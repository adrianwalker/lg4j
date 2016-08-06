package org.adrianwalker.lg4j.discovery;

import org.adrianwalker.lg4j.Response;

public final class DiscoveryResponse implements Response {

  private String hostAddress;

  public String getHostAddress() {
    return hostAddress;
  }

  public void setHostAddress(final String hostAddress) {
    this.hostAddress = hostAddress;
  }
}
