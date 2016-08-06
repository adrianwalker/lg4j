package org.adrianwalker.lg4j.command;

import java.io.InputStream;
import java.io.OutputStream;
import org.adrianwalker.lg4j.XmlMessage;

public final class Command extends XmlMessage<CommandRequest, CommandResponse> {

  private static final String DEFAULT_FILE = "/roap/api/command";

  public Command(final String host, final int port, final String file) {

    super(host, port, file);
  }

  public Command(final String host) {

    super(host, DEFAULT_FILE);
  }

  @Override
  protected void marshalRequest(
          final CommandRequest request,
          final OutputStream os) {

    request.marshal(os);
  }

  @Override
  protected CommandResponse unmarshalResponse(final InputStream is) {

    return new CommandResponse().unmarshal(is);
  }
}
