/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class CategoryDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7587193580437271613L;
/*     */   @JsonProperty("CategoryId")
/*     */   private Integer categoryid;
/*     */   @JsonProperty("CategoryName")
/*     */   private String categoryname;
/*     */   @JsonProperty("CategoryImg")
/*     */   private String categoryimg;
/*     */   @JsonProperty("ParentId")
/*     */   private Integer parentid;
/*     */   @JsonProperty("IsShow")
/*     */   private Integer isshow;
/*     */   @JsonProperty("CategoryPath")
/*     */   private String categorypath;
/*     */   @JsonProperty("CategoryArray")
/*     */   private String categoryarray;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   
/*     */   public Integer getCategoryid()
/*     */   {
/*  63 */     return this.categoryid;
/*     */   }
/*     */   
/*     */   public void setCategoryid(Integer categoryid)
/*     */   {
/*  72 */     this.categoryid = categoryid;
/*     */   }
/*     */   
/*     */   public String getCategoryname()
/*     */   {
/*  81 */     return this.categoryname;
/*     */   }
/*     */   
/*     */   public void setCategoryname(String categoryname)
/*     */   {
/*  90 */     this.categoryname = categoryname;
/*     */   }
/*     */   
/*     */   public String getCategoryimg()
/*     */   {
/*  99 */     return this.categoryimg;
/*     */   }
/*     */   
/*     */   public void setCategoryimg(String categoryimg)
/*     */   {
/* 108 */     this.categoryimg = categoryimg;
/*     */   }
/*     */   
/*     */   public Integer getParentid()
/*     */   {
/* 117 */     return this.parentid;
/*     */   }
/*     */   
/*     */   public void setParentid(Integer parentid)
/*     */   {
/* 126 */     this.parentid = parentid;
/*     */   }
/*     */   
/*     */   public Integer getIsshow()
/*     */   {
/* 135 */     return this.isshow;
/*     */   }
/*     */   
/*     */   public void setIsshow(Integer isshow)
/*     */   {
/* 144 */     this.isshow = isshow;
/*     */   }
/*     */   
/*     */   public String getCategorypath()
/*     */   {
/* 153 */     return this.categorypath;
/*     */   }
/*     */   
/*     */   public void setCategorypath(String categorypath)
/*     */   {
/* 162 */     this.categorypath = categorypath;
/*     */   }
/*     */   
/*     */   public String getCategoryarray()
/*     */   {
/* 171 */     return this.categoryarray;
/*     */   }
/*     */   
/*     */   public void setCategoryarray(String categoryarray)
/*     */   {
/* 180 */     this.categoryarray = categoryarray;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 189 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 198 */     this.sortid = sortid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.CategoryDTO
 * JD-Core Version:    0.7.0.1
 */