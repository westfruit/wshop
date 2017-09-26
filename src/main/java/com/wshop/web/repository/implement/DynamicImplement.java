/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.DynamicDTO;
/*    */ import com.wshop.web.repository.DynamicRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class DynamicImplement
/*    */   extends JdbcDaoImpl
/*    */   implements DynamicRepository
/*    */ {
/*    */   public List<DynamicDTO> findAllByProductId(Integer productId)
/*    */   {
/* 17 */     return super.queryForObjectList("SELECT attr.* from t_dynamic attr WHERE attr.AttributeId IN (SELECT AttributeId FROM t_dynamic_product_map WHERE ProductId=" + productId + ")", DynamicDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public List<DynamicDTO> findAllByCategoryId(Integer categoryId)
/*    */   {
/* 23 */     return super.queryForObjectList("SELECT attr.* from t_dynamic attr INNER JOIN t_dynamic_cate_map map ON map.AttributeId=attr.AttributeId WHERE  map.CategoryId=" + categoryId, DynamicDTO.class, new Object[0]);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.DynamicImplement
 * JD-Core Version:    0.7.0.1
 */