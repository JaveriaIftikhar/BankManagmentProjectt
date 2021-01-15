import java.awt.FlowLayout;

import javax.swing.*;

public class ShowRecord {
	JFrame jf;
	ShowRecord(String outp)
	{
		jf=new JFrame("Detail of All records");
		jf.setLayout(new FlowLayout());
		
		JTextArea textArea = new JTextArea(2, 20);
	    textArea.setText(outp);
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setOpaque(false);
	    textArea.setEditable(false);
	    textArea.setFocusable(false);
	    jf.add(textArea);
		jf.setSize(300,300);
		jf.setVisible(true);
		
		
		
	}
	

}