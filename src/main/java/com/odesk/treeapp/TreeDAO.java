package com.odesk.treeapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreeDAO {

	/**
	 * retrieve a treenode by ID with children nodes
	 * 
	 * @param treenode
	 *            id
	 * @return treenode with children treenodes
	 */

	public static TreeNode getTreeNode(int id) {
		final String sql = "select id,name,description,parentid from treenode where id=?";
		Connection connection = ConnectionUtil.getConnection();
		TreeNode node = null;
		PreparedStatement pstmt=null;
		ResultSet rtst=null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rtst = pstmt.executeQuery();
			if (rtst.next()) {
				node = new TreeNode();
				node.setId(rtst.getInt(1));
				node.setName(rtst.getString(2));
				node.setDescription(rtst.getString(3));
				node.setParentid(rtst.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rtst!=null){
				try {
					rtst.close();
				} catch (SQLException e) {
					
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
				
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return node;
	}

	/**
	 * retrieve all children treenodes by parent ID
	 * 
	 * @param parentid
	 *            , parent treenode id
	 * @return children treenodes
	 */

	public static List<TreeNode> getChildrenNodes(int parentid) {
		final String sql = "select id,name,description,parentid from treenode where parentid=?";
		Connection connection = ConnectionUtil.getConnection();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, parentid);
			ResultSet rtst = pstmt.executeQuery();
			TreeNode node = null;
			while (rtst.next()) {
				node = new TreeNode();
				node.setId(rtst.getInt(1));
				node.setName(rtst.getString(2));
				node.setDescription(rtst.getString(3));
				node.setParentid(rtst.getInt(4));
				nodes.add(node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodes;
	}

}
