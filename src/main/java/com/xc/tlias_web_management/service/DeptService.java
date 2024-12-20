package com.xc.tlias_web_management.service;

import com.xc.tlias_web_management.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门的数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @return
     */
    void delete(Integer id);

    /**
     * 添加部门
     * @return
     */
    void add(Dept dept);

    /**
     * 查询单个部门的数据
     * @return
     */
    Dept getById(Integer id);

    /**
     * 更新部门
     * @return
     */
    void update(Dept dept);

}
