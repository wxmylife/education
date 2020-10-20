package com.wxmylife.education.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

public class CommonPage <T> {
  private Long pageNum;
  private Long pageSize;
  private Long totalPage;
  private Long total;
  private List<T> list;

  /**
   * 将PageHelper分页后的list转为分页信息
   */
  // public static <T> CommonPage<T> restPage(List<T> list) {
  //   CommonPage<T> result = new CommonPage<T>();
  //   Page<T> pageInfo = new Page<T>();
  //   result.setTotalPage(pageInfo.getPages());
  //   result.setPageNum(pageInfo.getPageNum());
  //   result.setPageSize(pageInfo.getPageSize());
  //   result.setTotal(pageInfo.getTotal());
  //   result.setList(pageInfo.getList());
  //   return result;
  // }

  /**
   * 将SpringData分页后的list转为分页信息
   */
  public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
    CommonPage<T> result = new CommonPage<T>();
    result.setTotalPage(pageInfo.getPages());
    result.setPageNum(pageInfo.getCurrent());
    result.setPageSize(pageInfo.getSize());
    result.setTotal(pageInfo.getTotal());
    result.setList(pageInfo.getRecords());
    return result;
  }

  public Long getPageNum() {
    return pageNum;
  }

  public void setPageNum(Long pageNum) {
    this.pageNum = pageNum;
  }

  public Long getPageSize() {
    return pageSize;
  }

  public void setPageSize(Long pageSize) {
    this.pageSize = pageSize;
  }

  public Long getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Long totalPage) {
    this.totalPage = totalPage;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }
}