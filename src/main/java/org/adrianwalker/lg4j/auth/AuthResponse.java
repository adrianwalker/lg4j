package org.adrianwalker.lg4j.auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.XmlResponse;

@XmlRootElement(name = "envelope")
public final class AuthResponse extends XmlResponse<AuthResponse> {

  private int roapError;
  private String roapErrorDetail;
  private int session;

  @XmlElement(name = "ROAPError", required = true)
  public int getRoapError() {
    return roapError;
  }

  public void setRoapError(final int roapError) {
    this.roapError = roapError;
  }

  @XmlElement(name = "ROAPErrorDetail", required = true)
  public String getRoapErrorDetail() {
    return roapErrorDetail;
  }

  public void setRoapErrorDetail(final String roapErrorDetail) {
    this.roapErrorDetail = roapErrorDetail;
  }

  @XmlElement(name = "session", required = false)
  public int getSession() {
    return session;
  }

  public void setSession(final int session) {
    this.session = session;
  }
}
