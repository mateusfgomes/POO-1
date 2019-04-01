import java.io.IOException;

/**
 * Classe que representa as figuras geom�tricas: c�rculo, ret�ngulo e quadrado. Para
 * todas elas devem ser implementados m�todos para retornar a �rea e o per�metro. O c�rculo possui
 * um raio e as outras classes os tamanhos dos lados. Al�m disso as figuras possuem uma cor, definida
 * por um atributo string e um atributo �filled� que diz se a figura � preenchida pela cor ou se � vazia.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class FiguraGeometrica {
	protected String cor;
	protected int filled;
	FiguraGeometrica fig;
		
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static void main (String[] args) throws NumberFormatException, IOException {
		System.out.println("Escolha a figura geom�trica:\n"
							+ "1 - Circulo\n"
							+ "2 - Quadrado\n"
							+ "3 - Retangulo\n");
		int tipo = EntradaTeclado.leInt();
		
		if(tipo == 1) { //circulo
			Circulo c = new Circulo();
			System.out.println("Raio: ");
			c.setRaio(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			c.setCor(color);
			
			System.out.println("\nPer�metro: " + c.perimetro(c.getRaio()) 
								+ "\n�rea: " + c.area(c.getRaio())
								+ "\nCor: " + c.getCor());
			
		}
		else if(tipo == 2) { //quadrado
			Quadrado q = new Quadrado();
			System.out.println("Base: ");
			q.setBase(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			q.setCor(color);
			
			System.out.println("\nPer�metro: " + q.perimetro(q.getBase()) 
							+ "\n�rea: " + q.area(q.getBase())
							+ "\nCor: " + q.getCor());
		}
		else if(tipo == 3) { //retangulo
			Retangulo r = new Retangulo();
			System.out.println("Base: ");
			r.setBase(EntradaTeclado.leDouble());
			System.out.println("Altura: ");
			r.setAltura(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			r.setCor(color);
			
			System.out.println("\nPer�metro: " + r.perimetro(r.getBase(), r.getAltura()) 
							+ "\n�rea: " + r.area(r.getBase(), r.getAltura())
							+ "\nCor: " + r.getCor());
		}
		
	}
	
}
