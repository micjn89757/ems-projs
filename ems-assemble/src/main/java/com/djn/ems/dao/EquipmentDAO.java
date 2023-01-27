package com.djn.ems.dao;

import com.djn.ems.domain.Equipment;
import com.djn.ems.domain.NoteBook;
import com.djn.ems.domain.NotePad;
import com.djn.ems.domain.PC;
import com.djn.ems.service.Data;
import com.djn.ems.service.EMSException;
import com.djn.ems.service.Status;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 处理设备数据的对象
 */
public class EquipmentDAO {
    /**
     * 为设备生成的唯一id
     */
    private static int total = 1;

    /**
     * 保存设备数据的二进制文件名
     */
    private final String filename = "equipments.dat";

    public EquipmentDAO() {}

    /**
     * 从文件中获取所有数据
     * @return 数据列表
     */
    public List<Equipment> getList() {
        String url = Objects.requireNonNull(Objects.requireNonNull(EquipmentDAO.class.getClassLoader().getResource("static/" + filename)).getFile());
        Path path = Paths.get(url.substring(1));
        List<Equipment> eqs = new ArrayList<>(Data.EQUIPMENT.length);

        try(FileInputStream fos = new FileInputStream(path.toFile());
            ObjectInputStream oos = new ObjectInputStream(fos);) {
            Object object = oos.readObject();
            if (object instanceof List<?>) {
                for (Object o : (List<?>)object) {
                    eqs.add((Equipment) o);
                }
            }

            if(eqs.size() > 0) {
                return eqs;
            }

            return initList();
        }catch (Exception e) {
            return initList();
        }
    }

    /**
     * 没有序列化的时候，将读取Data里的数据
     */
    private List<Equipment> initList() {
        List<Equipment> eqs = new ArrayList<>(Data.EQUIPMENT.length);

        for (int i = 0; i < Data.EQUIPMENT.length; i++) {
            // 根据id创建不同的设备对象并添加进eqs
            if (Integer.parseInt(Data.EQUIPMENT[i][0]) == Data.PC.getCode()) {
                eqs.add(new PC(total++,
                        Data.EQUIPMENT[i][1],
                        Double.parseDouble(Data.EQUIPMENT[i][2]),
                        Status.FREE,
                        Data.EQUIPMENT[i][3]));
            }else if (Integer.parseInt(Data.EQUIPMENT[i][0]) == Data.NOTEBOOK.getCode()) {
                eqs.add(new NoteBook(total++,
                        Data.EQUIPMENT[i][1],
                        Double.parseDouble(Data.EQUIPMENT[i][2]),
                        Status.FREE,
                        Data.EQUIPMENT[i][3]));
            }else {
                eqs.add(new NotePad(total++,
                        Data.EQUIPMENT[i][1],
                        Double.parseDouble(Data.EQUIPMENT[i][2]),
                        Status.FREE));
            }
        }

        return eqs;
    }

    /**
     * 将设备数据对象列表序列化
     */
    public void save(List<Equipment> list) throws EMSException {
        String url = Objects.requireNonNull(Objects.requireNonNull(EquipmentDAO.class.getClassLoader().getResource("static/" + filename)).getFile());
        Path path = Paths.get(url.substring(1));

        try(FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(list);
        }catch (IOException e) {
            throw new EMSException("数据文件不存在或无法访问");
        }

    }
}
