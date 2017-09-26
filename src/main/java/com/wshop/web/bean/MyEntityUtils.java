/*     */ package com.wshop.web.bean;
/*     */ 
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MyEntityUtils
/*     */ {
/*  23 */   private String tablename = "";
/*     */   private String[] colnames;
/*     */   private String[] colTypes;
/*     */   private int[] colSizes;
/*     */   private int[] colScale;
/*  28 */   private boolean importUtil = false;
/*  29 */   private boolean importSql = false;
/*  30 */   private boolean importMath = false;
/*     */   
/*     */   public void tableToEntity(String tName)
/*     */   {
/*  37 */     this.tablename = tName;
/*     */     
/*  39 */     Connection conn = null;
/*  40 */     String strsql = "SELECT * FROM " + this.tablename;
/*     */     try
/*     */     {
/*  42 */       System.out.println(strsql);
/*  43 */       PreparedStatement pstmt = conn.prepareStatement(strsql);
/*  44 */       pstmt.executeQuery();
/*  45 */       ResultSetMetaData rsmd = pstmt.getMetaData();
/*  46 */       int size = rsmd.getColumnCount();
/*  47 */       this.colnames = new String[size];
/*  48 */       this.colTypes = new String[size];
/*  49 */       this.colSizes = new int[size];
/*  50 */       this.colScale = new int[size];
/*  51 */       for (int i = 0; i < rsmd.getColumnCount(); i++)
/*     */       {
/*  52 */         rsmd.getCatalogName(i + 1);
/*  53 */         this.colnames[i] = rsmd.getColumnName(i + 1).toLowerCase();
/*  54 */         this.colTypes[i] = rsmd.getColumnTypeName(i + 1).toLowerCase();
/*  55 */         this.colScale[i] = rsmd.getScale(i + 1);
/*  56 */         System.out.println(rsmd.getCatalogName(i + 1));
/*  57 */         if ("datetime".equals(this.colTypes[i])) {
/*  58 */           this.importUtil = true;
/*     */         }
/*  60 */         if (("image".equals(this.colTypes[i])) || ("text".equals(this.colTypes[i]))) {
/*  61 */           this.importSql = true;
/*     */         }
/*  63 */         if (this.colScale[i] > 0) {
/*  64 */           this.importMath = true;
/*     */         }
/*  66 */         this.colSizes[i] = rsmd.getPrecision(i + 1);
/*     */       }
/*  68 */       String content = parse(this.colnames, this.colTypes, this.colSizes);
/*     */       try
/*     */       {
/*  70 */         FileWriter fw = new FileWriter(initcap(this.tablename) + ".java");
/*  71 */         PrintWriter pw = new PrintWriter(fw);
/*  72 */         pw.println(content);
/*  73 */         pw.flush();
/*  74 */         pw.close();
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/*  76 */         e.printStackTrace();
/*     */       }
/*     */       return;
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  82 */         if (conn != null) {
/*  82 */           conn.close();
/*     */         }
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/*  84 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private String parse(String[] colNames, String[] colTypes, int[] colSizes)
/*     */   {
/*  93 */     StringBuffer sb = new StringBuffer();
/*  94 */     sb.append("\r\nimport java.io.Serializable;\r\n");
/*  95 */     if (this.importUtil) {
/*  96 */       sb.append("import java.util.Date;\r\n");
/*     */     }
/*  98 */     if (this.importSql) {
/*  99 */       sb.append("import java.sql.*;\r\n\r\n");
/*     */     }
/* 101 */     if (this.importMath) {
/* 102 */       sb.append("import java.math.*;\r\n\r\n");
/*     */     }
/* 105 */     processColnames(sb);
/* 106 */     sb.append("public class " + initcap(this.tablename) + " implements Serializable {\r\n");
/* 107 */     processAllAttrs(sb);
/* 108 */     processAllMethod(sb);
/* 109 */     sb.append("}\r\n");
/* 110 */     System.out.println(sb.toString());
/* 111 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private void processColnames(StringBuffer sb)
/*     */   {
/* 121 */     sb.append("\r\n/** " + this.tablename + "\r\n");
/* 122 */     String colsiz = "";
/* 123 */     String colsca = "";
/* 124 */     for (int i = 0; i < this.colnames.length; i++)
/*     */     {
/* 125 */       colsiz = "(" + this.colSizes[i] + "," + this.colScale[i] + ")";
/* 126 */       sb.append("\t" + this.colnames[i].toUpperCase() + "\t" + this.colTypes[i].toUpperCase() + colsiz + "\r\n");
/* 127 */       char[] ch = this.colnames[i].toCharArray();
/* 128 */       char c = 'a';
/* 129 */       if (ch.length > 3) {
/* 130 */         for (int j = 0; j < ch.length; j++)
/*     */         {
/* 131 */           c = ch[j];
/* 132 */           if ((c == '_') && 
/* 133 */             (ch[(j + 1)] >= 'a') && (ch[(j + 1)] <= 'z')) {
/* 134 */             ch[(j + 1)] = ((char)(ch[(j + 1)] - ' '));
/*     */           }
/*     */         }
/*     */       }
/* 139 */       String str = new String(ch);
/* 140 */       this.colnames[i] = str.replaceAll("_", "");
/*     */     }
/* 142 */     sb.append("*/\r\n");
/*     */   }
/*     */   
/*     */   private void processAllMethod(StringBuffer sb)
/*     */   {
/* 150 */     for (int i = 0; i < this.colnames.length; i++)
/*     */     {
/* 151 */       sb.append("\tpublic void set" + initcap(this.colnames[i]) + "(" + 
/* 152 */         oracleSqlType2JavaType(this.colTypes[i], this.colScale[i], this.colSizes[i]) + " " + this.colnames[i] + "){\r\n");
/*     */       
/* 154 */       sb.append("\t\tthis." + this.colnames[i] + "=" + this.colnames[i] + ";\r\n");
/* 155 */       sb.append("\t}\r\n");
/*     */       
/* 157 */       sb.append("\tpublic " + oracleSqlType2JavaType(this.colTypes[i], this.colScale[i], this.colSizes[i]) + " get" + 
/* 158 */         initcap(this.colnames[i]) + "(){\r\n");
/* 159 */       sb.append("\t\treturn " + this.colnames[i] + ";\r\n");
/* 160 */       sb.append("\t}\r\n");
/*     */     }
/*     */   }
/*     */   
/*     */   private void processAllAttrs(StringBuffer sb)
/*     */   {
/* 170 */     sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
/* 171 */     for (int i = 0; i < this.colnames.length; i++) {
/* 172 */       sb.append("\tprivate " + oracleSqlType2JavaType(this.colTypes[i], this.colScale[i], this.colSizes[i]) + " " + this.colnames[i] + ";\r\n");
/*     */     }
/* 175 */     sb.append("\r\n");
/*     */   }
/*     */   
/*     */   private String initcap(String str)
/*     */   {
/* 184 */     char[] ch = str.toCharArray();
/* 185 */     if ((ch[0] >= 'a') && (ch[0] <= 'z')) {
/* 186 */       ch[0] = ((char)(ch[0] - ' '));
/*     */     }
/* 188 */     return new String(ch);
/*     */   }
/*     */   
/*     */   private String oracleSqlType2JavaType(String sqlType, int scale, int size)
/*     */   {
/* 198 */     if (sqlType.equals("integer")) {
/* 199 */       return "Integer";
/*     */     }
/* 200 */     if (sqlType.equals("long")) {
/* 201 */       return "Long";
/*     */     }
/* 202 */     if ((sqlType.equals("float")) || 
/* 203 */       (sqlType.equals("float precision")) || 
/* 204 */       (sqlType.equals("double")) || 
/* 205 */       (sqlType.equals("double precision"))) {
/* 207 */       return "BigDecimal";
/*     */     }
/* 208 */     if ((sqlType.equals("number")) || 
/* 209 */       (sqlType.equals("decimal")) || 
/* 210 */       (sqlType.equals("numeric")) || 
/* 211 */       (sqlType.equals("real"))) {
/* 212 */       return scale == 0 ? "Long" : size < 10 ? "Integer" : "BigDecimal";
/*     */     }
/* 213 */     if ((sqlType.equals("varchar")) || 
/* 214 */       (sqlType.equals("varchar2")) || 
/* 215 */       (sqlType.equals("char")) || 
/* 216 */       (sqlType.equals("nvarchar")) || 
/* 217 */       (sqlType.equals("nchar"))) {
/* 218 */       return "String";
/*     */     }
/* 219 */     if ((sqlType.equals("datetime")) || 
/* 220 */       (sqlType.equals("date")) || 
/* 221 */       (sqlType.equals("timestamp"))) {
/* 222 */       return "Date";
/*     */     }
/* 224 */     return null;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 231 */     MyEntityUtils t = new MyEntityUtils();
/* 232 */     t.tableToEntity("TABLE");
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.bean.MyEntityUtils
 * JD-Core Version:    0.7.0.1
 */