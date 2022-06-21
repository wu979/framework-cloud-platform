package com.framework.cloud.platform.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.platform.common.dto.OauthCodeDTO;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.OauthCodeInfoVO;
import com.framework.cloud.platform.domain.converter.OauthCodeConverter;
import com.framework.cloud.platform.domain.entity.OauthCode;
import com.framework.cloud.platform.domain.repository.OauthCodeRepository;
import com.framework.cloud.platform.domain.service.OauthCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 授权码 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class OauthCodeServiceImpl implements OauthCodeService {

    private final OauthCodeConverter oauthCodeConverter;
    private final OauthCodeRepository oauthCodeRepository;

    @Override
    public OauthCodeInfoVO info(String code) {
        OauthCode oauthCode = oauthCodeRepository.entity(code);
        if (ObjectUtil.isNull(oauthCode)) {
            throw new BizException(PlatformMsg.OAUTH_CODE_NOT_EXISTS.getMsg());
        }
        if (!oauthCodeRepository.removeById(oauthCode.getId())) {
            throw new BizException(PlatformMsg.OAUTH_CODE_NOT_EXISTS.getMsg());
        }
        return oauthCodeConverter.info(oauthCode);
    }

    @Override
    public boolean save(OauthCodeDTO param) {
        OauthCode oauthCode = new OauthCode();
        CopierUtil.copyProperties(param, oauthCode);
        oauthCode.setExpiresTime(LocalDateTime.now().plusMinutes(10));
        return oauthCodeRepository.saveOrUpdate(oauthCode);
    }

}