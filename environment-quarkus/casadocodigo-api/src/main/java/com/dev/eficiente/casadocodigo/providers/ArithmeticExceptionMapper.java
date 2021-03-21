/**
 * 
 */
package com.dev.eficiente.casadocodigo.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.dev.eficiente.casadocodigo.handlers.ErrorResponse;

/**
 * @author Valdir Junior
 *
 */
@Provider
public class ArithmeticExceptionMapper implements ExceptionMapper<ArithmeticException> {

  @Override
  public Response toResponse(ArithmeticException ex) {
    ErrorResponse response = new ErrorResponse(ex.getMessage(), "400", null);
    return Response.status(Status.BAD_REQUEST).entity(response).build();

  }

}
