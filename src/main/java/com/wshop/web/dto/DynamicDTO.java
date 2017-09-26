/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DynamicDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2629669798564764936L;
/*     */   @JsonProperty("AttributeId")
/*     */   private Integer attributeid;
/*     */   @JsonProperty("ControlType")
/*     */   private Integer controltype;
/*     */   @JsonProperty("DataType")
/*     */   private Integer datatype;
/*     */   @JsonProperty("Readonly")
/*     */   private Integer readonly;
/*     */   @JsonProperty("IsMust")
/*     */   private Integer ismust;
/*     */   @JsonProperty("SortId")
/*     */   private Integer sortid;
/*     */   @JsonProperty("AttributeName")
/*     */   private String attributename;
/*     */   @JsonProperty("PromptText")
/*     */   private String prompttext;
/*     */   @JsonProperty("Attributes")
/*  61 */   private List<DynamicOptionDTO> attributes = new ArrayList();
/*     */   
/*     */   public Integer getAttributeid()
/*     */   {
/*  70 */     return this.attributeid;
/*     */   }
/*     */   
/*     */   public void setAttributeid(Integer attributeid)
/*     */   {
/*  79 */     this.attributeid = attributeid;
/*     */   }
/*     */   
/*     */   public Integer getControltype()
/*     */   {
/*  88 */     return this.controltype;
/*     */   }
/*     */   
/*     */   public void setControltype(Integer controltype)
/*     */   {
/*  98 */     this.controltype = controltype;
/*     */   }
/*     */   
/*     */   public Integer getDatatype()
/*     */   {
/* 107 */     return this.datatype;
/*     */   }
/*     */   
/*     */   public void setDatatype(Integer datatype)
/*     */   {
/* 117 */     this.datatype = datatype;
/*     */   }
/*     */   
/*     */   public Integer getReadonly()
/*     */   {
/* 126 */     return this.readonly;
/*     */   }
/*     */   
/*     */   public void setReadonly(Integer readonly)
/*     */   {
/* 136 */     this.readonly = readonly;
/*     */   }
/*     */   
/*     */   public Integer getIsmust()
/*     */   {
/* 145 */     return this.ismust;
/*     */   }
/*     */   
/*     */   public void setIsmust(Integer ismust)
/*     */   {
/* 155 */     this.ismust = ismust;
/*     */   }
/*     */   
/*     */   public Integer getSortid()
/*     */   {
/* 164 */     return this.sortid;
/*     */   }
/*     */   
/*     */   public void setSortid(Integer sortid)
/*     */   {
/* 173 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   public String getAttributename()
/*     */   {
/* 182 */     return this.attributename;
/*     */   }
/*     */   
/*     */   public void setAttributename(String attributename)
/*     */   {
/* 191 */     this.attributename = attributename;
/*     */   }
/*     */   
/*     */   public String getPrompttext()
/*     */   {
/* 200 */     return this.prompttext;
/*     */   }
/*     */   
/*     */   public void setPrompttext(String prompttext)
/*     */   {
/* 209 */     this.prompttext = prompttext;
/*     */   }
/*     */   
/*     */   public List<DynamicOptionDTO> getAttributes()
/*     */   {
/* 213 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public void setAttributes(List<DynamicOptionDTO> attributes)
/*     */   {
/* 217 */     this.attributes = attributes;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.DynamicDTO
 * JD-Core Version:    0.7.0.1
 */