import javax.swing.*;
import java.awt.*;

public class ButtonDemo extends JPanel {
    private int count = 0;
    JTextArea resetMessage = new JTextArea(3, 20);;
    JTextField textField = new JTextField(10);

    public ButtonDemo(){

            this.add(this.createButton());
            this.add(resetMessage);
            this.add(textField);
            this.add(this.reset());

            resetMessage.setEditable(false);
            resetMessage.setLineWrap(true);
            resetMessage.setWrapStyleWord(true);

        resetMessage.setEditable(false); //Makes the text box read only. Allows for no manual user input from keyboard
        createButton().addActionListener(e -> {

        });
    }
    public JButton createButton() {

        JButton button = new JButton("Button Click");
        int count[] = {0};
        int increment = 1;

        button.addActionListener(e -> {
            count[0]+=increment;
            textField.setText("Updated by Button!");
            System.out.println("New value: " + textField.getText());
            textField.setText(String.valueOf(count[0]));
            System.out.println(count[0]);
            incrementCount(); //Only works when place in this action listener
        });

        return button;
    }
    public void incrementCount() {
        count++;

        textField.setText(String.valueOf(count));

        if (count % 10 == 0) {
            resetMessage.setText("Your new total is " + count);
        } else {
            resetMessage.setText("No new milestones reached " + count);
        }

    }

    //Reset the options displayed back to 0 to start over again
    public JButton reset () {
        JButton resetToZero = new JButton("Reset");
        resetToZero.addActionListener(event -> {
            count = 0;
            textField.setText(String.valueOf(count));
        });
        return resetToZero;
    }
}
