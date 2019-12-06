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
    public AftersalesService refund(AftersalesService ass) {
        ass.setType(false);
        ass.setBeApplied(false);
        ass.setBeDeleted(false);
        afterSaleDao.addAfterSale(ass);
        Integer id= ass.getId();
        AftersalesService ret=afterSaleDao.getAfterSale(id);
        return ret;
    }
    public AftersalesService exchange(AftersalesService ass)
    {
        ass.setType(true);
        ass.setBeApplied(false);
        ass.setBeDeleted(false);
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
