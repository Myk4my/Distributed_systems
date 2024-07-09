import java.rmi.registry.*;
import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements IIncrementa{
	final static String URL = "rmi://127.0.0.1/Incrementa";
	public int x;

	public Server() throws RemoteException{
        	x=0;
	}

	// Implementação do método que foi declarado na interface IIncrementa
	public void aumenta() throws RemoteException{
       		 x++;
		
	}
	public int retorna() throws RemoteException{
		return x;
	}

	public void msg(String msn) throws RemoteException{
		System.out.println("Mensagem do cliente = "+msn);
	}

	public static void main(String args[]){
		try {
			System.out.println("Iniciando o Servidor RMI");
			// acessa o serviço que irá executar em background para abrir a porta 1099		
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

			// Criando objeto local, nesta chamada é acessado o construtor da classe Incrementa
			Server obj = new Server();
			// Abaixo estamos publicando o objeto remoto
			Naming.rebind(URL,obj);
		} catch(Exception e) 	{
			System.out.println("Error no servidor"+e);
		}
	}
}
