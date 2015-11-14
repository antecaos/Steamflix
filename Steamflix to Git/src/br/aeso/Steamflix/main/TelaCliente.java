package br.aeso.Steamflix.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.aeso.Steamflix.Cliente.Cliente;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToggleButton;

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
	private Cliente cliente;
	private JLabel tituloLabel;

	public TelaCliente() {
		start();
	}

	public void start(){
		String[] estados = { "AC", "AL", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
				"RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 0, 985, 431);
		contentPane.add(scrollPane_2);
		
		JPanel panel_3 = new JPanel();
		scrollPane_2.setViewportView(panel_3);
		panel_3.setLayout(null);
		
		tituloLabel = new JLabel();
		tituloLabel.setBounds(7, 193, 0, 0);
		panel_3.add(tituloLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 964, 377);
		panel_3.add(scrollPane);
		
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
		
		final JToggleButton mudarDados = new JToggleButton("Mudar dados");
		mudarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mudarDados.isSelected()){
					autorizaMudanca();	
				}else{
					nomeField.setEnabled(false);
				}
				
			}
		});
		panel.add(mudarDados, "14, 2");
		
		JLabel nomeLabel = new JLabel("Nome");
		panel.add(nomeLabel, "2, 4, right, default");
		
		nomeField = new JTextField();
		nomeField.setEnabled(false);
		panel.add(nomeField, "4, 4, 7, 1, fill, default");
		nomeField.setColumns(10);
		
		JLabel cpfLabel = new JLabel("CPF");
		panel.add(cpfLabel, "2, 6, right, default");
		
		cpfield = new JTextField();
		cpfield.setEnabled(false);
		panel.add(cpfield, "4, 6, fill, default");
		cpfield.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data de Nascimento");
		panel.add(dataLabel, "6, 6, right, default");
		
		dataField = new JTextField();
		dataField.setEnabled(false);
		panel.add(dataField, "8, 6, left, default");
		dataField.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		panel.add(enderecoLabel, "2, 8, right, default");
		
		JLabel logradouroLabel = new JLabel("Logradouro");
		panel.add(logradouroLabel, "2, 10, right, default");
		
		logradouroField = new JTextField();
		logradouroField.setEnabled(false);
		panel.add(logradouroField, "4, 10, 7, 1");
		logradouroField.setColumns(10);
		
		JLabel numeroLabel = new JLabel("Nº");
		panel.add(numeroLabel, "12, 10, right, default");
		
		numeroField = new JTextField();
		numeroField.setEnabled(false);
		panel.add(numeroField, "14, 10, left, default");
		numeroField.setColumns(5);
		
		JLabel complementoLabel = new JLabel("Complemento");
		panel.add(complementoLabel, "2, 12, right, default");
		
		complementoField = new JTextField();
		complementoField.setEnabled(false);
		panel.add(complementoField, "4, 12, fill, default");
		complementoField.setColumns(10);
		
		JLabel bairroLabel = new JLabel("Bairro");
		panel.add(bairroLabel, "6, 12, right, default");
		
		bairroField = new JTextField();
		bairroField.setEnabled(false);
		panel.add(bairroField, "8, 12, fill, default");
		bairroField.setColumns(10);
		
		JLabel cidadeLabel = new JLabel("Cidade");
		panel.add(cidadeLabel, "10, 12, right, default");
		
		cidadeField = new JTextField();
		cidadeField.setEnabled(false);
		panel.add(cidadeField, "12, 12, fill, default");
		cidadeField.setColumns(10);
		
		JLabel estadoLabel = new JLabel("Estado");
		panel.add(estadoLabel, "14, 12, right, default");
		
		JComboBox estadoComboBox = new JComboBox(estados);
		panel.add(estadoComboBox, "16, 12, left, default");
		
		JLabel paisLabel = new JLabel("País");
		panel.add(paisLabel, "2, 14, right, default");
		
		paisField = new JTextField();
		paisField.setEnabled(false);
		panel.add(paisField, "4, 14, fill, default");
		paisField.setColumns(10);
		
		JLabel cepLabel = new JLabel("CEP");
		panel.add(cepLabel, "6, 14, right, default");
		
		cepField = new JTextField();
		cepField.setEnabled(false);
		panel.add(cepField, "8, 14, center, default");
		cepField.setColumns(10);
		
		JLabel cadastroLabel = new JLabel("Cadastro");
		panel.add(cadastroLabel, "2, 16, right, default");
		
		JLabel loginLabel = new JLabel("Login");
		panel.add(loginLabel, "2, 18, right, default");
		
		loginField = new JTextField();
		loginField.setEnabled(false);
		panel.add(loginField, "4, 18, fill, default");
		loginField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha");
		panel.add(senhaLabel, "2, 20, right, default");
		
		senhaField = new JTextField();
		senhaField.setEnabled(false);
		panel.add(senhaField, "4, 20, fill, default");
		senhaField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		panel.add(emailLabel, "2, 22, right, default");
		
		emailField = new JTextField();
		emailField.setEnabled(false);
		panel.add(emailField, "4, 22, fill, default");
		emailField.setColumns(10);
		
		JLabel emailSecundarioLabel = new JLabel("Email Secundário");
		panel.add(emailSecundarioLabel, "6, 22, right, default");
		
		emailSecundarioField = new JTextField();
		emailSecundarioField.setEnabled(false);
		panel.add(emailSecundarioField, "8, 22, fill, default");
		emailSecundarioField.setColumns(10);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		panel.add(telefoneLabel, "2, 24, right, default");
		
		telefoneField = new JTextField();
		telefoneField.setEnabled(false);
		panel.add(telefoneField, "4, 24, fill, default");
		telefoneField.setColumns(10);
		
		JLabel celularLabel = new JLabel("Celular");
		panel.add(celularLabel, "6, 24, right, default");
		
		celularField = new JTextField();
		celularField.setEnabled(false);
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
		
		JButton button = new JButton("Loja");
		button.setBounds(844, 394, 64, 25);
		panel_3.add(button);
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
		this.tituloLabel.setText("Cliente -"+ this.cliente.getNome());
		this.nomeField.setText(cliente.getNome());
		this.cpfield.setText(cliente.getCPF());
		this.dataField.setText(cliente.dataFormatada());
		//Terminar de setar os dados para o cliente;
	}
	
	public void autorizaMudanca(){
		nomeField.setEnabled(true);
		//Terminar de autorizar os dados para mudanças;
	}
	
	public void proibeMudancas(){
		nomeField.setEnabled(false);
		//Terminar de proibir as mudanças;
	}
	
	public void atualizarCliente() {
		
	}
}
