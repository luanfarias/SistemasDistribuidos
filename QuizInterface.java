import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuizInterface extends Remote {
	//metodos que serão implementados
	public void sorteiaDaQuestao() throws RemoteException;
	public String mostraPerguntaEscolhida() throws RemoteException;
	public String verificaResposta (int resposta) throws RemoteException;

}
