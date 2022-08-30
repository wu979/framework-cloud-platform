package com.framework.cloud.platform.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.vo.TenantPageVO;
import com.framework.cloud.platform.domain.entity.Tenant;
import org.apache.ibatis.annotations.Param;

/**
 * 租户 数据库接口
 *
 * @author wusiwei
 */
public interface TenantMapper extends BaseMapper<Tenant> {

    IPage<TenantPageVO> page(@Param("pg") Page<TenantPageVO> page, @Param("param") TenantPageDTO param);

}