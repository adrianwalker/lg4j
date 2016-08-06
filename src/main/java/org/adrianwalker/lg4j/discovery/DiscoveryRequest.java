package org.adrianwalker.lg4j.discovery;

import org.adrianwalker.lg4j.Request;
import static java.lang.String.format;

public final class DiscoveryRequest implements Request {

  private static final String REQUEST
          = "M-SEARCH * HTTP/1.1\r\n"
          + "HOST: %s:%s\r\n"
          + "MAN: %s\r\n"
          + "MX: %s\r\n"
          + "ST: %s\r\n"
          + "USER-AGENT: %s\r\n"
          + "\n";

  private static final String DEFAULT_HOST = "239.255.255.250";
  private static final int DEFAULT_PORT = 1900;
  private static final String DEFAULT_MAN = "\"ssdp:discover\"";
  private static final int DEFAULT_MX = 3;
  private static final String DEFAULT_ST = "udap:rootservice";
  private static final String DEFAULT_USER_AGENT = "lg4j";

  private String host;
  private int port;
  private String man;
  private int mx;
  private String st;
  private String userAgent;

  public DiscoveryRequest() {

    host = DEFAULT_HOST;
    port = DEFAULT_PORT;
    man = DEFAULT_MAN;
    mx = DEFAULT_MX;
    st = DEFAULT_ST;
    userAgent = DEFAULT_USER_AGENT;
  }

  public String getHost() {
    return host;
  }

  public void setHost(final String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(final int port) {
    this.port = port;
  }

  public String getMan() {
    return man;
  }

  public void setMan(final String man) {
    this.man = man;
  }

  public int getMx() {
    return mx;
  }

  public void setMx(final int mx) {
    this.mx = mx;
  }

  public String getSt() {
    return st;
  }

  public void setSt(final String st) {
    this.st = st;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(final String userAgent) {
    this.userAgent = userAgent;
  }

  public byte[] getBytes() {
    return format(REQUEST, host, port, man, mx, st, userAgent).getBytes();
  }
}
