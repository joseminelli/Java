import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class JogadorGUI extends JFrame implements ActionListener, WindowListener {

    private final JButton votarBtn;
    private final JButton apurarBtn;
    private final ArrayList<Jogador> jogadores;


    public JogadorGUI(ArrayList<Jogador> jogadores){
        super("Votação BBB");
        toFront();
        setLocationRelativeTo(null);
        setSize(400, 300);
        setLayout(new FlowLayout());
        this.jogadores = jogadores;

        votarBtn = new JButton("Votar");
        apurarBtn = new JButton("Apurar");

        add(votarBtn);
        add(apurarBtn);

        addWindowListener(this);
        setVisible(true);

        votarBtn.addActionListener(this);
        apurarBtn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == votarBtn) {
            try {
                Votar(jogadores);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao votar: " + ex.getMessage());
            }
        } else if (e.getSource() == apurarBtn) {
            try {
                Apurar(jogadores);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao apurar: " + ex.getMessage());
            }
        }
    }

    protected void Votar(ArrayList<Jogador> jogadores){
        String escolhido = "null";
            escolhido = JOptionPane.showInputDialog("Digite o nome da pessoa escolhida:");

            if(!escolhido.equals("null")) {
                for (Jogador player : jogadores) {
                    if (player.getNome().toLowerCase().equals(escolhido.toLowerCase())) {
                        player.incrementaUmVoto();
                    }
                }
            }
    }

    protected void Apurar(ArrayList<Jogador> jogadores){
        Jogador maisvotado = new Jogador("null");
        for(Jogador player : jogadores){
            if (player.getVotos() > maisvotado.getVotos()){
                maisvotado = player;
            }
        }
        if(maisvotado.getNome().equals("null")){
            JOptionPane.showMessageDialog(this, "Não aconteceu uma votação");
        } else {
            JOptionPane.showMessageDialog(this, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                    "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                    "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                    "vou conseguir te eliminar com alegria. Com " + maisvotado.getVotos() + " votos, é você quem sai\n" +
                    maisvotado.getNome());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
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
