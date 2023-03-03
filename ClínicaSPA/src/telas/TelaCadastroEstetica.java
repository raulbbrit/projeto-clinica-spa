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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import arquivo.Arquivo;
import classes.Estetica;
import classes.Pacientes;

public class TelaCadastroEstetica extends JFrame {
	private JLabel jlNome, jlTelefone, jlGenero, jlTipoDeAtividade, jlTipoDeServico, jlImagem;
	private JRadioButton jrbMasculino, jrbFeminino;
	private ButtonGroup bgGenero;
	private JTextField jtfNome, jtfTelefone;
	private ImageIcon imagem;
	private JButton jbCadastrar, jbFecharCadastro;
	private JList<String> jlistaAtividade;
	private JList<String> jlistaServico;
	private JScrollPane jspTipoDeServico; 
	private List<Pacientes> pacientes;
	protected Arquivo arquivo = new Arquivo();

	private String[] tipoDeAtividade = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar-se na Academia"};
	private String[] tipoDeServico = {"Drenagem linfática","Hidratação de pés e mãos","Limpeza de pele",
			"Banho de lua","Peeling","Cuidados para o cabelo","Massagem esfoliante facial e corporal"};


	public TelaCadastroEstetica(String title, List<Pacientes> pacientes) {
		super(title);
		this.pacientes = pacientes;
		setSize(400, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
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

		jlTelefone = new JLabel("Telefone:");
		add(jlTelefone);
		jlTelefone.setBounds(200, 100, 100, 20);

		jlTipoDeAtividade = new JLabel("Tipo de Atividade:");
		add(jlTipoDeAtividade);
		jlTipoDeAtividade.setBounds(10, 100, 100, 20);

		jlTipoDeServico = new JLabel("Tipo de Serviço");
		add(jlTipoDeServico);
		jlTipoDeServico.setBounds(10, 220, 100, 20);

		/**JTextArea**/

		jtfNome = new JTextField();
		add(jtfNome);
		jtfNome.setBounds(10, 40, 175, 20);

		jtfTelefone = new JTextField();
		add(jtfTelefone);
		jtfTelefone.setBounds(200, 120, 175, 20);

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

		/**JList & JScroll**/
		jspTipoDeServico = new JScrollPane();
		add(jspTipoDeServico);
		jspTipoDeServico.setViewportView(jlistaServico);

		jlistaAtividade = new JList<String>(tipoDeAtividade);
		add(jlistaAtividade);
		jlistaAtividade.setBackground(Color.pink);
		jlistaAtividade.setBounds(10, 130, 150, 62);

		jlistaServico = new JList<String>(tipoDeServico);
		add(jlistaServico);
		jlistaServico.setBackground(Color.pink);
		jspTipoDeServico.setBounds(10, 240, 250, 60);

		/**JButton**/

		jbCadastrar = new JButton("Cadastrar");
		add(jbCadastrar);
		jbCadastrar.setBackground(Color.decode("#D494A0"));
		jbCadastrar.setBounds(30, 320, 100, 20);

		jbFecharCadastro = new JButton("Sair");
		jbFecharCadastro.setBackground(Color.decode("#D494A0"));
		add(jbFecharCadastro);
		jbFecharCadastro.setBounds(230, 320, 100, 20);

		/**Imagem**/

		imagem = new ImageIcon(getClass().getResource("/imagem/LogoSakura.png"));
		jlImagem = new JLabel(imagem);
		add(jlImagem);
		jlImagem.setBounds(180, 40, 200, 300);

	}

	private void iniciarEventos() {

		jbCadastrar.addActionListener(new ActionListener() { //botão cadastrar

			@Override
			public void actionPerformed(ActionEvent e) {

				/**Variaveis locais para passar no construtor**/

				String genero = null;
				String atividade = null;
				String tipoServico = null;

				/**Formatação da lista de Atividades**/

				if(jlistaAtividade.isSelectedIndex(0)) atividade = "Caminhar no Bosque";
				if(jlistaAtividade.isSelectedIndex(1)) atividade = "Nadar na Piscina";
				if(jlistaAtividade.isSelectedIndex(2)) atividade = "Exercitar-se na Academia";

				/**Formatação da lista de Serviços**/

				if(jlistaServico.isSelectedIndex(0)) tipoServico = "Drenagem linfática";
				if(jlistaServico.isSelectedIndex(1)) tipoServico = "Hidratação de pés e mãos";
				if(jlistaServico.isSelectedIndex(2)) tipoServico = "Limpeza de pele";
				if(jlistaServico.isSelectedIndex(3)) tipoServico = "Banho de lua";
				if(jlistaServico.isSelectedIndex(4)) tipoServico = "Peeling";
				if(jlistaServico.isSelectedIndex(5)) tipoServico = "Cuidados para o cabelo";
				if(jlistaServico.isSelectedIndex(6)) tipoServico = "Massagem esfoliante facial e corporal";

				/**JButton formatação**/

				if (jrbMasculino.isSelected()) genero=jrbMasculino.getText();
				if (jrbFeminino.isSelected()) genero=jrbFeminino.getText();	

				/**Validação e 
				 * Adicionando as informações de Estetica**/

				if(!jtfNome.getText().isEmpty() || !jtfTelefone.getText().isEmpty() || genero != null || atividade != null ||
						tipoServico != null) {
					try {
						pacientes.add(new Estetica(jtfNome.getText(), jtfTelefone.getText(), genero, atividade, "Estética", tipoServico));	
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "CADASTRO ESTÉTICA", JOptionPane.INFORMATION_MESSAGE);

						setVisible(false);

						/**Exception**/
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar. Confira as informações", "CADASTRO EMAGRACIMENTO", JOptionPane.INFORMATION_MESSAGE);
					}

				} else JOptionPane.showMessageDialog(null, "Preencha todas as informações corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
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