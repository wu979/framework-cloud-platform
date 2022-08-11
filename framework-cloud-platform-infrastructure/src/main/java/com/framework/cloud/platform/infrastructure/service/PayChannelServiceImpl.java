package com.framework.cloud.platform.infrastructure.service;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.cache.annotation.Cache;
import com.framework.cloud.cache.enums.CacheMedium;
import com.framework.cloud.cache.enums.CacheType;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.platform.common.constant.PlatformConstant;
import com.framework.cloud.platform.common.dto.PayChannelDTO;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.msg.PlatformMsg;
import com.framework.cloud.platform.common.vo.PayChannelInfoVO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;
import com.framework.cloud.platform.domain.entity.PayChannel;
import com.framework.cloud.platform.domain.repository.PayChannelRepository;
import com.framework.cloud.platform.domain.service.PayChannelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 支付渠道 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PayChannelServiceImpl implements PayChannelService {

    private final PayChannelRepository payChannelRepository;

    @Override
    public PageVO<PayChannelPageVO> page(PayChannelPageDTO param) {
        return payChannelRepository.page(param);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.CHANNEL + "'+#id", type = CacheType.READ_WRITE, medium = CacheMedium.FULL)
    public PayChannelInfoVO info(Long id) {
        return payChannelRepository.info(id);
    }

    @Override
    public boolean save(PayChannelDTO param) {
        PayChannelInfoVO exist = payChannelRepository.info(param.getCode());
        AssertUtil.nonNull(exist, PlatformMsg.PAY_CHANNEL_EXIST.getMsg());
        PayChannel payChannel = new PayChannel();
        CopierUtil.copyProperties(param, payChannel);
        return payChannelRepository.save(payChannel);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.CHANNEL + "'+#param.id", type = CacheType.DEL, medium = CacheMedium.FULL)
    public boolean update(PayChannelDTO param) {
        PayChannel payChannel = payChannelRepository.getByIdNotNull(param.getId());
        PayChannelInfoVO exist = payChannelRepository.info(param.getCode());
        if (ObjectUtil.isNotNull(exist)) {
            AssertUtil.isTrue(exist.getId().equals(payChannel.getId()), PlatformMsg.PAY_CHANNEL_EXIST.getMsg());
        }
        CopierUtil.copyProperties(param, payChannel);
        return payChannelRepository.saveOrUpdate(payChannel);
    }

    @Override
    @Cache(key = "'" + PlatformConstant.CHANNEL + "'+#id", type = CacheType.DEL, medium = CacheMedium.FULL)
    public boolean enable(Long id, boolean enable) {
        PayChannel payChannel = payChannelRepository.getByIdNotNull(id);
        if (enable) {
            AssertUtil.isFalse(payChannel.getEnable(), PlatformMsg.PAY_CHANNEL_ENABLE.getMsg());
        } else {
            AssertUtil.isTrue(payChannel.getEnable(), PlatformMsg.PAY_CHANNEL_DISABLE.getMsg());
        }
        payChannel.setEnable(enable);
        return payChannelRepository.updateById(payChannel);
    }
}