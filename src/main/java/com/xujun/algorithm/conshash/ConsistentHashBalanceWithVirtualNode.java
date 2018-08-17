package com.xujun.algorithm.conshash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一致性hash算法模拟有虚拟节点
 *  每个真实节点应该拆分成多少个虚拟节点？
 *  真实节点越少，所需阐发的虚拟节点越多，比如有10个真实节点，
 *  每个节点所需拆分的虚拟节点个数可能是100~200个，才能达到真正的负载均衡。
 * 
 * @author xujun
 * @date 2018.8.17 10:16
 */
public class ConsistentHashBalanceWithVirtualNode {

	private TreeMap<Long, String> virtualNodes = new TreeMap<Long, String>();

	private String[] nodes;

	// 每个真实节点对应的虚拟节点数
	private final int replicationCount;

	public ConsistentHashBalanceWithVirtualNode(String[] nodes, int replicationCount) {
		this.replicationCount = replicationCount;
		this.nodes = Arrays.copyOf(nodes, nodes.length);
		initalize();
	}

	/**
	 * 初始化哈希环，循环计算每个node名称的哈希值，并将其放入treemap
	 * 并为每个真实节点创建相应的虚拟节点
	 */
	private void initalize() {
		for (String nodeName : nodes) {
			for (int i = 0; i < replicationCount / 4; i++) {
				String virtualNodeName = getNodeNameByIndex(nodeName, i);
				for (int j = 0; j < 4; j++) {
					virtualNodes.put(hash(virtualNodeName, j), nodeName);
				}
			}
		}
	}

	/**
	 * 根据真实节点名称给每个虚拟节点命名
	 * @param nodeName
	 * @param i
	 * @return
	 */
	private String getNodeNameByIndex(String nodeName, int i) {
		return new StringBuffer(nodeName).append("&&").append(i).toString();
	}

	/**
	 * 根据资源key选择返回相应的节点名称
	 * @param key
	 * @return
	 */
	public String selectNode(String key) {
		Long hashOfKey = hash(key, 0);
		if (!virtualNodes.containsKey(hashOfKey)) {
			// ceilingEntry()的作用是得到比hashOfKey大的第一个Entry
			Map.Entry<Long, String> entry = virtualNodes.ceilingEntry(hashOfKey);
			if (entry != null) {
				return entry.getValue();
			} else {
				return nodes[0];
			}
		} else {
			return virtualNodes.get(hashOfKey);
		}
	}

	/**
	 * @param nodeName
	 * @param i
	 * @return
	 */
	private Long hash(String nodeName, int number) {
		byte[] digest = md5(nodeName);
		return (((long) (digest[3 + number * 4] & 0xFF) << 24) | ((long) (digest[2 + number * 4] & 0xFF) << 16)
				| ((long) (digest[1 + number * 4] & 0xFF) << 8) | (digest[number * 4] & 0xFF)) & 0xFFFFFFFFL;
	}

	/**
	 * md5加密
	 * @param nodeName
	 * @return
	 */
	private byte[] md5(String nodeName) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(nodeName.getBytes("UTF-8"));
			return md.digest();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void printTreeNode() {
		if (virtualNodes != null && !virtualNodes.isEmpty()) {
			virtualNodes.forEach((hashKey, node) -> {
				System.out.println(new StringBuffer(node).append(" ==> ").append(hashKey));
			});
		} else {
			System.out.println("Cycle is empty.");
		}
	}

	public static void main(String[] args) {
		String[] nodes = new String[10];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = "192.168.2." + i + ":8080";
		}
		ConsistentHashBalanceWithVirtualNode consistentHashBalance = new ConsistentHashBalanceWithVirtualNode(nodes, 16);
		consistentHashBalance.printTreeNode();
	}
}
