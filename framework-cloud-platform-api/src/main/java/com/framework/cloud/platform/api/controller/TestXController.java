package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.stream.producer.StreamProducer;
import com.framework.cloud.stream.rabbit.listener.TestMessage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "动态路由")
@RestController
@RequestMapping(path = "/test")
public class TestXController {

    @Resource
    private StreamProducer rabbitProducer;

    @GetMapping("/mq")
    public Result<Boolean> mq() {
        rabbitProducer.send(new TestMessage("979"),"direct.mode", "test.route");
        return R.success(true);
    }
}
