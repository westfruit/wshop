/*    */ package com.wshop.web.repository.implement;
/*    */ 
/*    */ import com.wshop.web.repository.BaseRepository;
/*    */ import com.wshop.web.util.base.JdbcDaoImpl;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.jdbc.core.PreparedStatementCreator;
/*    */ import org.springframework.jdbc.support.GeneratedKeyHolder;
/*    */ import org.springframework.jdbc.support.KeyHolder;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class BaseImplement
/*    */   extends JdbcDaoImpl
/*    */   implements BaseRepository
/*    */ {
/*    */   public Integer getNewIntegerId()
/*    */   {
/* 27 */     KeyHolder keyHolder = new GeneratedKeyHolder();
/* 28 */     this.jdbcTemplate.update(new PreparedStatementCreator()
/*    */     {
/*    */       public PreparedStatement createPreparedStatement(Connection conn)
/*    */         throws SQLException
/*    */       {
/* 31 */         PreparedStatement ps = conn.prepareStatement("REPLACE INTO t_sequence_int (stub) VALUES ('a');", 1);
/* 32 */         return ps;
/*    */       }
/* 32 */     }, keyHolder);
/*    */     
/*    */ 
/*    */ 
/* 36 */     return Integer.valueOf(keyHolder.getKey().intValue());
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.implement.BaseImplement
 * JD-Core Version:    0.7.0.1
 */