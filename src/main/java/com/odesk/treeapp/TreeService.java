package com.odesk.treeapp;

import java.util.List;

public class TreeService {

	public List<TreeNode> getROOTTree() {

		return null;
	}

	public TreeNode getNode(Integer id) {
		TreeNode node = TreeDAO.getTreeNode(id);
		recursiveTree(node);
		return node;
	}

	private TreeNode recursiveTree(TreeNode node) {
		List<TreeNode> children = TreeDAO.getChildrenNodes(node.getId());
		for (TreeNode child : children) {
			TreeNode n=recursiveTree(child);
			node.getChildren().add(n);
		}
		return node;
	}

}
