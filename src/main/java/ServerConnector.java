import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnector implements Runnable{
    private CommsController commsController;
    private ServerSocket serverSocket;
    private int PORT = 10000;

    public ServerConnector (CommsController commsController) {
        this.commsController = commsController;

    }

    @java.lang.Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept(); // Wait for connection
                setSocketToChannel(socket); // New channel socket it's set and peer id is stored
            }

        } catch (IOException e) {
            // TODO: Handle
        }

    }

    public void setSocketToChannel(Socket socket) {
        PeerIdentificator pid = new PeerIdentificator(socket.getInetAddress().getHostName(), socket.getInetAddress().getHostAddress(), socket.getPort());

        for (Channel chn : commsController.getChannels()) {
            if (chn.getInterlocutor().getAddress().equals(pid.getAddress()) || chn.getInterlocutor().getPort() == pid.getPort()) {
                chn.setSocket(socket);
                commsController.getConnectedPeers().add(pid);

                new Thread(chn).start();
            }
        }
    }


}
