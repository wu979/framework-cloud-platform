package com.framework.cloud.platform.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.platform.common.dto.PayModePageDTO;
import com.framework.cloud.platform.common.enums.PayModeType;
import com.framework.cloud.platform.common.vo.PayModeAvailableVO;
import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.common.vo.PayModePageVO;
import com.framework.cloud.platform.domain.entity.PayMode;
import com.framework.cloud.platform.domain.repository.PayModeRepository;
import com.framework.cloud.platform.infrastructure.converter.PayModeConverter;
import com.framework.cloud.platform.infrastructure.mapper.PayModeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 支付方式 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PayModeRepositoryImpl extends BaseRepositoryImpl<PayModeMapper, PayMode> implements PayModeRepository {

    private final PayModeConverter payModeConverter;

    @Override
    public PageVO<PayModePageVO> page(PayModePageDTO param) {
        Page<PayModePageVO> page = PageParam.buildOrder(param);
        IPage<PayModePageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public List<PayModeListVO> listByChannelId(Long id) {
        LambdaQueryWrapper<PayMode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PayMode::getChannelId, id);
        List<PayMode> payModeList = this.list(wrapper);
        return payModeConverter.list(payModeList);
    }

    @Override
    public List<PayModeAvailableVO> availableList() {
        return this.baseMapper.availableList();
    }

    @Override
    public PayModeInfoVO info(Long id) {
        PayMode payMode = this.getById(id);
        return payModeConverter.info(payMode);
    }

    @Override
    public PayModeInfoVO info(PayModeType modeType) {
        LambdaQueryWrapper<PayMode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PayMode::getModeType, modeType);
        PayMode payMode = this.getOne(wrapper);
        return payModeConverter.info(payMode);
    }
}