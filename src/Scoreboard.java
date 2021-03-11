import javax.swing.*;
import java.awt.*;

abstract class Scoreboard {
    JLabel p1Label;
    JLabel p2Label;
    JLabel gameStatusLabel;

    Player p1;
    Player p2;

    public void updateScores() {
        p1Label.setText("Player 1 score: " + p1.getPlayerScore());
        p2Label.setText("Player 2 score: " + p2.getPlayerScore());
    }
    public void rotateTurn(Player current) {
        if (current == p1) {
            p1Label.setBackground(Color.decode("#fc0303"));
            gameStatusLabel.setText("Current player: Player 1");
            p2Label.setBackground(Color.WHITE);
        } else {
            p2Label.setBackground(Color.decode("#fc0303"));
            gameStatusLabel.setText("Current player: Player 2");
            p1Label.setBackground(Color.WHITE);
        }
    };

    public void declareWinner(Player winner) {
        if (winner == p1) {
            gameStatusLabel.setText("Game over! Player 1 wins!");
            p1Label.setBackground(Color.decode("#56CBF9"));
            p2Label.setBackground(Color.WHITE);
        } else {
            gameStatusLabel.setText("Game over! Player 2 wins!");
            p1Label.setBackground(Color.WHITE);
            p2Label.setBackground(Color.decode("#fc0303"));
        }
    }

    public void declareWinner() {
        gameStatusLabel.setText("Game over! Its a draw!");
        p1Label.setBackground(Color.WHITE);
        p2Label.setBackground(Color.WHITE);
    }
    
	
	public Player switchPlayers(Player currentPlayer) {
		if(currentPlayer == p1) {
			return p2;
		}
		else {
			rotateTurn(currentPlayer);
			return p1;
		}
		
	}
}
