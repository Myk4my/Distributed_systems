import java.rmi.registry.*;
import java.rmi.*;
import java.rmi.server.*;

public class ServerLobeu extends UnicastRemoteObject implements IIncrementaLobeu{
	public ServerLobeu() throws RemoteException{

	}
	final static String URL = "rmi://127.0.0.1/Incrementa";

	// Implementação do método que foi declarado na interface IIncrementa
	public double soma(double x, double y) throws RemoteException{
		return x+y;
	}
	public double mult(double x, double y) throws RemoteException{
                return x*y;
        }
	public double div(double x, double y) throws RemoteException{
                return x/y;
        }
	public double sub(double x, double y) throws RemoteException{
                return x-y;
        }

	public void fim() throws RemoteException{
		System.exit(0);
	}

	public static void main(String args[]){
		try {
			System.out.println("Iniciando o Servidor RMI");
			// acessa o serviço que irá executar em background para abrir a porta 1099
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

			// Criando objeto local, nesta chamada é acessado o construtor da classe Incrementa
			ServerLobeu obj = new ServerLobeu();
			// Abaixo estamos publicando o objeto remoto
			Naming.rebind(URL,obj);
		} catch(Exception e) 	{
			System.out.println("Error no servidor"+e);
		}
	}
}
