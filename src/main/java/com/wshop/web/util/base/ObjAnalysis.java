/*    */ package com.wshop.web.util.base;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ObjAnalysis
/*    */ {
/*    */   public static Map ConvertObjToMap(Object obj)
/*    */   {
/* 13 */     Map<String, Object> reMap = new HashMap();
/* 14 */     if (obj == null) {
/* 15 */       return null;
/*    */     }
/* 16 */     Field[] fields = obj.getClass().getDeclaredFields();
/*    */     try
/*    */     {
/* 18 */       for (int i = 0; i < fields.length; i++) {
/*    */         try
/*    */         {
/* 20 */           Field f = obj.getClass().getDeclaredField(fields[i].getName());
/* 21 */           f.setAccessible(true);
/* 22 */           Object o = f.get(obj);
/* 23 */           reMap.put(fields[i].getName(), o);
/*    */         }
/*    */         catch (NoSuchFieldException e)
/*    */         {
/* 26 */           e.printStackTrace();
/*    */         }
/*    */         catch (IllegalArgumentException e)
/*    */         {
/* 29 */           e.printStackTrace();
/*    */         }
/*    */         catch (IllegalAccessException e)
/*    */         {
/* 32 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (SecurityException e)
/*    */     {
/* 37 */       e.printStackTrace();
/*    */     }
/* 39 */     return reMap;
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.util.base.ObjAnalysis
 * JD-Core Version:    0.7.0.1
 */