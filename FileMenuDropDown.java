import javax.swing.*;
import java.awt.*;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class FileMenuDropDown extends JFrame implements ActionListener {

    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu viewMenu = new JMenu("View");
    JMenu helpMenu = new JMenu("Help");
    JMenu toolsMenu = new JMenu("Tools");

    String[] options = {
            "New Project",
            "Open Project",
            "Save"
    };

    FileMenuDropDown() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        menuBar.add(toolsMenu);

        this.setJMenuBar(menuBar);

        // Add the dropdown items to File
        ItemsList(fileMenu);

        fileMenu.addActionListener(this);

        this.setLayout(new BorderLayout());

        // Make the window visible after setup
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JMenu ItemsList(JMenu menu) {

        for (int scanList = 0;
             scanList < options.length;
             scanList++) {

            JMenuItem selectItems =
                    new JMenuItem(options[scanList]);
            if (options[scanList].equals("New Project")) {
                selectItems.addActionListener(e -> OpenNewProject());
            }
                if(options[scanList].equals("Open Project")) {
                    selectItems.addActionListener(event -> OpenNewWindow());
                }
                    if (options[scanList].equals("Save")){
                        selectItems.addActionListener(event ->ItemsSaved());


            }

            menu.add(selectItems);
        }

        return menu;
    }
public void OpenNewProject(){
    System.out.println("New Project created!");
}
public void OpenNewWindow(){
    OpenedWindow newWindow = new OpenedWindow();
}
public void ItemsSaved(){
    System.out.println("Items saved");
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fileMenu){
            OpenNewProject();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileMenuDropDown::new);
    }
}