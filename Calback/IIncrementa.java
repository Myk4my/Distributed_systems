import java.rmi.*;

public interface IIncrementa extends Remote{

	public int inc () throws RemoteException; //método que será acessado pelo cliente, somente declaração!	
	public void refclient (IClient IClient) throws RemoteException;//este método recebe o endereço do cliente (BINA)
}
