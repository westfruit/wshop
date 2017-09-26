/*    */ package com.wshop.web.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_ATTRIBUTE_VALUE")
/*    */ public class AttributeValueEntity
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 6720035914221627100L;
/*    */   @Id
/*    */   @Column(name="OPTIONID", unique=true, nullable=false, length=10)
/*    */   private Integer optionid;
/*    */   @Column(name="ATTRIBUTEID", nullable=true, length=10)
/*    */   private Integer attributeid;
/*    */   @Column(name="OPTIONNAME", nullable=true, length=100)
/*    */   private String optionname;
/*    */   
/*    */   public Integer getOptionid()
/*    */   {
/* 50 */     return this.optionid;
/*    */   }
/*    */   
/*    */   public void setOptionid(Integer optionid)
/*    */   {
/* 59 */     this.optionid = optionid;
/*    */   }
/*    */   
/*    */   public Integer getAttributeid()
/*    */   {
/* 68 */     return this.attributeid;
/*    */   }
/*    */   
/*    */   public void setAttributeid(Integer attributeid)
/*    */   {
/* 77 */     this.attributeid = attributeid;
/*    */   }
/*    */   
/*    */   public String getOptionname()
/*    */   {
/* 86 */     return this.optionname;
/*    */   }
/*    */   
/*    */   public void setOptionname(String optionname)
/*    */   {
/* 95 */     this.optionname = optionname;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.entity.AttributeValueEntity
 * JD-Core Version:    0.7.0.1
 */