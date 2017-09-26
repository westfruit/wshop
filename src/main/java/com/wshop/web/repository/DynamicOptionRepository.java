package com.wshop.web.repository;

import com.wshop.web.dto.DynamicOptionDTO;
import java.util.List;

public abstract interface DynamicOptionRepository
{
  public abstract List<DynamicOptionDTO> findAllByAttributeId(String paramString);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.DynamicOptionRepository
 * JD-Core Version:    0.7.0.1
 */