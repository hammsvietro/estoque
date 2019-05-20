package estoque;

public class Produto {

	private long quantidade;

	private long id;

	private String nome;
        
        private double valor;

	public Produto() {
            
	}

    

	public Produto(long quantidade, long id, String nome, double valor) {
           this.setQuantidade(quantidade);
           this.setId(id);
           this.setNome(nome);
           this.setValor(valor);
	}

	public void setQuantidade(long quantidade) {
            this.quantidade=quantidade;
	}

	public void setId(long id) {
            this.id=id;
	}
        
        public void setValor(double valor){
            this.valor=valor;
        }
        
	public void setNome(String nome) {
            this.nome=nome;
	}

	public long getQuantidade() {
		return this.quantidade;
	}

	public long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}
        
        public double getValor(){
            return this.valor;
        }
        
        
        
}
