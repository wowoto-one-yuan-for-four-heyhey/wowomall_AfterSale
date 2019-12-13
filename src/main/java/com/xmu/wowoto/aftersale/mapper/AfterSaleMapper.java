package com.xmu.wowoto.aftersale.mapper;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
@Mapper
@Repository
public interface AfterSaleMapper {
    /**
     * 增加售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param aftersalesService 售后服务对象
    *@return addAfterSale 插入结果
    */
    int addAfterSale(AftersalesService aftersalesService);

    /**
     * 根据id寻找售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return AftersalesService 查到的对象
    */
    AftersalesService findAfterSaleById(Integer id);

    /**
     * 更新售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param aftersalesService 售后服务对象
    *@return int 修改结果
    */
    int updateAfterSale(AftersalesService aftersalesService);

    /**
     * 接受售后服务
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return int 修改结果
    */
    int applyAfterSale(Integer id);
    
    /**
     * 根据售后id获得用户id
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 售后服务id
    *@return userId 售后服务的用户id
    */
    Integer getUserIdById(Integer id);

    /**
     * 根据用户id获得售后服务列表
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param id 用户id
     * @param begin 开始行数
     * @param limit 一页行数
    *@return list 售后服务列表
    */
    List<AftersalesService> findAfterSaleByUserId(Integer id,Integer begin,Integer limit);

    /**
     * 获取售后服务列表
    *@author MedalWill
    *@date 2019/12/13
    *
    *@param begin 开始行数
     * @param limit 一页行数
    *@return list 售后服务列表
    */
    List<AftersalesService> findAllAfterSale(Integer begin,Integer limit);
}
