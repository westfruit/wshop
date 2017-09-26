/*     */ package com.wshop.web.util.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Page<T>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5764853545343945831L;
/*     */   public static final int DEFAULT_PAGE_SIZE = 20;
/*     */   public static final int MAX_PAGE_SIZE = 1000;
/*     */   private List<T> list;
/*     */   private int totalCount;
/*     */   private int totalPage;
/*     */   private int pageCurrent;
/*     */   private int pageSize;
/*     */   private String orderField;
/*     */   private String orderDirection;
/*     */   
/*     */   public Page() {}
/*     */   
/*     */   public Page(int totalCount, int totalPage, int pageCurrent, int pageSize, List<T> list)
/*     */   {
/*  75 */     this.totalCount = totalCount;
/*  76 */     this.totalPage = totalPage;
/*  77 */     this.pageCurrent = pageCurrent;
/*  78 */     this.pageSize = pageSize;
/*  79 */     this.list = list;
/*     */   }
/*     */   
/*     */   public List<T> getList()
/*     */   {
/*  83 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<T> list)
/*     */   {
/*  87 */     this.list = list;
/*     */   }
/*     */   
/*     */   public int getTotalCount()
/*     */   {
/*  91 */     return this.totalCount;
/*     */   }
/*     */   
/*     */   public void setTotalCount(int totalCount)
/*     */   {
/*  95 */     this.totalCount = totalCount;
/*     */   }
/*     */   
/*     */   public int getTotalPage()
/*     */   {
/*  99 */     return this.totalPage;
/*     */   }
/*     */   
/*     */   public void setTotalPage(int totalPage)
/*     */   {
/* 103 */     this.totalPage = totalPage;
/*     */   }
/*     */   
/*     */   public int getPageCurrent()
/*     */   {
/* 107 */     return this.pageCurrent;
/*     */   }
/*     */   
/*     */   public void setPageCurrent(int pageCurrent)
/*     */   {
/* 111 */     this.pageCurrent = pageCurrent;
/*     */   }
/*     */   
/*     */   public int getPageSize()
/*     */   {
/* 115 */     return this.pageSize;
/*     */   }
/*     */   
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 119 */     this.pageSize = pageSize;
/*     */   }
/*     */   
/*     */   public String getOrderField()
/*     */   {
/* 123 */     return this.orderField;
/*     */   }
/*     */   
/*     */   public void setOrderField(String orderField)
/*     */   {
/* 127 */     this.orderField = orderField;
/*     */   }
/*     */   
/*     */   public String getOrderDirection()
/*     */   {
/* 131 */     return this.orderDirection;
/*     */   }
/*     */   
/*     */   public void setOrderDirection(String orderDirection)
/*     */   {
/* 135 */     this.orderDirection = orderDirection;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.util.base.Page
 * JD-Core Version:    0.7.0.1
 */