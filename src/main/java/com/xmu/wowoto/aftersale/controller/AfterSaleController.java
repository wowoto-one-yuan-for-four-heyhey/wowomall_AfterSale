package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.controller.vo.AfterSaleUpdateVO;
import com.xmu.wowoto.aftersale.controller.vo.AfterSaleVO;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.service.AfterSaleService;
import com.xmu.wowoto.aftersale.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wowoto
 * @date 12/12/2019
 */
@RestController
@RequestMapping("")
public class AfterSaleController {
    @Autowired
    AfterSaleService afterSaleService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("admin/afterSaleServices")
    public Object adminFindAftersalesServiceList(Integer page,Integer limit)
    {

        if(page==null || limit==null || page < 1 || limit < 1)
        {
            return ResponseUtil.fail(402,"bad params!");
        }

        Integer begin=limit*(page-1);
        List<AftersalesService> assList=afterSaleService.findAllAfterSale(begin,limit);

        return ResponseUtil.ok(assList);
    }

    @GetMapping("afterSaleServices/{id}")
    public Object adminFindAftersalesService(@PathVariable("id") Integer id){
        if(id==null || id < 1)
        {    return ResponseUtil.fail(402,"bad params!");}
        AftersalesService ass=afterSaleService.getAfterSale(id);
        if(ass != null){
            return ResponseUtil.ok(ass);
        }else {
            return ResponseUtil.fail(402,"DB error!");
        }
    }


    @PutMapping("admin/afterSaleServices/{id}")
    public Object adminUpdateAftersalesService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(505,"数据不存在！");
        }
        if(id==null)
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        if((avo.getType()!=null)&&(avo.getApply_reason()==null)&&(avo.getStatus_code()==null))
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(avo.getStatus_code());
        AftersalesService retass=afterSaleService.updateUser(id,ass);
        if(retass!=null)
        {
            return ResponseUtil.ok(retass);
        }
        else
        {
            return ResponseUtil.fail(505,"Object dosen't exist!");
        }
    }

    @GetMapping("afterSaleServices")
    public Object userFindAftersalesServiceList(Integer page,Integer limit) {
        if(page==null || limit==null|| page < 1||limit < 1){
            return ResponseUtil.fail(402,"bad params!");}
        Integer begin=limit*(page-1);
        Integer userId= Integer.valueOf(request.getHeader("id"));
    return ResponseUtil.ok(afterSaleService.findAfterSaleByUserId(userId,begin,limit));
    }

    @PostMapping("afterSaleServices")
    public Object userApplyAftersalesService(@RequestBody AfterSaleVO asvo){
        if((asvo.getType()!=null)||(asvo.getApply_reason()==null)||(asvo.getGoods_type()==null)
        ||(asvo.getNumber()==null)||(asvo.getOrder_item_id()==null))
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        AftersalesService ass = new AftersalesService();
        Integer userId = Integer.valueOf(request.getHeader("id"));
        ass.setUserId(userId);
        ass.setType(asvo.getType());
        ass.setGoodsType(asvo.getGoods_type());
        ass.setApplyReason(asvo.getApply_reason());
        ass.setNumber(asvo.getNumber());
        ass.setOrderItemId(asvo.getOrder_item_id());
        AftersalesService retass=afterSaleService.addAfterSale(ass);
        if (retass!=null)
        {
            return ResponseUtil.ok(retass);
        }
        else
        {
            return ResponseUtil.fail(505,"Object dosen't exist!");
        }
    }

    @GetMapping("afterSaleServices/{id}")
    public Object userFindAftersaleService(@PathVariable("id") Integer id){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Integer expect=afterSaleService.getUserIdById(id);
        if(expect == null ||!expect.equals(userId) )
        {return ResponseUtil.fail(506,"Permission deny!");}
        AftersalesService ass=afterSaleService.getAfterSale(id);
        return ResponseUtil.ok(ass);
    }

    @PutMapping("afterSaleServices/{id}")
    public Object userUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(505,"数据不存在！");
        }
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(null);
        AftersalesService find = afterSaleService.getAfterSale(id);
        if(find != null) {
            return ResponseUtil.fail(506,"Permission deny!");
        }
        return afterSaleService.updateUser(id,ass);
    }

    @DeleteMapping("aftersaleServices/{id}")
    public Object userDeleteAftersaleService(@PathVariable("id")Integer id){
        return ResponseUtil.ok(afterSaleService.deleteAfterSale(id));
    }
}
