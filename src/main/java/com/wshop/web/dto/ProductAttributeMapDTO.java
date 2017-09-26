/*    */ package com.wshop.web.dto;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ProductAttributeMapDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -7779387032312334716L;
/*    */   @JsonProperty("ProductId")
/*    */   private Integer productid;
/*    */   @JsonProperty("OptionId")
/*    */   private Integer optionid;
/*    */   
/*    */   public Integer getProductid()
/*    */   {
/* 43 */     return this.productid;
/*    */   }
/*    */   
/*    */   public void setProductid(Integer productid)
/*    */   {
/* 52 */     this.productid = productid;
/*    */   }
/*    */   
/*    */   public Integer getOptionid()
/*    */   {
/* 61 */     return this.optionid;
/*    */   }
/*    */   
/*    */   public void setOptionid(Integer optionid)
/*    */   {
/* 70 */     this.optionid = optionid;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductAttributeMapDTO
 * JD-Core Version:    0.7.0.1
 */