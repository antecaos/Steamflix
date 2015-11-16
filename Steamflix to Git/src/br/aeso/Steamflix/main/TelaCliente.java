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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

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
	private JTable tabelaCompras;
	private Cliente cliente;
	private JLabel tituloLabel;

	public TelaCliente() {
		start();
	}

	public void start() {
		String[] estados = { "AC", "AL", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ",
				"RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPainelGeral = new JScrollPane();
		scrollPainelGeral.setBounds(12, 0, 985, 431);
		contentPane.add(scrollPainelGeral);

		JPanel painelGeral = new JPanel();
		scrollPainelGeral.setViewportView(painelGeral);
		painelGeral.setLayout(null);

		tituloLabel = new JLabel();
		tituloLabel.setBounds(7, 193, 0, 0);
		painelGeral.add(tituloLabel);

		JScrollPane scrollPainelTabs = new JScrollPane();
		scrollPainelTabs.setBounds(12, 5, 964, 377);
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
						ColumnSpec.decode("max(14dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
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
					nomeField.setEnabled(false);
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

		cpfield = new JTextField();
		cpfield.setEnabled(false);
		painelDados.add(cpfield, "4, 6, fill, default");
		cpfield.setColumns(10);

		JLabel dataLabel = new JLabel("Data de Nascimento");
		painelDados.add(dataLabel, "6, 6, right, default");

		dataField = new JTextField();
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

		JComboBox estadoComboBox = new JComboBox(estados);
		painelDados.add(estadoComboBox, "16, 12, left, default");

		JLabel paisLabel = new JLabel("País");
		painelDados.add(paisLabel, "2, 14, right, default");

		paisField = new JTextField();
		paisField.setEnabled(false);
		painelDados.add(paisField, "4, 14, fill, default");
		paisField.setColumns(10);

		JLabel cepLabel = new JLabel("CEP");
		painelDados.add(cepLabel, "6, 14, right, default");

		cepField = new JTextField();
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

		JLabel emailSecundarioLabel = new JLabel("Email Secundário");
		painelDados.add(emailSecundarioLabel, "6, 22, right, default");

		emailSecundarioField = new JTextField();
		emailSecundarioField.setEnabled(false);
		painelDados.add(emailSecundarioField, "8, 22, fill, default");
		emailSecundarioField.setColumns(10);

		JLabel telefoneLabel = new JLabel("Telefone");
		painelDados.add(telefoneLabel, "2, 24, right, default");

		telefoneField = new JTextField();
		telefoneField.setEnabled(false);
		painelDados.add(telefoneField, "4, 24, fill, default");
		telefoneField.setColumns(10);

		JLabel celularLabel = new JLabel("Celular");
		painelDados.add(celularLabel, "6, 24, right, default");

		celularField = new JTextField();
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
		scrollTabelaCompras.setBounds(12, 12, 903, 321);
		painelCompra.add(scrollTabelaCompras);

		tabelaCompras = new JTable();
		tabelaCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaCompras.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Data", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaCompras.getColumnModel().getColumn(0).setResizable(false);
		tabelaCompras.getColumnModel().getColumn(0).setMinWidth(10);
		tabelaCompras.setBackground(Color.WHITE);
		tabelaCompras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollTabelaCompras.setViewportView(tabelaCompras);

		JPanel painelAluguel = new JPanel();
		painelTabs.addTab("Alugueis", null, painelAluguel, null);
		painelAluguel.setLayout(null);

		JButton button = new JButton("Loja");
		button.setBounds(844, 394, 64, 25);
		painelGeral.add(button);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.tituloLabel.setText("Cliente -" + this.cliente.getNome());
		this.nomeField.setText(cliente.getNome());
		this.cpfield.setText(cliente.getCPF());
		this.dataField.setText(cliente.dataFormatada());
		// Terminar de setar os dados para o cliente;
	}

	public void autorizaMudanca() {
		nomeField.setEnabled(true);
		// Terminar de autorizar os dados para mudanças;
	}

	public void proibeMudancas() {
		nomeField.setEnabled(false);
		// Terminar de proibir as mudanças;
	}

	public void atualizarCliente() {

	}
}
