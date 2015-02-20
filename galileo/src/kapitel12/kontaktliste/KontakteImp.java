package kapitel12.kontaktliste;

import java.util.ArrayList;

public class KontakteImp implements Kontakte {
	private ArrayList<Kontakt> kontakte;
	
	public KontakteImp(){
		kontakte = new ArrayList<Kontakt>();
	}
	
	@Override
	public void addKontakt(Kontakt kontakt) {
		kontakte.add(kontakt);

	}

	@Override
	public String[] getWerte() {
		String[] werte= new String[kontakte.size()];
		for(int i=0;i<kontakte.size();i++){
			werte[i] = kontakte.get(i).toString();
		}
		return werte;
	}

	@Override
	public Kontakt remove(int index) {
		Kontakt geloeschter= kontakte.get(index);
		kontakte.remove(index);
		return geloeschter;
	}

}
