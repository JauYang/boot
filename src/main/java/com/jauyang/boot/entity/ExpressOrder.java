package com.jauyang.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Yann
 * @date 2021-08-26 11:16
 */
@Data
@TableName("t_express_order")
@Builder
public class ExpressOrder implements Serializable {

    private static final long serialVersionUID = 5011315517739308402L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "寄件人姓名")
    private String fromName;

    @ApiModelProperty(value = "寄件人手机号")
    private String fromPhone;

    @ApiModelProperty(value = "收件人姓名")
    private String toName;

    @ApiModelProperty(value = "收件人手机号")
    private String toPhone;

}
