
package jogo8pecas;

/**
 *
 * @author Patricia
 */
public class Jogo8pecas {

    public static void main(String[] args) {
    int estadoInicial [][]={{0,2,3},
                            {1,4,6},
                            {7,5,8}};
    Estado e = new Estado(estadoInicial);
    No no = new No(e, -1, 0);
    
    /*
    BuscaProfundidadeLimitada b = new BuscaProfundidadeLimitada();
    b.busca(no);
    */
    
    BuscaLargura l = new BuscaLargura();
    l.busca(no);
    
    }
}