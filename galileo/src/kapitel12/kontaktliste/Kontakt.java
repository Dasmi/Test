package kapitel12.kontaktliste;

public interface Kontakt {
	public void setNachname(String nachname);
	public void setVorname(String vorname);
	public void setTelefon(String telefon);
	public void setEmail(String eMail);
	public String getNachname();
	public String getVorname();
	public String getTelefon();
	public String getEmail();
	public String toString();
	public void parseString(String kontaktString);
}
