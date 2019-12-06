package com.xmu.wowoto.aftersale.dao;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.mapper.AfterSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterSaleDao {
    @Autowired
    AfterSaleMapper afterSaleMapper;
    public int addAfterSale(AftersalesService ass){
        return afterSaleMapper.addAfterSale(ass);
    }
    public AftersalesService getAfterSale(Integer id) {return afterSaleMapper.findAfterSaleById(id);}
}
