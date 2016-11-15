import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Choice;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.Component;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JFrame principal;
	private JFrame inicio;
	
	private JButton btnCrearMiPlaylist;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel icono;
	private JTextArea txtrBienvenidoALa;
	private JPanel panel2;
	private JComboBox<String> comboBox;
	private JLabel lblGnero;
	private JLabel lblCanciones;
	private JLabel lblCreaTuPlaylist;
	private JLabel lblNewLabel;
	private JButton btnAgregar;
	private JLabel lblNewLabel_1;
	private JTable tabla;
	private JTable tabla3;
	private JTable tabla2;
	private JPanel panel_1;
	private JLabel lblPlaylistDelUsuario;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton button;
	private JPanel panel_5;
	private JLabel lblCancionesRecomendadas;
	private JLabel lblAPartirDe;
	private JScrollPane scrollPane;
	private JButton button_1;
	private JPanel panel_6;
	private JLabel lblNewLabel_2;
	private final Vector<String> Generos;
	private final String [] d={"NOMBRE","ARTISTA"};
	private Vector<String> Canciones;
	private Vector<String> Artistas;
	private DbFunctions database;
	private String[][] info;
	private MiModelo model;
	private MiModelo model2;
	private MiModelo model3;
	private int contador;
	private String[][] playlist;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
					GUI window = new GUI();
					window.inicio.setVisible(true);
					
				
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		database = new DbFunctions();
		Generos = database.getGenero();
		contador=0;
		initialize();
		
	}
	
	public void initialize(){
		
		
		principal = new JFrame();
		principal.getContentPane().setBackground(Color.GRAY);
	    principal.setResizable(false);
	     
        principal.getContentPane().setLayout(null);
        principal.setBackground(new Color(63, 63, 112));
        principal.setTitle("Music4Me Premium");
		principal.setBounds(100, 20, 801, 697);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.getContentPane().setLayout(null);
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(Color.BLACK);
        separator.setBounds(474, 7, 0, 378);
        principal.getContentPane().add(separator);
		
        panel2 = new JPanel();
        panel2.setBackground(new Color(63, 63, 112));
        panel2.setBounds(10, 32, 464, 353);
        principal.getContentPane().add(panel2);
        panel2.setLayout(null);
        
        comboBox = new JComboBox(Generos);
        comboBox.addActionListener(new MusicListener());
        comboBox.addItemListener((ItemListener) new MusicListener());
        comboBox.setBackground(Color.GRAY);
        comboBox.setBounds(10, 39, 95, 20);
        panel2.add(comboBox);
        
        lblGnero = new JLabel("G\u00C9NERO");
        lblGnero.setFont(new Font("Consolas", Font.BOLD, 14));
        lblGnero.setForeground(Color.WHITE);
        lblGnero.setBounds(10, 20, 71, 14);
        panel2.add(lblGnero);
        
        lblCanciones = new JLabel("CANCIONES");
        lblCanciones.setForeground(Color.WHITE);
        lblCanciones.setFont(new Font("Consolas", Font.BOLD, 14));
        lblCanciones.setBounds(10, 70, 95, 14);
        panel2.add(lblCanciones);
        
        btnAgregar = new JButton("");
        btnAgregar.addActionListener(new MusicListener());
        btnAgregar.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn3.png"));
        btnAgregar.setBounds(320, 186, 108, 33);
        panel2.add(btnAgregar);
        
		String[][] info={};
		
		model=new MiModelo();
		model.setDataVector(info,d);
		
		
		tabla=new JTable(model);
		tabla.setBounds(10, 115, 274, 211);
	    tabla.getTableHeader().setFont(new Font("arial",Font.BOLD,12));
	    tabla.getTableHeader().setForeground(Color.WHITE);
	    tabla.getTableHeader().setBackground(new Color(63, 63, 112));
	    tabla.setShowVerticalLines(false);
	    tabla.setBackground(Color.GRAY);
	    tabla.setForeground(Color.WHITE);
	    tabla.setFont(new Font("arial",Font.BOLD,12));
	    tabla.setGridColor(Color.LIGHT_GRAY);
	    tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	
	    
	    JScrollPane scroll=new JScrollPane(tabla);
	    scroll.setBackground(new Color(63, 63, 112));
	    scroll.setForeground(Color.WHITE);
	    scroll.setFont(new Font("Calibri", Font.PLAIN, 12));
	    scroll.setBounds(10, 95, 274, 231);
	    panel2.add(scroll);
        
      
        
      
		
        lblCreaTuPlaylist = new JLabel("CREA TU PLAYLIST");
        lblCreaTuPlaylist.setFont(new Font("Arial", Font.BOLD, 18));
        lblCreaTuPlaylist.setForeground(Color.WHITE);
        lblCreaTuPlaylist.setBounds(147, 7, 285, 14);
        principal.getContentPane().add(lblCreaTuPlaylist);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(63, 63, 112));
        panel_1.setBounds(484, 32, 301, 353);
        principal.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
		Object[][] info2={};
		
		model2=new MiModelo();
		model2.setDataVector(info2, d);
		
		tabla2=new JTable(model2);
		tabla2.setBounds(10, 46, 270, 22);
		tabla2.getTableHeader().setFont(new Font("arial",Font.BOLD,12));
		tabla2.getTableHeader().setForeground(Color.WHITE);
		tabla2.getTableHeader().setBackground(new Color(63, 63, 112));
		tabla2.setShowVerticalLines(false);
		tabla2.setBackground(Color.GRAY);
		tabla2.setForeground(Color.WHITE);
		tabla2.setFont(new Font("arial",Font.BOLD,12));
		tabla2.setGridColor(Color.LIGHT_GRAY);
	    tabla2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    
	    JScrollPane scroll2=new JScrollPane(tabla2);
	    scroll2.setFont(new Font("Calibri", Font.PLAIN, 12));
	    scroll2.setBounds(10, 34, 270, 246);
	    panel_1.add(scroll2);
        
	        
	        
      
        
        button = new JButton("");
        button.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn4.png"));
        button.setBounds(99, 291, 108, 33);
        panel_1.add(button);
        
        JLabel label = new JLabel("CANCIONES");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Consolas", Font.BOLD, 14));
        label.setBounds(10, 11, 95, 14);
        panel_1.add(label);
        
        
        lblPlaylistDelUsuario = new JLabel("PLAYLIST DEL USUARIO");
        lblPlaylistDelUsuario.setForeground(Color.WHITE);
        lblPlaylistDelUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        lblPlaylistDelUsuario.setBounds(526, 7, 239, 14);
        principal.getContentPane().add(lblPlaylistDelUsuario);
        
        panel_2 = new JPanel();
        panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setBounds(474, 0, 10, 385);
        principal.getContentPane().add(panel_2);
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.DARK_GRAY);
        panel_3.setBounds(0, 0, 10, 668);
        principal.getContentPane().add(panel_3);
        
        panel_4 = new JPanel();
        panel_4.setBackground(Color.DARK_GRAY);
        panel_4.setBounds(785, 0, 10, 668);
        principal.getContentPane().add(panel_4);
        
        panel_5 = new JPanel();
        panel_5.setBackground(Color.DARK_GRAY);
        panel_5.setBounds(0, 384, 795, 14);
        principal.getContentPane().add(panel_5);
        
        lblCancionesRecomendadas = new JLabel("CANCIONES RECOMENDADAS");
        lblCancionesRecomendadas.setForeground(Color.WHITE);
        lblCancionesRecomendadas.setFont(new Font("Arial", Font.BOLD, 18));
        lblCancionesRecomendadas.setBounds(88, 407, 285, 14);
        principal.getContentPane().add(lblCancionesRecomendadas);
        
        lblAPartirDe = new JLabel("A partir de las canciones de tu playlist");
        lblAPartirDe.setFont(new Font("Arial", Font.BOLD, 14));
        lblAPartirDe.setForeground(Color.WHITE);
        lblAPartirDe.setBounds(88, 425, 304, 14);
        principal.getContentPane().add(lblAPartirDe);
        
   
		Object[][] info3={};
		
		model3=new MiModelo();
		model3.setDataVector(info3, d);
		
		tabla3=new JTable(model3);
		tabla3.setBounds(35, 477, 422, 126);
		tabla3.getTableHeader().setFont(new Font("arial",Font.BOLD,12));
		tabla3.getTableHeader().setForeground(Color.WHITE);
		tabla3.getTableHeader().setBackground(new Color(63, 63, 112));
		tabla3.setShowVerticalLines(false);
		tabla3.setBackground(Color.GRAY);
		tabla3.setForeground(Color.WHITE);
		tabla3.setFont(new Font("arial",Font.BOLD,12));
		tabla3.setGridColor(Color.LIGHT_GRAY);
	    tabla3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    
	    JScrollPane scroll3=new JScrollPane(tabla3);
	    scroll3.setFont(new Font("Calibri", Font.PLAIN, 12));
	    scroll3.setBounds(35, 450, 422, 153);
	    principal.getContentPane().add(scroll3);
     
        
        button_1 = new JButton("");
        button_1.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn6.PNG"));
        button_1.setBounds(183, 614, 108, 33);
        principal.getContentPane().add(button_1);
        
        panel_6 = new JPanel();
        panel_6.setBackground(Color.DARK_GRAY);
        panel_6.setBounds(0, 658, 795, 14);
        principal.getContentPane().add(panel_6);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\titulo.png"));
        lblNewLabel_2.setBounds(475, 477, 290, 121);
        principal.getContentPane().add(lblNewLabel_2);
        
		inicio = new JFrame();
		inicio.getContentPane().setBackground(Color.GRAY);
	    inicio.setResizable(false);
        inicio.setBackground(new Color(63, 63, 112));
        inicio.setTitle("Music4Me");
		inicio.setBounds(100, 100, 305, 481);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.getContentPane().setLayout(null);
		inicio.getContentPane().setLayout(null);
		
		
		btnCrearMiPlaylist = new JButton("");
		btnCrearMiPlaylist.setBounds(64, 358, 172, 39);
		btnCrearMiPlaylist.setBackground(Color.WHITE);
		btnCrearMiPlaylist.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn1.png"));
		btnCrearMiPlaylist.addActionListener(new MusicListener());
		inicio.getContentPane().add(btnCrearMiPlaylist);
		
		btnNewButton = new JButton("");
		btnNewButton.setBounds(95, 408, 109, 33);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\bt2.png"));
		inicio.getContentPane().add(btnNewButton);
		
		txtrBienvenidoALa = new JTextArea();
		txtrBienvenidoALa.setForeground(Color.WHITE);
		txtrBienvenidoALa.setBackground(Color.GRAY);
		txtrBienvenidoALa.setEditable(false);
		txtrBienvenidoALa.setLineWrap(true);
		txtrBienvenidoALa.setFont(new Font("Arial", Font.BOLD, 15));
		txtrBienvenidoALa.setText("  Bienvenido a la mayor comunidad \r\n    de recomendaciones musicales\r\n\r\n        REDESCUBRE TU M\u00DASICA");
		txtrBienvenidoALa.setBounds(21, 269, 256, 89);
		inicio.getContentPane().add(txtrBienvenidoALa);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\icono2.png"));
		lblNewLabel.setBounds(69, 11, 208, 170);
		inicio.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\titulo.png"));
		lblNewLabel_1.setBounds(10, 188, 267, 81);
		inicio.getContentPane().add(lblNewLabel_1);
        
      }
	
	private class MusicListener implements ActionListener,ItemListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==btnCrearMiPlaylist){
				principal.setVisible(true);
				inicio.setVisible(false);
			}
			
			
			
			if (e.getSource()==btnAgregar){
				contador++;
				int indice = tabla.getSelectedRow();
				String[] newSong = info[indice];
				String[][] playlistTemp1 = new String[contador][contador];
				for (int i=0;i<(contador-1);i++){
					playlistTemp1[i]=playlist[i];
				}
				
				
				if (Arrays.asList(playlistTemp1).contains(newSong)){
					contador=contador-1;
					model2.setDataVector(playlist, d);
					tabla2.setModel(model2);
					JOptionPane.showMessageDialog(null, "Esa canción ya existe en tu playlist.");
				}
				else{
				playlistTemp1[contador-1] = newSong;
				
				
				model2.setDataVector(playlistTemp1, d);
				tabla2.setModel(model2);
				playlist = playlistTemp1;
				
			   }
			}
			
		}
		
		
		
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==comboBox){
				
				if(e.getStateChange()==ItemEvent.SELECTED){
					
					int cont;
					String[][] temp;
					switch(comboBox.getSelectedIndex()){
					
					case 0:
						
					
					Canciones = database.getCanciones("Rock");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
					
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
					
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 1:
						
					
					Canciones = database.getCanciones("Pop");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
						
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
						
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 2:
						
						
					Canciones = database.getCanciones("Alternative");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;

				    case 3:
						
						
					Canciones = database.getCanciones("Electronic");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 4:
						
						
					Canciones = database.getCanciones("R&B");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 5:
						
						
					Canciones = database.getCanciones("Rap");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 6:	
						
					Canciones = database.getCanciones("Hip-Hop");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
				    case 7:
						
					Canciones = database.getCanciones("Country");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
					
				    case 8:
						
						
					Canciones = database.getCanciones("Dance");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
					
				    case 9:
						
						
					Canciones = database.getCanciones("Latino");
					Artistas = database.getArtistas();
					cont = Canciones.size();
					temp = new String[cont][cont];
							
					for (int i=0; i<cont; i++){
							String[] temp2 ={Canciones.get(i),Artistas.get(i)};
							temp[i] = temp2;	
					}
							
					model.setDataVector(temp,d);
					tabla.setModel(model);
					info=temp;
					break;
					
					}
					
		 		
		     	}
		
			}
		}
	}
			
	
	
	
	class MiModelo extends DefaultTableModel{
		
		public boolean isCellEditable (int filas,int Columnas){

				return false;	
		}
	
    }
  
}

	