/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.DynamicProductMapDTO;
/*    */ import com.wshop.web.repository.DynamicProductMapRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class DynamicProductMapImplement
/*    */   extends JdbcDaoImpl
/*    */   implements DynamicProductMapRepository
/*    */ {
/*    */   public List<DynamicProductMapDTO> findAllByProductId(Integer productId)
/*    */   {
/* 20 */     return super.queryForObjectList("SELECT map.*,t_dynamic.AttributeName from t_dynamic_product_map map inner join t_dynamic on map.AttributeId=t_dynamic.AttributeId  WHERE map.ProductId =" + productId, DynamicProductMapDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public int batchUpdateAttributeProductMap(final List<DynamicProductMapDTO> list, Integer productId)
/*    */   {
/* 25 */     this.jdbcTemplate.execute("DELETE FROM t_dynamic_product_map  WHERE ProductId=" + productId);
/* 26 */     String sql = "INSERT INTO t_dynamic_product_map (ProductId,AttributeId,OptionValue) VALUES (?,?,?)";
/* 27 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 30 */         DynamicProductMapDTO map = (DynamicProductMapDTO)list.get(i);
/* 31 */         ps.setInt(1, map.getProductid().intValue());
/* 32 */         ps.setInt(2, map.getAttributeid().intValue());
/* 33 */         ps.setString(3, map.getOptionvalue());
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
 * Qualified Name:     com.wshop.web.repository.implement.DynamicProductMapImplement
 * JD-Core Version:    0.7.0.1
 */