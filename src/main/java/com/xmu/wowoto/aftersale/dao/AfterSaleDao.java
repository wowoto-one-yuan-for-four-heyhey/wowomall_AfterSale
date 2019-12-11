package com.xmu.wowoto.aftersale.dao;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.mapper.AfterSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AfterSaleDao {
    @Autowired
    AfterSaleMapper afterSaleMapper;
    public int addAfterSale(AftersalesService ass){
        return afterSaleMapper.addAfterSale(ass);
    }
    public AftersalesService getAfterSale(Integer id) {
        AftersalesService as = afterSaleMapper.findAfterSaleById(id);
        as.setBeDeleted(false);
        return as;
    }
    public int updateAfterSale(AftersalesService ass){return afterSaleMapper.updateAfterSale(ass);}
    public int applyAfterSale(Integer id){return afterSaleMapper.applyAfterSale(id);}
    public List<AftersalesService> findAllAfterSale(Integer begin,Integer limit){return afterSaleMapper.findAllAfterSale(begin,limit);}
    public List<AftersalesService> findAfterSaleByUserId(Integer id){return afterSaleMapper.findAfterSaleByUserId(id);}
}
