import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;
import javax.swing.*;

public class Loteria extends JFrame {

    private final JButton numericGame = new JButton("Jogo Numérico");
    private final JButton letterGame = new JButton("Jogo de Letras");
    private final JButton parouimparGame = new JButton("Par ou ímpar");
    private final JButton ready = new JButton("Pronto");
    private final JTextField numfield = new JTextField(10);
    private final JLabel numlabel = new JLabel("Digite um número (0 a 100)");
    private final JLabel letterlabel = new JLabel("Digite uma letra (A a Z)");
    private final JLabel parouimparlabel = new JLabel("Escolha Par ou Ímpar");
    private final JLabel titleLotoFacil = new JLabel("LotoFácil");

    private int numEscolhido;
    private boolean isNumericGame = false;
    private boolean isLetterGame = false;
    private boolean isParOuImparGame = false;

    private JPanel initialPanel;

    public Loteria() {
        configurarComponentes();
    }

    private void configurarComponentes() {
        setTitle("LotoFácil");
        setSize(400, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(28, 28, 28));

        titleLotoFacil.setHorizontalAlignment(SwingConstants.CENTER);
        numlabel.setHorizontalAlignment(SwingConstants.CENTER);
        letterlabel.setHorizontalAlignment(SwingConstants.CENTER);
        parouimparlabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLotoFacil.setFont(new Font("Poppins", Font.PLAIN, 20));

        initialPanel = new JPanel();
        initialPanel.setLayout(new GridLayout(4, 1, 20, 20));
        initialPanel.add(titleLotoFacil);
        initialPanel.add(numericGame);
        initialPanel.add(letterGame);
        initialPanel.add(parouimparGame);
        add(initialPanel);

        numericGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNumericGame = true;
                isLetterGame = false;
                isParOuImparGame = false;
                showGamePanel(numlabel);
            }
        });

        letterGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNumericGame = false;
                isLetterGame = true;
                isParOuImparGame = false;
                showGamePanel(letterlabel);
            }
        });

        parouimparGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNumericGame = false;
                isLetterGame = false;
                isParOuImparGame = true;
                showGamePanel(parouimparlabel);
            }
        });

        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGameResult();
            }
        });
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }
        });
    }

    private void fechar() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Confirmar saída?",
                "?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void Resetgame() {
        numfield.setText("");
        remove(getContentPane().getComponent(1));
        initialPanel.setVisible(true);
        revalidate();
    }

    private void showGamePanel(JLabel label) {
        initialPanel.setVisible(false);
        JPanel gamePanel = new JPanel(new GridLayout(4, 1, 10, 10));
        gamePanel.add(label);
        gamePanel.add(numfield);
        gamePanel.add(new JLabel());
        gamePanel.add(ready);
        add(gamePanel);
        revalidate();
    }

    private void handleGameResult() {
        if (isNumericGame) {
            handleNumericGame();
        } else if (isLetterGame) {
            handleLetterGame();
        } else if (isParOuImparGame) {
            handleParOuImparGame();
        }
    }

    private void handleNumericGame() {
        try {
            int inputNumber = Integer.parseInt(numfield.getText());
            Random random = new Random();
            int randomNumber = random.nextInt(100);

            if (inputNumber == randomNumber) {
                JOptionPane.showMessageDialog(this, "Parabéns, você acertou o número sorteado: " + randomNumber);
            } else {
                JOptionPane.showMessageDialog(this, "Que pena, você errou o número sorteado: " + randomNumber);
            }

            Resetgame();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }

    private void handleLetterGame() {
        String inputText = numfield.getText();
        if (inputText.length() != 1 || !Character.isLetter(inputText.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma única letra válida.");
            return;
        }

        char inputChar = inputText.toUpperCase().charAt(0);
        char randomChar = 'J';

        if (inputChar == randomChar) {
            JOptionPane.showMessageDialog(this, "Parabéns, você acertou a letra sorteada: " + randomChar);
        } else {
            JOptionPane.showMessageDialog(this, "Que pena, você errou a letra sorteada: " + randomChar);
        }

        Resetgame();
    }

    private void handleParOuImparGame() {
        try {
            int inputNumber = Integer.parseInt(numfield.getText());

            if (inputNumber % 2 == 0) {
                JOptionPane.showMessageDialog(this, "Parabéns, você acertou! ");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena, você errou! O número sorteado foi par");
            }

            Resetgame();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }

    public static void main(String[] args) {
        Loteria loteria = new Loteria();
        loteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loteria.setVisible(true);
    }
}
