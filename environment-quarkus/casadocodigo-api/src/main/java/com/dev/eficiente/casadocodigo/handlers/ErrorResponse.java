package com.dev.eficiente.casadocodigo.handlers;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ErrorResponse {

  private String errorMessage;
  private String errorCode;
  private String documetationLink;

  @JsonCreator
  public ErrorResponse(String errorMessage, String errorCode, String documetationLink) {
    super();
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.documetationLink = documetationLink;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getDocumetationLink() {
    return documetationLink;
  }

}
