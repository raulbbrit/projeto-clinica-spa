package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import classes.Pacientes;


public class Arquivo {

	public void escreverArquivo(List<Pacientes> lista) { //chama lista Pacientes

		FileOutputStream fluxo;

		/**Escrever**/

		try {
			fluxo = new FileOutputStream("Paciente.bin");
			ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
			objeto.writeObject(lista);
			objeto.close();

			/**Erros**/

		} catch (FileNotFoundException e) {
			System.err.println("Arquivo inexistente");

		} catch (IOException e) {	
			System.err.println("Arquivo corrompido");

		}

		System.out.println("Salvo com sucesso");
	}

	public List<Pacientes> lerObjeto(List<Pacientes> lista) { //chama lista Pacientes

		FileInputStream fluxo;

		/**Ler**/

		try {
			fluxo = new FileInputStream("Paciente.bin");
			ObjectInputStream objeto = new ObjectInputStream(fluxo);
			lista = (List<Pacientes>) objeto.readObject();
			objeto.close();

			/**Erros**/

		} catch (ClassNotFoundException e) {
			System.err.println("Arquivo corrompido");

		} catch (FileNotFoundException e) {
			System.err.println("Arquivo inexistente");
			escreverArquivo(lista);

		} catch (IOException e) {
			System.err.println("Arquivo corrompido");
		}

		return lista;
	}
}