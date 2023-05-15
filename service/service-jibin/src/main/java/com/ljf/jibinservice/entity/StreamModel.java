package com.ljf.jibinservice.entity;

import com.ljf.jibinservice.common.model.ModelState;
import com.ljf.jibinservice.common.model.ModelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import javax.persistence.*;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
@Table(name = "streammodel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "JDBC")
    @Column(name = "streamModelId")
    private Integer streamModelId;
    @Column(name = "adminId")
    private Integer adminId;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "modelName")
    private String modelName;
    @Column(name = "modelParameter")
    private String modelParameter;
    @Column(name = "modelUrl")
    private String modelUrl;
    @Column(name = "state")
    private ModelState state;
    @Column(name = "model_type")
    private ModelType modelType;
}
