package com.xc.tlias_web_management.mapper;

import com.xc.tlias_web_management.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门的数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @return
     */
    void deleteById(Integer id);

    /**
     * 添加部门
     * @return
     */
    void insert(Dept dept);

    /**
     * 查询单个部门的数据
     * @return
     */
    Dept getSimple(Integer id);

    /**
     * 更新部门
     * @return
     */
    void update(Dept dept);
}
