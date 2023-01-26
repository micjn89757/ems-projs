package com.djn.ems.service;


public enum Data {
    PC(11), NOTEBOOK(12), NOTEPAD(13);
    /**
     * 模拟数据
     * PC: 11, factory,price,display
     * NOTEBOOK: 12,factory,price,model
     * NOTEPAD: 13,factory,price
     */
    public static final String[][] EQUIPMENT = {
            {"12", "联想", "6000", "拯救者"},
            {"11", "宏基", "5000", "AT7-N52"},
            {"13", "小米", "2000"},
            {"11", "戴尔", "4000", "3800-R33"},
            {"12", "苹果", "12000", "MBP15"},
            {"11", "华硕", "8000", "K30BD-21寸"},
            {"11", "联想", "7000", "YOGA"},
            {"12", "惠普", "5800", "X500"},
            {"13", "苹果", "4500"},
            {"12", "惠普", "5800", "FZ5"}
    };
    private final int code;

    private Data(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Data{" +
                "code=" + code +
                "} " + super.toString();
    }
}
