package com.chenshinan.transaction.infra.exception;

/**
 * 自定义异常
 *
 * @author shinan.chen
 * @date 2018/10/8
 */
public class CsnException extends RuntimeException {
    private transient Object[] parameters;
    private String code;
    private String message;

    public CsnException(String code, Object... parameters) {
        super(code);
        this.parameters = parameters;
        this.code = code;
    }

    public CsnException(String code, Throwable cause, Object... parameters) {
        super(code, cause);
        this.parameters = parameters;
        this.code = code;
    }

    public CsnException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.parameters = new Object[0];
    }

    public CsnException(Throwable cause, Object... parameters) {
        super(cause);
        this.parameters = parameters;
    }
}
