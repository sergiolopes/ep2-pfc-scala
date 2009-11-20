package imagem

import org.junit._
import org.hamcrest.CoreMatchers._
import Assert._

class MatrizTest {
  
  @Test
  def testaDimensoesSaoMantidas:Unit = {
    val matriz = Matriz[Int](10, 20)
    assertThat(matriz.linhas, is(10))
    assertThat(matriz.colunas, is(20))
  }
  
  @Test
  def testaValorDefaultENull = {
    val matriz = Matriz[Int](10, 20)
    for (i <- 0 to matriz.linhas - 1)
      for (j <- 0 to matriz.colunas - 1)
    	  assertThat(matriz(i,j), nullValue())
  }
  
  @Test{val expected = classOf[ArrayIndexOutOfBoundsException]}
  def testaExceptionSeEstourarDimensoes = {
    val matriz = Matriz[Int](10, 20)
    matriz(10,20) = 42
  }
  
  @Test{val expected = classOf[IllegalArgumentException]}
  def testaExceptionSeUsarDimensoesNegativas:Unit = Matriz[Int](-10, -20)
  
}
