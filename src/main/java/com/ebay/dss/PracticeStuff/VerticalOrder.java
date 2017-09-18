package com.ebay.dss.PracticeStuff;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrder {
	public static TreeMap<Integer, ArrayList> ht = new TreeMap<Integer, ArrayList>();;
	public static int level;
	public ArrayList<Integer> al;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TreeNode vertical(TreeNode root, int level) {
		if (root == null) {
			return null;
		}
		TreeNode y = vertical(root.left, --level);
		if (y == null) {
			level++;
		}
		if (ht.get(level) != null) {
			ArrayList x = ht.get(level);
			x.add(root.data);
			ht.put(level, x);
		} else {
			al = new ArrayList<Integer>();
			al.add(root.data);
			ht.put(level, al);
		}
		return vertical(root.right, ++level);
	}

	public void printResult(TreeMap ht) {
		Set<Integer> i = ht.keySet();
		for (int keys : i) {
			System.out.println(ht.get(keys));
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		VerticalOrder p = new VerticalOrder();
		p.vertical(root, 0);
		p.printResult(ht);

	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
