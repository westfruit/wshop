/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class DynamicCateMapDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7948483846679043050L;
/*     */   @JsonProperty("Id")
/*     */   private Integer id;
/*     */   @JsonProperty("CategoryId")
/*     */   private Integer categoryid;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  56 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getCategoryid()
/*     */   {
/*  65 */     return this.categoryid;
/*     */   }
/*     */   
/*     */   public void setCategoryid(Integer categoryid)
/*     */   {
/*  74 */     this.categoryid = categoryid;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  83 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/*  92 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 101 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 110 */     this.sortid = sortid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.DynamicCateMapDTO
 * JD-Core Version:    0.7.0.1
 */