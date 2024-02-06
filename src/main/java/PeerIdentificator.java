public class PeerIdentificator {
    private String hostname, address;
    private int port;

    public PeerIdentificator(String hostname, String address, int port) {
        this.hostname = hostname;
        this.address = address;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
