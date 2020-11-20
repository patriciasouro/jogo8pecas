package jogo8pecas;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuscaLargura {

    private ArrayList<No> List = new ArrayList();
    private Queue<No> fronteira = new PriorityQueue<>();
    private int limite = 100;

public BuscaLargura(){}

public void busca(No noInicial){

        //Inserir no inicial na frontreira
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();

        while (!fronteira.isEmpty()){
        //poll remove o elemento presente no inicio da fila.
        no = fronteira.poll();
        List.add(no);
        int pai = List.size()-1;
              
        //verificar se o nó é pbjetivo
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
