import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author Victor
 *
 */
public class UserInteraction {
	private HashMap<String, Beer> hash;
	
	public UserInteraction(HashMap<String, Beer> hash){
		this.hash = hash;
	}
	
	public void printUsage(){
		System.out.println("Olá, eu sou a Máquina Cervejeira™.");
		System.out.println("Digite o estilo da cerveja que eu direi a menor temperatura ideal de consumo.");
		System.out.println("Digite \"adicionar\" ou \"remover\" para adicionar ou remover um estilo,"
				+ " \"listar\" para listar os estilos, \"ajuda\" para exibir essa mensagem novamente"
				+ " ou \"sair\" para sair");
	}
	
	public void printBeer(Beer beer){
		if(beer == null){
			System.out.println("Esse estilo não está catalogado. Você pode adicioná-lo usando o comando \"adicionar\".");
			return;
		}
		
		System.out.println("Estilo: " + beer.getName());
		System.out.println("Temperatura mínima: " + beer.getMinTemp());
	}
	
	public Beer readAdd(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String name = null;
		int min, max;
		
		try {
			System.out.println("Digite o estilo:");
			name = br.readLine().toUpperCase();
			
			System.out.println("Digite a temperatura mínima de consumo:");
			min = Integer.valueOf(br.readLine().toUpperCase());
			
			System.out.println("Digite a temperatura máxima de consumo:");
			max = Integer.valueOf(br.readLine().toUpperCase());
		} catch (IOException e) {
			System.out.println("Input inválido");
			e.printStackTrace();
			return null;
		}
		
		Beer beer = new Beer(name, min, max);
		return beer;
	}
	
	private void remove(String name){
		hash.remove(name);
		System.out.println(name + " removido.");
	}
	
	public int readInput(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String option = null;
		try {
			option = br.readLine().toUpperCase();
		} catch (IOException e) {
			System.out.println("Opção inválida.");
			e.printStackTrace();
			return -2;
		}
		
		switch(option){
		case "ADICIONAR":
			Beer beer = readAdd();
			hash.put(beer.getName(), beer);
			System.out.println("Adicionado!");
			break;
			
		case "REMOVER":
			String name;
			try {
				System.out.println("Estilo: ");
				name = br.readLine().toUpperCase();
			} catch (IOException e) {
				System.out.println("Estilo inválido.");
				e.printStackTrace();
				return -2;
			}
			remove(name);
			break;
			
		case "LISTAR":
			Collection<Beer> beers = hash.values();
			Iterator<Beer> it = beers.iterator();
			
			while(it.hasNext()){
				Beer element = it.next();
				System.out.println("Estilo: " + element.getName());
				System.out.println("Temperatura mínima: " + element.getMinTemp() + "\n");
			}
			break;
			
		case "AJUDA":
			printUsage();
			break;
			
		case "SAIR":
			return -1;
		
		default:
			printBeer(hash.get(option));
			break;
		}
		
		return 0;
	}
}
