package com.framework.cloud.platform.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.cache.cache.RedisCache;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.platform.common.constant.CacheConstant;
import com.framework.cloud.platform.common.dto.TenantDTO;
import com.framework.cloud.platform.common.dto.TenantPageDTO;
import com.framework.cloud.platform.common.dto.TenantVerifyDTO;
import com.framework.cloud.platform.common.enums.ApproveType;
import com.framework.cloud.platform.common.enums.GrantType;
import com.framework.cloud.platform.common.enums.ScopeType;
import com.framework.cloud.platform.common.enums.TenantStatus;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantPageVO;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.entity.Setting;
import com.framework.cloud.platform.domain.entity.Tenant;
import com.framework.cloud.platform.domain.repository.SettingRepository;
import com.framework.cloud.platform.domain.repository.TenantRepository;
import com.framework.cloud.platform.domain.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 租户 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final RedisCache redisCache;
    private final TenantRepository tenantRepository;
    private final SettingRepository settingRepository;

    @Override
    public PageVO<TenantPageVO> page(TenantPageDTO param) {
        return tenantRepository.page(param);
    }

    @Override
    public TenantInfoVO info(Long id) {
        return tenantRepository.info(id);
    }

    @Override
    public TenantVO infoByCode(String code) {
        TenantVO tenantVO = redisCache.get(CacheConstant.TENANT, TenantVO.class);
        if (ObjectUtil.isNotNull(tenantVO)) {
            return tenantVO;
        }
        tenantVO = tenantRepository.infoByCode(code);
        if (ObjectUtil.isNotNull(tenantVO)) {
            redisCache.put(CacheConstant.TENANT, tenantVO);
        }
        return tenantVO;
    }

    @Override
    public boolean saveUpdate(TenantDTO param) {
        Tenant tenant;
        TenantVO exist = tenantRepository.infoByCode(param.getCode());
        if (ObjectUtil.isNull(param.getId())) {
            AssertUtil.nonNull(exist, PlatformMsg.TENANT_EXISTS.getMsg());
            tenant = new Tenant();
            CopierUtil.copyProperties(param, tenant);
            tenant.setStatus(TenantStatus.REVIEWED);
        } else {
            tenant = tenantRepository.getById(param.getId());
            if (ObjectUtil.isNotNull(exist)) {
                AssertUtil.isTrue(exist.getId().equals(param.getId()), PlatformMsg.TENANT_EXISTS.getMsg());
            }
            CopierUtil.copyProperties(param, tenant);
        }
        tenant.setGrantType(param.getGrantTypeList().stream().map(GrantType::getGrant).collect(Collectors.joining(",")));
        tenant.setApprove(param.getApproveList().stream().map(ApproveType::getApprove).collect(Collectors.joining(",")));
        tenant.setScope(param.getScopeList().stream().map(ScopeType::getScope).collect(Collectors.joining(",")));
        tenant.setAuthorities(String.join(",", param.getAuthoritieList()));
        tenant.setResourceIds(String.join(",", param.getResourceIdList()));
        return tenantRepository.saveOrUpdate(tenant);
    }

    @Override
    public boolean verify(TenantVerifyDTO param) {
        Tenant tenant = tenantRepository.getByIdNotNull(param.getTenantId());
        tenant.setStatus(param.getIsApproval() ? TenantStatus.NORMAL : TenantStatus.REFUSE);
        if (tenantRepository.updateById(tenant)) {
            Setting setting = new Setting();
            setting.setTenantId(param.getTenantId());
            return settingRepository.save(setting);
        }
        return false;
    }
}