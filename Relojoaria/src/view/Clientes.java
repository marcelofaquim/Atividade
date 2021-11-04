package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPesquisar;
	private JTextField txtIdCli;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cboUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setResizable(false);
		setModal(true);
		setTitle("Mordern watches - Assistencia Tecnica Especializada");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/icones/relogio-de-24-horas.png")));
		setBounds(100, 100, 750, 489);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 734, 450);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(10, 58, 670, 94);
			contentPanel.add(panel);
		}
		{
			txtPesquisar = new JTextField();
			txtPesquisar.setBounds(10, 28, 287, 20);
			contentPanel.add(txtPesquisar);
			txtPesquisar.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(10, 187, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtIdCli = new JTextField();
			txtIdCli.setEditable(false);
			txtIdCli.setBounds(33, 184, 86, 20);
			contentPanel.add(txtIdCli);
			txtIdCli.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("* Nome");
			lblNewLabel_1.setBounds(152, 187, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtNome = new JTextField();
			txtNome.setBounds(208, 184, 232, 20);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("* Fone");
			lblNewLabel_2.setBounds(462, 187, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtFone = new JTextField();
			txtFone.setBounds(508, 184, 133, 20);
			contentPanel.add(txtFone);
			txtFone.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("* CEP");
			lblNewLabel_3.setBounds(10, 231, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtCep = new JTextField();
			txtCep.setBounds(47, 228, 86, 20);
			contentPanel.add(txtCep);
			txtCep.setColumns(10);
		}
		{
			JButton btnCep = new JButton("Buscar");
			btnCep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarCep();
				}

	
					
				}
			);
			btnCep.setBounds(151, 227, 89, 23);
			contentPanel.add(btnCep);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("* Endere\u00E7o");
			lblNewLabel_4.setBounds(250, 231, 73, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtEndereco = new JTextField();
			txtEndereco.setBounds(333, 228, 308, 20);
			contentPanel.add(txtEndereco);
			txtEndereco.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("* N\u00FAmero");
			lblNewLabel_5.setBounds(10, 283, 60, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setBounds(82, 280, 86, 20);
			contentPanel.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Complemento");
			lblNewLabel_6.setBounds(188, 283, 78, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			txtComplemento = new JTextField();
			txtComplemento.setBounds(283, 280, 78, 20);
			contentPanel.add(txtComplemento);
			txtComplemento.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("* Bairro");
			lblNewLabel_7.setBounds(371, 283, 46, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			txtBairro = new JTextField();
			txtBairro.setBounds(427, 280, 214, 20);
			contentPanel.add(txtBairro);
			txtBairro.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("* Cidade");
			lblNewLabel_8.setBounds(10, 319, 60, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			txtCidade = new JTextField();
			txtCidade.setBounds(92, 316, 205, 20);
			contentPanel.add(txtCidade);
			txtCidade.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("UF");
			lblNewLabel_9.setBounds(346, 319, 46, 14);
			contentPanel.add(lblNewLabel_9);
		}
		{
			cboUf = new JComboBox();
			cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
			cboUf.setBounds(381, 315, 59, 22);
			contentPanel.add(cboUf);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("* Campos Obrigatorios");
			lblNewLabel_10.setBounds(549, 31, 131, 14);
			contentPanel.add(lblNewLabel_10);
		}
		{
			JLabel lblNewLabel_11 = new JLabel("");
			lblNewLabel_11.setIcon(new ImageIcon(Clientes.class.getResource("/icones/lupa.png")));
			lblNewLabel_11.setBounds(307, 15, 32, 32);
			contentPanel.add(lblNewLabel_11);
		}
		{
			JButton btnAdicionar = new JButton("");
			btnAdicionar.setBorder(null);
			btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/icones/add64.png")));
			btnAdicionar.setBounds(446, 368, 64, 64);
			contentPanel.add(btnAdicionar);
		}
		{
			JButton btnExcluir = new JButton("");
			btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnExcluir.setBorder(null);
			btnExcluir.setIcon(new ImageIcon(Clientes.class.getResource("/icones/delet64.png")));
			btnExcluir.setBounds(533, 368, 64, 64);
			contentPanel.add(btnExcluir);
		}
		{
			JButton btnEditar = new JButton("");
			btnEditar.setBorder(null);
			btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditar.setIcon(new ImageIcon(Clientes.class.getResource("/icones/edit.png")));
			btnEditar.setBounds(624, 368, 64, 64);
			contentPanel.add(btnEditar);
		}
	}
		
		/**
		 * buscarCep
		 */
		private void buscarCep() {
			String logradouro = "";
			String tipoLogradouro = "";
			String resultado = null;
			String cep = txtCep.getText();
			try {
				URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
				SAXReader xml = new SAXReader();
				Document documento = xml.read(url);
				Element root = documento.getRootElement();
				for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
					Element element = it.next();
					if (element.getQualifiedName().equals("cidade")) {
						txtCidade.setText(element.getText());
					}
					if (element.getQualifiedName().equals("bairro")) {
						txtBairro.setText(element.getText());
					}
					if (element.getQualifiedName().equals("uf")) {
						cboUf.setSelectedItem(element.getText());
					}
					if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipoLogradouro = element.getText();
					}
					if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
					}
					if (element.getQualifiedName().equals("resultado")) {
						resultado = element.getText();
						if (resultado.equals("1")) {
							//lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
			} catch (Exception e) {
				System.out.println(e);
			}
				
	}
		
		

}
