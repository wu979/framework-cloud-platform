package com.framework.cloud.platform.infrastructure.service;

import com.framework.cloud.platform.common.enums.SwitchType;
import com.framework.cloud.platform.common.vo.SettingInfoVO;
import com.framework.cloud.platform.domain.entity.Setting;
import com.framework.cloud.platform.domain.repository.SettingRepository;
import com.framework.cloud.platform.domain.service.SettingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 租户配置 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;

    @Override
    public SettingInfoVO info() {
        return settingRepository.info();
    }

    @Override
    public boolean switchPermissionDelete(SwitchType switchType) {
        Setting entity = settingRepository.entity();
        entity.setPermissionDelete(SwitchType.OPEN.equals(switchType) ? Boolean.TRUE : Boolean.FALSE);
        return settingRepository.updateById(entity);
    }
}