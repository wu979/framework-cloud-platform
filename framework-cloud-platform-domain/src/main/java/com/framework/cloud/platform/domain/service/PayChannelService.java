package com.framework.cloud.platform.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.platform.common.dto.PayChannelDTO;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.vo.PayChannelInfoVO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;

/**
 * 支付渠道 服务层接口
 *
 * @author wusiwei
 */
public interface PayChannelService {
    /**
     * 支付渠道 分页
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
     * 新增
     *
     * @param param 新增参数
     * @return bool
     */
    boolean save(PayChannelDTO param);

    /**
     * 修改
     *
     * @param param 修改参数
     * @return bool
     */
    boolean update(PayChannelDTO param);

    /**
     * 启、禁用
     *
     * @param id 主键
     * @param enable 启用、禁用
     * @return bool
     */
    boolean enable(Long id, boolean enable);
}