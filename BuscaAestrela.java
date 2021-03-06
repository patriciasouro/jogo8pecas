package jogo8pecas;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BuscaAestrela{
   private PriorityQueue<No> Fronteira;
   private ArrayList<No> Lista;
   private int Indice;
   
   public BuscaAestrela(){
       Fronteira = new PriorityQueue<>();
       Lista = new ArrayList();
       Indice = 10;
   }

public void BuscaAestrela(No noInicial){
    //Inserir no inicial na frontreira
    Fronteira.add(noInicial);
    No no = new No();
    ArrayList<No> sucessores = new ArrayList();
    //Enquanto a fronteira nao estiver vazia
        while(!Fronteira.isEmpty())
            //no =remove fronteira
            no = Fronteira.poll();
            Lista.add(no); 
           int pai = Lista.size()-1;
            //testar se no e objetivo
            if(no.getEstado().EhObjetivo()){
                imprimeCaminho(no);
                return;
            }

            if(no.getfuncaoAvaliacao() < Indice){
            //gerar sucessor do no
            sucessores = no.GerarSucessor(pai);
            //Inserir sucessor na fronteira
            Fronteira.addAll(sucessores);
            }
}
    public void imprimeCaminho(No noObjetivo){
        No aux = new No();
        aux = noObjetivo;
        aux.printNo();
        while (aux.getPai()!=-1){
        aux=this.Lista.get(aux.getPai());
        aux.printNo();
        }   
    }
}


