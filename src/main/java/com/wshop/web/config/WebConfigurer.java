/*    */ package com.wshop.web.config;
/*    */ 
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ @Component
/*    */ class WebConfigurer
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry)
/*    */   {
/* 14 */     registry.addResourceHandler(new String[] { "/files/**" }).addResourceLocations(new String[] { "file:///D:/Java/SpringBoot/WShop/src/main/resources/static/upload/" });
/*    */   }
/*    */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.config.WebConfigurer
 * JD-Core Version:    0.7.0.1
 */