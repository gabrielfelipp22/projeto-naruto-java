package Main;

import java.util.Scanner;
public class Console {
	private Scanner scanner;
	private SistemaNaruto sistema;
	
	public Console() {
		scanner = new Scanner(System.in);
		sistema = new SistemaNaruto();
	}
	
	private int lerInteiro(String mensagem) {
		while(true) {
			System.out.println(mensagem);
			String entrada = scanner.nextLine();
			try {
				return Integer.parseInt(entrada);
			} catch(NumberFormatException e) {
				System.out.println("Número inválido!");
			}
		}
	}
	private String lerTexto(String mensagem) {
		System.out.println(mensagem);
		return scanner.nextLine();
	}
	
	private void menu() {
		System.out.println("=== SISTEMA DE CADASTRO === ");
		System.out.println("1 - Cadastrar personagem ");
		System.out.println("2 - Consultar personagem ");
		System.out.println("3 - Remover personagem ");
		System.out.println("4 - Realizar Missao ");
		System.out.println("5 - Listar personagens ");
		System.out.println("0 - Sair ");
	}
	private void menuLetrasMissao() {
		System.out.println("Rank S - 80 pontos ");
		System.out.println("Rank A - 40 pontos ");
		System.out.println("Rank B - 20 pontos ");
		System.out.println("Rank C - 10 pontos ");
		System.out.println("Rank D - 5 pontos ");
		System.out.println("Escolha o rank da missão: ");
		
	}
	
	private void cadastrarPersonagem() {
		String id = lerTexto("ID: ");
		String nome = lerTexto("Nome: ");
		String cla = lerTexto("Clã do personagem: ");
		boolean cadastrou = sistema.cadastrarPersonagem(id, nome, cla);
		if(cadastrou) {
			System.out.println("Personagem Cadastrado!");
		}else {
			System.out.println("Falha ao cadastrar!");
		}
	}
	private void removerPersonagem(){
		String id = lerTexto("ID: ");
		sistema.removerPersonagemPorId(id);
	}
	private void consultarPersonagemPorId() {
		String id = lerTexto("ID: ");
		sistema.consultarPersonagemPorId(id);
	}
	private void registrarMissao() {
		String id = lerTexto("ID: ");
		menuLetrasMissao();
		String letra = lerTexto("Letra da missao: ");
		sistema.registrarMissao(id, letra);
	}
	private void listarPersonagens() {
		sistema.listarPersonagens();
	}
	
	 public void iniciar() {
	        int opcao;
	        
	        do {
	            menu();
	            opcao = lerInteiro("Opcao: ");
	            
	            executarOpcao(opcao);
	            
	            if (opcao != 0) {
	                System.out.println();
	            }
	            
	        } while (opcao != 0);
	        
	        scanner.close();
	    }
	 private void executarOpcao(int opcao) {
	        switch (opcao) {
	            case 1:
	                cadastrarPersonagem();
	                break;
	            case 2:
	                consultarPersonagemPorId();
	                break;
	            case 3:
	                removerPersonagem();
	                break;
	            case 4:
	                registrarMissao();
	                break;
	            case 5:
	            		listarPersonagens();
	                break;
	            case 0:
	                System.out.println("Programa encerrado.");
	                break;
	            default:
	                System.out.println("Opcao invalida.");
	        }
	    }
}
