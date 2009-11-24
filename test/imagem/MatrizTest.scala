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
  
  @Test
  def testaToString:Unit = {
    val matriz = Matriz[Int](3,3)
    matriz(0,0) = 1
    matriz(0,1) = 2
    matriz(0,2) = 3
    matriz(1,0) = 4
    matriz(1,1) = 5
    matriz(1,2) = 6
    matriz(2,0) = 7
    matriz(2,1) = 8
    matriz(2,2) = 9

    val expected = """|1 2 3
    				  |4 5 6
                      |7 8 9""".stripMargin
    
    assertThat(matriz.toString, is(expected))
  }
  
}
