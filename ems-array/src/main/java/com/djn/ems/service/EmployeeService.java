package com.djn.ems.service;

import com.djn.ems.domain.Architect;
import com.djn.ems.domain.Designer;
import com.djn.ems.domain.Employee;
import com.djn.ems.domain.Programmer;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 内部数据不允许外部随意修改，具有更好的封装性
 */
public class EmployeeService {
     /**
     * 存放员工的数组
     */
    private static final Employee[] EMPLOYEES = new Employee[15];

    /**
     * 员工数组中真正存在员工数量
     */
    private int realCount = 0;

    /**
     * 员工列表中存在的架构师的数量
     */
    private int archCount = 0;

    /**
     * 员工列表中存在的设计师的数量
     */
    private int desCount = 0;

    /**
     * 员工列表中存在的程序员数量
     */
    private int progCount = 0;


    public EmployeeService() {}

    /**
     * 向员工列表中的最后追加员工
     *
     * @param emp 员工对象，可以是普通员工、程序员、设计师和架构师
     * @return 如果返回0表明添加成功，否则表明添加失败
     *  错误码:1: 表示数组已满无法添加
     *        2: 最多只能有两名架构师
     *        3: 最多只能有三名设计师
     *        4: 最多只能有五名程序员
     */
    public int addEmployee(Employee emp) {
        if (EMPLOYEES.length == realCount) {
            return 1;
        }

        // 可能会出现NPE
        Class<? extends Employee> empClass = emp.getClass();

        // 添加员工
        EMPLOYEES[realCount++] = emp;

        if (Objects.equals(empClass.getName(), Architect.class.getName())) {
            if (archCount < 2) {
                archCount++;
            }else {
                return 2;
            }
        }else if (Objects.equals(empClass.getName(), Designer.class.getName())) {
            if (desCount < 3) {
                desCount++;
            }else {
                return 3;
            }
        }else if (Objects.equals(empClass.getName(), Programmer.class.getName())) {
            if (progCount < 5) {
                progCount++;
            }else {
                return 4;
            }
        }
        return 0;
    }

    /**
     * 删除员工列表里面的指定员工
     * @param index 删除的员工编号,从1开始
     * @return 删除成功返回true，删除失败返回false
     */
    public boolean removeEmployee(int index) {
        /*
            这里也可以和添加员工一样设置明确意义的返回值错误码
        */
        // 没有员工，编号不存在，都是删除失败
        if (realCount == 0 || index > realCount || index <= 0) {
            return false;
        }

        Class<? extends Employee> empClass = EMPLOYEES[index - 1].getClass();
        // 删除操作, 注意防止索引越界
        for (int i = index; i < realCount; i++) {
            EMPLOYEES[i - 1] = EMPLOYEES[i];
        }

        if (Objects.equals(empClass.getName(), Architect.class.getName())) {
            archCount--;
        }else if (Objects.equals(empClass.getName(), Designer.class.getName())) {
            desCount--;
        }else if (Objects.equals(empClass.getName(), Programmer.class.getName())) {
            progCount--;
        }

        realCount--;
        return true;
    }

    /**
     * 返回列表
     * @return 员工列表
     */
    public Employee[] getAllEmployees() {
        return Arrays.copyOf(EMPLOYEES, realCount);
    }

    /**
     * 获取某一员工对象
     * @param index 员工编号
     * @return 员工对象
     */
    public Employee getEmployee(int index) {
        if (index <= 0 || index > realCount) {
            return null;
        }

        return EMPLOYEES[index - 1];
    }

    /**
     * 返回员工数量
     */
    public int getEmpNums() {
        return this.realCount;
    }


}
