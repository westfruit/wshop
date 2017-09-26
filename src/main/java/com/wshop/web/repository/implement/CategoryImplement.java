/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.CategoryDTO;
/*    */ import com.wshop.web.repository.CategoryRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class CategoryImplement
/*    */   extends JdbcDaoImpl
/*    */   implements CategoryRepository
/*    */ {
/*    */   public List<CategoryDTO> findAllByParentId(Integer parentId)
/*    */   {
/* 17 */     return super.queryForObjectList("SELECT * from t_category WHERE ParentId=" + parentId, CategoryDTO.class, new Object[0]);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.CategoryImplement
 * JD-Core Version:    0.7.0.1
 */