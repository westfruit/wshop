/*     */ package com.wshop.web.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProductDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3264773012421841094L;
/*     */   @JsonProperty("ProductId")
/*  30 */   private Integer productid = Integer.valueOf(0);
/*     */   @JsonProperty("Title")
/*  33 */   private String title = "";
/*     */   @JsonProperty("SearchTitle")
/*  37 */   private String searchtitle = "";
/*     */   @JsonProperty("Summery")
/*  41 */   private String summery = "";
/*     */   @JsonProperty("CateId")
/*  46 */   private Integer cateid = Integer.valueOf(0);
/*     */   @JsonProperty("CateName")
/*  49 */   private String catename = "";
/*     */   @JsonProperty("BrandName")
/*  53 */   private String brandname = "";
/*     */   @JsonProperty("ProductImg")
/*  57 */   private String productimg = "";
/*     */   @JsonProperty("SellPrice")
/*  61 */   private BigDecimal sellprice = new BigDecimal(0);
/*     */   @JsonProperty("ProductAlbum")
/*  65 */   private String productalbum = "";
/*     */   @JsonProperty("VerifyStatus")
/*  70 */   private Integer verifystatus = Integer.valueOf(0);
/*     */   @JsonProperty("ShelveStatus")
/*  74 */   private Integer shelvestatus = Integer.valueOf(0);
/*     */   @JsonProperty("UpdateTime")
/*  77 */   private Date updatetime = new Date();
/*     */   @JsonProperty("SkuList")
/*  80 */   private List<ProductSkuDTO> skuList = new ArrayList() {};
/*     */   @JsonProperty("AttributeList")
/*  83 */   private Collection<ProductAttributeDTO> attributelist = new ArrayList() {};
/*     */   @JsonProperty("AttributeMapList")
/*  86 */   private List<ProductAttributeDTO> attributeMaplist = new ArrayList() {};
/*     */   @JsonProperty("DynamicList")
/*  89 */   private List<DynamicDTO> dynamiclist = new ArrayList() {};
/*     */   @JsonProperty("DynamicMapList")
/*  92 */   private List<DynamicProductMapDTO> dynamicmaplist = new ArrayList() {};
/*     */   @JsonProperty("Album")
/*  95 */   private List<String> album = new ArrayList();
/*     */   @JsonProperty("Content")
/*  98 */   private String content = "";
/*     */   @JsonProperty("ServiceInfo")
/* 101 */   private String serviceinfo = "";
/*     */   @JsonProperty("ProductRelatedList")
/* 104 */   private List<ProductRelatedMapDTO> productrelatedlist = new ArrayList() {};
/*     */   @JsonProperty("ProductGiftList")
/* 107 */   private List<ProductGiftMapDTO> productgiftlist = new ArrayList() {};
/*     */   
/*     */   public List<String> getAlbum()
/*     */   {
/* 116 */     if ((null != this.productalbum) && (this.productalbum.length() > 0)) {
/* 117 */       return Arrays.asList(this.productalbum.trim().split(","));
/*     */     }
/* 119 */     return this.album;
/*     */   }
/*     */   
/*     */   public void setAlbum(List<String> list)
/*     */   {
/* 128 */     this.album = list;
/*     */   }
/*     */   
/*     */   public Collection<ProductAttributeDTO> getAttributelist()
/*     */   {
/* 136 */     return this.attributelist;
/*     */   }
/*     */   
/*     */   public void setAttributelist(Collection<ProductAttributeDTO> list)
/*     */   {
/* 145 */     this.attributelist = list;
/*     */   }
/*     */   
/*     */   public List<ProductAttributeDTO> getAttributemapList()
/*     */   {
/* 154 */     return this.attributeMaplist;
/*     */   }
/*     */   
/*     */   public void setAttributemapList(List<ProductAttributeDTO> attributeMaplist)
/*     */   {
/* 163 */     this.attributeMaplist = attributeMaplist;
/*     */   }
/*     */   
/*     */   public List<ProductSkuDTO> getSkuList()
/*     */   {
/* 172 */     return this.skuList;
/*     */   }
/*     */   
/*     */   public void setSkuList(List<ProductSkuDTO> list)
/*     */   {
/* 181 */     this.skuList = list;
/*     */   }
/*     */   
/*     */   public Integer getProductid()
/*     */   {
/* 190 */     return this.productid;
/*     */   }
/*     */   
/*     */   public void setProductid(Integer productid)
/*     */   {
/* 199 */     this.productid = productid;
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/* 208 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title)
/*     */   {
/* 217 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getSearchtitle()
/*     */   {
/* 226 */     return this.searchtitle;
/*     */   }
/*     */   
/*     */   public void setSearchtitle(String searchtitle)
/*     */   {
/* 235 */     this.searchtitle = searchtitle;
/*     */   }
/*     */   
/*     */   public String getSummery()
/*     */   {
/* 244 */     return this.summery;
/*     */   }
/*     */   
/*     */   public void setSummery(String summery)
/*     */   {
/* 253 */     this.summery = summery;
/*     */   }
/*     */   
/*     */   public Integer getCateid()
/*     */   {
/* 262 */     return this.cateid;
/*     */   }
/*     */   
/*     */   public void setCateid(Integer cateid)
/*     */   {
/* 271 */     this.cateid = cateid;
/*     */   }
/*     */   
/*     */   public String getCatename()
/*     */   {
/* 280 */     return this.catename;
/*     */   }
/*     */   
/*     */   public void setCatename(String catename)
/*     */   {
/* 289 */     this.catename = catename;
/*     */   }
/*     */   
/*     */   public String getBrandname()
/*     */   {
/* 298 */     return this.brandname;
/*     */   }
/*     */   
/*     */   public void setBrandname(String brandname)
/*     */   {
/* 307 */     this.brandname = brandname;
/*     */   }
/*     */   
/*     */   public String getProductimg()
/*     */   {
/* 316 */     return this.productimg;
/*     */   }
/*     */   
/*     */   public void setProductimg(String productimg)
/*     */   {
/* 325 */     this.productimg = productimg;
/*     */   }
/*     */   
/*     */   public String getProductalbum()
/*     */   {
/* 334 */     return this.productalbum;
/*     */   }
/*     */   
/*     */   public void setProductalbum(String productalbum)
/*     */   {
/* 343 */     this.productalbum = productalbum;
/*     */   }
/*     */   
/*     */   public Integer getVerifystatus()
/*     */   {
/* 352 */     return this.verifystatus;
/*     */   }
/*     */   
/*     */   public void setVerifystatus(Integer verifystatus)
/*     */   {
/* 361 */     this.verifystatus = verifystatus;
/*     */   }
/*     */   
/*     */   public Integer getShelvestatus()
/*     */   {
/* 370 */     return this.shelvestatus;
/*     */   }
/*     */   
/*     */   public void setShelvestatus(Integer shelvestatus)
/*     */   {
/* 379 */     this.shelvestatus = shelvestatus;
/*     */   }
/*     */   
/*     */   public Date getUpdatetime()
/*     */   {
/* 388 */     return this.updatetime;
/*     */   }
/*     */   
/*     */   public void setUpdatetime(Date updatetime)
/*     */   {
/* 397 */     this.updatetime = updatetime;
/*     */   }
/*     */   
/*     */   public String getContent()
/*     */   {
/* 412 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content)
/*     */   {
/* 421 */     this.content = content;
/*     */   }
/*     */   
/*     */   public String getServiceinfo()
/*     */   {
/* 431 */     return this.serviceinfo;
/*     */   }
/*     */   
/*     */   public void setServiceinfo(String serviceinfo)
/*     */   {
/* 440 */     this.serviceinfo = serviceinfo;
/*     */   }
/*     */   
/*     */   public List<ProductRelatedMapDTO> getProductrelatedlist()
/*     */   {
/* 444 */     return this.productrelatedlist;
/*     */   }
/*     */   
/*     */   public void setProductrelatedlist(List<ProductRelatedMapDTO> productrelatedlist)
/*     */   {
/* 448 */     this.productrelatedlist = productrelatedlist;
/*     */   }
/*     */   
/*     */   public List<ProductGiftMapDTO> getProductgiftlist()
/*     */   {
/* 452 */     return this.productgiftlist;
/*     */   }
/*     */   
/*     */   public void setProductgiftlist(List<ProductGiftMapDTO> productgiftlist)
/*     */   {
/* 456 */     this.productgiftlist = productgiftlist;
/*     */   }
/*     */   
/*     */   public List<DynamicDTO> getDynamiclist()
/*     */   {
/* 460 */     return this.dynamiclist;
/*     */   }
/*     */   
/*     */   public void setDynamiclist(List<DynamicDTO> dynamiclist)
/*     */   {
/* 464 */     this.dynamiclist = dynamiclist;
/*     */   }
/*     */   
/*     */   public List<DynamicProductMapDTO> getDynamicmaplist()
/*     */   {
/* 468 */     return this.dynamicmaplist;
/*     */   }
/*     */   
/*     */   public void setDynamicmaplist(List<DynamicProductMapDTO> dynamicmaplist)
/*     */   {
/* 472 */     this.dynamicmaplist = dynamicmaplist;
/*     */   }
/*     */   
/*     */   public BigDecimal getSellprice()
/*     */   {
/* 476 */     return this.sellprice;
/*     */   }
/*     */   
/*     */   public void setSellprice(BigDecimal sellprice)
/*     */   {
/* 480 */     this.sellprice = sellprice;
/*     */   }
/*     */ }


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.dto.ProductDTO
 * JD-Core Version:    0.7.0.1
 */