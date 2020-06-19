package database;

public class Ator {
	private int id_ator;
	private String nome_ator;
	
	public Ator() { }
	
	public Ator(int id_ator, String nome_ator) {
		this.id_ator = id_ator;
		this.nome_ator = nome_ator;
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

	@Override
	public String toString() {
		return "Ator [ID= " + id_ator + ", Nome= " + nome_ator + "]";
	}
}
