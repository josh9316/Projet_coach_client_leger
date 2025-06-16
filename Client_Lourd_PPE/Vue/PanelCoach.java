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

import controleur.Coach;
import controleur.Controleur;
import controleur.Tableau;

public class PanelCoachs extends PanelPrincipal implements ActionListener, KeyListener
{
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField();
	private JTextField txtMdp= new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtQualification = new JTextField();
	private JTextField txtTel = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btValider = new JButton("Valider"); 
	
	private JTable tableCoachs ; 
	private Tableau tableauCoachs ; 
	
	private JPanel panelFiltre = new JPanel (); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer= new JButton("Filtrer");
	
	private JButton btSupprimer = new JButton("Supprimer");
	
	private JLabel lbNBCoachs = new JLabel(); 
	
	public PanelCoachs() {
		super ("Gestion des Coachs");
		
		//Placement du panel formulaire 
		this.panelForm.setBackground(Color.cyan);
		this.panelForm.setBounds(30, 100, 300, 200);
		this.panelForm.setLayout(new GridLayout(7,2));
		this.panelForm.add(new JLabel("Nom Coach :")); 
		this.panelForm.add(this.txtNom); 
		
		this.panelForm.add(new JLabel("Prénom Coach :")); 
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Qualification postale :")); 
		this.panelForm.add(this.txtQualification);
		
		this.panelForm.add(new JLabel("Email Coach :")); 
		this.panelForm.add(this.txtEmail);
		
		this.panelForm.add(new JLabel("Téléphone Coach :")); 
		this.panelForm.add(this.txtTel);
		
		this.panelForm.add(new JLabel("MDP Coach :")); 
		this.panelForm.add(this.txtMdp);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btValider); 
		
		this.add(this.panelForm);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btValider.addActionListener(this);
		
		//rendre les champs ecoutables 
		this.txtNom.addKeyListener(this);
		this.txtPrenom.addKeyListener(this);
		this.txtEmail.addKeyListener(this);
		this.txtQualification.addKeyListener(this);
		this.txtTel.addKeyListener(this);
		
		//installation de la JTable 
		String entetes[] = {"Id Coach", "Nom", "Prenom", "Qualification","Email", "Telephone"};
		this.tableauCoachs = new Tableau (this.obtenirDonnees(""), entetes); 
		this.tableCoachs = new JTable(this.tableauCoachs);
		JScrollPane uneScroll = new JScrollPane(this.tableCoachs);
		uneScroll.setBounds(360, 100, 480, 250);
		this.add(uneScroll); 
		
		//installation du panel filtre 
		this.panelFiltre.setBackground(Color.cyan);
		this.panelFiltre.setBounds(370, 60, 450, 30);
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les Coachs par : ")); 
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
		this.lbNBCoachs.setBounds(450, 380, 400, 20);
		this.add(this.lbNBCoachs);
		this.lbNBCoachs.setText("Nombre de Coachs : " + this.tableauCoachs.getRowCount());
		
		//rendre la Jtable ecoutable sur le click de la souris 
		this.tableCoachs.addMouseListener(new MouseListener() {
			
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
					numLigne = tableCoachs.getSelectedRow(); 
					txtNom.setText(tableauCoachs.getValueAt(numLigne, 1).toString());
					txtPrenom.setText(tableauCoachs.getValueAt(numLigne, 2).toString());
					txtQualification.setText(tableauCoachs.getValueAt(numLigne, 3).toString());
					txtEmail.setText(tableauCoachs.getValueAt(numLigne, 4).toString());
					txtTel.setText(tableauCoachs.getValueAt(numLigne, 5).toString());
					
					btSupprimer.setVisible(true);
					btValider.setText("Modifier");
				}
			}
		});
		
	}
	public Object [][] obtenirDonnees(String filtre)
	{
		//convertir une ArrayList d'objets de Coachs en matrice d'elements 
		ArrayList <Coach>  lesCoachs ; 
		if (filtre.equals("")) {
			lesCoachs = Controleur.selectAllCoachs();
		}else {
			lesCoachs = Controleur.selectLikeCoachs(filtre);
		}
		Object matrice[][] = new Object[lesCoachs.size()][6];
		int i = 0; 
		for (Coach unCoach : lesCoachs) {
			matrice[i][0] = unCoach.getIdCoach(); 
			matrice[i][1] = unCoach.getNom(); 
			matrice[i][2] = unCoach.getPrenom(); 
			matrice[i][3] = unCoach.getQualification(); 
			matrice[i][4] = unCoach.getEmail(); 
			matrice[i][5] = unCoach.getTel(); 
			i++;
		}
		return matrice ; 
	}

	public void viderChamps () {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtQualification.setText("");
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
			this.tableauCoachs.setDonnees(this.obtenirDonnees(filtre));
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Valider")) {
			this.traitement ();
			this.lbNBCoachs.setText("Nombre de Coachs : " + this.tableauCoachs.getRowCount());
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Modifier")) {
			// recupérer l'ID Coach 
			int numLigne, idCoach ; 
			numLigne = tableCoachs.getSelectedRow(); 
			idCoach = Integer.parseInt(tableauCoachs.getValueAt(numLigne, 0).toString());
			//récupérer les champs de données 
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText();
			String qualification = this.txtQualification.getText();
			String email = this.txtEmail.getText();
			String tel = this.txtTel.getText();
			
			ArrayList<String> lesChamps = new ArrayList<String>(); 
			lesChamps.add(nom); 
			lesChamps.add(prenom);
			lesChamps.add(qualification);
			lesChamps.add(email);
			lesChamps.add(tel); 
			if (Controleur.verifDonnees(lesChamps)) {
				//instancier un nouveau Coach 
				Coach unCoach = new Coach(idCoach, nom, prenom, qualification, email,"", tel); 
				//réaliser la modification dans la BDD 
				Controleur.updateCoach(unCoach);
				//actualiser l'afffichage 
				this.tableauCoachs.setDonnees(this.obtenirDonnees(""));
				// message de confirmation 
				JOptionPane.showMessageDialog(this, "Modification réussie du Coach.", 
						"Modification Coach", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
						"Insertion Coach", JOptionPane.ERROR_MESSAGE);
			}
			// vider les champs 
			this.viderChamps();
		}
		else if (e.getSource() == this.btSupprimer) {
			//on récupère l'id Coach 
			int numLigne, idCoach ; 
			numLigne = tableCoachs.getSelectedRow(); 
			idCoach = Integer.parseInt(tableauCoachs.getValueAt(numLigne, 0).toString());
			
			//on supprime dans la BDD 
			Controleur.deleteCoach(idCoach);
			//on actualise l'affichage 
			this.tableauCoachs.setDonnees(this.obtenirDonnees(""));
			this.lbNBCoachs.setText("Nombre de Coachs : " + this.tableauCoachs.getRowCount());
			
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
		String prenom = this.txtPrenom.getText();
		String qualification = this.txtQualification.getText();
		String email = this.txtEmail.getText();
		String tel = this.txtTel.getText();
		
		ArrayList<String> lesChamps = new ArrayList<String>(); 
		lesChamps.add(nom); 
		lesChamps.add(prenom);
		lesChamps.add(qualification);
		lesChamps.add(email);
		lesChamps.add(tel); 
		if (Controleur.verifDonnees(lesChamps)) {
			//créer une instance de la classe Coach 
			Coach unCoach  = new Coach(nom, prenom, qualification, email, "", tel);
			
			//Insérer dans la base de données 
			Controleur.insertCoach(unCoach);
			
			//Afficher message de confirmation 
			JOptionPane.showMessageDialog(this, "Insertion réussie du Coach.", 
					"Insertion Coach", JOptionPane.INFORMATION_MESSAGE);
			
			//Actualiser l'affichage du tableau Coachs 
			this.tableauCoachs.setDonnees(this.obtenirDonnees(""));
			
		}else {
			JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
					"Insertion Coach", JOptionPane.ERROR_MESSAGE);
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


















 
