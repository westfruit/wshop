/*     */ package com.wshop.web.controller;
/*     */ 
/*     */ import com.wshop.web.dto.DynamicProductMapDTO;
/*     */ import com.wshop.web.dto.ProductAttributeDTO;
/*     */ import com.wshop.web.dto.ProductAttributeValueDTO;
/*     */ import com.wshop.web.dto.ProductDTO;
/*     */ import com.wshop.web.dto.ProductGiftMapDTO;
/*     */ import com.wshop.web.dto.ProductRelatedMapDTO;
/*     */ import com.wshop.web.dto.ProductSkuDTO;
/*     */ import com.wshop.web.service.BaseService;
/*     */ import com.wshop.web.service.DynamicService;
/*     */ import com.wshop.web.service.ProductAttributeService;
/*     */ import com.wshop.web.service.ProductService;
/*     */ import com.wshop.web.service.ProductSkuService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/"})
/*     */ @CrossOrigin(allowedHeaders={"*"}, allowCredentials="true")
/*     */ public class DefaultController
/*     */ {
/*     */   @Autowired
/*     */   ProductService productService;
/*     */   @Autowired
/*     */   ProductAttributeService productAttributeService;
/*     */   @Autowired
/*     */   ProductSkuService productSkuService;
/*     */   @Autowired
/*     */   DynamicService dynamicService;
/*     */   @Autowired
/*     */   BaseService baseService;
/*  34 */   Integer userId = Integer.valueOf(2);
/*     */   
/*     */   @RequestMapping(value={"/detail/{productid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String Detail(@PathVariable int productid, Map<String, Object> map)
/*     */   {
/*  39 */     ProductDTO product = null;
/*  40 */     if (productid > 0) {
/*  41 */       product = this.productService.findProductById(Integer.valueOf(productid), this.userId);
/*     */     }
/*  43 */     if (null == product) {
/*  44 */       product = new ProductDTO();
/*     */     }
/*  48 */     map.put("ProductId", product.getProductid());
/*  49 */     map.put("Content", product.getContent());
/*  50 */     return "Detail";
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/admin/{productid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String ProductEdit(@PathVariable int productid, Map<String, Object> map)
/*     */   {
/*  56 */     ProductDTO product = new ProductDTO();
/*  57 */     if (productid > 0) {
/*  58 */       product = this.productService.findProductById(Integer.valueOf(productid), this.userId);
/*     */     } else {
/*  60 */       product.setProductid(this.baseService.getNewIntegerId());
/*     */     }
/*  63 */     map.put("ProductId", product.getProductid());
/*  64 */     map.put("CateId", product.getCateid());
/*  65 */     map.put("CateName", product.getCatename());
/*  66 */     map.put("BrandName", product.getBrandname());
/*  67 */     map.put("Content", product.getContent());
/*  68 */     map.put("ServiceInfo", product.getServiceinfo());
/*  69 */     return "ProductEdit";
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/admin/{productid}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String ProductSave(@PathVariable int productid, HttpServletRequest request, Map<String, Object> map)
/*     */   {
/*  77 */     String title = request.getParameter("Title");
/*  78 */     String searchTitle = request.getParameter("SearchTitle");
/*  79 */     String summery = request.getParameter("Summery");
/*  80 */     Integer cateId = Integer.valueOf(Integer.valueOf(request.getParameter("CateId")).intValue());
/*  81 */     String cateName = request.getParameter("CateName");
/*  82 */     String brandName = request.getParameter("BrandName");
/*  83 */     String productImg = request.getParameter("ProductImg");
/*  84 */     String productAlbum = request.getParameter("ProductAlbum");
/*  85 */     String content = request.getParameter("Content");
/*  86 */     String serviceInfo = request.getParameter("ServiceInfo");
/*     */     
/*  88 */     ProductDTO product = this.productService.findProductById(Integer.valueOf(productid), this.userId);
/*  89 */     product.setTitle(title);
/*  90 */     product.setSearchtitle(searchTitle);
/*  91 */     product.setSummery(summery);
/*  92 */     product.setCateid(cateId);
/*  93 */     product.setCatename(cateName);
/*  94 */     product.setBrandname(brandName);
/*  95 */     product.setProductimg(productImg);
/*  96 */     product.setProductalbum(productAlbum);
/*  97 */     product.setContent(content);
/*  98 */     product.setServiceinfo(serviceInfo);
/*     */     
/*     */ 
/*     */ 
/* 102 */     String[] ParaGiftList = request.getParameterValues("GiftId");
/* 103 */     List<ProductGiftMapDTO> ProductGiftList = new ArrayList();
/*     */     String para;
/* 104 */     if ((null != ParaGiftList) && (ParaGiftList.length > 0)) {
/* 105 */       for (para : ParaGiftList) {
/*     */         try
/*     */         {
/* 107 */           ProductGiftMapDTO gift = new ProductGiftMapDTO();
/* 108 */           gift.setProductid(product.getProductid());
/* 109 */           gift.setProductid2(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 110 */           ProductGiftList.add(gift);
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/*     */     }
/* 117 */     product.setProductgiftlist(ProductGiftList);
/*     */     
/*     */ 
/*     */ 
/* 121 */     String[] ParaRelatedList = request.getParameterValues("RelatedId");
/* 122 */     Object ProductRelatedList = new ArrayList();
/*     */     String para;
/* 123 */     if ((null != ParaRelatedList) && (ParaRelatedList.length > 0))
/*     */     {
/* 124 */       String[] arrayOfString2 = ParaRelatedList;para = arrayOfString2.length;
/* 124 */       for (localException = 0; localException < para; localException++)
/*     */       {
/* 124 */         para = arrayOfString2[localException];
/*     */         try
/*     */         {
/* 126 */           ProductRelatedMapDTO related = new ProductRelatedMapDTO();
/* 127 */           related.setProductid(product.getProductid());
/* 128 */           related.setProductid2(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 129 */           ((List)ProductRelatedList).add(related);
/*     */         }
/*     */         catch (Exception localException1) {}
/*     */       }
/*     */     }
/* 136 */     product.setProductrelatedlist((List)ProductRelatedList);
/*     */     
/*     */ 
/*     */ 
/* 140 */     String[] ParaAttrList = request.getParameterValues("AttrvalueId");
/* 141 */     List<ProductAttributeDTO> AttrList = new ArrayList();
/*     */     String para;
/* 142 */     if ((null != ParaAttrList) && (ParaAttrList.length > 0))
/*     */     {
/* 143 */       localException = ParaAttrList;para = localException.length;
/* 143 */       for (localException1 = 0; localException1 < para; localException1++)
/*     */       {
/* 143 */         para = localException[localException1];
/*     */         try
/*     */         {
/* 145 */           ProductAttributeDTO attr = new ProductAttributeDTO();
/* 146 */           attr.setAttributeid(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 147 */           attr.setAttributename(request.getParameter("AttributeName_" + para));
/* 148 */           attr.setProductid(product.getProductid());
/* 149 */           AttrList.add(attr);
/*     */         }
/*     */         catch (Exception localException2) {}
/*     */       }
/*     */     }
/* 156 */     product.setAttributemapList(AttrList);
/*     */     
/*     */ 
/*     */ 
/* 160 */     String[] ParaOptionList = request.getParameterValues("OptionId");
/* 161 */     List<ProductAttributeValueDTO> AttrValueList = new ArrayList();
/*     */     String para;
/* 162 */     if ((null != ParaOptionList) && (ParaOptionList.length > 0))
/*     */     {
/* 163 */       localException1 = ParaOptionList;para = localException1.length;
/* 163 */       for (localException2 = 0; localException2 < para; localException2++)
/*     */       {
/* 163 */         para = localException1[localException2];
/*     */         try
/*     */         {
/* 165 */           ProductAttributeValueDTO attr = new ProductAttributeValueDTO();
/* 166 */           attr.setOptionid(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 167 */           attr.setOptionname(request.getParameter("OptionName_" + para));
/* 168 */           attr.setOptionimg(request.getParameter("OptionImg_" + para));
/* 169 */           attr.setAttributeid(Integer.valueOf(Integer.valueOf(request.getParameter("AttributeId_" + para)).intValue()));
/* 170 */           attr.setAttributename(request.getParameter("AttributeName_" + para));
/* 171 */           attr.setProductid(product.getProductid());
/* 172 */           AttrValueList.add(attr);
/*     */         }
/*     */         catch (Exception localException3) {}
/*     */       }
/*     */     }
/* 181 */     String[] ParaDynamicList = request.getParameterValues("DynamicId");
/* 182 */     List<DynamicProductMapDTO> DynamicList = new ArrayList();
/*     */     String para;
/* 183 */     if ((null != ParaDynamicList) && (ParaDynamicList.length > 0))
/*     */     {
/* 184 */       localException2 = ParaDynamicList;para = localException2.length;
/* 184 */       for (localException3 = 0; localException3 < para; localException3++)
/*     */       {
/* 184 */         para = localException2[localException3];
/*     */         try
/*     */         {
/* 186 */           String[] optionList = request.getParameterValues("Dynamic_" + para);
/* 187 */           if (null != optionList) {
/* 188 */             for (String optionValue : optionList)
/*     */             {
/* 189 */               DynamicProductMapDTO dynamic = new DynamicProductMapDTO();
/* 190 */               dynamic.setProductid(product.getProductid());
/* 191 */               dynamic.setAttributeid(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 192 */               dynamic.setOptionvalue(optionValue);
/* 193 */               DynamicList.add(dynamic);
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException4) {}
/*     */       }
/*     */     }
/* 204 */     String[] ParaSkuList = request.getParameterValues("SkuId");
/* 205 */     List<ProductSkuDTO> Skulist = new ArrayList();
/* 206 */     if ((null != ParaSkuList) && (ParaSkuList.length > 0))
/*     */     {
/* 207 */       localException3 = ParaSkuList;para = localException3.length;
/* 207 */       for (localException4 = 0; localException4 < para; localException4++)
/*     */       {
/* 207 */         String para = localException3[localException4];
/*     */         try
/*     */         {
/* 209 */           ProductSkuDTO sku = new ProductSkuDTO();
/* 210 */           sku.setProductid(product.getProductid());
/* 211 */           sku.setSkuid(Integer.valueOf(Integer.valueOf(para).intValue()));
/* 212 */           sku.setSkuprice(new BigDecimal(request.getParameter("SkuPrice_" + para)));
/* 213 */           sku.setStockquantity(Integer.valueOf(Integer.valueOf(request.getParameter("StockQuantity_" + para)).intValue()));
/* 214 */           sku.setCommoditycode(request.getParameter("CommodityCode_" + para));
/* 215 */           sku.setSkuimg1(request.getParameter("SkuImg1_" + para));
/* 216 */           sku.setSkuimg2(request.getParameter("SkuImg2_" + para));
/* 217 */           sku.setAttributes(request.getParameter("Attributes_" + para));
/* 218 */           sku.setAttributename(request.getParameter("CombineName_" + para));
/* 219 */           sku.setAttributes(request.getParameter("CombineId_" + para));
/* 220 */           sku.setIsdelete(Integer.valueOf(Integer.valueOf(request.getParameter("IsDelete_" + para)).intValue()));
/* 222 */           if ((sku.getIsdelete().compareTo(Integer.valueOf(1)) == 0) || (sku.getSkuprice().compareTo(new BigDecimal(0)) < 1) || 
/* 223 */             (sku.getCommoditycode() == null) || (sku.getCommoditycode().isEmpty()))
/*     */           {
/* 224 */             sku.setIsdelete(Integer.valueOf(1));
/* 225 */             sku.setStockquantity(Integer.valueOf(0));
/*     */           }
/*     */           else
/*     */           {
/* 227 */             product.setSellprice(sku.getSkuprice());
/*     */           }
/* 229 */           Skulist.add(sku);
/*     */         }
/*     */         catch (Exception localException6) {}
/*     */       }
/*     */     }
/* 239 */     List<ProductSkuDTO> delSkuList = new ArrayList();
/* 240 */     for (ProductSkuDTO skuold : product.getSkuList())
/*     */     {
/* 241 */       boolean flag = false;
/* 242 */       skuold.setIsdelete(Integer.valueOf(1));
/* 243 */       for (ProductSkuDTO skunew : Skulist) {
/* 244 */         if (skuold.getSkuid().intValue() == skunew.getSkuid().intValue())
/*     */         {
/* 245 */           flag = true;
/* 246 */           break;
/*     */         }
/*     */       }
/* 250 */       if (!flag)
/*     */       {
/* 251 */         skuold.setIsdelete(Integer.valueOf(1));
/* 252 */         delSkuList.add(skuold);
/*     */       }
/*     */     }
/* 257 */     for (ProductSkuDTO delsku : delSkuList) {
/* 259 */       Skulist.add(delsku);
/*     */     }
/* 262 */     product.setSkuList(Skulist);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 267 */     this.productAttributeService.replaceProductAttribute(AttrList);
/*     */     
/*     */ 
/* 270 */     this.productAttributeService.replaceProductAttributeMap(AttrValueList, product.getProductid());
/*     */     
/*     */ 
/* 273 */     this.productAttributeService.replaceProductAttributeValue(AttrValueList);
/*     */     
/*     */ 
/* 276 */     this.productSkuService.replaceProductSku(Skulist);
/*     */     
/*     */ 
/* 279 */     this.dynamicService.batchUpdateAttributeProductMap(DynamicList, product.getProductid());
/*     */     
/*     */ 
/* 282 */     this.productService.saveProduct(product);
/*     */     
/*     */ 
/*     */ 
/* 286 */     return "redirect:/admin/" + product.getProductid();
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.controller.DefaultController
 * JD-Core Version:    0.7.0.1
 */