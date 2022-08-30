package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.dto.PayModeDTO;
import com.framework.cloud.platform.common.dto.PayModePageDTO;
import com.framework.cloud.platform.common.vo.PayModeAvailableVO;
import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.common.vo.PayModePageVO;
import com.framework.cloud.platform.domain.service.PayModeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 支付方式 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "支付方式")
@RestController
@RequestMapping(path = "/pay-mode")
public class PayModeController {

    @Resource
    private PayModeService payModeService;

    @ApiOperation(value = "支付方式分页")
    @PostMapping(value = "/page")
    public Result<PageVO<PayModePageVO>> page(@ApiParam("条件") @RequestBody PayModePageDTO param) {
        return R.success(payModeService.page(param));
    }

    @ApiOperation(value = "支付方式列表")
    @GetMapping(value = "/list")
    public Result<List<PayModeListVO>> list(@ApiParam("主键") @RequestParam("channelId") Long id) {
        return R.success(payModeService.list(id));
    }

    @ApiOperation(value = "支付方式可用列表")
    @GetMapping(value = "/available/list")
    public Result<List<PayModeAvailableVO>> list() {
        return R.success(payModeService.availableList());
    }

    @ApiOperation(value = "支付方式详情")
    @GetMapping(value = "/{id}/info")
    public Result<PayModeInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payModeService.info(id));
    }

    @ApiOperation(value = "支付方式新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("支付方式") @Valid @Validated(Save.class) @RequestBody PayModeDTO param) {
        return R.success(payModeService.save(param));
    }

    @ApiOperation(value = "支付方式修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("支付方式") @Valid @Validated(Update.class) @RequestBody PayModeDTO param) {
        return R.success(payModeService.update(param));
    }

    @ApiOperation(value = "支付方式启用")
    @PostMapping(value = "/{id}/enable")
    public Result<Boolean> enable(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payModeService.enable(id, Boolean.TRUE));
    }

    @ApiOperation(value = "支付方式禁用")
    @PostMapping(value = "/{id}/disable")
    public Result<Boolean> disable(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(payModeService.enable(id, Boolean.FALSE));
    }
}
