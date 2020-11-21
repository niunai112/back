package com.heeexy.example.util.constants;

public enum DeleteStateEnum {
    NORMAL("1","正常"),
    DELETE("2","删除")
    ;

    private String deleteStateCode;
    private String deleteStateMsg;

    DeleteStateEnum(String deleteStateCode, String deleteStateMsg) {
        this.deleteStateCode = deleteStateCode;
        this.deleteStateMsg = deleteStateMsg;
    }

    public String getDeleteStateCode() {
        return deleteStateCode;
    }

    public String getDeleteStateMsg() {
        return deleteStateMsg;
    }
}
