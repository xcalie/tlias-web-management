package com.xc.tlias_web_management.mapper;

import com.xc.tlias_web_management.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询全部员工的数据
     * @return
     */
    //Long count();

    /**
     * 分页查询员工数据
     * @param start
     * @param pageSize
     * @return
     */
    //List<Emp> page(Integer start, Integer pageSize);

    /**
     * 查询全部员工的数据 包括分页
     * @return
     */
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    void insert(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getSimple(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    Emp getByUsernameAndPassword(Emp emp);
}
