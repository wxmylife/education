package com.wxmylife.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "Teacher对象查新",description = "讲师查询对象封装")
@Data
public class TeacherQuery implements Serializable {

  public static final long serialVersionUID=1L;

  @ApiModelProperty("教师名称,模糊查询")
  private String name;

  @ApiModelProperty("头衔")
  private Integer level;

  @ApiModelProperty(value = "开始时间",example = "2020-01-01 10:10:10")
  private String begin;

  @ApiModelProperty(value = "结束时间",example = "2020-01-01 10:10:10")
  private String end;
}
