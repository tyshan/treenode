package com.odesk.treeapp;

import net.sf.json.JSONObject;

public class JsonUtils {

	public static String javaToJson(TreeNode node) {
		return JSONObject.fromObject(node).toString(4);
	}
}
