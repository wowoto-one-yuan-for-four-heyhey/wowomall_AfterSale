package com.xmu.wowoto.aftersale.service;

import com.xmu.wowoto.aftersale.dao.AfterSaleDao;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AfterSaleService {

    @Autowired
    AfterSaleDao afterSaleDao;
    public AftersalesService addAfterSale(AftersalesService ass) {
        afterSaleDao.addAfterSale(ass);
        Integer id= ass.getId();
        AftersalesService ret=afterSaleDao.getAfterSale(id);
        return ret;
    }
    public AftersalesService getAfterSale(Integer id)
    {
        AftersalesService ret =afterSaleDao.getAfterSale(id);
        return ret;
    }
}
