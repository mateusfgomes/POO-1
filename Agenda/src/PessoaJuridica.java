/**
 * A pessoa jur�dica possui os seguintes atributos: CNPJ, nome, endere�o, email, inscri��o estadual,
 *raz�o social, outros que voc� achar necess�rios.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class PessoaJuridica extends ContatoBasico {
	
	private String cnpj;
	private String inscrEstadual;
	private String razaoSocial;
	
	/**
	 * Construtor de Pessoa juridica
	 * @param n Nome
	 * @param end Endere�o
	 * @param m Email
	 * @param num CNPJ
	 * @param insc Insri��o Estadual
	 * @param razao Razao Social
	 */
	public PessoaJuridica(String n, String end, String m, String num, String insc, String razao) {
		super(n, end, m);
		this.cnpj = num;
		this.inscrEstadual = insc;
		this.razaoSocial = razao;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Nome: " + nome + "\n";
		s += "Endere�o: " + endereco + "\n";
		s += "E-mail: " + email + "\n";
		s += "CNPJ: " + cnpj + "\n";
		s += "Inscri��o Estadual: " + inscrEstadual + "\n";
		s += "Raz�o Social: " + razaoSocial + "\n";
		s += "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
		
		return s;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEstadual() {
		return inscrEstadual;
	}

	public void setInscrEstadual(String inscrEstadual) {
		this.inscrEstadual = inscrEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
}
