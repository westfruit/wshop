/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.ProductAttributeDTO;
/*    */ import com.wshop.web.repository.ProductAttributeRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class ProductAttributeImplement
/*    */   extends JdbcDaoImpl
/*    */   implements ProductAttributeRepository
/*    */ {
/*    */   public List<ProductAttributeDTO> findAllByProductId(Integer productId)
/*    */   {
/* 21 */     return super.queryForObjectList("SELECT *  from t_product_attribute WHERE ProductId=" + productId, ProductAttributeDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public int replaceProductAttribute(final List<ProductAttributeDTO> list)
/*    */   {
/* 26 */     String sql = " REPLACE INTO t_product_attribute (AttributeId,AttributeName,ProductId) VALUES (?,?,?)";
/* 27 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 30 */         ProductAttributeDTO map = (ProductAttributeDTO)list.get(i);
/* 31 */         ps.setInt(1, map.getAttributeid().intValue());
/* 32 */         ps.setString(2, map.getAttributename());
/* 33 */         ps.setInt(3, map.getProductid().intValue());
/*    */       }
/*    */       
/*    */       public int getBatchSize()
/*    */       {
/* 38 */         return list.size();
/*    */       }
/* 41 */     });
/* 42 */     return results.length;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.ProductAttributeImplement
 * JD-Core Version:    0.7.0.1
 */