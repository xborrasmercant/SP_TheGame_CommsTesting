import java.util.ArrayList;

public class CommsController {
    private ServerConnector serverConnector;
    private ClientConnector clientConnector;
    private ArrayList<PeerIdentificator> connectedPeers;
    private ArrayList<Channel> channels;

    public CommsController() {
        this.serverConnector = new ServerConnector(this);
        this.channels = new ArrayList<>();
        this.connectedPeers = new ArrayList<>();

    }

    public void addChannel(Interlocutor interlocutor) { // Create new channel for one peer (interlocutor)
        Channel chn = new Channel(this, interlocutor);
        channels.add(chn);
    }

    public ServerConnector getServerConnector() {
        return serverConnector;
    }
    public void setServerConnector(ServerConnector serverConnector) {
        this.serverConnector = serverConnector;
    }
    public ClientConnector getClientConnector() {
        return clientConnector;
    }
    public void setClientConnector(ClientConnector clientConnector) {
        this.clientConnector = clientConnector;
    }
    public Channel getChannel(int index) {
        if (channels.get(index) != null) {
            return channels.get(index);
        }

        System.out.println("[ERROR]: Channel with index (" + index + ") does not exists");
        return null;
    }
    public ArrayList<Channel> getChannels() {
        return channels;
    }
    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }
    public ArrayList<PeerIdentificator> getConnectedPeers() {
        return connectedPeers;
    }
    public void setConnectedPeers(ArrayList<PeerIdentificator> connectedPeers) {
        this.connectedPeers = connectedPeers;
    }
}
