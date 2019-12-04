package com.xmu.wowoto.aftersale.dao;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.mapper.AfterSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterSaleDao {
    @Autowired
    AfterSaleMapper afterSaleMapper;
    public void addAfterSale(AftersalesService ass){

    }
}
