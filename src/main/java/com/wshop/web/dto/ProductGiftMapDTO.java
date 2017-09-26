/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class ProductGiftMapDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4790626152690500183L;
/*     */   @JsonProperty("Id")
/*     */   private Integer id;
/*     */   @JsonProperty("ProductId")
/*     */   private Integer productid;
/*     */   @JsonProperty("ProductId2")
/*     */   private Integer productid2;
/*     */   @JsonProperty("Title")
/*     */   private String title;
/*     */   @JsonProperty("ProductImg")
/*     */   private String productimg;
/*     */   @JsonProperty("SellPrice")
/*  48 */   private BigDecimal sellprice = new BigDecimal(0);
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  75 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  84 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getProductid2()
/*     */   {
/*  93 */     return this.productid2;
/*     */   }
/*     */   
/*     */   public void setProductid2(Integer productid2)
/*     */   {
/* 102 */     this.productid2 = productid2;
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
 * Qualified Name:     com.wshop.web.dto.ProductGiftMapDTO
 * JD-Core Version:    0.7.0.1
 */