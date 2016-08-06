package org.adrianwalker.lg4j;

import java.io.IOException;
import org.adrianwalker.lg4j.discovery.Discovery;
import org.adrianwalker.lg4j.discovery.DiscoveryRequest;
import org.adrianwalker.lg4j.discovery.DiscoveryResponse;
import org.adrianwalker.lg4j.auth.Auth;
import org.adrianwalker.lg4j.auth.AuthRequest;
import org.adrianwalker.lg4j.auth.AuthResponse;
import org.adrianwalker.lg4j.command.Command;
import org.adrianwalker.lg4j.command.CommandRequest;
import org.adrianwalker.lg4j.command.CommandResponse;
import org.adrianwalker.lg4j.exception.Lg4jException;

public final class Lg4j {

  public static final int RESPONSE_OK = 200;

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
    authKeyRequest.setType(AuthRequest.AUTH_KEY_REQ);

    AuthResponse authKeyResponse = auth.execute(authKeyRequest);

    if (RESPONSE_OK != authKeyResponse.getRoapError()) {

      throw new Lg4jException(
              authKeyResponse.getRoapError(),
              authKeyResponse.getRoapErrorDetail());
    }
  }

  public int authenticate(final String ip, final int authKey)
          throws Lg4jException, IOException {

    Auth auth = new Auth(ip);

    AuthRequest authRequest = new AuthRequest();
    authRequest.setType(AuthRequest.AUTH_REQ);
    authRequest.setValue(authKey);

    AuthResponse authResponse = auth.execute(authRequest);

    if (RESPONSE_OK != authResponse.getRoapError()) {

      throw new Lg4jException(
              authResponse.getRoapError(),
              authResponse.getRoapErrorDetail());
    }

    return authResponse.getSession();
  }

  public void sendKey(final String ip, final int key)
          throws Lg4jException, IOException {

    Command command = new Command(ip);

    CommandRequest commandRequest = new CommandRequest();
    commandRequest.setName(CommandRequest.HANDLE_KEY_INPUT);
    commandRequest.setValue(key);

    CommandResponse commandResponse = command.execute(commandRequest);

    if (RESPONSE_OK != commandResponse.getRoapError()) {

      throw new Lg4jException(
              commandResponse.getRoapError(),
              commandResponse.getRoapErrorDetail());
    }
  }
}
