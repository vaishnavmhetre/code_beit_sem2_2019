import Client.Client;
import Server.Server;

/**
 * The main class to start communication
 *
 * How to start -
 *
 * Go to base of the project and run `rmiregistry`
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

            //  Create a server instance and expose Dummy.interfaces feature it

            Server server = new Server();
            server.startTransformFeature();

        } else if (args[0].equals("client")) {

            if (args[1].isEmpty())
                throw new Exception("Need some string to toUpper");

            // Create a client instance and uppercase the given string

            Client client = new Client("127.0.0.1");
            client.toUpper(args[1]);

        } else throw new Exception("Server or Client needs to be specified as \"server\" or \"client <any string>\" respectively as first argument to run");

    }
}
