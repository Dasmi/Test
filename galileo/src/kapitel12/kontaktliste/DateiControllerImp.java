package kapitel12.kontaktliste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DateiControllerImp implements DateiController {

	private String pfad;

	public DateiControllerImp() {
		pfad = "." + File.separator + "kontakte.dat";
	}

	@Override
	public void kontakteSpeichern(Kontakte kontakte) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(pfad));
			for (String kontakt : kontakte.getWerte()) {
				out.write(kontakt);
				out.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Kontakte kontakteLaden() {
		Kontakte kontakte = new KontakteImp();
		File file = new File(pfad);
		BufferedReader in = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String zeile;
			try {
				in = new BufferedReader(new FileReader(file));
				while((zeile=in.readLine())!=null){
					Kontakt kontakt = new KontaktImp();
					kontakt.parseString(zeile);
					kontakte.addKontakt(kontakt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(in !=null){
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return kontakte;
	}
}
