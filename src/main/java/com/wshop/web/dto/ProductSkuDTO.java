/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public class ProductSkuDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5828930272091300869L;
/*     */   @JsonProperty("SkuId")
/*     */   private Integer skuid;
/*     */   @JsonProperty("ProductId")
/*     */   private Integer productid;
/*     */   @JsonProperty("StockQuantity")
/*     */   private Integer stockquantity;
/*     */   @JsonProperty("CommodityCode")
/*     */   private String commoditycode;
/*     */   @JsonProperty("SkuPrice")
/*     */   private BigDecimal skuprice;
/*     */   @JsonProperty("SkuImg1")
/*     */   private String skuimg1;
/*     */   @JsonProperty("SkuImg2")
/*     */   private String skuimg2;
/*     */   @JsonProperty("ImgList")
/*     */   private Collection<String> imglist;
/*     */   @JsonProperty("Attributes")
/*     */   private String attributes;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   
/*     */   public ProductSkuDTO()
/*     */   {
/*  59 */     this.imglist = new ArrayList();
/*     */   }
/*     */   
/*     */   @JsonProperty("IsDelete")
/*  72 */   private Integer isdelete = Integer.valueOf(0);
/*     */   
/*     */   public Collection<String> getImglist()
/*     */   {
/*  84 */     if ((null != this.skuimg2) && (this.skuimg2.length() > 0)) {
/*  85 */       return Arrays.asList(this.skuimg2.trim().split(","));
/*     */     }
/*  87 */     return this.imglist;
/*     */   }
/*     */   
/*     */   public void setImglist(Collection<String> imglist)
/*     */   {
/*  96 */     this.imglist = imglist;
/*     */   }
/*     */   
/*     */   public Integer getIsdelete()
/*     */   {
/* 105 */     return this.isdelete;
/*     */   }
/*     */   
/*     */   public void setIsdelete(Integer isdelete)
/*     */   {
/* 114 */     this.isdelete = isdelete;
/*     */   }
/*     */   
/*     */   public Integer getSkuid()
/*     */   {
/* 123 */     return this.skuid;
/*     */   }
/*     */   
/*     */   public void setSkuid(Integer skuid)
/*     */   {
/* 132 */     this.skuid = skuid;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/* 141 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/* 150 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getStockquantity()
/*     */   {
/* 159 */     return this.stockquantity;
/*     */   }
/*     */   
/*     */   public void setStockquantity(Integer stockquantity)
/*     */   {
/* 168 */     this.stockquantity = stockquantity;
/*     */   }
/*     */   
/*     */   public String getCommoditycode()
/*     */   {
/* 177 */     return this.commoditycode;
/*     */   }
/*     */   
/*     */   public void setCommoditycode(String commoditycode)
/*     */   {
/* 186 */     this.commoditycode = commoditycode;
/*     */   }
/*     */   
/*     */   public BigDecimal getSkuprice()
/*     */   {
/* 195 */     return this.skuprice;
/*     */   }
/*     */   
/*     */   public void setSkuprice(BigDecimal skuprice)
/*     */   {
/* 204 */     this.skuprice = skuprice;
/*     */   }
/*     */   
/*     */   public String getSkuimg1()
/*     */   {
/* 213 */     return this.skuimg1;
/*     */   }
/*     */   
/*     */   public void setSkuimg1(String skuimg1)
/*     */   {
/* 222 */     this.skuimg1 = skuimg1;
/*     */   }
/*     */   
/*     */   public String getSkuimg2()
/*     */   {
/* 231 */     return this.skuimg2;
/*     */   }
/*     */   
/*     */   public void setSkuimg2(String skuimg2)
/*     */   {
/* 240 */     this.skuimg2 = skuimg2;
/*     */   }
/*     */   
/*     */   public String getAttributes()
/*     */   {
/* 249 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public void setAttributes(String attributes)
/*     */   {
/* 258 */     this.attributes = attributes;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 267 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 276 */     this.attributename = attributename;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductSkuDTO
 * JD-Core Version:    0.7.0.1
 */