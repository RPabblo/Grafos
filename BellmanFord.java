public class BellmanFord {
    
    private Grafo grafo;
    private int raiz;
    private int matrizDeCustos[][];
    private int custos[];


    public BellmanFord(Grafo grafo, int raiz) {
        this.grafo = grafo;
        this.raiz = raiz;
    }

 
    public int c(int l, int i) {
        if(l == 0 && i > 0) {
            return Integer.MAX_VALUE;
        }
        
        if(l == 0 && i == 0) {
            return 0;
        }

        // Para cada vizinho:
        //return min(matrizDeCustos[l - 1][i], min(matrizDeCustos[l - 1][j] + grafo.getAresta(j, i)));

        return i;
    }

    public void calcular() {
        matrizDeCustos = new int[grafo.getNumVertices()][grafo.getNumVertices()];
        matrizDeCustos[0][0] = 0;
        
        for(int i = 1; i < grafo.getNumVertices(); i++) {
            matrizDeCustos[0][i] = Integer.MAX_VALUE;
        }

        for(int l = 1; l < grafo.getNumVertices() - 1 ; l++) {
            for(int i = 0; i < grafo.getNumVertices(); i++) {
                matrizDeCustos[l][i] = c(l, i);
            }
        }
    }

    public void imprimirMatrizDeCustos() {
        for(int l = 0; l < grafo.getNumVertices(); l++) {
            for(int i = 0; i < grafo.getNumVertices(); i++) {
                System.out.println();
            }
        }
    }

    public void imprimirGrafo() {
        System.out.println("Grafo:\n ");
        System.out.print("     ");


        for(int l = 0; l < grafo.getNumVertices(); l++) {
            System.out.print(l + "      ");
        }
        System.out.print("\n");

        for(int l = 0; l < grafo.getNumVertices(); l++) {
            System.out.print(l + " ");
            for(int i = 0; i < grafo.getNumVertices(); i++) {
                if(matrizDeCustos[l][i] == Integer.MAX_VALUE) {
                    System.out.print("  INF  ");
                }
                else {
                    System.out.print(" " + matrizDeCustos[l][i] + " ");
                }
            }
            System.out.print("\n");
        }
    }
}
