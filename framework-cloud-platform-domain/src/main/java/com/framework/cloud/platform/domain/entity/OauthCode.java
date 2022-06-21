package com.framework.cloud.platform.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 授权码 实体
 *
 * @author wusiwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_oauth_code")
@ApiModel(value="授权码对象", description="授权码")
public class OauthCode {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "授权码")
    private String code;

    @ApiModelProperty(value = "授权用户二进制信息")
    private byte[] authentication;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expiresTime;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Long createTime;
}