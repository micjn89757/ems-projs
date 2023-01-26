package com.djn.ems.service;

import com.djn.ems.domain.Equipment;
import com.djn.ems.domain.NoteBook;
import com.djn.ems.domain.NotePad;
import com.djn.ems.domain.PC;

import java.util.Arrays;


/**
 * 设备管理器
 */
public class EquipmentService {
    /**
     * 为设备生成的唯一id
     */
    private static int total = 1;

    /**
     * 保存所有设备对象的数组
     */
    private final Equipment[] eqs;

    /**
     * 根据项目提供的Data类构建相应大小的Equipment数组
     * Data类中有一个二维数组，每个子数组代表一个子类对象的数据
     */
    public EquipmentService() {
        eqs = new Equipment[Data.EQUIPMENT.length];

        for (int i = 0; i < Data.EQUIPMENT.length; i++) {
            // 根据id创建不同的设备对象并添加进eqs
            if (Integer.parseInt(Data.EQUIPMENT[i][0]) == Data.PC.getCode()) {
                eqs[i] = new PC(total++,
                                Data.EQUIPMENT[i][1],
                                Double.parseDouble(Data.EQUIPMENT[i][2]),
                                Status.FREE,
                                Data.EQUIPMENT[i][3]);
            }else if (Integer.parseInt(Data.EQUIPMENT[i][0]) == Data.NOTEBOOK.getCode()) {
                eqs[i] = new NoteBook(total++,
                                    Data.EQUIPMENT[i][1],
                                    Double.parseDouble(Data.EQUIPMENT[i][2]),
                                    Status.FREE,
                                    Data.EQUIPMENT[i][3]);
            }else {
                eqs[i] = new NotePad(total++,
                                    Data.EQUIPMENT[i][1],
                                    Double.parseDouble(Data.EQUIPMENT[i][2]),
                                    Status.FREE);
            }
        }
    }


    public Equipment[] getAllEquipments() {
        return Arrays.copyOf(eqs, eqs.length);
    }

    /**
     * 根据id返回指定设备
     * @param id 设备id
     * @return 返回id对应设备对象, 如果不存在抛出异常
     * @throws EMSException
     */
    public Equipment getEquipment(int id) throws EMSException {
        for (Equipment e : eqs) {
            if (e.getId() == id) {
                return e;
            }
        }

        throw new EMSException("没有找到指定id的设备");
    }
}
