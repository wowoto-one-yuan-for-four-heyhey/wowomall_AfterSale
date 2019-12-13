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
@FeignClient("order")
public interface OrderService {
    @GetMapping("orderItem/{orderItemId}/goodsType")
    public Object findOrderItemType(@PathVariable("orderItemId") Integer orderItemId );
}
