package br.aeso.Steamflix.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField senhaField;
	private JButton entrarBotao;
	private JLabel lblNoCadastrado;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		start();
	}
	
	public void start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(161, 139, 39, 15);
		contentPane.add(loginLabel);
		
		loginField = new JTextField();
		loginField.setBounds(124, 168, 114, 19);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha");
		senhaLabel.setBounds(158, 199, 45, 15);
		contentPane.add(senhaLabel);
		
		senhaField = new JTextField();
		senhaField.setColumns(10);
		senhaField.setBounds(124, 228, 114, 19);
		contentPane.add(senhaField);
		
		entrarBotao = new JButton("Entrar");
		entrarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		entrarBotao.setBounds(122, 259, 117, 25);
		contentPane.add(entrarBotao);
		
		lblNoCadastrado = new JLabel("Não é cadastrado? Cadastre-se");
		lblNoCadastrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNoCadastrado.setBounds(69, 313, 224, 15);
		contentPane.add(lblNoCadastrado);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(161, 53, 40, 15);
		contentPane.add(lblLogo);
	}

}
