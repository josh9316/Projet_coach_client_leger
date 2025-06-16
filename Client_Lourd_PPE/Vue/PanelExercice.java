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
import controleur.Exercice;
import controleur.Tableau;

public class PanelExercices extends PanelPrincipal implements ActionListener, KeyListener
{
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtDate = new JTextField();
	private JTextField txtTemps = new JTextField();
	private JTextField txtDifficulte = new JTextField();
	private JTextField txtIdClub = new JTextField();

	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btValider = new JButton("Valider"); 
	
	private JTable tableExercices ; 
	private Tableau tableauExercices ; 
	
	private JPanel panelFiltre = new JPanel (); 
	private JTextField txtFiltre = new JTextField(); 
	private JButton btFiltrer= new JButton("Filtrer");
	
	private JButton btSupprimer = new JButton("Supprimer");
	
	private JLabel lbNBExercices = new JLabel(); 
	
	public PanelExercices() {
		super ("Gestion des Exercices");
		
		//Placement du panel formulaire 
		this.panelForm.setBackground(Color.cyan);
		this.panelForm.setBounds(30, 100, 300, 200);
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("nom Exercice :")); 
		this.panelForm.add(this.txtNom); 

		
		this.panelForm.add(new JLabel("date Exercice :")); 
		this.panelForm.add(this.txtDate);
		
		this.panelForm.add(new JLabel("temps Exercice :")); 
		this.panelForm.add(this.txtTemps);
		
		this.panelForm.add(new JLabel("difficulte Exercice :")); 
		this.panelForm.add(this.txtDifficulte);

		this.panelForm.add(new JLabel("id Club :")); 
		this.panelForm.add(this.txtIdClub);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btValider); 
		
		this.add(this.panelForm);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btValider.addActionListener(this);
		
		//rendre les champs ecoutables 
		this.txtNom.addKeyListener(this);
		
		this.txtTemps.addKeyListener(this);
		this.txtDate.addKeyListener(this);
		this.txtDifficulte.addKeyListener(this);
		
		
		//installation de la JTable 
		String entetes[] = {"Id Exercice", "Nom", "Temps","Date", "Difficulte",  "IdClub"};
		this.tableauExercices = new Tableau (this.obtenirDonnees(""), entetes); 
		this.tableExercices = new JTable(this.tableauExercices);
		JScrollPane uneScroll = new JScrollPane(this.tableExercices);
		uneScroll.setBounds(360, 100, 480, 250);
		this.add(uneScroll); 
		
		//installation du panel filtre 
		this.panelFiltre.setBackground(Color.cyan);
		this.panelFiltre.setBounds(370, 60, 450, 30);
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les Exercices par : ")); 
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
		this.lbNBExercices.setBounds(450, 380, 400, 20);
		this.add(this.lbNBExercices);
		this.lbNBExercices.setText("Nombre de Exercices : " + this.tableauExercices.getRowCount());
		
		//rendre la Jtable ecoutable sur le click de la souris 
		this.tableExercices.addMouseListener(new MouseListener() {
			
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
					numLigne = tableExercices.getSelectedRow(); 
					txtNom.setText(tableauExercices.getValueAt(numLigne, 1).toString());
					
					txtDate.setText(tableauExercices.getValueAt(numLigne, 2).toString());
					txtTemps.setText(tableauExercices.getValueAt(numLigne, 3).toString());
					txtDifficulte.setText(tableauExercices.getValueAt(numLigne, 4).toString());
					txtIdClub.setText(tableauExercices.getValueAt(numLigne, 5).toString());

					btSupprimer.setVisible(true);
					btValider.setText("Modifier");
				}
			}
		});
		
	}
	public Object [][] obtenirDonnees(String filtre)
	{
		//convertir une ArrayList d'objets de Exercice en matrice d'elements 
		ArrayList <Exercice>  lesExercices ; 
		if (filtre.equals("")) {
			lesExercices = Controleur.selectAllExercices();
		}else {
			lesExercices = Controleur.selectLikeExercices(filtre);
		}
		Object matrice[][] = new Object[lesExercices.size()][6];
		int i = 0; 
		for (Exercice unExercice : lesExercices) {
			matrice[i][0] = unExercice.getIdexo(); 
			matrice[i][1] = unExercice.getNom(); 

			matrice[i][2] = unExercice.getDateExo(); 
			matrice[i][3] = unExercice.getTempsExo(); 
			matrice[i][4] = unExercice.getDifficulteExo(); 
			matrice[i][5] = unExercice.getIdclub(); 

			i++;
		}
		return matrice ; 
	}

	public void viderChamps () {
		this.txtNom.setText("");
		this.txtDate.setText("");
		this.txtTemps.setText("");
		this.txtDifficulte.setText("");
		this.txtIdClub.setText("");
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
			this.tableauExercices.setDonnees(this.obtenirDonnees(filtre));
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Valider")) {
			this.traitement ();
			this.lbNBExercices.setText("Nombre de Exercices : " + this.tableauExercices.getRowCount());
		}
		else if (e.getSource() == this.btValider && this.btValider.getText().equals("Modifier")) {
			// recupérer l'ID Exercice 
			int numLigne, idExercice ; 
			numLigne = tableExercices.getSelectedRow(); 
			idExercice = Integer.parseInt(tableauExercices.getValueAt(numLigne, 0).toString());
			//récupérer les champs de données 
			String nom = this.txtNom.getText(); 
			String date = this.txtDate.getText();
			int temps =  Integer.parseInt(this.txtTemps.getText());
			String difficulte = this.txtDifficulte.getText();
			int idclub =  Integer.parseInt(this.txtIdClub.getText());
			ArrayList<String> lesChamps = new ArrayList<String>(); 
			lesChamps.add(nom); 
			lesChamps.add(date);
		 
			lesChamps.add(difficulte);
			if (Controleur.verifDonnees(lesChamps)) {
				//instancier un nouveau Exercice 
				Exercice unExercice = new Exercice(idExercice, nom, date, temps, difficulte, idclub); 
				//réaliser la modification dans la BDD 
				Controleur.updateExercice(unExercice);
				//actualiser l'afffichage 
				this.tableauExercices.setDonnees(this.obtenirDonnees(""));
				// message de confirmation 
				JOptionPane.showMessageDialog(this, "Modification réussie de l'Exercice.", 
						"Modification Exercice", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
						"Insertion Exercice", JOptionPane.ERROR_MESSAGE);
			}
			// vider les champs 
			this.viderChamps();
		}
		else if (e.getSource() == this.btSupprimer) {
			//on récupère l'id Coach 
			int numLigne, idClub ; 
			numLigne = tableExercices.getSelectedRow(); 
			idClub = Integer.parseInt(tableauExercices.getValueAt(numLigne, 0).toString());
			
			//on supprime dans la BDD 
			Controleur.deleteExercice(idClub);
			//on actualise l'affichage 
			this.tableauExercices.setDonnees(this.obtenirDonnees(""));
			this.lbNBExercices.setText("Nombre de Exercices : " + this.tableauExercices.getRowCount());
			
			// confirmation de la suppression réussie 
			JOptionPane.showMessageDialog(this, "Suppression réussie de l' Exercice.", 
					"Suppression Exercice", JOptionPane.INFORMATION_MESSAGE);
			
			//vider les champs 
			this.viderChamps();
		}
	}
	private void traitement () {
		//récupérer les données 
		String nom = this.txtNom.getText(); 
		String date = this.txtDate.getText();
		int temps = Integer.parseInt(this.txtTemps.getText());
		String difficulte = this.txtDifficulte.getText();
		int idclub = Integer.parseInt(this.txtIdClub.getText());
		ArrayList<String> lesChamps = new ArrayList<String>(); 
		lesChamps.add(nom); 

		lesChamps.add(date);
		 
		lesChamps.add(difficulte); 
		if (Controleur.verifDonnees(lesChamps)) {
			//créer une instance de la classe Exercice 
			Exercice unExercice  = new Exercice( nom, date, temps, difficulte, idclub);
			
			//Insérer dans la base de données 
			Controleur.insertExercice(unExercice);
			
			//Afficher message de confirmation 
			JOptionPane.showMessageDialog(this, "Insertion réussie de l' Exercice.", 
					"Insertion Exercice", JOptionPane.INFORMATION_MESSAGE);
			
			//Actualiser l'affichage du tableau Exercice 
			this.tableauExercices.setDonnees(this.obtenirDonnees(""));
			
		}else {
			JOptionPane.showMessageDialog(this, "Veuillez remplir les champs.", 
					"Insertion Exercice", JOptionPane.ERROR_MESSAGE);
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


















 
