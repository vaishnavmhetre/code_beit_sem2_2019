package Server;


import Transform.Transform;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * Server in the communication
 */

public class Server {

    /**
     * Start new Dummy.interfaces Feature for clients
     *
     * @throws RemoteException       - In case Remote Connection goes into trouble
     * @throws MalformedURLException - In case invalid URL is given
     */

    public void startTransformFeature() throws MalformedURLException, RemoteException {

        Transform transform = new Transform();
        Naming.rebind("transform", transform);

    }
}
