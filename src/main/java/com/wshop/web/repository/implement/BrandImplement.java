/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.BrandDTO;
/*    */ import com.wshop.web.repository.BrandRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.util.List;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class BrandImplement
/*    */   extends JdbcDaoImpl
/*    */   implements BrandRepository
/*    */ {
/*    */   public List<BrandDTO> findAll()
/*    */   {
/* 18 */     return super.queryForObjectList("SELECT * from t_brand ", BrandDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public List<BrandDTO> findAllByKeyword(String keyword)
/*    */   {
/* 23 */     return super.queryForObjectList("SELECT * from t_brand WHERE BrandName LIKE '%" + keyword + "%' OR PinyinName LIKE '%" + keyword + "%' ", BrandDTO.class, new Object[0]);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.BrandImplement
 * JD-Core Version:    0.7.0.1
 */