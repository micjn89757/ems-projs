package com.djn.ems.service;

import com.djn.ems.dao.EmployeeDAO;
import com.djn.ems.domain.*;

import java.io.IOException;
import java.util.*;

/**
 * 内部数据不允许外部随意修改，具有更好的封装性
 */
public class EmployeeService {
    /**
     * 最大开发人员数量
     */
    private static final int MAX_DEVELOPER = 10;

    private final EmployeeDAO dao = new EmployeeDAO();
     /**
     * 存放员工的列表
     */
    private final List<Employee> list;

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


    public EmployeeService() {
        list = dao.getList();
    }

    /**
     * 向员工列表中的最后追加员工
     *
     * @param emp 员工对象，可以是普通员工、程序员、设计师和架构师
     *  错误消息:
     *        设备正在使用中，无法领用
     *        设备已经报废，无法领用
     *        开发人员已满，无法添加
     *        团队中只能由五名程序员
     *        团队中只能有三名设计师
     *        团队中只能有两名架构师
     */
    public void addEmployee(Employee emp) throws EMSException {
        if (list.size() == MAX_DEVELOPER) {
            throw new EMSException("开发人员已满，无法添加");
        }

        // 可能会出现NPE
        Class<? extends Employee> empClass = emp.getClass();

        if (Objects.equals(empClass.getName(), Architect.class.getName())) {
            if (archCount < 2) {
                archCount++;
            }else {
                throw new EMSException("架构师不能超过两个人");
            }
        }else if (Objects.equals(empClass.getName(), Designer.class.getName())) {
            if (desCount < 3) {
                desCount++;
            }else {
                throw new EMSException("设计师不能超过三个人");
            }
        }else if (Objects.equals(empClass.getName(), Programmer.class.getName())) {
            if (progCount < 5) {
                progCount++;
            }else {
                throw new EMSException("程序员不能超过五个人");
            }
        }

        // 添加员工
        list.add(emp);
    }

    /**
     * 删除员工列表里面的指定员工
     * @param index 删除的员工编号,从1开始
     */
    public void removeEmployee(int index) throws EMSException {
        // 没有员工，编号不存在，都是删除失败
        if (list.size() == 0 || index > MAX_DEVELOPER || index <= 0) {
            throw new EMSException("未找到员工id");
        }

        Class<? extends Employee> empClass = list.get(index - 1).getClass();

        if (Objects.equals(empClass.getName(), Architect.class.getName())) {
            archCount--;
        }else if (Objects.equals(empClass.getName(), Designer.class.getName())) {
            desCount--;
        }else if (Objects.equals(empClass.getName(), Programmer.class.getName())) {
            progCount--;
        }

        // 删除操作
        list.remove(index - 1);
    }

    /**
     * 返回员工列表
     * @return 员工列表
     */
    public List<Employee> getAllEmployees() {
        List<Employee> tempList = new ArrayList<>(list.size());
        Collections.copy(tempList, list);
        return tempList;
    }

    /**
     * 获取某一员工对象
     * @param index 员工编号
     * @return 员工对象
     */
    public Employee getEmployee(int index) throws EMSException {
        if (index <= 0 || index > MAX_DEVELOPER) {
            throw new EMSException("未找到指定员工或索引不合法");
        }

        return list.get(index - 1);
    }

    /**
     * 返回员工数量
     */
    public int getEmpNums() {
        return list.size();
    }

    /**
     * 保存员工数据到文件中
     */
    public void save() throws IOException {
        try {
            dao.save(list);
        } catch (EMSException e) {
            throw new IOException("数据文件不存在或无法访问");
        }
    }


}
