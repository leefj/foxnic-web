package org.github.foxnic.web.misc.ztree;

import java.util.ArrayList;
import java.util.List;

public class ZTreeNode {

	public String getHierarchy() {
		return hierarchy;
	}

	public static interface Transformer<T> {
		ZTreeNode transform(T data,ZTreeNode node);
	}
	
	/**
	 * 节点转换
	 * */
	public static <T> List<ZTreeNode> toList(List<T> list, Transformer<T> transformer) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (T t : list) {
			ZTreeNode node=new ZTreeNode();
			transformer.transform(t, node);
			nodes.add(node);
		}
		return nodes;
	}
	
	
	private String id;
	private String parentId;
	private String icon;
	private String name;
	private Boolean isParent;
	private Boolean checked;
	private String url;



	private int depth;
	private String hierarchy;
	private List<String> namePathArray =new ArrayList<>();
	private String namePath;
	private List<ZTreeNode> children;


	public void addChild(ZTreeNode node) {
		if(children==null) children=new ArrayList<>();
		children.add(node);
	}

	public List<ZTreeNode> getChildren() {
		return children;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<String> getNamePathArray() {
		return namePathArray;
	}

	public void addNamePath(String namePath) {
		this.namePathArray.add(namePath);
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getNamePath() {
		return namePath;
	}

	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}
	
}
