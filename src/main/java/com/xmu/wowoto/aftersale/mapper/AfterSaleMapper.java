package com.xmu.wowoto.aftersale.mapper;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@Mapper
@Repository
public interface AfterSaleMapper {
    int addAfterSale(AftersalesService aftersalesService);
    AftersalesService findAfterSaleById(Integer id);
    int updateAfterSale(AftersalesService aftersalesService);
    int applyAfterSale(Integer id);
    Integer getUserIdById(Integer id);
    List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit);
    List<AftersalesService> findAllAfterSale(Integer begin,Integer limit);
}
