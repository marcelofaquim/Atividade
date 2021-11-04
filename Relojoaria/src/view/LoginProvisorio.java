package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginProvisorio extends JFrame {
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProvisorio frame = new LoginProvisorio();
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
	public LoginProvisorio() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginProvisorio.class.getResource("/icones/relogio-de-24-horas.png")));
		setTitle("Login - Mordern watches - Assistencia Tecnica Especializada");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 53, 42, 14);
		getContentPane().add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(63, 50, 279, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(10, 105, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(63, 102, 279, 20);
		getContentPane().add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnEntrar.setBounds(159, 172, 89, 23);
		getContentPane().add(btnEntrar);

	}// Fim do construtor

	DAO dao = new DAO();

	private void logar() {
			if(txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login", " Atenção!",JOptionPane.WARNING_MESSAGE);
				txtLogin.requestFocus();
			} else if (txtSenha.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, " Preencha a Senha", " Atenção!", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					String read = "select * from usuarios where login=? and senha=md5(?)";
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(read);
					pst.setString(1, txtLogin.getText());
					pst.setString(2, txtSenha.getText());
					
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
						Principal principal = new Principal();
						principal.setVisible(true);
						
						this.dispose();
						
					}else {
							JOptionPane.showMessageDialog(null, " Login e/ou senha inválido(s)", " Atenção!", JOptionPane.WARNING_MESSAGE);
						}
						con.close();
				} catch (Exception e) {
						System.out.println(e);
				}
			}
	}
}
	
