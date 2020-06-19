package database;

public class Filme {
	
	private int id_filme;
	private String titulo_filme;
	private int id_ator_filme;
	
	public Filme() { }
	
	public Filme(int id_filme, String titulo_filme, int id_ator_filme) {
		this.id_filme = id_filme;
		this.titulo_filme = titulo_filme;
		this.id_ator_filme = id_ator_filme;
	}

	public int getId() {
		return id_filme;
	}

	public void setId(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getTitulo() {
		return titulo_filme;
	}

	public void setTitulo(String titulo_filme) {
		this.titulo_filme = titulo_filme;
	}
	
	public int getIdAtor() {
		return id_ator_filme;
	}
	
	public void setIdAtor(int id_ator_filme) {
		this.id_ator_filme = id_ator_filme;
	}


	@Override
	public String toString() {
		return "Filme [ID= " + id_filme + ", Título= " + titulo_filme + ", ID Ator Filme= " + id_ator_filme + "]";
	}
}
