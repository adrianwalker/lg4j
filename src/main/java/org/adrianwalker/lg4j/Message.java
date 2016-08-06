package org.adrianwalker.lg4j;

import java.io.IOException;

public interface Message<Q extends Request, S extends Response> {

  S execute(Q request) throws IOException;

}
