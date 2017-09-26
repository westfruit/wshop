/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class ProductAttributeValueDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8653953102929829622L;
/*     */   @JsonProperty("Id")
/*     */   private Integer id;
/*     */   @JsonProperty("OptionId")
/*     */   private Integer optionid;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("OptionName")
/*     */   private String optionname;
/*     */   @JsonProperty("OptionImg")
/*     */   private String optionimg;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   @JsonProperty("ProductId")
/*     */   private Integer productid;
/*     */   
/*     */   public Integer getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id)
/*     */   {
/*  69 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getOptionid()
/*     */   {
/*  78 */     return this.optionid;
/*     */   }
/*     */   
/*     */   public void setOptionid(Integer optionid)
/*     */   {
/*  87 */     this.optionid = optionid;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  96 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/* 105 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public String getOptionname()
/*     */   {
/* 114 */     return this.optionname;
/*     */   }
/*     */   
/*     */   public void setOptionname(String optionname)
/*     */   {
/* 123 */     this.optionname = optionname;
/*     */   }
/*     */   
/*     */   public String getOptionimg()
/*     */   {
/* 132 */     return this.optionimg;
/*     */   }
/*     */   
/*     */   public void setOptionimg(String optionimg)
/*     */   {
/* 141 */     this.optionimg = optionimg;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 150 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 159 */     this.attributename = attributename;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/* 163 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/* 167 */     this.productid = productid;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductAttributeValueDTO
 * JD-Core Version:    0.7.0.1
 */