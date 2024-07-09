import java.rmi.*;

interface IClient extends Remote{
//Este método será acessado pelo servidor
	public void avisa(String msg) throws RemoteException;

}
