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

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
					frame.setTitle("Tela cliente");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JLabel lblNewLabel_13 = new JLabel("Cliente");
		lblNewLabel_13.setBounds(414, 0, 50, 15);
		contentPane.add(lblNewLabel_13);
		
		JButton btnLoja = new JButton("Loja");
		btnLoja.setBounds(818, 439, 117, 25);
		contentPane.add(btnLoja);
		
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
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "2, 4, right, default");
		
		textField = new JTextField();
		panel.add(textField, "4, 4, 7, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		panel.add(lblCpf, "2, 6, right, default");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "4, 6, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2, "6, 6, right, default");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "8, 6, left, default");
		textField_4.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		panel.add(lblEndereo, "2, 8, right, default");
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		panel.add(lblLogradouro, "2, 10, right, default");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "4, 10, 7, 1");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nº");
		panel.add(lblNewLabel_1, "12, 10, right, default");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "14, 10, left, default");
		textField_2.setColumns(5);
		
		JLabel lblBairro = new JLabel("Complemento");
		panel.add(lblBairro, "2, 12, right, default");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "4, 12, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro");
		panel.add(lblNewLabel_3, "6, 12, right, default");
		
		textField_7 = new JTextField();
		panel.add(textField_7, "8, 12, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		panel.add(lblCidade, "10, 12, right, default");
		
		textField_6 = new JTextField();
		panel.add(textField_6, "12, 12, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		panel.add(lblNewLabel_4, "14, 12, right, default");
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "16, 12, left, default");
		
		JLabel lblNewLabel_5 = new JLabel("País");
		panel.add(lblNewLabel_5, "2, 14, right, default");
		
		textField_8 = new JTextField();
		panel.add(textField_8, "4, 14, fill, default");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CEP");
		panel.add(lblNewLabel_6, "6, 14, right, default");
		
		textField_9 = new JTextField();
		panel.add(textField_9, "8, 14, fill, default");
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cadastro");
		panel.add(lblNewLabel_7, "2, 16, right, default");
		
		JLabel lblNewLabel_8 = new JLabel("Login");
		panel.add(lblNewLabel_8, "2, 18, right, default");
		
		textField_10 = new JTextField();
		panel.add(textField_10, "4, 18, fill, default");
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Senha");
		panel.add(lblNewLabel_9, "2, 20, right, default");
		
		textField_11 = new JTextField();
		panel.add(textField_11, "4, 20, fill, default");
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Email");
		panel.add(lblNewLabel_10, "2, 22, right, default");
		
		textField_12 = new JTextField();
		panel.add(textField_12, "4, 22, fill, default");
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Email Secundário");
		panel.add(lblNewLabel_11, "6, 22, right, default");
		
		textField_13 = new JTextField();
		panel.add(textField_13, "8, 22, fill, default");
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Telefone");
		panel.add(lblNewLabel_12, "2, 24, right, default");
		
		textField_14 = new JTextField();
		panel.add(textField_14, "4, 24, fill, default");
		textField_14.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		panel.add(lblCelular, "6, 24, right, default");
		
		textField_16 = new JTextField();
		panel.add(textField_16, "8, 24, fill, default");
		textField_16.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		panel.add(btnAtualizar, "14, 26");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Compras", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Alugueis", null, panel_2, null);
		panel_2.setLayout(null);
	}
}
