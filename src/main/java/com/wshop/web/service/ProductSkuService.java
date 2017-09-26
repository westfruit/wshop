/*    */ package com.wshop.web.service;
/*    */ 
/*    */ import com.wshop.web.dto.ProductSkuDTO;
/*    */ import com.wshop.web.repository.ProductSkuRepository;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class ProductSkuService
/*    */ {
/*    */   @Autowired
/*    */   ProductSkuRepository productSkuRepository;
/*    */   
/*    */   public int replaceProductSku(List<ProductSkuDTO> list)
/*    */   {
/* 20 */     return this.productSkuRepository.replaceProductSku(list);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.service.ProductSkuService
 * JD-Core Version:    0.7.0.1
 */