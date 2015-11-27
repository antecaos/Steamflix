package br.aeso.Steamflix.main;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class TelaProdutoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField classificacaoField;
	private JFormattedTextField lancamentoField;
	private JLabel generoLabel;
	private JTextField generoField;
	private JLabel criadorLabel;
	private JTextField criadorField;
	private JLabel precoVendaLabel;
	private JTextField precoVendaField;
	private JLabel precoAluguelLabel;
	private JTextField precoAluguelField;
	private JLabel quantidadeLabel;
	private JTextField quantidadeField;
	private Fachada fachada;
	private Jogo jogo;
	private Filme filme;
	private JLabel produtoLabel;

	public TelaProdutoCliente() {
		fachada = Fachada.getInstance();
		Start();
	}

	public void Start() {
		setTitle("SteamFlix - Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(167, 14, 40, 15);
		contentPane.add(nomeLabel);

		nomeField = new JTextField();
		nomeField.setBounds(286, 12, 358, 19);
		nomeField.setEnabled(false);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		JLabel classificacaoLabel = new JLabel("Classifica\u00E7\u00E3o");
		classificacaoLabel.setBounds(167, 41, 92, 15);
		contentPane.add(classificacaoLabel);

		classificacaoField = new JTextField();
		classificacaoField.setBounds(286, 36, 114, 19);
		classificacaoField.setEnabled(false);
		contentPane.add(classificacaoField);
		classificacaoField.setColumns(10);

		precoVendaLabel = new JLabel("Pre\u00E7o Venda");
		precoVendaLabel.setBounds(407, 41, 89, 15);
		contentPane.add(precoVendaLabel);

		precoVendaField = new JTextField();
		precoVendaField.setBounds(530, 36, 114, 19);
		precoVendaField.setEnabled(false);
		contentPane.add(precoVendaField);
		precoVendaField.setColumns(10);

		JLabel lancamentoLabel = new JLabel("Lan\u00E7amento");
		lancamentoLabel.setBounds(167, 70, 87, 15);
		contentPane.add(lancamentoLabel);

		try {
			lancamentoField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lancamentoField.setBounds(286, 68, 114, 19);
		lancamentoField.setEnabled(false);
		contentPane.add(lancamentoField);
		lancamentoField.setColumns(10);

		precoAluguelLabel = new JLabel("Pre\u00E7o Aluguel");
		precoAluguelLabel.setBounds(407, 70, 97, 15);
		contentPane.add(precoAluguelLabel);

		precoAluguelField = new JTextField();
		precoAluguelField.setBounds(530, 68, 114, 19);
		precoAluguelField.setEnabled(false);
		contentPane.add(precoAluguelField);
		precoAluguelField.setColumns(10);

		generoLabel = new JLabel("G\u00EAnero");
		generoLabel.setBounds(167, 96, 52, 15);
		contentPane.add(generoLabel);

		generoField = new JTextField();
		generoField.setBounds(286, 94, 114, 19);
		generoField.setEnabled(false);
		contentPane.add(generoField);
		generoField.setColumns(10);

		quantidadeLabel = new JLabel("Quantidade");
		quantidadeLabel.setBounds(407, 96, 83, 15);
		contentPane.add(quantidadeLabel);

		quantidadeField = new JTextField();
		quantidadeField.setBounds(530, 94, 114, 19);
		quantidadeField.setEnabled(false);
		contentPane.add(quantidadeField);
		quantidadeField.setColumns(10);

		criadorLabel = new JLabel("Criador");
		criadorLabel.setBounds(167, 122, 52, 15);
		contentPane.add(criadorLabel);

		criadorField = new JTextField();
		criadorField.setBounds(286, 120, 114, 19);
		criadorField.setEnabled(false);
		contentPane.add(criadorField);
		criadorField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(12, 0, 144, 157);
		contentPane.add(panel);
		panel.setLayout(null);

		produtoLabel = new JLabel("Foto");
		produtoLabel.setBounds(52, 75, 32, 15);
		panel.add(produtoLabel);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSair.setBounds(530, 125, 117, 25);
		contentPane.add(btnSair);
	}

	public void setJogo(int id) {
		this.jogo = fachada.procuraJogo(id);
		generoField.setText(jogo.getGenero().getNome());
		nomeField.setText(jogo.getNome());
		criadorField.setText(jogo.getDesenvolvedor());
		precoVendaField.setText("" + jogo.getPrecoVenda());
		precoAluguelField.setText("" + jogo.getPrecoAluguel());
		classificacaoField.setText(jogo.getClassificacao());
		lancamentoField.setText(jogo.dataFormatada());
		quantidadeField.setText("" + jogo.getQuantidade());		
	}

	public void setFilme(Integer id) {
		this.filme = fachada.procuraFilme(id);
		criadorField.setText(filme.getDiretor());
		generoField.setText(filme.getGenero().getNome());
		nomeField.setText(filme.getNome());
		precoVendaField.setText("" + filme.getPrecoVenda());
		precoAluguelField.setText("" + filme.getPrecoAluguel());
		classificacaoField.setText(filme.getClassificacao());
		lancamentoField.setText(filme.dataFormatada());
		quantidadeField.setText("" + filme.getQuantidade());		
	}
}
