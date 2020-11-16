package jogo8pecas;

import java.util.ArrayList;

public class No implements Comparable <No> {
    private Estado estado;
    private int profundidade;//custo
    private int pai;
    private int heuristica;//heuristica 
    private int funcaoAvaliacao; //função de avaliação é a heuristica mais a profundidade do no
        
    public No(Estado estado, int pai, int profundidade){
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        this.heuristica = heuristicaPosicaoErrada(estado);
        this.funcaoAvaliacao = this.heuristica+this.profundidade;       
    }
    
    public No (){}

    public int getHeuristica() {
        return heuristica;
    }

    public int getfuncaoAvaliacao() {
        return funcaoAvaliacao;
    }
    public void setHeuristica(int h) {
        this.heuristica = h;
    }

    public void setfuncaoAvaliacao(int f) {
        this.funcaoAvaliacao = f;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado e) {
        this.estado = e;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }
    
    
     public ArrayList<No> GerarSucessor(int pai){
       ArrayList sucessores = new ArrayList();
       Estado e;
       No noSuc;
       
       //Direita
       e = this.estado.GerarSucessor('d');
       if(e!=null){
           noSuc = new No( e, pai, this.profundidade+1);
           sucessores.add(noSuc);
       }
       
       //Esquerda
       e = this.estado.GerarSucessor('e');
       if(e!=null){
           noSuc = new No( e, pai, this.profundidade+1);
           sucessores.add(noSuc);
       }
       
       //Cima
       e = this.estado.GerarSucessor('c');
       if(e!=null){
           noSuc = new No( e, pai, this.profundidade+1);
           sucessores.add(noSuc);
       }
       
       //Baixo
       e = this.estado.GerarSucessor('b');
       if(e!=null){
           noSuc = new No( e, pai, this.profundidade+1);
           sucessores.add(noSuc);
       }
       
       return sucessores;
    }
     
    public void printNo(){
        System.out.println("Estado: "); 
        this.estado.printEstado();
        System.out.println("Pai: "+this.pai);
        System.out.println("Profundidade: "+this.profundidade);
     
    }
    
    public int heuristicaManhattan(Estado estadoFinal){
        return Math.abs(estadoFinal.getLinhaVazia() - estado.getLinhaVazia())+
                Math.abs(estadoFinal.getColunaVazia() - estado.getColunaVazia());
    }
    
    public int heuristicaPosicaoErrada(Estado matAtual){
        int objetivo[][] = {{1,2,3},{4,5,6},{7,8,0}};
        int aux[][]= matAtual.getMat();
        int h=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(aux[i][j] != objetivo[i][j]){
                    return h++;
                }
            }
        }return h;
    }

    @Override
    public int compareTo(No o) {
        if(this.getfuncaoAvaliacao()>((No)o).getfuncaoAvaliacao())//compara a função avaliação é maior q o nó e retorna 1
                return 1;
        else if(this.getfuncaoAvaliacao()<((No)o).getfuncaoAvaliacao())//compara a função avaliação é menor q o nó e retorna 1
                return -1;
                
                return 0;
    
    }

}
