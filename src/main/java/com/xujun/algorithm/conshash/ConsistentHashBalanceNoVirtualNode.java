package com.xujun.algorithm.conshash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一致性hash算法模拟
 * 
 * @author xujun
 * @date 2018.8.17 9:54
 */
public class ConsistentHashBalanceNoVirtualNode {

	private TreeMap<Long, String> realNodes = new TreeMap<Long, String>();

	private String[] nodes;

	public ConsistentHashBalanceNoVirtualNode(String[] nodes) {
		this.nodes = Arrays.copyOf(nodes, nodes.length);
		initalize();
	}

	/**
	 * 初始化哈希环，循环计算每个node名称的哈希值，并将其放入treemap
	 */
	private void initalize() {
		for (String nodeName : nodes) {
			realNodes.put(hash(nodeName, 0), nodeName);
		}
	}

	/**
	 * 根据资源key选择返回相应的节点名称
	 * @param key
	 * @return
	 */
	public String selectNode(String key) {
		Long hashOfKey = hash(key, 0);
		if (!realNodes.containsKey(hashOfKey)) {
			// ceilingEntry()的作用是得到比hashOfKey大的第一个Entry
			Map.Entry<Long, String> entry = realNodes.ceilingEntry(hashOfKey);
			if (entry != null) {
				return entry.getValue();
			} else {
				return nodes[0];
			}
		} else {
			return realNodes.get(hashOfKey);
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
		if (realNodes != null && !realNodes.isEmpty()) {
			realNodes.forEach((hashKey, node) -> {
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
		ConsistentHashBalanceNoVirtualNode consistentHashBalance = new ConsistentHashBalanceNoVirtualNode(nodes);
		consistentHashBalance.printTreeNode();
	}
}
