import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    private JPanel mainPanel, topPanel, selectPanel, quitScorePanel;
    private JLabel title;
    private ImageIcon rockIcon, paperIcon, scissorIcon;
    private JButton rockButton, paperButton, scissorButton;
    private JButton quitButton;
    private JTextField playerWinsTF, computerWinsTF, tiesTF;
    private JTextArea gameResults;
    private JScrollPane scroll;
    private ActionListener quit = new QuitListener();
    private ActionListener rockSelection = new RockListener();
    private ActionListener paperSelection = new PaperListener();
    private ActionListener scissorsSelection = new ScissorsListener();
    private int playerWinsNum, computerWinsNum, tiesNum;
    private String playerWinsStr, computerWinsStr, tiesStr;

    Random rnd = new Random();

    public RockPaperScissorsFrame()
    {
        setTitle("Rock Paper Scissors Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        topPanel = new JPanel();
        selectPanel = new JPanel();
        quitScorePanel = new JPanel();

        title = new JLabel("Welcome to Rock Paper Scissors");
        rockIcon = new ImageIcon("src/rock.png");
        paperIcon = new ImageIcon("src/paper.png");
        scissorIcon = new ImageIcon("src/scissors.png");

        Image rockImage = rockIcon.getImage();
        Image rocknewIMG = rockImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon((rocknewIMG));

        Image paperImage = paperIcon.getImage();
        Image papernewIMG = paperImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon((papernewIMG));

        Image scissorImage = scissorIcon.getImage();
        Image scissornewIMG = scissorImage.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        scissorIcon = new ImageIcon((scissornewIMG));

        rockButton = new JButton("Rock", rockIcon);
        rockButton.addActionListener(rockSelection);
        paperButton = new JButton("Paper", paperIcon);
        paperButton.addActionListener(paperSelection);
        scissorButton = new JButton("Scissors", scissorIcon);
        scissorButton.addActionListener(scissorsSelection);

        playerWinsTF = new JTextField("Player Wins: "+ playerWinsNum);
        playerWinsTF.setEditable(false);
        computerWinsTF = new JTextField("Computer Wins: " + computerWinsNum);
        computerWinsTF.setEditable(false);
        tiesTF = new JTextField("Ties: " + tiesNum);
        tiesTF.setEditable(false);

        gameResults = new JTextArea(6,30);
        scroll = new JScrollPane(gameResults);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout(0,75));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new GridLayout(1,2));
        mainPanel.add(selectPanel, BorderLayout.CENTER);
        selectPanel.setLayout(new GridLayout(2,3,100,50));
        mainPanel.add(quitScorePanel, BorderLayout.SOUTH);
        quitScorePanel.setLayout(new GridLayout(2,1));

        // Top
        topPanel.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        // Select
        selectPanel.add(rockButton);
        rockButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        rockButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(paperButton);
        paperButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        paperButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(scissorButton);
        scissorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        scissorButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        selectPanel.add(playerWinsTF);
        playerWinsTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        selectPanel.add(computerWinsTF);
        computerWinsTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        selectPanel.add(tiesTF);
        tiesTF.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        // Bottom/Quit
        quitScorePanel.add(scroll);
        gameResults.setFont(new Font("Times New Roman", Font.BOLD, 25));
        quitScorePanel.add(quitButton);
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
    }

    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }

    private class RockListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked rock, the computer picked rock. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
            else if (compMove == 1)//paper
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked rock, the computer picked paper. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
            else if (compMove == 2)//scissors
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked rock, the computer picked scissors. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
        }
    }
    private class PaperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked paper, the computer picked rock. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
            else if (compMove == 1)//paper
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked paper, the computer picked paper. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
            else if (compMove == 2)//scissors
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked paper, the computer picked scissors. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
        }
    }
    private class ScissorsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int compMove = rnd.nextInt(3); //0 is rock, 1 is paper, 2 is scissors
            if (compMove == 0)//rock
            {
                computerWinsNum++;
                computerWinsStr = String.valueOf(computerWinsNum);
                gameResults.append("You picked scissors, the computer picked rock. The computer won!\n");
                computerWinsTF.setText("Computer Wins: " + computerWinsStr);
            }
            else if (compMove == 1)//paper
            {
                playerWinsNum++;
                playerWinsStr = String.valueOf(playerWinsNum);
                gameResults.append("You picked scissors, the computer picked paper. You won!\n");
                playerWinsTF.setText("Player Wins: " + playerWinsStr);
            }
            else if (compMove == 2)//scissors
            {
                tiesNum++;
                tiesStr = String.valueOf(tiesNum);
                gameResults.append("You picked scissors, the computer picked scissors. You tied with the computer!\n");
                tiesTF.setText("Ties: " + tiesStr);
            }
        }
    }
}
