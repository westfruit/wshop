/*     */ package com.wshop.web.util.base;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ public class MapParserUtil
/*     */ {
/*     */   public static Map<String, Object> convertBeanToMap(Object bean)
/*     */   {
/*  34 */     Map<String, Object> map = new HashMap();
/*     */     try
/*     */     {
/*  36 */       Class c = bean.getClass();
/*     */       
/*  38 */       Method[] methodArr = c.getMethods();
/*  39 */       for (Method method : methodArr)
/*     */       {
/*  40 */         String methodName = method.getName();
/*  41 */         if ((methodName.startsWith("get")) && (!"getClass".equals(methodName)) && 
/*  42 */           (null != method.invoke(bean, new Object[0])))
/*     */         {
/*  43 */           String key = methodName.substring(3);
/*  44 */           key = key.toLowerCase().charAt(0) + key.substring(1);
/*  45 */           map.put(key, method.invoke(bean, new Object[0]));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*  51 */     return map;
/*     */   }
/*     */   
/*     */   public static Map<String, String> convertBeanToStringMap(Object bean)
/*     */   {
/*  63 */     Map<String, String> map = new HashMap();
/*     */     try
/*     */     {
/*  65 */       Class c = bean.getClass();
/*     */       
/*  67 */       Method[] methodArr = c.getMethods();
/*  68 */       for (Method method : methodArr)
/*     */       {
/*  69 */         String methodName = method.getName();
/*  70 */         if ((methodName.startsWith("get")) && (!"getClass".equals(methodName)) && 
/*  71 */           (null != method.invoke(bean, new Object[0])))
/*     */         {
/*  72 */           String key = methodName.substring(3);
/*  73 */           key = key.toLowerCase().charAt(0) + key.substring(1);
/*  74 */           map.put(key, method.invoke(bean, new Object[0]).toString());
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*  80 */     return map;
/*     */   }
/*     */   
/*     */   public static Map<String, String> getAllRequestParam(HttpServletRequest request)
/*     */   {
/*  90 */     Map<String, String> res = new HashMap();
/*  91 */     Enumeration<?> temp = request.getParameterNames();
/*  92 */     if (null != temp) {
/*  93 */       while (temp.hasMoreElements())
/*     */       {
/*  94 */         String en = (String)temp.nextElement();
/*  95 */         String value = request.getParameter(en);
/*  96 */         res.put(en, value);
/*  98 */         if ((null == res.get(en)) || ("".equals(res.get(en)))) {
/*  99 */           res.remove(en);
/*     */         }
/*     */       }
/*     */     }
/* 103 */     return res;
/*     */   }
/*     */   
/*     */   public static Map<String, Object> getInputStreamToMap(HttpServletRequest request)
/*     */   {
/* 113 */     Map<String, Object> resultMap = null;
/*     */     try
/*     */     {
/* 115 */       String str = IOUtils.toString(request.getInputStream());
/*     */     }
/*     */     catch (IOException localIOException1) {}
/* 121 */     return resultMap;
/*     */   }
/*     */   
/*     */   public static <T> T getObjectFromMap(Class<T> cls, Map<String, ? extends Object> data)
/*     */   {
/* 132 */     T object = null;
/*     */     try
/*     */     {
/* 135 */       object = cls.newInstance();
/*     */       
/* 137 */       BeanUtils.populate(object, data);
/*     */     }
/*     */     catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InvocationTargetException localInvocationTargetException) {}
/* 145 */     return object;
/*     */   }
/*     */   
/*     */   public static String getStringFromMap(Map<String, ? extends Object> map, String key)
/*     */   {
/* 156 */     return getStringFromMap(map, key, null);
/*     */   }
/*     */   
/*     */   public static String getStringFromMap(Map<String, ? extends Object> map, String key, String defaultValue)
/*     */   {
/* 168 */     if (StringUtil.isEmpty(key)) {
/* 169 */       return defaultValue;
/*     */     }
/* 171 */     Object result = map.get(key);
/* 172 */     if (result == null) {
/* 173 */       return defaultValue;
/*     */     }
/* 175 */     return result.toString();
/*     */   }
/*     */   
/*     */   public static Integer getIntFromMap(Map<String, ? extends Object> map, String key)
/*     */   {
/* 187 */     if (StringUtil.isEmpty(key)) {
/* 188 */       return null;
/*     */     }
/* 190 */     Object result = map.get(key);
/* 191 */     if (result == null) {
/* 192 */       return null;
/*     */     }
/* 194 */     return Integer.valueOf(Integer.parseInt(result.toString()));
/*     */   }
/*     */   
/*     */   public static Long getLongFromMap(Map<String, ? extends Object> map, String key)
/*     */   {
/* 206 */     if (StringUtil.isEmpty(key)) {
/* 207 */       return null;
/*     */     }
/* 209 */     Object result = map.get(key);
/* 210 */     if (result == null) {
/* 211 */       return null;
/*     */     }
/* 213 */     return Long.valueOf(Long.parseLong(result.toString()));
/*     */   }
/*     */   
/*     */   public static BigDecimal getBigDecimalFromMap(Map<String, ? extends Object> map, String key)
/*     */   {
/* 225 */     if (StringUtil.isEmpty(key)) {
/* 226 */       return null;
/*     */     }
/* 228 */     Object result = map.get(key);
/* 229 */     if (result == null) {
/* 230 */       return null;
/*     */     }
/* 232 */     return new BigDecimal(result.toString());
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.util.base.MapParserUtil
 * JD-Core Version:    0.7.0.1
 */