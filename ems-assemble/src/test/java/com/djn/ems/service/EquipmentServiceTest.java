package com.djn.ems.service;

import com.djn.ems.domain.Equipment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EquipmentServiceTest {

    /**
     * 测试初始化是否正确
     */
    @Test
    public void testInit() {
        EquipmentService eps = new EquipmentService();

        assertNotNull(eps.getAllEquipments(), "初始化失败");
//        System.out.println(Arrays.toString(eps.getAllEquipments()));
    }

    /**
     * 测试寻找指定设备
     */
    @Test
    public void testGetEquipment() {
        EquipmentService eps = new EquipmentService();


        try {
            // 正常id
            assertNotNull(eps.getEquipment(2));
            // 不存在id
            assertThrows(EMSException.class, () -> eps.getEquipment(50));
        }catch (EMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试设备对象列表序列化
     */
    @Test
    public void testSave() {
        EquipmentService eps = new EquipmentService();
        List<Equipment> list = eps.getAllEquipments();
        System.out.println(list);
        for (Equipment e : list) {
            e.setStatus(Status.USED);
        }
        System.out.println(list);
        assertDoesNotThrow(eps::save);

    }
}
