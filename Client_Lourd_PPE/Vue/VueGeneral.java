package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
import controleur.PPE_Lourd_bask;

public class VueGenerale extends JFrame implements ActionListener
{
	private JPanel panelMenu = new JPanel (); 
	
	private JButton btProfil = new JButton("Profil"); 
	private JButton btCoachs = new JButton("Coachs");
	private JButton btClubs = new JButton("Clubs");
	private JButton btExercices = new JButton("Exercices");
	private JButton btRDVs = new JButton("RDVs");
	//private JButton btStats = new JButton("Stats");
	private JButton btQuitter = new JButton("Quitter");
	
	//instances des panels :
	private static PanelProfil unPanelProfil = new PanelProfil(); 
	private static PanelCoachs unPanelCoachs= new PanelCoachs(); 
	private static PanelClubs unPanelClubs = new PanelClubs(); 
	private static PanelExercices unPanelExercices = new PanelExercices(); 
	private static PanelRDVs unPanelRDVs = new PanelRDVs(); 
	//private static PanelStats unPanelStats = new PanelStats(); 
	
	
	public VueGenerale() {
		this.setTitle("Gestion Coaching 2025");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.darkGray);
		this.setLayout(null);
		this.setBounds(50, 50, 1000, 600);
		
		//installation du panel Menu 
		this.panelMenu.setBackground(Color.darkGray);
		this.panelMenu.setBounds(50, 10, 900, 40);
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil); 
		this.panelMenu.add(this.btCoachs);
		this.panelMenu.add(this.btClubs);
		this.panelMenu.add(this.btExercices);
		this.panelMenu.add(this.btRDVs);
		//this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu); 
		
		//rendre les boutons ecoutables 
		this.btProfil.addActionListener(this);
		this.btCoachs.addActionListener(this);
		this.btClubs.addActionListener(this);
		this.btExercices.addActionListener(this);
		this.btRDVs.addActionListener(this);
		//this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		//ajout des panels dans la vue générale 
		this.add(unPanelProfil); 
		this.add(unPanelCoachs); 
		this.add(unPanelClubs); 
		this.add(unPanelExercices); 
		this.add(unPanelRDVs); 
		//this.add(unPanelStats); 
		
		this.setVisible(true);
	}
	
	private void afficherPanel (int choix) {
		unPanelProfil.setVisible(false);
		unPanelCoachs.setVisible(false);
		unPanelClubs.setVisible(false);
		unPanelExercices.setVisible(false);
		unPanelRDVs.setVisible(false);
		//unPanelStats.setVisible(false);
		switch (choix) {
		case 1 : unPanelProfil.setVisible(true); break;
		case 2 : unPanelCoachs.setVisible(true); break;
		case 3 : unPanelClubs.setVisible(true); break;
		case 4 : unPanelExercices.setVisible(true); break;
		case 5 : unPanelRDVs.setVisible(true); break;
		//case 6 : unPanelStats.setVisible(true); break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String choix = e.getActionCommand(); 
		switch(choix) {
		case "Quitter" : 
			//rendre visible la fenetre VueConnexion
			PPE_Lourd_bask.rendreVisibleVueConnexion(true);
			 
			 //detruire la vue generale 
			PPE_Lourd_bask.creerVueGenerale(false);
			 break; 
		case "Profil" : this.afficherPanel(1); break; 
		case "Coachs" : this.afficherPanel(2); break; 
		case "Clubs" : this.afficherPanel(3); break; 
		case "Exercices" : this.afficherPanel(4); break; 
		case "RDVs" : this.afficherPanel(5); break; 
		//case "Stats" : this.afficherPanel(6); break; 
		
		}
	}

}





