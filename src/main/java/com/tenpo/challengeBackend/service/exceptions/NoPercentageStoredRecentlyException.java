package com.tenpo.challengeBackend.service.exceptions;

public class NoPercentageStoredRecentlyException extends RuntimeException {

    public NoPercentageStoredRecentlyException() {
        super();
    }

    public NoPercentageStoredRecentlyException(String message) {
        super(message);
    }

    public NoPercentageStoredRecentlyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPercentageStoredRecentlyException(Throwable cause) {
        super(cause);
    }
}
