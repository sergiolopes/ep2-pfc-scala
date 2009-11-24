package imagem
import org.junit._
import org.hamcrest.CoreMatchers._
import Assert._
import Constantes._

class FuncoesSuite {
  
  @Test
  def testaPreencheRetangulo:Unit= {
    val matriz = Matriz[Int](10,10)
    Funcoes.preencheRetangulo(matriz, 2, 4, 5, 8, 42)
    
    for (i <- 0 until matriz.linhas) {
      for (j <- 0 until matriz.colunas) {
        if (i < 2 || i > 4 || j < 5 || j > 8)
        	assertThat(matriz(i,j), nullValue())
        else
            assertThat(matriz(i,j), is(42))
      }
    }
  }
  
  @Test
  def testaPreencheBorda:Unit= {
    val matriz = Matriz[Int](NLins,NCols)
    Funcoes.preencheBorda(matriz)
    
    for (i <- 0 until Base)
      for (j <- 0 until matriz.colunas)
    	assertThat(matriz(i,j), nullValue())
    
    for (j <- 0 until matriz.colunas)
    	assertThat(matriz(Base,j), is(Preto))
    
    for (i <- Base + 1 until NLins)
      for (j <- 0 until matriz.colunas)
    	assertThat(matriz(i,j), is(Branco))
  }
}
