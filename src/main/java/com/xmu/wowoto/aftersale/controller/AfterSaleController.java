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
@RequestMapping("/aftersaleService")
public class AfterSaleController {
    @Autowired
    AfterSaleService afterSaleService;

    @GetMapping("admin")
    @ApiOperation(value="管理员查询售后服务列表  /list")
    public Object adminFindAftersaleServiceList()
    {
        Object ret =ResponseUtil.ok(afterSaleService.findAllAfterSale());
        return ret;
    }

    @GetMapping("{id}/admin")
    @ApiOperation(value="管理员查询某一售后服务具体信息  ")
    public Object adminFindAftersaleService(@PathVariable("id") Integer id){
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Object ret=ResponseUtil.ok(ass);
        return ret;
    }


    @PutMapping("{id}/admin")
    @ApiOperation(value="管理员修改售后服务的信息  /update")
    public Object adminUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(avo.getStatus_code());
        return ResponseUtil.ok(afterSaleService.updateUser(id,ass));
    }
/*
    @GetMapping("user")
    @ApiOperation(value="用户查询售后服务列表  /list")
    public Object userFindAftersaleServiceList();
*/
    @PostMapping("user")
    @ApiOperation(value="用户申请售后服务  ")
    public Object userApplyAftersaleService(@RequestBody AfterSaleVO asvo){
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

    @GetMapping("{id}/user")
    @ApiOperation(value="用户查询某一售后服务具体信息  ")
    public Object userFindAftersaleService(@PathVariable("id") Integer id){
        //@todo 用户只能看自己的订单
        AftersalesService ass=afterSaleService.getAfterSale(id);
        Object ret=ResponseUtil.ok(ass);
        return ret;
    }

    @PutMapping("{id}/user")
    @ApiOperation(value="用户修改售后服务的信息(比如状态:取消售后服务)  /update")
    public Object userUpdateAftersaleService(@PathVariable("id")Integer id, @RequestBody AfterSaleUpdateVO avo){
        AftersalesService ass = new AftersalesService();
        ass.setType(avo.getType());
        ass.setApplyReason(avo.getApply_reason());
        ass.setStatusCode(null);
        return afterSaleService.updateUser(id,ass);
    }

    @DeleteMapping("{id}/user")
    @ApiOperation(value="用户删除某一个售后服务的信息  /delete")
    public Object userDeleteAftersaleService(@PathVariable("id")Integer id){
        return ResponseUtil.ok(afterSaleService.deleteAfterSale(id));
    }





    //自有
    @PutMapping("afterSaleServices/{id}/apply")
    public boolean applyAfterSale(@PathVariable("id")Integer id){return afterSaleService.applyAfterSale(id);}
}
