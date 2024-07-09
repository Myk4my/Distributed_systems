// Esta classe irá implementar o objeto remoto e todos os metodos que foram declarados na interface, que neste exemplo possui o nome de IIcrementa

import java.rmi.server.*;
import java.rmi.*;

public class Incrementa extends UnicastRemoteObject implements IIncrementa{
	int x;

	// Abaixo temos o construtor que possibilita que esta classe seja acessada por outra classe que cria um objeto para ela
	
	public Incrementa() throws RemoteException{
		x=0;
	}

	// Implementação do método que foi declarado na interface IIncrementa
	public int aumenta() throws RemoteException{
		x++;
		return x;
	}
}
