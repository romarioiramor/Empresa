package br.com.empresa.usuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.empresa.bean.Usuario;
import br.com.empresa.factory.ConexaoFactory;
import java.sql.ResultSet;

public class UsuarioDAO {

		public void salvar(Usuario u)throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO usuario ");
			sql.append("(nome, email, senha, cpf, telefone, celular, endereco, "
					+ "bairro, cidade, uf, cep, instituicaoEnsino, polo, "
					+ "curso, turno, semestre, previsaoFormatura, anexoCurriculo, usuario)" );
			sql.append("VALUES (?)");
			
			Connection conexao = (Connection) ConexaoFactory.conectar();
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
			comando.setString(1, u.getNome(), u.getEmail(), u.getSenha(), u.getCpf(),
					u.getTelefone(), u.getCelular(), u.getEndereco(), u.getBairro(), 
					u.getCidade(), u.getUf(), u.getCep(), u.getInstituicaoEnsino(), 
					u.getPolo(), u.getCurso(), u.getTurno(), u.getSemestre(), 
					u.getPrevisaoFormatura(), u.getAnexoCurriculo(), u.getUsuario());
			
			comando.executeUpdate();						
		}
		
		public void excluir(Usuario u) throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM usuario ");
			sql.append("WHERE codigo = ? ");
			
			Connection conexao = (Connection) ConexaoFactory.conectar();
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
			comando.setLong(1, u.getCodigo());
			
			comando.executeUpdate();			
		}
		
		public void editar(Usuario u)  throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE usuario ");
			sql.append("SET nome, email, senha, cpf, telefone, celular, "
					+ "endereco, bairro, cidade, uf, cep, instituicaoEnsino, "
					+ "polo, curso, turno, semestre, previsaoFormatura, anexoCurriculo, usuario");
			sql.append("WHERE codigo = ? ");
			
			Connection conexao = (Connection) ConexaoFactory.conectar();
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
			comando.setString(1, u.getNome(), u.getEmail(), u.getSenha(), u.getCpf(),
					u.getTelefone(), u.getCelular(), u.getEndereco(), u.getBairro(), 
					u.getCidade(), u.getUf(), u.getCep(), u.getInstituicaoEnsino(), 
					u.getPolo(), u.getCurso(), u.getTurno(), u.getSemestre(), 
					u.getPrevisaoFormatura(), u.getAnexoCurriculo(), u.getUsuario());
			comando.setLong(2, u.getCodigo());
			
			comando.executeUpdate();
		}
		
		public Usuario buscarPorCodigo(Usuario u) throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT codigo,  nome, email, senha, cpf, telefone, celular, "
					+ "endereco, bairro, cidade, uf, cep, instituicaoEnsino, "
					+ "polo, curso, turno, semestre, previsaoFormatura, anexoCurriculo, "
					+ "usuario");
			sql.append("FROM usuario ");
			sql.append("WHERE codigo = ? ");
			
			Connection conexao = (Connection) ConexaoFactory.conectar();
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
			comando.setLong(1, u.getCodigo());
			
			ResultSet resultado = comando.executeQuery();
			
			Usuario retorno = null;
			
			if (resultado.next()) {
				retorno = new Usuario();
				retorno.setCodigo(resultado.getLong("codigo"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setEmail(resultado.getString("email"));
				retorno.setSenha(resultado.getString("senha"));
				retorno.setCpf(resultado.getString("cpf"));
				retorno.setTelefone(resultado.getString("telefone"));
				retorno.setCelular(resultado.getString("celular"));
				retorno.setEndereco(resultado.getString("endereco"));
				retorno.setBairro(resultado.getString("bairro"));
				retorno.setCidade(resultado.getString("cidade"));
				retorno.setUf(resultado.getString("uf"));
				retorno.setCep(resultado.getString("cep"));
				retorno.setInstituicaoEnsino(resultado.getString("instituicaoEnsino"));
				retorno.setPolo(resultado.getString("polo"));
				retorno.setCurso(resultado.getString("curso"));
				retorno.setTurno(resultado.getString("turno"));
				retorno.setSemestre(resultado.getString("semestre"));
				retorno.setPrevisaoFormatura(resultado.getString("previsaoFormatura"));
				retorno.setAnexoCurriculo(resultado.getString("anexoCurriculo"));
				retorno.setUsuario(resultado.getString("usuario"));
			}
			return retorno;
		}
		
		public ArrayList<Usuario> listar() throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT codigo,  nome, email, senha, cpf, telefone, celular, "
					+ "endereco, bairro, cidade, uf, cep, instituicaoEnsino, "
					+ "polo, curso, turno, semestre, previsaoFormatura, anexoCurriculo, "
					+ "usuario");
			sql.append("FROM usuario ");
			sql.append("ORDER BY descricao ASC ");
			
			Connection conexao = (Connection) ConexaoFactory.conectar();
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
			
			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			
			while(resultado.next()) {
				Usuario u = new Usuario();
				u.setCodigo(resultado.getLong("codigo"));
				u.setNome(resultado.getString("nome"));
				u.setEmail(resultado.getString("email"));
				u.setSenha(resultado.getString("senha"));
				u.setCpf(resultado.getString("cpf"));
				u.setTelefone(resultado.getString("telefone"));
				u.setCelular(resultado.getString("celular"));
				u.setEndereco(resultado.getString("endereco"));
				u.setBairro(resultado.getString("bairro"));
				u.setCidade(resultado.getString("cidade"));
				u.setUf(resultado.getString("uf"));
				u.setCep(resultado.getString("cep"));
				u.setInstituicaoEnsino(resultado.getString("instituicaoEnsino"));
				u.setPolo(resultado.getString("polo"));
				u.setCurso(resultado.getString("curso"));
				u.setTurno(resultado.getString("turno"));
				u.setSemestre(resultado.getString("semestre"));
				u.setPrevisaoFormatura(resultado.getString("previsaoFormatura"));
				u.setAnexoCurriculo(resultado.getString("anexoCurriculo"));
				u.setUsuario(resultado.getString("usuario"));
				
				lista.add(u);
				
			}
			
			return lista;
		}
}
