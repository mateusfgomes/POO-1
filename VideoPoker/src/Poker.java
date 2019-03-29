import java.io.IOException;
/**
 * 		VIDEO POKER
 *		O video poker � um jogo de cartas em que o usu�rio interage com o computador,
 *fazendo apostas e tentando conseguir algumas combina��es espec�ficas (as mesmas
 *do poker normal) que lhe d�o recompensas, proporcionais ao valor que o jogador
 *apostou.
 *		Cada jogo inicia com o jogador recebendo uma quantidade fixa de cr�ditos (200
 *cr�ditos). 
 *		Cada rodada inicia com o jogador apostando um certo n�mero de cr�ditos,
 *maior que zero e menor ou igual ao n�mero de cr�ditos que possui. 
 *		Feito isso, o jogador recebe cinco cartas e deve tentar fazer uma das combina��es 
 *que lhe paguem os pr�mios. Para isso, o jogador pode escolher trocar de zero a cinco cartas
 *que recebeu. Em seguida, pode trocar mais uma vez as cartas para alcan�ar alguma
 *combina��o.
 */

/**
 * Administra e roda o jogo.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Poker {
	/**
	 **************************************************************************************								
	 * _____________________________COMBINA��ES__________________________________________ *
	 *	Combina��o 												Pr�mio					  *	
	 *	Dois pares 												1 X Valor da aposta		  *
	 *	Trinca 													2 X valor da aposta		  *
	 *	Straight (5 cartas em sequ�ncia de naipes diferentes) 	5 X valor da aposta		  *
	 *	Flush (5 cartas do mesmo naipe n�o seguidas) 			10 X valor da aposta	  *
	 *	Full hand (uma trinca e um par) 						20 X valor da aposta	  *
	 *	Quadra 													50 X valor da aposta	  *
	 *	Straight Flush (5 cartas seguidas do mesmo naipe) 		100 X valor da aposta	  *
	 *	Royal Straight Flush 									200 X valor da aposta	  *
	 *	(5 cartas seguidas do mesmo naipe de 10 at� o As) 								  *
	 * ___________________________________________________________________________________*
	 *																					  *
	 **************************************************************************************
	 */
	
	/**
	 * Encontra combina��es de uma m�o de cartas.
	 * @param m M�o que ser� verificada.
	 * @return Valor do b�nus que a combina��o encontrada concede como pr�mio
	 */
	public static int premio (Mao m) { //verifica qual ser� o premio recebido e retorna o valor a ser multiplicado pelo valor da aposta
		if (Mao.royalStraightFlush(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu um Royal Straight Flush! :D\n");
			return 200;
		}
		if (Mao.straightFlush(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu um Straight Flush! :D\n");
			return 100;
		}
		if(Mao.quadra(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu uma Quadra! :D\n");
			return 50;
		}
		if(Mao.fullHand(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu uma Full Hand! :D\n");
			return 20;
		}
		if(Mao.flush(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu um Flush! :D\n");
			return 10;
		}
		if(Mao.straight(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu um Straight! :D\n");
			return 5;
		}
		if(Mao.trinca(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu uma Trinca! :D\n");
			return 2;
		}
		if(Mao.doisPares(m) == 1) {
			System.out.println("Parab�ns! Voc� conseguiu Dois Pares! :D\n");
			return 1;
		}
		System.out.println("Que pena! Voc� n�o conseguiu nenhuma combina��o! :(\n");
		return 0;
	}
	
	public static void main (String [] args) throws IOException {
		System.out.println("~*~*~ BEM VINDO AO VIDEO POKER!!!! ~*~*~\n");
		
		int enter = 0;
		System.out.println("Digite 1 para come�ar.\n");
		while (enter != 1) {
			enter = EntradaTeclado.leInt();
			if (enter != 1) System.out.println("Digite 1 para come�ar.\n");
		}
		
		
		double saldo = 200;
		
		//criando baralho
		Baralho baralho = new Baralho();
		
		//criando m�o
		Mao mao = new Mao(baralho);
		
		int rodada = 0;
		
		do {
			//NOVA RODADA
			rodada++;
			System.out.println("\n###### RODADA " + rodada + " ######");	
			System.out.printf("Saldo: $%.2f \n", saldo);
			
			//fazendo a aposta
			System.out.println("\nDigite o valor que deseja apostar: ");
			double aposta = EntradaTeclado.leDouble();
			while(aposta < 0 || aposta > saldo) {
				System.out.println("\nValor inv�lido. Digite um valor menor ou igual ao seu saldo, e maior ou igual a zero: ");
				aposta = EntradaTeclado.leDouble();
			}
			saldo = saldo - aposta;
			

			System.out.println("Suas cartas s�o: ");
			//printando a m�o
	        System.out.print("\n");
			Mao.printaMao(mao);
			
			//PRIMEIRA TROCA
			System.out.println("PRIMEIRA TROCA: Digite quantas cartas deseja tocar (de 0 a 5): ");
			int n = EntradaTeclado.leInt();
			
			int option;
			for(int i = 0; i < n; i++) {
				System.out.printf("Digite a(s) carta(s) que deseja trocar\n");
				option = EntradaTeclado.leInt();
				if(option < 1 || option > 5) {
					break;
				}
				//trocando a carta escolhida
				baralho.TrocarCarta(mao, option-1);
			}
			
			System.out.println("Sua m�o atualizada �: ");
			Mao.printaMao(mao);
			
			
			//SEGUNDA TROCA
			System.out.println("SEGUNDA TROCA: Digite quantas cartas deseja tocar (de 0 a 5): ");
			n = EntradaTeclado.leInt();
			
			for(int i = 0; i < n; i++) {
				System.out.println("Digite a(s) carta(s) que deseja trocar:");
				option = EntradaTeclado.leInt();
				if(option < 1 || option > 5) {
					break;
				}
				//trocando a carta escolhida
				baralho.TrocarCarta(mao, option-1);
			}
			System.out.println("Suas m�o atualizada �: ");
			Mao.printaMao(mao);
			
			//FIM DA RODADA -- RESULTADOS:
			System.out.println("FIM DA RODADA\n" + "");
			int bonus = premio(mao);
			
			saldo = saldo + (aposta * bonus); //atualizando o saldo com o premio ganho
			
			//FIM DA RODADA
			
		}while(saldo > 0);
		
		
		System.out.println("Seu saldo acabou!\n FIM DE JOGO!\n");
		
		
	}
	

}
