package com.framework.cloud.platform.domain.service;

import com.framework.cloud.platform.common.enums.SwitchType;
import com.framework.cloud.platform.common.vo.SettingInfoVO;

/**
 * 租户配置 服务层接口
 *
 * @author wusiwei
 */
public interface SettingService {

    /**
     * 详情
     *
     * @return 详情
     */
    SettingInfoVO info();

    /**
     * 开关权限删除
     *
     * @param switchType 开关
     * @return 是否成功
     */
    boolean switchPermissionDelete(SwitchType switchType);
}