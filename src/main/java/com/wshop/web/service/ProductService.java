/*     */ package com.wshop.web.service;
/*     */ 
/*     */ import com.wshop.web.dto.DynamicDTO;
/*     */ import com.wshop.web.dto.DynamicProductMapDTO;
/*     */ import com.wshop.web.dto.ProductAttributeDTO;
/*     */ import com.wshop.web.dto.ProductAttributeValueDTO;
/*     */ import com.wshop.web.dto.ProductDTO;
/*     */ import com.wshop.web.repository.AttributeValueRepository;
/*     */ import com.wshop.web.repository.BaseRepository;
/*     */ import com.wshop.web.repository.DynamicProductMapRepository;
/*     */ import com.wshop.web.repository.ProductAttributeMapRepository;
/*     */ import com.wshop.web.repository.ProductAttributeRepository;
/*     */ import com.wshop.web.repository.ProductRepository;
/*     */ import com.wshop.web.repository.ProductSkuRepository;
/*     */ import com.wshop.web.util.base.Page;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class ProductService
/*     */ {
/*     */   @Autowired
/*     */   ProductRepository productRepository;
/*     */   @Autowired
/*     */   ProductSkuRepository productSkuRepository;
/*     */   @Autowired
/*     */   ProductAttributeMapRepository productAttributeMapRepository;
/*     */   @Autowired
/*     */   ProductAttributeRepository productAttributeRepository;
/*     */   @Autowired
/*     */   AttributeValueRepository attributeValueRepository;
/*     */   @Autowired
/*     */   BaseRepository baseRepository;
/*     */   @Autowired
/*     */   DynamicProductMapRepository dynamicProductMapRepository;
/*     */   @Autowired
/*     */   DynamicService dynamicService;
/*     */   
/*     */   public List<ProductDTO> findAll()
/*     */   {
/*  42 */     return this.productRepository.findAll();
/*     */   }
/*     */   
/*     */   public ProductDTO findProductById(Integer productId, Integer userId)
/*     */   {
/*  48 */     ProductDTO product = this.productRepository.findProductById(productId);
/*  49 */     if (null == product)
/*     */     {
/*  50 */       product = new ProductDTO();
/*  51 */       if (productId.intValue() > 0) {
/*  52 */         product.setProductid(productId);
/*     */       } else {
/*  55 */         product.setProductid(this.baseRepository.getNewIntegerId());
/*     */       }
/*     */     }
/*  59 */     product.setProductgiftlist(this.productRepository.findProductGiftByProductId(product.getProductid()));
/*  60 */     product.setProductrelatedlist(this.productRepository.findProductRelatedByProductId(product.getProductid()));
/*     */     
/*  62 */     product.setSkuList(this.productSkuRepository.getProductSkuByProductId(product.getProductid()));
/*  63 */     Collection<ProductAttributeDTO> skuAttribute = getAttributeByProductId(product.getProductid());
/*  64 */     product.setAttributelist(skuAttribute);
/*     */     
/*  66 */     List<DynamicDTO> dynamicList = this.dynamicService.findAllByCategoryIdProductId(product.getCateid(), product.getProductid());
/*  67 */     List<DynamicProductMapDTO> dynamicMapList = this.dynamicProductMapRepository.findAllByProductId(product.getProductid());
/*  68 */     if ((dynamicList != null) && (dynamicMapList != null)) {
/*  69 */       for (DynamicDTO dynamic : dynamicList)
/*     */       {
/*  70 */         String prompt = "";
/*  71 */         for (DynamicProductMapDTO map : dynamicMapList) {
/*  73 */           if (dynamic.getAttributeid().equals(map.getAttributeid())) {
/*  74 */             prompt = prompt + " " + map.getOptionvalue();
/*     */           }
/*     */         }
/*  77 */         dynamic.setPrompttext(prompt);
/*     */       }
/*     */     }
/*  82 */     product.setDynamiclist(dynamicList);
/*  83 */     product.setDynamicmaplist(dynamicMapList);
/*     */     
/*     */ 
/*     */ 
/*  87 */     return product;
/*     */   }
/*     */   
/*     */   public Page<ProductDTO> findAllPage(Integer pageCurrent, Integer pageSize, String where)
/*     */   {
/*  92 */     return this.productRepository.findAllPage(pageCurrent, pageSize, where);
/*     */   }
/*     */   
/*     */   public int saveProduct(ProductDTO product)
/*     */   {
/*  96 */     this.productRepository.batchUpdateProductGift(product.getProductgiftlist(), product.getProductid());
/*  97 */     this.productRepository.batchUpdateProductRelated(product.getProductrelatedlist(), product.getProductid());
/*     */     
/*  99 */     return this.productRepository.replaceProduct(product).intValue();
/*     */   }
/*     */   
/*     */   public Collection<ProductAttributeDTO> getAttributeByProductId(Integer productId)
/*     */   {
/* 104 */     List<ProductAttributeDTO> attributeList = this.productAttributeRepository.findAllByProductId(productId);
/* 105 */     if ((null == attributeList) || (attributeList.isEmpty())) {
/* 106 */       return new ArrayList();
/*     */     }
/* 109 */     HashMap<Integer, ProductAttributeDTO> hashMap = new HashMap();
/* 110 */     for (ProductAttributeDTO attr : attributeList) {
/* 111 */       hashMap.put(attr.getAttributeid(), attr);
/*     */     }
/* 114 */     Object maps = this.attributeValueRepository.findAllByProductId(productId);
/*     */     
/* 116 */     Integer attributeId = Integer.valueOf(0);
/* 120 */     for (ProductAttributeValueDTO value : (List)maps)
/*     */     {
/* 121 */       attributeId = value.getAttributeid();
/* 122 */       if (hashMap.containsKey(value.getAttributeid()))
/*     */       {
/* 123 */         ProductAttributeDTO attr = (ProductAttributeDTO)hashMap.get(attributeId);
/* 124 */         ((ProductAttributeDTO)hashMap.get(attributeId)).getValueList().add(value);
/*     */       }
/*     */     }
/* 128 */     return hashMap.values();
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.service.ProductService
 * JD-Core Version:    0.7.0.1
 */