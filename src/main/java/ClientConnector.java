import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnector implements Runnable{
    private CommsController commsController;
    private String peerAddress;
    private int peerPort;

    public ClientConnector (CommsController commsController, String peerAddress, int peerPort) {
        this.commsController = commsController;
        this.peerAddress = peerAddress;
        this.peerPort = peerPort;

    }

    @java.lang.Override
    public void run() {
        connectToPeer(peerAddress, peerPort);
    }

    public void connectToPeer(String peerAddress, int peerPort) {
        try {
            Socket socket = new Socket(peerAddress, peerPort);

            for (Channel chn : commsController.getChannels()) { // Find channel of peer you want to connect and start it
                if (chn.getInterlocutor().getAddress().equals(peerAddress) || chn.getInterlocutor().getPort() == peerPort) {
                    new Thread(chn).start();
                }
            }

        } catch (Exception e) {
            System.out.println("[EXCEPTION]: Error connecting to peer.");
        }
    }
}
