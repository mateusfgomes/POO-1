import java.io.IOException;
/**
 * 
 * A pessoa f�sica tem os seguintes atributos:
 * CPF, nome, endere�o, data de nascimento, email, estado civil, outros.
 * 
 * @author Michelle Wingter da Silva
 * @author 10783243
 */
public class PessoaFisica extends ContatoBasico {
	
	private String cpf;
	private String dataNascimento;
	private String estadoCivil;
	
	/**
	 * Construtor de Pessoa F�sica
	 * @param n Nome da pessoa
	 * @param end Endere�o
	 * @param mail Email
	 * @param num CPF
	 * @param data Data de Nascimento
	 * @param estado Estado Civil
	 */
	public PessoaFisica(String n, String end, String mail, String num, String data, String estado) {
		super(n, end, mail);
		this.cpf = num;
		this.dataNascimento = data;
		this.estadoCivil = estado;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Nome: " + nome + "\n";
		s += "Endere�o: " + endereco + "\n";
		s += "E-mail: " + email + "\n";
		s += "CPF: " + cpf + "\n";
		s += "Data de Nascimento: " + dataNascimento + "\n";
		s += "Estado Civil: " + estadoCivil + "\n";
		s += "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
		
		return s;
	}

	/**
	* Retorna a String do CPF da pessoa f�sica
	* @return String do CPF da pessoa f�sica
	*/
	public String getCpf() {
		return cpf;
	}

	/**
	 * Define um CPF de uma pessoa f�sica
	 * @param cpf CPF da Pessoa Fisica
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna a String da data de nascimento de uma pessoa f�sica
	 * @return String da data de nascimento de uma pessoa f�sica
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Define a data de nascimento de uma pessoa f�sica
	 * @param dataNascimento Data de nascimento de uma pessoa fisica
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o estado civil de uma pessoa fisica
	 * @return String do estado civil de uma pessoa f�sica
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * Define o estado civil de uma pessoa f�sica
	 * @param estadoCivil String do estado civil de uma pessoa f�sica
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	/**
	 * Formata a string recebida pelo usuario no formato padr�o do cpf (XXX.XXX.XXX-XX)
	 * @param cpf String do CPF no formato XXXXXXXXXXX
	 * @return O CPF formatado no padr�o XXX.XXX.XXX-XX
	 */
	/*public static String formataCPF(int cpf) {
		String p1 = cpf.substring(0,3);
		String p2 = cpf.substring(3,6);
		String p3 = cpf.substring(6,9);
		String p4 = cpf.substring(9,11);
		return cpf = String.format("%s.%s.%s-%s", p1, p2, p3, p4);	
	}*/
	
	/*
	public static void printPF(int i) {
		System.out.println("Nome: " + Agenda.get(i).getNome());
		System.out.println("CPF: " + Agenda.get(i).getCpf());
		System.out.println("Endere�o: " + Agenda.get(i).getEndereco());
		System.out.println("Data de nascimento: " + Agenda.get(i).getDataNascimento());
		System.out.println("Email: " + Agenda.get(i).email);
		System.out.println("Estado Civil: " + Agenda.get(i).getEstadoCivil());
	}
	*/
	
	//MAIN PARA FINS DE TESTE
	public static void main (String[] args) throws IOException {

	
	}
}
