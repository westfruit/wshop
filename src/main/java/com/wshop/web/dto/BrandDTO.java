/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class BrandDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4324840998053251007L;
/*     */   @JsonProperty("BrandId")
/*     */   private Integer brandid;
/*     */   @JsonProperty("BrandName")
/*     */   private String brandname;
/*     */   @JsonProperty("PinyinName")
/*     */   private String pinyinname;
/*     */   @JsonProperty("BrandLogo")
/*     */   private String brandlogo;
/*     */   @JsonProperty("IsShow")
/*     */   private Integer isshow;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   
/*     */   public Integer getBrandid()
/*     */   {
/*  55 */     return this.brandid;
/*     */   }
/*     */   
/*     */   public void setBrandid(Integer brandid)
/*     */   {
/*  64 */     this.brandid = brandid;
/*     */   }
/*     */   
/*     */   public String getBrandname()
/*     */   {
/*  73 */     return this.brandname;
/*     */   }
/*     */   
/*     */   public void setBrandname(String brandname)
/*     */   {
/*  82 */     this.brandname = brandname;
/*     */   }
/*     */   
/*     */   public String getPinyinname()
/*     */   {
/*  91 */     return this.pinyinname;
/*     */   }
/*     */   
/*     */   public void setPinyinname(String pinyinname)
/*     */   {
/* 100 */     this.pinyinname = pinyinname;
/*     */   }
/*     */   
/*     */   public String getBrandlogo()
/*     */   {
/* 109 */     return this.brandlogo;
/*     */   }
/*     */   
/*     */   public void setBrandlogo(String brandlogo)
/*     */   {
/* 118 */     this.brandlogo = brandlogo;
/*     */   }
/*     */   
/*     */   public Integer getIsshow()
/*     */   {
/* 127 */     return this.isshow;
/*     */   }
/*     */   
/*     */   public void setIsshow(Integer isshow)
/*     */   {
/* 136 */     this.isshow = isshow;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 145 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 154 */     this.sortid = sortid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.BrandDTO
 * JD-Core Version:    0.7.0.1
 */