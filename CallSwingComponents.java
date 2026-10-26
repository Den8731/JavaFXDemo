package com.cherish.mycrochetdesignplanner;

import javax.swing.*;
import java.awt.*;

public class CallSwingComponents extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    int width,height;
    String setTitleOf;


     CallSwingComponents(int w,int h, String windowTitle){
         this.width = w; //Sets the width for whatever integer value entered
         this.height = h; //Sets the height for whatever integer value entered
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);

         this.setSize(w,h);

         //set title of window
         this.setTitleOf = windowTitle;
         this.setTitle(windowTitle);

         // Initialize the card layout
         cardLayout = new CardLayout();

// Initialize the panel that uses it
         cards = new JPanel(cardLayout);

// Configure the JFrame's layout separately
         setLayout(new BorderLayout());

// Place the card panel in the main window
         add(cards, BorderLayout.CENTER);

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }

    public void addPage(JPanel newPanel, String pageName) {
        cards.add(newPanel, pageName);
    }
    public void showPage(String pageName) {
        cardLayout.show(cards, pageName);
    }

    public void nextPage(JPanel nextPage, String nxtPage){
         cardLayout.next(cards);
    }

    public void previousPage(JPanel prevPage, String lastPage){
         cardLayout.previous(cards);
    }
    public void firstPage() {
        cardLayout.first(cards);
    }

    public void lastPage() {
        cardLayout.last(cards);
    }
}
