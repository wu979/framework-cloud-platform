package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.dto.PayChannelDTO;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.vo.PayChannelInfoVO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;
import com.framework.cloud.platform.domain.service.PayChannelService;
import io.seata.core.context.RootContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 支付渠道 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "支付渠道")
@RestController
@RequestMapping(path = "/pay-channel")
public class PayChannelController {

    @Resource
    private PayChannelService payChannelService;

    @ApiOperation(value = "支付渠道列表")
    @PostMapping(value = "/page")
    public Result<PageVO<PayChannelPageVO>> page(@ApiParam("条件") @RequestBody PayChannelPageDTO param) {
        return R.success(payChannelService.page(param));
    }

    @ApiOperation(value = "支付渠道详情")
    @GetMapping(value = "/{id}/info")
    public Result<PayChannelInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payChannelService.info(id));
    }

    @ApiOperation(value = "支付渠道新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("支付渠道") @Valid @Validated(Save.class) @RequestBody PayChannelDTO param) {
        String xid = RootContext.getXID();
        System.out.println(xid);
        return R.success(payChannelService.save(param));
    }

    @ApiOperation(value = "支付渠道修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("支付渠道") @Valid @Validated(Update.class) @RequestBody PayChannelDTO param) {
        return R.success(payChannelService.update(param));
    }

    @ApiOperation(value = "支付渠道启用")
    @PostMapping(value = "/{id}/enable")
    public Result<Boolean> enable(@ApiParam("主键") @PathVariable("id") Long id) {
        int i = 1 / 0;
        return R.success(payChannelService.enable(id, Boolean.TRUE));
    }

    @ApiOperation(value = "支付渠道禁用")
    @PostMapping(value = "/{id}/disable")
    public Result<Boolean> disable(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payChannelService.enable(id, Boolean.FALSE));
    }
}
