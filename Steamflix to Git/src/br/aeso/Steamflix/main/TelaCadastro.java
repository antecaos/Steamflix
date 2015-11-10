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
	private JTextField nomeFantasiaField;
	private JTextField ruaFornecedorField;
	private JTextField numeroFornecedorField;
	private JTextField complementoFornecedorField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField razaoSocialField;
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

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 302);
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
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		String[] estados = { "AC", "AL", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
				"RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridwidth = 8;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel.add(tabbedPane, gbc_tabbedPane);

		JPanel painelCadastroCliente = new JPanel();
		tabbedPane
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

		JPanel cadastroFornecedor = new JPanel();
		tabbedPane
				.addTab("Cadastro Fornecedor", null, cadastroFornecedor, null);
		GridBagLayout gbl_cadastroFornecedor = new GridBagLayout();
		gbl_cadastroFornecedor.columnWidths = new int[]{0, 0};
		gbl_cadastroFornecedor.rowHeights = new int[]{0, 0};
		gbl_cadastroFornecedor.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_cadastroFornecedor.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		cadastroFornecedor.setLayout(gbl_cadastroFornecedor);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		cadastroFornecedor.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		GridBagConstraints gbc_lblNomeFantasia = new GridBagConstraints();
		gbc_lblNomeFantasia.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeFantasia.gridx = 0;
		gbc_lblNomeFantasia.gridy = 0;
		panel_1.add(lblNomeFantasia, gbc_lblNomeFantasia);
		
		nomeFantasiaField = new JTextField();
		nomeFantasiaField.setColumns(10);
		GridBagConstraints gbc_nomeFantasiaField = new GridBagConstraints();
		gbc_nomeFantasiaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeFantasiaField.gridwidth = 3;
		gbc_nomeFantasiaField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFantasiaField.gridx = 1;
		gbc_nomeFantasiaField.gridy = 0;
		panel_1.add(nomeFantasiaField, gbc_nomeFantasiaField);
		
		JLabel lblRazoSocial = new JLabel("Razão Social");
		GridBagConstraints gbc_lblRazoSocial = new GridBagConstraints();
		gbc_lblRazoSocial.anchor = GridBagConstraints.EAST;
		gbc_lblRazoSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblRazoSocial.gridx = 4;
		gbc_lblRazoSocial.gridy = 0;
		panel_1.add(lblRazoSocial, gbc_lblRazoSocial);
		
		razaoSocialField = new JTextField();
		GridBagConstraints gbc_razaoSocialField = new GridBagConstraints();
		gbc_razaoSocialField.gridwidth = 3;
		gbc_razaoSocialField.insets = new Insets(0, 0, 5, 5);
		gbc_razaoSocialField.fill = GridBagConstraints.HORIZONTAL;
		gbc_razaoSocialField.gridx = 5;
		gbc_razaoSocialField.gridy = 0;
		panel_1.add(razaoSocialField, gbc_razaoSocialField);
		razaoSocialField.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		GridBagConstraints gbc_lblCnpj = new GridBagConstraints();
		gbc_lblCnpj.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnpj.gridx = 0;
		gbc_lblCnpj.gridy = 1;
		panel_1.add(lblCnpj, gbc_lblCnpj);
		
		JFormattedTextField cnpjField = null;
		try {
			cnpjField = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnpjField.setColumns(10);
		GridBagConstraints gbc_cnpjField = new GridBagConstraints();
		gbc_cnpjField.insets = new Insets(0, 0, 5, 5);
		gbc_cnpjField.gridx = 1;
		gbc_cnpjField.gridy = 1;
		panel_1.add(cnpjField, gbc_cnpjField);
		
		JLabel label_3 = new JLabel("CEP");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		JFormattedTextField formattedTextField_2 = null;
		try {
			cepFornecedorField = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cepFornecedorField.setColumns(10);
		GridBagConstraints gbc_cepFornecedorField = new GridBagConstraints();
		gbc_cepFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_cepFornecedorField.gridx = 5;
		gbc_cepFornecedorField.gridy = 1;
		panel_1.add(cepFornecedorField, gbc_cepFornecedorField);
		
		JLabel label_4 = new JLabel("Rua");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 2;
		panel_1.add(label_4, gbc_label_4);
		
		ruaFornecedorField = new JTextField();
		ruaFornecedorField.setColumns(10);
		GridBagConstraints gbc_ruaFornecedorField = new GridBagConstraints();
		gbc_ruaFornecedorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ruaFornecedorField.gridwidth = 3;
		gbc_ruaFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_ruaFornecedorField.gridx = 1;
		gbc_ruaFornecedorField.gridy = 2;
		panel_1.add(ruaFornecedorField, gbc_ruaFornecedorField);
		
		JLabel label_5 = new JLabel("Nº");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 4;
		gbc_label_5.gridy = 2;
		panel_1.add(label_5, gbc_label_5);
		
		numeroFornecedorField = new JTextField();
		numeroFornecedorField.setColumns(10);
		GridBagConstraints gbc_numeroFornecedorField = new GridBagConstraints();
		gbc_numeroFornecedorField.insets = new Insets(0, 0, 5, 5);
		gbc_numeroFornecedorField.gridx = 5;
		gbc_numeroFornecedorField.gridy = 2;
		panel_1.add(numeroFornecedorField, gbc_numeroFornecedorField);
		
		JLabel label_6 = new JLabel("Complemento");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 6;
		gbc_label_6.gridy = 2;
		panel_1.add(label_6, gbc_label_6);
		
		complementoFornecedorField = new JTextField();
		complementoFornecedorField.setColumns(10);
		GridBagConstraints gbc_complementoFornecedorField = new GridBagConstraints();
		gbc_complementoFornecedorField.insets = new Insets(0, 0, 5, 0);
		gbc_complementoFornecedorField.gridx = 7;
		gbc_complementoFornecedorField.gridy = 2;
		panel_1.add(complementoFornecedorField, gbc_complementoFornecedorField);
		
		JLabel label_7 = new JLabel("Bairro");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 3;
		panel_1.add(label_7, gbc_label_7);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_1.add(textField_4, gbc_textField_4);
		
		JLabel label_8 = new JLabel("Estado");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 2;
		gbc_label_8.gridy = 3;
		panel_1.add(label_8, gbc_label_8);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 3;
		panel_1.add(comboBox, gbc_comboBox);
		
		JLabel label_9 = new JLabel("Cidade");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 4;
		gbc_label_9.gridy = 3;
		panel_1.add(label_9, gbc_label_9);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 3;
		panel_1.add(textField_5, gbc_textField_5);
		
		JLabel label_10 = new JLabel("País");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 6;
		gbc_label_10.gridy = 3;
		panel_1.add(label_10, gbc_label_10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 7;
		gbc_textField_6.gridy = 3;
		panel_1.add(textField_6, gbc_textField_6);
		
		JLabel label_11 = new JLabel("Login");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 4;
		panel_1.add(label_11, gbc_label_11);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 4;
		panel_1.add(textField_7, gbc_textField_7);
		
		JLabel label_12 = new JLabel("Senha");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 2;
		gbc_label_12.gridy = 4;
		panel_1.add(label_12, gbc_label_12);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 4;
		panel_1.add(passwordField, gbc_passwordField);
		
		JLabel label_13 = new JLabel("Email");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 5;
		panel_1.add(label_13, gbc_label_13);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 5;
		panel_1.add(textField_8, gbc_textField_8);
		
		JLabel label_14 = new JLabel("Email Secundário");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 2;
		gbc_label_14.gridy = 5;
		panel_1.add(label_14, gbc_label_14);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 5;
		panel_1.add(textField_9, gbc_textField_9);
		
		JLabel label_15 = new JLabel("Telefone");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 4;
		gbc_label_15.gridy = 5;
		panel_1.add(label_15, gbc_label_15);
		
		JFormattedTextField formattedTextField_3 = null;
		try {
			formattedTextField_3 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedTextField_3.setColumns(10);
		GridBagConstraints gbc_formattedTextField_3 = new GridBagConstraints();
		gbc_formattedTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_3.gridx = 5;
		gbc_formattedTextField_3.gridy = 5;
		panel_1.add(formattedTextField_3, gbc_formattedTextField_3);
		
		JLabel label_16 = new JLabel("Celular");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 6;
		gbc_label_16.gridy = 5;
		panel_1.add(label_16, gbc_label_16);
		
		JFormattedTextField formattedTextField_4 = null;
		try {
			formattedTextField_4 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedTextField_4.setColumns(10);
		GridBagConstraints gbc_formattedTextField_4 = new GridBagConstraints();
		gbc_formattedTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTextField_4.gridx = 7;
		gbc_formattedTextField_4.gridy = 5;
		panel_1.add(formattedTextField_4, gbc_formattedTextField_4);
		
		JButton button = new JButton("Cadastrar");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 7;
		gbc_button.gridy = 6;
		panel_1.add(button, gbc_button);

	}

}
