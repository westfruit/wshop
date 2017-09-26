package com.wshop.web.repository;

import com.wshop.web.dto.ProductDTO;
import com.wshop.web.dto.ProductGiftMapDTO;
import com.wshop.web.dto.ProductRelatedMapDTO;
import com.wshop.web.util.base.Page;
import java.util.List;

public abstract interface ProductRepository
{
  public abstract List<ProductDTO> findAll();
  
  public abstract ProductDTO findProductById(Integer paramInteger);
  
  public abstract Integer replaceProduct(ProductDTO paramProductDTO);
  
  public abstract Page<ProductDTO> findAllPage(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract List<ProductGiftMapDTO> findProductGiftByProductId(Integer paramInteger);
  
  public abstract List<ProductRelatedMapDTO> findProductRelatedByProductId(Integer paramInteger);
  
  public abstract Integer batchUpdateProductGift(List<ProductGiftMapDTO> paramList, Integer paramInteger);
  
  public abstract Integer batchUpdateProductRelated(List<ProductRelatedMapDTO> paramList, Integer paramInteger);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.ProductRepository
 * JD-Core Version:    0.7.0.1
 */