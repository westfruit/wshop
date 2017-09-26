/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProductAttributeDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7116036424362261892L;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   @JsonProperty("ProductId")
/*     */   private Integer productid;
/*     */   @JsonProperty("AttributeValue")
/*  41 */   private List<ProductAttributeValueDTO> valueList = new ArrayList() {};
/*     */   
/*     */   public List<ProductAttributeValueDTO> getValueList()
/*     */   {
/*  50 */     return this.valueList;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  60 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/*  69 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/*  78 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/*  87 */     this.attributename = attributename;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  97 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/* 106 */     this.productid = productid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductAttributeDTO
 * JD-Core Version:    0.7.0.1
 */