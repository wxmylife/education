package com.wxmylife.eduservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author abby
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历，一句话说明")
    private String career;

    @ApiModelProperty(value = "头衔 1高级 2首席")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
