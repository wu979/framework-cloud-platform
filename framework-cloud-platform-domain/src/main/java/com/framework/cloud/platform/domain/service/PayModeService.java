package com.framework.cloud.platform.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.platform.common.dto.PayModeDTO;
import com.framework.cloud.platform.common.dto.PayModePageDTO;
import com.framework.cloud.platform.common.vo.PayModeAvailableVO;
import com.framework.cloud.platform.common.vo.PayModeInfoVO;
import com.framework.cloud.platform.common.vo.PayModeListVO;
import com.framework.cloud.platform.common.vo.PayModePageVO;

import java.util.List;

/**
 * 支付方式 服务层接口
 *
 * @author wusiwei
 */
public interface PayModeService {
    /**
     * 支付方式 分页
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
    List<PayModeListVO> list(Long id);

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
     * 新增
     *
     * @param param 新改参数
     * @return bool
     */
    boolean save(PayModeDTO param);

    /**
     * 修改
     *
     * @param param 修改参数
     * @return bool
     */
    boolean update(PayModeDTO param);

    /**
     * 启用、禁用
     *
     * @param id 主键
     * @param enable 启用、禁用
     * @return 是否成功
     */
    boolean enable(Long id, boolean enable);

}