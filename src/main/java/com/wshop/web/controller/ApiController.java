/*     */ package com.wshop.web.controller;
/*     */ 
/*     */ import com.wshop.web.dto.ProductDTO;
/*     */ import com.wshop.web.service.BrandService;
/*     */ import com.wshop.web.service.CategoryService;
/*     */ import com.wshop.web.service.DynamicService;
/*     */ import com.wshop.web.service.ProductAttributeService;
/*     */ import com.wshop.web.service.ProductService;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/api"})
/*     */ @CrossOrigin(allowedHeaders={"*"}, allowCredentials="true")
/*     */ public class ApiController
/*     */ {
/*     */   @Autowired
/*     */   ProductService productService;
/*     */   @Autowired
/*     */   ProductAttributeService productAttributeService;
/*     */   @Autowired
/*     */   DynamicService dynamicService;
/*     */   @Autowired
/*     */   CategoryService categoryService;
/*     */   @Autowired
/*     */   BrandService brandService;
/*  50 */   private Integer userId = Integer.valueOf(2);
/*  51 */   private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
/*     */   @Value("${server.upload.path}")
/*     */   private String ROOT;
/*     */   
/*     */   @RequestMapping({"/product/{productid}"})
/*     */   public Object Product(@PathVariable int productid)
/*     */   {
/*  57 */     Map<String, Object> map = new HashMap() {};
/*  58 */     map.put("nameKey", "Thymeleaf");
/*  59 */     map.put("name", "westfruit");
/*  60 */     ProductDTO product = new ProductDTO();
/*  61 */     if (productid > 0) {
/*  62 */       product = this.productService.findProductById(Integer.valueOf(productid), this.userId);
/*     */     }
/*  65 */     return product;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/productpage/{keyword}/{pagecurrent}/{pagesize}"})
/*     */   public Object Product(@PathVariable String keyword, @PathVariable Integer pagecurrent, @PathVariable Integer pagesize)
/*     */   {
/*  70 */     Map<String, Object> map = new HashMap() {};
/*  71 */     map.put("nameKey", "Thymeleaf");
/*  72 */     map.put("name", "westfruit");
/*     */     
/*  74 */     String where = " ";
/*  75 */     if ((null != keyword) && (!keyword.isEmpty())) {
/*  76 */       where = " and SearchTitle like '%" + keyword + "%'";
/*     */     }
/*  78 */     return this.productService.findAllPage(pagecurrent, pagesize, where);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/attribute"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public Object GetAttributeByCategoryAndProductId(@RequestParam int categoryId, @RequestParam int productId)
/*     */   {
/*  99 */     return this.dynamicService.findAllByCategoryIdProductId(Integer.valueOf(categoryId), Integer.valueOf(productId));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/category/{parentId}"})
/*     */   public Object GetCategoryByParentId(@PathVariable int parentId)
/*     */   {
/* 103 */     return this.categoryService.findAllByParentId(Integer.valueOf(parentId));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/brand"})
/*     */   public Object GetAllBrand()
/*     */   {
/* 107 */     return this.brandService.findAll();
/*     */   }
/*     */   
/*     */   @RequestMapping({"/brand/{keyword}"})
/*     */   public Object GetBrandByKeyword(@PathVariable String keyword)
/*     */   {
/* 111 */     return this.brandService.findAllByKeyword(keyword);
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.controller.ApiController
 * JD-Core Version:    0.7.0.1
 */