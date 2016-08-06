package org.adrianwalker.lg4j.discovery;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.adrianwalker.lg4j.Message;

public final class Discovery
        implements Message<DiscoveryRequest, DiscoveryResponse> {

  private static final int RESPONSE_LENGTH = 1024;
  private static final int MILLISECONDS = 1000;

  @Override
  public DiscoveryResponse execute(final DiscoveryRequest request)
          throws IOException {

    byte[] buf = request.getBytes();

    InetAddress address = InetAddress.getByName(request.getHost());

    DatagramPacket requestPacket = new DatagramPacket(
            buf,
            buf.length, address,
            request.getPort());

    try (DatagramSocket socket = new DatagramSocket()) {

      socket.setSoTimeout(request.getMx() * MILLISECONDS);
      socket.send(requestPacket);

      DatagramPacket responsePacket
              = new DatagramPacket(new byte[RESPONSE_LENGTH], RESPONSE_LENGTH);

      socket.receive(responsePacket);

      DiscoveryResponse response = new DiscoveryResponse();
      response.setHostAddress(responsePacket.getAddress().getHostAddress());

      return response;
    }
  }
}
