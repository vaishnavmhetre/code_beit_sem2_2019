import Client.Client;
import Server.Server;


/**
 * The main class to start communication
 *
 * How to start -
 *
 * (Start Server before Client)
 *
 *      To start Server =>
 *          `java Worker server`
 *
 *      To start Client =>
 *          `java Worker client`
 *
 */

public class Worker {

    /**
     * Main function that JVM shall call to start execution
     *
     * @param args - Has command line arguments
     * @throws Exception - throws any delegated Exception from Server/Client
     */

    public static void main(String[] args) throws Exception {

        if (args[0].equals("server")) {

            //  Create a server instance and run it

            Server server = new Server(25000);
            server.run();

        } else if (args[0].equals("client")) {

            // Create a client instance and run it

            Client client = new Client("localhost", 25000);
            client.run();

        } else throw new Exception("Server or Client needs to be specified as \"server\" or \"client\" respectively as first argument to run");

    }
}
