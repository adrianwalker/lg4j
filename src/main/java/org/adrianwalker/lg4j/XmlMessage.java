package org.adrianwalker.lg4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public abstract class XmlMessage<Q extends XmlRequest, S extends XmlResponse>
        implements Message<Q, S> {

  private static final String PROTOCOL = "http";
  private static final String CONTENT_TYPE_VALUE = "application/atom+xml";
  private static final String CONTENT_TYPE_KEY = "Content-Type";
  private static final int DEFAULT_PORT = 8080;

  private final String host;
  private final int port;
  private final String file;

  public XmlMessage(
          final String host,
          final int port,
          final String file) {

    this.host = host;
    this.port = port;
    this.file = file;
  }

  public XmlMessage(final String host, final String file) {

    this(host, DEFAULT_PORT, file);
  }

  @Override
  public final S execute(final Q request) throws IOException {

    URLConnection connection = openConnection(PROTOCOL, host, port, file);

    try (OutputStream os = connection.getOutputStream()) {

      marshalRequest(request, os);

      InputStream is = connection.getInputStream();

      S response = unmarshalResponse(is);

      return response;
    }
  }

  protected abstract void marshalRequest(Q request, OutputStream os);

  protected abstract S unmarshalResponse(InputStream is);

  private URLConnection openConnection(
          final String protocol,
          final String host,
          final int port,
          final String file) throws IOException {

    URL url = new URL(protocol, host, port, file);

    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);
    connection.setRequestProperty(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);

    return connection;
  }
}
