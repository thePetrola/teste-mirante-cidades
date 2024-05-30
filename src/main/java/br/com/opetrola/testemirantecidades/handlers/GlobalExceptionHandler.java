package br.com.opetrola.testemirantecidades.handlers;

import br.com.opetrola.testemirantecidades.exceptions.BadRequestException;
import br.com.opetrola.testemirantecidades.exceptions.ExceptionResponse;
import br.com.opetrola.testemirantecidades.exceptions.InternalServerErrorException;
import br.com.opetrola.testemirantecidades.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class, BadRequestException.class, InternalServerErrorException.class})
    public final ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof NotFoundException unfe) {
            return handleUserNotFoundException(unfe, headers, request);
        } else if (ex instanceof BadRequestException cnae) {
            return handleBadRequestException(cnae, headers, HttpStatus.BAD_REQUEST, request);
        } else {
            return handleExceptionInternal(ex, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    protected ResponseEntity<ExceptionResponse> handleUserNotFoundException(NotFoundException ex, HttpHeaders headers, WebRequest request) {
        return handleExceptionInternal(ex,
                new ExceptionResponse(System.currentTimeMillis(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage(),
                        request.getDescription(false)),
                headers,
                HttpStatus.NOT_FOUND,
                request);
    }

    protected ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex,
                new ExceptionResponse(System.currentTimeMillis(),
                        status.value(),
                        ex.getMessage(),
                        request.getDescription(false)),
                headers,
                status,
                request);
    }

    protected ResponseEntity<ExceptionResponse> handleExceptionInternal(Exception ex, ExceptionResponse body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
