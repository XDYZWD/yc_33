package com.yc.web.model;

import java.io.Serializable;
import java.util.List;

public class JsonModel<T> implements Serializable  {

	/**
	 * 他是在web层  在servlet与前端的HTML、JSP页面间传输json数据用的
	 */
	private static final long serialVersionUID = -2519518733795311561L;
	
	
	private Integer code;//操作状态编码:1.表示成功  2.失败
	private String errorMsg;//信息
	private Object obj;//对象
	private String url;//下一个要去的页面
	
	//easyui datagrid
	private Integer total; // 总的记录数
	private Integer pages;  //*当前为第几页
	private Integer pageSize; //每页xx条
	private List<T> rows; //记录
	
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", errorMsg=" + errorMsg + ", obj=" + obj + ", url=" + url + ", total="
				+ total + ", pages=" + pages + ", pageSize=" + pageSize + ", rows=" + rows + "]";
	}
}
