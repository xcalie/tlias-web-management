package com.xc.tlias_web_management.controller;

import com.xc.tlias_web_management.pojo.Dept;
import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*@RequestMapping(value = "/depts", method = RequestMethod.GET)//指定请求方式为GET*/

    /**
     * 查询全部部门的数据
     * @return
     */
    @GetMapping//简写方式
    public Result list(){
        log.info("查询全部部门的数据");

        //调用Service层的方法
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}", id);

        //调用Service层的方法
        deptService.delete(id);

        return Result.success();
    }

    /**
     * 添加部门
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody Dept dept){
        log.info("添加部门:{}", dept);

        //调用Service层的方法
        deptService.add(dept);

        return Result.success();
    }

    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询部门:{}", id);

        //调用Service层的方法
        Dept dept = deptService.getById(id);

        return Result.success(dept);
    }

    /**
     * 修改部门
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门:{}", dept);

        //调用Service层的方法
        deptService.update(dept);

        return Result.success();
    }
}
