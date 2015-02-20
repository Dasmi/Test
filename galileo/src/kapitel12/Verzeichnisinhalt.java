package kapitel12;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Verzeichnisinhalt {

	private JFrame frame;
	private JTextField textField;
	private DefaultListModel verzeichnisListModel;
	private DefaultListModel dateiListModel;
	private File verzeichnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verzeichnisinhalt window = new Verzeichnisinhalt();
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
	public Verzeichnisinhalt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVerzeichnis = new JLabel("Verzeichnis");
		lblVerzeichnis.setBounds(10, 11, 66, 14);
		frame.getContentPane().add(lblVerzeichnis);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 380, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnInhaltAnzeigen = new JButton("Inhalt anzeigen");
		btnInhaltAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verzeichnisListModel.clear();
				dateiListModel.clear();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Verzeichnisname fehlt");
				}else{
					verzeichnis= new File(textField.getText());
					if(verzeichnis.exists()){
						String[] inhalt = verzeichnis.list();
						for(String eintrag:inhalt){
							File f = new File(verzeichnis,eintrag);
							if(f.isDirectory()){
								verzeichnisListModel.addElement(eintrag);
							}else{
								dateiListModel.addElement(eintrag);
							}							
						}
					}else{
						JOptionPane.showMessageDialog(null, "Verzeichnis existiert.");
					}
				}
			}
		});
		btnInhaltAnzeigen.setBounds(10, 63, 130, 23);
		frame.getContentPane().add(btnInhaltAnzeigen);
		
		JLabel lblVerzeichnisse = new JLabel("Verzeichnisse");
		lblVerzeichnisse.setBounds(10, 97, 86, 14);
		frame.getContentPane().add(lblVerzeichnisse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 196, 75);
		frame.getContentPane().add(scrollPane);
		
		verzeichnisListModel=new DefaultListModel();
		JList list = new JList(verzeichnisListModel);
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(216, 122, 196, 75);
		frame.getContentPane().add(scrollPane_1);
		
		dateiListModel= new DefaultListModel();
		JList list_1 = new JList(dateiListModel);
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblDateien = new JLabel("Dateien");
		lblDateien.setBounds(216, 97, 101, 14);
		frame.getContentPane().add(lblDateien);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(158, 208, 121, 20);
		frame.getContentPane().add(btnEnde);
		
		JButton btnAuswhlen = new JButton("Ausw\u00E4hlen...");
		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int status =fc.showOpenDialog(null);
				if(status==JFileChooser.APPROVE_OPTION){
					File selectionFile = fc.getSelectedFile();
					textField.setText(selectionFile.getPath());
				}
			}
		});
		btnAuswhlen.setBounds(289, 63, 101, 23);
		frame.getContentPane().add(btnAuswhlen);
	}
}
