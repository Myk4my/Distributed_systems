import java.rmi.*;
public interface IIncrementaLobeu extends Remote{
	public double soma(double x, double y) throws RemoteException;
	public double sub(double x, double y) throws RemoteException;
	public double div(double x, double y) throws RemoteException;
	public double mult(double x, double y) throws RemoteException;
	public void fim() throws RemoteException;
}
