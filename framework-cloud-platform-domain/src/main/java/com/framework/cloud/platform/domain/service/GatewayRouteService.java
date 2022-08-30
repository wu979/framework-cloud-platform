package com.framework.cloud.platform.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.platform.common.dto.GatewayFastRouteDTO;
import com.framework.cloud.platform.common.dto.GatewayRouteDTO;
import com.framework.cloud.platform.common.dto.GatewayRoutePageDTO;
import com.framework.cloud.platform.common.vo.GatewayRouteInfoVO;
import com.framework.cloud.platform.common.vo.GatewayRouteListVO;
import com.framework.cloud.platform.common.vo.GatewayRoutePageVO;

import java.util.List;

/**
 * 动态路由 服务层接口
 *
 * @author wusiwei
 */
public interface GatewayRouteService {

    /**
     * 动态路由 分页
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
    List<GatewayRouteListVO> list();

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    GatewayRouteInfoVO info(Long id);

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return bool
     */
    boolean saveUpdate(GatewayRouteDTO param);

    /**
     * 快速新增
     *
     * @param param 新增参数
     * @return bool
     */
    boolean fastSave(GatewayFastRouteDTO param);

    /**
     * 启用/禁用
     *
     * @param id     主键
     * @param enable 启、禁用
     * @return bool
     */
    boolean enable(Long id, boolean enable);
}