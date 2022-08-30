package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.common.utils.StringUtil;
import com.framework.cloud.platform.common.enums.ApproveType;
import com.framework.cloud.platform.common.enums.GrantType;
import com.framework.cloud.platform.common.enums.ScopeType;
import com.framework.cloud.platform.common.vo.TenantInfoVO;
import com.framework.cloud.platform.common.vo.TenantVO;
import com.framework.cloud.platform.domain.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 租户 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface TenantConverter {

    /**
     * 租户 详情转换
     *
     * @param tenant 实体
     * @return 详情
     */
    TenantVO infoByCode(Tenant tenant);

    /**
     * 租户 详情转换
     *
     * @param tenantList 实体
     * @return 详情
     */
    List<TenantVO> tenantList(List<Tenant> tenantList);

    /**
     * 租户 详情转换
     *
     * @param tenant 实体
     * @return 详情
     */
    @Mappings(value = {
            @Mapping(target = "scope", source = "scope", qualifiedByName = "scopeList"),
            @Mapping(target = "grantType", source = "grantType", qualifiedByName = "grantTypeList"),
            @Mapping(target = "authorities", source = "authorities", qualifiedByName = "authoritieList"),
            @Mapping(target = "approve", source = "approve", qualifiedByName = "approveList"),
            @Mapping(target = "resourceIds", source = "resourceIds", qualifiedByName = "resourceIdList"),
    })
    TenantInfoVO info(Tenant tenant);

    @Named("scopeList")
    default Set<ScopeType> scopeList(String scope) {
        Set<ScopeType> scopeList = new HashSet<>();
        if (StringUtil.isNotEmpty(scope)) {
            scopeList = Stream.of(scope.split(",")).map(ScopeType::getScopeType).collect(Collectors.toSet());
        }
        return scopeList;
    }

    @Named("grantTypeList")
    default Set<GrantType> grantTypeList(String grantType) {
        Set<GrantType> grantTypeList = new HashSet<>();
        if (StringUtil.isNotEmpty(grantType)) {
            grantTypeList = Stream.of(grantType.split(",")).map(GrantType::getGrantType).collect(Collectors.toSet());
        }
        return grantTypeList;
    }

    @Named("authoritieList")
    default Set<String> authoritieList(String authorities) {
        Set<String> authoritieList = new HashSet<>();
        if (StringUtil.isNotEmpty(authorities)) {
            authoritieList = Stream.of(authorities.split(",")).collect(Collectors.toSet());
        }
        return authoritieList;
    }

    @Named("approveList")
    default Set<ApproveType> approveList(String approve) {
        Set<ApproveType> approveList = new HashSet<>();
        if (StringUtil.isNotEmpty(approve)) {
            approveList = Stream.of(approve.split(",")).map(ApproveType::getApproveType).collect(Collectors.toSet());
        }
        return approveList;
    }

    @Named("resourceIdList")
    default Set<String> resourceIdList(String resourceIds) {
        Set<String> resourceIdList = new HashSet<>();
        if (StringUtil.isNotEmpty(resourceIds)) {
            resourceIdList = Stream.of(resourceIds.split(",")).collect(Collectors.toSet());
        }
        return resourceIdList;
    }
}