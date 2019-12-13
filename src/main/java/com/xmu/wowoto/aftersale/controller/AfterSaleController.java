package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.controller.vo.AdminAfterSaleUpdateVO;
import com.xmu.wowoto.aftersale.controller.vo.AfterSaleUpdateVO;
import com.xmu.wowoto.aftersale.controller.vo.AfterSaleVO;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.service.OrderService;
import com.xmu.wowoto.aftersale.service.impl.AfterSaleServiceImpl;
import com.xmu.wowoto.aftersale.util.JacksonUtil;
import com.xmu.wowoto.aftersale.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@RestController
@RequestMapping("")
public class AfterSaleController {
    @Autowired
    AfterSaleServiceImpl afterSaleService;

    @Autowired
    OrderService orderService;

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
    public Object adminUpdateAftersalesService(@PathVariable("id")Integer id, @RequestBody AdminAfterSaleUpdateVO avo){
        if(id==null)
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(505,"数据不存在！");
        }
        if((avo.getBeApplied()==null)&&(avo.getStatus()==null))
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getStatus());
        ass.setApplyReason(avo.getBeApplied());
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
        if((asvo.getType()!=null)||(asvo.getApplyReason()==null)
        ||(asvo.getNumber()==null)||(asvo.getOrderItemId()==null))
        {
            return ResponseUtil.fail(402,"bad params!");
        }
        AftersalesService ass = new AftersalesService();
        Integer userId = Integer.valueOf(request.getHeader("id"));
        ass.setUserId(userId);
        ass.setType(asvo.getType());
        Object ret=orderService.findOrderItemType(asvo.getOrderItemId());
        Integer type= JacksonUtil.parseInteger(ret.toString(),"data");
        ass.setGoodsType(type);
        ass.setApplyReason(asvo.getApplyReason());
        ass.setNumber(asvo.getNumber());
        ass.setOrderItemId(asvo.getOrderItemId());
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
        ass.setApplyReason(avo.getApplyReason());
        ass.setStatusCode(avo.getStatusCode());
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
