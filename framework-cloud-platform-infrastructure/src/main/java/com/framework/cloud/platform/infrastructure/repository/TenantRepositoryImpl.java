package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantPageVO;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.entity.Tenant;
import com.framework.cloud.platform.domain.repository.TenantRepository;
import com.framework.cloud.platform.infrastructure.converter.TenantConverter;
import com.framework.cloud.platform.infrastructure.mapper.TenantMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 租户 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class TenantRepositoryImpl extends BaseRepositoryImpl<TenantMapper, Tenant> implements TenantRepository {

    private final TenantConverter tenantConverter;

    @Override
    public PageVO<TenantPageVO> page(TenantPageDTO param) {
        Page<TenantPageVO> page = PageParam.buildOrder(param);
        IPage<TenantPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public List<TenantVO> tenantList() {
        List<Tenant> list = this.list();
        return tenantConverter.tenantList(list);
    }

    @Override
    public TenantInfoVO info(Long id) {
        Tenant tenant = this.getById(id);
        return tenantConverter.info(tenant);
    }

    @Override
    public TenantVO infoByCode(String code) {
        LambdaQueryWrapper<Tenant> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Tenant::getCode, code);
        Tenant tenant = this.getOne(wrapper);
        return tenantConverter.infoByCode(tenant);
    }
}