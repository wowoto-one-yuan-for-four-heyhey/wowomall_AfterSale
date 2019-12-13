package com.xmu.wowoto.aftersale.service;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@Service
public interface AfterSaleService {
    /**
     * 新增售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param ass 添加的售后服务
    *@return afterSaleService 写入的对象
    */
    AftersalesService addAfterSale(AftersalesService ass);

    /**
     * 获得售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return  afterSaleService 获得的对象
    */
    AftersalesService getAfterSale(Integer id);

    /**
     * 删除售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return bool 删除是否成功
    */
    boolean deleteAfterSale(Integer id);

    /**
     * 批准售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return bool 批准是否成功
    */
    boolean applyAfterSale(Integer id);

    /**
     * 用户更新售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
     * @param ass 售后服务对象
    *@return afterSaleService 更新的售后服务对象
    */
    AftersalesService updateUser(Integer id,AftersalesService ass);

    /**
     * 用户获得所有售后服务列表
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param begin 开始行数
     * @param limit 每页行数
    *@return list 售后服务列表
    */
    List<AftersalesService> findAllAfterSale(Integer begin, Integer limit);

    /**
     * 根据售后服务id寻找用户id
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return userId 用户id
    */
    Integer getUserIdById(Integer id);

    /**
     * 用户根据用户id寻找他的所有售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 用户id
     * @param begin 开始行数
     * @param limit 每页行数
    *@return list 获得的售后服务
    */
    List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit);
}
