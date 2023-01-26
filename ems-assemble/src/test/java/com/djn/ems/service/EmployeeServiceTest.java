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
        // 最多只能有两名架构师
        for (int i = 0; i < 2; i++) {
            try {
                employeeService.addEmployee(new Architect());
            } catch (EMSException e) {
                e.printStackTrace();
            }
        }
        Throwable emsException1 = assertThrows(EMSException.class, () -> employeeService.addEmployee(new Architect()));
        assertEquals("架构师不能超过两个人", emsException1.getMessage());

        // 最多只能有三名设计师
        for (int i = 0; i < 3; i++) {
            try {
                employeeService.addEmployee(new Designer());
            } catch (EMSException e) {
                e.printStackTrace();
            }
        }
        Throwable emsException2 = assertThrows(EMSException.class, () -> employeeService.addEmployee(new Designer()));
        assertEquals("设计师不能超过三个人", emsException2.getMessage());

        // 最多只能有五名程序员
        for (int i = 0; i < 5; i++) {
            try {
                employeeService.addEmployee(new Programmer());
            } catch (EMSException e) {
                e.printStackTrace();
            }
        }
        Throwable emsException3 = assertThrows(EMSException.class, () -> employeeService.addEmployee(new Programmer()));
        assertEquals("程序员不能超过五个人", emsException3.getMessage());

        // 开发人员已满
        for (int i = 0; i < 5; i++) {
            try {
                employeeService.addEmployee(new Employee());
            } catch (EMSException e) {
                e.printStackTrace();
            }
        }
        Throwable emsException4 = assertThrows(EMSException.class, () -> employeeService.addEmployee(new Employee()));
        assertEquals("开发人员已满，无法添加", emsException4.getMessage());

    }

    /**
     * 测试删除员工功能
     */
    @Test
    public void testRemoveEmployee() {
        EmployeeService employeeService = new EmployeeService();

        // 列表为空
        assertThrows(EMSException.class, () -> employeeService.removeEmployee(1));
        // 编号越界
        try {
            employeeService.addEmployee(new Employee());
        } catch (EMSException e) {
            e.printStackTrace();
        }
        assertThrows(EMSException.class, () -> employeeService.removeEmployee(2));
        assertThrows(EMSException.class, () -> employeeService.removeEmployee(-1));

        // 正常删除
        try {
            employeeService.addEmployee(new Employee());
        } catch (EMSException e) {
            e.printStackTrace();
        }
        assertDoesNotThrow(() -> employeeService.removeEmployee(1));
        // 正常删除完只剩下一个员工
        assertEquals(1, employeeService.getEmpNums());
    }

    /**
     * 测试获取员工列表
     */
    @Test
    public void testGetAllEmployees() {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.addEmployee(new Employee());
            employeeService.addEmployee(new Employee());
        }catch (EMSException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.deepToString(employeeService.getAllEmployees()));
    }

    /**
     * 测试获取某一员工对象
     */
    @Test
    public void testGetEmployee() {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.addEmployee(new Employee());
            employeeService.addEmployee(new Employee());
        }catch (EMSException e) {
            e.printStackTrace();
        }


        // 正常获取
        assertDoesNotThrow(() -> employeeService.getEmployee(2));

        //索引越界
        assertThrows(EMSException.class, () -> employeeService.getEmployee(-1));
        assertThrows(EMSException.class, () ->employeeService.getEmployee(3));
    }

    /**
     * 测试获取员工数量
     */
    @Test
    public void testGetEmpNums() {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.addEmployee(new Employee());
            employeeService.addEmployee(new Employee());
        }catch (EMSException e) {
            e.printStackTrace();
        }

        assertEquals(2, employeeService.getEmpNums());
    }
}
