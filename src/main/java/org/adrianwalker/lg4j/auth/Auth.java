package org.adrianwalker.lg4j.auth;

import java.io.InputStream;
import java.io.OutputStream;
import org.adrianwalker.lg4j.XmlMessage;

public final class Auth extends XmlMessage<AuthRequest, AuthResponse> {

  private static final String DEFAULT_FILE = "/roap/api/auth";

  public Auth(final String host, final int port, final String file) {

    super(host, port, file);
  }

  public Auth(final String host) {

    super(host, DEFAULT_FILE);
  }

  @Override
  protected void marshalRequest(
          final AuthRequest request,
          final OutputStream os) {

    request.marshal(os);
  }

  @Override
  protected AuthResponse unmarshalResponse(final InputStream is) {

    return new AuthResponse().unmarshal(is);
  }
}
