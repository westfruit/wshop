/*    */ package com.wshop.web.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ 
/*    */ public class Base64img
/*    */ {
/*    */   @JsonProperty("imgBase")
/*    */   private String imgbase;
/*    */   @JsonProperty("imgFormat")
/*    */   private String imgformat;
/*    */   @JsonProperty("lookIndex")
/*    */   private String lookindex;
/*    */   
/*    */   public String getLookindex()
/*    */   {
/* 26 */     return this.lookindex;
/*    */   }
/*    */   
/*    */   public void seLookindex(String lookindex)
/*    */   {
/* 35 */     this.lookindex = lookindex;
/*    */   }
/*    */   
/*    */   public String getImgformat()
/*    */   {
/* 44 */     return this.imgformat;
/*    */   }
/*    */   
/*    */   public void seImgformat(String imgformat)
/*    */   {
/* 53 */     this.imgformat = imgformat;
/*    */   }
/*    */   
/*    */   public String getImgbase()
/*    */   {
/* 63 */     return this.imgbase;
/*    */   }
/*    */   
/*    */   public void seImgbase(String imgbase)
/*    */   {
/* 72 */     this.imgbase = imgbase;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.model.Base64img
 * JD-Core Version:    0.7.0.1
 */