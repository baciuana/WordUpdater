package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataprocess.ProcessFiles;
import utils.PropertyHandler;
import utils.SwingUtils;


public class MainPanel extends JPanel{
	
	private PropertyHandler propertyHandler = PropertyHandler.getInstance();
	private File importXlsFile, importDocSampleFile;
	private JLabel importXlsFileLabel, importDocSampleFileLabel, destFolderLabel;
	private JButton generateButton;
	private File destinationDir = SwingUtils.createDir("target.dir", "C:\\");
	
	private static final String LABELMARGIN = "  ";
	
	public MainPanel(){
		super();
		
		initGUI();
	}
	
	private void initGUI(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel xlsPanel = new JPanel(null);
		//xlsPanel.setBorder(new TitledBorder("Fisierul XLSX"));
		xlsPanel.setPreferredSize(new Dimension(100, 50));
		add(xlsPanel);
		
		JButton selectFileButton = new JButton("Selectati fisieul XLSX... ");
		selectFileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				fc.setMultiSelectionEnabled(false);
//
//				fc.setDialogTitle("Selectati fisierul XLSX");
//				if (importXlsFile != null) {
//					fc.setCurrentDirectory(importXlsFile);
//				}
//
//				if (fc.showOpenDialog(MainPanel.this) == JFileChooser.APPROVE_OPTION) {
//					setImportXlsfile(fc.getSelectedFile().getAbsolutePath());
//				}
				setImportXlsfile("C:\\Users\\Ana\\Desktop\\ana\\septembrie 2016_test.xls");		
				enableGenerateButton(true);
			}
		});
		selectFileButton.setBounds(30, 15, 140, 21);
		xlsPanel.add(selectFileButton);

		JLabel label = new JLabel("Fisier xlsx: ");
		label.setBounds(180, 15, 100, 21);
		xlsPanel.add(label);

		importXlsFileLabel = new JLabel(" ");
		importXlsFileLabel.setFont(importXlsFileLabel.getFont().deriveFont(java.awt.Font.BOLD));
		importXlsFileLabel.setBounds(250, 15, 350, 21);
		xlsPanel.add(importXlsFileLabel);
		
		JPanel docPanel = new JPanel(null);
		docPanel.setPreferredSize(new Dimension(100, 50));
		add(docPanel);
		
		JButton selectDocFileButton = new JButton("Selectati fisieul DOCX... ");
		selectDocFileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				fc.setMultiSelectionEnabled(false);
//
//				fc.setDialogTitle("Selectati fisierul DOCX");
//				if (importDocSampleFile != null) {
//					fc.setCurrentDirectory(importDocSampleFile);
//				}
//
//				if (fc.showOpenDialog(MainPanel.this) == JFileChooser.APPROVE_OPTION) {
//					setImportDocfile(fc.getSelectedFile().getAbsolutePath());
//				}
				setImportDocfile("C:\\Users\\Ana\\Desktop\\ana\\sample2.docx");			
				enableGenerateButton(true);
			}
		});
		selectDocFileButton.setBounds(30, 15, 140, 21);
		docPanel.add(selectDocFileButton);

		JLabel labelDoc = new JLabel("Fisier docx: ");
		labelDoc.setBounds(180, 15, 100, 21);
		docPanel.add(labelDoc);

		importDocSampleFileLabel = new JLabel(" ");
		importDocSampleFileLabel.setFont(importDocSampleFileLabel.getFont().deriveFont(java.awt.Font.BOLD));
		importDocSampleFileLabel.setBounds(250, 15, 350, 21);
		docPanel.add(importDocSampleFileLabel);
		
		JPanel dirPanel = new JPanel(null);
		dirPanel.setPreferredSize(new Dimension(100, 50));
		add(dirPanel);
		
		JButton dirButton = new JButton("Selectati directorul destinatie ...");
		final JPanel thisPanel = this;
		dirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//				fc.setMultiSelectionEnabled(false);
//				fc.setDialogTitle("Selectati directorul");
//				fc.setCurrentDirectory(destinationDir);
//				if (fc.showOpenDialog(thisPanel) == JFileChooser.APPROVE_OPTION) {
//					destinationDir = fc.getSelectedFile();
//					propertyHandler.setProperty("target.dir", destinationDir.getAbsolutePath());
//					setDestinationFolderLabel(destinationDir.getAbsolutePath());
//					enableGenerateButton(true);
//				}
				destinationDir = new File("C:\\Users\\Ana\\Desktop\\ana");
			}
		});
		dirButton.setBounds(30, 15, 180, 21);
		dirPanel.add(dirButton);
		
		JLabel labelDir = new JLabel("Destinatie: ");
		labelDir.setBounds(220, 15, 100, 21);
		dirPanel.add(labelDir);

		destFolderLabel = new JLabel(" ");
		destFolderLabel.setFont(destFolderLabel.getFont().deriveFont(java.awt.Font.BOLD));
		destFolderLabel.setBounds(280, 15, 350, 21);
		dirPanel.add(destFolderLabel);
		
		
		generateButton = new JButton ("Generare");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessFiles pf = new ProcessFiles(importXlsFile, importDocSampleFile);
				
			}
		});
		add(generateButton);
	}
	
	private boolean setImportXlsfile(String filePath) {
		if (filePath != null) {
			importXlsFile = new File(filePath);
			if (importXlsFile.canRead()) {
				importXlsFileLabel.setText(LABELMARGIN + importXlsFile.getName());
				importXlsFileLabel.repaint();
				return true;
			}

		}
		return false;
	}
	
	private boolean setImportDocfile(String filePath) {
		if (filePath != null) {
			importDocSampleFile = new File(filePath);
			if (importDocSampleFile.canRead()) {
				importDocSampleFileLabel.setText(LABELMARGIN + importDocSampleFile.getName());
				importDocSampleFileLabel.repaint();
				return true;
			}

		}
		return false;
	}
	
	private boolean setDestinationFolderLabel(String filePath) {
		if (filePath != null) {
		
			destFolderLabel.setText(LABELMARGIN + destinationDir.getAbsolutePath());
			destFolderLabel.repaint();
			return true;
			

		}
		return false;
	}
	
	public void enableGenerateButton(boolean enable){
		generateButton.setEnabled(enable && importXlsFile != null && importDocSampleFile != null);
	}

}
