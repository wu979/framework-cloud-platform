package com.framework.cloud.platform.infrastructure.converter;

import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.domain.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 租户配置 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface SettingConverter {

    /**
     * 租户配置 详情转换
     *
     * @param setting 实体
     * @return 详情
     */
    SettingInfoVO info(Setting setting);

}