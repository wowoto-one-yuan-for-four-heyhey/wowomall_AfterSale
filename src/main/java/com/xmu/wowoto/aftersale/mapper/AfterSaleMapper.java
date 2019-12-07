package com.xmu.wowoto.aftersale.mapper;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AfterSaleMapper {
    int addAfterSale(AftersalesService aftersalesService);

    AftersalesService findAfterSaleById(Integer id);
    int updateAfterSale(AftersalesService aftersalesService);
    int applyAfterSale(Integer id);

    List<AftersalesService> findAllAfterSale();
}
