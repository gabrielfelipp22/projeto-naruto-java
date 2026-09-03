package Main;

public class Personagem {
	private String id;
	private String nome;
	private String claDoPersonagem;
	private NivelPersonagem nivel;
	private int quantidadeDePontos;
	
	public Personagem(String id, String nome, String claDoPersonagem ) throws Exception{
		if(id == null || id.isEmpty()) {
			throw new Exception("Id do personagem inválido");
		}
		if(nome == null || nome.isEmpty()) {
			throw new Exception("Nome inválido"); 
		}
		if(claDoPersonagem == null || claDoPersonagem.isEmpty()) {
			throw new Exception("Clã inválido");
		}
		this.id = id;
		this.nome = nome;
		this.claDoPersonagem = claDoPersonagem;
		this.nivel = new Genin();
		this.quantidadeDePontos = 0;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getClaDoPersonagem() {
		return claDoPersonagem;
	}

	public NivelPersonagem getNivel() {
		return nivel;
	}

	public int getQuantidadeDePontos() {
		return quantidadeDePontos;
	}
	
	public void registrarMissao( RankMissao missao) {
		if(missao != null) {
		quantidadeDePontos += missao.calcularPontos();
		atualizarNivel();
		}
	}
	public void atualizarNivel() {
		if(quantidadeDePontos < 50) {
			nivel = new Genin();
		}
		else if (quantidadeDePontos <= 99 ) {
			nivel = new Chunin();
		}
		else if(quantidadeDePontos <= 149) {
			nivel = new Jounin();
		}
		else if(quantidadeDePontos <= 200) {
			nivel = new Sanin();
		}
		else {
			nivel = new Hokage();
		}
	}
}
