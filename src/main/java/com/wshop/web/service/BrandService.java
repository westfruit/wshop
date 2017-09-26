/*    */ package com.wshop.web.service;
/*    */ 
/*    */ import com.wshop.web.repository.BrandRepository;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class BrandService
/*    */ {
/*    */   @Autowired
/*    */   BrandRepository brandRepository;
/*    */   
/*    */   public Object findAllByKeyword(String keyword)
/*    */   {
/* 16 */     return this.brandRepository.findAllByKeyword(keyword);
/*    */   }
/*    */   
/*    */   public Object findAll()
/*    */   {
/* 20 */     return this.brandRepository.findAll();
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.service.BrandService
 * JD-Core Version:    0.7.0.1
 */