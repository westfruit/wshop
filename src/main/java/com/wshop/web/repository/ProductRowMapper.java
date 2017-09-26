/*    */ package com.wshop.web.repository;
/*    */ 
/*    */ import com.wshop.web.dto.ProductDTO;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.springframework.jdbc.core.RowMapper;
/*    */ 
/*    */ public class ProductRowMapper
/*    */   implements RowMapper<ProductDTO>
/*    */ {
/*    */   public ProductDTO mapRow(ResultSet rs, int rowNum)
/*    */     throws SQLException
/*    */   {
/* 17 */     ProductDTO obj = new ProductDTO();
/* 18 */     obj.setProductid(Integer.valueOf(rs.getInt("ProductId")));
/* 19 */     obj.setTitle(rs.getString("Title"));
/* 20 */     obj.setCateid(Integer.valueOf(rs.getInt("CateId")));
/* 21 */     obj.setShelvestatus(Integer.valueOf(rs.getInt("ShelveStatus")));
/* 22 */     obj.setVerifystatus(Integer.valueOf(rs.getInt("VerifyStatus")));
/* 23 */     return null;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.ProductRowMapper
 * JD-Core Version:    0.7.0.1
 */