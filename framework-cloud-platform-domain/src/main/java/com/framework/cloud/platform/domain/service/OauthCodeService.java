package com.framework.cloud.platform.domain.service;

import com.framework.cloud.platform.common.dto.OauthCodeDTO;
import com.framework.cloud.platform.common.vo.OauthCodeInfoVO;

/**
 * 授权码 服务层接口
 *
 * @author wusiwei
 */
public interface OauthCodeService {

    /**
     * 详情
     *
     * @param code 授权码
     * @return 详情
     */
    OauthCodeInfoVO info(String code);

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return 详情
     */
    boolean save(OauthCodeDTO param);

}