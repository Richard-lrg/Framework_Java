package com.cactus.scheduledemo.core.bean;

import java.util.List;

/**
 * Created by liruigao on 2019-07-23.
 */
public class PageBean<T> {
    /**
     * 默认页码
     */
    public static final int PAGE_NO = 1;

    /**
     * 默认分页大小
     */
    public static final int PAGE_SIZE = 10;

    private Integer pageNo = PAGE_NO;
    private Integer pageSize = PAGE_SIZE;
    private Long total = 0L; // 记录总数
    private Integer totalPage = 1; // 页面总数，计算得出，不提供setter方法
    private List<T> data;
    private String cursor;

    /**
     * 扩展字段，用于标记
     */
    private Integer flag = 0;

    public PageBean() {
    }

    public PageBean(Integer pageNo, Integer pageSize) {
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
        }
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public PageBean(Integer pageNo, Integer pageSize, Long total) {
        this(pageNo, pageSize);
        this.setTotal(total);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        if (total == null || total.compareTo(0L) < 0) {
            return;
        }
        this.total = total;
        this.totalPage = (int) ((this.total + this.pageSize - 1) / this.pageSize);
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

}
