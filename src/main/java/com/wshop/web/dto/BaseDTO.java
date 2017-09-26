/*    */ package com.wshop.web.dto;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ 
/*    */ public class BaseDTO
/*    */ {
/*    */   @JsonProperty("IntValue")
/* 11 */   private Integer intvalue = Integer.valueOf(0);
/*    */   @JsonProperty("LongValue")
/* 12 */   private long longvalue = 0L;
/*    */   
/*    */   public Integer getIntvalue()
/*    */   {
/* 16 */     return this.intvalue;
/*    */   }
/*    */   
/*    */   public void setIntvalue(Integer intvalue)
/*    */   {
/* 20 */     this.intvalue = intvalue;
/*    */   }
/*    */   
/*    */   public long getLongvalue()
/*    */   {
/* 24 */     return this.longvalue;
/*    */   }
/*    */   
/*    */   public void setLongvalue(long longvalue)
/*    */   {
/* 28 */     this.longvalue = longvalue;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.BaseDTO
 * JD-Core Version:    0.7.0.1
 */