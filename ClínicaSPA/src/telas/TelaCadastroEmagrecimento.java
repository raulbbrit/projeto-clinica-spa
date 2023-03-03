package telas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import arquivo.Arquivo;
import classes.Emagrecimento;
import classes.Pacientes;

public class TelaCadastroEmagrecimento extends JFrame {

	private JLabel jlNome, jlPeso, jlTelefone, jlGenero, jlAltura, jlTipoDeAtividade, jlImagem;
	private JRadioButton jrbMasculino, jrbFeminino;
	private ButtonGroup bgGenero;
	private JTextField jtfNome, jtfPeso, jtfTelefone, jtfAltura;
	private ImageIcon imagem;
	private JButton jbCadastrar, jbFecharCadastro;
	private String[] tipoDeAtividade = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar-se na Academia"};
	private JList<String> jlistaAtividade;

	private List<Pacientes> pacientes = null;
	protected Arquivo arquivo = new Arquivo();

	public TelaCadastroEmagrecimento(String title, List<Pacientes> pacientes) {
		super(title);
		this.pacientes = pacientes;
		setSize(400, 400);
		setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.pink);
		iniciarComponentes();
		iniciarEventos();

	}

	private void iniciarComponentes() {

		/*
		 * - Criar objeto
		 * - Adiconar
		 * - Colocar cor, se precisar
		 * - Dimensionar
		 * 
		 *********/

		/**JLabel**/

		jlNome = new JLabel("Nome:");
		add(jlNome);
		jlNome.setBounds(10, 20, 50, 20);

		jlGenero = new JLabel("Gênero:");
		add(jlGenero);
		jlGenero.setBounds(265, 20, 50, 20);

		jlPeso = new JLabel("Peso:");
		add(jlPeso);
		jlPeso.setBounds(10, 100, 50, 20);

		jlTelefone = new JLabel("Telefone:");
		add(jlTelefone);
		jlTelefone.setBounds(200, 100, 100, 20);

		jlTipoDeAtividade = new JLabel("Tipo de Atividade:");
		add(jlTipoDeAtividade);
		jlTipoDeAtividade.setBounds(10, 190, 100, 20);

		jlAltura = new JLabel("Altura:");
		add(jlAltura);
		jlAltura.setBounds(200, 190, 100, 20);

		/**JTextArea**/

		jtfNome = new JTextField();
		add(jtfNome);
		jtfNome.setBounds(10, 40, 175, 20);

		jtfPeso = new JTextField();
		add(jtfPeso);
		jtfPeso.setBounds(10, 120, 100, 20);

		jtfTelefone = new JTextField();
		add(jtfTelefone);
		jtfTelefone.setBounds(200, 120, 175, 20);

		jtfAltura = new JTextField();
		add(jtfAltura);
		jtfAltura.setBounds(200, 220, 75, 20);

		/**RadioButton**/

		bgGenero = new ButtonGroup();

		jrbMasculino = new JRadioButton("Masculino");
		add(jrbMasculino);
		bgGenero.add(jrbMasculino);
		jrbMasculino.setBackground(Color.pink);
		jrbMasculino.setBounds(200, 40, 100, 20);

		jrbFeminino = new JRadioButton("Feminino");
		add(jrbFeminino);
		bgGenero.add(jrbFeminino);
		jrbFeminino.setBackground(Color.pink);
		jrbFeminino.setBounds(300, 40, 100, 20);

		/**JList**/

		jlistaAtividade = new JList<String>(tipoDeAtividade);
		add(jlistaAtividade);
		jlistaAtividade.setBackground(Color.pink);
		jlistaAtividade.setBounds(10, 220, 150, 60);

		/**JButton**/

		jbCadastrar = new JButton("Cadastrar");
		add(jbCadastrar);
		jbCadastrar.setBackground(Color.decode("#D494A0"));
		jbCadastrar.setBounds(30, 320, 100, 20);

		jbFecharCadastro = new JButton("Sair");
		add(jbFecharCadastro);
		jbFecharCadastro.setBackground(Color.decode("#D494A0"));
		jbFecharCadastro.setBounds(30, 360, 100, 20);

		/**Imagem**/

		imagem = new ImageIcon(getClass().getResource("/imagem/LogoSakura.png"));
		jlImagem = new JLabel(imagem);
		add(jlImagem);
		jlImagem.setBounds(180, 140, 200, 300);

	}

	private void iniciarEventos() {


		jbCadastrar.addActionListener(new ActionListener() { //botão cadastrar

			@Override
			public void actionPerformed(ActionEvent e) {
				/**Variaveis locais para passar no construtor**/

				String genero = null;
				String atividade = null;

				/**Formatação na lista de Atividades**/

				if(jlistaAtividade.isSelectedIndex(0)) atividade = "Caminhar no Bosque";
				if(jlistaAtividade.isSelectedIndex(1)) atividade = "Nadar na Piscina";
				if(jlistaAtividade.isSelectedIndex(2)) atividade = "Exercitar-se na Academia";

				/**JButton formatação**/

				if (jrbMasculino.isSelected()) genero="Masculino";
				if (jrbFeminino.isSelected()) genero="Feminino";	

				if(jtfNome.getText().isEmpty() || jtfAltura.getText().isEmpty() || jtfTelefone.getText().isEmpty() ||
						jtfPeso.getText().isEmpty() || genero==null || atividade==null) { //validação dos campos

					JOptionPane.showMessageDialog(null, "Preencha todas as informações corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					try {

						/**Construtor da Classe Emagrecimento
						 * Passar as informações usando a classe mãe Pacientes
						 * **/
						pacientes.add(new Emagrecimento(jtfNome.getText(), jtfTelefone.getText(), genero, atividade, "Emagrecimento",
								Float.parseFloat(jtfPeso.getText()), Float.parseFloat(jtfAltura.getText())));

						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "CADASTRO EMAGRECIMENTO", JOptionPane.INFORMATION_MESSAGE);

						setVisible(false);

					} catch (NumberFormatException e2) { //validação do erro de entrada 

						JOptionPane.showMessageDialog(null, "Erro ao cadastrar. Confira as informações", "CADASTRO EMAGRACIMENTO", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		jbFecharCadastro.addActionListener(new ActionListener() { //botão fechar cadastro

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
	}
}