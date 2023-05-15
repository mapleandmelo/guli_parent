package com.ljf.jibinservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujingfeng
 * @since 2022-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TestGuanxinbin对象", description="")
public class TestGuanxinbin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String male;

    private String age;

    private String education;

    @TableField("currentSmoker")
    private String currentSmoker;

    @TableField("cigsPerDay")
    private String cigsPerDay;

    @TableField("BPMeds")
    private String BPMeds;

    @TableField("prevalentStroke")
    private String prevalentStroke;

    @TableField("prevalentHyp")
    private String prevalentHyp;

    private String diabetes;

    @TableField("totChol")
    private String totChol;

    @TableField("sysBP")
    private String sysBP;

    @TableField("diaBP")
    private String diaBP;

    @TableField("BMI")
    private String bmi;

    @TableField("heartRate")
    private String heartRate;

    private String glucose;

    @TableField("TenYearCHD")
    private String TenYearCHD;


}
