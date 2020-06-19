package database;

public class filme_X_ator {
	
	private int id_ator;
	private String nome_ator;
	private int id_filme;
	private String titulo_filme;
	private int id_ator_filme;
	
	public void Ator_Filme() { }
	
	public void Ator_Filme(int id_ator, String nome_ator, int id_filme, String titulo_filme, int id_ator_filme) {
		this.id_ator = id_ator;
		this.nome_ator = nome_ator;
		this.id_filme = id_filme;
		this.titulo_filme = titulo_filme;
		this.id_ator_filme = id_ator_filme;
	}

	public int getId() {
		return id_ator;
	}

	public void setId(int id_ator) {
		this.id_ator = id_ator;
	}

	public String getNome() {
		return nome_ator;
	}

	public void setNome(String nome_ator) {
		this.nome_ator = nome_ator;
	}
	
	public int getId1() {
		return id_filme;
	}

	public void setId1(int id_filme) {
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
		return "Filme X Ator [ID Ator= " + id_ator + ", Nome Ator= " + nome_ator + " ||| ID Filme= " + id_filme + ", Título Filme= " + titulo_filme + ", ID Ator Filme= " + id_ator_filme + "]";
	}
}
