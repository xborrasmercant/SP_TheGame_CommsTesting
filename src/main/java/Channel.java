import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Channel implements Runnable{
    private CommsController commsController;
    private Interlocutor interlocutor;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;


    public Channel(CommsController commsController, Interlocutor interlocutor) {
        this.commsController = commsController;
        this.interlocutor = interlocutor;

    }

    @Override
    public void run() {

    }



    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;

        try{
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("[EXCEPTION]: Cannot set SOCKET because it's null");
        }
    }
    public void killSocket() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("[EXCEPTION]: Cannot delete SOCKET because it's null");
        }
    }
    public BufferedReader getIn() {
        return in;
    }
    public void setIn(BufferedReader in) {
        this.in = in;
    }
    public PrintWriter getOut() {
        return out;
    }
    public void setOut(PrintWriter out) {
        this.out = out;
    }
    public Interlocutor getInterlocutor() {
        return interlocutor;
    }
    public void setInterlocutor(Interlocutor interlocutor) {
        this.interlocutor = interlocutor;
    }
}
