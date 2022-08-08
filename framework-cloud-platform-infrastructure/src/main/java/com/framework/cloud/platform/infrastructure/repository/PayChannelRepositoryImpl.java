package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.vo.PayChannelInfoVO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;
import com.framework.cloud.platform.domain.entity.PayChannel;
import com.framework.cloud.platform.domain.repository.PayChannelRepository;
import com.framework.cloud.platform.infrastructure.converter.PayChannelConverter;
import com.framework.cloud.platform.infrastructure.mapper.PayChannelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 支付渠道 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PayChannelRepositoryImpl extends BaseRepositoryImpl<PayChannelMapper, PayChannel> implements PayChannelRepository {

    private final PayChannelConverter payChannelConverter;

    @Override
    public PageVO<PayChannelPageVO> page(PayChannelPageDTO param) {
        Page<PayChannelPageVO> page = PageParam.buildOrder(param);
        IPage<PayChannelPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public PayChannelInfoVO info(Long id) {
        PayChannel payChannel = this.getById(id);
        return payChannelConverter.info(payChannel);
    }

    @Override
    public PayChannelInfoVO info(String code) {
        LambdaQueryWrapper<PayChannel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PayChannel::getCode, code);
        PayChannel payChannel = this.getOne(wrapper);
        return payChannelConverter.info(payChannel);
    }
}