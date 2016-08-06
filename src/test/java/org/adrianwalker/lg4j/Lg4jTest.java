package org.adrianwalker.lg4j;

import java.io.IOException;
import static org.adrianwalker.lg4j.KeyCodes.VOLUME_DOWN;
import static org.adrianwalker.lg4j.KeyCodes.VOLUME_UP;
import org.adrianwalker.lg4j.exception.Lg4jException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public final class Lg4jTest {

  private static final int AUTHENTICATION_KEY = 674689; // change this

  @Test
  public void testVolume() throws IOException, Lg4jException, InterruptedException {

    Lg4j lg4j = new Lg4j();
    String ip = lg4j.discoverIpAddress();
    assertTrue(ip.matches("^\\d{1,3}(\\.\\d{1,3}){3}$"));

    lg4j.displayAuthenticationKey(ip);

    int session = lg4j.authenticate(ip, AUTHENTICATION_KEY);
    assertTrue(session > 0);

    lg4j.sendKey(ip, VOLUME_DOWN);

    Thread.sleep(1000);

    lg4j.sendKey(ip, VOLUME_UP);

  }
}
