package com.sunshine.framework.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/***
 * ��ҳ��װ��
 * @author ralphone.zhuo
 *
 */
public class PageEntity implements Serializable {

	private static final long serialVersionUID = -3321814010636693361L;

	private int page = 1;               //  ��ǰҳ
	
	private int sizePage = 20;          //  ÿҳ��¼��, Ϊ0��ʾ����ҳ
	
	private int rowCount = 0;           //  SQL��ѯ�������

	private int totalPage = 0;          //  ��ҳ��
	
	private List<String> listNumber = new ArrayList<String>();
	
	
	private int startPage;
	
	private int endPage;
	
	private String pageArray;
	
	public void initPageArray() {
		if (this.page <= 5) {
	       this.startPage = 1;
	       this.endPage = this.startPage + 9;
	       if(this.endPage > this.totalPage)
	    	   this.endPage = this.totalPage;
	    } else {
	       this.startPage = this.page - 5;
		   this.endPage = this.page + 4;
		   if(this.endPage > this.totalPage)
		       this.endPage = this.totalPage;
	    }
		
		pageArray = "";
		for (int i = startPage; i <= this.endPage; i ++) {
			if (pageArray.equals("")) {
				if (page == i) {
					pageArray = "" + i;
				} else {
					pageArray = "<a href='###' onclick='gotopage("+i+"); return false;'>" + i +"</a>";
				}
			} else {
				if (page == i) {
					pageArray = pageArray + "&nbsp;&nbsp;" + i;
				} else {
					pageArray = pageArray + "&nbsp;&nbsp;<a href='###' onclick='gotopage("+i+"); return false;'>" + i +"</a>";
				}
			}
		}
	}

	public String getPageArray() {
		return pageArray;
	}

	public void setPageArray(String pageArray) {
		this.pageArray = pageArray;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getSizePage() {
		return sizePage;
	}

	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setListNumber(List<String> listNumber) {
		this.listNumber = listNumber;
	}
	
	public List getListNumber() {
		listNumber.add("0:����");
		listNumber.add("10:10");
		listNumber.add("20:20");
		listNumber.add("40:40");
		listNumber.add("60:60");
		listNumber.add("80:80");
		listNumber.add("100:100");
		listNumber.add("200:200");
		listNumber.add("300:300");
		return listNumber;
	}
	

	/**
	 * �����һҳ
	 * 
	 * @return int
	 */
	public int getBackPage() {
		return (this.page + 1) > getTotalPage() ? getTotalPage()
				: this.page + 1;
	}

	/**
	 * �����һҳ
	 * 
	 * @return int
	 */
	public int getPreviousPage() {
		return (this.page - 1) < 1 ? 1 : this.page - 1;
	}

	/**
	 * ������ҳ��
	 * 
	 * @return int
	 */
	public int getTotalPage() {
		return (int) Math.ceil((double) rowCount / sizePage);
	}
	
	
}
