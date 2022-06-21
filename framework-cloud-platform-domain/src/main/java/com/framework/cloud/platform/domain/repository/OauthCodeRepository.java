package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.domain.entity.OauthCode;

/**
 * 授权码 数据层接口
 *
 * @author wusiwei
 */
public interface OauthCodeRepository extends BaseRepository<OauthCode> {

    /**
     * 详情
     *
     * @param code 授权码
     * @return 详情
     */
    OauthCode entity(String code);

}