package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import arquivo.Arquivo;
import classes.Calculos;
import classes.Emagrecimento;
import classes.Estetica;
import classes.Pacientes;

public class TelaPrincipal extends JFrame {

	private JMenuBar mnBarra;
	private JMenu jmOpcao, jmCadastro;
	private JMenuItem jmiSair, jmiCadastroDaEstetica, jmiCadastroDoEmagrecimento;
	private JButton jbPesquisar, jbApresentarDados, jbAlterar, jbRemover,
	jbEvolucaoDoPeso, jbGravar;
	private JTextArea jtaMostrar;
	private JLabel jlImagem;
	private ImageIcon imagem;
	private JScrollPane jspMostrar;


	protected List<Pacientes> pacientes = new ArrayList<Pacientes>();
	protected Arquivo arquivo = new Arquivo();

	public TelaPrincipal(String title){
		super(title);
		setBounds(0, 0, 620, 670);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setBackground(Color.decode("#F08080"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		iniciarEventos();
		pacientes=arquivo.lerObjeto(pacientes);
	}

	private void iniciarComponentes() {

		/***Barra Menu***/

		mnBarra = new JMenuBar();
		jmOpcao = new JMenu("Opcões");
		jmCadastro = new JMenu("Cadastros");
		jmiSair = new JMenuItem("Sair");
		jmiCadastroDaEstetica = new JMenuItem("Cadastro Estética"); 
		jmiCadastroDoEmagrecimento = new JMenuItem("Cadastro Emagrecimento");

		jmOpcao.add(jmiSair);
		jmCadastro.add(jmiCadastroDoEmagrecimento);
		jmCadastro.add(jmiCadastroDaEstetica);

		jmiSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jmiCadastroDaEstetica.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		jmiCadastroDoEmagrecimento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));

		mnBarra.add(jmOpcao);
		mnBarra.add(jmCadastro);

		setJMenuBar(mnBarra);



		/**Dado Cadastro**/

		/*
		 * - Criar objeto
		 * - Adiconar
		 * - Colocar cor, se precisar
		 * - Dimensionar
		 * 
		 *********/

		jbPesquisar = new JButton("Pesquisar");
		add(jbPesquisar);
		jbPesquisar.setBackground(Color.decode("#9D566D"));
		jbPesquisar.setBounds(450, 187, 140, 20);

		jbApresentarDados = new JButton("Apresentar Dados");
		add(jbApresentarDados);	
		jbApresentarDados.setBackground(Color.decode("#9D566D"));
		jbApresentarDados.setBounds(450, 227, 140, 20);

		jbAlterar = new JButton("Alterar");
		add(jbAlterar);
		jbAlterar.setBackground(Color.decode("#9D566D"));
		jbAlterar.setBounds(450, 517, 140, 20);

		jbRemover = new JButton("Remover");
		add(jbRemover);
		jbRemover.setBackground(Color.decode("#9D566D"));
		jbRemover.setBounds(450, 557, 140, 20);

		jbEvolucaoDoPeso = new JButton("Evolução do Peso");
		add(jbEvolucaoDoPeso);
		jbEvolucaoDoPeso.setBackground(Color.decode("#9D566D"));
		jbEvolucaoDoPeso.setBounds(450, 267, 140, 20);

		jbGravar = new JButton("Gravar");
		add(jbGravar);
		jbGravar.setBackground(Color.decode("#9D566D"));
		jbGravar.setBounds(450, 597, 140, 20);

		jtaMostrar = new JTextArea();
		add(jtaMostrar);

		jspMostrar = new JScrollPane();
		add(jspMostrar);
		jspMostrar.setViewportView(jtaMostrar);
		jspMostrar.setBounds(20 , 180, 400, 447);

		/**Imagem**/

		imagem = new ImageIcon(getClass().getResource("/imagem/LogoSakura.png"));
		jlImagem = new JLabel(imagem);

		add(jlImagem);

		jlImagem.setBounds(200,-75, 200, 300);

	}

	private void iniciarEventos() {

		jmiCadastroDoEmagrecimento.addActionListener(new ActionListener() { //Abrir o JFrame do Cadastro do Emagrecimento

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroEmagrecimento telaEmagrecimento = new TelaCadastroEmagrecimento("Cadastro do Emagrecimento", pacientes);
				telaEmagrecimento.setVisible(true);

			}
		});

		jmiCadastroDaEstetica.addActionListener(new ActionListener() { //Abrir o JFrame do Cadastro da Estética

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroEstetica telaEstetica = new TelaCadastroEstetica("Cadastro da Estética", pacientes);
				telaEstetica.setVisible(true);

			}
		});

		jbApresentarDados.addActionListener(new ActionListener() { //Botão para atualizar o JTextArea

			@Override
			public void actionPerformed(ActionEvent e) {

				jtaMostrar.setText(""); //reset no jtaMostrar
				int indice = 1;

				if(pacientes.size()==0) { //validação
					JOptionPane.showMessageDialog(null, "Total de pacientes: 0", "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
				} else {

					for (Pacientes pacientes2 : pacientes) {
						if (pacientes2 instanceof Emagrecimento) { //Apresentar paciente do Emagrecimento
							jtaMostrar.append(indice+"º"+pacientes2.mostrarDadosCadastro()+"\n\n");
						}
						if(pacientes2 instanceof Estetica) {//Apresentar paciente da Estética
							jtaMostrar.append(indice+"º"+pacientes2.mostrarDadosCadastro()+"\n\n");	
						}
						indice++;
					}				

				}
			}
		});

		jbEvolucaoDoPeso.addActionListener(new ActionListener() { /* botão para mostrar a 
		 *   porcentagem do peso ideal (apenas emagrecimento) */
			@Override
			public void actionPerformed(ActionEvent e) {

				if(pacientes.size()==0) { //validação
					JOptionPane.showMessageDialog(null, "Total de pacientes: 0", "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
				} else {
					String nome = JOptionPane.showInputDialog("Entre com o nome: ");
					for (Pacientes pacientes2 : pacientes) {
						if (pacientes2 instanceof Emagrecimento) {
							if(pacientes2.getNome().equals(nome)) {
								jtaMostrar.setText(""); //reset no jtaMostrar
								jtaMostrar.append("Paciente: "+pacientes2.getNome()+"\nPorcentagem do Peso ideal: "+
										Calculos.porcentagemDoPesoIdeal(Calculos.pesoIdeal(((Emagrecimento) pacientes2).getAltura(),
												pacientes2.getGenero()), ((Emagrecimento) pacientes2).getPeso())+"%");
							
							} else {
								JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				}
			}
		});

		jbAlterar.addActionListener(new ActionListener() { //botão para alterar a atividadade

			@Override
			public void actionPerformed(ActionEvent e) {

				if(pacientes.size()==0) { //validação
					JOptionPane.showMessageDialog(null, "Total de pacientes: 0", "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
				} else {

					/**Menu para escolher o tipo de paciente**/
					String[] tipoPaciente = {"Emagrecimento", "Estética"};
					int paciente_escolha = JOptionPane.showOptionDialog(null, "Escolha a atividade", "PACIENTES", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, tipoPaciente, "Emagrecimento");
					String nome = JOptionPane.showInputDialog("Entre com o nome: ");

					if (paciente_escolha == 0) { //Alterar no Emagrecimento
						for (Pacientes pacientes2 : pacientes) {
							if (pacientes2 instanceof Emagrecimento) {
								
								String[] tipoDeAtividade = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar-se na academia"};
								String atividade = null;
								int resp = JOptionPane.showOptionDialog(null, "Escolha a atividade", "EMAGRECIMENTO", JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null, tipoDeAtividade, "Caminhar no Bosque");
								if (resp == 0) atividade = ((Emagrecimento) pacientes2).passearBosque();
								if (resp == 1) atividade = ((Emagrecimento) pacientes2).nadarPiscina();
								if (resp == 2) atividade = ((Emagrecimento) pacientes2).exercitarNaAcademia();

								if (pacientes2.getNome().equals(nome)) {
									pacientes2.setTipodeAtividade(atividade);
									
								} else {
									JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //se o nome não existir
								}
							}
							
						}
					}

					if (paciente_escolha == 1) { //Alterar na Estética
						for (Pacientes pacientes2 : pacientes) {
							if(pacientes2 instanceof Estetica) {
								String[] tipoDeAtividade = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar-se na academia"};
								String atividade = null;
								int resp = JOptionPane.showOptionDialog(null, "Escolha a atividade", "ESTÉTICA", JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null, tipoDeAtividade, "Caminhar no Bosque");
								if (resp == 0) atividade = ((Estetica) pacientes2).passearBosque();
								if (resp == 1) atividade = ((Estetica) pacientes2).nadarPiscina();
								if (resp == 2) atividade = ((Estetica) pacientes2).exercitarNaAcademia();

								if (pacientes2.getNome().equals(nome)) {
									pacientes2.setTipodeAtividade(atividade);
									
								} else {
									JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //se o nome não existir
								}
							}
							
						}
					}
				}
			}
		});


		jbRemover.addActionListener(new ActionListener() {//botão para remover um paciente

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if(pacientes.size()==0) { //validação
						JOptionPane.showMessageDialog(null, "Total de pacientes: 0", "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
					} else {
						/**Menu para escolher o tipo de paciente**/
						String[] tipoPaciente = {"Emagrecimento", "Estética"};
						int resp = JOptionPane.showOptionDialog(null, "Escolha a atividade", "PACIENTES", JOptionPane.DEFAULT_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, tipoPaciente, "Emagrecimento");
						String nome = JOptionPane.showInputDialog("Entre com o nome: ");

						if (resp == 0) { //emagrecimento
							for (Pacientes pacientes3 : pacientes) {
								if (pacientes3 instanceof Emagrecimento) {
								
									if(pacientes3.getNome().equals(nome)) {
										pacientes.remove(pacientes3);
										
									} else {
										JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //validção
									}
								}
							}
						} 

						if (resp == 1) { //estética
							for (Pacientes pacientes3 : pacientes) {
								if (pacientes3 instanceof Estetica) {
							
									if(pacientes3.getNome().equals(nome)) {
										pacientes.remove(pacientes3);
										
									}  else {
										JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //validação
									}
								} 
							}
						}
					}
				} catch (ConcurrentModificationException erro) { //exception da alteração
					JOptionPane.showMessageDialog(null, "Paciente removido", "PACIENTES", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		jmiSair.addActionListener(new ActionListener() { //MenuItem para fechar o programa

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		jbPesquisar.addActionListener(new ActionListener() { //botão para pesquisar um paciente

			@Override
			public void actionPerformed(ActionEvent e) {

				if(pacientes.size()==0) { //validação
					JOptionPane.showMessageDialog(null, "Total de pacientes: 0", "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
				} else {
					/**Menu para escolher o tipo de paciente**/
					String[] tipoPaciente = {"Emagrecimento", "Estética"};
					int resp = JOptionPane.showOptionDialog(null, "Escolha a atividade", "PACIENTES", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, tipoPaciente, "Emagrecimento");
					String nome = JOptionPane.showInputDialog("Entre com o nome: ");

					if (resp == 0) { //emagrecimento
						for (Pacientes pacientes2 : pacientes) {
							if(pacientes2 instanceof Emagrecimento) {
							
								if (pacientes2 instanceof Emagrecimento) {
									if(pacientes2.getNome().equals(nome)) {
										jtaMostrar.setText("");
										jtaMostrar.append(pacientes2.mostrarDadosCadastro()+"\nPeso Ideal: "+
												Calculos.pesoIdeal(((Emagrecimento) pacientes2).getAltura(), pacientes2.getGenero())+" Kg");
										
									} else {
										JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //validação
									}
								}
							}
						}
					} 

					if (resp == 1) { //estetica
						for (Pacientes pacientes2 : pacientes) {
							if (pacientes2 instanceof Estetica) {
								
								if (pacientes2 instanceof Estetica) {
									if(pacientes2.getNome().equals(nome)) {
										jtaMostrar.setText("");
										jtaMostrar.append(pacientes2.mostrarDadosCadastro());
										
									} else {
										JOptionPane.showMessageDialog(null, "Paciente não encontrado", "PACIENTES", JOptionPane.ERROR_MESSAGE); //validação
									}
								}
							}
						} 
					}
				}
			}
		});

		jbGravar.addActionListener(new ActionListener() { //botão para gravar no .bin

			@Override
			public void actionPerformed(ActionEvent arg0) {

				arquivo.escreverArquivo(pacientes);
			}
		});
	}
}