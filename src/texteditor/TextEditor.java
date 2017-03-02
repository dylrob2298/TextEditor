package texteditor;

import java.awt.BorderLayout;
import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class TextEditor extends JFrame{

  private static final long serialVersionUID = 1L;
  
  private JTextArea text;
  private JScrollPane jScrollPanel;
  private JMenuBar menuBar;
  private String currentFile;
  
  public TextEditor() {
    super("TextEditor");
    
    currentFile = "Untitled";
    
    initUI();
    
    
  }
  
  private void initUI() {
    
    menuBar = new JMenuBar();
    
    JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);
    
    
    // open file button
    JMenuItem openMI = new JMenuItem("Open");
    openMI.setMnemonic(KeyEvent.VK_O);
    openMI.setToolTipText("Open a new .txt file");
    
    
    // save file button
    JMenuItem saveMI = new JMenuItem("Save");
    saveMI.setMnemonic(KeyEvent.VK_S);
    saveMI.setToolTipText("Save this file");
    
    
    // save as file button
    JMenuItem saveAsMI = new JMenuItem("Save as");
    saveAsMI.setMnemonic(KeyEvent.VK_A);
    saveAsMI.setToolTipText("Save this as a new file");
    
    
    // new file button
    JMenuItem newMI = new JMenuItem("New");
    newMI.setMnemonic(KeyEvent.VK_N);
    newMI.setToolTipText("Create a new .txt file");
    

    // exit application button
    JMenuItem exitMI = new JMenuItem("Exit");
    exitMI.setMnemonic(KeyEvent.VK_E);
    exitMI.setToolTipText("Exit application");
    exitMI.addActionListener((ActionEvent event) -> {
        System.exit(0);
    });
    
    
    file.add(openMI);
    file.add(saveMI);
    file.add(saveAsMI);
    file.add(newMI);
    file.add(exitMI);

    menuBar.add(file);

    setJMenuBar(menuBar);
    
    
    
    text = new JTextArea(25, 40);
    jScrollPanel = new JScrollPane(text);
    add(jScrollPanel, BorderLayout.CENTER);
    pack();
    
  }
  
  
  private void loadFile(String filename) {
    
    try {
      FileReader r = new FileReader(filename);
      text.read(r, null);
      r.close();
      currentFile = filename;
      
      
    }
    catch (IOException e) {
      
      
    }
    
    
  }
  
  private void saveFile(String filename) {
    
    try {
      FileWriter w = new FileWriter(filename);
      text.write(w);
      w.close();
      currentFile = filename;
      
      
    }
    
    catch (IOException e) {
      
    }
    
  }
  
  public static void main(String args[]) {
    
    new TextEditor().setVisible(true);
  }

}
