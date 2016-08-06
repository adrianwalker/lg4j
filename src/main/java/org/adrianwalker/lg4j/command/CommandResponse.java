package org.adrianwalker.lg4j.command;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.XmlResponse;

@XmlRootElement(name = "envelope")
public final class CommandResponse extends XmlResponse<CommandResponse> {

  private int roapError;
  private String roapErrorDetail;

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
}
