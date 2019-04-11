package Client;

import Transform.Transformable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * Client in the communication
 */

public class Client {

    /**
     * Attributes
     */

    public String serverIP;

    /**
     * Client Constructor
     *
     * @param serverIP - Server IP we're sending request to
     */

    public Client(String serverIP) {
        this.serverIP = serverIP;
    }

    /**
     * Get URL of Server for Dummy.interfaces Implementation
     *
     * @param serverIP - Server IP we're sending request to
     * @return - URL of Server for Dummy.interfaces Implementation
     */

    private String getTransformServerURL(String serverIP) {
        return "rmi://" + serverIP + "/transform";
    }

    /**
     * Connect to server and get uppercase of given string
     *
     * @param data - String to be converted to Upper case
     * @throws RemoteException       - In case Remote Connection goes into trouble
     * @throws MalformedURLException - In case invalid URL is given
     * @throws NotBoundException     - In case RMI connection not established
     */

    public void toUpper(String data) throws RemoteException, MalformedURLException, NotBoundException {

        String transformUrl = getTransformServerURL(this.serverIP);

        Transformable transformable = (Transformable) Naming.lookup(transformUrl);

        System.out.println(String.format("Normal: %s", data));
        System.out.println(String.format("Uppercase: %s", transformable.toUpper(data)));

    }
}
