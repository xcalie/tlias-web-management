package com.xc.tlias_web_management.controller;

import com.xc.tlias_web_management.pojo.Emp;
import com.xc.tlias_web_management.pojo.PageBean;
import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理控制器
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工数据
     * @param page 页数
     * @param pageSize 大小
     * @param name
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("页数: {}, 大小: {}", page, pageSize);

        //调用分页查询员工数据的业务逻辑
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    /**
     * 根据id查询员工数据
     * @param ids
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工: {}", ids);

        //调用删除员工的业务逻辑
        empService.delete(ids);

        return Result.success();
    }

    /**
     * 添加员工
     * @param emp
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工: {}", emp);

        //调用添加员工的业务逻辑
        empService.add(emp);

        return Result.success();
    }

    /**
     * 根据id查询员工
     * @param id
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询员工: {}", id);

        //调用根据id查询员工的业务逻辑
        Emp emp = empService.getById(id);

        return Result.success(emp);
    }

    /**
     * 修改员工
     * @param emp
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工: {}", emp);

        //调用修改员工的业务逻辑
        empService.update(emp);

        return Result.success();
    }
}
