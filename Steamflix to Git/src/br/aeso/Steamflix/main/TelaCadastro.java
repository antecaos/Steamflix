package br.aeso.Steamflix.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Util.CPFInvalidoException;
import br.aeso.Steamflix.Util.CampoVazioException;

public class TelaCadastro extends JFrame {

	private Fachada fachada;
	private JPanel contentPane;
	private JFormattedTextField dataNasciementoClienteField;
	private JTextField nomeClienteField;
	private JFormattedTextField cpfClienteField;
	private JTextField ruaClienteField;
	private JTextField numeroClienteField;
	private JTextField complementoClienteField;
	private JTextField bairroClienteField;
	private JTextField cidadeClienteField;
	private JTextField paisClienteField;
	private JFormattedTextField cepClienteField;
	private JTextField loginClienteField;
	private JPasswordField senhaClienteField;
	private JTextField emailClienteField;
	private JTextField emailSecundarioClienteField;
	private JFormattedTextField telefoneClienteField;
	private JFormattedTextField celularClienteField;
	private JTextField nomeFantasiaFornecedorField;
	private JTextField razaoFornecedorField;
	private JTextField ruaFornecedorField;
	private JTextField numeroFornecedorField;
	private JTextField complementoFornecedorField;
	private JTextField bairroFornecedorField;
	private JTextField cidadeFornecedorField;
	private JTextField paisFornecedorField;
	private JTextField loginFornecedorField;
	private JPasswordField senhaFornecedorPasswordField;
	private JTextField emailFornecedorField;
	private JTextField emailSecundarioFornecedorField;
	private JFormattedTextField cnpjFornecedorField;
	private JFormattedTextField cepFornecedorField;
	private JFormattedTextField telefoneFornecedorField;
	private JFormattedTextField celularFornecedorField;
	private JComboBox estadoClienteComboBox;
	private JComboBox estadoFornecedorComboBox;
	private TelaCliente telaCliente;

	public TelaCadastro() {
		start();
	}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblTelaDeCadastro = new JLabel("Tela de Cadastro");
		GridBagConstraints gbc_lblTelaDeCadastro = new GridBagConstraints();
		gbc_lblTelaDeCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_lblTelaDeCadastro.gridx = 0;
		gbc_lblTelaDeCadastro.gridy = 0;
		contentPane.add(lblTelaDeCadastro, gbc_lblTelaDeCadastro);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 154, 73, 0, 0, 0, 0, 82, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		String[] estados = { "AC", "AL", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
				"RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };

		JTabbedPane cadastroPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_cadastroPane = new GridBagConstraints();
		gbc_cadastroPane.insets = new Insets(0, 0, 5, 0);
		gbc_cadastroPane.gridwidth = 0;
		gbc_cadastroPane.fill = GridBagConstraints.BOTH;
		gbc_cadastroPane.gridx = 0;
		gbc_cadastroPane.gridy = 0;
		panel.add(cadastroPane, gbc_cadastroPane);

		JPanel painelCadastroCliente = new JPanel();
		cadastroPane.addTab("Cadastro Cliente", null, painelCadastroCliente,
				null);
		GridBagLayout gbl_painelCadastroCliente = new GridBagLayout();
		gbl_painelCadastroCliente.columnWidths = new int[] { 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_painelCadastroCliente.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_painelCadastroCliente.columnWeights = new double[] { 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_painelCadastroCliente.rowWeights = new double[] { 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		painelCadastroCliente.setLayout(gbl_painelCadastroCliente);

		JLabel nomeClienteLabel = new JLabel("Nome");
		GridBagConstraints gbc_nomeClienteLabel = new GridBagConstraints();
		gbc_nomeClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeClienteLabel.gridx = 0;
		gbc_nomeClienteLabel.gridy = 0;
		painelCadastroCliente.add(nomeClienteLabel, gbc_nomeClienteLabel);

		nomeClienteField = new JTextField();
		GridBagConstraints gbc_nomeClienteField = new GridBagConstraints();
		gbc_nomeClienteField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeClienteField.gridwidth = 7;
		gbc_nomeClienteField.insets = new Insets(0, 0, 5, 0);
		gbc_nomeClienteField.gridx = 1;
		gbc_nomeClienteField.gridy = 0;
		painelCadastroCliente.add(nomeClienteField, gbc_nomeClienteField);
		nomeClienteField.setColumns(10);

		JLabel cpfClienteLabel = new JLabel("CPF");
		GridBagConstraints gbc_cpfClienteLabel = new GridBagConstraints();
		gbc_cpfClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cpfClienteLabel.gridx = 0;
		gbc_cpfClienteLabel.gridy = 1;
		painelCadastroCliente.add(cpfClienteLabel, gbc_cpfClienteLabel);
		try {
			cpfClienteField = new JFormattedTextField(new MaskFormatter(
					"###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_cpfClienteField = new GridBagConstraints();
		gbc_cpfClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_cpfClienteField.gridx = 1;
		gbc_cpfClienteField.gridy = 1;
		painelCadastroCliente.add(cpfClienteField, gbc_cpfClienteField);
		cpfClienteField.setColumns(10);

		JLabel dataNascimentoClienteLabel = new JLabel("Data Nascimento");
		GridBagConstraints gbc_dataNascimentoClienteLabel = new GridBagConstraints();
		gbc_dataNascimentoClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataNascimentoClienteLabel.gridx = 2;
		gbc_dataNascimentoClienteLabel.gridy = 1;
		painelCadastroCliente.add(dataNascimentoClienteLabel,
				gbc_dataNascimentoClienteLabel);
		try {
			dataNasciementoClienteField = new JFormattedTextField(
					new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_dataNasciementoClienteField = new GridBagConstraints();
		gbc_dataNasciementoClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_dataNasciementoClienteField.gridx = 3;
		gbc_dataNasciementoClienteField.gridy = 1;
		painelCadastroCliente.add(dataNasciementoClienteField,
				gbc_dataNasciementoClienteField);
		dataNasciementoClienteField.setColumns(10);

		JLabel cepClienteLabel = new JLabel("CEP");
		GridBagConstraints gbc_cepClienteLabel = new GridBagConstraints();
		gbc_cepClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_cepClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cepClienteLabel.gridx = 4;
		gbc_cepClienteLabel.gridy = 1;
		painelCadastroCliente.add(cepClienteLabel, gbc_cepClienteLabel);
		try {
			cepClienteField = new JFormattedTextField(new MaskFormatter(
					"##.###-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_cepClienteField = new GridBagConstraints();
		gbc_cepClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_cepClienteField.gridx = 5;
		gbc_cepClienteField.gridy = 1;
		painelCadastroCliente.add(cepClienteField, gbc_cepClienteField);
		cepClienteField.setColumns(10);

		JLabel ruaClienteLabel = new JLabel("Rua");
		GridBagConstraints gbc_ruaClienteLabel = new GridBagConstraints();
		gbc_ruaClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ruaClienteLabel.gridx = 0;
		gbc_ruaClienteLabel.gridy = 2;
		painelCadastroCliente.add(ruaClienteLabel, gbc_ruaClienteLabel);

		ruaClienteField = new JTextField();
		GridBagConstraints gbc_ruaClienteField = new GridBagConstraints();
		gbc_ruaClienteField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ruaClienteField.gridwidth = 3;
		gbc_ruaClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_ruaClienteField.gridx = 1;
		gbc_ruaClienteField.gridy = 2;
		painelCadastroCliente.add(ruaClienteField, gbc_ruaClienteField);
		ruaClienteField.setColumns(10);

		JLabel numeroClienteLabel = new JLabel("Nº");
		GridBagConstraints gbc_numeroClienteLabel = new GridBagConstraints();
		gbc_numeroClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroClienteLabel.gridx = 4;
		gbc_numeroClienteLabel.gridy = 2;
		painelCadastroCliente.add(numeroClienteLabel, gbc_numeroClienteLabel);

		numeroClienteField = new JTextField();
		GridBagConstraints gbc_numeroClienteField = new GridBagConstraints();
		gbc_numeroClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_numeroClienteField.gridx = 5;
		gbc_numeroClienteField.gridy = 2;
		painelCadastroCliente.add(numeroClienteField, gbc_numeroClienteField);
		numeroClienteField.setColumns(10);

		JLabel complementoClienteLabel = new JLabel("Complemento");
		GridBagConstraints gbc_complementoClienteLabel = new GridBagConstraints();
		gbc_complementoClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_complementoClienteLabel.gridx = 6;
		gbc_complementoClienteLabel.gridy = 2;
		painelCadastroCliente.add(complementoClienteLabel,
				gbc_complementoClienteLabel);

		complementoClienteField = new JTextField();
		GridBagConstraints gbc_complementoClienteField = new GridBagConstraints();
		gbc_complementoClienteField.insets = new Insets(0, 0, 5, 0);
		gbc_complementoClienteField.gridx = 7;
		gbc_complementoClienteField.gridy = 2;
		painelCadastroCliente.add(complementoClienteField,
				gbc_complementoClienteField);
		complementoClienteField.setColumns(10);

		JLabel bairroClienteLabel = new JLabel("Bairro");
		GridBagConstraints gbc_bairroClienteLabel = new GridBagConstraints();
		gbc_bairroClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bairroClienteLabel.gridx = 0;
		gbc_bairroClienteLabel.gridy = 3;
		painelCadastroCliente.add(bairroClienteLabel, gbc_bairroClienteLabel);

		bairroClienteField = new JTextField();
		GridBagConstraints gbc_bairroClienteField = new GridBagConstraints();
		gbc_bairroClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_bairroClienteField.gridx = 1;
		gbc_bairroClienteField.gridy = 3;
		painelCadastroCliente.add(bairroClienteField, gbc_bairroClienteField);
		bairroClienteField.setColumns(10);

		JLabel estadoClienteLabel = new JLabel("Estado");
		GridBagConstraints gbc_estadoClienteLabel = new GridBagConstraints();
		gbc_estadoClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_estadoClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_estadoClienteLabel.gridx = 2;
		gbc_estadoClienteLabel.gridy = 3;
		painelCadastroCliente.add(estadoClienteLabel, gbc_estadoClienteLabel);
		estadoClienteComboBox = new JComboBox(estados);
		GridBagConstraints gbc_estadoClienteComboBox = new GridBagConstraints();
		gbc_estadoClienteComboBox.anchor = GridBagConstraints.WEST;
		gbc_estadoClienteComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_estadoClienteComboBox.gridx = 3;
		gbc_estadoClienteComboBox.gridy = 3;
		painelCadastroCliente.add(estadoClienteComboBox,
				gbc_estadoClienteComboBox);

		JLabel cidadeClienteLabel = new JLabel("Cidade");
		GridBagConstraints gbc_cidadeClienteLabel = new GridBagConstraints();
		gbc_cidadeClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_cidadeClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeClienteLabel.gridx = 4;
		gbc_cidadeClienteLabel.gridy = 3;
		painelCadastroCliente.add(cidadeClienteLabel, gbc_cidadeClienteLabel);

		cidadeClienteField = new JTextField();
		GridBagConstraints gbc_cidadeClienteField = new GridBagConstraints();
		gbc_cidadeClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeClienteField.gridx = 5;
		gbc_cidadeClienteField.gridy = 3;
		painelCadastroCliente.add(cidadeClienteField, gbc_cidadeClienteField);
		cidadeClienteField.setColumns(10);

		JLabel paisClienteLabel = new JLabel("País");
		GridBagConstraints gbc_paisClienteLabel = new GridBagConstraints();
		gbc_paisClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_paisClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_paisClienteLabel.gridx = 6;
		gbc_paisClienteLabel.gridy = 3;
		painelCadastroCliente.add(paisClienteLabel, gbc_paisClienteLabel);

		paisClienteField = new JTextField();
		GridBagConstraints gbc_paisClienteField = new GridBagConstraints();
		gbc_paisClienteField.insets = new Insets(0, 0, 5, 0);
		gbc_paisClienteField.gridx = 7;
		gbc_paisClienteField.gridy = 3;
		painelCadastroCliente.add(paisClienteField, gbc_paisClienteField);
		paisClienteField.setColumns(10);

		JLabel loginClienteLabel = new JLabel("Login");
		GridBagConstraints gbc_loginClienteLabel = new GridBagConstraints();
		gbc_loginClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginClienteLabel.gridx = 0;
		gbc_loginClienteLabel.gridy = 4;
		painelCadastroCliente.add(loginClienteLabel, gbc_loginClienteLabel);

		loginClienteField = new JTextField();
		GridBagConstraints gbc_loginClienteField = new GridBagConstraints();
		gbc_loginClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_loginClienteField.gridx = 1;
		gbc_loginClienteField.gridy = 4;
		painelCadastroCliente.add(loginClienteField, gbc_loginClienteField);
		loginClienteField.setColumns(10);

		JLabel senhaClienteLabel = new JLabel("Senha");
		GridBagConstraints gbc_senhaClienteLabel = new GridBagConstraints();
		gbc_senhaClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_senhaClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_senhaClienteLabel.gridx = 2;
		gbc_senhaClienteLabel.gridy = 4;
		painelCadastroCliente.add(senhaClienteLabel, gbc_senhaClienteLabel);

		senhaClienteField = new JPasswordField();
		GridBagConstraints gbc_senhaClienteField = new GridBagConstraints();
		gbc_senhaClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_senhaClienteField.gridx = 3;
		gbc_senhaClienteField.gridy = 4;
		painelCadastroCliente.add(senhaClienteField, gbc_senhaClienteField);
		senhaClienteField.setColumns(10);

		JLabel emailClienteLabel = new JLabel("Email");
		GridBagConstraints gbc_emailClienteLabel = new GridBagConstraints();
		gbc_emailClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailClienteLabel.gridx = 0;
		gbc_emailClienteLabel.gridy = 5;
		painelCadastroCliente.add(emailClienteLabel, gbc_emailClienteLabel);

		emailClienteField = new JTextField();
		GridBagConstraints gbc_emailClienteField = new GridBagConstraints();
		gbc_emailClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_emailClienteField.gridx = 1;
		gbc_emailClienteField.gridy = 5;
		painelCadastroCliente.add(emailClienteField, gbc_emailClienteField);
		emailClienteField.setColumns(10);

		JLabel emailSecundarioClienteLabel = new JLabel("Email Secundário");
		GridBagConstraints gbc_emailSecundarioClienteLabel = new GridBagConstraints();
		gbc_emailSecundarioClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailSecundarioClienteLabel.gridx = 2;
		gbc_emailSecundarioClienteLabel.gridy = 5;
		painelCadastroCliente.add(emailSecundarioClienteLabel,
				gbc_emailSecundarioClienteLabel);

		emailSecundarioClienteField = new JTextField();
		GridBagConstraints gbc_emailSecundarioClienteField = new GridBagConstraints();
		gbc_emailSecundarioClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_emailSecundarioClienteField.gridx = 3;
		gbc_emailSecundarioClienteField.gridy = 5;
		painelCadastroCliente.add(emailSecundarioClienteField,
				gbc_emailSecundarioClienteField);
		emailSecundarioClienteField.setColumns(10);

		JLabel telefoneClienteLabel = new JLabel("Telefone");
		GridBagConstraints gbc_telefoneClienteLabel = new GridBagConstraints();
		gbc_telefoneClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telefoneClienteLabel.gridx = 4;
		gbc_telefoneClienteLabel.gridy = 5;
		painelCadastroCliente.add(telefoneClienteLabel,
				gbc_telefoneClienteLabel);
		try {
			telefoneClienteField = new JFormattedTextField(new MaskFormatter(
					"(##)####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_telefoneClienteField = new GridBagConstraints();
		gbc_telefoneClienteField.insets = new Insets(0, 0, 5, 5);
		gbc_telefoneClienteField.gridx = 5;
		gbc_telefoneClienteField.gridy = 5;
		painelCadastroCliente.add(telefoneClienteField,
				gbc_telefoneClienteField);
		telefoneClienteField.setColumns(10);

		JLabel celularClienteLabel = new JLabel("Celular");
		GridBagConstraints gbc_celularClienteLabel = new GridBagConstraints();
		gbc_celularClienteLabel.anchor = GridBagConstraints.EAST;
		gbc_celularClienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_celularClienteLabel.gridx = 6;
		gbc_celularClienteLabel.gridy = 5;
		painelCadastroCliente.add(celularClienteLabel, gbc_celularClienteLabel);
		try {
			celularClienteField = new JFormattedTextField(new MaskFormatter(
					"(##)#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_celularClienteField = new GridBagConstraints();
		gbc_celularClienteField.insets = new Insets(0, 0, 5, 0);
		gbc_celularClienteField.gridx = 7;
		gbc_celularClienteField.gridy = 5;
		painelCadastroCliente.add(celularClienteField, gbc_celularClienteField);
		celularClienteField.setColumns(10);

		JButton cadastrarClienteButton = new JButton("Cadastrar");
		cadastrarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarCliente();
			}
		});
		GridBagConstraints gbc_cadastrarClienteButton = new GridBagConstraints();
		gbc_cadastrarClienteButton.gridx = 7;
		gbc_cadastrarClienteButton.gridy = 6;
		painelCadastroCliente.add(cadastrarClienteButton,
				gbc_cadastrarClienteButton);

		JPanel painelCadastroFornecedor = new JPanel();
		cadastroPane.addTab("Cadastro Fornecedor", null,
				painelCadastroFornecedor, null);
		GridBagLayout gbl_painelCadastroFornecedor = new GridBagLayout();
		gbl_painelCadastroFornecedor.columnWidths = new int[] { 0, 0 };
		gbl_painelCadastroFornecedor.rowHeights = new int[] { 0, 0 };
		gbl_painelCadastroFornecedor.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_painelCadastroFornecedor.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		painelCadastroFornecedor.setLayout(gbl_painelCadastroFornecedor);

		JPanel painelFornecedor = new JPanel();
		GridBagConstraints gbc_painelFornecedor = new GridBagConstraints();
		gbc_painelFornecedor.fill = GridBagConstraints.BOTH;
		gbc_painelFornecedor.gridx = 0;
		gbc_painelFornecedor.gridy = 0;
		painelCadastroFornecedor.add(painelFornecedor, gbc_painelFornecedor);
		GridBagLayout gbl_painelFornecedor = new GridBagLayout();
		gbl_painelFornecedor.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 50,
				0, 0 };
		gbl_painelFornecedor.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_painelFornecedor.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_painelFornecedor.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		painelFornecedor.setLayout(gbl_painelFornecedor);

		JLabel nomeFantasiaFornecedorLabel = new JLabel("Nome");
		GridBagConstraints gbc_nomeFantasiaFornecedorLabel = new GridBagConstraints();
		gbc_nomeFantasiaFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFantasiaFornecedorLabel.gridx = 0;
		gbc_nomeFantasiaFornecedorLabel.gridy = 0;
		painelFornecedor.add(nomeFantasiaFornecedorLabel,
				gbc_nomeFantasiaFornecedorLabel);

		nomeFantasiaFornecedorField = new JTextField();
		nomeFantasiaFornecedorField.setColumns(10);
		GridBagConstraints gbc_nomeFantasiaFornecedorField = new GridBagConstraints();
		gbc_nomeFantasiaFornecedorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeFantasiaFornecedorField.gridwidth = 2;
		gbc_nomeFantasiaFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFantasiaFornecedorField.gridx = 1;
		gbc_nomeFantasiaFornecedorField.gridy = 0;
		painelFornecedor.add(nomeFantasiaFornecedorField,
				gbc_nomeFantasiaFornecedorField);

		JLabel razaoFornecedorLabel = new JLabel("Razão \nSocial");
		GridBagConstraints gbc_razaoFornecedorLabel = new GridBagConstraints();
		gbc_razaoFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_razaoFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_razaoFornecedorLabel.gridx = 3;
		gbc_razaoFornecedorLabel.gridy = 0;
		painelFornecedor.add(razaoFornecedorLabel, gbc_razaoFornecedorLabel);

		razaoFornecedorField = new JTextField();
		razaoFornecedorField.setColumns(10);
		GridBagConstraints gbc_razaoFornecedorField = new GridBagConstraints();
		gbc_razaoFornecedorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_razaoFornecedorField.gridwidth = 2;
		gbc_razaoFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_razaoFornecedorField.gridx = 4;
		gbc_razaoFornecedorField.gridy = 0;
		painelFornecedor.add(razaoFornecedorField, gbc_razaoFornecedorField);

		JLabel cnpjFornecedorLabel = new JLabel("CNPJ");
		GridBagConstraints gbc_cnpjFornecedorLabel = new GridBagConstraints();
		gbc_cnpjFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_cnpjFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cnpjFornecedorLabel.gridx = 0;
		gbc_cnpjFornecedorLabel.gridy = 1;
		painelFornecedor.add(cnpjFornecedorLabel, gbc_cnpjFornecedorLabel);

		JFormattedTextField formattedTextField = null;
		try {
			cnpjFornecedorField = new JFormattedTextField(new MaskFormatter(
					"##.###.###/####-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnpjFornecedorField.setColumns(10);
		GridBagConstraints gbc_cnpjFornecedorField = new GridBagConstraints();
		gbc_cnpjFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_cnpjFornecedorField.gridx = 1;
		gbc_cnpjFornecedorField.gridy = 1;
		painelFornecedor.add(cnpjFornecedorField, gbc_cnpjFornecedorField);

		JLabel cepFornecedorLabel = new JLabel("CEP");
		GridBagConstraints gbc_cepFornecedorLabel = new GridBagConstraints();
		gbc_cepFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_cepFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cepFornecedorLabel.gridx = 2;
		gbc_cepFornecedorLabel.gridy = 1;
		painelFornecedor.add(cepFornecedorLabel, gbc_cepFornecedorLabel);

		JFormattedTextField formattedTextField_1 = null;
		try {
			cepFornecedorField = new JFormattedTextField(new MaskFormatter(
					"##.###-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cepFornecedorField.setColumns(10);
		GridBagConstraints gbc_cepFornecedorField = new GridBagConstraints();
		gbc_cepFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_cepFornecedorField.gridx = 3;
		gbc_cepFornecedorField.gridy = 1;
		painelFornecedor.add(cepFornecedorField, gbc_cepFornecedorField);

		JLabel ruaFornecedorLabel = new JLabel("Rua");
		GridBagConstraints gbc_ruaFornecedorLabel = new GridBagConstraints();
		gbc_ruaFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_ruaFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ruaFornecedorLabel.gridx = 0;
		gbc_ruaFornecedorLabel.gridy = 2;
		painelFornecedor.add(ruaFornecedorLabel, gbc_ruaFornecedorLabel);

		ruaFornecedorField = new JTextField();
		ruaFornecedorField.setColumns(10);
		GridBagConstraints gbc_ruaFornecedorField = new GridBagConstraints();
		gbc_ruaFornecedorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ruaFornecedorField.gridwidth = 3;
		gbc_ruaFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_ruaFornecedorField.gridx = 1;
		gbc_ruaFornecedorField.gridy = 2;
		painelFornecedor.add(ruaFornecedorField, gbc_ruaFornecedorField);

		JLabel numeroFornecedorLabel = new JLabel("Nº");
		GridBagConstraints gbc_numeroFornecedorLabel = new GridBagConstraints();
		gbc_numeroFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroFornecedorLabel.gridx = 4;
		gbc_numeroFornecedorLabel.gridy = 2;
		painelFornecedor.add(numeroFornecedorLabel, gbc_numeroFornecedorLabel);

		numeroFornecedorField = new JTextField();
		numeroFornecedorField.setColumns(5);
		GridBagConstraints gbc_numeroFornecedorField = new GridBagConstraints();
		gbc_numeroFornecedorField.anchor = GridBagConstraints.WEST;
		gbc_numeroFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_numeroFornecedorField.gridx = 5;
		gbc_numeroFornecedorField.gridy = 2;
		painelFornecedor.add(numeroFornecedorField, gbc_numeroFornecedorField);

		JLabel complementoFornecedorLabel = new JLabel("Complemento");
		GridBagConstraints gbc_complementoFornecedorLabel = new GridBagConstraints();
		gbc_complementoFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_complementoFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_complementoFornecedorLabel.gridx = 6;
		gbc_complementoFornecedorLabel.gridy = 2;
		painelFornecedor.add(complementoFornecedorLabel,
				gbc_complementoFornecedorLabel);

		complementoFornecedorField = new JTextField();
		complementoFornecedorField.setColumns(10);
		GridBagConstraints gbc_complementoFornecedorField = new GridBagConstraints();
		gbc_complementoFornecedorField.insets = new Insets(0, 0, 5, 0);
		gbc_complementoFornecedorField.gridx = 7;
		gbc_complementoFornecedorField.gridy = 2;
		painelFornecedor.add(complementoFornecedorField,
				gbc_complementoFornecedorField);

		JLabel bairroFornecedorLabel = new JLabel("Bairro");
		GridBagConstraints gbc_bairroFornecedorLabel = new GridBagConstraints();
		gbc_bairroFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_bairroFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bairroFornecedorLabel.gridx = 0;
		gbc_bairroFornecedorLabel.gridy = 3;
		painelFornecedor.add(bairroFornecedorLabel, gbc_bairroFornecedorLabel);

		bairroFornecedorField = new JTextField();
		bairroFornecedorField.setColumns(10);
		GridBagConstraints gbc_bairroFornecedorField = new GridBagConstraints();
		gbc_bairroFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_bairroFornecedorField.gridx = 1;
		gbc_bairroFornecedorField.gridy = 3;
		painelFornecedor.add(bairroFornecedorField, gbc_bairroFornecedorField);

		JLabel estadoFornecedorLabel = new JLabel("Estado");
		GridBagConstraints gbc_estadoFornecedorLabel = new GridBagConstraints();
		gbc_estadoFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_estadoFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_estadoFornecedorLabel.gridx = 2;
		gbc_estadoFornecedorLabel.gridy = 3;
		painelFornecedor.add(estadoFornecedorLabel, gbc_estadoFornecedorLabel);

		estadoFornecedorComboBox = new JComboBox(estados);
		GridBagConstraints gbc_estadoFornecedorComboBox = new GridBagConstraints();
		gbc_estadoFornecedorComboBox.anchor = GridBagConstraints.WEST;
		gbc_estadoFornecedorComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_estadoFornecedorComboBox.gridx = 3;
		gbc_estadoFornecedorComboBox.gridy = 3;
		painelFornecedor.add(estadoFornecedorComboBox,
				gbc_estadoFornecedorComboBox);

		JLabel cidadeFornecedorLabel = new JLabel("Cidade");
		GridBagConstraints gbc_cidadeFornecedorLabel = new GridBagConstraints();
		gbc_cidadeFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_cidadeFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeFornecedorLabel.gridx = 4;
		gbc_cidadeFornecedorLabel.gridy = 3;
		painelFornecedor.add(cidadeFornecedorLabel, gbc_cidadeFornecedorLabel);

		cidadeFornecedorField = new JTextField();
		cidadeFornecedorField.setColumns(10);
		GridBagConstraints gbc_cidadeFornecedorField = new GridBagConstraints();
		gbc_cidadeFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeFornecedorField.gridx = 5;
		gbc_cidadeFornecedorField.gridy = 3;
		painelFornecedor.add(cidadeFornecedorField, gbc_cidadeFornecedorField);

		JLabel paisFornecedorLabel = new JLabel("País");
		GridBagConstraints gbc_paisFornecedorLabel = new GridBagConstraints();
		gbc_paisFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_paisFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_paisFornecedorLabel.gridx = 6;
		gbc_paisFornecedorLabel.gridy = 3;
		painelFornecedor.add(paisFornecedorLabel, gbc_paisFornecedorLabel);

		paisFornecedorField = new JTextField();
		paisFornecedorField.setColumns(10);
		GridBagConstraints gbc_paisFornecedorField = new GridBagConstraints();
		gbc_paisFornecedorField.insets = new Insets(0, 0, 5, 0);
		gbc_paisFornecedorField.gridx = 7;
		gbc_paisFornecedorField.gridy = 3;
		painelFornecedor.add(paisFornecedorField, gbc_paisFornecedorField);

		JLabel loginFornecedorLabel = new JLabel("Login");
		GridBagConstraints gbc_loginFornecedorLabel = new GridBagConstraints();
		gbc_loginFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_loginFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginFornecedorLabel.gridx = 0;
		gbc_loginFornecedorLabel.gridy = 4;
		painelFornecedor.add(loginFornecedorLabel, gbc_loginFornecedorLabel);

		loginFornecedorField = new JTextField();
		loginFornecedorField.setColumns(10);
		GridBagConstraints gbc_loginFornecedorField = new GridBagConstraints();
		gbc_loginFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_loginFornecedorField.gridx = 1;
		gbc_loginFornecedorField.gridy = 4;
		painelFornecedor.add(loginFornecedorField, gbc_loginFornecedorField);

		JLabel senhaFornecedorLabel = new JLabel("Senha");
		GridBagConstraints gbc_senhaFornecedorLabel = new GridBagConstraints();
		gbc_senhaFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_senhaFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_senhaFornecedorLabel.gridx = 2;
		gbc_senhaFornecedorLabel.gridy = 4;
		painelFornecedor.add(senhaFornecedorLabel, gbc_senhaFornecedorLabel);

		senhaFornecedorPasswordField = new JPasswordField();
		senhaFornecedorPasswordField.setColumns(10);
		GridBagConstraints gbc_senhaFornecedorPasswordField = new GridBagConstraints();
		gbc_senhaFornecedorPasswordField.insets = new Insets(0, 0, 5, 5);
		gbc_senhaFornecedorPasswordField.gridx = 3;
		gbc_senhaFornecedorPasswordField.gridy = 4;
		painelFornecedor.add(senhaFornecedorPasswordField,
				gbc_senhaFornecedorPasswordField);

		JLabel emailFornecedorLabel = new JLabel("Email");
		GridBagConstraints gbc_emailFornecedorLabel = new GridBagConstraints();
		gbc_emailFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_emailFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailFornecedorLabel.gridx = 0;
		gbc_emailFornecedorLabel.gridy = 5;
		painelFornecedor.add(emailFornecedorLabel, gbc_emailFornecedorLabel);

		emailFornecedorField = new JTextField();
		emailFornecedorField.setColumns(10);
		GridBagConstraints gbc_emailFornecedorField = new GridBagConstraints();
		gbc_emailFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_emailFornecedorField.gridx = 1;
		gbc_emailFornecedorField.gridy = 5;
		painelFornecedor.add(emailFornecedorField, gbc_emailFornecedorField);

		JLabel emailSecundarioFornecedorLabel = new JLabel("Email Secundário");
		GridBagConstraints gbc_emailSecundarioFornecedorLabel = new GridBagConstraints();
		gbc_emailSecundarioFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailSecundarioFornecedorLabel.gridx = 2;
		gbc_emailSecundarioFornecedorLabel.gridy = 5;
		painelFornecedor.add(emailSecundarioFornecedorLabel,
				gbc_emailSecundarioFornecedorLabel);

		emailSecundarioFornecedorField = new JTextField();
		emailSecundarioFornecedorField.setColumns(10);
		GridBagConstraints gbc_emailSecundarioFornecedorField = new GridBagConstraints();
		gbc_emailSecundarioFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_emailSecundarioFornecedorField.gridx = 3;
		gbc_emailSecundarioFornecedorField.gridy = 5;
		painelFornecedor.add(emailSecundarioFornecedorField,
				gbc_emailSecundarioFornecedorField);

		JLabel telefoneFornecedorLabel = new JLabel("Telefone");
		GridBagConstraints gbc_telefoneFornecedorLabel = new GridBagConstraints();
		gbc_telefoneFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_telefoneFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telefoneFornecedorLabel.gridx = 4;
		gbc_telefoneFornecedorLabel.gridy = 5;
		painelFornecedor.add(telefoneFornecedorLabel,
				gbc_telefoneFornecedorLabel);

		JFormattedTextField formattedTextField_5 = null;
		try {
			telefoneFornecedorField = new JFormattedTextField(
					new MaskFormatter("(##)####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telefoneFornecedorField.setColumns(10);
		GridBagConstraints gbc_telefoneFornecedorField = new GridBagConstraints();
		gbc_telefoneFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_telefoneFornecedorField.gridx = 5;
		gbc_telefoneFornecedorField.gridy = 5;
		painelFornecedor.add(telefoneFornecedorField,
				gbc_telefoneFornecedorField);

		JLabel celularFornecedorLabel = new JLabel("Celular");
		GridBagConstraints gbc_celularFornecedorLabel = new GridBagConstraints();
		gbc_celularFornecedorLabel.anchor = GridBagConstraints.EAST;
		gbc_celularFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_celularFornecedorLabel.gridx = 6;
		gbc_celularFornecedorLabel.gridy = 5;
		painelFornecedor
				.add(celularFornecedorLabel, gbc_celularFornecedorLabel);

		JFormattedTextField formattedTextField_6 = null;
		try {
			celularFornecedorField = new JFormattedTextField(new MaskFormatter(
					"(##)#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		celularFornecedorField.setColumns(10);
		GridBagConstraints gbc_celularFornecedorField = new GridBagConstraints();
		gbc_celularFornecedorField.insets = new Insets(0, 0, 5, 0);
		gbc_celularFornecedorField.gridx = 7;
		gbc_celularFornecedorField.gridy = 5;
		painelFornecedor
				.add(celularFornecedorField, gbc_celularFornecedorField);

		JButton cadastrarFornecedorButton = new JButton("Cadastrar");
		cadastrarFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFornecedor();
			}
		});
		GridBagConstraints gbc_cadastrarFornecedorButton = new GridBagConstraints();
		gbc_cadastrarFornecedorButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cadastrarFornecedorButton.gridx = 7;
		gbc_cadastrarFornecedorButton.gridy = 6;
		painelFornecedor.add(cadastrarFornecedorButton,
				gbc_cadastrarFornecedorButton);
	}

	public void cadastrarCliente() {
		fachada = Fachada.getInstance();
		Cliente cliente = new Cliente();
		Cadastro cadastro = new Cadastro();
		Endereco endereco = new Endereco();
		Calendar dataNascimento = Calendar.getInstance();
		String dataEmTexto = this.dataNasciementoClienteField.getText();
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cliente.setCPF(this.cpfClienteField.getText());
		cliente.setNome(this.nomeClienteField.getText());
		cliente.setDataDeNascimento(dataNascimento);

		endereco.setBairro(this.bairroClienteField.getText());
		endereco.setCEP(this.cepClienteField.getText());
		endereco.setCidade(this.cidadeClienteField.getText());
		endereco.setComplemento(this.complementoClienteField.getText());
		endereco.setEstado(this.estadoClienteComboBox.getSelectedItem()
				.toString());
		endereco.setLogradouro(this.ruaClienteField.getText());
		endereco.setNumero(this.numeroClienteField.getText());
		endereco.setPais(this.paisClienteField.getText());

		cadastro.setEmailPrincipal(this.emailClienteField.getText());
		cadastro.setEmailSecundario(this.emailSecundarioClienteField.getText());
		cadastro.setLogin(this.loginClienteField.getText());
		cadastro.setSenha(new String(this.senhaClienteField.getPassword()));
		cadastro.setTelefoneCelular(this.celularClienteField.getText());
		cadastro.setTelefoneFixo(this.telefoneClienteField.getText());
		cliente.setCadastro(cadastro);
		cliente.setEndereco(endereco);
		endereco.setCliente(cliente);
		cadastro.setCliente(cliente);

		try {
			fachada.cadastrarCliente(cliente);
			JOptionPane.showMessageDialog(this, cliente.getNome()
					+ "Usuário cadastrado com Sucesso!");
			entrarCliente(cliente);
		} catch (CampoVazioException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Mensagem erro!", EXIT_ON_CLOSE);
		} catch (CPFInvalidoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Mensagem erro!", EXIT_ON_CLOSE);;
		}

		// TelaCliente tela = new TelaCliente();
		// tela.setVisible(true);

	}

	public void cadastrarFornecedor() {
		fachada = Fachada.getInstance();
		Fornecedor fornecedor = new Fornecedor();
		Cadastro cadastro = new Cadastro();
		Endereco endereco = new Endereco();

		fornecedor.setNomeFantasia(this.nomeFantasiaFornecedorField.getText());
		fornecedor.setRazaoSocial(this.razaoFornecedorField.getText());
		fornecedor.setCNPJ(this.cnpjFornecedorField.getText());

		endereco.setBairro(this.bairroFornecedorField.getText());
		endereco.setCEP(this.cepFornecedorField.getText());
		endereco.setCidade(this.cidadeFornecedorField.getText());
		endereco.setComplemento(this.complementoFornecedorField.getText());
		endereco.setEstado(this.estadoFornecedorComboBox.getSelectedItem()
				.toString());
		endereco.setLogradouro(this.ruaFornecedorField.getText());
		endereco.setNumero(this.numeroFornecedorField.getText());
		endereco.setPais(this.paisFornecedorField.getText());

		cadastro.setEmailPrincipal(this.emailFornecedorField.getText());
		cadastro.setEmailSecundario(this.emailSecundarioFornecedorField
				.getText());
		cadastro.setLogin(this.loginFornecedorField.getText());
		cadastro.setSenha(new String(this.senhaFornecedorPasswordField
				.getPassword()));
		cadastro.setTelefoneCelular(this.celularFornecedorField.getText());
		cadastro.setTelefoneFixo(this.telefoneFornecedorField.getText());
		fornecedor.setCadastro(cadastro);
		fornecedor.setEndereco(endereco);
		endereco.setFornecedor(fornecedor);
		cadastro.setFornecedor(fornecedor);

		// JOptionPane.showMessageDialog(this, fornecedor);

		try {
			fachada.cadastrarFornecedor(fornecedor);
			JOptionPane.showMessageDialog(this, fornecedor.getNomeFantasia()
					+ "Usuário cadastrado com Sucesso!");
			entrarFornecedor(fornecedor);
		} catch (br.aeso.Steamflix.Util.CampoVazioException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Mensagem erro!", EXIT_ON_CLOSE);
		}
	}

	public void entrarCliente(Cliente cliente) {
		telaCliente = new TelaCliente();
		telaCliente.setCliente(cliente);
		telaCliente.setVisible(true);
		telaCliente.setTitle("SteamFlix - Cliente");
	}

	public void entrarFornecedor(Fornecedor fornecedor) {
		// Terminar de implementar
	}
}
