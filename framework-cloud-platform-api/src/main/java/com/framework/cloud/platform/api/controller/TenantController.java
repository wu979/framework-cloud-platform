package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.dto.TenantDTO;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.dto.TenantVerifyDTO;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantPageVO;
import com.framework.cloud.platform.domain.service.TenantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 租户 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "租户")
@RestController
@RequestMapping(path = "/tenant")
public class TenantController {

    @Resource
    private TenantService tenantService;

    @ApiOperation(value = "租户列表")
    @PostMapping(value = "/page")
    public Result<PageVO<TenantPageVO>> page(@ApiParam("条件") @RequestBody TenantPageDTO param) {
        return R.success(tenantService.page(param));
    }

    @ApiOperation(value = "租户详情")
    @GetMapping(value = "/{id}/info")
    public Result<TenantInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(tenantService.info(id));
    }

    @ApiOperation(value = "租户详情")
    @GetMapping(value = "/{code}/info/code")
    public Result<TenantInfoVO> infoByCode(@ApiParam("租户标识") @PathVariable("code") String code) {
        return R.success(tenantService.infoByCode(code));
    }

    @ApiOperation(value = "租户新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("租户") @Valid @Validated(Save.class) @RequestBody TenantDTO param) {
        return R.success(tenantService.saveUpdate(param));
    }

    @ApiOperation(value = "租户修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("租户") @Valid @Validated(Update.class) @RequestBody TenantDTO param) {
        return R.success(tenantService.saveUpdate(param));
    }

    @ApiOperation(value = "租户审核")
    @PostMapping(value = "/verify")
    public Result<Boolean> verify(@ApiParam("审核") @Valid @RequestBody TenantVerifyDTO param) {
        return R.success(tenantService.verify(param));
    }
}
