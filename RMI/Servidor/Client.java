import java.rmi.*;

public class Client{
	public static void main(String args[]){
		try {
			// Busca a referência do objeto remoto criado no servidor
			IIncrementa vary = (IIncrementa) Naming.lookup("rmi://127.0.0.1/Incrementa");
			// já podemos acessar o método remoto implementado no servidor.
		System.out.println("O valor de retorno é: "+vary.aumenta());
	
		}catch(Exception e) {
			System.out.print("Erro no cliente"+e);
		}
	}

}
