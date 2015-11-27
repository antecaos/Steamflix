package br.aeso.Steamflix.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;
import br.aeso.Steamflix.Produtos.Produtos;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField logradouroField;
	private JTextField numeroField;
	private JFormattedTextField cpfield;
	private JFormattedTextField dataField;
	private JTextField complementoField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField paisField;
	private JFormattedTextField cepField;
	private JTextField loginField;
	private JTextField senhaField;
	private JTextField emailField;
	private JTextField emailSecundarioField;
	private JFormattedTextField telefoneField;
	private JFormattedTextField celularField;
	private JTable tabelaCompras;
	private Cliente cliente;
	private JLabel tituloLabel;
	private TelaLogin telaLogin;
	private JComboBox estadoComboBox;
	private boolean enabled;
	Fachada fachada;
	private JTable tabelaAluguel;
	private DefaultTableModel comprasDefaultTableModel;
	private DefaultTableModel aluguelDefaultTableModel;
	private JTable tabelaJogos;
	private DefaultTableModel jogosDefaultTable;
	private DefaultTableModel filmesDefaultTable;
	private JTable tabelaFilmes;

	public TelaCliente() {
		start();
		fachada = Fachada.getInstance();
	}

	public void start() {
		setTitle("SteamFlix - Cliente");
		String[] estados = { "AC", "AL", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
				"RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPainelGeral = new JScrollPane();
		scrollPainelGeral.setBounds(12, 0, 840, 431);
		contentPane.add(scrollPainelGeral);

		JPanel painelGeral = new JPanel();
		scrollPainelGeral.setViewportView(painelGeral);
		painelGeral.setLayout(null);

		tituloLabel = new JLabel();
		tituloLabel.setBounds(7, 193, 0, 0);
		painelGeral.add(tituloLabel);

		JScrollPane scrollPainelTabs = new JScrollPane();
		scrollPainelTabs.setBounds(12, 5, 820, 377);
		painelGeral.add(scrollPainelTabs);

		JTabbedPane painelTabs = new JTabbedPane(JTabbedPane.TOP);
		scrollPainelTabs.setViewportView(painelTabs);

		JPanel painelDados = new JPanel();
		painelTabs.addTab("Dados", null, painelDados, null);
		painelDados
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(66dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(34dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(36dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("21dlu"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(48dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(26dlu;default)"), },
						new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC,
								FormFactory.DEFAULT_ROWSPEC, }));

		final JToggleButton mudarDados = new JToggleButton("Mudar dados");
		mudarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mudarDados.isSelected()) {
					autorizaMudanca();
				} else {
					proibeMudancas();
				}

			}
		});
		painelDados.add(mudarDados, "14, 2");

		JLabel nomeLabel = new JLabel("Nome");
		painelDados.add(nomeLabel, "2, 4, right, default");

		nomeField = new JTextField();
		nomeField.setEnabled(false);
		painelDados.add(nomeField, "4, 4, 7, 1, fill, default");
		nomeField.setColumns(10);

		JLabel cpfLabel = new JLabel("CPF");
		painelDados.add(cpfLabel, "2, 6, right, default");

		try {
			cpfield = new JFormattedTextField(new MaskFormatter(
					"###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cpfield.setEnabled(false);
		painelDados.add(cpfield, "4, 6, fill, default");
		cpfield.setColumns(10);

		JLabel dataLabel = new JLabel("Data");
		painelDados.add(dataLabel, "6, 6, right, default");

		try {
			dataField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		dataField.setEnabled(false);
		painelDados.add(dataField, "8, 6, left, default");
		dataField.setColumns(10);

		JLabel enderecoLabel = new JLabel("Endereço");
		painelDados.add(enderecoLabel, "2, 8, right, default");

		JLabel logradouroLabel = new JLabel("Logradouro");
		painelDados.add(logradouroLabel, "2, 10, right, default");

		logradouroField = new JTextField();
		logradouroField.setEnabled(false);
		painelDados.add(logradouroField, "4, 10, 7, 1");
		logradouroField.setColumns(10);

		JLabel numeroLabel = new JLabel("Nº");
		painelDados.add(numeroLabel, "12, 10, right, default");

		numeroField = new JTextField();
		numeroField.setEnabled(false);
		painelDados.add(numeroField, "14, 10, left, default");
		numeroField.setColumns(5);

		JLabel complementoLabel = new JLabel("Complemento");
		painelDados.add(complementoLabel, "2, 12, right, default");

		complementoField = new JTextField();
		complementoField.setEnabled(false);
		painelDados.add(complementoField, "4, 12, fill, default");
		complementoField.setColumns(10);

		JLabel bairroLabel = new JLabel("Bairro");
		painelDados.add(bairroLabel, "6, 12, right, default");

		bairroField = new JTextField();
		bairroField.setEnabled(false);
		painelDados.add(bairroField, "8, 12, fill, default");
		bairroField.setColumns(10);

		JLabel cidadeLabel = new JLabel("Cidade");
		painelDados.add(cidadeLabel, "10, 12, right, default");

		cidadeField = new JTextField();
		cidadeField.setEnabled(false);
		painelDados.add(cidadeField, "12, 12, fill, default");
		cidadeField.setColumns(10);

		JLabel estadoLabel = new JLabel("Estado");
		painelDados.add(estadoLabel, "14, 12, right, default");

		estadoComboBox = new JComboBox(estados);
		estadoComboBox.setEnabled(false);
		painelDados.add(estadoComboBox, "16, 12, left, default");

		JLabel paisLabel = new JLabel("País");
		painelDados.add(paisLabel, "2, 14, right, default");

		paisField = new JTextField();
		paisField.setEnabled(false);
		painelDados.add(paisField, "4, 14, fill, default");
		paisField.setColumns(10);

		JLabel cepLabel = new JLabel("CEP");
		painelDados.add(cepLabel, "6, 14, right, default");

		try {
			cepField = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cepField.setEnabled(false);
		painelDados.add(cepField, "8, 14, center, default");
		cepField.setColumns(10);

		JLabel cadastroLabel = new JLabel("Cadastro");
		painelDados.add(cadastroLabel, "2, 16, right, default");

		JLabel loginLabel = new JLabel("Login");
		painelDados.add(loginLabel, "2, 18, right, default");

		loginField = new JTextField();
		loginField.setEnabled(false);
		painelDados.add(loginField, "4, 18, fill, default");
		loginField.setColumns(10);

		JLabel senhaLabel = new JLabel("Senha");
		painelDados.add(senhaLabel, "2, 20, right, default");

		senhaField = new JTextField();
		senhaField.setEnabled(false);
		painelDados.add(senhaField, "4, 20, fill, default");
		senhaField.setColumns(10);

		JLabel emailLabel = new JLabel("Email");
		painelDados.add(emailLabel, "2, 22, right, default");

		emailField = new JTextField();
		emailField.setEnabled(false);
		painelDados.add(emailField, "4, 22, fill, default");
		emailField.setColumns(10);

		JLabel emailSecundarioLabel = new JLabel("Email Sec");
		painelDados.add(emailSecundarioLabel, "6, 22, right, default");

		emailSecundarioField = new JTextField();
		emailSecundarioField.setEnabled(false);
		painelDados.add(emailSecundarioField, "8, 22, fill, default");
		emailSecundarioField.setColumns(10);

		JLabel telefoneLabel = new JLabel("Telefone");
		painelDados.add(telefoneLabel, "2, 24, right, default");

		try {
			telefoneField = new JFormattedTextField(new MaskFormatter(
					"(##)####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		telefoneField.setEnabled(false);
		painelDados.add(telefoneField, "4, 24, fill, default");
		telefoneField.setColumns(10);

		JLabel celularLabel = new JLabel("Celular");
		painelDados.add(celularLabel, "6, 24, right, default");

		try {
			celularField = new JFormattedTextField(new MaskFormatter(
					"(##)#####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		celularField.setEnabled(false);
		painelDados.add(celularField, "8, 24, fill, default");
		celularField.setColumns(10);

		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarCliente();
			}
		});
		painelDados.add(botaoAtualizar, "14, 26");

		JPanel painelCompra = new JPanel();
		painelTabs.addTab("Compras", null, painelCompra, null);
		painelCompra.setLayout(null);

		JScrollPane scrollTabelaCompras = new JScrollPane();
		scrollTabelaCompras.setBounds(12, 12, 788, 321);
		painelCompra.add(scrollTabelaCompras);

		tabelaCompras = new JTable();
		tabelaCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAluguelCompra telaAluguelCompra = new TelaAluguelCompra();
				telaAluguelCompra.setVisible(true);
				telaAluguelCompra.setCompra((int) tabelaCompras.getValueAt(
						tabelaCompras.getSelectedRow(), 0));
				//System.out.println();
			}
		});
		tabelaCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		comprasDefaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Data", "Pre\u00E7o" });
		tabelaCompras.setModel(comprasDefaultTableModel);
		scrollTabelaCompras.setViewportView(tabelaCompras);

		JPanel painelAluguel = new JPanel();
		painelTabs.addTab("Alugueis", null, painelAluguel, null);
		painelAluguel.setLayout(null);

		JScrollPane scrollTabelaAluguel = new JScrollPane();
		scrollTabelaAluguel.setBounds(12, 12, 788, 323);
		painelAluguel.add(scrollTabelaAluguel);

		tabelaAluguel = new JTable();
		tabelaAluguel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAluguelCompra telaAluguelCompra = new TelaAluguelCompra();
				telaAluguelCompra.setVisible(true);
				telaAluguelCompra.setAluguel((int) tabelaAluguel.getValueAt(
						tabelaAluguel.getSelectedRow(), 0));
				//System.out.println();
			}
		});
		aluguelDefaultTableModel = new DefaultTableModel(new Object[][] { {
				null, null, null }, }, new String[] { "Id", "Data de alguel",
				"Data de devolu\u00E7\u00E3o", "Preço" });
		tabelaAluguel.setModel(aluguelDefaultTableModel);
		tabelaAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollTabelaAluguel.setViewportView(tabelaAluguel);

		JPanel painelJogos = new JPanel();
		painelTabs.addTab("Jogos", null, painelJogos, null);
		painelJogos.setLayout(null);

		JScrollPane scrollTabelaJogos = new JScrollPane();
		scrollTabelaJogos.setBounds(12, 12, 788, 323);
		painelJogos.add(scrollTabelaJogos);

		tabelaJogos = new JTable();
		tabelaJogos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaProdutoCliente telaProduto = new TelaProdutoCliente();
				telaProduto.setFilme((Integer) tabelaJogos.getValueAt(
						tabelaJogos.getSelectedRow(), 0));
				telaProduto.setVisible(true);
			}
		});
		jogosDefaultTable = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Fornecedor", "Desenvolvedor",
						"Nota", "Classifica\u00E7\u00E3o", "G\u00EAnero",
						"Devolu\u00E7\u00E3o", "Data de lan\u00E7amento" });
		tabelaJogos.setModel(jogosDefaultTable);
		tabelaJogos.getColumnModel().getColumn(0).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabelaJogos.getColumnModel().getColumn(1).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(1).setPreferredWidth(86);
		tabelaJogos.getColumnModel().getColumn(2).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(2).setPreferredWidth(115);
		tabelaJogos.getColumnModel().getColumn(3).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(3).setPreferredWidth(107);
		tabelaJogos.getColumnModel().getColumn(4).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(4).setPreferredWidth(35);
		tabelaJogos.getColumnModel().getColumn(5).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(5).setPreferredWidth(85);
		tabelaJogos.getColumnModel().getColumn(6).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(6).setPreferredWidth(57);
		tabelaJogos.getColumnModel().getColumn(7).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(7).setPreferredWidth(72);
		tabelaJogos.getColumnModel().getColumn(8).setResizable(false);
		tabelaJogos.getColumnModel().getColumn(8).setPreferredWidth(113);
		scrollTabelaJogos.setViewportView(tabelaJogos);

		JPanel painelFilmes = new JPanel();
		painelTabs.addTab("Filmes", null, painelFilmes, null);
		painelFilmes.setLayout(null);

		JScrollPane scrollPaneFilmes = new JScrollPane();
		scrollPaneFilmes.setBounds(12, 12, 788, 323);
		painelFilmes.add(scrollPaneFilmes);

		tabelaFilmes = new JTable();
		tabelaFilmes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaProdutoCliente telaProduto = new TelaProdutoCliente();
				telaProduto.setFilme((Integer) tabelaFilmes.getValueAt(
						tabelaFilmes.getSelectedRow(), 0));
				telaProduto.setVisible(true);
			}
		});

		filmesDefaultTable = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Fornecedor", "Diretor", "Nota",
						"Classifica\u00E7\u00E3o", "G\u00EAnero",
						"Devolu\u00E7\u00E3o", "Data de lan\u00E7amento" });
		tabelaFilmes.setModel(filmesDefaultTable);
		tabelaFilmes.getColumnModel().getColumn(0).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(0).setPreferredWidth(25);
		tabelaFilmes.getColumnModel().getColumn(1).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(1).setPreferredWidth(86);
		tabelaFilmes.getColumnModel().getColumn(2).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(2).setPreferredWidth(115);
		tabelaFilmes.getColumnModel().getColumn(3).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(3).setPreferredWidth(107);
		tabelaFilmes.getColumnModel().getColumn(4).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(4).setPreferredWidth(35);
		tabelaFilmes.getColumnModel().getColumn(5).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(5).setPreferredWidth(85);
		tabelaFilmes.getColumnModel().getColumn(6).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(6).setPreferredWidth(57);
		tabelaFilmes.getColumnModel().getColumn(7).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(7).setPreferredWidth(72);
		tabelaFilmes.getColumnModel().getColumn(8).setResizable(false);
		tabelaFilmes.getColumnModel().getColumn(8).setPreferredWidth(113);
		scrollPaneFilmes.setViewportView(tabelaFilmes);

		JButton button = new JButton("Loja");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLoja telaLoja = new TelaLoja();
				telaLoja.setVisible(true);
			}
		});
		button.setBounds(677, 394, 64, 25);
		painelGeral.add(button);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				setVisible(false);
			}
		});
		btnSair.setBounds(746, 394, 79, 25);
		painelGeral.add(btnSair);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.tituloLabel.setText("Cliente -" + this.cliente.getNome());
		this.nomeField.setText(cliente.getNome());
		this.cpfield.setText(cliente.getCPF());
		this.dataField.setText(cliente.dataFormatada());
		this.bairroField.setText(cliente.getEndereco().getBairro());
		this.celularField.setText(cliente.getCadastro().getTelefoneCelular());
		this.cepField.setText(cliente.getEndereco().getCEP());
		this.cidadeField.setText(cliente.getEndereco().getCidade());
		this.complementoField.setText(cliente.getEndereco().getComplemento());
		this.emailField.setText(cliente.getCadastro().getEmailPrincipal());
		this.emailSecundarioField.setText(cliente.getCadastro()
				.getEmailSecundario());
		this.loginField.setText(cliente.getCadastro().getLogin());
		this.logradouroField.setText(cliente.getEndereco().getLogradouro());
		this.numeroField.setText(cliente.getEndereco().getNumero());
		this.paisField.setText(cliente.getEndereco().getPais());
		this.senhaField.setText(cliente.getCadastro().getSenha());
		this.telefoneField.setText(cliente.getCadastro().getTelefoneFixo());
		this.estadoComboBox.setSelectedItem(cliente.getEndereco().getEstado());
	}

	public void autorizaMudanca() {
		this.nomeField.setEnabled(true);
		this.cpfield.setEnabled(true);
		this.dataField.setEnabled(true);
		this.bairroField.setEnabled(true);
		this.celularField.setEnabled(true);
		this.cepField.setEnabled(true);
		this.cidadeField.setEnabled(true);
		this.complementoField.setEnabled(true);
		this.emailField.setEnabled(true);
		this.emailSecundarioField.setEnabled(true);
		this.loginField.setEnabled(true);
		this.logradouroField.setEnabled(true);
		this.numeroField.setEnabled(true);
		this.paisField.setEnabled(true);
		this.senhaField.setEnabled(true);
		this.telefoneField.setEnabled(true);
		this.estadoComboBox.setEnabled(true);
		this.enabled = true;
	}

	public void proibeMudancas() {
		this.nomeField.setEnabled(false);
		this.cpfield.setEnabled(false);
		this.dataField.setEnabled(false);
		this.bairroField.setEnabled(false);
		this.celularField.setEnabled(false);
		this.cepField.setEnabled(false);
		this.cidadeField.setEnabled(false);
		this.complementoField.setEnabled(false);
		this.emailField.setEnabled(false);
		this.emailSecundarioField.setEnabled(false);
		this.loginField.setEnabled(false);
		this.logradouroField.setEnabled(false);
		this.numeroField.setEnabled(false);
		this.paisField.setEnabled(false);
		this.senhaField.setEnabled(false);
		this.telefoneField.setEnabled(false);
		this.estadoComboBox.setEnabled(false);
		this.enabled = false;
	}

	public void atualizarCliente() {

		Cliente cliente = new Cliente();
		Cadastro cadastro = new Cadastro();
		Endereco endereco = new Endereco();
		Calendar dataNascimento = Calendar.getInstance();
		String dataEmTexto = this.dataField.getText();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cliente.setCPF(this.cpfield.getText());
		cliente.setNome(this.nomeField.getText());
		cliente.setDataDeNascimento(dataNascimento);

		endereco.setBairro(this.bairroField.getText());
		endereco.setCEP(this.cepField.getText());
		endereco.setCidade(this.cidadeField.getText());
		endereco.setComplemento(this.complementoField.getText());
		endereco.setEstado(this.estadoComboBox.getSelectedItem().toString());
		endereco.setLogradouro(this.logradouroField.getText());
		endereco.setNumero(this.numeroField.getText());
		endereco.setPais(this.paisField.getText());

		cadastro.setEmailPrincipal(this.emailField.getText());
		cadastro.setEmailSecundario(this.emailSecundarioField.getText());
		cadastro.setLogin(this.loginField.getText());
		cadastro.setSenha(new String(this.senhaField.getText()));
		cadastro.setTelefoneCelular(this.celularField.getText());
		cadastro.setTelefoneFixo(this.telefoneField.getText());
		cliente.setCadastro(cadastro);
		cliente.setEndereco(endereco);
		endereco.setCliente(cliente);
		cadastro.setCliente(cliente);

		fachada.atualizarCliente(cliente);
		JOptionPane.showMessageDialog(this, cliente.getNome()
				+ " Usuário atualizado com Sucesso!");
	}

	public void listarCompras(String cpf) {
		comprasDefaultTableModel.setNumRows(0);

		ArrayList<Compra> lista = fachada.listaCompraPorCliente(cpf);
		for (Compra compra : lista) {
			Vector vector = new Vector();
			vector.add(compra.getId());
			vector.add(compra.dataFormatada());
			vector.add(compra.getPrecoFormatado());
			comprasDefaultTableModel.addRow(vector);
		}
	}

	public void listarAluguel(String cpf) {
		aluguelDefaultTableModel.setNumRows(0);

		ArrayList<Aluguel> lista = fachada.listaAluguelPorCliente(cpf);
		for (Aluguel aluguel : lista) {
			Vector vector = new Vector();
			vector.add(aluguel.getId());
			vector.add(aluguel.dataFormatada());
			vector.add(aluguel.dataDevolucaoFormatada());
			vector.add(aluguel.getPrecoFormatado());
			aluguelDefaultTableModel.addRow(vector);
		}
	}

	public void listarJogos(String cpf) {
		jogosDefaultTable.setNumRows(0);

		ArrayList<Compra> listaCompra = fachada.listaCompraPorCliente(cpf);
		ArrayList<Aluguel> listaAluguel = fachada.listaAluguelPorCliente(cpf);

		if (!listaCompra.isEmpty()) {
			for (Compra compra : listaCompra) {

				if (!compra.getJogos().isEmpty()) {
					for (Jogo jogo : compra.getJogos()) {
						Vector vector = new Vector();
						vector.add(jogo.getId());
						vector.add(jogo.getNome());
						vector.add(jogo.getFornecedor().getNomeFantasia());
						vector.add(jogo.getDesenvolvedor());
						vector.add(jogo.getNota());
						vector.add(jogo.getClassificacao());
						vector.add(jogo.getGenero().getNome());
						vector.add("-");
						vector.add(jogo.getDataFormatada());
						jogosDefaultTable.addRow(vector);
					}
				}
			}
		}

		if (!listaAluguel.isEmpty()) {

			for (Aluguel aluguel : listaAluguel) {
				if (!aluguel.getJogo().isEmpty()) {
					for (Jogo jogo : aluguel.getJogo()) {
						Vector vector = new Vector();
						vector.add(jogo.getId());
						vector.add(jogo.getNome());
						vector.add(jogo.getFornecedor().getNomeFantasia());
						vector.add(jogo.getDesenvolvedor());
						vector.add(jogo.getNota());
						vector.add(jogo.getClassificacao());
						vector.add(jogo.getGenero().getNome());
						vector.add(aluguel.dataDevolucaoFormatada());
						vector.add(jogo.getDataFormatada());
						jogosDefaultTable.addRow(vector);
					}
				}
			}
		}
	}

	public void listarFilmes(String cpf) {
		jogosDefaultTable.setNumRows(0);

		ArrayList<Compra> listaCompra = fachada.listaCompraPorCliente(cpf);
		ArrayList<Aluguel> listaAluguel = fachada.listaAluguelPorCliente(cpf);

		if (!listaCompra.isEmpty()) {
			for (Compra compra : listaCompra) {

				if (!compra.getFilmes().isEmpty()) {
					for (Filme filme : compra.getFilmes()) {
						Vector vector = new Vector();
						vector.add(filme.getId());
						vector.add(filme.getNome());
						vector.add(filme.getFornecedor().getNomeFantasia());
						vector.add(filme.getDiretor());
						vector.add(filme.getNota());
						vector.add(filme.getClassificacao());
						vector.add(filme.getGenero().getNome());
						vector.add("-");
						vector.add(filme.getDataFormatada());
						filmesDefaultTable.addRow(vector);
					}
				}
			}
		}

		if (!listaAluguel.isEmpty()) {

			for (Aluguel aluguel : listaAluguel) {
				if (!aluguel.getFilme().isEmpty()) {
					for (Filme filme : aluguel.getFilme()) {
						Vector vector = new Vector();
						vector.add(filme.getId());
						vector.add(filme.getNome());
						vector.add(filme.getFornecedor().getNomeFantasia());
						vector.add(filme.getDiretor());
						vector.add(filme.getNota());
						vector.add(filme.getClassificacao());
						vector.add(filme.getGenero().getNome());
						vector.add(aluguel.dataDevolucaoFormatada());
						vector.add(filme.getDataFormatada());
						filmesDefaultTable.addRow(vector);
					}
				}
			}
		}
	}
}
