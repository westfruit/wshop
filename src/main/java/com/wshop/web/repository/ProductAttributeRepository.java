package com.wshop.web.repository;

import com.wshop.web.dto.ProductAttributeDTO;
import java.util.List;

public abstract interface ProductAttributeRepository
{
  public abstract List<ProductAttributeDTO> findAllByProductId(Integer paramInteger);
  
  public abstract int replaceProductAttribute(List<ProductAttributeDTO> paramList);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.ProductAttributeRepository
 * JD-Core Version:    0.7.0.1
 */