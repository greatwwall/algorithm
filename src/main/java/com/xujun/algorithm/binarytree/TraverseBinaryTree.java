package com.xujun.algorithm.binarytree;

import java.security.SecureRandom;

/**
 * 二叉树的遍历
 * 
 * @author xujun
 * @date 2018.08.17 10:32
 */
/**
 * @author Administrator
 *
 */
public class TraverseBinaryTree {

	private static final SecureRandom random = new SecureRandom();

	/**
	 * 节点类 
	 */
	public static class TreeNode {
		int val;
		String name;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val, String name) {
			this.val = val;
			this.name = name;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", name=" + name + "]";
		}
	}

	/**
	 * 初始化创建节点
	 * @param node
	 * @param deep
	 */
	public static TreeNode createTree(TreeNode node, int deep) {
		if (deep > 1) {
			deep--;
			int left = random.nextInt(1000000);
			int right = random.nextInt(1000000);
			node.left = createTree(new TreeNode(left, "left_" + left), deep);
			node.right = createTree(new TreeNode(right, "right_" + right), deep);
		}
		return node;
	}

	/**
	 * 前序遍历
	 */
	public static void preorderTraversal(TreeNode node) {
		if (node == null)
			return;
		System.out.println(node);
		if (node.left != null)
			preorderTraversal(node.left);
		if (node.right != null)
			preorderTraversal(node.right);
	}

	/**
	 * 中序遍历
	 * @param node
	 */
	public static void middleTraversal(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			middleTraversal(node.left);
		System.out.println(node);
		if (node.right != null)
			middleTraversal(node.right);
	}

	/**
	 * 后序遍历
	 * @param node
	 */
	public static void postOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null) {
			middleTraversal(node.left);
		}
		if (node.right != null)
			middleTraversal(node.right);
		System.out.println(node);
	}

	public static void main(String[] args) {
		TreeNode node = createTree(new TreeNode(1, "root"), 4);
		node.left = new TreeNode(2, "left");
		node.right = new TreeNode(3, "right");
		TraverseBinaryTree.preorderTraversal(node);
		System.out.println("===========================");
		TraverseBinaryTree.middleTraversal(node);
		System.out.println("===========================");
		TraverseBinaryTree.postOrderTraversal(node);
	}
}
