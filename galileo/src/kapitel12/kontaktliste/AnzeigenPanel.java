package kapitel12.kontaktliste;

import javax.swing.JPanel;

public abstract class AnzeigenPanel extends JPanel {
	public abstract void initGui();
	public abstract void setWerte(String[] werte);
	public abstract int getSelectedIndex();
	public abstract void setAnzeigeController(AnzeigeController anzeigeController);
}
