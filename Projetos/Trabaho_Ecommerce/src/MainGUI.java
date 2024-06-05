import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.List;
import java.text.NumberFormat;

public class MainGUI {
    File file = new File();
    private JFrame frame;
    private Cliente cliente = file.ReadJson("src/clientes.json", Cliente.class);
    private Estoque estoque = new Estoque();
    private List<Produto> produtos = estoque.getProdutos();
    private Carrinho carrinho;
    private Color BgColor = new Color(38, 38, 38);
    private Color ButtonColor = new Color(100, 100, 100);
    private Color TextAreaColor = new Color(78, 78, 78);

    public MainGUI() {
        Cliente cliente = file.ReadJson("src/clientes.json", Cliente.class);

        do {
            if (cliente == null) {
                cliente = NovoCliente();
            }
        } while (cliente == null);
        carrinho = new Carrinho(cliente);

        initialize();
    }

    private static Cliente NovoCliente() {
        Cliente cliente;
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String email = JOptionPane.showInputDialog("Digite o email do cliente:");
        String rua = JOptionPane.showInputDialog("Digite a rua do endereço do cliente:");
        String cidade = JOptionPane.showInputDialog("Digite a cidade do endereço do cliente:");
        String cep = JOptionPane.showInputDialog("Digite o CEP do endereço do cliente:");
        if (nome == null || email == null || rua == null || cidade == null || cep == null) {
            return null;
        }
        cliente = Cliente.CadastrarClienteGUI(nome, email, rua, cidade, cep);
        return cliente;
    }

    private void initialize() {
        Font Montserrat = loadCustomFont("Montserrat.ttf");
        setUIFont(new FontUIResource(Montserrat));
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
          System.err.println(ex);
        }
        frame = new JFrame("Retro Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(BgColor);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));
        frame.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBackground(BgColor);

        ImageIcon icon = new ImageIcon("src/logo.png");
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        JLabel imgLabel = new JLabel(resizedIcon);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.add(imgLabel, BorderLayout.NORTH);

        JButton btnVerProdutos = createButton("Ver Todos os Produtos", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutosGUI();
            }
        });

        JButton btnVerCarrinho = createButton("Ver Carrinho", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCarrinhoGUI();
            }
        });

        JButton btnSuaConta = createButton("Sua Conta", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaMenu();
            }
        });
        JButton btnGerenciarProdutos = createButton("Gerenciar Produtos", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirInterfaceGerenciarProdutos();
            }
        });

        JButton btnSair = createButton("Sair", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.add(imgLabel);
        mainPanel.add(btnVerProdutos);
        mainPanel.add(btnVerCarrinho);
        mainPanel.add(btnSuaConta);
        mainPanel.add(btnGerenciarProdutos);
        mainPanel.add(btnSair);

        frame.setVisible(true);
    }
    private static Font loadCustomFont(String path) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT,  File.CreateFile(path)).deriveFont(Font.PLAIN, 12);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 12);
        }
    }

    private static void setUIFont(FontUIResource font) {
        UIDefaults defaults = UIManager.getDefaults();
        for (Object key : defaults.keySet()) {
            if (defaults.get(key) instanceof FontUIResource) {
                defaults.put(key, font);
            }
        }
    }

    private void adicionarNovoProduto() {
        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        String precoStr = JOptionPane.showInputDialog("Digite o preço do produto:");
        double preco = Double.parseDouble(precoStr);
        String[] categorias = {"Blusa", "Vinil"};
        String categoria = (String) JOptionPane.showInputDialog(
                null,
                "Escolha a categoria do produto:",
                "Categoria",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias,
                categorias[0]);

        String cor = JOptionPane.showInputDialog("Digite a cor da blusa/banda:");
        String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade em estoque:");
        int quantidade = Integer.parseInt(quantidadeStr);
        Estoque.addprodutoGUI(nome, preco, categoria, quantidade, cor);
    }


    private JButton createButton(String text, ActionListener actionListener) {
        BotaoRedondo button = new BotaoRedondo(text);
        button.setFont(new Font("Montserrat", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(ButtonColor);
        button.setForeground(Color.white);
        button.addActionListener(actionListener);
        return button;
    }



    private void abrirInterfaceGerenciarProdutos() {
        JFrame gerenciarFrame = new JFrame("Gerenciar Produtos");
        gerenciarFrame.setSize(450, 600);
        gerenciarFrame.getContentPane().setBackground(BgColor);
        gerenciarFrame.setLayout(new BorderLayout());
        gerenciarFrame.setLocationRelativeTo(null);

        JLabel TituloLabel = new JLabel("Gerenciar Produtos");
        TituloLabel.setForeground(Color.WHITE);
        TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        TituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        gerenciarFrame.add(TituloLabel, BorderLayout.NORTH);

        DefaultListModel<Produto> listModel = new DefaultListModel<>();
        for (Produto produto : produtos) {
            listModel.addElement(produto);
        }
        JList<Produto> productList = new JList<>(listModel);
        productList.setBackground(TextAreaColor);
        productList.setForeground(Color.WHITE);
        productList.setSelectionBackground(Color.GRAY);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton btnAdd = createButton("Adicionar Produto", e -> {
            adicionarNovoProduto();
            UpdateProdutosList(productList, listModel, true);
        });

        JButton btnRemover = createButton("Remover Produto", e -> {
            Produto produtoSelecionado = productList.getSelectedValue();
            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(gerenciarFrame, "Selecione um produto para remover.");
                return;
            }
            Estoque.removerProduto(produtoSelecionado.getId());
            UpdateProdutosList(productList, listModel, false);
        });

        JButton btnVoltar = createButton("Voltar", e -> gerenciarFrame.dispose());

        JPanel buttonPanel = new JPanel(new BorderLayout());

        buttonPanel.setBackground(BgColor);
        buttonPanel.add(btnAdd, BorderLayout.WEST);
        buttonPanel.add(btnVoltar, BorderLayout.SOUTH);
        buttonPanel.add(btnRemover, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        gerenciarFrame.add(scrollPane, BorderLayout.CENTER);
        gerenciarFrame.add(buttonPanel, BorderLayout.SOUTH);

        gerenciarFrame.setVisible(true);
    }


    private void UpdateProdutosList(JList<Produto> productList, DefaultListModel<Produto> listModel, boolean isAdding) {
        if (isAdding) {
            listModel.addElement(estoque.getProdutos().get(estoque.getProdutos().size() - 1));
        } else {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    private void ContaMenu() {
        JFrame contaFrame = new JFrame("Sua Conta");
        contaFrame.setSize(450, 600);
        contaFrame.getContentPane().setBackground(BgColor);
        contaFrame.setLayout(new BorderLayout());
        contaFrame.setLocationRelativeTo(null);

        JLabel TituloLabel = new JLabel("Sua Conta");
        TituloLabel.setForeground(Color.WHITE);
        TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        TituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        contaFrame.add(TituloLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(TextAreaColor);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        UpdateTextAreaPerfil(textArea);

        JButton btnEditar = createButton("Editar Informações", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente = NovoCliente();
                UpdateTextAreaPerfil(textArea);
            }
        });
        JButton btnListarVendas = createButton("Ver Histórico", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarVendasGUI();
            }
        });

        JButton btnVoltar = createButton("Voltar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contaFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());

        buttonPanel.setBackground(BgColor);
        buttonPanel.add(btnListarVendas, BorderLayout.WEST);
        buttonPanel.add(btnVoltar, BorderLayout.SOUTH);
        buttonPanel.add(btnEditar, BorderLayout.EAST);

        contaFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        contaFrame.add(buttonPanel, BorderLayout.SOUTH);

        contaFrame.setVisible(true);
    }

    private void UpdateTextAreaPerfil(JTextArea textArea) {
        textArea.setText("");
        textArea.append("Nome: " + cliente.getNome() + "\n");
        textArea.append("Email: " + cliente.getEmail() + "\n");
        textArea.append("Endereço: " + cliente.getEnderecoString() + "\n");
    }
    private void listarVendasGUI() {
        ListarVendasGUI();
    }

    private void listarProdutosGUI() {
        JFrame listarProdutosFrame = new JFrame("Todos os Produtos");
        listarProdutosFrame.setSize(450, 600);
        listarProdutosFrame.getContentPane().setBackground(BgColor);
        listarProdutosFrame.setLayout(new BorderLayout());
        listarProdutosFrame.setLocationRelativeTo(null);

        JLabel TituloLabel = new JLabel("Produtos Disponíveis");
        TituloLabel.setForeground(Color.WHITE);
        TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        TituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        listarProdutosFrame.add(TituloLabel, BorderLayout.NORTH);

        DefaultListModel<Produto> listModel = new DefaultListModel<>();
        for (Produto produto : produtos) {
            listModel.addElement(produto);
        }
        JList<Produto> productList = new JList<>(listModel);
        productList.setBackground(TextAreaColor);
        productList.setSelectionBackground(Color.GRAY);
        productList.setForeground(Color.WHITE);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listarProdutosFrame.add(new JScrollPane(productList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(BgColor);

        JButton btnAdicionar = createButton("Add ao Carrinho", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produtoSelecionado = productList.getSelectedValue();
                if (produtoSelecionado != null) {
                    if(!carrinho.adicionarItem(new ItemVenda(produtoSelecionado, 1)))
                        return;
                    JOptionPane.showMessageDialog(listarProdutosFrame, "Produto adicionado ao carrinho: " + produtoSelecionado.getNome());
                } else {
                    JOptionPane.showMessageDialog(listarProdutosFrame, "Selecione um produto para adicionar ao carrinho.");
                }
            }
        });

        JButton btnVoltar = createButton("Voltar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutosFrame.dispose();
            }
        });
        buttonPanel.add(btnVoltar, BorderLayout.WEST);
        buttonPanel.add(btnAdicionar, BorderLayout.EAST);

        listarProdutosFrame.add(buttonPanel, BorderLayout.SOUTH);

        listarProdutosFrame.setVisible(true);
    }

    private void ListarVendasGUI() {
        JFrame listarVendasFrame = new JFrame("Vendas");
        listarVendasFrame.setSize(450, 600);
        listarVendasFrame.getContentPane().setBackground(BgColor);
        listarVendasFrame.setLayout(new BorderLayout());
        listarVendasFrame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(TextAreaColor);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.append("Vendas do Cliente:\n");
        for (Venda venda : Venda.getVendas()) {
            textArea.append(venda.VendaToString() + "\n");
        }

        JButton btnVoltar = createButton("Voltar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarVendasFrame.dispose();
            }
        });

        listarVendasFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        listarVendasFrame.add(btnVoltar, BorderLayout.SOUTH);

        listarVendasFrame.setVisible(true);
    }


    private void listarCarrinhoGUI() {
        JFrame listarCarrinhoFrame = new JFrame("Carrinho");
        listarCarrinhoFrame.setSize(450, 600);
        listarCarrinhoFrame.getContentPane().setBackground(BgColor);
        listarCarrinhoFrame.setLayout(new BorderLayout());
        listarCarrinhoFrame.setLocationRelativeTo(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (ItemVenda item : carrinho.getItens()) {
            listModel.addElement(item.ItemVendaToString());
        }
        JList<String> itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setBackground(TextAreaColor);
        itemList.setSelectionBackground(Color.GRAY);
        itemList.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(BgColor);

        JLabel carrinhoLabel = new JLabel("Carrinho Vazio");
        carrinhoLabel.setForeground(Color.WHITE);
        carrinhoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carrinhoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        carrinhoLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Adiciona um espaçamento ao redor do texto

        listarCarrinhoFrame.add(carrinhoLabel, BorderLayout.NORTH);


        JButton btnRemover = createButton("Remover do Carrinho", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                    carrinho.removerItem(carrinho.getItens().get(selectedIndex));
                    JOptionPane.showMessageDialog(listarCarrinhoFrame, "Item removido do carrinho.");
                } else {
                    JOptionPane.showMessageDialog(listarCarrinhoFrame, "Selecione um item para remover do carrinho.");
                }
            }
        });
        JButton btnFinalizarCompra = createButton("Finalizar Compra", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(carrinho.getItens().isEmpty()){
                    JOptionPane.showMessageDialog(listarCarrinhoFrame, "Carrinho vazio. Adicione produtos para finalizar a compra.");
                    return;
                }
                FinalizarCompraGUI();
                listarCarrinhoFrame.dispose();
            }
        });
        JButton btnVoltar = createButton("Voltar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCarrinhoFrame.dispose();
            }
        });

        buttonPanel.setBackground(BgColor);
        buttonPanel.add(btnVoltar, BorderLayout.SOUTH);
        buttonPanel.add(btnFinalizarCompra, BorderLayout.WEST);
        buttonPanel.add(btnRemover, BorderLayout.EAST);

        if (!carrinho.getItens().isEmpty()) {
            carrinhoLabel.setText(carrinho.getQuantidadeItens() +" iten(s) no carrinho");
        }

        listarCarrinhoFrame.add(new JScrollPane(itemList), BorderLayout.CENTER);
        listarCarrinhoFrame.add(buttonPanel, BorderLayout.SOUTH);

        listarCarrinhoFrame.setVisible(true);
    }


    private void FinalizarCompraGUI() {
        JFrame finalizarCompraFrame = new JFrame("Finalizar Compra");
        finalizarCompraFrame.setSize(450, 600);
        finalizarCompraFrame.getContentPane().setBackground(BgColor);
        finalizarCompraFrame.setLayout(new BorderLayout());
        finalizarCompraFrame.setLocationRelativeTo(null);

        JLabel TituloLabel = new JLabel("Método de pagamento");
        TituloLabel.setForeground(Color.WHITE);
        TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        TituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        finalizarCompraFrame.add(TituloLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BgColor);

        JButton btnCartao = createButton("Cartão de Crédito", e -> {
            finalizarCompraFrame.dispose();
            exibirDetalhesCompra("Cartão de Crédito");
        });
        JButton btnBoleto = createButton("Boleto", e -> {
            finalizarCompraFrame.dispose();
            exibirDetalhesCompra("Boleto");
        });
        JButton btnPix = createButton("Pix", e -> {
            finalizarCompraFrame.dispose();
            exibirDetalhesCompra("Pix");
        });
        JButton btnCancelar = createButton("Cancelar", e -> finalizarCompraFrame.dispose());

        buttonPanel.add(btnCartao);
        buttonPanel.add(btnBoleto);
        buttonPanel.add(btnPix);
        buttonPanel.add(btnCancelar);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 20, 0));
        finalizarCompraFrame.add(buttonPanel, BorderLayout.CENTER);

        finalizarCompraFrame.setVisible(true);
    }

    private void exibirDetalhesCompra(String formaPagamento) {
        JFrame detalhesCompraFrame = new JFrame("Detalhes da Compra");
        detalhesCompraFrame.setSize(450, 600);
        detalhesCompraFrame.setBackground(BgColor);
        detalhesCompraFrame.setLayout(new BorderLayout(10, 10));
        detalhesCompraFrame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(TextAreaColor);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.append("Pedido total de: " + NumberFormat.getCurrencyInstance().format(carrinho.calcularTotal()) + "\n\n");
        textArea.append("Detalhes da compra:\n");
        for (ItemVenda item : carrinho.getItens()) {
            textArea.append(item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s) - " +
                    NumberFormat.getCurrencyInstance().format(item.getSubtotal()) + " (" +
                    NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco()) + " cada)\n");
        }
        textArea.append("\nForma de pagamento: " + formaPagamento + "\n\n");
        if (cliente != null) {
            textArea.append("Detalhes da entrega:\n");
            textArea.append("Cliente: " + cliente.getNome() + "\n");
            textArea.append("Endereço: " + cliente.getEndereco().getRua() + ", " +
                    cliente.getEndereco().getCidade() + " - " + cliente.getEndereco().getCep() + "\n");
        } else {
            textArea.append("Detalhes da entrega: Cliente não cadastrado.\n");
        }

        JButton btnFinalizarCompra = createButton("Finalizar Compra", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrinho.Finalizar();
                carrinho.limparCarrinho();
                JOptionPane.showMessageDialog(detalhesCompraFrame, "Compra finalizada com sucesso!");
                detalhesCompraFrame.dispose();
            }
        });
        JButton btnVoltar = createButton("Voltar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detalhesCompraFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BgColor);
        buttonPanel.add(btnFinalizarCompra);
        buttonPanel.add(btnVoltar);

        detalhesCompraFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        detalhesCompraFrame.add(buttonPanel, BorderLayout.SOUTH);
        detalhesCompraFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
