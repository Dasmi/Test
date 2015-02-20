package kapitel12.kontaktliste;

import javax.swing.JPanel;

public abstract class BearbeitenPanel extends JPanel {
	public abstract void initGui();
	public abstract String getNachname();
	public abstract String getVorname();
	public abstract String getTelefon();
	public abstract String getEMail();
	public abstract void setNachname(String nachname);
	public abstract void setVorname(String vorname);
	public abstract void setTelefon(String telefon);
	public abstract void setEMail(String eMail);
	public abstract void setAnzeigeController(AnzeigeController anzeigeController);
}
