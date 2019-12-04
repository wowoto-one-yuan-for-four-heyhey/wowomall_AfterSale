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
        ass.setBeDelete(false);
        afterSaleDao.addAfterSale(ass);
        return ass;
    }
}
