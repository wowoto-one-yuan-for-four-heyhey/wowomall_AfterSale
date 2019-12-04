package com.xmu.wowoto.aftersale.mapper;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AfterSaleMapper {
    int addAfterSale(AftersalesService aftersalesService);
}
