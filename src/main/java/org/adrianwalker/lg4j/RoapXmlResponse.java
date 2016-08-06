package org.adrianwalker.lg4j;

import javax.xml.bind.annotation.XmlElement;

public abstract class RoapXmlResponse<S> extends XmlResponse<S> {

  public static final int RESPONSE_OK = 200;

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
