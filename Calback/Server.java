import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements IIncrementa{
	final static String ENDERECO = "rmi://127.0.0.1/inc";
	
	int i;
	IClient IntClient;
	//criando o método construtor para ser instanciado na classe Server
	public Server () throws RemoteException{
		i = 0;		
	}

	// recebe a referência do Cliente
	public void refclient (IClient IClient) throws RemoteException{
		IntClient = IClient;

	}

	//método acessado pelo cliente
	public int inc () throws RemoteException{
		i++; //incrementa i a cada acesso do cliente
		if (i>3)
			IntClient.avisa("Seu saldo aumentou!");
		return i;
	}
	
	public static void main (String args[]){
	try{
		//a linha abaixo chama o registry para abrir a porta 1099
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Server obj_remoto = new Server();//instancia o objeto local para a classe Incrementa
		Naming.rebind(ENDERECO, obj_remoto);//publica o objeto remoto
	
	}catch(Exception e){
		System.out.println("server's error "+e);
		}
	}

}
