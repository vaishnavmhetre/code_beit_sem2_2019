package Server;

import Communication.Communication;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Communication {

    /**
     * Attributes
     */

    ServerSocket serverSocket; // Server socket instance for communication server


    /**
     * Client Constructor
     *
     * @param port - Port we're communicating over
     */

    public Server(int port) throws IOException {
        super(port);
        this.createServerSocket();
    }


    /**
     * Create socket server for communication server
     *
     * @throws IOException - In case server socket goes into trouble
     */

    public void createServerSocket() throws IOException {
        this.serverSocket = new ServerSocket(this.port);
    }


    /**
     * Create socket for communication
     *
     * @return Self instance (method chaining)
     * @throws IOException - In case socket goes into trouble
     */

    public Server createSocket() throws IOException {
        this.socket = this.serverSocket.accept();
        return this;
    }


    /**
     * @inheritDoc
     */

    public void run() throws Exception {

        System.out.println("Server started and listening on the port " + this.port);

        while (true) {

            String message = this.createSocket().showOthersMessage( "Client");

            if (message.equals("O&O")) // I mean "Over And Out" :P
                break;

            message = this.createSocket().sendMyMessage("Me");

            if (message.equals("O&O")) // I mean "Over And Out" :P
                break;

        }

    }

}
