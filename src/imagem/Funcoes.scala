package imagem
import modelo._
import Constantes._

object Funcoes {
	def geraImagem(s: List[ElemSilhueta], nomeArq: String): Unit = throw new RuntimeException
 
	def preencheBorda(matriz: Matriz[Int]):Unit = {
	  preencheRetangulo(matriz, Base, BordaInf, 0, NCols - 1, Branco)
      preencheRetangulo(matriz, Base, Base, 0, NCols - 1, Preto)
	}

    def preencheRetangulo(a: Matriz[Int], 
		      lin1: Int, lin2: Int,
		      col1: Int, col2: Int, k: Int): Unit = {
   
      // validacoes
      if (lin1 < 0 || lin2 < 0 || col1 < 0 || col2 < 0)
        throw new IllegalArgumentException("Todos os argumentos devem ser positivos")
      if (lin1 > lin2 || col1 > col2)
        throw new IllegalArgumentException("Os indices de linhas e colunas devem ser crescentes")
      
      for (i <- lin1 to lin2)
        for (j <- col1 to col2)
          a(i,j) = k;
   }
}
