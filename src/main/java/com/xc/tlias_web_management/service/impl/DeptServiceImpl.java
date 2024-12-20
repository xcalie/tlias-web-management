package com.xc.tlias_web_management.service.impl;

import com.xc.tlias_web_management.aop.MyLog;
import com.xc.tlias_web_management.mapper.DeptMapper;
import com.xc.tlias_web_management.pojo.Dept;
import com.xc.tlias_web_management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @MyLog
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @MyLog
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getSimple(id);
    }

    @MyLog
    @Override
    public void update(Dept newDept) {
        Dept oldDept = deptMapper.getSimple(newDept.getId());
        oldDept.setName(newDept.getName());
        oldDept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(oldDept);
    }
}
