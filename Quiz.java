
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class Quiz extends UnicastRemoteObject implements QuizInterface{

	Questao[] arrayDePerguntas = new Questao[10]; //array de perguntas e respostas
	int numQuestao; //numero da questao escolhida
	int certo = 1; //opcao certa
	int errado = 0; //opcao errada

	//Construtor
	public Quiz() throws RemoteException{

		//Instancia todos os index do array
		for (int i = 0; i < 10; i++) {
			arrayDePerguntas[i] = new Questao();
		}

		//Perguntas e respostas
		arrayDePerguntas[0].pergunta = "O que � um Sistema Distribu�do?\n"
				+ "Um conjunto e computadores independentes que se apresenta a seus usu�rios como um sistema �nico e independente.";
		arrayDePerguntas[0].resposta = this.certo;

		arrayDePerguntas[1].pergunta = "O que seria um sistema de computa��o em cluster?";
		arrayDePerguntas[1].resposta = this.errado;

		arrayDePerguntas[2].pergunta = "Em rela��o as vantagens do uso de Threads em rela��o a Processos em sistemas distribu�dos. Essas afirma��es s�o verdadeiras?\n"
				+ "Compartilham mem�ria;\nS�o iniciadas de forma mais r�pida;\nPodem ser encerradas assim que tiverem conclu�do sua fun��o.";
		arrayDePerguntas[2].resposta = this.certo;

		arrayDePerguntas[3].pergunta = "No modelo cliente-servidor de computa��o distribu�da, os�\n"
				+ "Servidores requisitam servi�os dos clientes mediante uma interface do tipo HTTP";
		arrayDePerguntas[3].resposta = this.errado;

		arrayDePerguntas[4].pergunta = "Os tipos mais comuns de defeitos em sistemas distribu�dos provocados por falhas f�sicas de componentes ou interfer�ncia eletromagn�tica s�o:\n"
				+ "[0] Capturas de senhas , sobrecargas de servidores, mensagens duplicadas\n"
				+ "[1] Colapso de servidores, queda do enlace e perda de mensagens";
		arrayDePerguntas[4].resposta = this.certo;

		arrayDePerguntas[5].pergunta = "A defini��o de concorr�ncia na Computa��o Distribu�da �:\n"
				+ "A execu��o concorrente � uma caracter�stica intr�nseca de um sistema distribu�do, na qual os recursos disputam os processos.";
		arrayDePerguntas[5].resposta = this.errado;

		arrayDePerguntas[6].pergunta = "O objetivo de uma camada de Middleware em um sistema multicamadas �:\n"
				+ "Disponibilizar classes utilit�rias e servi�os independentes de plataformas que permitam a obten��o de computa��o distribu�da em ambientes heterog�neos.";
		arrayDePerguntas[6].resposta = this.certo;

		arrayDePerguntas[7].pergunta = "A comunica��o entre processos em um sistema distribu�do pode ser realizado por um mecanismo conhecido como RPC - Chamada de Procedimento Remoto. Sobre esse mecanismo qual � a op��o correta?\n"
				+ "[0] Os stubs cliente e servidor s�o respons�veis pela convers�o de formato dos par�metros de entrada e sa�da, caso haja necessidade\n"
				+ "[1] Processos comunicantes compartilham o mesmo espa�o de endere�amento";
		arrayDePerguntas[7].resposta = this.errado;

		arrayDePerguntas[8].pergunta = "Sistemas distribu�dos Pervasivos se caracterizam por...\n"
				+ "Equipamentos costumam ser caracterizados por seu pequeno tamanho, alimentado por bateria, mobilidade e conex�o sem fio.";
		arrayDePerguntas[8].resposta = this.certo;

		arrayDePerguntas[9].pergunta = "Em uma rede onde o cliente consome servi�os oferecido por um servidor, que fornece este servi�o simultaneamente a diversos usu�rios, estamos falando de:\n"
				+ "[0] Arquitetura ponto a ponto\n"
				+ "[1] Arquitetura Cliente/Servidor";
		arrayDePerguntas[9].resposta = this.certo;

	}


	//Sorteio da questao
	public void sorteiaDaQuestao() {
		Random random = new Random(); //gera numero randomico
		int questaoSorteada = random.nextInt(10); //numero randomico de 0 a 9
		this.numQuestao = questaoSorteada;
	}

	//Mostra a pergunta que foi sorteada para o usuario
	public String mostraPerguntaEscolhida() {
		String perguntaEscolhida = arrayDePerguntas[numQuestao].pergunta;
		return perguntaEscolhida;
	}


	//Recebe a resposta da pergunta e retorna se errou ou acertou
	public String verificaResposta (int resposta) {
		if (resposta == arrayDePerguntas[numQuestao].resposta) {
			return "Voce acertou!";
		} else return "Voce errou!";

	}


}
