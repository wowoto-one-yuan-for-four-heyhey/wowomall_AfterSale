package com.xmu.wowoto.aftersale.service;

import com.xmu.wowoto.aftersale.domain.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 22:31
 */
@Service
public interface LogService {

    /**
     * 添加日志
     * @param log
     * @return
     */
    Log addLog(@RequestBody Log log);
}
