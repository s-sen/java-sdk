package dev.openfeature.javasdk.exceptions;

import dev.openfeature.javasdk.ErrorCode;
import lombok.Getter;
import lombok.experimental.StandardException;

@StandardException
public class ParseError extends OpenFeatureError {
    private static final long serialVersionUID = 1L;

    @Getter private final ErrorCode errorCode = ErrorCode.PARSE_ERROR;

}
