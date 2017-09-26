/*     */ package com.wshop.web.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_PRODUCT_ATTRIBUTE_MAP")
/*     */ public class ProductAttributeMapEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7779387032312334716L;
/*     */   @Id
/*     */   @Column(name="ID", unique=true, nullable=false, length=10)
/*     */   private Integer id;
/*     */   @Column(name="PRODUCTID", nullable=true, length=10)
/*     */   private Integer productid;
/*     */   @Column(name="OPTIONID", nullable=true, length=10)
/*     */   private Integer optionid;
/*     */   @Column(name="OPTIONNAME", nullable=true, length=100)
/*     */   private String optionname;
/*     */   @Column(name="ATTRIBUTEID", nullable=true, length=10)
/*     */   private Integer attributeid;
/*     */   @Column(name="ATTRIBUTENAME", nullable=true, length=100)
/*     */   private String attributename;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  62 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  71 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/*  80 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/*  89 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public Integer getOptionid()
/*     */   {
/*  98 */     return this.optionid;
/*     */   }
/*     */   
/*     */   public void setOptionid(Integer optionid)
/*     */   {
/* 107 */     this.optionid = optionid;
/*     */   }
/*     */   
/*     */   public String getOptionname()
/*     */   {
/* 116 */     return this.optionname;
/*     */   }
/*     */   
/*     */   public void setOptionname(String optionname)
/*     */   {
/* 125 */     this.optionname = optionname;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/* 134 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/* 143 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 152 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 161 */     this.attributename = attributename;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.entity.ProductAttributeMapEntity
 * JD-Core Version:    0.7.0.1
 */