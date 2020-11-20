package jogo8pecas;
/**
 *
 * @author Patricia
 */
public class Jogo8pecas {

    public static void main(String[] args) {
     
    int estadoInicial [][]={{1,2,3},{4,5,0},{7,8,6}};    
    //int estadoInicial [][]={{0,2,3},{1,4,6},{7,5,8}};
   
    Estado e = new Estado(estadoInicial);
    No no = new No(e, -1, 0);
    
 //   BuscaLargura l = new BuscaLargura(); l.busca(no); 
    BuscaProfundidadeLimitada b = new BuscaProfundidadeLimitada(); b.busca(no);    
    
    
    }
}
