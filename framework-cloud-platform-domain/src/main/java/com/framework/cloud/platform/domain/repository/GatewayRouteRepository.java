package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.dto.GatewayRoutePageDTO;
import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRouteListVO;
import com.framework.cloud.platform.common.vo.GatewayRoutePageVO;
import com.framework.cloud.platform.domain.entity.GatewayRoute;

import java.util.List;

/**
 * 动态路由 数据层接口
 *
 * @author wusiwei
 */
public interface GatewayRouteRepository extends BaseRepository<GatewayRoute> {

    /**
     * 动态路由分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<GatewayRoutePageVO> page(GatewayRoutePageDTO param);

    /**
     * 动态路由 列表
     *
     * @return 数据
     */
    List<GatewayRouteListVO> routeList();

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    GatewayRouteInfoVO info(Long id);

    /**
     * 根据名称查询
     *
     * @param name 名称
     * @return 网关
     */
    GatewayRoute getByName(String name);
}