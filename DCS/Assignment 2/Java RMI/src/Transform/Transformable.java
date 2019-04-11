package Transform;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Declares features to be given for string transformation
 */

public interface Transformable extends Remote {


    /**
     * Converts given string into uppercase
     *
     * @param data - String to be converted to uppercase
     * @return - String converted into uppercase
     */

    String toUpper(String data) throws RemoteException;

}
