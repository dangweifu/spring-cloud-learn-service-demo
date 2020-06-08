package org.wiulus.spring.cloud.commons.tools.exception;


import org.wiulus.spring.cloud.commons.tools.utils.MessageUtils;

/**
 * @author : WiuLuS
 * @version : v1.0 06.08.2020
 * @discription :
 * @date : 2020-06-08 15:59:56
 * @email : m13886933623@163.com
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public CustomException(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public CustomException(int code, String... params) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public CustomException(int code, Throwable e) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public CustomException(int code, Throwable e, String... params) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public CustomException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
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

}
