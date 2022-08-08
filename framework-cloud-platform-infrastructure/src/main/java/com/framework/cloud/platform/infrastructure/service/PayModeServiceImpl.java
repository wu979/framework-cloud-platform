package com.framework.cloud.platform.infrastructure.service;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.cache.annotation.Cache;
import com.framework.cloud.cache.enums.CacheMedium;
import com.framework.cloud.cache.enums.CacheType;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.common.utils.StringUtil;
import com.framework.cloud.platform.common.constant.PlatformConstant;
import com.framework.cloud.platform.common.dto.PayModeDTO;
import com.framework.cloud.platform.common.dto.PayModePageDTO;
import com.framework.cloud.platform.common.enums.PayChannelType;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.common.vo.PayModePageVO;
import com.framework.cloud.platform.domain.entity.PayChannel;
import com.framework.cloud.platform.domain.entity.PayMode;
import com.framework.cloud.platform.domain.repository.PayChannelRepository;
import com.framework.cloud.platform.domain.repository.PayModeRepository;
import com.framework.cloud.platform.domain.service.PayModeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 支付方式 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PayModeServiceImpl implements PayModeService {

    private final PayChannelRepository payChannelRepository;
    private final PayModeRepository payModeRepository;

    @Override
    public PageVO<PayModePageVO> page(PayModePageDTO param) {
        return payModeRepository.page(param);
    }

    @Override
    public List<PayModeListVO> list(Long id) {
        return payModeRepository.listByChannelId(id);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.MODE + "'+#id", type = CacheType.FULL, medium = CacheMedium.FULL)
    public PayModeInfoVO info(Long id) {
        return payModeRepository.info(id);
    }

    @Override
    public boolean save(PayModeDTO param) {
        PayChannel payChannel = payChannelRepository.getByIdNotNull(param.getChannelId());
        if (PayChannelType.WX.equals(payChannel.getType())) {
            if (StringUtil.isBlank(param.getMchId())) {
                AssertUtil.isBlank(param.getMchId(), "直连商户号不能为空");
            }
        }
        PayModeInfoVO exist = payModeRepository.info(param.getModeType());
        PayMode payMode = new PayMode();
        AssertUtil.nonNull(exist, PlatformMsg.PAY_MODE_EXIST.getMsg());
        CopierUtil.copyProperties(param, payMode);
        return payModeRepository.save(payMode);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.MODE + "'+#param.id", type = CacheType.DELETE, medium = CacheMedium.FULL)
    public boolean update(PayModeDTO param) {
        PayChannel payChannel = payChannelRepository.getByIdNotNull(param.getChannelId());
        if (PayChannelType.WX.equals(payChannel.getType())) {
            if (StringUtil.isBlank(param.getMchId())) {
                AssertUtil.isBlank(param.getMchId(), "直连商户号不能为空");
            }
        }
        PayMode payMode = payModeRepository.getByIdNotNull(param.getId());
        PayModeInfoVO exist = payModeRepository.info(param.getModeType());
        if (ObjectUtil.isNotNull(exist)) {
            AssertUtil.isTrue(exist.getId().equals(payMode.getId()), PlatformMsg.PAY_MODE_EXIST.getMsg());
        }
        CopierUtil.copyProperties(param, payMode);
        return payModeRepository.updateById(payMode);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.MODE + "'+#id", type = CacheType.DELETE, medium = CacheMedium.FULL)
    public boolean enable(Long id, boolean enable) {
        PayMode payMode = payModeRepository.getByIdNotNull(id);
        if (enable) {
            AssertUtil.isFalse(payMode.getEnable(), PlatformMsg.PAY_MODE_ENABLE.getMsg());
        } else {
            AssertUtil.isTrue(payMode.getEnable(), PlatformMsg.PAY_MODE_DISABLE.getMsg());
        }
        payMode.setEnable(enable);
        return payModeRepository.updateById(payMode);
    }
}