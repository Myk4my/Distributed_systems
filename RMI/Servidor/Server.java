import java.rmi.registry.*;
import java.rmi.*;

public class Server{
	final static String URL = "rmi://127.0.0.1/Incrementa";
	public static void main(String args[]){
		try {
			
			System.out.println("Iniciando o Servidor RMI");
			// acessa o serviço que irá executar em background para abrir a porta 1099		
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

			// Criando objeto local, nesta chamada é acessado o construtor da classe Incrementa
			Incrementa obj = new Incrementa();
			// Abaixo estamos publicando o objeto remoto
			Naming.rebind(URL,obj);
		} catch(Exception e) 	{
			System.out.println("Error no servidor"+e);
		}	
	}
}
