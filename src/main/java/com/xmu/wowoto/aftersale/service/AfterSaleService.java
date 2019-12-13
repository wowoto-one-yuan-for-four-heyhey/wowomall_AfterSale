package com.xmu.wowoto.aftersale.service;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@Service
public interface AfterSaleService {
    public AftersalesService addAfterSale(AftersalesService ass);
    public AftersalesService getAfterSale(Integer id);
    public boolean deleteAfterSale(Integer id);
    public boolean applyAfterSale(Integer id);
    public AftersalesService updateUser(Integer id,AftersalesService ass);
    public List<AftersalesService> findAllAfterSale(Integer begin, Integer limit);
    public Integer getUserIdById(Integer id);
    public List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit);
}
