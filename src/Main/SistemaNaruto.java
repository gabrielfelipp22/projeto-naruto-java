package Main;

import java.util.ArrayList;
import java.util.List;

public class SistemaNaruto {
	private List<Personagem> personagens;
	private Personagem hokageAtual;
	public SistemaNaruto() {
		personagens = new ArrayList<>();
	}
	
	private Personagem buscarPersonagemPorId(String id) {
		for(Personagem personagem: personagens) {
			if(personagem.getId().equalsIgnoreCase(id)) {
				return personagem;
			}
		}
		return null;
	}
	
	public boolean cadastrarPersonagem(String id, String nome, String claDoPersonagem) {
		if(buscarPersonagemPorId(id) != null) {
			return false;
		}try {
			Personagem personagem = new Personagem(id, nome, claDoPersonagem);
			personagens.add(personagem);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	public void consultarPersonagemPorId(String id) {
		Personagem personagem = buscarPersonagemPorId(id);
		if(personagem == null) {
			System.out.println("Personagem não encontrado!");
		}else {
			System.out.println("Id do Personagem: " + personagem.getId());
			System.out.println("Nome do Personagem: " + personagem.getNome());
			System.out.println("cla do Personagem: " + personagem.getClaDoPersonagem());
			System.out.println("Quantidade de pontos do Personagem: " + personagem.getQuantidadeDePontos());
			System.out.println("Nivel do Personagem: " + personagem.getNivel().nomeDoNivel());
		}
	}
	private RankMissao converterRank(String letra) {
		switch(letra) {
		case "D":
			return new RankD();
		case "C":
			return new RankC();
		case "B":
			return new RankB();
		case "A":
			return new RankA();
		case "S":
			return new RankS();
		default:
			return null;
		}
	}
	public void registrarMissao(String id, String letraRank) {
		Personagem personagem = buscarPersonagemPorId(id);
		if(personagem == null) {
			System.out.println("Personagem não encontrado!");
		}else {
			RankMissao rankConvertido = converterRank(letraRank);
			if(rankConvertido == null) {
				System.out.println("Nivel de missao inválido");
			}else {
				personagem.registrarMissao(rankConvertido);
				 verificarTronoHokage(personagem);
			}
		}
	}
	private void verificarTronoHokage(Personagem candidato) {
		if(candidato.getQuantidadeDePontos() < 201) {
			return;
		}
		if(hokageAtual == null) {
			candidato.setNivelPersonagem(new Hokage());
			hokageAtual = candidato;
			return;
		}
		if(hokageAtual.equals(candidato)) {
			return;
		}
		if(candidato.getQuantidadeDePontos()>= hokageAtual.getQuantidadeDePontos()) {
			hokageAtual.setNivelPersonagem(new Sanin());
			hokageAtual = candidato;
		}
	}
	public void listarPersonagens() {
		if(personagens.isEmpty()) {
			System.out.println("Lista vazia");
		}else {
			for(Personagem personagem: personagens) {
				System.out.println("Id do Personagem: " + personagem.getId());
				System.out.println("Nome do Personagem: " + personagem.getNome());
				System.out.println("cla do Personagem: " + personagem.getClaDoPersonagem());
				System.out.println("Quantidade de pontos do Personagem: " + personagem.getQuantidadeDePontos());
				System.out.println("Nivel do Personagem: " + personagem.getNivel().nomeDoNivel());
				System.out.println("*************************");
			}
		}
	}
	public void removerPersonagemPorId(String id) {
		Personagem personagem = buscarPersonagemPorId(id);
		if(personagem == null) {
			System.out.println("Personagem não encontrado");
		}else {
			personagens.remove(personagem);
		}
	}
}
