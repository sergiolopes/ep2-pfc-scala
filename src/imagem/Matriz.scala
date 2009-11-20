package imagem

class Matriz[T] (
  private val n: Int, 
  private val m: Int
) {
  
  if (n < 0 || m < 0)
    throw new IllegalArgumentException("Dimensoes da Matriz devem ser positivas")
  
  private val array = new Array[Array[T]](n, m)
  
  
  def apply(x: Int, y: Int) = array(x)(y)
  def update(x: Int, y: Int, v: T) = array(x)(y) = v
  
  def linhas = n
  def colunas = m
}
object Matriz {
  def apply[T](n:Int, m:Int) = new Matriz[T](n,m)
}