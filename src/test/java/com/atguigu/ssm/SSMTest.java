package com.atguigu.ssm;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atguigu.entity.Emp;
import com.atguigu.mapper.EmpMapper;
import com.atguigu.service.EmpService;
import com.atguigu.service.impl.EmpServiceImpl;
import org.apache.ibatis.javassist.ClassPath;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hxld
 * @create 2022-07-01 20:44
 */
@SpringJUnitConfig(locations = {"classpath:spring-persist.xml"})
public class SSMTest {
    @Autowired
    private DruidDataSource dataSource;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpService empService;

    @Test
    public void testtx(){
        List<Emp> empList = empService.getALL();
        for (Emp emp : empList) {
            System.out.println("emp=" +emp);
        }
    }

    @Test
    public void testList(){
        List<Emp> empList = empMapper.getAllEmp();
        for (Emp emp : empList) {
            System.out.println("emp=" +emp);
        }
    }


    //使用日志进行输出，需要在logback.xml中设置类的日志级别为DUBUG
   Logger logger =  LoggerFactory.getLogger(getClass());

    @Test
    public void testConn() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
        //使用日志级别输出
        logger.debug(connection.toString());
    }
}
