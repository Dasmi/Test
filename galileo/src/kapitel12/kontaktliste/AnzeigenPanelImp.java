package kapitel12.kontaktliste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AnzeigenPanelImp extends AnzeigenPanel{
	private JLabel kontaktlisteLabel;
	private JButton bearbeitenButton;
	private JButton endeButton;
	private JList<String> kontaktliste;
	private JScrollPane scrollPane;
	private JButton loescheButton;
	private AnzeigeController anzeigeController;
		
	@Override
	public void initGui(){
		anzeigeController = anzeigeController;
		this.setBounds(0, 125, 500, 136);
		this.setLayout(null);
		{
			kontaktlisteLabel = new JLabel();
			this.add(kontaktlisteLabel);
			kontaktlisteLabel.setText("Kontaktliste:");
			kontaktlisteLabel.setBounds(12, 5, 75, 16);
		}
		{
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(11,26,470,77);
			{
				kontaktliste = new JList();
				kontaktliste.setBounds(12, 27, 467, 74);
				kontaktliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
			this.add(scrollPane);				
		}
		{
			loescheButton=new JButton();
			this.add(loescheButton);
			loescheButton.setText("markierten Eintrag löschen");
			loescheButton.setBounds(11, 106, 190, 23);
			loescheButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					loescheButtonActionPerformed(evt);
				}
			});
		}
		{
			endeButton = new JButton();
			this.add(endeButton);
			endeButton.setText("Ende");
			endeButton.setBounds(400, 106, 80, 23);
			endeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					endeButtonActionPerformed(evt);
				}
			});
		}
		{
			bearbeitenButton = new JButton();
			this.add(bearbeitenButton);
			bearbeitenButton.setText("Bearbeiten");
			bearbeitenButton.setBounds(247, 109, 120, 23);
			bearbeitenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					bearbeitenButtonActionPerformed(evt);
				}
			});
		}
	}

	@Override
	public void setWerte(String[] werte) {
		int selecteterIndex = getSelectedIndex();
		scrollPane.setViewportView(kontaktliste);
		kontaktliste.setModel(new DefaultComboBoxModel<String>(werte));
		if(selecteterIndex<0||selecteterIndex>=werte.length){
			selecteterIndex=0;
		}
		kontaktliste.setSelectedIndex(selecteterIndex);
	}

	@Override
	public int getSelectedIndex() {
		return kontaktliste.getSelectedIndex();
	}
	private void loescheButtonActionPerformed(ActionEvent evt) {
		anzeigeController.kontaktLoeschen();
	}

	@Override
	public void setAnzeigeController(AnzeigeController anzeigeController) {
		this.anzeigeController = anzeigeController;
	}
	
	private void endeButtonActionPerformed(ActionEvent evt) {
		anzeigeController.beende();
	}
	
	private void bearbeitenButtonActionPerformed(ActionEvent evt) {
		anzeigeController.kontaktBearbeiten();
	}
}
