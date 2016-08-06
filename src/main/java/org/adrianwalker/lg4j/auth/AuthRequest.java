package org.adrianwalker.lg4j.auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.XmlRequest;

@XmlRootElement(name = "auth")
public final class AuthRequest extends XmlRequest<AuthRequest> {

  public static final String AUTH_KEY_REQ = "AuthKeyReq";
  public static final String AUTH_REQ = "AuthReq";

  private String type;
  private int value;

  @XmlElement(name = "type", required = true)
  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  @XmlElement(name = "value", required = false)
  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
