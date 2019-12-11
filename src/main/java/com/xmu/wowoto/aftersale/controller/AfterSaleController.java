package com.xmu.wowoto.aftersale.controller;

import com.xmu.wowoto.aftersale.controller.vo.AfterSaleUpdateVO;
import com.xmu.wowoto.aftersale.controller.vo.AfterSaleVO;
import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.service.AfterSaleService;
import com.xmu.wowoto.aftersale.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
public class AfterSaleController {
    @Autowired
    AfterSaleService afterSaleService;

    @GetMapping("admin/aftersalesServices")
    @ApiOperation(value="管理员查询售后服务列表  /list")
    public Object adminFindAftersalesServiceList(Integer page,Integer limit)
    {
        if(page==null || limit==null)
            return ResponseUtil.fail(402,"bad params!");
        Integer begin=limit*(page-1);
        List<AftersalesService> assList=afterSaleService.findAllAfterSale(begin,limit);
        Object ret =ResponseUtil.ok(assList);
        return ret;
    }

    @GetMapping("aftersalesServices/{id}")
    @ApiOperation(value="管理员查询某一售后服务具体信息  ")
    public Object adminFindAftersalesService(@PathVariable("id") Integer id){
        if(id==null)
            return ResponseUtil.fail(402,"bad params!");
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Object ret=ResponseUtil.ok(ass);
        return ret;
    }


    @PutMapping("admin/aftersalesServices/{id}")
    @ApiOperation(value="管理员修改售后服务的信息  /update")
    public Object adminUpdateAftersalesService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        if(id==null)
            return ResponseUtil.fail(402,"bad params!");
        if((avo.getType()==false)&&(avo.getApply_reason()==null)&&(avo.getStatus_code()==null))
            return ResponseUtil.fail(402,"bad params!");
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(avo.getStatus_code());
        AftersalesService retass=afterSaleService.updateUser(id,ass);
        if(retass!=null)
        return ResponseUtil.ok();
        else
            return ResponseUtil.fail(505,"Object dosen't exist!");
    }

    @GetMapping("aftersalesService")
    @ApiOperation(value="用户查询售后服务列表  /list")
    public Object userFindAftersalesServiceList(Integer page,Integer limit) {
        if(page==null || limit==null)
            return ResponseUtil.fail(402,"bad params!");
        Integer begin=limit*(page-1);
        //TODO:假id
        Integer userId=1;
    return ResponseUtil.ok(afterSaleService.findAfterSaleByUserId(userId,begin,limit));
    }

    @PostMapping("aftersalesService")
    @ApiOperation(value="用户申请售后服务  ")
    public Object userApplyAftersalesService(@RequestBody AfterSaleVO asvo){
        if((asvo.getType()==false)||(asvo.getApply_reason()==null)||(asvo.getGoods_type()==null)
        ||(asvo.getNumber()==null)||(asvo.getOrder_item_id()==null))
            return ResponseUtil.fail(402,"bad params!");
        AftersalesService ass = new AftersalesService();
        //TODO 假id
        ass.setUserId(1001);
        ass.setType(asvo.getType());
        ass.setGoodsType(asvo.getGoods_type());
        ass.setApplyReason(asvo.getApply_reason());
        ass.setNumber(asvo.getNumber());
        ass.setOrderItemId(asvo.getOrder_item_id());
        AftersalesService retass=afterSaleService.addAfterSale(ass);
        if (retass!=null)
            return ResponseUtil.ok(retass);
        else
            return ResponseUtil.fail(505,"Object dosen't exist!");
    }

    @GetMapping("user/aftersalesServices/{id}")
    @ApiOperation(value="用户查询某一售后服务具体信息  ")
    public Object userFindAftersaleService(@PathVariable("id") Integer id){
        //@todo 用户只能看自己的订单
        //@TODO 假数据
        Integer userId=10086;
        Integer expect=afterSaleService.getUserIdById(id);
        if(expect!=userId)
            return ResponseUtil.fail(506,"Permission deny!");
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Object ret=ResponseUtil.ok(ass);
        return ret;
    }

    @PutMapping("user/aftersalesServices/{id}")
    @ApiOperation(value="用户修改售后服务的信息(比如状态:取消售后服务)  /update")
    public Object userUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(null);
        return afterSaleService.updateUser(id,ass);
    }

    @DeleteMapping("aftersalesServices/{id}")
    @ApiOperation(value="用户删除某一个售后服务的信息  /delete")
    public Object userDeleteAftersaleService(@PathVariable("id")Integer id){
        return ResponseUtil.ok(afterSaleService.deleteAfterSale(id));
    }





    //自有
    @PutMapping("afterSaleServices/{id}/apply")
    public boolean applyAfterSale(@PathVariable("id")Integer id){return afterSaleService.applyAfterSale(id);}
}
