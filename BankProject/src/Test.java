import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Test
{
    public static void main(String[] a) {
        System.out.print("Enter sentence");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine().toUpperCase(); 
        String[] t = word.split(" ");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String separator = System.lineSeparator(); // decide here the string used to separate your output, you can use "" if you don't want to separate the different parts of the array 't'
                JFrame f = new JFrame ("Output");
                // First solution: use a JTextArea
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false); // you might want to turn off the possibilty to change the text inside the textArea, comment out this line if you don't
                textArea.setFocusable(false); // you might want to turn off the possibility to select the text inside the textArea, comment out this line if you don't
                for (String e : t) if(e.startsWith("A")) textArea.append(e + separator);
                f.add(textArea);
                // Second solution: If you still want to have all the output into a textfield, replace the previous 5 lines of code with the following code :
                // separator = " ";  // in this case don't use a newline to separate the output
                // String text = "";
                // for (String e : t) if(e.startsWith("A")) text += e + separator;
                // f.add(new JTextField(text));
                // f.setSize(300,200);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}