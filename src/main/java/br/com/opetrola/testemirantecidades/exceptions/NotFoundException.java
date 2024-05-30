package br.com.opetrola.testemirantecidades.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(Long id) {
        super(String.format("No records found for id: %d", id));
    }

}
