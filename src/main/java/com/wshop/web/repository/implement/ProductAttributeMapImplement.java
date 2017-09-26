/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.ProductAttributeMapDTO;
/*    */ import com.wshop.web.dto.ProductAttributeValueDTO;
/*    */ import com.wshop.web.repository.ProductAttributeMapRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class ProductAttributeMapImplement
/*    */   extends JdbcDaoImpl
/*    */   implements ProductAttributeMapRepository
/*    */ {
/*    */   public List<ProductAttributeMapDTO> findAll()
/*    */   {
/* 23 */     return super.queryForObjectList("select * from t_product_attribute_map", ProductAttributeMapDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public List<ProductAttributeMapDTO> findAllByProductId(Integer productId)
/*    */   {
/* 28 */     return super.queryForObjectList("select * from t_product_attribute_map where ProductId=" + productId, ProductAttributeMapDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public int replaceProductAttributeMap(final List<ProductAttributeValueDTO> list, Integer productId)
/*    */   {
/* 32 */     this.jdbcTemplate.execute("DELETE FROM t_product_attribute_map WHERE ProductId=" + productId);
/* 33 */     String sql = " INSERT INTO t_product_attribute_map (ProductId,OptionId) VALUES (?,?)";
/* 34 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 37 */         ProductAttributeValueDTO map = (ProductAttributeValueDTO)list.get(i);
/* 38 */         ps.setInt(1, map.getProductid().intValue());
/* 39 */         ps.setInt(2, map.getOptionid().intValue());
/*    */       }
/*    */       
/*    */       public int getBatchSize()
/*    */       {
/* 43 */         return list.size();
/*    */       }
/* 46 */     });
/* 47 */     return results.length;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.ProductAttributeMapImplement
 * JD-Core Version:    0.7.0.1
 */