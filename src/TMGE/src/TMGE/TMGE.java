package TMGE;

import javax.swing.*;
import java.awt.*;

public class TMGE {
	private static TMGE tmge_instance = null;
    JFrame mainFrame;
    JPanel scorePanel;
    JPanel tilePanel;
    JButton tiles[][];
    int TILE_HEIGHT;
    int TILE_WIDTH;

    public JButton[][] getTilesInterface() {
        return tiles;
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }

    public static TMGE getInstance(int WIDTH, int HEIGHT, String TITLE) {
    	if(tmge_instance == null) {
    		tmge_instance = new TMGE(WIDTH,HEIGHT,TITLE);
    	}
    	return tmge_instance;
    }
    
    public TMGE (int WIDTH, int HEIGHT, String TITLE) {
        TILE_HEIGHT = HEIGHT;
        TILE_WIDTH = WIDTH;

        mainFrame = new JFrame(TITLE);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 700);

        scorePanel = new JPanel();

        tilePanel = new JPanel();
        tiles = new JButton[TILE_HEIGHT][TILE_WIDTH];
        for (int i = 0 ; i < TILE_HEIGHT ; i++) {
            for (int j = 0 ; j < TILE_WIDTH ; j++) {
                tiles[i][j] = new JButton();
                tiles[i][j].setBorderPainted(false);
                tiles[i][j].setContentAreaFilled(true);
                tiles[i][j].setOpaque(true);
                tiles[i][j].setBackground(Color.GRAY);
                tilePanel.add(tiles[i][j]);
            }
        }

        tilePanel.setLayout(new GridLayout(TILE_HEIGHT, TILE_WIDTH, 5,5));
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainFrame.add(tilePanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }
}