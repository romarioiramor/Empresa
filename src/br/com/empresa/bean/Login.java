package br.com.empresa.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login {

	private String login ;
	private String senha;
	
	public Boolean autenticar() {
		if(this.login != null && this.senha != null) {
			if(this.login.equals(login) && this.senha.equals(senha))
		return true;
	}
		return false;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
