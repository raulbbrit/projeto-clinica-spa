package classes;

import java.io.Serializable;
import java.text.DecimalFormat;

import interfaces.Atividades;

public class Emagrecimento extends Pacientes implements Atividades, Serializable {

	private float peso, altura;

	/**CONSTRUTOR**/

	public Emagrecimento(String nome, String telefone, String genero, String tipodeAtividade, String tipodeTratamento,
			float peso, float altura) {
		super(nome, telefone, genero, tipodeAtividade, tipodeTratamento);
		this.peso = peso;
		this.altura = altura;
	}

	/**GETTERS**/

	public float getPeso() {
		return peso;
	}

	public float getAltura() {
		return altura;
	}

	/**MÉTODOS SOBRESCRITOS**/

	@Override
	public String mostrarDadosCadastro() { //dado dos cadastrados em emagrecimento
		return "\nTipo de tratamento: "+getTipodeTratamento()+"\nNome: "+getNome()+"\nTelefone: "+getTelefone()+"\nTipo de Atividade: "+getTipodeAtividade()+
				"\nPeso : "+getPeso()+" Kg";
	}

	@Override
	public String passearBosque() {
		return "Caminhar no Bosque";
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