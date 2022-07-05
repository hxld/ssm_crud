package com.atguigu.mapper;

import com.atguigu.entity.Emp;

import java.util.List;

/**
 * @author hxld
 * @create 2022-07-01 20:22
 */
public interface EmpMapper {
    List<Emp>  getAllEmp();

    void deleteEmpByPrimaryId(Integer empId);

    void insert(Emp emp);

    Emp selectedEmpByPrimaryId(Integer empId);

    void doUpdate(Emp emp);
}
