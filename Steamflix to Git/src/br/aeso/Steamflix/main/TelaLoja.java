package br.aeso.Steamflix.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class TelaLoja extends JFrame {

	private JPanel contentPane;
	private JTable tabelaFilmes;
	private JTable tabelaJogos;
	private DefaultTableModel filmesDefaultModel;
	private DefaultTableModel jogosDefaultModel;
	private Fachada fachada;
	private ArrayList<Jogo> jogos;
	private ArrayList<Filme> filmes;
	private Compra compra;
	private Aluguel aluguel;
	private JTextField nomeFilmeField;
	private JTextField classificacaoFilmeField;
	private JTextField precoVendaFilmeField;
	private JTextField precoAluguelFilmeField;
	private JTextField generoFilmeField;
	private JTextField quantidadeFilmeField;
	private JTextField diretorFilmeField;
	private JTextField nomeJogoField;
	private JTextField classificacaoJogoField;
	private JTextField precoVendaJogoField;
	private JTextField precoAluguelJogoField;
	private JTextField generoJogoField;
	private JTextField quantidadeJogoField;
	private JTextField desenvolvedorJogoField;
	private JFormattedTextField lancamentoJogoField;
	private JFormattedTextField lancamentoFilmeField;
	private Jogo jogo;
	private Filme filme;
	private JScrollPane scrollPaneFilmes;
	private JScrollPane scrollPaneJogos;
	private JPanel painelJogoProduto;
	private JPanel painelFilmeProduto;
	private JPanel painelJogos;
	private JPanel painelFilmes;
	private JPanel painelCard;
	private JTable tabelaProdutos;
	private JTextField cupomField;
	private JTextField totalField;
	private DefaultTableModel produtosDefaultModel;
	private JButton botaoCancelarFilme;

	public TelaLoja() {
		fachada = Fachada.getInstance();
		filmes = new ArrayList<Filme>();
		jogos = new ArrayList<Jogo>();
		start();
		listarFilmes();
		listarJogos();
	}

	public void start() {
		setTitle("SteamFlix - Loja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBounds(677, 0, 62, 25);
		contentPane.add(btnSair);
		filmesDefaultModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Pre\u00E7o Venda",
						"Pre\u00E7o Aluguel" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		jogosDefaultModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Pre\u00E7o Venda",
						"Pre\u00E7o Aluguel" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		JButton botaoCarrinho = new JButton("Carrinho");
		botaoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) (painelCard.getLayout());
				card.show(painelCard, "painelCarrinho");
				listarProdutos();
			}
		});
		botaoCarrinho.setBounds(553, 0, 117, 25);
		contentPane.add(botaoCarrinho);
		painelCard = new JPanel();
		painelCard.setBounds(12, 24, 727, 453);
		contentPane.add(painelCard);
		painelCard.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		painelCard.add(tabbedPane, "painelTabProdutos");

		painelFilmes = new JPanel();
		tabbedPane.addTab("Filmes", null, painelFilmes, null);
		painelFilmes.setLayout(new CardLayout(0, 0));

		scrollPaneFilmes = new JScrollPane();
		painelFilmes.add(scrollPaneFilmes, "tabelaFilmes");

		tabelaFilmes = new JTable();
		tabelaFilmes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout card = (CardLayout) (painelFilmes.getLayout());
				card.show(painelFilmes, "painelFilmeProduto");
				setFilme((int) tabelaFilmes.getValueAt(
						tabelaFilmes.getSelectedRow(), 0));
			}
		});
		tabelaFilmes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaFilmes.setModel(filmesDefaultModel);

		tabelaFilmes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaFilmes.getColumnModel().getColumn(1).setPreferredWidth(340);
		tabelaFilmes.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaFilmes.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPaneFilmes.setViewportView(tabelaFilmes);

		painelFilmeProduto = new JPanel();
		painelFilmeProduto.setVisible(false);
		painelFilmes.add(painelFilmeProduto, "painelFilmeProduto");
		painelFilmeProduto.setLayout(null);

		JPanel painelFilmeDoProduto = new JPanel();
		painelFilmeDoProduto.setLayout(null);
		painelFilmeDoProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelFilmeDoProduto.setBounds(12, 12, 670, 166);
		painelFilmeProduto.add(painelFilmeDoProduto);

		JLabel nomeFilmeLabel = new JLabel("Nome");
		nomeFilmeLabel.setBounds(167, 14, 40, 15);
		painelFilmeDoProduto.add(nomeFilmeLabel);

		nomeFilmeField = new JTextField();
		nomeFilmeField.setEnabled(false);
		nomeFilmeField.setColumns(10);
		nomeFilmeField.setBounds(286, 12, 358, 19);
		painelFilmeDoProduto.add(nomeFilmeField);

		JLabel classificacaoFilmeLabel = new JLabel("Classificação");
		classificacaoFilmeLabel.setBounds(167, 41, 92, 15);
		painelFilmeDoProduto.add(classificacaoFilmeLabel);

		classificacaoFilmeField = new JTextField();
		classificacaoFilmeField.setEnabled(false);
		classificacaoFilmeField.setColumns(10);
		classificacaoFilmeField.setBounds(286, 36, 114, 19);
		painelFilmeDoProduto.add(classificacaoFilmeField);

		JLabel precoVendaFilmeLabel = new JLabel("Preço Venda");
		precoVendaFilmeLabel.setBounds(407, 41, 89, 15);
		painelFilmeDoProduto.add(precoVendaFilmeLabel);

		precoVendaFilmeField = new JTextField();
		precoVendaFilmeField.setEnabled(false);
		precoVendaFilmeField.setColumns(10);
		precoVendaFilmeField.setBounds(530, 36, 114, 19);
		painelFilmeDoProduto.add(precoVendaFilmeField);

		JLabel lancamentoFilmeLabel = new JLabel("Lançamento");
		lancamentoFilmeLabel.setBounds(167, 70, 87, 15);
		painelFilmeDoProduto.add(lancamentoFilmeLabel);
		try {
			lancamentoFilmeField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lancamentoFilmeField.setEnabled(false);
		lancamentoFilmeField.setColumns(10);
		lancamentoFilmeField.setBounds(286, 68, 114, 19);
		painelFilmeDoProduto.add(lancamentoFilmeField);

		JLabel precoAluguelFilmeLabel = new JLabel("Preço Aluguel");
		precoAluguelFilmeLabel.setBounds(407, 70, 97, 15);
		painelFilmeDoProduto.add(precoAluguelFilmeLabel);

		precoAluguelFilmeField = new JTextField();
		precoAluguelFilmeField.setEnabled(false);
		precoAluguelFilmeField.setColumns(10);
		precoAluguelFilmeField.setBounds(530, 68, 114, 19);
		painelFilmeDoProduto.add(precoAluguelFilmeField);

		JLabel generoFilmeLabel = new JLabel("Gênero");
		generoFilmeLabel.setBounds(167, 96, 52, 15);
		painelFilmeDoProduto.add(generoFilmeLabel);

		generoFilmeField = new JTextField();
		generoFilmeField.setEnabled(false);
		generoFilmeField.setColumns(10);
		generoFilmeField.setBounds(286, 94, 114, 19);
		painelFilmeDoProduto.add(generoFilmeField);

		JLabel quantidadeFilmeLabel = new JLabel("Quantidade");
		quantidadeFilmeLabel.setBounds(407, 96, 83, 15);
		painelFilmeDoProduto.add(quantidadeFilmeLabel);

		quantidadeFilmeField = new JTextField();
		quantidadeFilmeField.setEnabled(false);
		quantidadeFilmeField.setColumns(10);
		quantidadeFilmeField.setBounds(530, 94, 114, 19);
		painelFilmeDoProduto.add(quantidadeFilmeField);

		JLabel diretorFilmeLabel = new JLabel("Diretor");
		diretorFilmeLabel.setBounds(167, 122, 52, 15);
		painelFilmeDoProduto.add(diretorFilmeLabel);

		diretorFilmeField = new JTextField();
		diretorFilmeField.setEnabled(false);
		diretorFilmeField.setColumns(10);
		diretorFilmeField.setBounds(286, 125, 114, 19);
		painelFilmeDoProduto.add(diretorFilmeField);

		JPanel painelFimeFoto = new JPanel();
		painelFimeFoto.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelFimeFoto.setLayout(null);
		painelFimeFoto.setBounds(12, 0, 144, 157);
		painelFilmeDoProduto.add(painelFimeFoto);

		JLabel fotoFilmeLabel = new JLabel("Foto");
		fotoFilmeLabel.setBounds(56, 69, 32, 15);
		painelFimeFoto.add(fotoFilmeLabel);

		JButton botaoAdicionarFilme = new JButton("Adicionar");
		botaoAdicionarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaFilme();
				painelFilmeProduto.setVisible(false);
			}
		});
		botaoAdicionarFilme.setBounds(544, 132, 100, 25);
		painelFilmeDoProduto.add(botaoAdicionarFilme);

		botaoCancelarFilme = new JButton("Cancelar");
		botaoCancelarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelFilmeProduto.setVisible(false);
			}
		});
		botaoCancelarFilme.setBounds(436, 132, 96, 25);
		painelFilmeDoProduto.add(botaoCancelarFilme);

		painelJogos = new JPanel();
		tabbedPane.addTab("Jogos", null, painelJogos, null);
		painelJogos.setLayout(new CardLayout(0, 0));

		scrollPaneJogos = new JScrollPane();
		painelJogos.add(scrollPaneJogos, "tabelaJogos");

		tabelaJogos = new JTable();
		tabelaJogos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout card = (CardLayout) (painelJogos.getLayout());
				card.show(painelJogos, "painelJogoProduto");
				setJogo((int) tabelaJogos.getValueAt(
						tabelaJogos.getSelectedRow(), 0));
			}
		});
		tabelaJogos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaJogos.setModel(jogosDefaultModel);
		tabelaJogos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaJogos.getColumnModel().getColumn(1).setPreferredWidth(340);
		tabelaJogos.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaJogos.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPaneJogos.setViewportView(tabelaJogos);

		painelJogoProduto = new JPanel();
		painelJogos.add(painelJogoProduto, "painelJogoProduto");
		painelJogoProduto.setLayout(null);

		JPanel painelJogoDoProduto = new JPanel();
		painelJogoDoProduto.setLayout(null);
		painelJogoDoProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelJogoDoProduto.setBounds(12, 12, 670, 166);
		painelJogoProduto.add(painelJogoDoProduto);

		JLabel nomeJogoLabel = new JLabel("Nome");
		nomeJogoLabel.setBounds(167, 14, 40, 15);
		painelJogoDoProduto.add(nomeJogoLabel);

		nomeJogoField = new JTextField();
		nomeJogoField.setEnabled(false);
		nomeJogoField.setColumns(10);
		nomeJogoField.setBounds(286, 12, 358, 19);
		painelJogoDoProduto.add(nomeJogoField);

		JLabel classificacaoJogoLabel = new JLabel("Classificação");
		classificacaoJogoLabel.setBounds(167, 41, 92, 15);
		painelJogoDoProduto.add(classificacaoJogoLabel);

		classificacaoJogoField = new JTextField();
		classificacaoJogoField.setEnabled(false);
		classificacaoJogoField.setColumns(10);
		classificacaoJogoField.setBounds(286, 36, 114, 19);
		painelJogoDoProduto.add(classificacaoJogoField);

		JLabel precoVendaJogoLabel = new JLabel("Preço Venda");
		precoVendaJogoLabel.setBounds(407, 41, 89, 15);
		painelJogoDoProduto.add(precoVendaJogoLabel);

		precoVendaJogoField = new JTextField();
		precoVendaJogoField.setEnabled(false);
		precoVendaJogoField.setColumns(10);
		precoVendaJogoField.setBounds(530, 36, 114, 19);
		painelJogoDoProduto.add(precoVendaJogoField);

		JLabel lancamentoJogoLabel = new JLabel("Lançamento");
		lancamentoJogoLabel.setBounds(167, 70, 87, 15);
		painelJogoDoProduto.add(lancamentoJogoLabel);
		try {
			lancamentoJogoField = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lancamentoJogoField.setEnabled(false);
		lancamentoJogoField.setColumns(10);
		lancamentoJogoField.setBounds(286, 68, 114, 19);
		painelJogoDoProduto.add(lancamentoJogoField);

		JLabel precoAluguelJogoLabel = new JLabel("Preço Aluguel");
		precoAluguelJogoLabel.setBounds(407, 70, 97, 15);
		painelJogoDoProduto.add(precoAluguelJogoLabel);

		precoAluguelJogoField = new JTextField();
		precoAluguelJogoField.setEnabled(false);
		precoAluguelJogoField.setColumns(10);
		precoAluguelJogoField.setBounds(530, 68, 114, 19);
		painelJogoDoProduto.add(precoAluguelJogoField);

		JLabel generoJogoLabel = new JLabel("Gênero");
		generoJogoLabel.setBounds(167, 96, 52, 15);
		painelJogoDoProduto.add(generoJogoLabel);

		generoJogoField = new JTextField();
		generoJogoField.setEnabled(false);
		generoJogoField.setColumns(10);
		generoJogoField.setBounds(286, 94, 114, 19);
		painelJogoDoProduto.add(generoJogoField);

		JLabel quantidadeJogoLabel = new JLabel("Quantidade");
		quantidadeJogoLabel.setBounds(407, 96, 83, 15);
		painelJogoDoProduto.add(quantidadeJogoLabel);

		quantidadeJogoField = new JTextField();
		quantidadeJogoField.setEnabled(false);
		quantidadeJogoField.setColumns(10);
		quantidadeJogoField.setBounds(530, 94, 114, 19);
		painelJogoDoProduto.add(quantidadeJogoField);

		JLabel desenvolverJogoLabel = new JLabel("Desenvolvedor");
		desenvolverJogoLabel.setBounds(167, 122, 105, 15);
		painelJogoDoProduto.add(desenvolverJogoLabel);

		desenvolvedorJogoField = new JTextField();
		desenvolvedorJogoField.setEnabled(false);
		desenvolvedorJogoField.setColumns(10);
		desenvolvedorJogoField.setBounds(286, 125, 114, 19);
		painelJogoDoProduto.add(desenvolvedorJogoField);

		JPanel painelFotoJogo = new JPanel();
		painelFotoJogo.setLayout(null);
		painelFotoJogo.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelFotoJogo.setBounds(12, 0, 144, 157);
		painelJogoDoProduto.add(painelFotoJogo);

		JLabel fotoJogoLabel = new JLabel("Foto");
		fotoJogoLabel.setBounds(56, 69, 32, 15);
		painelFotoJogo.add(fotoJogoLabel);

		JButton botaoAdicionarJogo = new JButton("Adicionar");
		botaoAdicionarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaJogo();
				painelJogoProduto.setVisible(false);
			}
		});
		botaoAdicionarJogo.setBounds(544, 132, 100, 25);
		painelJogoDoProduto.add(botaoAdicionarJogo);

		JButton botaoCancelarJogo = new JButton("Cancelar");
		botaoCancelarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelJogoProduto.setVisible(false);
			}
		});
		botaoCancelarJogo.setBounds(436, 132, 96, 25);
		painelJogoDoProduto.add(botaoCancelarJogo);

		JPanel painelCarrinho = new JPanel();
		painelCard.add(painelCarrinho, "painelCarrinho");
		painelCarrinho.setLayout(null);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) (painelCard.getLayout());
				card.show(painelCard, "painelTabProdutos");
			}
		});
		botaoVoltar.setBounds(598, 12, 117, 25);
		painelCarrinho.add(botaoVoltar);

		JButton botaoAlugar = new JButton("Alugar");
		botaoAlugar.setBounds(466, 416, 117, 25);
		painelCarrinho.add(botaoAlugar);

		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBounds(598, 416, 117, 25);
		painelCarrinho.add(botaoComprar);

		JScrollPane scrollPaneProdutos = new JScrollPane();
		scrollPaneProdutos.setBounds(12, 54, 703, 238);
		painelCarrinho.add(scrollPaneProdutos);

		tabelaProdutos = new JTable();
		tabelaProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabelaProdutos.getSelectedColumn() == 4) {
					produtosDefaultModel.removeRow(tabelaProdutos
							.getSelectedRow());
				}
			}
		});

		produtosDefaultModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Pre\u00E7o Venda",
						"Pre\u00E7o Aluguel", "Remover" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaProdutos.setModel(produtosDefaultModel);
		tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(320);
		tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
		tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPaneProdutos.setViewportView(tabelaProdutos);

		cupomField = new JTextField();
		cupomField.setBounds(598, 314, 114, 19);
		painelCarrinho.add(cupomField);
		cupomField.setColumns(10);

		JLabel cupomLabel = new JLabel("Cupom");
		cupomLabel.setBounds(550, 316, 48, 15);
		painelCarrinho.add(cupomLabel);

		totalField = new JTextField();
		totalField.setEnabled(false);
		totalField.setBounds(598, 345, 114, 19);
		painelCarrinho.add(totalField);
		totalField.setColumns(10);

		JLabel totalLabel = new JLabel("Total");
		totalLabel.setBounds(556, 347, 36, 15);
		painelCarrinho.add(totalLabel);
	}

	public void listarJogos() {
		jogosDefaultModel.setNumRows(0);

		ArrayList<Jogo> lista = fachada.listaJogo();

		if (!lista.isEmpty()) {
			for (Jogo jogo : lista) {
				Vector vector = new Vector();
				vector.add(jogo.getId());
				vector.add(jogo.getNome());
				vector.add("R$" + jogo.getPrecoVenda());
				vector.add("R$" + jogo.getPrecoAluguel());
				jogosDefaultModel.addRow(vector);
			}
		}

	}

	public void listarFilmes() {
		filmesDefaultModel.setNumRows(0);

		ArrayList<Filme> lista = fachada.listaFilme();

		if (!lista.isEmpty()) {
			for (Filme filme : lista) {
				Vector vector = new Vector();
				vector.add(filme.getId());
				vector.add(filme.getNome());
				vector.add("R$" + filme.getPrecoVenda());
				vector.add("R$" + filme.getPrecoAluguel());
				filmesDefaultModel.addRow(vector);
			}
		}
	}

	public void listarProdutos() {
		produtosDefaultModel.setNumRows(0);

		if (!this.filmes.isEmpty()) {
			for (Filme filme : this.filmes) {
				Vector vector = new Vector();
				vector.add(filme.getId());
				vector.add(filme.getNome());
				vector.add("R$" + filme.getPrecoVenda());
				vector.add("R$" + filme.getPrecoAluguel());
				vector.add("X");
				produtosDefaultModel.addRow(vector);
			}
		}
		if (!this.jogos.isEmpty()) {
			for (Jogo jogo : this.jogos) {
				Vector vector = new Vector();
				vector.add(jogo.getId());
				vector.add(jogo.getNome());
				vector.add("R$" + jogo.getPrecoVenda());
				vector.add("R$" + jogo.getPrecoAluguel());
				vector.add("X");
				produtosDefaultModel.addRow(vector);
			}
		}

	}

	public void setJogo(int id) {
		this.jogo = fachada.procuraJogo(id);
		generoJogoField.setText(jogo.getGenero().getNome());
		nomeJogoField.setText(jogo.getNome());
		desenvolvedorJogoField.setText(jogo.getDesenvolvedor());
		precoVendaJogoField.setText("" + jogo.getPrecoVenda());
		precoAluguelJogoField.setText("" + jogo.getPrecoAluguel());
		classificacaoJogoField.setText(jogo.getClassificacao());
		lancamentoJogoField.setText(jogo.dataFormatada());
		quantidadeJogoField.setText("" + jogo.getQuantidade());
	}

	public void setFilme(int id) {
		this.filme = fachada.procuraFilme(id);
		generoFilmeField.setText(filme.getGenero().getNome());
		nomeFilmeField.setText(filme.getNome());
		diretorFilmeField.setText(filme.getDiretor());
		precoVendaFilmeField.setText("" + filme.getPrecoVenda());
		precoAluguelFilmeField.setText("" + filme.getPrecoAluguel());
		classificacaoFilmeField.setText(filme.getClassificacao());
		lancamentoFilmeField.setText(filme.dataFormatada());
		quantidadeFilmeField.setText("" + filme.getQuantidade());
	}

	public void adicionaFilme() {
		filmes.add(this.filme);
		JOptionPane.showMessageDialog(this, this.filme.getNome()
				+ " adicionado ao carrinho");
	}

	public void adicionaJogo() {
		jogos.add(this.jogo);
		JOptionPane.showMessageDialog(this, this.jogo.getNome()
				+ " adiocionado ao carrinho");
	}
}
