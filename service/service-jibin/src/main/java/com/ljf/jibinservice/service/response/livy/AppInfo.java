package com.ljf.jibinservice.service.response.livy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppInfo {
    @ApiModelProperty
    private String driverLogUrl;
    @ApiModelProperty
    private String sparkUiUrl;
}
