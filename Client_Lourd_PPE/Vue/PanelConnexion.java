package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controleur.Controleur;
 
import controleur.PPE_Lourd_bask;
import controleur.Club;
import controleur.Coach; 

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JTextField txtEmail = new JTextField("a@gmail.com"); 
	private JPasswordField txtMdp = new JPasswordField("123"); 
	
	private JPanel panelForm = new JPanel(); 
	
	public VueConnexion() {
		//changer le titre de la fenetre 
		this.setTitle("Application BSK Gestion Coaching 2025");
		//definir des dimensions de la fenetre 
		this.setBounds(100, 100, 600, 300);
		//fermer et tuer l'application sur le bouton croix 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//changer de couleur de fond de la fenetre 
		this.getContentPane().setBackground(new Color (81, 66, 62));
		//eliminer le quadrillage par de defaut : feuille de style
		this.setLayout(null);
		//desactiver le redimensionnement de la fenetre 
		this.setResizable(false);
		
		//Installation du logo 
		ImageIcon uneImage = new ImageIcon("src/images/hoop_master.png"); 
		JLabel leLogo = new JLabel(uneImage); 
		leLogo.setBounds(20, 20, 250, 250);
		this.add(leLogo); 
		
		//construction du panel Formulaire 
		this.panelForm.setBackground(new Color (81, 66, 62));
		this.panelForm.setLayout(new GridLayout(3,2));
		this.panelForm.setBounds(300, 60, 280, 180);
		this.panelForm.add(new JLabel("Email : ")); 
		this.panelForm.add(this.txtEmail); 
		this.panelForm.add(new JLabel("MDP : ")); 
		this.panelForm.add(this.txtMdp); 
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btSeConnecter); 
		this.add(this.panelForm); 
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//rendre les champs texte ecoutables 
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		//rendre visible la fenetre 
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == this.btAnnuler) {
			 this.txtEmail.setText("");
			 this.txtMdp.setText("");
		 }
		 else if (e.getSource() == this.btSeConnecter) {
			 this.traitement (); 
		 }
	}

	private void traitement () {
		 String email = this.txtEmail.getText(); 
		 String mdp = new String(this.txtMdp.getPassword()); 
		 //Recupération du Club identifié par email et mdp. 
		 Coach unCoach = Controleur.selectWhereCoach(email, mdp);
		 if (unCoach==null) {
		 JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants.");
		 }else {
			 JOptionPane.showMessageDialog(this, "Bienvenue."+unCoach.getNom());
			 
			 //rendre invisible la fenetre VueConnexion
			 PPE_Lourd_bask.rendreVisibleVueConnexion(false);
			 
			 //save de Club 
			 PPE_Lourd_bask.setCoachConnecte(unCoach);
			 
			 //ouvrir la vue generale 
			 PPE_Lourd_bask.creerVueGenerale(true);
			
		 }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
