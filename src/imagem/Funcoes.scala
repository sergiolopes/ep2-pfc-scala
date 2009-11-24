package imagem
import modelo._
import Constantes._
import java.io._

object Funcoes {
	def geraImagem(s: List[ElemSilhueta], nomeArq: String): Unit = {
	  val file = new FileWriter(nomeArq)
      geraImagem(s, file)
      file.close
	}
  
    def geraImagem(s: List[ElemSilhueta], writer: Writer): Unit = {
	  val matriz = geraMatriz(s)
      val out = new PrintWriter(writer)
      out.println("P2")
      out.println("%d %d" format (NCols,NLins))
      out.println(Branco)
      out.print(matriz.toString)
      out.close
	}
 
	def geraMatriz(silhueta: List[ElemSilhueta]):Matriz[Int] = {
	  val matriz = Matriz[Int](NLins,NCols)
	  preencheBorda(matriz)
   
	  var atual = ElemSilhueta(0,0)
	  for (proximo <- silhueta) {
	    val lin1 = Base - atual.h - 1
	    
	    preencheRetangulo(matriz, lin1, Base - 1, atual.x, proximo.x, Cinza)
	    preencheRetangulo(matriz, 0, lin1, atual.x, proximo.x, Branco)
        atual = proximo
	  }
   
	  if (atual.x < NCols - 1)
		  preencheRetangulo(matriz, 0, Base - 1, atual.x, NCols - 1, Branco)
   
	  matriz
	}
 
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
