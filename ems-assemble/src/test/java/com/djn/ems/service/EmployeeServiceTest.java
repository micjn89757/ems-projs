package com.djn.ems.service;

import com.djn.ems.domain.Architect;
import com.djn.ems.domain.Designer;
import com.djn.ems.domain.Employee;
import com.djn.ems.domain.Programmer;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    /**
     * 测试添加员工功能
     * 测试不同错误码是否正确返回
     */
    @Test
    public void testAddEmployee() {
        EmployeeService employeeService = new EmployeeService();
        // 错误码2: 最多只能有两名架构师
        for (int i = 0; i < 2; i++) {
            employeeService.addEmployee(new Architect());
        }
        assertEquals(2, employeeService.addEmployee(new Architect()));

        // 错误码3: 最多只能有三名设计师
        for (int i = 0; i < 3; i++) {
            employeeService.addEmployee(new Designer());
        }
        assertEquals(3, employeeService.addEmployee(new Designer()));

        // 错误4: 最多只能有五名程序员
        for (int i = 0; i < 5; i++) {
            employeeService.addEmployee(new Programmer());
        }
        assertEquals(4, employeeService.addEmployee(new Programmer()));

        // 错误1: 数组已满
        for (int i = 0; i < 5; i++) {
            employeeService.addEmployee(new Employee());
        }
        assertEquals(1, employeeService.addEmployee(new Employee()));

    }

    /**
     * 测试删除员工功能
     */
    @Test
    public void testRemoveEmployee() {
        EmployeeService employeeService = new EmployeeService();

        // 列表为空
        assertFalse(employeeService.removeEmployee(1));
        // 编号越界
        employeeService.addEmployee(new Employee());
        assertFalse(employeeService.removeEmployee(2));
        assertFalse(employeeService.removeEmployee(-1));

        // 正常删除
        employeeService.addEmployee(new Employee());
        assertTrue(employeeService.removeEmployee(1));
        assertEquals(1, employeeService.getEmpNums());
    }

    /**
     * 测试获取员工列表
     */
    @Test
    public void testGetAllEmployees() {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee());
        employeeService.addEmployee(new Employee());

        System.out.println(Arrays.deepToString(employeeService.getAllEmployees()));
    }

    /**
     * 测试获取某一员工对象
     */
    @Test
    public void testGetEmployee() {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee());
        employeeService.addEmployee(new Employee());


        // 正常获取
        assertNotNull(employeeService.getEmployee(2));

        //索引越界
        assertNull(employeeService.getEmployee(-1));
        assertNull(employeeService.getEmployee(3));
    }

    /**
     * 测试获取员工数量
     */
    @Test
    public void testGetEmpNums() {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee());
        employeeService.addEmployee(new Employee());

        assertEquals(2, employeeService.getEmpNums());
    }
}
