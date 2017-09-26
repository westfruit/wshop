/*     */ package com.wshop.web.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ 
/*     */ public class UploadResult
/*     */ {
/*     */   @JsonProperty("Code")
/*     */   private String code;
/*     */   @JsonProperty("message")
/*     */   private String message;
/*     */   @JsonProperty("ImgUrl")
/*     */   private String imgUrl;
/*     */   @JsonProperty("error")
/*     */   private Integer error;
/*     */   @JsonProperty("url")
/*     */   private String url;
/*     */   
/*     */   public Integer getError()
/*     */   {
/*  32 */     return this.error;
/*     */   }
/*     */   
/*     */   public void setError(Integer error)
/*     */   {
/*  41 */     this.error = error;
/*     */   }
/*     */   
/*     */   public String getUrl()
/*     */   {
/*  50 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url)
/*     */   {
/*  59 */     this.url = url;
/*     */   }
/*     */   
/*     */   public String getImgurl()
/*     */   {
/*  68 */     return this.imgUrl;
/*     */   }
/*     */   
/*     */   public void setImgurl(String imgUrl)
/*     */   {
/*  77 */     this.imgUrl = imgUrl;
/*     */   }
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  86 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message)
/*     */   {
/*  95 */     this.message = message;
/*     */   }
/*     */   
/*     */   public String getCode()
/*     */   {
/* 104 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code)
/*     */   {
/* 113 */     this.code = code;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.model.UploadResult
 * JD-Core Version:    0.7.0.1
 */