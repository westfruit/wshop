/*     */ package com.wshop.web.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_PRODUCT")
/*     */ public class ProductEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3264773012421841094L;
/*     */   @Id
/*     */   @Column(name="PRODUCTID", unique=true, nullable=false, length=10)
/*     */   private Integer productid;
/*     */   @Column(name="TITLE", nullable=true, length=300)
/*     */   private String title;
/*     */   @Column(name="SEARCHTITLE", nullable=true, length=300)
/*     */   private String searchtitle;
/*     */   @Column(name="SUMMERY", nullable=true, length=600)
/*     */   private String summery;
/*     */   @Column(name="CATEID", nullable=false, length=10)
/*     */   private Integer cateid;
/*     */   @Column(name="CATENAME", nullable=true, length=300)
/*     */   private String catename;
/*     */   @Column(name="BRANDNAME", nullable=true, length=300)
/*     */   private String brandname;
/*     */   @Column(name="PRODUCTIMG", nullable=true, length=300)
/*     */   private String productimg;
/*     */   @Column(name="PRODUCTALBUM", nullable=true, length=1200)
/*     */   private String productalbum;
/*     */   @Column(name="VERIFYSTATUS", nullable=true, length=10)
/*     */   private Integer verifystatus;
/*     */   @Column(name="SHELVESTATUS", nullable=true, length=10)
/*     */   private Integer shelvestatus;
/*     */   @Column(name="UPDATETIME", nullable=true)
/*     */   private Date updatetime;
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  87 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  96 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/* 105 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title)
/*     */   {
/* 114 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getSearchtitle()
/*     */   {
/* 123 */     return this.searchtitle;
/*     */   }
/*     */   
/*     */   public void setSearchtitle(String searchtitle)
/*     */   {
/* 132 */     this.searchtitle = searchtitle;
/*     */   }
/*     */   
/*     */   public String getSummery()
/*     */   {
/* 141 */     return this.summery;
/*     */   }
/*     */   
/*     */   public void setSummery(String summery)
/*     */   {
/* 150 */     this.summery = summery;
/*     */   }
/*     */   
/*     */   public Integer getCateid()
/*     */   {
/* 159 */     return this.cateid;
/*     */   }
/*     */   
/*     */   public void setCateid(Integer cateid)
/*     */   {
/* 168 */     this.cateid = cateid;
/*     */   }
/*     */   
/*     */   public String getCatename()
/*     */   {
/* 177 */     return this.catename;
/*     */   }
/*     */   
/*     */   public void setCatename(String catename)
/*     */   {
/* 186 */     this.catename = catename;
/*     */   }
/*     */   
/*     */   public String getBrandname()
/*     */   {
/* 195 */     return this.brandname;
/*     */   }
/*     */   
/*     */   public void setBrandname(String brandname)
/*     */   {
/* 204 */     this.brandname = brandname;
/*     */   }
/*     */   
/*     */   public String getProductimg()
/*     */   {
/* 213 */     return this.productimg;
/*     */   }
/*     */   
/*     */   public void setProductimg(String productimg)
/*     */   {
/* 222 */     this.productimg = productimg;
/*     */   }
/*     */   
/*     */   public String getProductalbum()
/*     */   {
/* 231 */     return this.productalbum;
/*     */   }
/*     */   
/*     */   public void setProductalbum(String productalbum)
/*     */   {
/* 240 */     this.productalbum = productalbum;
/*     */   }
/*     */   
/*     */   public Integer getVerifystatus()
/*     */   {
/* 249 */     return this.verifystatus;
/*     */   }
/*     */   
/*     */   public void setVerifystatus(Integer verifystatus)
/*     */   {
/* 258 */     this.verifystatus = verifystatus;
/*     */   }
/*     */   
/*     */   public Integer getShelvestatus()
/*     */   {
/* 267 */     return this.shelvestatus;
/*     */   }
/*     */   
/*     */   public void setShelvestatus(Integer shelvestatus)
/*     */   {
/* 276 */     this.shelvestatus = shelvestatus;
/*     */   }
/*     */   
/*     */   public Date getUpdatetime()
/*     */   {
/* 285 */     return this.updatetime;
/*     */   }
/*     */   
/*     */   public void setUpdatetime(Date updatetime)
/*     */   {
/* 294 */     this.updatetime = updatetime;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.entity.ProductEntity
 * JD-Core Version:    0.7.0.1
 */