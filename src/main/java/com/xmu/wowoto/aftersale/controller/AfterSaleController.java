package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.domain.Log;
import com.xmu.wowoto.aftersale.service.OrderService;
import com.xmu.wowoto.aftersale.service.impl.AfterSaleServiceImpl;
import com.xmu.wowoto.aftersale.util.JacksonUtil;
import com.xmu.wowoto.aftersale.util.ResponseCode;
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
    public Object adminFindAftersalesServiceList(Integer userId,
                                                 @RequestParam(defaultValue = "10") Integer limit,
                                                 @RequestParam(defaultValue = "1") Integer page) {
        Integer adminId =Integer.valueOf(request.getHeader("id"));
        if(adminId < 1 ){
            return ResponseUtil.unlogin();
        }
        if(page==null || limit==null || page < 1 || limit < 1)
        {
            return ResponseUtil.fail(402,"参数值不对");
        }

        Integer begin=limit*(page-1);
        List<AftersalesService> assList;

        if(userId!=null)
        {
            if(userId < 1){
                return ResponseUtil.badArgumentValue();
            }

            assList=afterSaleService.findAfterSaleByUserId(userId,begin,limit);
            if(assList == null){
                return ResponseUtil.fail(ResponseCode.GET_FAILED.getCode(),
                        ResponseCode.GET_FAILED.getMessage());
            }
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
        Integer adminId =Integer.valueOf(request.getHeader("id"));
        if(adminId < 1 ){
            return ResponseUtil.unlogin();
        }
        if(id==null || id < 1)
        {    return ResponseUtil.fail(402,"参数值不对");}
        AftersalesService ass=afterSaleService.getAfterSale(id);
        if(ass == null){
            return ResponseUtil.fail(ResponseCode.GET_FAILED.getCode(),
                    ResponseCode.GET_FAILED.getMessage());
        }
        Log log=new Log();
        log.setType(0);
        log.setStatusCode(1);
        log.setActionId(1);
        log.setActions("管理员查看售后服务"+ass.getId());
        return ResponseUtil.ok(ass);
    }

    @PutMapping("admin/afterSaleServices/{id}")
    public Object adminUpdateAftersalesService(@PathVariable("id")Integer id, @RequestBody AftersalesService avo){
        Integer adminId =Integer.valueOf(request.getHeader("id"));
        if(adminId < 1 ){
            return ResponseUtil.unlogin();
        }
        if(id==null || id < 1 || avo == null )
        {
            return ResponseUtil.badArgumentValue();
        }
        if(afterSaleService.getAfterSale(id)==null)
        {
            return ResponseUtil.fail(ResponseCode.USE_FAILED.getCode(),ResponseCode.USE_FAILED.getMessage());
        }
        if(avo.getStatusCode()==null)
        {
            return ResponseUtil.badArgumentValue();
        }
        AftersalesService ass = new AftersalesService();
        ass.setStatusCode(avo.getStatusCode());

        AftersalesService retass = afterSaleService.updateUser(id,ass);
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
            return ResponseUtil.fail(ResponseCode.USE_FAILED.getCode(),ResponseCode.USE_FAILED.getMessage());
        }
    }

    @GetMapping("afterSaleServices")
    public Object userFindAftersalesServiceList(@RequestParam(defaultValue = "10") Integer limit,
                                                @RequestParam(defaultValue = "1") Integer page) {
        if(page==null || limit==null|| page < 1||limit < 1){
            return ResponseUtil.fail(402,"参数值不对");}
        Integer begin=limit*(page-1);
        Integer userId= Integer.valueOf(request.getHeader("id"));
        if(userId < 1){
            return ResponseUtil.badArgumentValue();
        }
    return ResponseUtil.ok(afterSaleService.findAfterSaleByUserId(userId,begin,limit));
    }

    @PostMapping("afterSaleServices")
    public Object userApplyAftersalesService(@RequestBody AftersalesService asvo){
        if((asvo.getType()==null)
        ||(asvo.getNumber()==null)||(asvo.getOrderItemId()==null))
        {
            return ResponseUtil.badArgumentValue();
        }
        AftersalesService ass = new AftersalesService();
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId < 1){
            return ResponseUtil.badArgumentValue();
        }
        ass.setUserId(userId);
        ass.setType(asvo.getType());
        //??????????????
        // orderService    ??????
        Object ret = orderService.findOrderItemType(asvo.getOrderItemId());
        Integer type = JacksonUtil.parseInteger(ret.toString(),"data");
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
            return ResponseUtil.fail(ResponseCode.USE_FAILED.getCode(),ResponseCode.USE_FAILED.getMessage());
        }
    }

    @GetMapping("afterSaleServices/{id}")
    public Object userFindAftersaleService(@PathVariable("id") Integer id){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId < 1){return ResponseUtil.badArgumentValue();}
        Integer expect = afterSaleService.getUserIdById(id);
        if(!expect.equals(userId) )
        {return ResponseUtil.fail(ResponseCode.GET_FAILED.getCode(),ResponseCode.GET_FAILED.getMessage()); }
        AftersalesService ass=afterSaleService.getAfterSale(id);
        return ResponseUtil.ok(ass);
    }

    @PutMapping("afterSaleServices/{id}")
    public Object userUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AftersalesService avo){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId < 1){return ResponseUtil.badArgumentValue();}
        if(id < 1){
            return ResponseUtil.badArgumentValue();
        }
        AftersalesService aftersalesService = afterSaleService.getAfterSale(id);
        if(aftersalesService == null)
        {
            return ResponseUtil.badArgumentValue();
        }
        if(userId.equals(aftersalesService.getUserId())){
            return ResponseUtil.fail(ResponseCode.USE_FAILED.getCode(),ResponseCode.USE_FAILED.getMessage());
        }
        if((avo.getType()==null)&&(avo.getNumber()==null)&&(avo.getApplyReason()==null)){
            return ResponseUtil.badArgumentValue();
        }

        aftersalesService.setType(avo.getType());
        aftersalesService.setApplyReason(avo.getApplyReason());
        aftersalesService.setNumber(avo.getNumber());
        AftersalesService ret =afterSaleService.updateUser(id,aftersalesService);
        if(ret!=null)
        {return ResponseUtil.ok(ret);}
        else
        {
            return ResponseUtil.fail(ResponseCode.USE_FAILED.getCode(),
                    ResponseCode.USE_FAILED.getMessage());
        }
    }

    @DeleteMapping("aftersaleServices/{id}")
    public Object userDeleteAftersaleService(@PathVariable("id")Integer id){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId < 1){return ResponseUtil.badArgumentValue();}
        AftersalesService aftersalesService = afterSaleService.getAfterSale(id);
        if(aftersalesService == null){
            return ResponseUtil.badArgumentValue();
        }else if(aftersalesService.getUserId()==null
                ||!aftersalesService.getUserId().equals(userId)){
            return ResponseUtil.fail(ResponseCode.DELETE_FAILED.getCode(),
                    ResponseCode.DELETE_FAILED.getMessage());
        }
        if(!afterSaleService.deleteAfterSale(id))  {
            return ResponseUtil.fail(ResponseCode.DELETE_FAILED.getCode(),
                    ResponseCode.DELETE_FAILED.getMessage());
        }
        else
        {return ResponseUtil.ok(true);}
    }
}
