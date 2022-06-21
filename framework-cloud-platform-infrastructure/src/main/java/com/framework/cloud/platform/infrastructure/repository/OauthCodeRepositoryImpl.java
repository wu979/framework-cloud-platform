package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.domain.entity.OauthCode;
import com.framework.cloud.platform.domain.repository.OauthCodeRepository;
import com.framework.cloud.platform.infrastructure.mapper.OauthCodeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 授权码 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class OauthCodeRepositoryImpl extends BaseRepositoryImpl<OauthCodeMapper, OauthCode> implements OauthCodeRepository {

    @Override
    public OauthCode entity(String code) {
        LambdaQueryWrapper<OauthCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OauthCode::getCode, code);
        return this.getOne(wrapper);
    }
}