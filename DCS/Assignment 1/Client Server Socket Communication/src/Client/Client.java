package Client;

import Communication.Communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Client in the communication
 */

public class Client extends Communication {

    /**
     * Attributes
     */

    String host; // Host we're communicating over


    /**
     * Client Constructor
     *
     * @param host - Host we're communicating over
     * @param port - Port we're communicating over
     */

    public Client(String host, int port) {
        super(port);
        this.host = host;
    }


    /**
     * Get Address from host
     *
     * @param host - Host we're communicating over
     * @return - Return address of host
     * @throws UnknownHostException - In case any unknown host is encountered
     */

    public InetAddress getAddress(String host) throws UnknownHostException {
        return InetAddress.getByName(host);
    }


    /**
     * Create socket for communication from host and port
     *
     * @return - Self instance (method chaining)
     * @throws IOException - In case socket goes into trouble
     */

    public Client createSocket() throws IOException {
        this.socket = new Socket(this.getAddress(host), port);
        return this;
    }


    /**
     * @inheritDoc
     */

    public void run() throws Exception {

        System.out.println("Connected to Server on host " + this.host + " and port " + this.port);

        while (true) {

            String message = this.createSocket().sendMyMessage("Me");

            if (message.equals("O&O")) // I mean "Over And Out" :P
                break;

            message = this.createSocket().showOthersMessage("Server");

            if (message.equals("O&O")) // I mean "Over And Out" :P
                break;

        }

    }

}
