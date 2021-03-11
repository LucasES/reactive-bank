package br.com.reactivebank.handler;

import br.com.reactivebank.exception.ApiError;
import br.com.reactivebank.exception.OperationTypeNotFoundError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Exception handler
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 10/03/21
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ApiError> serverExceptionHandler(Exception ex) {
        String error = "Error!";
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);

        return Mono.just(apiError);
    }

}
