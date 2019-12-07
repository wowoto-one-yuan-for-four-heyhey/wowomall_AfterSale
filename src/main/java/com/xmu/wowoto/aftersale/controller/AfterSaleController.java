package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.controller.vo.AfterSaleVO;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.service.AfterSaleService;
import com.xmu.wowoto.aftersale.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AfterSaleController {
    @Autowired
    AfterSaleService afterSaleService;

    @PostMapping("afterSaleService/")
    public Object addAfterSale(@RequestBody AfterSaleVO asvo) {
        AftersalesService ass = new AftersalesService();
        ass.setType(asvo.getType());
        ass.setGoodsType(asvo.getGoods_type());
        ass.setApplyReason(asvo.getApply_reason());
        ass.setNumber(asvo.getNumber());
        ass.setOrderItemId(asvo.getOrder_item_id());
        AftersalesService retass=afterSaleService.addAfterSale(ass);
        Object retObj = ResponseUtil.ok(retass);
        //logger.debug("submit的返回值："+retObj);
        return retObj;
    }
    @GetMapping("afterSaleService/{id}")
    public Object getAfterSale(@PathVariable("id") Integer id)
    {
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Object ret=ResponseUtil.ok(ass);
        return ret;
    }
}
