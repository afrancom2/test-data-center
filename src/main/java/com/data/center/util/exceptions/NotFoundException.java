package com.data.center.util.exceptions;

public class NotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE_GENERAL = "Not found for %s";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_GENERAL.concat(" with id %s");
    private static final String ERROR_MESSAGE_TWO_TABLES = "Not found for %s with sale id %s and operator id %s";

    public NotFoundException(String tableName, String id) {
        super(String.format(ERROR_MESSAGE, tableName, id));
    }

    public NotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE_GENERAL, tableName));
    }

    public NotFoundException(String tableName, String id1, String id2) {
        super(String.format(ERROR_MESSAGE_TWO_TABLES, tableName, id1, id2));
    }

}
