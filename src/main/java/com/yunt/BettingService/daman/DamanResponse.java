package com.yunt.BettingService.daman;

public class DamanResponse {
    private int code;
    private boolean success;
    private String msg;
    private DamanData data;

    public DamanResponse() {
    }

    public DamanResponse(int code, boolean success, String msg, DamanData data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DamanData getData() {
        return data;
    }

    public void setData(DamanData data) {
        this.data = data;
    }
}
