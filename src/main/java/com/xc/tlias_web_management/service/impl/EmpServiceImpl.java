package com.xc.tlias_web_management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xc.tlias_web_management.mapper.EmpMapper;
import com.xc.tlias_web_management.pojo.Emp;
import com.xc.tlias_web_management.pojo.PageBean;
import com.xc.tlias_web_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Short gender, LocalDate begin, LocalDate end) {
        /*//获取总记录数
        Long count = empMapper.count();

        //获取当前页员工数据
        Integer start = (page - 1) * pageSize;
        List<Emp> emps = empMapper.page(start, pageSize);*/

        //获取全部员工数据
        PageHelper.startPage(page, pageSize);

        //获取全部员工数据
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //返回分页数据
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setPassword("123456");

        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getSimple(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
