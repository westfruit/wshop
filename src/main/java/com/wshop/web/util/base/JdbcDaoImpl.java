/*    */ package com.wshop.web.util.base;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.util.Assert;
/*    */ 
/*    */ public abstract class JdbcDaoImpl
/*    */ {
/*    */   @Autowired
/*    */   protected JdbcTemplate jdbcTemplate;
/*    */   
/*    */   public Long getLastId()
/*    */   {
/* 21 */     return (Long)this.jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
/*    */   }
/*    */   
/*    */   public <T> T queryForObject(String sql, Class<T> clazz, Object... args)
/*    */   {
/* 27 */     Assert.hasText(sql, "sq;语句不能为空");
/* 28 */     return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(clazz), args);
/*    */   }
/*    */   
/*    */   public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args)
/*    */   {
/* 35 */     Assert.hasText(sql, "sq;语句不能为空");
/* 36 */     return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(clazz), args);
/*    */   }
/*    */   
/*    */   public Page<Map<String, Object>> queryForPage(String sql, int pageCurrent, int pageSize, Object... args)
/*    */   {
/* 42 */     Assert.hasText(sql, "sql 语句不能为空");
/* 43 */     Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
/* 44 */     String sqlCount = Sql.countSql(sql);
/* 45 */     int count = ((Integer)this.jdbcTemplate.queryForObject(sqlCount, Integer.class, args)).intValue();
/* 46 */     pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
/* 47 */     pageSize = Sql.checkPageSize(pageSize);
/* 48 */     int totalPage = Sql.countTotalPage(count, pageSize);
/* 49 */     String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
/* 50 */     List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sqlList, args);
/* 51 */     return new Page(count, totalPage, pageCurrent, pageSize, list);
/*    */   }
/*    */   
/*    */   public <T> Page<T> queryForPage(String sql, int pageCurrent, int pageSize, Class<T> clazz, Object... args)
/*    */   {
/* 58 */     Assert.hasText(sql, "sql 语句不能为空");
/* 59 */     Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1");
/* 60 */     Assert.isTrue(clazz != null, "clazz 不能为空");
/* 61 */     String sqlCount = Sql.countSql(sql);
/* 62 */     int count = ((Integer)this.jdbcTemplate.queryForObject(sqlCount, Integer.class, args)).intValue();
/* 63 */     pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent);
/* 64 */     pageSize = Sql.checkPageSize(pageSize);
/* 65 */     int totalPage = Sql.countTotalPage(count, pageSize);
/* 66 */     String sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize);
/* 67 */     List<T> list = this.jdbcTemplate.query(sqlList, new BeanPropertyRowMapper(clazz), args);
/* 68 */     return new Page(count, totalPage, pageCurrent, pageSize, list);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.util.base.JdbcDaoImpl
 * JD-Core Version:    0.7.0.1
 */