package com.djn.ems.view;

import com.djn.ems.domain.Employee;
import com.djn.ems.service.EmployeeService;

import java.util.Objects;
import java.util.Scanner;


/**
 * 菜单显示和处理用户操作
 */
public class EmployeeView {
    /**
     * 关联服务模块
     */
    private EmployeeService employeeService = new EmployeeService();

    /**
     * 进入主菜单，是项目的真正入口,不可以轻易结束
     */
    public void enterMainMenu() {

    }

    /**
     * 添加新员工
     */
    public void addNewEmployee() {

    }

    /**
     * 修改员工
     */
    private void modifyEmployee() {
        // 逻辑就是通过getEmployee获取相应对象更改其属性，就不实现了
        System.out.println("修改员工");
    }

    /**
     * 删除员工
     */
    private void deleteEmployee() {
    }

    /**
     * 员工列表
     */
    private void listAllEmployees() {
    }
}
