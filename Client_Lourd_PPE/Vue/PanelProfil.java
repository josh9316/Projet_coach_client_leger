package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.PPE_Lourd_bask;
import controleur.Club;
import controleur.Coach;

public class PanelProfil extends PanelPrincipal implements ActionListener {
	private JTextArea txtInfos = new JTextArea(); 
	private Coach unCoach; 
	private JButton btModifier = new JButton("Modifier Profil"); 
	
	private JPanel panelForm = new JPanel(); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField();
	private JTextField txtQualification = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtTel = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btValider = new JButton("Valider");
	
	public PanelProfil() {
		super("Gestion du Profil"); 
		
		this.panelForm.setBackground(Color.cyan);
		this.panelForm.setBounds(400, 100, 400, 250);
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.setVisible(false);
		
		this.panelForm.add(new JLabel("Nom Club : "));
		this.panelForm.add(this.txtNom); 
		
		this.panelForm.add(new JLabel("Prénom Club : "));
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Adresse : "));
		this.panelForm.add(this.txtQualification);
		
		this.panelForm.add(new JLabel("Email Club : "));
		this.panelForm.add(this.txtEmail);
		
		this.panelForm.add(new JLabel("Téléphone Club : "));
		this.panelForm.add(this.txtTel);
		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btValider);
		
		this.add(this.panelForm); 
		
		this.txtInfos.setBounds(50, 100, 300, 240);
		unCoach = PPE_Lourd_bask.getCoachConnecte(); 
		
		this.txtInfos.setBackground(Color.cyan);
		this.txtInfos.setEditable(false);
		
		this.txtInfos.setText(
			  "________________INFOS PROFIL _____________\n\n"
			+ " Nom Club : " + unCoach.getNom() + "\n\n"
			+ " Prénom Club : " + unCoach.getPrenom() + "\n\n"
			+ " Qualification : " + unCoach.getQualification() + "\n\n"
			+ " Email Club : " + unCoach.getEmail() + "\n\n"
			+ " Téléphone Club : " + unCoach.getTel() + "\n\n"
			+ "__________________________________________"
		);
		this.add(this.txtInfos); 
		
		this.btModifier.setBounds(100, 360, 200, 40);
		this.add(this.btModifier);
		
		this.btAnnuler.addActionListener(this);
		this.btValider.addActionListener(this);
		this.btModifier.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btModifier) {
			this.txtNom.setText(unCoach.getNom());
			this.txtPrenom.setText(unCoach.getPrenom());
			this.txtQualification.setText(unCoach.getQualification());
			this.txtEmail.setText(unCoach.getEmail());
			this.txtTel.setText(unCoach.getTel());
			this.panelForm.setVisible(true);
		}
		else if (e.getSource() == this.btAnnuler) {
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtQualification.setText("");
			this.txtEmail.setText("");
			this.txtTel.setText("");
			this.panelForm.setVisible(false);
		}
		else if (e.getSource() == this.btValider) {
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText();
			String qualification = this.txtQualification.getText();
			String email = this.txtEmail.getText();
			String tel = this.txtTel.getText();
			
			ArrayList<String> lesChamps = new ArrayList<>();
			lesChamps.add(nom);
			lesChamps.add(prenom);
			lesChamps.add(qualification);
			lesChamps.add(email);
			lesChamps.add(tel);
			
			if (Controleur.verifDonnees(lesChamps)) {
				unCoach.setNom(nom);
				unCoach.setPrenom(prenom);
				unCoach.setQualification(qualification);
				unCoach.setEmail(email);
				unCoach.setTel(tel);
				
				Controleur.updateCoach(unCoach);
				PPE_Lourd_bask.setCoachConnecte(unCoach);
				
				JOptionPane.showMessageDialog(this, "Modification des données réussie", "Modification", JOptionPane.OK_OPTION);
				
				this.txtInfos.setText(
						  "________________INFOS PROFIL _____________\n\n"
						+ " Nom Club : " + unCoach.getNom() + "\n\n"
						+ " Prénom Club : " + unCoach.getPrenom() + "\n\n"
						+ " Qualification : " + unCoach.getQualification() + "\n\n"
						+ " Email Club : " + unCoach.getEmail() + "\n\n"
						+ " Téléphone Club : " + unCoach.getTel() + "\n\n"
						+ "__________________________________________"
					);
			} else {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtQualification.setText("");
			this.txtEmail.setText("");
			this.txtTel.setText("");
			this.panelForm.setVisible(false);
		}
	}
}
