import java.awt.Container;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calendar extends JFrame implements ActionListener
{
  private static final JTextArea[] monthsArea = new JTextArea[12];

  private static final JButton checkButton = new JButton("Check");
  private static final JTextField yearTextField = new JTextField(6);

  private static Year year = new Year(2013);
  private static String[] monthsArray = year.toString().split("%");

  private static Container total;
  private static JPanel panel;

  public Calendar()
  {
    setTitle("Calendar");
    setResizable(false);

    total = getContentPane();
    total.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.add(yearTextField);
    inputPanel.add(checkButton);
    checkButton.addActionListener(this);
    total.add(inputPanel,BorderLayout.NORTH);

    panel = new JPanel(new GridLayout(3,4,10,10));

    for(int index = 0; index <= 11; index++)
    {
      monthsArea[index] = new JTextArea(3,4);
      monthsArea[index].setText(monthsArray[index]);
      monthsArea[index].setEnabled(false);
      monthsArea[index].setDisabledTextColor(Color.black);
      monthsArea[index].setBackground(Color.white);
      panel.add(monthsArea[index]);
    }//for index


    total.add(panel,BorderLayout.SOUTH);

    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }//constructor

  public void actionPerformed(ActionEvent event)
  {
    year = new Year(Integer.parseInt(yearTextField.getText()));
    monthsArray = year.toString().split("%");

    for(int index = 0; index <= 11; index++)
      monthsArea[index].setText(monthsArray[index]);
    //for index

  }//ActionPerformed

  public static void main(String[] args)
  {
    new Calendar().setVisible(true);
  }//main
}//class
