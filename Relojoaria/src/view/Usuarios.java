package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Usuarios extends JDialog {
	private JTextField txtPesquisar;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		getContentPane().setEnabled(false);
		setTitle("Usuarios");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/icones/relogio-de-24-horas.png")));
		setBounds(100, 100, 522, 349);
		getContentPane().setLayout(null);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarUsuario();
			}
		});
		txtPesquisar.setBounds(10, 24, 166, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Usuarios.class.getResource("/icones/lupa.png")));
		lblNewLabel.setBounds(186, 18, 32, 32);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 147, 37, 14);
		getContentPane().add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(32, 144, 71, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(147, 147, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(203, 144, 221, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 59, 478, 77);
		getContentPane().add(desktopPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 478, 77);
		desktopPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
				setarSenha();
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setBounds(10, 186, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtLogin = new JTextField();
		txtLogin.setBounds(42, 183, 109, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setBounds(161, 186, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtSenha = new JTextField();
		txtSenha.setBounds(203, 183, 221, 20);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Perfil");
		lblNewLabel_5.setBounds(10, 225, 32, 14);
		getContentPane().add(lblNewLabel_5);

		cboPerfil = new JComboBox();
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] {"", "Admin\t", "Operador"}));
		cboPerfil.setBounds(52, 221, 99, 22);
		getContentPane().add(cboPerfil);

		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();

			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/icones/add64.png")));
		btnAdicionar.setBounds(171, 221, 80, 80);
		getContentPane().add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarUsuarios();
			}
		});
		btnEditar.setIcon(new ImageIcon(Usuarios.class.getResource("/icones/edit.png")));
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(274, 221, 80, 80);
		getContentPane().add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/icones/delet64.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setBounds(364, 221, 80, 80);
		getContentPane().add(btnExcluir);
		
		RestrictedTextField nome = new RestrictedTextField(this.txtUsuario);
		nome.setLimit(50);
		RestrictedTextField email = new RestrictedTextField(this.txtLogin);
		email.setLimit(50);
		RestrictedTextField senha = new RestrictedTextField(this.txtSenha);
		senha.setLimit(250);

	} // Fim do construtor

	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JComboBox cboPerfil;
	

	private void pesquisarUsuario() {
		// ? = Paramentro
		String read = "select * from usuarios where usuario like ?";
		try {
			// abrir a conexao com o banco
			Connection con = dao.conectar();
			// preparar a query(instrucao sql) para pesquisar no banco
			PreparedStatement pst = con.prepareStatement(read);
			// substituir o parametro(?) Atencao ao % para completar a query
			// 1 = Ele é um Parametro(?)
			pst.setString(1, txtPesquisar.getText() + "%");
			// Executar a query e obter os dados do banco (resultado)
			ResultSet rs = pst.executeQuery();
			// popular(preencher) a tabela com os dados do banco
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
		}
	} // Fim Do construtor

	private void adicionarUsuario() {
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Usuario", " Atenção!", JOptionPane.WARNING_MESSAGE);
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo de Login", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtLogin.requestFocus();

		} else if (txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo de Senha", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtSenha.requestFocus();
		} else {
			// inserir o Usuario no banco
			String create = "insert into usuarios (usuario,login,senha, perfil) values (?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtSenha.getText());
				pst.setString(4, cboPerfil.getActionCommand());
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso.", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do Construtor
	
	private void editarUsuarios() {
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Usuario", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o  campo login", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtLogin.requestFocus();
		
	} else if (txtSenha.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha a senha", "Atenção!", JOptionPane.WARNING_MESSAGE);
		txtSenha.requestFocus();
		
	} else {
		String update = "update usuarios set usuario=?,login=?,senha=md5(?), perfil=? where id=?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtLogin.getText());
			pst.setString(3, txtSenha.getText());
			pst.setString(4, cboPerfil.getActionCommand());
			pst.setString(5, txtId.getText());
			int confirma = pst.executeUpdate();
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Dados do cliente atualizado com sucesso.", "Mensagem",
						JOptionPane.INFORMATION_MESSAGE);
				con.close();
			}
	}	catch (Exception e) {
		System.out.println(e);
	}
		
	}

} // Fim do Metodo
	
	private void excluirUsuario() {
		// Confirmação de Exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste Usuario?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// código principal 
			String delete= " delete from usuarios where id=?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				int excluir = pst.executeUpdate();
				if (excluir ==1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				}
				
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Exclusão não realizada.\nUsuario possui pendencias em aberto.", "Atenção!", JOptionPane.WARNING_MESSAGE);
			
			}catch (Exception e ) {
				System.out.println(e);
			
		}
}
} // Fim do Construtor
	
	
	private void setarCampos() {
		// a linha abaixo obtem o conteudo da linha da tabela
		// int = reference ao indice da tabela [0] [1]...
		int setar = table.getSelectedRow();
		// setar os campos
		txtId.setText(table.getModel().getValueAt(setar, 0).toString());
		txtUsuario.setText(table.getModel().getValueAt(setar, 1).toString());
		txtLogin.setText(table.getModel().getValueAt(setar, 2).toString());
		txtSenha.setText(table.getModel().getValueAt(setar, 3).toString());
		cboPerfil.setSelectedItem(table.getModel().getValueAt(setar, 4).toString());
		// Gerenciar os botões
		btnAdicionar.setEnabled(false);
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);

	}
	
	private void setarSenha() {
		String read2 = "select senha from usuarios where id=?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtId.getText());
		
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				txtSenha.setText(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void limpar() {
		// limpar campos
		txtPesquisar.setText(null);
		txtId.setText(null);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
		// limpar a tabela
		((DefaultTableModel) table.getModel()).setRowCount(0);
		// gerenciar os botões
		btnAdicionar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}
