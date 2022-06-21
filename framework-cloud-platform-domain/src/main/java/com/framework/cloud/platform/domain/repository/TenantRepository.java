package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.common.dto.*;
import com.framework.cloud.platform.domain.entity.Tenant;

/**
 * 租户 数据层接口
 *
 * @author wusiwei
 */
public interface TenantRepository extends BaseRepository<Tenant> {

    /**
     * 租户分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<TenantPageVO> page(TenantPageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    TenantInfoVO info(Long id);

    /**
     * 详情
     *
     * @param code 标识
     * @return 详情
     */
    TenantInfoVO infoByCode(String code);
}