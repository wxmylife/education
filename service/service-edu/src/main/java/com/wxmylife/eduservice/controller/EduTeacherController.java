package com.wxmylife.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxmylife.education.utils.CommonPage;
import com.wxmylife.education.utils.CommonResult;
import com.wxmylife.eduservice.entity.EduTeacher;
import com.wxmylife.eduservice.entity.vo.TeacherQuery;
import com.wxmylife.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author abby
 * @since 2020-10-20
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

  @Autowired
  private EduTeacherService teacherService;

  @ApiOperation("所有讲师列表")
  @GetMapping
  public CommonResult<List<EduTeacher>> findAllTeacher() {
    return CommonResult.success(teacherService.list());

  }

  @ApiOperation("根据id删除讲师")
  @DeleteMapping("{id}")
  public CommonResult deleteTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable("id") String id) {
    if (teacherService.removeById(id)) {
      return CommonResult.success(null);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("分页查询")
  @GetMapping("pageTeacher/{page}/{limit}")
  public CommonResult<CommonPage<EduTeacher>> queryTeacherToPage(@ApiParam(name = "page", value = "页码", required = true) @PathVariable("page") long page,
                                                                 @ApiParam(name = "limit", value = "分页数据数", required = true) @PathVariable("limit") long limit) {
    Page<EduTeacher> teacherPage = new Page<>(page, limit);
    teacherService.page(teacherPage, null);
    return CommonResult.success(CommonPage.restPage(teacherPage));
  }

  @ApiOperation("分页条件查询")
  @GetMapping("pageTeacherCondition/{page}/{limit}")
  public CommonResult<CommonPage<EduTeacher>> queryTeacherToPageCondition(
      @ApiParam(name = "page", value = "页码", required = true) @PathVariable("page") long page,
      @ApiParam(name = "limit", value = "分页数据数", required = true) @PathVariable("limit") long limit,
      TeacherQuery teacherQuery) {
    Page<EduTeacher> teacherPage = new Page<>(page, limit);
    QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

    if (!StringUtils.isEmpty(teacherQuery.getName())) {
      wrapper.like("name", teacherQuery.getName());
    }

    if (teacherQuery.getLevel() != null) {
      wrapper.eq("level", teacherQuery.getLevel());
    }

    if (!StringUtils.isEmpty(teacherQuery.getBegin())) {
      wrapper.ge("gmt_create", teacherQuery.getBegin());
    }

    if (!StringUtils.isEmpty(teacherQuery.getEnd())) {
      wrapper.le("gmt_create", teacherQuery.getEnd());
    }

    teacherService.page(teacherPage, wrapper);
    return CommonResult.success(CommonPage.restPage(teacherPage));
  }

  @PostMapping("addTeacher")
  @ApiOperation("添加讲师")
  public CommonResult addTeacher(@RequestBody EduTeacher eduTeacher) {
    if (teacherService.save(eduTeacher)) {
      return CommonResult.success(eduTeacher);
    } else {
      return CommonResult.failed();
    }
  }

  @GetMapping("{id}")
  @ApiOperation("查询")
  public CommonResult addTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable("id") String id) {
    return CommonResult.success(teacherService.getById(id));
  }

  @PutMapping("update")
  @ApiOperation("更新")
  public CommonResult updateTeacher(@RequestBody EduTeacher eduTeacher) {
    if (teacherService.updateById(eduTeacher)) {
      return CommonResult.success(null);
    } else {
      return CommonResult.failed();
    }
  }
}


