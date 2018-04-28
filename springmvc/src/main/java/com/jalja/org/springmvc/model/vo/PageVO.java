package com.jalja.org.springmvc.model.vo;

public class PageVO<T> {
	private Integer pageNum;//��ǰҳ
	private Integer pageSize;//ÿҳ����
	private Integer totalPages;////һ������ҳ��
	private Long totalSize;//������
	private T datas;//����
	
	
	public PageVO(Integer pageNum, Integer pageSize, Long totalSize, T datas) {
		this(pageSize,totalSize);
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.datas = datas;
	}

	public PageVO(Integer pageSize, Long totalSize) {
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalPages=getTotalPages();
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalPages() {
		if(totalSize%pageSize==0) {
			totalPages=(int) (totalSize/pageSize);
		}else {
			totalPages=(int) ((totalSize/pageSize)+1);
		}
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}
}
