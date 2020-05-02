package com.t2s.staying.home.T2S.StayingHome.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class EditDocument {
	 
	 private JButton btnLoadButton;
	 private JFrame frame;    
	 JFrame parentFrame = new JFrame();
	 
	 JFileChooser jFileChooser = new JFileChooser();
	 StringBuilder sb = new StringBuilder();
	 private JTextField textArea;
	 private JButton btnSave;
	

	 private void openFile(String fileName) {
			try {
				FileReader reader = new FileReader(fileName);
				textArea.read(reader, null);
				reader.close();
			}
			catch(IOException e) {
				JOptionPane.showMessageDialog(btnLoadButton, this,"File" + fileName + "can't be opened.", 0);
			}
		}
	 
	 
	 
	  private void saveFile(String fileName) {
			try {
				FileWriter writer = new FileWriter(fileName);
				textArea.write(writer);
				writer.close();
			}
			catch(IOException e) {
	                    	JOptionPane.showMessageDialog(btnSave, this,"File" + fileName + "can't be saved.", 0);

			}
		}
	 
	 
	public  void EditDoc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDocument window = new EditDocument();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditDocument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnLoadButton = new JButton("Load");
		btnLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialog = new JFileChooser();
			       if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			            openFile(dialog.getSelectedFile().getAbsolutePath());
				
			       }
		
			}
		});
		btnLoadButton.setBounds(26, 103, 89, 23);
		frame.getContentPane().add(btnLoadButton);
		
		textArea = new JTextField();
		textArea.setBounds(151, 38, 476, 468);
		frame.getContentPane().add(textArea);
		textArea.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Text Area");
		lblNewLabel.setBounds(331, 13, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialog = new JFileChooser();
			       if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			            saveFile(dialog.getSelectedFile().getAbsolutePath());
			        }
			}
		});
		btnSave.setBounds(26, 158, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.setBounds(26, 212, 89, 23);
		frame.getContentPane().add(btnConvert);
		
		JButton btnConvertealine = new JButton("Convert a line");
		btnConvertealine.setBounds(26, 396, 99, 23);
		frame.getContentPane().add(btnConvertealine);
		
		
		
	}
}

/*public void actionPerformed(ActionEvent e) {
String	cn = textChooseN.getText()	.toString();
String  an = textAuthorsN.getText().toString();
String  ta = textArea.getText()	.toString();

try {
	FileWriter writer = new FileWriter("chris.txt",true);
	writer.write(cn);
	writer.write(System.getProperty("line.separator"));
	writer.write(an);
	writer.write(System.getProperty("line.separator"));
	writer.write(ta);
	writer.write(System.getProperty("line.separator"));
	writer.close();
	JOptionPane.showMessageDialog(getRootPane(), "Success");
	
	
} catch(Exception e1) {
	
	JOptionPane.showMessageDialog(getRootPane(), "Error");
	
}

JFileChooser fc=new JFileChooser();
				fc.showSaveDialog(null);
				File f=fc.getSelectedFile()	;
				try {
					FileWriter fw=new FileWriter(f);
					String text =textArea.getText();
					fw.write(text);
					fw.close();
			    }
				catch(IOException e1){
					System.out.println(e1);
				}

} */