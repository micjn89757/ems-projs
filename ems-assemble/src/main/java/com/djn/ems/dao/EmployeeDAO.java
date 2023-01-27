package com.djn.ems.dao;

import com.djn.ems.domain.Employee;
import com.djn.ems.service.EMSException;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeDAO {
    /**
     * 保存设备数据的二进制文件名
     */
    private final String filename = "employees.dat";

    /**
     * 接收所有员工对象的列表
     */
    public List<Employee> getList() {
        String url = Objects.requireNonNull(Objects.requireNonNull(EmployeeDAO.class.getClassLoader().getResource("static/" + filename)).getFile());
        Path path = Paths.get(url.substring(1));
        List<Employee> list = new ArrayList<>();

        // 数据文件不存在则创建
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileInputStream fis = new FileInputStream(path.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object object = ois.readObject();
            // 做一下类型校验
            if (object instanceof List<?> obj) {
                for (Object o : obj) {
                    list.add((Employee) o);
                }
            }
            return list;
        }catch (Exception e) {
            return list;
        }
    }

    /**
     * 保存所有员工到文件中, 使用对象序列化的方式
     */
    public void save(List<Employee> list) throws EMSException{
        String url = Objects.requireNonNull(Objects.requireNonNull(EmployeeDAO.class.getClassLoader().getResource("static/" + filename)).getFile());
        Path path = Paths.get(url.substring(1));


        try (FileOutputStream fos = new FileOutputStream(path.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        }catch (IOException e) {
            throw new EMSException("数据文件不存在或无法访问");
        }
    }
}
