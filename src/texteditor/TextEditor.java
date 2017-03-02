package texteditor;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class TextEditor extends JFrame{

  private static final long serialVersionUID = 1L;
  
  private JTextArea text;
  private JScrollPane jScrollPanel;
  private JMenuBar menuBar;
  
  public TextEditor() {
    super("TextEditor");
    
    initUI();
    
    
  }
  
  private void initUI() {
    
    menuBar = new JMenuBar();
    ImageIcon icon = new ImageIcon("exit.png");
    
    JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);

    // exit application button
    JMenuItem exitMI = new JMenuItem("Exit", icon);
    exitMI.setMnemonic(KeyEvent.VK_E);
    exitMI.setToolTipText("Exit application");
    exitMI.addActionListener((ActionEvent event) -> {
        System.exit(0);
    });
    
    file.add(exitMI);

    menuBar.add(file);

    setJMenuBar(menuBar);
    
    
    
    text = new JTextArea(25, 40);
    jScrollPanel = new JScrollPane(text);
    add(jScrollPanel, BorderLayout.CENTER);
    pack();
    
  }
  
  public static void main(String args[]) {
    
    new TextEditor().setVisible(true);
  }

}
