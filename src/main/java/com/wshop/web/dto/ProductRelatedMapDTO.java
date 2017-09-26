/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class ProductRelatedMapDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3695228672487262500L;
/*     */   @JsonProperty("Id")
/*  28 */   private Integer id = Integer.valueOf(0);
/*     */   @JsonProperty("ProductId")
/*  32 */   private Integer productid = Integer.valueOf(0);
/*     */   @JsonProperty("ProductId2")
/*  36 */   private Integer productid2 = Integer.valueOf(0);
/*     */   @JsonProperty("Title")
/*  40 */   private String title = "";
/*     */   @JsonProperty("ProductImg")
/*  44 */   private String productimg = "";
/*     */   @JsonProperty("SellPrice")
/*  47 */   private BigDecimal sellprice = new BigDecimal(0);
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  56 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  65 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  74 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  83 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getProductid2()
/*     */   {
/*  92 */     return this.productid2;
/*     */   }
/*     */   
/*     */   public void setProductid2(Integer productid2)
/*     */   {
/* 101 */     this.productid2 = productid2;
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/* 111 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title)
/*     */   {
/* 120 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getProductimg()
/*     */   {
/* 129 */     return this.productimg;
/*     */   }
/*     */   
/*     */   public void setProductimg(String productimg)
/*     */   {
/* 138 */     this.productimg = productimg;
/*     */   }
/*     */   
/*     */   public BigDecimal getSellprice()
/*     */   {
/* 142 */     return this.sellprice;
/*     */   }
/*     */   
/*     */   public void setSellprice(BigDecimal sellprice)
/*     */   {
/* 146 */     this.sellprice = sellprice;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductRelatedMapDTO
 * JD-Core Version:    0.7.0.1
 */