import java.util.Random;

public class Main {
  
	public static void main(String[] args) {
		int[] a = new int[500];
		
    	Random objGenerator = new Random();
    	
        for (int i = 0; i < 500; i++){
        	int randomNumber = objGenerator.nextInt(10000 - 1 + 1) + 1;
        	a[i] = randomNumber;
         }
        
        int[] sa = is(a);
                        
        int elemento = sa[objGenerator.nextInt(500)];
        
        System.out.println("Elemento sorteado: " + elemento);
        
        
        long inicioBinaria = System.nanoTime();
        
        Integer p = Main.binaria(elemento, sa);
        
        long fimBinaria = System.nanoTime();
        
        long totalBinaria = fimBinaria - inicioBinaria;
        

        
        
        long inicioSequencial = System.nanoTime();
        
        int qtd = Main.sequencial(elemento, sa);
        
        long fimSequencial = System.nanoTime();
        
        long totalSequencial = fimSequencial  - inicioSequencial;
        
        
        
        long total = fimSequencial - inicioBinaria;
        
        long percentualBinaria = (totalBinaria * 100) / total;
        
        long percentualSequencial = (totalSequencial * 100) / total;
        
        System.out.println("Posição elemento escolhido: " + p);

        System.out.println("Quantidade de elementos iguais:" + qtd);
                
        System.out.println("Percentual busca binária em nano secundos: " + percentualBinaria + "%");
        
        System.out.println("Percentual busca sequencial: " + percentualSequencial + "%");        
	}
	
	  public static Integer binaria(int x, int numeros[]) {
		    int inicio = 0, fim = numeros.length - 1;
		    int meio;
		    while (inicio <= fim) {
		      meio = (inicio + fim) / 2;
		      if (x == numeros[meio])
		        return meio;
		      if (x < numeros[meio])
		        fim = meio - 1;
		      else
		        inicio = meio + 1;
		    }
		    return null;
	  }
	
	  public static int sequencial(int x, int numeros[]) {
		    final int n = numeros.length;
		    int qtdIguais = 0;
		    for (int i = 0; i < n; i++)
		      if (x == numeros[i])
		    	  qtdIguais++;
		    
		    return qtdIguais;
	  }
	
	  public static int[] is(int arr[]){
	        int n = arr.length;
	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;
	  
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	        
	        return arr;
	 }
	  
}
