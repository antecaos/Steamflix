package br.aeso.Steamflix.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.Jogo.Jogo;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TelaProdutoFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField classificacaoField;
	private JFormattedTextField lancamentoField;
	private JLabel generoLabel;
	private JComboBox generoField;
	private JLabel criadorLabel;
	private JTextField criadorField;
	private JLabel precoVendaLabel;
	private JTextField precoVendaField;
	private JLabel precoAluguelLabel;
	private JTextField precoAluguelField;
	private JLabel quantidadeLabel;
	private JTextField quantidadeField;
	private JButton atualizarButton;
	private Fachada fachada;
	private Jogo jogo;
	private Filme filme;
	private JToggleButton botaoMuda;

	public TelaProdutoFornecedor() {
		fachada = Fachada.getInstance();
		Start();
	}

	public void Start() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("112px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("114px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("116px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("114px"), }, new RowSpec[] {
						FormFactory.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("19px"), FormFactory.LINE_GAP_ROWSPEC,
						RowSpec.decode("25px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel nomeLabel = new JLabel("Nome");
		contentPane.add(nomeLabel, "2, 2, left, center");

		nomeField = new JTextField();
		nomeField.setEnabled(false);
		contentPane.add(nomeField, "4, 2, 5, 1, fill, top");
		nomeField.setColumns(10);

		JLabel classificacaoLabel = new JLabel("Classifica\u00E7\u00E3o");
		contentPane.add(classificacaoLabel, "2, 4, left, center");

		classificacaoField = new JTextField();
		classificacaoField.setEnabled(false);
		contentPane.add(classificacaoField, "4, 4, left, top");
		classificacaoField.setColumns(10);

		precoVendaLabel = new JLabel("Pre\u00E7o Venda");
		contentPane.add(precoVendaLabel, "6, 4, left, center");

		precoVendaField = new JTextField();
		precoVendaField.setEnabled(false);
		contentPane.add(precoVendaField, "8, 4, left, top");
		precoVendaField.setColumns(10);

		JLabel lancamentoLabel = new JLabel("Lan\u00E7amento");
		contentPane.add(lancamentoLabel, "2, 6, left, center");

		try {
			lancamentoField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lancamentoField.setEnabled(false);
		contentPane.add(lancamentoField, "4, 6, left, top");
		lancamentoField.setColumns(10);

		precoAluguelLabel = new JLabel("Pre\u00E7o Aluguel");
		contentPane.add(precoAluguelLabel, "6, 6, left, center");

		precoAluguelField = new JTextField();
		precoAluguelField.setEnabled(false);
		contentPane.add(precoAluguelField, "8, 6, left, top");
		precoAluguelField.setColumns(10);

		generoLabel = new JLabel("G\u00EAnero");
		contentPane.add(generoLabel, "2, 8, left, center");

		generoField = new JComboBox(carregarComboBox());
		generoField.setEnabled(false);
		contentPane.add(generoField, "4, 8, left, center");

		quantidadeLabel = new JLabel("Quantidade");
		contentPane.add(quantidadeLabel, "6, 8, left, center");

		quantidadeField = new JTextField();
		quantidadeField.setEnabled(false);
		contentPane.add(quantidadeField, "8, 8, right, center");
		quantidadeField.setColumns(10);

		criadorLabel = new JLabel("Criador");
		contentPane.add(criadorLabel, "2, 10, left, center");

		criadorField = new JTextField();
		criadorField.setEnabled(false);
		contentPane.add(criadorField, "4, 10, left, center");
		criadorField.setColumns(10);

		atualizarButton = new JButton("Atualizar");
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualiza();
			}
		});

		botaoMuda = new JToggleButton("Muda");
		botaoMuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (botaoMuda.isSelected()) {
					autorizaMudanca();
				} else {
					proibeMudanca();
				}
			}
		});
		contentPane.add(botaoMuda, "6, 12");
		contentPane.add(atualizarButton, "8, 12, center, top");
	}

	public void setJogo(int id) {
		setTitle("SteamFlix - Jogo");
		this.jogo = fachada.procuraJogo(id);
		generoField.setSelectedItem(jogo.getGenero().getNome());
		nomeField.setText(jogo.getNome());
		criadorField.setText(jogo.getDesenvolvedor());
		precoVendaField.setText("" + jogo.getPrecoVenda());
		precoAluguelField.setText("" + jogo.getPrecoAluguel());
		classificacaoField.setText(jogo.getClassificacao());
		lancamentoField.setText(jogo.dataFormatada());
		quantidadeField.setText("" + jogo.getQuantidade());		
	}

	public void setFilme(Integer id) {
		setTitle("SteamFlix - Filme");
		this.filme = fachada.procuraFilme(id);
		criadorField.setText(filme.getDiretor());
		generoField.setSelectedItem(filme.getGenero().getNome());
		nomeField.setText(filme.getNome());
		precoVendaField.setText("" + filme.getPrecoVenda());
		precoAluguelField.setText("" + filme.getPrecoAluguel());
		classificacaoField.setText(filme.getClassificacao());
		lancamentoField.setText(filme.dataFormatada());
		quantidadeField.setText("" + filme.getQuantidade());
	}

	public void autorizaMudanca() {
		criadorField.setEnabled(true);
		generoField.setEnabled(true);
		nomeField.setEnabled(true);
		precoVendaField.setEnabled(true);
		precoAluguelField.setEnabled(true);
		classificacaoField.setEnabled(true);
		lancamentoField.setEnabled(true);
		quantidadeField.setEnabled(true);
	}

	public void proibeMudanca() {
		criadorField.setEnabled(false);
		generoField.setEnabled(false);
		nomeField.setEnabled(false);
		precoVendaField.setEnabled(false);
		precoAluguelField.setEnabled(false);
		classificacaoField.setEnabled(false);
		lancamentoField.setEnabled(false);
		quantidadeField.setEnabled(false);
	}

	public void atualiza() {
		if (this.filme != null) {
			Calendar dataLancamento = Calendar.getInstance();
			String dataEmTexto = this.lancamentoField.getText();
			try {
				Date data = new SimpleDateFormat("dd/MM/yyyy")
						.parse(dataEmTexto);
				dataLancamento.setTime(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.filme.setClassificacao(classificacaoField.getText());
			this.filme.setDataLancamento(dataLancamento);
			this.filme.setDiretor(criadorField.getText());
			this.filme.setNome(nomeField.getText());
			this.filme.setPrecoAluguel(Double.parseDouble(precoAluguelField
					.getText()));
			this.filme.setGenero((Genero) this.generoField.getSelectedItem());
			this.filme.setPrecoVenda(Double.parseDouble(precoVendaField
					.getText()));
			this.filme
					.setQuantidade(Integer.parseInt(quantidadeField.getText()));
			fachada.atualizarFilme(this.filme);
			JOptionPane.showMessageDialog(this, this.filme.getNome()
					+ " atualizado com Sucesso!");
			setVisible(false);

		} else if (this.jogo != null) {
			Calendar dataLancamento = Calendar.getInstance();
			String dataEmTexto = this.lancamentoField.getText();
			try {
				Date data = new SimpleDateFormat("dd/MM/yyyy")
						.parse(dataEmTexto);
				dataLancamento.setTime(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.jogo.setClassificacao(classificacaoField.getText());
			this.jogo.setDataLancamento(dataLancamento);
			this.jogo.setDesenvolvedor(criadorField.getText());
			this.jogo.setNome(nomeField.getText());
			this.jogo.setGenero((Genero) this.generoField.getSelectedItem());
			this.jogo.setPrecoAluguel(Double.parseDouble(precoAluguelField
					.getText()));
			this.jogo.setPrecoVenda(Double.parseDouble(precoVendaField
					.getText()));
			this.jogo
					.setQuantidade(Integer.parseInt(quantidadeField.getText()));
			fachada.atualizarJogo(this.jogo);
			JOptionPane.showMessageDialog(this, this.jogo.getNome()
					+ " atualizado com Sucesso!");
			setVisible(false);
		}
	}

	public Vector carregarComboBox() {
		ArrayList<Genero> lista = fachada.listarGenero();
		Vector vetor = new Vector();
		for (Genero genero : lista) {
			vetor.add(genero);
		}

		return vetor;
	}
}
