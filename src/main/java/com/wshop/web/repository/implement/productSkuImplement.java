/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.dto.ProductSkuDTO;
/*    */ import com.wshop.web.repository.ProductSkuRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class productSkuImplement
/*    */   extends JdbcDaoImpl
/*    */   implements ProductSkuRepository
/*    */ {
/*    */   public List<ProductSkuDTO> getProductSkuByProductId(Integer productId)
/*    */   {
/* 21 */     return super.queryForObjectList("select * from t_product_sku where ProductId=" + productId, ProductSkuDTO.class, new Object[0]);
/*    */   }
/*    */   
/*    */   public int replaceProductSku(final List<ProductSkuDTO> list)
/*    */   {
/* 25 */     String sql = "REPLACE INTO t_product_sku (SkuId,ProductId,StockQuantity,CommodityCode ,SkuPrice,SkuImg1,SkuImg2,Attributes,AttributeName,IsDelete) VALUES (?,?,?,?,?,?,?,?,?,?)";
/*    */     
/* 27 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*    */     {
/*    */       public void setValues(PreparedStatement ps, int i)
/*    */         throws SQLException
/*    */       {
/* 30 */         ProductSkuDTO sku = (ProductSkuDTO)list.get(i);
/* 31 */         ps.setInt(1, sku.getSkuid().intValue());
/* 32 */         ps.setInt(2, sku.getProductid().intValue());
/* 33 */         ps.setInt(3, sku.getStockquantity().intValue());
/* 34 */         ps.setString(4, sku.getCommoditycode());
/* 35 */         ps.setBigDecimal(5, sku.getSkuprice());
/* 36 */         ps.setString(6, sku.getSkuimg1());
/* 37 */         ps.setString(7, sku.getSkuimg2());
/* 38 */         ps.setString(8, sku.getAttributes());
/* 39 */         ps.setString(9, sku.getAttributename());
/* 40 */         ps.setInt(10, sku.getIsdelete().intValue());
/*    */       }
/*    */       
/*    */       public int getBatchSize()
/*    */       {
/* 44 */         return list.size();
/*    */       }
/* 47 */     });
/* 48 */     return results.length;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.productSkuImplement
 * JD-Core Version:    0.7.0.1
 */