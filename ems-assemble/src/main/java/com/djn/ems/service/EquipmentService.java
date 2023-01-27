package com.djn.ems.service;

import com.djn.ems.dao.EquipmentDAO;
import com.djn.ems.domain.Equipment;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 设备管理器
 */
public class EquipmentService {
    private final EquipmentDAO dao = new EquipmentDAO();

    /**
     * 获取List
     */
    private final List<Equipment> list;

    public EquipmentService() {
        list = dao.getList();
    }

    /**
     * 返回设备列表
     * @return 设备列表
     */
    public List<Equipment> getAllEquipments() {
        return List.copyOf(list);
    }

    /**
     * 根据id返回指定设备
     * @param id 设备id
     * @return 返回id对应设备对象, 如果不存在抛出异常
     * @throws EMSException
     */
    public Equipment getEquipment(int id) throws EMSException {
        for (Equipment e : list) {
            if (e.getId() == id) {
                return e;
            }
        }

        throw new EMSException("没有找到指定id的设备");
    }

    /**
     * 更新
     */
    public void save() throws IOException {
        try {
            dao.save(list);
        } catch (EMSException e) {
            throw new IOException("数据文件不存在或无法访问");
        }
    }
}
