package cn.kong.web.utils;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class FileInfo implements Serializable {

	
	private static final long serialVersionUID = 1L;
		
	private String type;
	
	private String name;
	
	private String path;
	
	private List<FileInfo> children;
	
	private boolean hasChildren;
	
	private String uuid;
	
	public FileInfo() {}
	
	public FileInfo(String type, String name, String path, List<FileInfo> children) {
		this.type = type;
		this.name = name;
		this.path = path;
		this.children = children;
		this.hasChildren = children != null && !children.isEmpty();
		this.uuid = UUID.randomUUID().toString();
	}
	
	public FileInfo(String type, String name, String path, List<FileInfo> children, String rootPath) {
		this(type, name, path, children);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("rootpath: " + rootPath);
		System.out.println(("path: " + path));
		if(!"".equals(rootPath)) {
			//windows \替换为/后处理
			path = path.replace("\\", "/");
			System.out.println("path(/): " + path);
			path = path.replaceFirst(rootPath, "");
			System.out.println("path(/): " + path);
			if(!path.startsWith("/")) path = "/" + path;
			this.path = path;
			System.out.println("path(/): " + path);
		}
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<FileInfo> getChildren() {
		return children;
	}

	public void setChildren(List<FileInfo> children) {
		this.children = children;
	}

	public boolean getHasChildren() {
		return hasChildren;
	}
	
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "FileInfo [type=" + type + ", name=" + name + ", path=" + path + ", children=" + children
				 + ", hasChildren=" + hasChildren + ", uuid=" + uuid + "]";
	}

	
	
	
	
	
}
