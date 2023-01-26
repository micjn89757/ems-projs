package com.djn.ems.main;

import com.djn.ems.view.EmployeeView;


/**
 * 系统入口
 */
public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeView employeeView = new EmployeeView();
        employeeView.enterMainMenu();
    }
}
