public class Interlocutor {
    private String address;
    private int port;

    public Interlocutor(String address, int port) {
        this.address = address;
        this.port = port;
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
