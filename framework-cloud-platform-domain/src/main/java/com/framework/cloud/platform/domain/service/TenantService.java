package com.framework.cloud.platform.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.platform.common.dto.TenantDTO;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.dto.TenantVerifyDTO;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantPageVO;

/**
 * 租户 服务层接口
 *
 * @author wusiwei
 */
public interface TenantService {
    /**
     * 租户 分页
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

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return 是否成功
     */
    boolean saveUpdate(TenantDTO param);

    /**
     * 审核
     *
     * @param param 审核参数
     * @return 是否成功
     */
    boolean verify(TenantVerifyDTO param);
}