import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;


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
	private JComboBox comboBox;
	private JLabel lblGnero;
	private JLabel lblCanciones;
	private JLabel lblCreaTuPlaylist;
	private JLabel lblNewLabel;
	private JButton btnAgregar;
	private JLabel lblNewLabel_1;
	private DefaultTableModel tablaR;
	private JTable tbInformacion;
	private JTable table;
	private JLabel lblNombreArtista;
	private JPanel panel_1;
	private JLabel lblPlaylistDelUsuario;
	private JPanel panel_2;
	private JLabel label;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton button;
	private JPanel panel_5;
	private JLabel lblCancionesRecomendadas;
	private JLabel lblAPartirDe;
	private JLabel lblNombreArtista_1;
	private JScrollPane scrollPane;
	private JButton button_1;
	private JPanel panel_6;
	private JLabel lblNewLabel_2;
	


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
        
        comboBox = new JComboBox();
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
        btnAgregar.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn3.png"));
        btnAgregar.setBounds(320, 186, 108, 33);
        panel2.add(btnAgregar);
        
       
        
        
      //creación de los elememtos que componen la lista 
        String[] nombres = {"Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena","Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena"}; 
        //creación del objeto lista 
        JList lista = new JList(nombres); 
        lista.setSelectionForeground(Color.GRAY);
        lista.setForeground(Color.BLACK);
        lista.setBackground(Color.WHITE);
        lista.setFont(new Font("Arial", Font.PLAIN, 12));
        //se cambia la orientación de presentación y el ajuste 
       
        //selecciona un elemento de la lista 
        
        //recoge el indice de los seleccionados 
        int[] indices = lista.getSelectedIndices(); 
        // aquí se crea el objeto, es decir la barra de desplazamiento 
        JScrollPane barraDesplazamiento = new JScrollPane(lista); 
        barraDesplazamiento.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        barraDesplazamiento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        barraDesplazamiento.setBounds(10, 115, 274, 211); 
        //Agrega la barra de desplazamiento al panel 
        panel2.add(barraDesplazamiento); 
        
        lblNombreArtista = new JLabel("NOMBRE                                     ARTISTA");
        lblNombreArtista.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombreArtista.setForeground(Color.WHITE);
        lblNombreArtista.setBounds(20, 95, 261, 14);
        panel2.add(lblNombreArtista);
        
      
        
      
		
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
        
        label = new JLabel("NOMBRE                                     ARTISTA");
        label.setBounds(45, 22, 210, 15);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        panel_1.add(label);
        
      //creación de los elememtos que componen la lista 
        String[] nombres2 = {"Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena","Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena","Macarena","Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena"}; 
        //creación del objeto lista 
        JList lista2 = new JList(nombres2); 
        lista2.setSelectionForeground(Color.GRAY);
        lista2.setForeground(Color.BLACK);
        lista2.setBackground(Color.WHITE);
        lista2.setFont(new Font("Arial", Font.PLAIN, 12));
       
        //recoge el indice de los seleccionados 
        int[] indices2 = lista2.getSelectedIndices(); 
        // aquí se crea el objeto, es decir la barra de desplazamiento 
        JScrollPane barraDesplazamiento2 = new JScrollPane(lista2); 
        barraDesplazamiento2.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        barraDesplazamiento2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        barraDesplazamiento2.setBounds(10, 46, 270, 227); 
        //Agrega la barra de desplazamiento al panel 
        panel_1.add(barraDesplazamiento2); 
        
        button = new JButton("");
        button.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\Proyecto\\btn4.png"));
        button.setBounds(99, 291, 108, 33);
        panel_1.add(button);
        
        
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
        
        lblNombreArtista_1 = new JLabel("NOMBRE                                                         ARTISTA");
        lblNombreArtista_1.setForeground(Color.WHITE);
        lblNombreArtista_1.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombreArtista_1.setBounds(63, 450, 369, 15);
        principal.getContentPane().add(lblNombreArtista_1);
        
        
        
      //creación de los elememtos que componen la lista 
        String[] nombres3 = {"Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena","Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena","Macarena","Ana","Margarita","Daniela","Divian", 
        "Leslie","Paz","Andrea","Macarena"}; 
        //creación del objeto lista 
        JList lista3 = new JList(nombres3); 
        lista3.setSelectionForeground(Color.GRAY);
        lista3.setForeground(Color.BLACK);
        lista3.setBackground(Color.WHITE);
        lista3.setFont(new Font("Arial", Font.PLAIN, 12));
       
        //recoge el indice de los seleccionados 
        int[] indices3 = lista3.getSelectedIndices(); 
        // aquí se crea el objeto, es decir la barra de desplazamiento 
        JScrollPane barraDesplazamiento3 = new JScrollPane(lista3); 
        barraDesplazamiento3.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        barraDesplazamiento3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        barraDesplazamiento3.setBounds(35, 477, 422, 126); 
        //Agrega la barra de desplazamiento al panel 
        principal.getContentPane().add(barraDesplazamiento3); 
        
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
	
	private class MusicListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==btnCrearMiPlaylist){
				principal.setVisible(true);
				inicio.setVisible(false);
			}
			
		}
	}
}
	