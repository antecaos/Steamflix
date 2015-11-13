package br.aeso.Steamflix.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField logradouroField;
	private JTextField numeroField;
	private JTextField cpfield;
	private JTextField dataField;
	private JTextField complementoField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField paisField;
	private JTextField cepField;
	private JTextField loginField;
	private JTextField senhaField;
	private JTextField emailField;
	private JTextField emailSecundarioField;
	private JTextField telefoneField;
	private JTextField celularField;
	private JTable table;

	public TelaCliente() {
		start();
	}

	public void start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloLabel = new JLabel("Cliente");
		tituloLabel.setBounds(414, 0, 50, 15);
		contentPane.add(tituloLabel);
		
		JButton botaoLoja = new JButton("Loja");
		botaoLoja.setBounds(818, 439, 117, 25);
		contentPane.add(botaoLoja);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 24, 923, 390);
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(26dlu;default)"),},
			new RowSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel nomeLabel = new JLabel("Nome");
		panel.add(nomeLabel, "2, 4, right, default");
		
		nomeField = new JTextField();
		panel.add(nomeField, "4, 4, 7, 1, fill, default");
		nomeField.setColumns(10);
		
		JLabel cpfLabel = new JLabel("CPF");
		panel.add(cpfLabel, "2, 6, right, default");
		
		cpfield = new JTextField();
		panel.add(cpfield, "4, 6, fill, default");
		cpfield.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data de Nascimento");
		panel.add(dataLabel, "6, 6, right, default");
		
		dataField = new JTextField();
		panel.add(dataField, "8, 6, left, default");
		dataField.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		panel.add(enderecoLabel, "2, 8, right, default");
		
		JLabel logradouroLabel = new JLabel("Logradouro");
		panel.add(logradouroLabel, "2, 10, right, default");
		
		logradouroField = new JTextField();
		panel.add(logradouroField, "4, 10, 7, 1");
		logradouroField.setColumns(10);
		
		JLabel numeroLabel = new JLabel("Nº");
		panel.add(numeroLabel, "12, 10, right, default");
		
		numeroField = new JTextField();
		panel.add(numeroField, "14, 10, left, default");
		numeroField.setColumns(5);
		
		JLabel complementoLabel = new JLabel("Complemento");
		panel.add(complementoLabel, "2, 12, right, default");
		
		complementoField = new JTextField();
		panel.add(complementoField, "4, 12, fill, default");
		complementoField.setColumns(10);
		
		JLabel bairroLabel = new JLabel("Bairro");
		panel.add(bairroLabel, "6, 12, right, default");
		
		bairroField = new JTextField();
		panel.add(bairroField, "8, 12, fill, default");
		bairroField.setColumns(10);
		
		JLabel cidadeLabel = new JLabel("Cidade");
		panel.add(cidadeLabel, "10, 12, right, default");
		
		cidadeField = new JTextField();
		panel.add(cidadeField, "12, 12, fill, default");
		cidadeField.setColumns(10);
		
		JLabel estadoLabel = new JLabel("Estado");
		panel.add(estadoLabel, "14, 12, right, default");
		
		JComboBox estadoComboBox = new JComboBox();
		panel.add(estadoComboBox, "16, 12, left, default");
		
		JLabel paisLabel = new JLabel("País");
		panel.add(paisLabel, "2, 14, right, default");
		
		paisField = new JTextField();
		panel.add(paisField, "4, 14, fill, default");
		paisField.setColumns(10);
		
		JLabel cepLabel = new JLabel("CEP");
		panel.add(cepLabel, "6, 14, right, default");
		
		cepField = new JTextField();
		panel.add(cepField, "8, 14, center, default");
		cepField.setColumns(10);
		
		JLabel cadastroLabel = new JLabel("Cadastro");
		panel.add(cadastroLabel, "2, 16, right, default");
		
		JLabel loginLabel = new JLabel("Login");
		panel.add(loginLabel, "2, 18, right, default");
		
		loginField = new JTextField();
		panel.add(loginField, "4, 18, fill, default");
		loginField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha");
		panel.add(senhaLabel, "2, 20, right, default");
		
		senhaField = new JTextField();
		panel.add(senhaField, "4, 20, fill, default");
		senhaField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		panel.add(emailLabel, "2, 22, right, default");
		
		emailField = new JTextField();
		panel.add(emailField, "4, 22, fill, default");
		emailField.setColumns(10);
		
		JLabel emailSecundarioLabel = new JLabel("Email Secundário");
		panel.add(emailSecundarioLabel, "6, 22, right, default");
		
		emailSecundarioField = new JTextField();
		panel.add(emailSecundarioField, "8, 22, fill, default");
		emailSecundarioField.setColumns(10);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		panel.add(telefoneLabel, "2, 24, right, default");
		
		telefoneField = new JTextField();
		panel.add(telefoneField, "4, 24, fill, default");
		telefoneField.setColumns(10);
		
		JLabel celularLabel = new JLabel("Celular");
		panel.add(celularLabel, "6, 24, right, default");
		
		celularField = new JTextField();
		panel.add(celularField, "8, 24, fill, default");
		celularField.setColumns(10);
		
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarCliente();
			}
		});
		panel.add(botaoAtualizar, "14, 26");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Compras", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 903, 321);
		panel_1.add(scrollPane_1);
		
			
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Alugueis", null, panel_2, null);
		panel_2.setLayout(null);
	}

	public void atualizarCliente() {

	}
}
