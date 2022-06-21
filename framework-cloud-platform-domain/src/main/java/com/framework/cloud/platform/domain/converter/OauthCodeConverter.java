package com.framework.cloud.platform.domain.converter;

import com.framework.cloud.platform.common.vo.OauthCodeInfoVO;
import com.framework.cloud.platform.domain.entity.OauthCode;
import org.mapstruct.Mapper;

/**
 * 授权码 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface OauthCodeConverter {

    /**
     * 授权码 详情转换
     *
     * @param oauthCode 实体
     * @return 详情
     */
    OauthCodeInfoVO info(OauthCode oauthCode);

}