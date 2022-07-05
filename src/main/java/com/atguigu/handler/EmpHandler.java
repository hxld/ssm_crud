package com.atguigu.handler;

import com.atguigu.entity.Emp;
import com.atguigu.service.EmpService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hxld
 * @create 2022-07-01 20:23
 */
@Controller
public class EmpHandler {
        @Autowired
        private EmpService empService;
        @RequestMapping("/get/all")
        public String getALLEmpList(Model model){
            List<Emp> empList = empService.getALL();
            model.addAttribute("empList",empList);
            return "emp-list";
        }

        @RequestMapping("/get/page/{pageNo}")
         public String getPage(
                 @PathVariable("pageNo")Integer pageNo,
                 Model model
        ){
            PageInfo<Emp> pageInfo = empService.getPageInfo(pageNo);
            model.addAttribute("pageInfo",pageInfo);
            return "emp-page";
        }

        @RequestMapping(value="/emp/{empId}/{pageNo}",method = RequestMethod.DELETE)
    public String doDelete(
            @PathVariable("empId")Integer empId,
            @PathVariable("pageNo")Integer pageNo
        ){
            empService.doDeleteEmpByPrimaryId(empId);
            return "redirect:/get/page/"+pageNo;
        }

        @RequestMapping(value="/emp",method = RequestMethod.POST)
        public String doSave(Emp emp){
            empService.doAdd(emp);

            return "redirect:/get/page/"+Integer.MAX_VALUE;
        }

        @RequestMapping(value="/emp/{empId}/{pageNo}",method =RequestMethod.GET)
        public  String selectAll(
                @PathVariable("empId")Integer empId,
                @PathVariable("pageNo")Integer pageNo,
                Model model
        ){
            Emp emp = empService.selectEmpById(empId);
            //将实体类对象存入模型
            model.addAttribute("emp");
            return "emp-add";

        }

        @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String update(
            Emp emp,
            @RequestParam("pageNo") Integer pageNo
        ){
            empService.doUpdate(emp);
            return "redirect:/get/page/"+pageNo;
        }

}
