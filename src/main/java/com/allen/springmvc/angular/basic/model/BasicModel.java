package com.allen.springmvc.angular.basic.model;

import java.io.Serializable;

public class BasicModel implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 修改人
	 */
	private String updator;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 更新时间
	 */
	private long updateAt;
	/**
	 * 提交时间
	 */
	private long commitAt;
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public long getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(long updateAt) {
		this.updateAt = updateAt;
	}
	public long getCommitAt() {
		return commitAt;
	}
	public void setCommitAt(long commitAt) {
		this.commitAt = commitAt;
	}
	
	
	
}
