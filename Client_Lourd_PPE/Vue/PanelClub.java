package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Club;
import controleur.Coach;
import controleur.Controleur;
import controleur.Tableau;

public class PanelClubs extends PanelPrincipal implements ActionListener, KeyListener
{
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtAdresse = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtTel = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btValider = new JButton("Valider"); 
	
	private JTable tableClubs ; 
	private Tableau tableauClubs ; 
	
	private JPanel panelFiltre = new JPanel (); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer= new JButton("Filtrer");
	
	private JButton btSupprimer = new JButton("Supprimer");
	
	private JLabel lbNBClubs = new JLabel(); 
	
	public PanelClubs() {
		super ("Gestion des Clubs");
		
		//Placement du panel formulaire 
		this.panelForm.setBackground(Color.cyan);
		this.panelForm.setBounds(30, 100, 300, 200);
		this.panelForm.setLayout(new GridLayout(5,2));
		this.panelForm.add(new JLabel("Nom Club :")); 
		this.panelForm.add(this.txtNom); 

		
		this.panelForm.add(new JLabel("Adresse postale :")); 
		this.panelForm.add(this.txtAdresse);
		
		this.panelForm.add(new JLabel("Email Club :")); 
		this.panelForm.add(this.txtEmail);
		
		this.panelForm.add(new JLabel("Téléphone Club :")); 
		this.panelForm.add(this.txtTel);

		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btValider); 
		
		this.add(this.panelForm);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btValider.addActionListener(this);
		
		//rendre les champs ecoutables 
		this.txtNom.addKeyListener(this);
		
		this.txtEmail.addKeyListener(this);
		this.txtAdresse.addKeyListener(this);
		this.txtTel.addKeyListener(this);
		
		//installation de la JTable 
		String entetes[] = {"Id Club", "Nom", "Adresse","Email", "Telephone"};
		this.tableauClubs = new Tableau (this.obtenirDonnees(""), entetes); 
		this.tableClubs = new JTable(this.tableauClubs);
		JScrollPane uneScroll = new JScrollPane(this.tableClubs);
		uneScroll.setBounds(360, 100, 480, 250);
		this.add(uneScroll); 
		
		//installation du panel filtre 
		this.panelFiltre.setBackground(Color.cyan);
		this.panelFiltre.setBounds(370, 60, 450, 30);
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les Clubs par : ")); 
		this.panelFiltre.add(this.txtFiltre); 
		this.panelFiltre.add(this.btFiltrer); 
		this.add(this.panelFiltre);
		this.btFiltrer.addActionListener(this);
		
		//installation du bouton supprimer 
		this.btSupprimer.setBounds(80, 340, 140, 30);
		this.add(this.btSupprimer); 
		this.btSupprimer.addActionListener(this);
		this.btSupprimer.setVisible(false);
		this.btSupprimer.setBackground(Color.red);
		
		//installation du compteur 
		this.lbNBClubs.setBounds(450, 380, 400, 20);
		this.add(this.lbNBClubs);
		this.lbNBClubs.setText("Nombre de Clubs : " + this.tableauClubs.getRowCount());
		
		//rendre la Jtable ecoutable sur le click de la souris 
		this.tableClubs.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {		
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = 0;
				if (e.getClickCount() >= 1) {
					numLigne = tableClubs.getSelectedRow(); 
					txtNom.setText(tableauClubs.getValueAt(numLigne, 1).toString());
					
					txtAdresse.setText(tableauClubs.getValueAt(numLigne, 2).toString());
					txtEmail.setText(tableauClubs.getValueAt(numLigne, 3).toString());
					txtTel.setText(tableauClubs.getValueAt(numLigne, 4).toString());
					
					btSupprimer.setVisible(true);
					btValider.setText("Modifier");
				}
			}
		});
		
	}
	public Object [][] obtenirDonnees(String filtre)
	{
		//convertir une ArrayList d'objets de Club en matrice d'elements 
		ArrayList <Club>  lesClubs ; 
		if (filtre.equals("")) {
			lesClubs = Controleur.selectAllClubs();
		}else {
			lesClubs = Controleur.selectLikeClubs(filtre);
		}
		Object matrice[][] = new Object[lesClubs.size()][5];
		int i = 0; 
		for (Club unClub : lesClubs) {
			matrice[i][0] = unClub.getIdClub(); 
			matrice[i][1] = unClub.getNom(); 

			matrice[i][2] = unClub.getAdresse(); 
			matrice[i][3] = unClub.getEmail(); 
			matrice[i][4] = unClub.getTel(); 
			i++;
		}
		return matrice ; 
	}

	public void viderChamps () {
		this.txtNom.setText("");
		this.txtAdresse.setText("");
		this.txtEmail.setText("");
		this.txtTel.setText("");
		btSupprimer.setVisible(false);
		btValider.setText("Valider");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		}
		else if (e.getSource() == this.btFiltrer) {
			//on récupère le filtre
			String filtre = this.txtFiltre.getText(); 
			
			//on actualise les données 
			this.tableauClubs.setDonnees(this.obtenirDonnees(filtre));
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Valider")) {
			this.traitement ();
			this.lbNBClubs.setText("Nombre de Clubs : " + this.tableauClubs.getRowCount());
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Modifier")) {
			// recupérer l'ID Coach 
			int numLigne, idClub ; 
			numLigne = tableClubs.getSelectedRow(); 
			idClub = Integer.parseInt(tableauClubs.getValueAt(numLigne, 0).toString());
			//récupérer les champs de données 
			String nom = this.txtNom.getText(); 
			String adresse = this.txtAdresse.getText();
			String email = this.txtEmail.getText();
			String tel = this.txtTel.getText();
			
			ArrayList<String> lesChamps = new ArrayList<String>(); 
			lesChamps.add(nom); 
			lesChamps.add(adresse);
			lesChamps.add(email);
			lesChamps.add(tel); 
			if (Controleur.verifDonnees(lesChamps)) {
				//instancier un nouveau Club 
				Club unClub = new Club(idClub, nom, adresse, email, tel); 
				//réaliser la modification dans la BDD 
				Controleur.updateClub(unClub);
				//actualiser l'afffichage 
				this.tableauClubs.setDonnees(this.obtenirDonnees(""));
				// message de confirmation 
				JOptionPane.showMessageDialog(this, "Modification réussie du Club.", 
						"Modification Club", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
						"Insertion Club", JOptionPane.ERROR_MESSAGE);
			}
			// vider les champs 
			this.viderChamps();
		}
		else if (e.getSource() == this.btSupprimer) {
			//on récupère l'id Coach 
			int numLigne, idClub ; 
			numLigne = tableClubs.getSelectedRow(); 
			idClub = Integer.parseInt(tableauClubs.getValueAt(numLigne, 0).toString());
			
			//on supprime dans la BDD 
			Controleur.deleteCoach(idClub);
			//on actualise l'affichage 
			this.tableauClubs.setDonnees(this.obtenirDonnees(""));
			this.lbNBClubs.setText("Nombre de Clubs : " + this.tableauClubs.getRowCount());
			
			// confirmation de la suppression réussie 
			JOptionPane.showMessageDialog(this, "Suppression réussie du Coach.", 
					"Suppression Coach", JOptionPane.INFORMATION_MESSAGE);
			
			//vider les champs 
			this.viderChamps();
		}
	}
	private void traitement () {
		//récupérer les données 
		String nom = this.txtNom.getText(); 
		String adresse = this.txtAdresse.getText();
		String email = this.txtEmail.getText();
		String tel = this.txtTel.getText();
		
		ArrayList<String> lesChamps = new ArrayList<String>(); 
		lesChamps.add(nom); 

		lesChamps.add(adresse);
		lesChamps.add(email);
		lesChamps.add(tel); 
		if (Controleur.verifDonnees(lesChamps)) {
			//créer une instance de la classe Coach 
			Club unClub  = new Club(nom, adresse, email, tel);
			
			//Insérer dans la base de données 
			Controleur.insertClub(unClub);
			
			//Afficher message de confirmation 
			JOptionPane.showMessageDialog(this, "Insertion réussie du Club.", 
					"Insertion Club", JOptionPane.INFORMATION_MESSAGE);
			
			//Actualiser l'affichage du tableau Club 
			this.tableauClubs.setDonnees(this.obtenirDonnees(""));
			
		}else {
			JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
					"Insertion Club", JOptionPane.ERROR_MESSAGE);
		}
		//Vider les champs texte 
		this.viderChamps();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.traitement(); 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


















 
