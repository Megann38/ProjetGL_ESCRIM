package colis.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//importation adaptation mac
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.TableColumn;


public class AllPackages extends JFrame implements MouseListener  {
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;
	private JTable tablePackages;
	private JScrollPane scrollPaneTable;
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private JButton btnMenu;
	private JButton btnResearch;
	private JButton btnAvailabality;
	private JPanel panBtn = new JPanel();
	private Font police = new Font("Arial", Font.BOLD, 30);

	public AllPackages() throws UnsupportedLookAndFeelException {
		//adaptation mac
		UIManager.setLookAndFeel(new MetalLookAndFeel());
		
		this.NewFrame_AllPackages();
		this.Table_AllPackages();
		this.Button_AllPackages();
		
		// affichage vue tous colis
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void NewFrame_AllPackages() {
		// recuperation taille ecran
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();

		// Dimension dimension =
		// java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.height = (int) maximumWindowBounds.getHeight();
		this.width = (int) maximumWindowBounds.getWidth();
//		final int heightf = height;
//		final int widthf = width - 200;

		// parametrage fenetre Tous Les Colis
		this.setTitle("Liste complète des colis");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imagePackage = new ImageIcon("media/colis2.jpg");
		this.setIconImage(imagePackage.getImage());
		// this.setResizable(false);
		this.setPreferredSize(new Dimension(width, height));
		
		this.getContentPane().setLayout(this.gbl);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	public void Table_AllPackages(){
		String [] headers=new String[15];
		headers[0] = "<html><center>N\u00B0<br>Colis</br></center></html>";
		headers[1]="Affectataire";
		headers[2]="Module";
		headers[3]="<html><center>Nominal<br>/<br>Optionnel</br></center></html>";
		headers[4]="Secteur";
		headers[5]="<html><center>Designation<br>generique</br></center></html>";
		headers[6]="<html><center>Precisions<br>articles</br></center></html>";
		headers[7]="Etat";
		headers[8]="Nature";
		headers[9]="<html><center>Dimensions (m)<br>(L*l*H)</br></center></html>";
		headers[10]="<html><center>Volume<br>(m3)</br></center></html>";
		headers[11]="<html><center>Poids<br>(Kg)</br></center></html>";
		headers[12]="Valeur";
		headers[13]="Iata";
		headers[14]="Projection";

		Object [][] rows = new Object [40][15];
		for (int i=0; i<40; i++){
			for (int j=0; j<15; j++){
				rows[i][j]=null;
			}
		}
		
		this.tablePackages = new JTable(rows, headers);
		this.tablePackages.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col = this.tablePackages.getColumnModel().getColumn(0);
        col.setPreferredWidth(40);
        col = this.tablePackages.getColumnModel().getColumn(1);
        col.setPreferredWidth(80);
        col = this.tablePackages.getColumnModel().getColumn(2);
        col.setPreferredWidth(70);
        col = this.tablePackages.getColumnModel().getColumn(3);
        col.setPreferredWidth(70);
        col = this.tablePackages.getColumnModel().getColumn(4);
        col.setPreferredWidth(110);
        col = this.tablePackages.getColumnModel().getColumn(5);
        col.setPreferredWidth(110);
        col = this.tablePackages.getColumnModel().getColumn(6);
        col.setPreferredWidth(130);
        col = this.tablePackages.getColumnModel().getColumn(6);
        col.setPreferredWidth(130);
        
        this.tablePackages.getTableHeader().setPreferredSize(new Dimension(tablePackages.getColumnModel().getTotalColumnWidth(),70));
		this.tablePackages.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		
		
		this.scrollPaneTable = new JScrollPane(this.tablePackages);
		this.scrollPaneTable.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.gc.fill = GridBagConstraints.BOTH; // le layout prendra toute la place horizontalement
		this.gc.weighty=3.5;
		
		this.getContentPane().add(this.scrollPaneTable,this.gc);
	}
	
	public void Button_AllPackages(){
		this.panBtn.setLayout(null);
		Insets insets = this.panBtn.getInsets();
		
		this.btnMenu=new JButton ("MENU");
		this.panBtn.add(this.btnMenu);
		Dimension sizeMenu = this.btnMenu.getPreferredSize();
		this.btnMenu.setBounds(insets.left, insets.top, sizeMenu.width+150, sizeMenu.height+25);
		this.btnMenu.setBackground(Color.DARK_GRAY);
		this.btnMenu.setForeground(new Color(255,255,255));
		this.btnMenu.setFont(police);
		this.btnMenu.addMouseListener(this);
		
		this.btnResearch=new JButton ("Recherche");
		Dimension sizeResearch=this.btnResearch.getPreferredSize();
		this.btnResearch.setBounds(600+sizeMenu.width+insets.left, insets.top, sizeResearch.width+150, sizeResearch.height+25);
		this.panBtn.add(this.btnResearch);
		this.btnResearch.setBackground(new Color(255,127,0));
		this.btnResearch.setForeground(new Color(255,255,255));
		this.btnResearch.setFont(police);
		this.btnResearch.addMouseListener(this);
		
		this.btnAvailabality=new JButton ("Disponibilités");
		this.btnAvailabality.setBounds(750+sizeMenu.width+sizeResearch.width+insets.left, insets.top, sizeResearch.width+150, sizeResearch.height+25);
		this.panBtn.add(this.btnAvailabality);
		this.btnAvailabality.setBackground(new Color(244,102,27));
		this.btnAvailabality.setForeground(new Color(255,255,255));
		this.btnAvailabality.setFont(police);
		this.btnAvailabality.addMouseListener(this);
		
		//this.gc.insets = new Insets(5, 0,5, 0); // reglage des marges entre composants 
		this.gc.fill=GridBagConstraints.BOTH;
		this.gc.weightx=3;
		this.gc.weighty=1;
		this.gc.gridwidth=1;
		this.gc.gridx=0;
		this.gc.gridy=4;
		this.getContentPane().add(this.panBtn,this.gc);
	}

	
//////MOUSE LISTENER///////
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton boutonSurvol = new JButton();
		boutonSurvol = (JButton) e.getSource();
		boutonSurvol.setBackground(new Color (173,79,9));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton boutonSurvol = new JButton();
		boutonSurvol = (JButton) e.getSource();
		if(boutonSurvol == btnMenu){
			boutonSurvol.setBackground(Color.DARK_GRAY);
		}else if (boutonSurvol == btnResearch){
			boutonSurvol.setBackground(new Color(255,127,0));
		}else if (boutonSurvol == btnAvailabality){
			boutonSurvol.setBackground(new Color(244,102,27));
		}
		
	}
}
