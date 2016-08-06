package org.adrianwalker.lg4j;

import java.io.IOException;
import static org.adrianwalker.lg4j.RoapXmlResponse.RESPONSE_OK;
import org.adrianwalker.lg4j.discovery.Discovery;
import org.adrianwalker.lg4j.discovery.DiscoveryRequest;
import org.adrianwalker.lg4j.discovery.DiscoveryResponse;
import org.adrianwalker.lg4j.auth.Auth;
import org.adrianwalker.lg4j.auth.AuthRequest;
import static org.adrianwalker.lg4j.auth.AuthRequest.AUTH_KEY_REQ;
import static org.adrianwalker.lg4j.auth.AuthRequest.AUTH_REQ;
import org.adrianwalker.lg4j.auth.AuthResponse;
import org.adrianwalker.lg4j.command.Command;
import org.adrianwalker.lg4j.command.CommandRequest;
import static org.adrianwalker.lg4j.command.CommandRequest.HANDLE_KEY_INPUT;
import org.adrianwalker.lg4j.command.CommandResponse;
import org.adrianwalker.lg4j.exception.Lg4jException;

public final class Lg4j {

  public String discoverIpAddress() throws IOException {

    Discovery address = new Discovery();

    DiscoveryRequest addressRequest = new DiscoveryRequest();
    DiscoveryResponse addressResponse = address.execute(addressRequest);

    return addressResponse.getHostAddress();
  }

  public void displayAuthenticationKey(final String ip)
          throws Lg4jException, IOException {

    Auth auth = new Auth(ip);

    AuthRequest authKeyRequest = new AuthRequest();
    authKeyRequest.setType(AUTH_KEY_REQ);

    AuthResponse authKeyResponse = auth.execute(authKeyRequest);

    checkResponseCode(authKeyResponse);
  }

  public int authenticate(final String ip, final int authKey)
          throws Lg4jException, IOException {

    Auth auth = new Auth(ip);

    AuthRequest authRequest = new AuthRequest();
    authRequest.setType(AUTH_REQ);
    authRequest.setValue(authKey);

    AuthResponse authResponse = auth.execute(authRequest);

    checkResponseCode(authResponse);

    return authResponse.getSession();
  }

  public void sendKey(final String ip, final int key)
          throws Lg4jException, IOException {

    Command command = new Command(ip);

    CommandRequest commandRequest = new CommandRequest();
    commandRequest.setName(HANDLE_KEY_INPUT);
    commandRequest.setValue(key);

    CommandResponse commandResponse = command.execute(commandRequest);

    checkResponseCode(commandResponse);
  }

  private void checkResponseCode(final RoapXmlResponse response)
          throws Lg4jException {

    if (RESPONSE_OK != response.getRoapError()) {

      throw new Lg4jException(
              response.getRoapError(),
              response.getRoapErrorDetail());
    }
  }
}
