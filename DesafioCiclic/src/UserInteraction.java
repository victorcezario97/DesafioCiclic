import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Victor
 *
 */
public class UserInteraction {
	
	public void printUsage(){
		System.out.println("Ol�, eu sou a M�quina Cervejeira�.");
		System.out.println("Digite o estilo da cerveja que eu direi a menor temperatura ideal de consumo.");
		System.out.println("Digite \"adicionar\" ou \"remover\" para adicionar ou remover um estilo");
	}
	
	public void printBeer(Beer beer){
		if(beer == null){
			System.out.println("Esse estilo n�o est� catalogado. Voc� pode adicion�-lo usando o comando \"adicionar\".");
			return;
		}
		
		System.out.println("Estilo: " + beer.getName());
		System.out.println("Temperatura m�nima: " + beer.getMinTemp());
	}
	
	public Beer printAdd(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String name = null;
		int min, max;
		
		try {
			System.out.println("Digite o estilo:");
			name = br.readLine();
			
			System.out.println("Digite a temperatura m�nima de consumo:");
			min = Integer.valueOf(br.readLine());
			
			System.out.println("Digite a temperatura m�xima de consumo:");
			max = Integer.valueOf(br.readLine());
		} catch (IOException e) {
			System.out.println("Input inv�lido");
			e.printStackTrace();
			return null;
		}
		
		Beer beer = new Beer(name, min, max);
		return beer;
	}
}
