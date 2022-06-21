package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.vo.SettingInfoVO;
import com.framework.cloud.platform.domain.entity.Setting;

/**
 * 租户配置 数据层接口
 *
 * @author wusiwei
 */
public interface SettingRepository extends BaseRepository<Setting> {

    /**
     * 详情
     *
     * @return 详情
     */
    Setting entity();

    /**
     * 详情
     *
     * @return 详情
     */
    SettingInfoVO info();

}