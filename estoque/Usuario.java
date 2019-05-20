/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

public class Usuario {

	private String username;

	private String senha;
        
        

	public Usuario(String user, String senha) {
            this.username = user;
            this.senha = senha;
	}
        
        public Usuario(){
        
        }

	public String getUserName() {
		return this.username;
	}

	public String getSenha() {
		return this.senha;
	}

}


