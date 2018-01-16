package com.nyh.app.model;

public class ColumnModel {
	
	private String columnName = "";
	private String humpColumnName = "";
	private String comment = "";
	private String colType = "";
	private String colDbType = "";
	private boolean isPK = false;
	private long length = 0;
	private int precision = 0;
	private int scale = 0;
	private int autoGen = 0;
	private boolean isNotNull = false;
	private String displayDbType="";
	
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getHumpColumnName() {
		return humpColumnName;
	}
	public void setHumpColumnName(String humpColumnName) {
		this.humpColumnName = humpColumnName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getColDbType() {
		return colDbType;
	}
	public void setColDbType(String colDbType) {
		this.colDbType = colDbType;
	}
	public boolean getIsPK() {
		return isPK;
	}
	public void setIsPK(boolean isPK) {
		this.isPK = isPK;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public int getAutoGen() {
		return autoGen;
	}
	public void setAutoGen(int autoGen) {
		this.autoGen = autoGen;
	}
	public boolean getIsNotNull() {
		return isNotNull;
	}
	public void setIsNotNull(boolean isNotNull) {
		this.isNotNull = isNotNull;
	}
	public String getDisplayDbType() {
		return displayDbType;
	}
	public void setDisplayDbType(String displayDbType) {
		this.displayDbType = displayDbType;
	}

	
	@Override
	public String toString() {
		return "ColumnModel [columnName=" + columnName + ", comment=" + comment + ", colType=" + colType + ", colDbType=" + colDbType + ", isPK=" + isPK
				+ ", length=" + length + ", precision=" + precision + ", scale=" + scale + ", autoGen=" + autoGen + ", isNotNull=" + isNotNull
				+ ", displayDbType=" + displayDbType + "]";
	}
}
