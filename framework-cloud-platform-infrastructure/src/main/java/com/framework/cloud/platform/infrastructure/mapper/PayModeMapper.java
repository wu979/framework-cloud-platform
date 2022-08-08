package com.framework.cloud.platform.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.platform.common.vo.*;
import com.framework.cloud.platform.common.dto.*;
import com.framework.cloud.platform.domain.entity.PayMode;
import org.apache.ibatis.annotations.Param;

/**
 * 支付方式 数据库接口
 *
 * @author wusiwei
 */
public interface PayModeMapper extends BaseMapper<PayMode> {

    IPage<PayModePageVO> page(@Param("pg") Page<PayModePageVO> page, @Param("param") PayModePageDTO param);

}