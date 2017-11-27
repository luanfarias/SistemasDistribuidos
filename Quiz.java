
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class Quiz extends UnicastRemoteObject implements QuizInterface{

	Questao[] arrayDePerguntas = new Questao[10]; //array de perguntas e respostas
	int numQuestao; //numero da questao escolhida
	int certo = 1; //opcao certa
	int errado = 0; //opcao errado
	int respDoCliente;

	//Questao escolhida e resposta do cliente A
	int questaoclienteA;
	int respClienteA;
	boolean clienteA = false;

	//Questao escolhida e resposta do cliente B
	int questaoclienteB;
	int respClienteB;
	boolean clienteB = false;

	//Construtor
	public Quiz() throws RemoteException{

		//Instancia todos os index do array
		for (int i = 0; i < 10; i++) {
			arrayDePerguntas[i] = new Questao();
		}

		System.out.println("O Quiz está sendo carregado. Aguarde alguns instantes...\n\n");

		//Perguntas e respostas
		arrayDePerguntas[0].pergunta = "\n*********************\n"
				+"O Sistema Distribuído é um conjunto e computadores independentes que se apresenta a seus usuários como um sistema único e independente?\n"
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[0].resposta = this.certo;

		arrayDePerguntas[1].pergunta = "\n*********************\n"
				+ "O sistema de computação em cluster é uma coleção de computadores interconectados que trabalham em conjunto como se fossem um único recurso computacional?\n"
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[1].resposta = this.certo;

		arrayDePerguntas[2].pergunta = "\n*********************\n"
				+ "Em relação as vantagens do uso de Threads em relação a Processos em sistemas distribuídos. As afirmações abaixo são verdadeiras?\n"
				+ " - Compartilham memória;\n - São iniciadas de forma mais rápida;\n - Podem ser encerradas assim que tiverem concluído sua função.\n"
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[2].resposta = this.certo;

		arrayDePerguntas[3].pergunta = "\n*********************\n"
				+ "No modelo cliente-servidor de computação distribuída, os servidores requisitam serviços dos clientes mediante uma interface do tipo HTTP.\n"
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[3].resposta = this.errado;

		arrayDePerguntas[4].pergunta = "\n*********************\n"
				+ "Os tipos mais comuns de defeitos em sistemas distribuídos provocados por falhas físicas de componentes ou interferência eletromagnética são:\n"
				+ "[0] Capturas de senhas , sobrecargas de servidores, mensagens duplicadas\n"
				+ "[1] Colapso de servidores, queda do enlace e perda de mensagens"
				+ "\n*********************\n";
		arrayDePerguntas[4].resposta = this.certo;

		arrayDePerguntas[5].pergunta = "\n*********************\n"
				+ "A definição de concorrência na Computção Distribuída é:\n"
				+ "A execusão concorrente é uma característica intrínseca de um sistema distribuédo, na qual os recursos disputam os processos."
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[5].resposta = this.errado;

		arrayDePerguntas[6].pergunta = "\n*********************\n"
				+ "O objetivo de uma camada de Middleware em um sistema multicamadas é:\n"
				+ "Disponibilizar classes utilitárias e serviços independentes de plataformas que permitam a obtenção de computação distribuída em ambientes heterogêneos."
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[6].resposta = this.certo;

		arrayDePerguntas[7].pergunta = "\n*********************\n"
				+ "A comunicação entre processos em um sistema distribuédo pode ser realizado por um mecanismo conhecido como RPC - Chamada de Procedimento Remoto. Sobre esse mecanismo qual é a opção correta?\n"
				+ "[0] Os stubs cliente e servidor são responsaveis pela conversão de formato dos parâmetros de entrada e saîda, caso haja necessidade\n"
				+ "[1] Processos comunicantes compartilham o mesmo espaço de endereçamento";
		arrayDePerguntas[7].resposta = this.errado;

		arrayDePerguntas[8].pergunta = "\n*********************\n"
				+ "Sistemas distribuídos Pervasivos se caracterizam por...\n"
				+ "Equipamentos costumam ser caracterizados por seu pequeno tamanho, alimentado por bateria, mobilidade e conexão sem fio.\n"
				+ "[0] FALSO\n[1] VERDADEIRO"
				+ "\n*********************\n";
		arrayDePerguntas[8].resposta = this.certo;

		arrayDePerguntas[9].pergunta = "\n*********************\n"
				+ "Em uma rede onde o cliente consome serviços oferecido por um servidor, que fornece este serviço simultaneamente a diversos usuários, estamos falando de:\n"
				+ "[0] Arquitetura ponto a ponto\n"
				+ "[1] Arquitetura Cliente/Servidor" +
				"\n*********************\n";
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
	public String verificaResposta () {
		if (respClienteA == arrayDePerguntas[questaoclienteA].resposta && respClienteB == arrayDePerguntas[questaoclienteB].resposta) {
			return "Cliente A e cliente B acertaram";
		} else if (respClienteA == arrayDePerguntas[questaoclienteA].resposta && respClienteB != arrayDePerguntas[questaoclienteB].resposta){
			return "Cliente A acertou e Cliente B errou!";
		}
		else if (respClienteA != arrayDePerguntas[questaoclienteA].resposta && respClienteB != arrayDePerguntas[questaoclienteB].resposta) {
			return "Cliente A errou e Cliente B acertou!";
		} else {
			return "Cliente A e Cliente B erraram!";
		}
	}
	// Salva as informações dos clientes e seta se eles responderam as questões
	public void salvaInformacao(int resposta) {
		if (clienteA == false) {
			questaoclienteA = numQuestao;
			respClienteA = respDoCliente;
			clienteA = true;
		}
		else {
			questaoclienteB = numQuestao;
			respClienteB = respDoCliente;
			clienteB = true;
		}
	}

	// Verifica se pode dar o resultado final para os clientes
	public boolean verificaClientes() {
		while (clienteA == false || clienteB == false) {
			return false;
		}
		return true;
	}
}
