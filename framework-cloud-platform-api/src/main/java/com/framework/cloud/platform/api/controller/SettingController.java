package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.enums.SwitchType;
import com.framework.cloud.platform.common.vo.SettingInfoVO;
import com.framework.cloud.platform.domain.service.SettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 租户配置 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "租户配置")
@RestController
@RequestMapping(path = "/setting")
public class SettingController {

    @Resource
    private SettingService settingService;

    @ApiOperation(value = "租户配置详情")
    @GetMapping(value = "/info")
    public Result<SettingInfoVO> info() {
        return R.success(settingService.info());
    }

    @ApiOperation(value = "开启权限删除配置")
    @PostMapping(value = "/open/permission/delete")
    public Result<Boolean> openPermissionDelete() {
        return R.success(settingService.switchPermissionDelete(SwitchType.OPEN));
    }

    @ApiOperation(value = "关闭权限删除配置")
    @PostMapping(value = "/close/permission/delete")
    public Result<Boolean> closePermissionDelete() {
        return R.success(settingService.switchPermissionDelete(SwitchType.CLOSE));
    }
}
