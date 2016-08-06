package org.adrianwalker.lg4j.command;

import javax.xml.bind.annotation.XmlRootElement;
import org.adrianwalker.lg4j.RoapXmlResponse;

@XmlRootElement(name = "envelope")
public final class CommandResponse extends RoapXmlResponse<CommandResponse> {

}
