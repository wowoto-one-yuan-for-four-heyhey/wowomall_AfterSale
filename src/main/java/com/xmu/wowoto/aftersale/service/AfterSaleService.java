package com.xmu.wowoto.aftersale.service;

import com.xmu.wowoto.aftersale.dao.AfterSaleDao;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public AftersalesService getAfterSale(Integer id) {
        AftersalesService ret = afterSaleDao.getAfterSale(id);
        return ret;
    }
    public boolean deleteAfterSale(Integer id){
        AftersalesService ass=new AftersalesService();
        ass.setId(id);
        ass.setBeDeleted(true);
        int result=afterSaleDao.updateAfterSale(ass);
        if(result!=0){
        return true;}
        else {return false;}
    }
    public boolean applyAfterSale(Integer id){
        int result=afterSaleDao.applyAfterSale(id);
        if(result!=0) {
            return true;
        }else {return false;
    }
    }
    public AftersalesService updateUser(Integer id,AftersalesService ass){
        afterSaleDao.updateAfterSale(ass);
        return afterSaleDao.getAfterSale(id);
    }
    public List<AftersalesService> findAllAfterSale(Integer begin,Integer limit) {
    return afterSaleDao.findAllAfterSale(begin,limit);
    }
    public Integer getUserIdById(Integer id){return afterSaleDao.getUserIdById(id);}
    public List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit){return afterSaleDao.findAfterSaleByUserId(id,begin,limit);}
}
