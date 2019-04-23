package Communication;

import java.io.*;
import java.net.Socket;


/**
 * Base communication handler (DRY building)
 */

abstract public class Communication implements Communicable {

    /**
     * Attributes
     */

    protected int port; // Port we're communicating over
    protected Socket socket; // Socket to be used for communication

    /**
     * Communication Constructor
     *
     * @param port - Port we're communicating over
     */

    public Communication(int port) {
        this.port = port;

        /*
         * Note for block- "Socket close on exit"
         *
         * This block is for closing socket on program exit in case we don't close it explicitly in our code for communication.
         * This socket close block is just a backup and can be ignored as it is has been handled in communication code.
         */

        // START - Socket close on exit

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    if (!socketIsClosed())
                        closeSocket();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // END - Socket close on exit

    }


    /**
     * Close the socket connection
     *
     * @throws IOException - In case socket goes into trouble
     */

    public void closeSocket() throws IOException {
        this.socket.close();
    }


    /**
     * Check if socket is closed for any communication
     *
     * @return - Socket is closed or not
     */

    public boolean socketIsClosed() {
        return this.socket.isClosed();
    }


    /**
     * Get our message from cmdline and send it to other/receiver end of socket
     *
     * @param myName - Name to be shown as identifier before our message
     * @return - Message that we sent
     * @throws IOException - In case socket goes into trouble
     */

    public String sendMyMessage(String myName) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(myName + ": ");
        String message = reader.readLine();

        OutputStream os = this.socket.getOutputStream();        // Get stream of socket for writing message
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(message);  // Write the message i.e. send the message
        bw.flush();         // Flush the stream if any garbage settles

        this.closeSocket();

        return message;

    }


    /**
     * Get message received from other end of socket
     *
     * @param othersName - Name to be shown as identifier before other node's received message
     * @return - Message we that received
     * @throws IOException - In case socket goes into trouble
     */

    public String showOthersMessage(String othersName) throws IOException {

        InputStream is = this.socket.getInputStream();          // Get stream of socket for reading received message
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String message = br.readLine();                         // Read the message
        System.out.println(othersName + ": " + message);

        this.closeSocket();

        return message;

    }

}
