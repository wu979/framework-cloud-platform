package com.framework.cloud.platform.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.platform.common.dto.PayChannelPageDTO;
import com.framework.cloud.platform.common.vo.PayChannelPageVO;
import com.framework.cloud.platform.domain.entity.PayChannel;
import org.apache.ibatis.annotations.Param;

/**
 * 支付渠道 数据库接口
 *
 * @author wusiwei
 */
public interface PayChannelMapper extends BaseMapper<PayChannel> {

    IPage<PayChannelPageVO> page(@Param("pg") Page<PayChannelPageVO> page, @Param("param") PayChannelPageDTO param);

}