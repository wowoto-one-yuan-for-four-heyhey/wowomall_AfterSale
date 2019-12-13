package com.xmu.wowoto.aftersale.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MedalWill
 * @date 2019/12/13 19:26
 */
@Service
@FeignClient("Order")
public interface OrderService {
    
/**
 *根据orderItemId寻找goodsType
*@author MedalWill
*@date 2019/12/13
*
*@param  orderItemId orderitem的Id
*@return Object
*/
    @GetMapping("orderItem/{orderItemId}/goodsType")
    Object findOrderItemType(@PathVariable("orderItemId") Integer orderItemId );
}
