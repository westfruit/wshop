/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.ProductAttributeValueDTO;
/*    */ import com.wshop.web.repository.AttributeValueRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class AttributeValueImplement
/*    */   extends JdbcDaoImpl
/*    */   implements AttributeValueRepository
/*    */ {
/*    */   public List<ProductAttributeValueDTO> findAllByProductId(Integer productId)
/*    */   {
/* 21 */     return super.queryForObjectList("SELECT attr.*,IFNULL(map.ProductId,0) as ProductId from t_product_attribute_value attr  LEFT JOIN t_product_attribute_map map  ON attr.OptionId=map.OptionId AND map.ProductId=" + productId, ProductAttributeValueDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public int replaceProductAttributeValue(final List<ProductAttributeValueDTO> list)
/*    */   {
/* 28 */     String sql = " REPLACE INTO t_product_attribute_value (OptionId,AttributeId,OptionName,OptionImg,AttributeName) VALUES (?,?,?,?,?)";
/* 29 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 32 */         ProductAttributeValueDTO map = (ProductAttributeValueDTO)list.get(i);
/* 33 */         ps.setInt(1, map.getOptionid().intValue());
/* 34 */         ps.setInt(2, map.getAttributeid().intValue());
/* 35 */         ps.setString(3, map.getOptionname());
/* 36 */         ps.setString(4, map.getOptionimg());
/* 37 */         ps.setString(5, map.getAttributename());
/*    */       }
/*    */       
/*    */       public int getBatchSize()
/*    */       {
/* 41 */         return list.size();
/*    */       }
/* 44 */     });
/* 45 */     return results.length;
/*    */   }
/*    */   
/*    */   public int batchUpdateProductAttributeValue(final List<ProductAttributeValueDTO> attrValueList)
/*    */   {
/* 51 */     String sql = " UPDATE  t_product_attribute_value set OptionName=?,OptionImg=? WHERE OptionId=?;";
/*    */     
/* 53 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 56 */         ProductAttributeValueDTO map = (ProductAttributeValueDTO)attrValueList.get(i);
/* 57 */         ps.setString(1, map.getOptionname());
/* 58 */         ps.setString(2, map.getOptionimg());
/* 59 */         ps.setInt(3, map.getOptionid().intValue());
/*    */       }
/*    */       
/*    */       public int getBatchSize()
/*    */       {
/* 63 */         return attrValueList.size();
/*    */       }
/* 66 */     });
/* 67 */     return results.length;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.AttributeValueImplement
 * JD-Core Version:    0.7.0.1
 */