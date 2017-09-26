/*     */ package com.wshop.web.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_PRODUCT_SKU")
/*     */ public class ProductSkuEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5828930272091300869L;
/*     */   @Id
/*     */   @Column(name="SKUID", unique=true, nullable=false, length=10)
/*     */   private Integer skuid;
/*     */   @Column(name="PRODUCTID", nullable=true, length=10)
/*     */   private Integer productid;
/*     */   @Column(name="STOCKQUANTITY", nullable=true, length=10)
/*     */   private Integer stockquantity;
/*     */   @Column(name="COMMODITYCODE", nullable=true, length=100)
/*     */   private String commoditycode;
/*     */   @Column(name="SKUPRICE", nullable=true)
/*     */   private BigDecimal skuprice;
/*     */   @Column(name="SKUIMG1", nullable=true, length=500)
/*     */   private String skuimg1;
/*     */   @Column(name="SKUIMG2", nullable=true, length=1200)
/*     */   private String skuimg2;
/*     */   @Column(name="ATTRIBUTES", nullable=true, length=1500)
/*     */   private String attributes;
/*     */   
/*     */   public Integer getSkuid()
/*     */   {
/*  71 */     return this.skuid;
/*     */   }
/*     */   
/*     */   public void setSkuid(Integer skuid)
/*     */   {
/*  80 */     this.skuid = skuid;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  89 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  98 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getStockquantity()
/*     */   {
/* 107 */     return this.stockquantity;
/*     */   }
/*     */   
/*     */   public void setStockquantity(Integer stockquantity)
/*     */   {
/* 116 */     this.stockquantity = stockquantity;
/*     */   }
/*     */   
/*     */   public String getCommoditycode()
/*     */   {
/* 125 */     return this.commoditycode;
/*     */   }
/*     */   
/*     */   public void setCommoditycode(String commoditycode)
/*     */   {
/* 134 */     this.commoditycode = commoditycode;
/*     */   }
/*     */   
/*     */   public BigDecimal getSkuprice()
/*     */   {
/* 143 */     return this.skuprice;
/*     */   }
/*     */   
/*     */   public void setSkuprice(BigDecimal skuprice)
/*     */   {
/* 152 */     this.skuprice = skuprice;
/*     */   }
/*     */   
/*     */   public String getSkuimg1()
/*     */   {
/* 161 */     return this.skuimg1;
/*     */   }
/*     */   
/*     */   public void setSkuimg1(String skuimg1)
/*     */   {
/* 170 */     this.skuimg1 = skuimg1;
/*     */   }
/*     */   
/*     */   public String getSkuimg2()
/*     */   {
/* 179 */     return this.skuimg2;
/*     */   }
/*     */   
/*     */   public void setSkuimg2(String skuimg2)
/*     */   {
/* 188 */     this.skuimg2 = skuimg2;
/*     */   }
/*     */   
/*     */   public String getAttributes()
/*     */   {
/* 197 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public void setAttributes(String attributes)
/*     */   {
/* 206 */     this.attributes = attributes;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.entity.ProductSkuEntity
 * JD-Core Version:    0.7.0.1
 */