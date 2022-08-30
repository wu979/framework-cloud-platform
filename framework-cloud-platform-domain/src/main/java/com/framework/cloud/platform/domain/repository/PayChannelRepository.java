package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.vo.PayChannelInfoVO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;
import com.framework.cloud.platform.domain.entity.PayChannel;

/**
 * 支付渠道 数据层接口
 *
 * @author wusiwei
 */
public interface PayChannelRepository extends BaseRepository<PayChannel> {

    /**
     * 支付渠道分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<PayChannelPageVO> page(PayChannelPageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    PayChannelInfoVO info(Long id);

    /**
     * 详情
     *
     * @param code 标识
     * @return 详情
     */
    PayChannelInfoVO info(String code);
}