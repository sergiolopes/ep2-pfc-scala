package testes
import imagem._

object MatrizTest {
  
  def main(args : Array[String]) : Unit = {
    
    val matriz = Matriz[Int](10, 20)
    matriz(0, 0) = 15
    println(matriz(0,0))
    println(matriz.linhas)
    println(matriz.colunas)
    
  }
}
