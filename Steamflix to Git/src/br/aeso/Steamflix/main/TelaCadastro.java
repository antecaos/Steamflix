package br.aeso.Steamflix.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollBar;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;


public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField dataNasciementoField;
	private JTextField nomeField;
	private JFormattedTextField cpfField;
	private JTextField ruaField;
	private JTextField numeroField;
	private JTextField complementoField;
	private JTextField bairroField;
	private JTextField cidadeField;
	private JTextField paisField;
	private JFormattedTextField cepField;
	private JTextField loginField;
	private JPasswordField senhaField;
	private JTextField emailField;
	private JTextField emailSecField;
	private JFormattedTextField telfoneField;
	private JFormattedTextField celularField;
	private JTextField nomeFantasiaFornecedorField;
	private JTextField razaoFornecedorField;
	private JTextField ruaFornecedorField;
	private JTextField numeroFornecedorField;
	private JTextField complementoFornecedorField;
	private JTextField bairroFornecedorField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField passwordField;
	private JTextField textField_9;
	private JTextField textField_10;
	private JFormattedTextField cnpjFornecedorField;
	private JFormattedTextField cepFornecedorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		cadastroPane
				.addTab("Cadastro Cliente", null, painelCadastroCliente, null);
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

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		painelCadastroCliente.add(lblNome, gbc_lblNome);

		nomeField = new JTextField();
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeField.gridwidth = 7;
		gbc_nomeField.insets = new Insets(0, 0, 5, 0);
		gbc_nomeField.gridx = 1;
		gbc_nomeField.gridy = 0;
		painelCadastroCliente.add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CPF*");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		painelCadastroCliente.add(lblNewLabel_2, gbc_lblNewLabel_2);
		try {
			cpfField = new JFormattedTextField(new MaskFormatter(
					"###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_cpfField = new GridBagConstraints();
		gbc_cpfField.insets = new Insets(0, 0, 5, 5);
		gbc_cpfField.gridx = 1;
		gbc_cpfField.gridy = 1;
		painelCadastroCliente.add(cpfField, gbc_cpfField);
		cpfField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data Nascimento");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		painelCadastroCliente.add(lblNewLabel_1, gbc_lblNewLabel_1);
		try {
			dataNasciementoField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_dataNasciementoField = new GridBagConstraints();
		gbc_dataNasciementoField.insets = new Insets(0, 0, 5, 5);
		gbc_dataNasciementoField.gridx = 3;
		gbc_dataNasciementoField.gridy = 1;
		painelCadastroCliente.add(dataNasciementoField,
				gbc_dataNasciementoField);
		dataNasciementoField.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCep.gridx = 4;
		gbc_lblCep.gridy = 1;
		painelCadastroCliente.add(lblCep, gbc_lblCep);
		try {
			cepField = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_cepField = new GridBagConstraints();
		gbc_cepField.insets = new Insets(0, 0, 5, 5);
		gbc_cepField.gridx = 5;
		gbc_cepField.gridy = 1;
		painelCadastroCliente.add(cepField, gbc_cepField);
		cepField.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		GridBagConstraints gbc_lblRua = new GridBagConstraints();
		gbc_lblRua.insets = new Insets(0, 0, 5, 5);
		gbc_lblRua.gridx = 0;
		gbc_lblRua.gridy = 2;
		painelCadastroCliente.add(lblRua, gbc_lblRua);

		ruaField = new JTextField();
		GridBagConstraints gbc_ruaField = new GridBagConstraints();
		gbc_ruaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ruaField.gridwidth = 3;
		gbc_ruaField.insets = new Insets(0, 0, 5, 5);
		gbc_ruaField.gridx = 1;
		gbc_ruaField.gridy = 2;
		painelCadastroCliente.add(ruaField, gbc_ruaField);
		ruaField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nº");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 2;
		painelCadastroCliente.add(lblNewLabel_3, gbc_lblNewLabel_3);

		numeroField = new JTextField();
		GridBagConstraints gbc_numeroField = new GridBagConstraints();
		gbc_numeroField.insets = new Insets(0, 0, 5, 5);
		gbc_numeroField.gridx = 5;
		gbc_numeroField.gridy = 2;
		painelCadastroCliente.add(numeroField, gbc_numeroField);
		numeroField.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		GridBagConstraints gbc_lblComplemento = new GridBagConstraints();
		gbc_lblComplemento.insets = new Insets(0, 0, 5, 5);
		gbc_lblComplemento.gridx = 6;
		gbc_lblComplemento.gridy = 2;
		painelCadastroCliente.add(lblComplemento, gbc_lblComplemento);

		complementoField = new JTextField();
		GridBagConstraints gbc_complementoField = new GridBagConstraints();
		gbc_complementoField.insets = new Insets(0, 0, 5, 0);
		gbc_complementoField.gridx = 7;
		gbc_complementoField.gridy = 2;
		painelCadastroCliente.add(complementoField, gbc_complementoField);
		complementoField.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 0;
		gbc_lblBairro.gridy = 3;
		painelCadastroCliente.add(lblBairro, gbc_lblBairro);

		bairroField = new JTextField();
		GridBagConstraints gbc_bairroField = new GridBagConstraints();
		gbc_bairroField.insets = new Insets(0, 0, 5, 5);
		gbc_bairroField.gridx = 1;
		gbc_bairroField.gridy = 3;
		painelCadastroCliente.add(bairroField, gbc_bairroField);
		bairroField.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 3;
		painelCadastroCliente.add(lblEstado, gbc_lblEstado);
		JComboBox estadoComboBox = new JComboBox(estados);
		GridBagConstraints gbc_estadoComboBox = new GridBagConstraints();
		gbc_estadoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_estadoComboBox.gridx = 3;
		gbc_estadoComboBox.gridy = 3;
		painelCadastroCliente.add(estadoComboBox, gbc_estadoComboBox);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 4;
		gbc_lblCidade.gridy = 3;
		painelCadastroCliente.add(lblCidade, gbc_lblCidade);

		cidadeField = new JTextField();
		GridBagConstraints gbc_cidadeField = new GridBagConstraints();
		gbc_cidadeField.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeField.gridx = 5;
		gbc_cidadeField.gridy = 3;
		painelCadastroCliente.add(cidadeField, gbc_cidadeField);
		cidadeField.setColumns(10);

		JLabel lblPais = new JLabel("País");
		GridBagConstraints gbc_lblPais = new GridBagConstraints();
		gbc_lblPais.insets = new Insets(0, 0, 5, 5);
		gbc_lblPais.gridx = 6;
		gbc_lblPais.gridy = 3;
		painelCadastroCliente.add(lblPais, gbc_lblPais);

		paisField = new JTextField();
		GridBagConstraints gbc_paisField = new GridBagConstraints();
		gbc_paisField.insets = new Insets(0, 0, 5, 0);
		gbc_paisField.gridx = 7;
		gbc_paisField.gridy = 3;
		painelCadastroCliente.add(paisField, gbc_paisField);
		paisField.setColumns(10);

		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 4;
		painelCadastroCliente.add(lblLogin, gbc_lblLogin);

		loginField = new JTextField();
		GridBagConstraints gbc_loginField = new GridBagConstraints();
		gbc_loginField.insets = new Insets(0, 0, 5, 5);
		gbc_loginField.gridx = 1;
		gbc_loginField.gridy = 4;
		painelCadastroCliente.add(loginField, gbc_loginField);
		loginField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 2;
		gbc_lblSenha.gridy = 4;
		painelCadastroCliente.add(lblSenha, gbc_lblSenha);

		senhaField = new JPasswordField();
		GridBagConstraints gbc_senhaField = new GridBagConstraints();
		gbc_senhaField.insets = new Insets(0, 0, 5, 5);
		gbc_senhaField.gridx = 3;
		gbc_senhaField.gridy = 4;
		painelCadastroCliente.add(senhaField, gbc_senhaField);
		senhaField.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		painelCadastroCliente.add(lblEmail, gbc_lblEmail);

		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 5;
		painelCadastroCliente.add(emailField, gbc_emailField);
		emailField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email Secundário");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 5;
		painelCadastroCliente.add(lblNewLabel_4, gbc_lblNewLabel_4);

		emailSecField = new JTextField();
		GridBagConstraints gbc_emailSecField = new GridBagConstraints();
		gbc_emailSecField.insets = new Insets(0, 0, 5, 5);
		gbc_emailSecField.gridx = 3;
		gbc_emailSecField.gridy = 5;
		painelCadastroCliente.add(emailSecField, gbc_emailSecField);
		emailSecField.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 4;
		gbc_lblTelefone.gridy = 5;
		painelCadastroCliente.add(lblTelefone, gbc_lblTelefone);
		try {
			telfoneField = new JFormattedTextField(new MaskFormatter(
					"(##)####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_telfoneField = new GridBagConstraints();
		gbc_telfoneField.insets = new Insets(0, 0, 5, 5);
		gbc_telfoneField.gridx = 5;
		gbc_telfoneField.gridy = 5;
		painelCadastroCliente.add(telfoneField, gbc_telfoneField);
		telfoneField.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 6;
		gbc_lblCelular.gridy = 5;
		painelCadastroCliente.add(lblCelular, gbc_lblCelular);
		try {
			celularField = new JFormattedTextField(new MaskFormatter(
					"(##)#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_celularField = new GridBagConstraints();
		gbc_celularField.insets = new Insets(0, 0, 5, 0);
		gbc_celularField.gridx = 7;
		gbc_celularField.gridy = 5;
		painelCadastroCliente.add(celularField, gbc_celularField);
		celularField.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridx = 7;
		gbc_btnCadastrar.gridy = 6;
		painelCadastroCliente.add(btnCadastrar, gbc_btnCadastrar);

		JPanel painelCadastroFornecedor = new JPanel();
		cadastroPane
				.addTab("Cadastro Fornecedor", null, painelCadastroFornecedor, null);
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
		gbl_painelFornecedor.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 50, 0, 0 };
		gbl_painelFornecedor.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_painelFornecedor.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_painelFornecedor.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		painelFornecedor.setLayout(gbl_painelFornecedor);

		JLabel nomeFantasiaFornecedorLabel = new JLabel("Nome");
		GridBagConstraints gbc_nomeFantasiaFornecedorLabel = new GridBagConstraints();
		gbc_nomeFantasiaFornecedorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFantasiaFornecedorLabel.gridx = 0;
		gbc_nomeFantasiaFornecedorLabel.gridy = 0;
		painelFornecedor.add(nomeFantasiaFornecedorLabel, gbc_nomeFantasiaFornecedorLabel);

		nomeFantasiaFornecedorField = new JTextField();
		nomeFantasiaFornecedorField.setColumns(10);
		GridBagConstraints gbc_nomeFantasiaFornecedorField = new GridBagConstraints();
		gbc_nomeFantasiaFornecedorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeFantasiaFornecedorField.gridwidth = 2;
		gbc_nomeFantasiaFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFantasiaFornecedorField.gridx = 1;
		gbc_nomeFantasiaFornecedorField.gridy = 0;
		painelFornecedor.add(nomeFantasiaFornecedorField, gbc_nomeFantasiaFornecedorField);

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
			cnpjFornecedorField = new JFormattedTextField(
					new MaskFormatter("(##)#####-####"));
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
			cepFornecedorField = new JFormattedTextField(
					new MaskFormatter("(##)#####-####"));
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
		painelFornecedor.add(complementoFornecedorLabel, gbc_complementoFornecedorLabel);

		complementoFornecedorField = new JTextField();
		complementoFornecedorField.setColumns(10);
		GridBagConstraints gbc_complementoFornecedorField = new GridBagConstraints();
		gbc_complementoFornecedorField.insets = new Insets(0, 0, 5, 0);
		gbc_complementoFornecedorField.gridx = 7;
		gbc_complementoFornecedorField.gridy = 2;
		painelFornecedor.add(complementoFornecedorField, gbc_complementoFornecedorField);

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

		JComboBox estadoFornecedorComboBox = new JComboBox(estados);
		GridBagConstraints gbc_estadoFornecedorComboBox = new GridBagConstraints();
		gbc_estadoFornecedorComboBox.anchor = GridBagConstraints.WEST;
		gbc_estadoFornecedorComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_estadoFornecedorComboBox.gridx = 3;
		gbc_estadoFornecedorComboBox.gridy = 3;
		painelFornecedor.add(estadoFornecedorComboBox, gbc_estadoFornecedorComboBox);

		JLabel label_9 = new JLabel("Cidade");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 4;
		gbc_label_9.gridy = 3;
		painelFornecedor.add(label_9, gbc_label_9);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 3;
		painelFornecedor.add(textField_6, gbc_textField_6);

		JLabel label_10 = new JLabel("País");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 6;
		gbc_label_10.gridy = 3;
		painelFornecedor.add(label_10, gbc_label_10);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.gridx = 7;
		gbc_textField_7.gridy = 3;
		painelFornecedor.add(textField_7, gbc_textField_7);

		JLabel label_11 = new JLabel("Login");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 4;
		painelFornecedor.add(label_11, gbc_label_11);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 4;
		painelFornecedor.add(textField_8, gbc_textField_8);

		JLabel label_12 = new JLabel("Senha");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 2;
		gbc_label_12.gridy = 4;
		painelFornecedor.add(label_12, gbc_label_12);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 4;
		painelFornecedor.add(passwordField, gbc_passwordField);

		JLabel label_13 = new JLabel("Email");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 5;
		painelFornecedor.add(label_13, gbc_label_13);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 5;
		painelFornecedor.add(textField_9, gbc_textField_9);

		JLabel label_14 = new JLabel("Email Secundário");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 2;
		gbc_label_14.gridy = 5;
		painelFornecedor.add(label_14, gbc_label_14);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.gridx = 3;
		gbc_textField_10.gridy = 5;
		painelFornecedor.add(textField_10, gbc_textField_10);

		JLabel label_15 = new JLabel("Telefone");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.anchor = GridBagConstraints.EAST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 4;
		gbc_label_15.gridy = 5;
		painelFornecedor.add(label_15, gbc_label_15);

		JFormattedTextField formattedTextField_5 = null;
		try {
			formattedTextField_5 = new JFormattedTextField(
					new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedTextField_5.setColumns(10);
		GridBagConstraints gbc_formattedTextField_5 = new GridBagConstraints();
		gbc_formattedTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_5.gridx = 5;
		gbc_formattedTextField_5.gridy = 5;
		painelFornecedor.add(formattedTextField_5, gbc_formattedTextField_5);

		JLabel label_16 = new JLabel("Celular");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 6;
		gbc_label_16.gridy = 5;
		painelFornecedor.add(label_16, gbc_label_16);

		JFormattedTextField formattedTextField_6 = null;
		try {
			formattedTextField_6 = new JFormattedTextField(
					new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedTextField_6.setColumns(10);
		GridBagConstraints gbc_formattedTextField_6 = new GridBagConstraints();
		gbc_formattedTextField_6.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField_6.gridx = 7;
		gbc_formattedTextField_6.gridy = 5;
		painelFornecedor.add(formattedTextField_6, gbc_formattedTextField_6);

		JButton button = new JButton("Cadastrar");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.gridx = 7;
		gbc_button.gridy = 6;
		painelFornecedor.add(button, gbc_button);
	}

}
