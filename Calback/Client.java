import java.rmi.*;
import java.rmi.server.*;

public class Client extends UnicastRemoteObject implements IClient {

	public Client() throws RemoteException{

	}

	//implementando o método declarado na interface do cliente
	//este método será invocado pelo servidor
    	public void avisa(String msg) throws RemoteException{
		System.out.println(msg);
	}

	public static void main (String args[]){
	try{
		IIncrementa obj = (IIncrementa) Naming.lookup("rmi://127.0.0.1/inc");
		Client obj_client = new Client(); // Cria um objeto remoto
		obj.refclient(obj_client); // Envia ao servidor a sua referência
		System.out.println("Valor incrementado "+obj.inc());
	}catch(Exception e){
		System.out.println("client's error "+e);
		}
	}

}


