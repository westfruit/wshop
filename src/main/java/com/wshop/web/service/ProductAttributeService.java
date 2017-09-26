/*    */ package com.wshop.web.service;
/*    */ 
/*    */ import com.wshop.web.dto.ProductAttributeDTO;
/*    */ import com.wshop.web.dto.ProductAttributeValueDTO;
/*    */ import com.wshop.web.repository.AttributeValueRepository;
/*    */ import com.wshop.web.repository.ProductAttributeMapRepository;
/*    */ import com.wshop.web.repository.ProductAttributeRepository;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class ProductAttributeService
/*    */ {
/*    */   @Autowired
/*    */   AttributeValueRepository attributeValueRepository;
/*    */   @Autowired
/*    */   ProductAttributeRepository productAttributeRepository;
/*    */   @Autowired
/*    */   ProductAttributeMapRepository productAttributeMapRepository;
/*    */   
/*    */   public int replaceProductAttributeValue(List<ProductAttributeValueDTO> list)
/*    */   {
/* 25 */     return this.attributeValueRepository.replaceProductAttributeValue(list);
/*    */   }
/*    */   
/*    */   public int replaceProductAttribute(List<ProductAttributeDTO> list)
/*    */   {
/* 29 */     return this.productAttributeRepository.replaceProductAttribute(list);
/*    */   }
/*    */   
/*    */   public int batchUpdateProductAttributeValue(List<ProductAttributeValueDTO> attrValueList)
/*    */   {
/* 33 */     return this.attributeValueRepository.batchUpdateProductAttributeValue(attrValueList);
/*    */   }
/*    */   
/*    */   public int replaceProductAttributeMap(List<ProductAttributeValueDTO> list, Integer productId)
/*    */   {
/* 37 */     return this.productAttributeMapRepository.replaceProductAttributeMap(list, productId);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.service.ProductAttributeService
 * JD-Core Version:    0.7.0.1
 */