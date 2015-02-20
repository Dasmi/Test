package kapitel12.kontaktliste;

public interface Kontakte {
	public void addKontakt(Kontakt kontakt);
	public Kontakt remove(int index);
	public String[] getWerte();
}
