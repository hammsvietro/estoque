package estoque;

import java.util.ArrayList;

public class Memoria {
        public Memoria() {

	}
        
        private static Memoria memoria = new Memoria();
    
	private ArrayList<Produto> produtoList = new ArrayList<Produto>();

	private ArrayList<Usuario> usuarioList = new ArrayList<Usuario>();

	
        
        public static Memoria get(){
            if( memoria == null )
                memoria = new Memoria();
            return memoria;
        
        }
        
	public boolean addProduto(Produto produto) {
            return this.produtoList.add(produto);
	}

	public boolean addUsuario(Usuario usuario) {
            return this.usuarioList.add(usuario);
	}
        
        public boolean addAdmin(Admin admin){
            return this.usuarioList.add(admin);
        }
        
        
        public ArrayList<Usuario> getUsuarios(){
            return this.usuarioList;
        }
        
        public ArrayList<Produto> getProdutos(){
            return produtoList;
        }
        
        public boolean editProduto(Produto antigo, Produto novo) {
            int i = 0;
            for( Produto x : produtoList ){
                if(x.getId()==antigo.getId() && x.getNome().equals(antigo.getNome()) && x.getQuantidade() == antigo.getQuantidade() && x.getValor() == antigo.getValor()){
                    produtoList.get(i).setId(novo.getId());
                    produtoList.get(i).setNome(novo.getNome());
                    produtoList.get(i).setQuantidade(novo.getQuantidade());
                    produtoList.get(i).setValor(novo.getValor());
                    return true;
                }
            i++;
            }
        return false;
        }
        
        public boolean rmProduto(Produto produto) {
            int i = 0;
            for(Produto x : produtoList){
                if(x.getId()==produto.getId()){
                    produtoList.remove(i);
                    return true;   
                }
            i++;      
            }
            
            return false;
	}
        
}

