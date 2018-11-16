package com.aitutech.lorenzo.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultApi<T> {

    private String msg;
    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResultApi() {

    }

    public ResultApi(ResultCode ResultCode) {
        this(ResultCode.getCode(), ResultCode.getMessage(), null);
    }

    public ResultApi(ResultCode ResultCode, T data) {
        this(ResultCode.getCode(), ResultCode.getMessage(), data);
    }

    public ResultApi(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static  ResultApi  success() {
        return new ResultApi(ResultCode.SUCCESS);
    }

    public static <T> ResultApi success(T data) {
        ResultApi result = ResultApi.success();
        result.setData(data);
        return result;
    }

    public static ResultApi fail() {
        return new ResultApi(ResultCode.FAIL);
    }

    public static ResultApi fail(String message) {
        ResultApi result = new ResultApi(ResultCode.FAIL);
        result.setMsg(message);
        return result;
    }

    public static ResultApi fail(ResultCode ResultCode) {
        return new ResultApi(ResultCode);
    }

    public static <T> ResultApi fail(ResultCode ResultCode, T data) {
        ResultApi result = ResultApi.fail(ResultCode);
        result.setData(data);
        return result;
    }

    public static <T> ResultApi success(ResultCode ResultCode, T data) {
        ResultApi result = ResultApi.success(ResultCode);
        result.setData(data);
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
