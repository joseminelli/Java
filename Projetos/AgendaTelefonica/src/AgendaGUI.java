import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class AgendaGUI extends JFrame implements ActionListener, WindowListener {
    private final JButton btnCadastrar;
    private final JButton btnExcluir;
    private final JList<String> lstPessoas;
    private final DefaultListModel<String> model;
    private final JScrollPane scroll;
    private final ArrayList<Pessoa> agendaArr;

    public AgendaGUI(ArrayList<Pessoa> agendaArr) {
        super("Agenda de Pessoas");
        toFront();
        setLocationRelativeTo(null);
        this.agendaArr = agendaArr;
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnCadastrar = new JButton("Cadastrar Pessoa");
        btnExcluir = new JButton("Excluir Pessoa");

        model = new DefaultListModel<>();
        lstPessoas = new JList<>(model);
        scroll = new JScrollPane(lstPessoas);
        scroll.setPreferredSize(new Dimension(380, 200));


        add(btnCadastrar);
        add(btnExcluir);
        add(scroll);

        btnCadastrar.addActionListener(this);
        btnExcluir.addActionListener(this);

        addWindowListener(this);
        setVisible(true);

        ListarPessoa(agendaArr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            try {
                CadastrarPessoa(agendaArr);
                ListarPessoa(agendaArr);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar pessoa: " + ex.getMessage());
            }
        } else if (e.getSource() == btnExcluir) {
            try {
                ExcluirPessoa(agendaArr);
                ListarPessoa(agendaArr);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir pessoa: " + ex.getMessage());
            }
        }
    }

    public void ListarPessoa(ArrayList<Pessoa> agendaArr) {
        model.clear();
        for (Pessoa contato : agendaArr) {
            model.addElement(contato.getNome() + " / " + contato.getTel());
        }
    }

    public void ExcluirPessoa(ArrayList<Pessoa> agendaArr) {
        int i;
        try {
            i = lstPessoas.getSelectedIndex();
            if (i != -1) {
                JOptionPane.showMessageDialog(this, "Contato excluído: " + agendaArr.get(i).getNome());
                agendaArr.remove(i);
            } else if ( agendaArr.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Selecione um contato para excluir.");
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Erro: posição inválida (" + e.getMessage() + ").");
        }
    }

    public void CadastrarPessoa(ArrayList<Pessoa> agendaArr) {
        int i;
        int novapessoa;
        try {
            i = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição a ser inserida (0 pra cancelar): "));
            i--; // ajuste de posição
            if (i != -1) {
                String nome = JOptionPane.showInputDialog("Informe o nome da pessoa: ");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade da pessoa: "));
                String tel = JOptionPane.showInputDialog("Informe o telefone da pessoa: ");
                agendaArr.add(i, new Pessoa(nome, idade, tel));
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Erro: posição inválida (" + e.getMessage() + ").");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
