public class Grafo {

    public static class Aresta {

        private int v1, v2, peso;

        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }

        public int getV1() {return v1; }
        public void setV1(int v1) {this.v1 = v1;}

        public int getV2() {return v2;}
        public void setV2(int v2) {this.v2 = v2;}

        public int getPeso() {return peso;}
        public void setPeso(int peso) {this.peso = peso;}
    }


    private int matAdj[][];
    private int numVertices;
    private int pos[];

    public Grafo(int numVertices) {

        this.matAdj = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;

        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                this.matAdj[i][j] = Integer.MAX_VALUE;  // ou 0?
            }
            this.pos[i] = -1;
        }
    }


    public void inserirAresta(int v1, int v2, int peso) {
        this.matAdj[v1][v2] = peso;
    }


    public boolean existeAresta(int v1, int v2) {
        return matAdj[v1][v2] != Integer.MAX_VALUE;
    }


    public boolean listaAdjVazia(int v1) {
        for(int i = 0; i < this.numVertices; i++) {
            if(matAdj[v1][i] != Integer.MAX_VALUE) return false;
        }
        return true;
    }


    public Aresta proxAdj(int vertice) {
        this.pos[vertice] += 1;
        while((this.pos[vertice] < this.numVertices) && (this.matAdj[vertice][this.pos[vertice]] == Integer.MAX_VALUE)) {
            this.pos[vertice] += 1;
        }

        if(this.pos[vertice] == this.numVertices) {
            return new Aresta(vertice, this.pos[vertice], this.matAdj[vertice][this.pos[vertice]]);
        }
        return null;
    }


    public Aresta removerAresta(int v1, int v2) {
        if(this.matAdj[v1][v2] == Integer.MAX_VALUE) return null;
        else {
            Aresta arestaRemovida = new Aresta(v1, v2, matAdj[v1][v2]);
            this.matAdj[v1][v2] = Integer.MAX_VALUE;
            return arestaRemovida;
        }
    }


    public void imprimirGrafo() {
        System.out.println("Grafo:\n ");
        System.out.print("     ");


        for(int i = 0; i < this.numVertices; i++) {
            System.out.print(i + "      ");
        }
        System.out.print("\n");

        for(int i = 0; i < this.numVertices; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < this.numVertices; j++) {
                if(matAdj[i][j] == Integer.MAX_VALUE) {
                    System.out.print("  INF  ");
                }
                else {
                    System.out.print(" " + matAdj[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public int getAresta(int v1, int v2) {
        return this.matAdj[v1][v2];
    }
}
