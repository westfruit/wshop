/*     */ package com.wshop.web.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_PRODUCT_ATTRIBUTE")
/*     */ public class ProductAttributeEntity
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7116036424362261892L;
/*     */   @Id
/*     */   @Column(name="ATTRIBUTEID", unique=true, nullable=false, length=10)
/*     */   private Integer attributeid;
/*     */   @Column(name="NAME", nullable=true, length=100)
/*     */   private String name;
/*     */   @Column(name="DESCRIPTION", nullable=true, length=300)
/*     */   private String description;
/*     */   @Column(name="CATEID", nullable=true, length=10)
/*     */   private Integer cateid;
/*     */   @Column(name="USERID", nullable=true, length=10)
/*     */   private Integer userid;
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  58 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/*  67 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  76 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name)
/*     */   {
/*  85 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription()
/*     */   {
/*  94 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description)
/*     */   {
/* 103 */     this.description = description;
/*     */   }
/*     */   
/*     */   public Integer getCateid()
/*     */   {
/* 112 */     return this.cateid;
/*     */   }
/*     */   
/*     */   public void setCateid(Integer cateid)
/*     */   {
/* 121 */     this.cateid = cateid;
/*     */   }
/*     */   
/*     */   public Integer getUserid()
/*     */   {
/* 130 */     return this.userid;
/*     */   }
/*     */   
/*     */   public void setUserid(Integer userid)
/*     */   {
/* 139 */     this.userid = userid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.entity.ProductAttributeEntity
 * JD-Core Version:    0.7.0.1
 */