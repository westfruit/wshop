/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class DynamicProductMapDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7739699869913472761L;
/*     */   @JsonProperty("Id")
/*     */   private Integer id;
/*     */   @JsonProperty("ProductId")
/*     */   private Integer productid;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   @JsonProperty("OptionId")
/*     */   private Integer optionid;
/*     */   @JsonProperty("OptionValue")
/*     */   private String optionvalue;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  76 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  85 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  94 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/* 103 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public Integer getOptionid()
/*     */   {
/* 112 */     return this.optionid;
/*     */   }
/*     */   
/*     */   public void setOptionid(Integer optionid)
/*     */   {
/* 121 */     this.optionid = optionid;
/*     */   }
/*     */   
/*     */   public String getOptionvalue()
/*     */   {
/* 130 */     return this.optionvalue;
/*     */   }
/*     */   
/*     */   public void setOptionvalue(String optionvalue)
/*     */   {
/* 139 */     this.optionvalue = optionvalue;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 148 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 157 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 161 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 165 */     this.attributename = attributename;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.DynamicProductMapDTO
 * JD-Core Version:    0.7.0.1
 */