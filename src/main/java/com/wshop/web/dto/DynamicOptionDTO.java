/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class DynamicOptionDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -4117651292606923764L;
/*     */   @JsonProperty("OptionId")
/*     */   private Integer optionid;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   @JsonProperty("OptionValue")
/*     */   private String optionvalue;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   @JsonProperty("Selected")
/*     */   private Integer selected;
/*     */   
/*     */   public Integer getSelected()
/*     */   {
/*  55 */     return this.selected;
/*     */   }
/*     */   
/*     */   public void setSelected(Integer selected)
/*     */   {
/*  64 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public Integer getOptionid()
/*     */   {
/*  73 */     return this.optionid;
/*     */   }
/*     */   
/*     */   public void setOptionid(Integer optionid)
/*     */   {
/*  82 */     this.optionid = optionid;
/*     */   }
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  91 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/* 100 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public String getOptionvalue()
/*     */   {
/* 109 */     return this.optionvalue;
/*     */   }
/*     */   
/*     */   public void setOptionvalue(String optionvalue)
/*     */   {
/* 118 */     this.optionvalue = optionvalue;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 127 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 136 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 140 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 144 */     this.attributename = attributename;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.DynamicOptionDTO
 * JD-Core Version:    0.7.0.1
 */