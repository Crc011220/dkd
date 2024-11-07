package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Task;
import com.dkd.manage.domain.TaskType;

public class TaskVo extends Task {

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    // 工单类型
    private TaskType taskType;

    @Override
    public String toString() {
        return "TaskVo{" +
                "taskType=" + taskType +
                '}';
    }
}