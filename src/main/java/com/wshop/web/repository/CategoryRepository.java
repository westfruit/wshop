package com.wshop.web.repository;

import com.wshop.web.dto.CategoryDTO;
import java.util.List;

public abstract interface CategoryRepository
{
  public abstract List<CategoryDTO> findAllByParentId(Integer paramInteger);
}


/* Location:           H:\Java\SpringBoot\wshop-0.0.1-SNAPSHOT\BOOT-INF\classes\
 * Qualified Name:     com.wshop.web.repository.CategoryRepository
 * JD-Core Version:    0.7.0.1
 */