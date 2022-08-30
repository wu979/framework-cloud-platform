package com.framework.cloud.platform.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.enums.platform.PayModeType;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.platform.common.dto.PayModePageDTO;
import com.framework.cloud.platform.common.vo.PayModeAvailableVO;
import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.common.vo.PayModePageVO;
import com.framework.cloud.platform.domain.entity.PayMode;

import java.util.List;

/**
 * 支付方式 数据层接口
 *
 * @author wusiwei
 */
public interface PayModeRepository extends BaseRepository<PayMode> {

    /**
     * 支付方式分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<PayModePageVO> page(PayModePageDTO param);

    /**
     * 支付方式 列表
     *
     * @param id 支付渠道主键
     * @return 支付方式列表
     */
    List<PayModeListVO> listByChannelId(Long id);

    /**
     * 支付方式 可用列表
     *
     * @return 支付方式列表
     */
    List<PayModeAvailableVO> availableList();

    /**
     * 详情
     *
     * @param id 主键
     * @return 详情
     */
    PayModeInfoVO info(Long id);

    /**
     * 详情
     *
     * @param modeType 支付方式类型
     * @return 详情
     */
    PayModeInfoVO info(PayModeType modeType);

}