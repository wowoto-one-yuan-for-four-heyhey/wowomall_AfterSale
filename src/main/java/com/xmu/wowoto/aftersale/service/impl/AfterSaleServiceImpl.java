package com.xmu.wowoto.aftersale.service.impl;

import com.xmu.wowoto.aftersale.dao.AfterSaleDao;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.service.AfterSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService {

    @Autowired
    AfterSaleDao afterSaleDao;

    @Override
    public AftersalesService addAfterSale(AftersalesService ass) {
        Integer ret=afterSaleDao.addAfterSale(ass);
        if(ret!=0)
        { Integer id= ass.getId();
        return afterSaleDao.getAfterSale(id);
        }
        else return null;
    }
    @Override
    public AftersalesService getAfterSale(Integer id) {

        return afterSaleDao.getAfterSale(id);
    }
    @Override
    public boolean deleteAfterSale(Integer id){
        AftersalesService ass=new AftersalesService();
        ass.setId(id);
        ass.setBeDeleted(true);
        int result=afterSaleDao.updateAfterSale(ass);
        return (result!=0);
    }
    @Override
    public boolean applyAfterSale(Integer id){
        int result=afterSaleDao.applyAfterSale(id);
        return (result!=0);
    }
    @Override
    public AftersalesService updateUser(Integer id,AftersalesService ass){
        afterSaleDao.updateAfterSale(ass);
        return afterSaleDao.getAfterSale(id);
    }
    @Override
    public List<AftersalesService> findAllAfterSale(Integer begin,Integer limit) {
    return afterSaleDao.findAllAfterSale(begin,limit);
    }
    @Override
    public Integer getUserIdById(Integer id){return afterSaleDao.getUserIdById(id);}
    @Override
    public List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit){return afterSaleDao.findAfterSaleByUserId(id,begin,limit);}
}
