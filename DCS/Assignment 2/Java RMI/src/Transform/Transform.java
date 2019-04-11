package Transform;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Transforms the string into different cases
 */

public class Transform extends UnicastRemoteObject implements Transformable {


    /**
     * Dummy.interfaces constructor
     *
     * @throws RemoteException - In case remote connection goes into trouble
     */

    public Transform() throws RemoteException {
        super();
    }

    /**
     * @inheritDoc
     */

    public String toUpper(String data) {
        return data.toUpperCase();
    }

}
