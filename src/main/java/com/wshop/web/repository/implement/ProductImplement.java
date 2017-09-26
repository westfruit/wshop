/*     */ package com.wshop.web.repository.implement;
/*     */ 
/*     */ import com.wshop.web.dto.ProductDTO;
/*     */ import com.wshop.web.dto.ProductGiftMapDTO;
/*     */ import com.wshop.web.dto.ProductRelatedMapDTO;
/*     */ import com.wshop.web.repository.ProductRepository;
/*     */ import com.wshop.web.util.base.JdbcDaoImpl;
/*     */ import com.wshop.web.util.base.Page;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import org.springframework.jdbc.core.BatchPreparedStatementSetter;
/*     */ import org.springframework.jdbc.core.JdbcTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Repository
/*     */ public class ProductImplement
/*     */   extends JdbcDaoImpl
/*     */   implements ProductRepository
/*     */ {
/*     */   @Transactional(readOnly=true)
/*     */   public List<ProductDTO> findAll()
/*     */   {
/*  30 */     return super.queryForObjectList("select * from t_product", ProductDTO.class, new Object[0]);
/*     */   }
/*     */   
/*     */   public Page<ProductDTO> findAllPage(Integer pageCurrent, Integer pageSize, String where)
/*     */   {
/*  36 */     return super.queryForPage("select * from t_product where 1=1 " + where, pageCurrent.intValue(), pageSize.intValue(), ProductDTO.class, new Object[0]);
/*     */   }
/*     */   
/*     */   public List<ProductGiftMapDTO> findProductGiftByProductId(Integer productId)
/*     */   {
/*  41 */     return super.queryForObjectList("select map.*,t_product.Title,t_product.ProductImg,t_product.SellPrice from t_product_gift_map map inner join t_product on t_product.ProductId=map.ProductId2 WHERE  map.ProductId=" + productId, ProductGiftMapDTO.class, new Object[0]);
/*     */   }
/*     */   
/*     */   public List<ProductRelatedMapDTO> findProductRelatedByProductId(Integer productId)
/*     */   {
/*  47 */     return super.queryForObjectList("select map.*,t_product.Title,t_product.ProductImg,t_product.SellPrice from t_product_related_map map inner join t_product on t_product.ProductId=map.ProductId2 WHERE  map.ProductId=" + productId, ProductRelatedMapDTO.class, new Object[0]);
/*     */   }
/*     */   
/*     */   public Integer batchUpdateProductGift(final List<ProductGiftMapDTO> list, Integer productId)
/*     */   {
/*  53 */     this.jdbcTemplate.execute("DELETE FROM t_product_gift_map WHERE ProductId=" + productId);
/*  54 */     String sql = " INSERT INTO t_product_gift_map (ProductId,ProductId2) VALUES (?,?)";
/*  55 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*     */     {
/*     */       public void setValues(PreparedStatement ps, int i)
/*     */         throws SQLException
/*     */       {
/*  58 */         ProductGiftMapDTO map = (ProductGiftMapDTO)list.get(i);
/*  59 */         ps.setInt(1, map.getProductid().intValue());
/*  60 */         ps.setInt(2, map.getProductid2().intValue());
/*     */       }
/*     */       
/*     */       public int getBatchSize()
/*     */       {
/*  64 */         return list.size();
/*     */       }
/*  67 */     });
/*  68 */     return Integer.valueOf(results.length);
/*     */   }
/*     */   
/*     */   public Integer batchUpdateProductRelated(final List<ProductRelatedMapDTO> list, Integer productId)
/*     */   {
/*  73 */     this.jdbcTemplate.execute("DELETE FROM t_product_related_map WHERE ProductId=" + productId);
/*  74 */     String sql = " INSERT INTO t_product_related_map (ProductId,ProductId2) VALUES (?,?)";
/*  75 */     int[] results = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
/*     */     {
/*     */       public void setValues(PreparedStatement ps, int i)
/*     */         throws SQLException
/*     */       {
/*  78 */         ProductRelatedMapDTO map = (ProductRelatedMapDTO)list.get(i);
/*     */         
/*  80 */         ps.setInt(1, map.getProductid().intValue());
/*  81 */         ps.setInt(2, map.getProductid2().intValue());
/*     */       }
/*     */       
/*     */       public int getBatchSize()
/*     */       {
/*  85 */         return list.size();
/*     */       }
/*  88 */     });
/*  89 */     return Integer.valueOf(results.length);
/*     */   }
/*     */   
/*     */   public ProductDTO findProductById(Integer productId)
/*     */   {
/*  94 */     List<ProductDTO> list = super.queryForObjectList("select t_product.*,t_product_ext.Content,t_product_ext.ServiceInfo from t_product inner join t_product_ext on t_product.ProductId=t_product_ext.ProductId  where t_product.ProductId=" + productId, ProductDTO.class, new Object[0]);
/*  96 */     if ((null != list) && (list.size() > 0)) {
/*  97 */       return (ProductDTO)list.get(0);
/*     */     }
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public Integer replaceProduct(ProductDTO product)
/*     */   {
/* 104 */     this.jdbcTemplate.update("REPLACE INTO t_product_ext (ProductId,Content,ServiceInfo) VALUES(?,?,?)", new Object[] { product.getProductid(), product.getContent(), product.getServiceinfo() });
/* 105 */     return Integer.valueOf(this.jdbcTemplate.update("REPLACE INTO t_product (ProductId,Title,SearchTitle,Summery,CateId,CateName,BrandName,ProductImg,ProductAlbum,VerifyStatus,ShelveStatus,UpdateTime,SellPrice) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)", new Object[] {product
/*     */     
/*     */ 
/* 108 */       .getProductid(), product
/* 109 */       .getTitle(), product
/* 110 */       .getSearchtitle(), product
/* 111 */       .getSummery(), product
/* 112 */       .getCateid(), product
/* 113 */       .getCatename(), product
/* 114 */       .getBrandname(), product
/* 115 */       .getProductimg(), product
/* 116 */       .getProductalbum(), product
/* 117 */       .getVerifystatus(), product
/* 118 */       .getShelvestatus(), product
/* 119 */       .getUpdatetime(), product
/* 120 */       .getSellprice() }));
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.ProductImplement
 * JD-Core Version:    0.7.0.1
 */