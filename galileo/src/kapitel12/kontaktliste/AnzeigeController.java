package kapitel12.kontaktliste;

public interface AnzeigeController {
	public void kontaktUebernehmen();
	public Kontakt kontaktLoeschen();
	public void beende();
	public void kontaktBearbeiten();
	public void setKontakte(Kontakte kontakte);
}
