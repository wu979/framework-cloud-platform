package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.holder.model.LoginUser;
import com.framework.cloud.holder.utils.OauthUtil;
import com.framework.cloud.platform.common.dto.*;
import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.domain.service.GatewayRouteService;
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
 * 动态路由 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "动态路由")
@RestController
@RequestMapping(path = "/gateway-route")
public class GatewayRouteController {

    @Resource
    private GatewayRouteService gatewayRouteService;

    @ApiOperation(value = "动态路由列表")
    @PostMapping(value = "/page")
    public Result<PageVO<GatewayRoutePageVO>> page(@ApiParam("条件") @RequestBody GatewayRoutePageDTO param) {
        return R.success(gatewayRouteService.page(param));
    }

    @ApiOperation(value = "动态路由列表")
    @GetMapping(value = "/list")
    public Result<List<GatewayRouteListVO>> list() {
        LoginUser user = OauthUtil.getUser();
        return R.success(gatewayRouteService.list());
    }

    @ApiOperation(value = "动态路由详情")
    @GetMapping(value = "/{id}/info")
    public Result<GatewayRouteInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(gatewayRouteService.info(id));
    }

    @ApiOperation(value = "动态路由新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("动态路由") @Valid @Validated(Save.class) @RequestBody GatewayRouteDTO param) {
        return R.success(gatewayRouteService.saveUpdate(param));
    }

    @ApiOperation(value = "动态路由修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("动态路由") @Valid @Validated(Update.class) @RequestBody GatewayRouteDTO param) {
        return R.success(gatewayRouteService.saveUpdate(param));
    }

    @ApiOperation(value = "动态路由快速新增")
    @PostMapping(value = "/fast/save")
    public Result<Boolean> fastSave(@ApiParam("动态路由") @Valid @RequestBody GatewayFastRouteDTO param) {
        return R.success(gatewayRouteService.fastSave(param));
    }

    @ApiOperation(value = "动态路由启用")
    @PostMapping(value = "/{id}/enable")
    public Result<Boolean> enable(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(gatewayRouteService.enable(id, Boolean.TRUE));
    }

    @ApiOperation(value = "动态路由禁用")
    @PostMapping(value = "/{id}/disable")
    public Result<Boolean> disable(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(gatewayRouteService.enable(id, Boolean.FALSE));
    }
}
