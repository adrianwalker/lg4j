package org.adrianwalker.lg4j.command;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.XmlRequest;

@XmlRootElement(name = "command")
public final class CommandRequest extends XmlRequest<CommandRequest> {

  public static final String HANDLE_KEY_INPUT = "HandleKeyInput";

  private String name;
  private int value;

  @XmlElement(name = "name", required = true)
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @XmlElement(name = "value", required = true)
  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
