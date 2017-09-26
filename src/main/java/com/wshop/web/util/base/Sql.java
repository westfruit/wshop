/*     */ package com.wshop.web.util.base;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class Sql
/*     */ {
/*     */   public static String checkSql(String sql)
/*     */   {
/*  22 */     String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
/*  23 */     String[] inj_stra = inj_str.split("\\|");
/*  24 */     for (int i = 0; i < inj_stra.length; i++) {
/*  25 */       if (sql.indexOf(inj_stra[i]) >= 0) {
/*  26 */         return "";
/*     */       }
/*     */     }
/*  29 */     return sql;
/*     */   }
/*     */   
/*     */   public static int countTotalPage(int totalCount, int pageSize)
/*     */   {
/*  42 */     if (totalCount % pageSize == 0) {
/*  43 */       return totalCount / pageSize;
/*     */     }
/*  45 */     return totalCount / pageSize + 1;
/*     */   }
/*     */   
/*     */   public static int checkPageCurrent(int totalCount, int pageSize, int pageCurrent)
/*     */   {
/*  65 */     int totalPage = countTotalPage(totalCount, pageSize);
/*  66 */     if (pageCurrent > totalPage)
/*     */     {
/*  69 */       if (totalPage < 1) {
/*  70 */         return 1;
/*     */       }
/*  72 */       return totalPage;
/*     */     }
/*  73 */     if (pageCurrent < 1) {
/*  74 */       return 1;
/*     */     }
/*  76 */     return pageCurrent;
/*     */   }
/*     */   
/*     */   public static int checkPageSize(int pageSize)
/*     */   {
/*  90 */     if (pageSize > 1000) {
/*  91 */       return 1000;
/*     */     }
/*  92 */     if (pageSize < 1) {
/*  93 */       return 20;
/*     */     }
/*  95 */     return pageSize;
/*     */   }
/*     */   
/*     */   public static int countOffset(int pageCurrent, int pageSize)
/*     */   {
/* 109 */     return (pageCurrent - 1) * pageSize;
/*     */   }
/*     */   
/*     */   public static String limitSql(int totalCount, int pageCurrent, int pageSize)
/*     */   {
/* 125 */     pageCurrent = checkPageCurrent(totalCount, pageSize, pageCurrent);
/* 126 */     pageSize = checkPageSize(pageSize);
/* 127 */     return " limit " + countOffset(pageCurrent, pageSize) + "," + pageSize;
/*     */   }
/*     */   
/*     */   public static String countSql(String sql)
/*     */   {
/* 138 */     String countSql = sql.substring(sql.toLowerCase().indexOf("from"));
/* 139 */     return "select count(*) " + removeOrderBy(countSql);
/*     */   }
/*     */   
/*     */   private static String removeOrderBy(String sql)
/*     */   {
/* 150 */     Pattern pat = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", 2);
/* 151 */     Matcher mc = pat.matcher(sql);
/* 152 */     StringBuffer strBuf = new StringBuffer();
/* 153 */     while (mc.find()) {
/* 154 */       mc.appendReplacement(strBuf, "");
/*     */     }
/* 156 */     mc.appendTail(strBuf);
/* 157 */     return strBuf.toString();
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.util.base.Sql
 * JD-Core Version:    0.7.0.1
 */