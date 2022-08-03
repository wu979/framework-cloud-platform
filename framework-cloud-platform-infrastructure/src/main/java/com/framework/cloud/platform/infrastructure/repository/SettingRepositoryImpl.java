package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.framework.cloud.holder.utils.OauthUtil;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.common.vo.SettingInfoVO;
import com.framework.cloud.platform.domain.entity.Setting;
import com.framework.cloud.platform.domain.repository.SettingRepository;
import com.framework.cloud.platform.infrastructure.converter.SettingConverter;
import com.framework.cloud.platform.infrastructure.mapper.SettingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 租户配置 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class SettingRepositoryImpl extends BaseRepositoryImpl<SettingMapper, Setting> implements SettingRepository {

    private final SettingConverter settingConverter;

    @Override
    public Setting entity() {
        LambdaQueryWrapper<Setting> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Setting::getTenantId, OauthUtil.getTenantId());
        return this.getOne(wrapper);
    }

    @Override
    public SettingInfoVO info() {
        return settingConverter.info(entity());
    }

}