package kapitel12.kontaktliste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
public class BearbeitenPanelImp extends BearbeitenPanel {
	private JLabel vornameLabel;
	private JTextField telefonFeld;
	private JButton uebernehmenButton;
	private JTextField emailFeld;
	private JLabel emailLabel;
	private JLabel telefonLabel;
	private JTextField vornameFeld;
	private JTextField nachnameFeld;
	private JLabel nachnameLabel;
	private AnzeigeController anzeigeController;
	
	@Override
	public void initGui() {
		this.setBounds(0, 0, 500, 119);
		this.setLayout(null);
		{
			nachnameLabel = new JLabel();
			this.add(nachnameLabel);
			nachnameLabel.setText("Nachname:");
			nachnameLabel.setBounds(8, 6, 74, 16);
		}
		{
			nachnameFeld = new JTextField();
			this.add(nachnameFeld);
			nachnameFeld.setBounds(5, 28, 132, 23);
		}
		{
			vornameLabel = new JLabel();
			this.add(vornameLabel);
			vornameLabel.setText("Vorname:");
			vornameLabel.setBounds(145, 6, 68, 16);
		}
		{
			vornameFeld = new JTextField();
			this.add(vornameFeld);
			vornameFeld.setBounds(142, 28, 142, 23);
		}
		{
			telefonLabel = new JLabel();
			this.add(telefonLabel);
			telefonLabel.setText("Telefon:");
			telefonLabel.setBounds(291, 6, 60, 16);
		}
		{
			telefonFeld = new JTextField();
			this.add(telefonFeld);
			telefonFeld.setBounds(289, 28, 194, 23);
		}
		{
			emailLabel = new JLabel();
			this.add(emailLabel);
			emailLabel.setText("Email:");
			emailLabel.setBounds(5, 63, 54, 16);
		}
		{
			emailFeld = new JTextField();
			this.add(emailFeld);
			emailFeld.setBounds(5, 85, 279, 23);
		}
		{
			uebernehmenButton = new JButton();
			this.add(uebernehmenButton);
			uebernehmenButton.setText("Übernehmen >>");
			uebernehmenButton.setBounds(318, 85, 130, 23);
			uebernehmenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					uebernehmenButtonActionPerformed(evt);
				}
			});
		}

	}
	
	public void setAnzeigeController(AnzeigeController anzeigeController){
		this.anzeigeController=anzeigeController;
	}

	@Override
	public String getNachname() {
		return nachnameFeld.getText();
	}


	@Override
	public String getVorname() {
		return vornameFeld.getText();
	}


	@Override
	public String getTelefon() {
		return telefonFeld.getText();
	}


	@Override
	public String getEMail() {
		return emailFeld.getText();
	}
	
	private void uebernehmenButtonActionPerformed(ActionEvent evt) {
		anzeigeController.kontaktUebernehmen();
	}

	@Override
	public void setNachname(String nachname) {
		this.nachnameFeld.setText(nachname);
	}

	@Override
	public void setVorname(String vorname) {
		this.vornameFeld.setText(vorname);
	}

	@Override
	public void setTelefon(String telefon) {
		this.telefonFeld.setText(telefon);
	}

	@Override
	public void setEMail(String eMail) {
		this.emailFeld.setText(eMail);
	}

}
