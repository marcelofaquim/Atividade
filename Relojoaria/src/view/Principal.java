package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// Evento disparado ao ativar o JFram
				setarData();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icones/relogio-de-24-horas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 430);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.setToolTipText("Usuarios");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/icones/usuarios.png")));
		btnUsuarios.setBounds(20, 32, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnRelatorios = new JButton("");
		btnRelatorios.setToolTipText("Relatorio");
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/icones/relatorios.png")));
		btnRelatorios.setBounds(20, 192, 128, 128);
		contentPane.add(btnRelatorios);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 355, 548, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(271, 11, 277, 14);
		panel.add(lblData);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisar usuarios = new Pesquisar();
				usuarios.setVisible(true);
			}
		});
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/icones/clientes.png")));
		btnClientes.setBounds(194, 32, 128, 128);
		contentPane.add(btnClientes);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {		
		 public void actionPerformed(ActionEvent e) {
			 // Clicar no botão
			 //Criando um objeto
			 Sobre sobre = new Sobre();
			 sobre.setVisible(true); // exibir o JDialog
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBackground(SystemColor.window);
		btnSobre.setBorder(null);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/icones/sobre.png")));
		btnSobre.setBounds(365, 32, 128, 128);
		contentPane.add(btnSobre);
		
		
		JLabel lblNewLabel = new JLabel("Mordern Watches - Assistencia Especializada");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 11));
		lblNewLabel.setBounds(301, 320, 247, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("Pesquisa Avan\u00E7ada por CEP");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/icones/pesquisaavan\u00E7ada.png")));
		btnNewButton.setBounds(187, 192, 128, 128);
		contentPane.add(btnNewButton);
	}
	
	
	private void setarData() {
		// as linhas abaixo são usadas para obter a formatação do sistema
		Date dataLabel = new Date();	
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		// a linha abaixo substitui a label do rodapé pela data
		lblData.setText(formatador.format(dataLabel));
	}
}
