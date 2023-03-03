package classes;

import java.io.Serializable;

public abstract class Pacientes  implements Serializable{

	protected String nome, telefone, genero, tipodeAtividade, tipodeTratamento;

	/**CONSTRUTOR**/

	public Pacientes(String nome, String telefone, String genero, String tipodeAtividade, String tipodeTratamento) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.genero = genero;
		this.tipodeAtividade = tipodeAtividade;
		this.tipodeTratamento = tipodeTratamento;
	}

	/**GETTERS E SETTERS**/

	public String getGenero() {
		return genero;
	}

	public String getTipodeAtividade() {
		return tipodeAtividade;
	}

	public void setTipodeAtividade(String tipodeAtividade) {
		this.tipodeAtividade = tipodeAtividade;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTipodeTratamento() {
		return tipodeTratamento;
	}

	/**MÉTODOS**/

	public String mostrarDadosCadastro() { //cadastro-mãe. Passar isso para as Classes Filhas para sobrescrever o método
		return null;
	}
}