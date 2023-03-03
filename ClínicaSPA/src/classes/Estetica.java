package classes;

import java.io.Serializable;

import interfaces.Atividades;

public class Estetica extends Pacientes implements Atividades, Serializable {

	public String tipoServico;

	/**CONSTRUTOR**/

	public Estetica(String nome, String telefone, String genero, String tipodeAtividade, String tipodeTratamento,
			String tipoServico) {
		super(nome, telefone, genero, tipodeAtividade, tipodeTratamento);
		this.tipoServico = tipoServico;
	}

	/**MÉTODOS SOBRESCRITOS**/

	@Override
	public String mostrarDadosCadastro() { //dado dos cadastrados em estética
		return "\nNome: "+getNome()+"\nTelefone: "+getTelefone()+"\nGênero: "+getGenero()+"\nTipo de Atividade: "+getTipodeAtividade()+
				"\nTipo de Serviço: "+tipoServico;
	}

	@Override
	public String passearBosque() {
		return "Passear no Bosque";
	}

	@Override
	public String exercitarNaAcademia() { 
		return "Exercita-se na Academia";
	}

	@Override
	public String nadarPiscina() {
		return "Nadar na Piscina";
	}
}
