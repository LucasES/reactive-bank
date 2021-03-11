package br.com.reactivebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 11/03/21
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperationTypeNotFoundError extends Exception {
    public OperationTypeNotFoundError(String message) {
        super(message);
    }
}
