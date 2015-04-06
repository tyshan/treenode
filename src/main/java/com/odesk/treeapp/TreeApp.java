package com.odesk.treeapp;

public class TreeApp {

	public static void main(String[] args) {

		TreeService service = new TreeService();

		// generate treenode 1
		TreeNode node1 = service.getNode(1);
		System.out.println(JsonUtils.javaToJson(node1));

		// generate treenode 2
		TreeNode node2 = service.getNode(2);
		System.out.println(JsonUtils.javaToJson(node2));

		// generate treenode
		TreeNode node4 = service.getNode(4);
		System.out.println(JsonUtils.javaToJson(node4));
	}

}
