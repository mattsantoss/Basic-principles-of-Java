package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "";
	private String user = "";
	private String password = "";

	private Connection conectar() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conexão

	public void testeConexao() {
		try {
			Connection conn = conectar();
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD CREATE */
	public void insertContact(JavaBeans contact) {
		String create = "insert into contatos(nome, fone, email) values (?,?,?)";

		try {
			// open connection
			Connection conn = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);

			// subistituir os paramtros (?) pelo conteudo das variáveis JavaBeans
			pst.setString(1, contact.getNome());
			pst.setString(2, contact.getFone());
			pst.setString(3, contact.getEmail());

			// executar a query
			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by nome";
		try {
			// open connection
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebe os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			conn.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//editar contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?, fone=?, email=? where idcon=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
