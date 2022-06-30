package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantPageVO;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.entity.Tenant;

import java.util.List;

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
     * 租户 列表
     *
     * @return 列表
     */
    List<TenantVO> tenantList();

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
    TenantVO infoByCode(String code);
}