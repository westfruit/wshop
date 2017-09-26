package com.wshop.web.repository;

import com.wshop.web.dto.BrandDTO;
import java.util.List;

public abstract interface BrandRepository
{
  public abstract List<BrandDTO> findAll();
  
  public abstract List<BrandDTO> findAllByKeyword(String paramString);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.BrandRepository
 * JD-Core Version:    0.7.0.1
 */