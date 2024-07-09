import java.rmi.*;
import java.util.Scanner;

public class ClientLobeu{
	public static void menu(){
		System.out.println("---------------------------");
		System.out.println("\nInforme a opção desejada");
		System.out.println("0. Fim (Fecha Servidor)");
		System.out.println("1. Somar");
		System.out.println("2. Multiplicar");
		System.out.println("3. Dividir");
		System.out.println("4. Subtrair");
		System.out.println("Opcao:");
		System.out.println("---------------------------");
	}
	public static void main(String args[]){
		int opcao;
		double x;
		double y;
		Scanner entrada = new Scanner(System.in);

		try {
			// Busca a referência do objeto remoto criado no servidor
			IIncrementaLobeu calc = (IIncrementaLobeu) Naming.lookup("rmi://"+args[0]+"/Incrementa");

			do{
			menu();
			opcao = entrada.nextInt();
			switch(opcao){
				case 0:
					try{
						 calc.fim();
					} catch (Exception e)	{	
						System.out.printf("Servidor Encerrado com sucesso.\n");
					}
					break;
				case 1:
					System.out.printf("Informe o valor para 'x'\n");
					x = entrada.nextDouble();
                                        System.out.printf("Informe o valor para 'y'\n");
                                        y = entrada.nextDouble();
					System.out.println("O valor da soma entre "+x+" e "+y+" é: "+calc.soma(x, y));
					break;
				case 2:
					System.out.printf("Informe o valor para 'x'\n");
					x = entrada.nextDouble();
                                        System.out.printf("Informe o valor para 'y'\n");
                                        y = entrada.nextDouble();
					System.out.println("O valor da multiplicação entre "+x+" e "+y+" é: "+calc.mult(x, y));
					break;
				case 3:
					System.out.printf("Informe o valor para 'x'\n");
					x = entrada.nextDouble();
                                        System.out.printf("Informe o valor para 'y'\n");
                                        y = entrada.nextDouble();
					System.out.println("O valor da razão entre "+x+" e "+y+" é: "+calc.div(x, y));
					break;
				case 4:
					System.out.printf("Informe o valor para 'x'\n");
					x = entrada.nextDouble();
                                        System.out.printf("Informe o valor para 'y'\n");
                                        y = entrada.nextDouble();
					System.out.println("O valor da subtração entre "+x+" e "+y+" é: "+calc.sub(x, y));
					break;
				default:
					System.out.println("Opção inválida.");
			}
		} while(opcao != 0);
	} catch(Exception e) {
               System.out.print("Erro no cliente"+e);
	}    
   }

}
