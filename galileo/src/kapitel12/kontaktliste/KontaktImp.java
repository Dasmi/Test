package kapitel12.kontaktliste;

public class KontaktImp implements Kontakt {
	String nachname;
	String vorname;
	String telefon;
	String  email;
	@Override
	public String getNachname() {
		return nachname;
	}
	@Override
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	@Override
	public String getVorname() {
		return vorname;
	}
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	@Override
	public String getTelefon() {
		return telefon;
	}
	@Override
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString(){
		return nachname+";"+vorname+";"+telefon+";"+email;
	}
	@Override
	public void parseString(String kontaktString) {
		String[] kontaktArray = new String[4];
		getEinzeleStrings(kontaktString,kontaktArray,0);
		setNachname(kontaktArray[0]);
		setVorname(kontaktArray[1]);
		setTelefon(kontaktArray[2]);
		setEmail(kontaktArray[3]);
	}
	public void getEinzeleStrings(String kontaktString,String[] array,int pos){
		int i = kontaktString.indexOf(";");
		if(i>=0){
			array[pos]=kontaktString.substring(0, i);
			getEinzeleStrings(kontaktString.substring(i+1,kontaktString.length()),array,pos+1);
		}else{
			if(i<0){
				array[pos]=kontaktString;
			}
		}
		
	}
	

}
