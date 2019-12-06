package com.xmu.wowoto.aftersale.mapper;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AfterSaleMapper {
    int addAfterSale(AftersalesService aftersalesService);

    AftersalesService findAfterSaleById(Integer id);
}
