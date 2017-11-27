import java.rmi.Naming;

public class QuizServidor {

	public static void main(String[] args) {
		try {
			Quiz jogo = new Quiz();

			String objname = "rmi://localhost:1099/jogo";
			System.out.println("Registrando o Jogo...");
			Naming.rebind(objname, jogo);
			System.out.println("Servidor no ar!");
		} catch (Exception e) {
			System.err.println("Houve algum erro!");
			e.printStackTrace();
			System.exit(2);
		}
		System.out.println("Aguardando inicializacao dos clientes...");
	}
}
