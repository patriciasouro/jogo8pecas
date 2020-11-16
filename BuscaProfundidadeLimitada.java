package jogo8pecas;

import java.util.ArrayList;
import java.util.Stack;

public class BuscaProfundidadeLimitada {
      
    private Stack<No> fronteira = new Stack();
    private ArrayList<No> List = new ArrayList();
    private int limite = 4;
    
    public BuscaProfundidadeLimitada(){}
     
    public void busca(No noInicial){
        //Inserir no inicial na frontreira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        //Enquanto a fronteira nao estiver vazia
        
            while(!fronteira.isEmpty()){
            //pop retorna o elemento presente no topo da pilha e o remove.
            //no = remove fronteira
            no = fronteira.pop();
            List.add(no);
            int pai = List.size()-1;

            //testar se no e objetivo

            if(no.getEstado().EhObjetivo()){        
                imprimeCaminho(no);
                return;
            }

            if(no.getProfundidade()<limite){

                //gerar sucessor do no
                sucessores = no.GerarSucessor(pai);
                //Inserir sucessor na fronteira
                fronteira.addAll(sucessores);
            }
        }
    }
    public void imprimeCaminho(No noObjetivo){
        No aux = new No();
        aux = noObjetivo;
        aux.printNo();
        while (aux.getPai()!=-1){
            aux=this.List.get(aux.getPai());
            aux.printNo();
        }   
    }
}