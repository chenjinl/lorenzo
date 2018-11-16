package com.aitutech.lorenzo.common.utils;

public enum ResultCode {

    /**
     * 系统级别错误
     */
    SYSTEM_ERROR(500, "系统错误"),

    METHODE_NOT_SUPPORTED(405, "请求方法类型不正确"),

    UNAUTHORIZED(403, "无访问/操作权限"),
    //
    /**
     * 服务级别错误 - 参数错误
     */
    PARAMETER_ERROR(20001, "参数错误"),

    LOGIN_INCORRECT(20002, "用户认证失败"),

    NO_TOKEN(20003, "缺少请求头参数"),

    TOKEN_INVALID(20004, "Token无效"),

    /**
     * 服务级别错误 - 系统服务
      */
    USER_NOT_LOGIN(20101, "用户未登录"),

    LOGIN_FAILURE(400, "登录失败"),
    LOGIN_SUCCESS(200, "登陆成功"),

    SUCCESS(200, "操作成功"),
    FAIL(500,"操作失败");

    private final int code;
    private final String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
