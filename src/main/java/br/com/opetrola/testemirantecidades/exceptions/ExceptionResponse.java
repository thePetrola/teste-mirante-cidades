package br.com.opetrola.testemirantecidades.exceptions;

import java.io.Serial;
import java.io.Serializable;

public record ExceptionResponse(long timestamp, int error, String message, String path) implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

}
