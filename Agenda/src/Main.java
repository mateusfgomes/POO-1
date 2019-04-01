import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static int menu() {
		System.out.println("---------AGENDA 2019---------\n\n" 
						+ "Escolha o que deseja fazer: \n"
						+ "1 - Adicionar contato.\n"
						+ "2 - Remover contato.\n" 
						+ "3 - Pesquisar contato.\n"
						+ "4 - Visualizar todos contatos.\n"
						 );
		int option = 0;
		option = tryCatch(1, 4);
		
		return option;
	}
	

	/**
	 * L� um numero e verifica se a op��o digitada � valida, ou seja, est� dentro do intervalo desejado.
	 * @param menor Menor valor do intervalo que se deseja verificar.
	 * @param maior Maior valor do intervalo que se deseja verificar.
	 * @return Retorna o primeiro valor v�lido digitado pelo usu�rio.
	 */
	public static int tryCatch(int menor, int maior) {
		int valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leInt();
			} catch (Exception e) {
				System.out.print("Isto n�o � um n�mero. ");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				System.out.println("Digite uma op��o v�lida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
		
	public static void main (String[] args) throws IOException {
		
		ArrayList<ContatoBasico> agenda = new ArrayList<ContatoBasico>();
		
		while (true) {
			int option = menu();
			if (option == 1) { //ADICIONAR CONTATO
				System.out.println("Digite 1 para adicionar Pessoa F�sica, ou 2 para Pessoa Juridica");
				int pType = tryCatch(1, 2); //l� a op��o de verifica se a op��o digitada � valida
					
				//lendo as informa��es basics
				System.out.println("Nome: ");
				String n = EntradaTeclado.leString();
				System.out.println("Endere�o: ");
				String end = EntradaTeclado.leString();
				System.out.println("Email: ");
				String mail = EntradaTeclado.leString();
				
				if(pType == 1) { //se for pessoa f�sica
					System.out.println("CPF: ");
					String doc = EntradaTeclado.leString();
					System.out.println("Data de nascimento: ");
					String data = EntradaTeclado.leString();
					System.out.println("Estado Civil: ");
					String est = EntradaTeclado.leString();
					
					PessoaFisica p = new PessoaFisica(n, end, mail, doc, data, est);
					agenda.add(p);
				}
				else { //se for pessoa juridica
					System.out.println("CNPJ: ");
					String doc = EntradaTeclado.leString();
					System.out.println("Inscri��o Estadual: ");
					String insc = EntradaTeclado.leString();
					System.out.println("Raz�o Social: ");
					String razao = EntradaTeclado.leString();
					
					PessoaJuridica p = new PessoaJuridica(n, end, mail, doc, insc, razao);
					agenda.add(p);
				}
				
			}
			else if (option == 2) { //REMOVER CONTATO
				System.out.println("Digite o CPF ou CNPJ da pessoa que deseja remover:");
				String doc = EntradaTeclado.leString();
				int indexPessoa = Agenda.buscaContato(doc, agenda);
				if(indexPessoa == -1) {
					System.out.println("Pessoa n�o encontrada.");
				}
				else {
					agenda.remove(indexPessoa);
					System.out.println("Pessoa removida!");
				}
			}
			else if (option == 3) { //PESQUISAR CONTATO (por nome ou por CPF/CNPJ)
				System.out.println("Digite 1 para pesquisar por nome, ou 2 para pesquisar por CPF/CNPJ: ");
				int p = tryCatch(1, 2);
				int index;
				String escolha;
				if(p == 1) { //pesquisar por nome
					System.out.println("Digite o nome que deseja pesquisar: ");
					escolha = EntradaTeclado.leString();
					agenda = Agenda.ordenaAgendaPorNome(agenda);
					index = Agenda.buscaContatoPorNome(escolha, agenda);
					if(index != -1) {
						System.out.println("PESSOA ENCONTRADA!\n" + agenda.get(index).toString());
					}
					
				}else { //pesquisar por CPF/CNPJ
					System.out.println("Digite o CPF/CNPJ que deseja pesquisar: ");
					escolha = EntradaTeclado.leString();
					agenda = Agenda.ordenaAgenda(agenda);
					index = Agenda.buscaContato(escolha, agenda);
					if(index != -1) {
						System.out.println("PESSOA ENCONTRADA!\n" + agenda.get(index).toString());
					}
					
				}	
			}
			else { //VISUALIZAR TODOS CONTATOS
				Agenda.printAgenda(agenda);
				
			}
		}
	}
}
