package kapitel12.kontaktliste;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



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
public class Kontaktliste extends javax.swing.JFrame {
	private BearbeitenPanel bearbeitenPanel;
	private DateiController dateiController;
	private AnzeigeController anzeigeController;
	private AnzeigenPanel anzeigePanel;


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Kontaktliste inst = new Kontaktliste();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Kontaktliste() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				bearbeitenPanel = new BearbeitenPanelImp();
				bearbeitenPanel.initGui();
				getContentPane().add(bearbeitenPanel);				
			}
			{
				anzeigePanel = new AnzeigenPanelImp();
				anzeigePanel.initGui();
				getContentPane().add(anzeigePanel);
				
			}
			{
				dateiController=new DateiControllerImp();
			}
			anzeigeController = new AnzeigeControllerImp(anzeigePanel, bearbeitenPanel,dateiController);
			bearbeitenPanel.setAnzeigeController(anzeigeController);
			anzeigePanel.setAnzeigeController(anzeigeController);
			Kontakte kontakte =  dateiController.kontakteLaden();
			anzeigeController.setKontakte(kontakte);
			pack();
			setSize(500, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
