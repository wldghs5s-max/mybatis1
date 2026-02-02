package com.kh.app;

public class SearchVo {
	
	private String searchType;
	private String searchText;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public SearchVo(String searchType, String searchText) {
		super();
		this.searchType = searchType;
		this.searchText = searchText;
	}
	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SearchVo [searchType=" + searchType + ", searchText=" + searchText + "]";
	}

}
