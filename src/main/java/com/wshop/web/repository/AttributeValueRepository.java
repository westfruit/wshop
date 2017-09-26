package com.wshop.web.repository;

import com.wshop.web.dto.ProductAttributeValueDTO;
import java.util.List;

public abstract interface AttributeValueRepository
{
  public abstract List<ProductAttributeValueDTO> findAllByProductId(Integer paramInteger);
  
  public abstract int replaceProductAttributeValue(List<ProductAttributeValueDTO> paramList);
  
  public abstract int batchUpdateProductAttributeValue(List<ProductAttributeValueDTO> paramList);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.AttributeValueRepository
 * JD-Core Version:    0.7.0.1
 */