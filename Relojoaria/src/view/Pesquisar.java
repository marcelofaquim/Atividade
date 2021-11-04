package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pesquisar extends JDialog {
	private JTextField txtPesquisar;
	private JTable table;
	private JTextField txtId;
	private JTextField txtNome;
	// private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisar dialog = new Pesquisar();
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
	public Pesquisar() {
		setResizable(false);
		setModal(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Pesquisar.class.getResource("/icones/relogio-de-24-horas.png")));
		setBounds(100, 100, 470, 525);
		getContentPane().setLayout(null);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				pesquisarCliente();
			}
		});
		txtPesquisar.setBounds(10, 20, 167, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Pesquisar.class.getResource("/icones/lupa.png")));
		lblNewLabel.setBounds(187, 14, 32, 32);
		getContentPane().add(lblNewLabel);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 64, 414, 64);
		getContentPane().add(desktopPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 414, 64);
		desktopPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampo();

			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 154, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(37, 151, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(144, 154, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setBounds(178, 151, 246, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);


		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Pesquisar.class.getResource("/icones/add64.png")));
		btnAdicionar.setBounds(37, 395, 80, 80);
		getContentPane().add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(Pesquisar.class.getResource("/icones/edit.png")));
		btnEditar.setBounds(178, 395, 80, 80);
		getContentPane().add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon(Pesquisar.class.getResource("/icones/delet64.png")));
		btnExcluir.setBounds(319, 395, 80, 80);
		getContentPane().add(btnExcluir);

		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setBounds(10, 206, 37, 14);
		getContentPane().add(lblNewLabel_5);

		txtCep = new JTextField();
		txtCep.setBounds(46, 206, 115, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o");
		lblNewLabel_6.setBounds(178, 209, 61, 14);
		getContentPane().add(lblNewLabel_6);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(246, 209, 178, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Numero");
		lblNewLabel_7.setBounds(10, 249, 46, 14);
		getContentPane().add(lblNewLabel_7);

		txtNumero = new JTextField();
		txtNumero.setBounds(56, 246, 67, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Complemento");
		lblNewLabel_8.setBounds(139, 252, 80, 14);
		getContentPane().add(lblNewLabel_8);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(246, 249, 120, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Cidade");
		lblNewLabel_9.setBounds(10, 302, 46, 14);
		getContentPane().add(lblNewLabel_9);

		txtCidade = new JTextField();
		txtCidade.setBounds(66, 299, 111, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		lblNewLabel_10 = new JLabel("Bairro");
		lblNewLabel_10.setBounds(204, 302, 46, 14);
		getContentPane().add(lblNewLabel_10);

		txtBairro = new JTextField();
		txtBairro.setBounds(246, 299, 165, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setBounds(31, 327, 86, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);

	} // Fim Do Construtor

	DAO dao = new DAO();
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JLabel lblNewLabel_10;
	private JTextField txtBairro;
	private JTextField txtFone;

	private void pesquisarCliente() {
		// ? = Paramentro
		String read = "select * from clientes where nome like ?";
		try {
			// abrir a conexao com o banco
			Connection con = dao.conectar();
			
			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setString(1, txtPesquisar.getText() + "%");
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void adicionarCliente() {
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Nome", " Atenção!", JOptionPane.WARNING_MESSAGE);
			txtNome.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtCep.requestFocus();

		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtEndereco.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero da sua residencia ", "Atenção!",
					JOptionPane.WARNING_MESSAGE);
			txtNumero.requestFocus();

		} else if (txtComplemento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Complemento", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtComplemento.requestFocus();

		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtCidade.requestFocus();

		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtBairro.requestFocus();

		} else {
			String create = "insert into clientes (nome,cep,endereco,numero,complemento,cidade,bairro,email,fone) values(?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtCep.getText());
				pst.setString(3, txtEndereco.getText());
				pst.setString(4, txtNumero.getText());
				pst.setString(5, txtComplemento.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, txtBairro.getText());
				pst.setString(8, txtFone.getText());
				
				

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, " Cliente adicionado com sucesso.", " Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
				}
				con.close();
				limpar();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do Metodo

	private void setarCampo() {
		int setar = table.getSelectedRow();
		txtId.setText(table.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(table.getModel().getValueAt(setar, 1).toString());
		txtCep.setText(table.getModel().getValueAt(setar, 2).toString());
		txtEndereco.setText(table.getModel().getValueAt(setar, 3).toString());
		txtNumero.setText(table.getModel().getValueAt(setar, 4).toString());
		txtComplemento.setText(table.getModel().getValueAt(setar, 5).toString());
		txtCidade.setText(table.getModel().getValueAt(setar, 7).toString());
		txtBairro.setText(table.getModel().getValueAt(setar, 6).toString());
		// Gerenciar os botões
		btnAdicionar.setEnabled(false);
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);

	}

	private void editarCliente() {

		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtNome.requestFocus();
		}

		else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtCep.requestFocus();

		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtEndereco.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero da sua residencia ", "Atenção!",
					JOptionPane.WARNING_MESSAGE);
			txtNumero.requestFocus();

		} else if (txtComplemento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Complemento", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtComplemento.requestFocus();

		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtCidade.requestFocus();

		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro", "Atenção!", JOptionPane.WARNING_MESSAGE);
			txtBairro.requestFocus();

		} else {

			String update = "update idcli set nome=?cep=?endereço=?numero=?complemento=?cidade=?bairro=?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);

				pst.setString(1, txtNome.getText());
				pst.setString(2, txtCep.getText());
				pst.setString(3, txtEndereco.getText());
				pst.setString(4, txtNumero.getText());
				pst.setString(5, txtComplemento.getText());
				pst.setString(6, txtCidade.getText());
				pst.setString(7, txtBairro.getText());
			

				
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do cliente atualizado com sucesso.", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
				}
				con.close();
				limpar();

			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
	} // Fim do Método

	private void excluirCliente() {

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {

			String delete = " delete from clientes where idcli=?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				int excluir = pst.executeUpdate();
				if (excluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
				}

				con.close();
				limpar();
			} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Exclusão não realizada.\nCliente possui pedido em aberto.",
						"Atenção!", JOptionPane.WARNING_MESSAGE);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private void limpar() {

		txtPesquisar.setText(null);
		txtId.setText(null);
		txtNome.setText(null);
		

		btnAdicionar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}
