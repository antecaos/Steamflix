package br.aeso.Steamflix.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Fachada.Fachada;
import java.awt.Color;

public class TelaAluguelCompra extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private Fachada fachada;
	private Compra compra;
	private Aluguel aluguel;

	public TelaAluguelCompra() {
		fachada = Fachada.getInstance();
		start();
	}

	public void start() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 420, 399);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

	public void setCompra(int id) {
		setTitle("SteamFlix - Compra");
		compra = fachada.procuraCompra(id);
		textArea.setText(compra.toString());
	}
	
	public void setAluguel(int id){
		setTitle("SteamFlix - Aluguel");
		aluguel = fachada.procuraAluguel(id);
		textArea.setText(aluguel.toString());
	}

}
