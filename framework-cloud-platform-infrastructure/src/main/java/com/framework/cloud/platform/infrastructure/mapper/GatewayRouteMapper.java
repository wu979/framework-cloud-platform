package com.framework.cloud.platform.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.common.dto.*;
import com.framework.cloud.platform.domain.entity.GatewayRoute;
import org.apache.ibatis.annotations.Param;

/**
 * 动态路由 数据库接口
 *
 * @author wusiwei
 */
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {

    IPage<GatewayRoutePageVO> page(@Param("pg") Page<GatewayRoutePageVO> page, @Param("param") GatewayRoutePageDTO param);

}