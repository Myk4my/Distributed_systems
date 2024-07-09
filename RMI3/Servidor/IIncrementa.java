import java.rmi.*;
public interface IIncrementa extends Remote{
	public void aumenta () throws RemoteException;
	public int retorna() throws RemoteException;
	public void msg(String msn) throws RemoteException;
}
