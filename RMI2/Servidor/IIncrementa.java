import java.rmi.*;
public interface IIncrementa extends Remote{
	public int aumenta () throws RemoteException;
}
