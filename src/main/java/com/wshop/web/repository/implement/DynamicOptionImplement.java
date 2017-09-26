/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.DynamicOptionDTO;
/*    */ import com.wshop.web.repository.DynamicOptionRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class DynamicOptionImplement
/*    */   extends JdbcDaoImpl
/*    */   implements DynamicOptionRepository
/*    */ {
/*    */   public List<DynamicOptionDTO> findAllByAttributeId(String attributeIds)
/*    */   {
/* 20 */     return super.queryForObjectList("SELECT * from t_dynamic_option  WHERE AttributeId IN (" + attributeIds + ")", DynamicOptionDTO.class, new Object[0]);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.DynamicOptionImplement
 * JD-Core Version:    0.7.0.1
 */