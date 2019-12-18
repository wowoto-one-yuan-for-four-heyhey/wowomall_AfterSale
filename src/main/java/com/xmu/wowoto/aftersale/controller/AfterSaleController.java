package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.domain.Log;
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
    public Object adminFindAftersalesServiceList(Integer userId,Integer limit,Integer page) {

        if(page==null || limit==null || page < 1 || limit < 1)
        {
            return ResponseUtil.fail(402,"参数值不对");
        }

        Integer begin=limit*(page-1);
        List<AftersalesService> assList;

        if(userId!=null)
        {
            assList=afterSaleService.findAfterSaleByUserId(userId,begin,limit);
        }
        else
        {
             assList = afterSaleService.findAllAfterSale(begin, limit);
        }
        Log log=new Log();
        log.setType(0);
        log.setStatusCode(1);
        log.setActionId(1);
        log.setActions("管理员查看售后列表");
        return ResponseUtil.ok(assList);
    }

    @GetMapping("admin/afterSaleServices/{id}")
    public Object adminFindAftersalesService(@PathVariable("id") Integer id){
        if(id==null || id < 1)
        {    return ResponseUtil.fail(402,"参数值不对");}
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Log log=new Log();
        log.setType(0);
        log.setStatusCode(1);
        log.setActionId(1);
        log.setActions("管理员查看售后服务"+ass.getId());
        return ResponseUtil.ok(ass);
    }

    @PutMapping("admin/afterSaleServices/{id}")
    public Object adminUpdateAftersalesService(@PathVariable("id")Integer id, @RequestBody AftersalesService avo){
        if(id==null)
        {
            return ResponseUtil.fail(402,"参数值不对");
        }
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(507,"非法操作");
        }
        if(avo.getStatusCode()==null)
        {
            return ResponseUtil.fail(402,"参数值不对");
        }
        AftersalesService ass = new AftersalesService();
        ass.setStatusCode(avo.getStatusCode());
        AftersalesService retass=afterSaleService.updateUser(id,ass);
        if(retass!=null)
        {
            Log log=new Log();
            log.setType(2);
            log.setStatusCode(1);
            log.setActionId(1);
            log.setActions("管理员修改售后服务"+retass.getId());
            return ResponseUtil.ok(retass);
        }
        else
        {
            return ResponseUtil.fail(505,"更新数据失败");
        }
    }

    @GetMapping("afterSaleServices")
    public Object userFindAftersalesServiceList(Integer limit,Integer page) {
        if(page==null || limit==null|| page < 1||limit < 1){
            return ResponseUtil.fail(402,"参数值不对");}
        Integer begin=limit*(page-1);
        Integer userId= Integer.valueOf(request.getHeader("id"));
    return ResponseUtil.ok(afterSaleService.findAfterSaleByUserId(userId,begin,limit));
    }

    @PostMapping("afterSaleServices")
    public Object userApplyAftersalesService(@RequestBody AftersalesService asvo){
        if((asvo.getType()==null)||(asvo.getApplyReason()==null)
        ||(asvo.getNumber()==null)||(asvo.getOrderItemId()==null))
        {
            return ResponseUtil.fail(402,"参数值不对");
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
            return ResponseUtil.fail(505,"更新数据失败");
        }
    }

    @GetMapping("afterSaleServices/{id}")
    public Object userFindAftersaleService(@PathVariable("id") Integer id){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Integer expect=afterSaleService.getUserIdById(id);
        if(expect == null )
        {return ResponseUtil.fail(507,"非法操作");}
        if(!expect.equals(userId) )
        {return ResponseUtil.fail(506,"无操作权限");}
        AftersalesService ass=afterSaleService.getAfterSale(id);
        return ResponseUtil.ok(ass);
    }

    @PutMapping("afterSaleServices/{id}")
    public Object userUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AftersalesService avo){
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(507,"非法操作");
        }
        if((avo.getType()==null)||(avo.getNumber()==null)||(avo.getApplyReason()==null)){
            return ResponseUtil.fail(402,"参数值不对");
        }
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApplyReason());
        ass.setNumber(avo.getNumber());
        AftersalesService ret=afterSaleService.updateUser(id,ass);
        if(ret!=null)
        {return ResponseUtil.ok(ret);}
        else
        {
            return ResponseUtil.fail(505,"更新数据失败");
        }
    }

    @DeleteMapping("aftersaleServices/{id}")
    public Object userDeleteAftersaleService(@PathVariable("id")Integer id){
        if(!afterSaleService.deleteAfterSale(id))  {
            return ResponseUtil.fail(505,"更新数据失败");
        }
        else
        {return ResponseUtil.ok(true);}
    }
}
