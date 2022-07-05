package com.atguigu.service;

import com.atguigu.entity.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author hxld
 * @create 2022-07-01 20:23
 */
public interface EmpService {
    List<Emp> getALL();

    //分页实现
    PageInfo<Emp> getPageInfo(Integer pageNo);


    //删除
    void doDeleteEmpByPrimaryId(Integer empId);

    //新增
    void doAdd(Emp emp);

    //查询
    Emp  selectEmpById(Integer empId);

    //更新
    void doUpdate(Emp emp);
}
