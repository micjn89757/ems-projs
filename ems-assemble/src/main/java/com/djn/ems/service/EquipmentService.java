package com.djn.ems.service;

import com.djn.ems.domain.Equipment;

import java.util.Arrays;

/**
 * 设备管理器
 */
public class EquipmentService {
    /**
     * 设备生成的唯一id
     */
    private static int total = 1;

    /**
     * 保存所有设备对象的数组
     */
    private Equipment[] eqs;

    /**
     * 根据项目提供的Data类构建相应大小的Equipment数组
     *
     */
    public EquipmentService() {

    }


    public Equipment[] getAllEquipments() {
        return Arrays.copyOf(eqs, eqs.length);
    }

    /**
     * 返回指定设备
     * @param id 设备id
     * @return 设备对象
     * @throws EMSException
     */
    public Equipment getEquipment(int id) throws EMSException {
        return null;
    }
}
