/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import java.util.*;



public class Facade {
    
    
    public Facade(){
    }
    
    static Memoria memoria = Memoria.get();
    
    ArrayList<Produto> produtoList = new ArrayList();
    ArrayList<Usuario> usuarioList = new ArrayList();
    
    public static boolean addUsuario(Usuario usuario){
        if(usuarioDisponivel(usuario)==false){
            return false;
        }
        return memoria.addUsuario(usuario);
    }
    
    public static boolean addProduto(Produto produto){
        return memoria.addProduto(produto);
    }
    
    public static boolean addAdmin(Admin admin){
        if(usuarioDisponivel(admin)==false){
            return false;
        }
        return memoria.addAdmin(admin);
    }
    
    public static ArrayList<Usuario> getUsuarios(){
        return memoria.getUsuarios();
    }
    
    public static ArrayList<Produto> getProdutos(){
        return memoria.getProdutos();
    }
    
    public static boolean editProduto(Produto antigo, Produto novo){
        return memoria.editProduto(antigo,novo);
    }
    
    public static boolean rmProduto(Produto produto){
        return memoria.rmProduto(produto);
    }
    
    public static boolean usuarioDisponivel(Usuario usuario){
        
        for(Usuario x : memoria.getUsuarios()){
            if(x.getUserName().equals(usuario.getUserName()))
                return false;
        }
        
        return true;
    }
    
    
    
    public static void init(){
        
        Admin admin = new Admin("Pedro","123");
        memoria.addAdmin(admin);
    }
}
