package com.ljf.jibinservice.entity;

import com.ljf.jibinservice.common.livy.SessionState;
import com.ljf.jibinservice.common.task.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */

@Table(name = "stream_task_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StreamTaskInfo {
    @Id
    @Column(name = "task_id")
    private Integer taskId; // 任务ID
    @Column(name = "task_state")
    private SessionState taskState;//任务状态
    @Column(name = "task_start_time")
    private Date taskStartTime; //任务开始时间
    @Column(name = "task_finish_time")
    private Date taskFinishTime; //任务完成时间
    @Column(name = "task_type")
    private TaskType taskType; // 任务类型
    @Column(name = "biz_id")
    private Integer bizId; // 对应业务Id
}