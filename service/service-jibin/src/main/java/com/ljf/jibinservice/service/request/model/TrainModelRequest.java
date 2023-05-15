package com.ljf.jibinservice.service.request.model;

import com.ljf.jibinservice.common.model.ModelType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
@ApiModel(value = "trainModelRequest",description = "模型训练参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainModelRequest {
    @ApiModelProperty("模型名称")
    @NotBlank(message = "模型名称不能为空")
    private String modelName;
    @ApiModelProperty("模型类型")
    @NotNull(message = "请选择模型")
    private ModelType modelType;
}