package br.com.gabrielrodrigues07.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
