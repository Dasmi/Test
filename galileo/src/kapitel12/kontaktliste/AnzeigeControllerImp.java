package kapitel12.kontaktliste;

public class AnzeigeControllerImp implements AnzeigeController {
	private AnzeigenPanel anzeigePanel;
	private BearbeitenPanel bearbeitenPanel;
	private Kontakte kontakte = new KontakteImp();
	private DateiController dateiController;

	public AnzeigeControllerImp(AnzeigenPanel anzeigePanel,
			BearbeitenPanel bearbeitenPanel,DateiController dateiController) {
		this.anzeigePanel = anzeigePanel;
		this.bearbeitenPanel = bearbeitenPanel;
		this.dateiController=dateiController;
	}

	@Override
	public void kontaktUebernehmen() {
		Kontakt neuerKontakt = new KontaktImp();
		neuerKontakt.setNachname(bearbeitenPanel.getNachname());
		neuerKontakt.setVorname(bearbeitenPanel.getVorname());
		neuerKontakt.setTelefon(bearbeitenPanel.getTelefon());
		neuerKontakt.setEmail(bearbeitenPanel.getEMail());
		kontakte.addKontakt(neuerKontakt);
		anzeigePanel.setWerte(kontakte.getWerte());

	}

	@Override
	public Kontakt kontaktLoeschen() {
		Kontakt rueckgabe = null;
		int index = anzeigePanel.getSelectedIndex();
		if (index >= 0) {
			rueckgabe = kontakte.remove(index);
			anzeigePanel.setWerte(kontakte.getWerte());
		}
		return rueckgabe;
	}

	@Override
	public void beende() {
		dateiController.kontakteSpeichern(kontakte);
		System.exit(0);
	}

	@Override
	public void kontaktBearbeiten() {
		Kontakt zuBearbeitender = kontaktLoeschen();
		if (zuBearbeitender != null) {
			bearbeitenPanel.setNachname(zuBearbeitender.getNachname());
			bearbeitenPanel.setVorname(zuBearbeitender.getVorname());
			bearbeitenPanel.setTelefon(zuBearbeitender.getTelefon());
			zuBearbeitender.setEmail(zuBearbeitender.getEmail());
			
		}

	}

	@Override
	public void setKontakte(Kontakte kontakte) {
		this.kontakte=kontakte;
		anzeigePanel.setWerte(kontakte.getWerte());
	}

}
