package com.framework.cloud.platform.api.controller;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.dto.OauthCodeDTO;
import com.framework.cloud.platform.common.vo.OauthCodeInfoVO;
import com.framework.cloud.platform.domain.service.OauthCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 授权码 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "授权码")
@RestController
@RequestMapping(path = "/oauth-code")
public class OauthCodeController {

    @Resource
    private OauthCodeService oauthCodeService;

    @ApiOperation(value = "授权码详情")
    @GetMapping(value = "/{code}/info")
    public Result<OauthCodeInfoVO> info(@ApiParam("主键") @PathVariable("code") String code) {
        return R.success(oauthCodeService.info(code));
    }

    @ApiOperation(value = "授权码新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("授权码") @Valid @Validated(Save.class) @RequestBody OauthCodeDTO param) {
        return R.success(oauthCodeService.save(param));
    }

}
