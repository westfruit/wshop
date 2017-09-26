/*    */ package com.wshop.web.service;
/*    */ 
/*    */ import com.wshop.web.repository.BaseRepository;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class BaseService
/*    */ {
/*    */   @Autowired
/*    */   BaseRepository baseRepository;
/*    */   
/*    */   public Integer getNewIntegerId()
/*    */   {
/* 16 */     return this.baseRepository.getNewIntegerId();
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.service.BaseService
 * JD-Core Version:    0.7.0.1
 */