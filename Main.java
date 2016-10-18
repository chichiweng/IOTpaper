package Map;
import javax.swing.*;
import java.awt.Color;

public class Main extends JFrame {
   private JComponent gp;

   public Main() {
      super("Original map");
      this.setBounds(0, 0, 775, 710);
      this.setPanel();
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void setPanel() {
      TestTree tree = new TestTree();
      this.gp = tree;
      gp.setBackground(new Color(117, 62, 171));
      this.setContentPane(gp);
   }

   public static void main(String[] args) {
      new Main();
   }
}