/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;
import java.util.ArrayList;


public class Admin extends Usuario {
        
        private String username;

	private String senha;
        
    public Admin(){}
        
    public Admin(String username, String senha){
            super(username, senha);
	}
        
	public void addProduto(ArrayList<Produto> x, Produto produto) {
            x.add(produto);
	}

	public void alterarProduto(ArrayList<Produto> x) {
            
	}

	public void removeProduto(ArrayList<Produto> x, int id) {
            
            for(Produto y : x){
                if(y.getId()==id){
                    x.remove(y);
                }
            }
            
	}

}
