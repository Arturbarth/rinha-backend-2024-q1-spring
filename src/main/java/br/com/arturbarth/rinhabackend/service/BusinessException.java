package br.com.arturbarth.rinhabackend.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serial;


public class BusinessException extends ResponseStatusException {

    @Serial
    private static final long serialVersionUID = 554890452813834003L;
    private final transient Object[] args;


    public BusinessException(HttpStatus status, Object... args) {
        super(status);
        this.args = args != null && args.length > 0 ? args : new String[] {""};
    }


    public BusinessException(HttpStatus status, String[] args) {
        super(status);
        this.args = args != null && args.length > 0 ? args : new String[] {""};
    }


    public BusinessException(HttpStatus status, String reason, Object... args) {
        super(status, reason);
        this.args = args;
    }

    public BusinessException(HttpStatus status, String reason, Throwable cause, Object... args) {
        super(status, reason, cause);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
