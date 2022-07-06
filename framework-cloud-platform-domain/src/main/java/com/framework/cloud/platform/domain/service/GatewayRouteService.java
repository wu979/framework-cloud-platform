package com.framework.cloud.platform.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.common.dto.*;
import com.framework.cloud.platform.domain.entity.GatewayRoute;

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
     * @return 详情
     */
    boolean saveUpdate(GatewayRouteDTO param);

    /**
     * 删除
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean removes(List<Long> ids);

}