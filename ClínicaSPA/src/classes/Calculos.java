package classes;

import java.io.Serializable;

public class Calculos implements Serializable {

	public static float pesoIdeal(float altura, String genero) { //calcular o massa corporal ideal

		if (genero.equals("Masculino")) //calculo para homem
			return (float) ((72.7*altura)- 58); 
		if (genero.equals("Feminino")) //calculo para mulher
			return (float) ((62.1*altura)- 44.7);

		return 0;
	}

	public static float porcentagemDoPesoIdeal(float pesoIdeal, float peso) { 

		return (float) ((1-pesoIdeal/peso)*100);
	}
}