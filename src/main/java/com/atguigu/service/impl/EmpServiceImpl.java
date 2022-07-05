package com.atguigu.service.impl;

import com.atguigu.entity.Emp;
import com.atguigu.mapper.EmpMapper;
import com.atguigu.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxld
 * @create 2022-07-01 20:23
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    @Transactional(readOnly = true)
    public List<Emp> getALL() {
        return empMapper.getAllEmp();
    }

    @Override
    public PageInfo<Emp> getPageInfo(Integer pageNo) {
        //设置每页显示的数据条数
        int pageSize = 6;

        //设定分页数据，开启分页功能
        PageHelper.startPage(pageNo,pageSize);


        //执行查询功能
        List<Emp> empList = empMapper.getAllEmp();

        //封装为pageInfo对象返回
        return new PageInfo<>(empList);

    }

    @Override
    public void doDeleteEmpByPrimaryId(Integer empId) {
        empMapper.deleteEmpByPrimaryId(empId);
    }

    @Override
    public void doAdd(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public Emp selectEmpById(Integer empId) {

        return empMapper.selectedEmpByPrimaryId(empId);
    }

    @Override
    public void doUpdate(Emp emp) {
        empMapper.doUpdate(emp);
    }
}
