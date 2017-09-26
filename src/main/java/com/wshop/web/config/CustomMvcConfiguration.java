/*    */ package com.wshop.web.config;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.util.List;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.http.converter.HttpMessageConverter;
/*    */ import org.springframework.http.converter.StringHttpMessageConverter;
/*    */ import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ @Configuration
/*    */ public class CustomMvcConfiguration
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   @Bean
/*    */   public HttpMessageConverter<String> responseBodyConverter()
/*    */   {
/* 22 */     StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
/* 23 */     return converter;
/*    */   }
/*    */   
/*    */   public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
/*    */   {
/* 29 */     super.configureMessageConverters(converters);
/* 30 */     converters.add(responseBodyConverter());
/*    */   }
/*    */   
/*    */   public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
/*    */   {
/* 36 */     configurer.favorPathExtension(false);
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.config.CustomMvcConfiguration
 * JD-Core Version:    0.7.0.1
 */