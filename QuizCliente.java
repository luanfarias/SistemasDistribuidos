import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class QuizCliente {
	public static void main(String[] args) {
		QuizInterface cliente = null;

		if (args.length != 2) {
			System.err.println("Use o comando: java QuizCliente 'ip'  Quiz");
			System.exit(1);
		}
		try {
			String objname = "rmi://"+args[0]+"/"+args[1];
			System.out.println("Aguardando o objeto:  " + objname);
        		cliente = (QuizInterface) Naming.lookup(objname);// Rmiregistry
		} catch (Exception e) {
			System.err.println("Problemas de localizacao! " + e);
			e.printStackTrace();
			System.exit(2);
		}
		try {
			cliente.sorteiaDaQuestao();
			System.out.println(cliente.mostraPerguntaEscolhida());
			Scanner ler = new Scanner(System.in);
			int resposta = ler.nextInt();
			System.out.println(cliente.verificaResposta(resposta));
		} catch (RemoteException re) {
			System.err.println("Problemas com a chamada remota! " + re);
			re.printStackTrace();
			System.exit(3);
		}
	}
}
