package org.adrianwalker.lg4j.exception;

public final class Lg4jException extends Exception {

  private final int errorCode;

  public Lg4jException(final int errorCode, final String message) {

    super(message);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }
}
