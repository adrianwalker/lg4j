package org.adrianwalker.lg4j.auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.RoapXmlResponse;

@XmlRootElement(name = "envelope")
public final class AuthResponse extends RoapXmlResponse<AuthResponse> {

  private int session;

  @XmlElement(name = "session", required = false)
  public int getSession() {
    return session;
  }

  public void setSession(final int session) {
    this.session = session;
  }
}
