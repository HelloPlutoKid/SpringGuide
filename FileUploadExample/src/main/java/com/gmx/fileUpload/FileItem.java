package com.gmx.fileUpload;

public class FileItem {
	private int index;
	private String fName;
	private String fSize;
	
	public FileItem(int index, String fName, String fSize) {
		super();
		this.index = index;
		this.fName = fName;
		this.fSize = fSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfSize() {
		return fSize;
	}

	public void setfSize(String fSize) {
		this.fSize = fSize;
	}
	
	
}
