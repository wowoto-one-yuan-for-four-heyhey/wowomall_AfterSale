package com.xmu.wowoto.aftersale.service.impl;

import com.xmu.wowoto.aftersale.domain.Log;
import com.xmu.wowoto.aftersale.service.LogService;
import com.xmu.wowoto.aftersale.service.RemoteLogService;
import com.xmu.wowoto.aftersale.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 22:31
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    RemoteLogService remoteLogService;

    @Override
    public Log addLog(Log log) {
        String json = remoteLogService.addLog(log);
        return JacksonUtil.parseObject(json, "data", Log.class);
    }
}
