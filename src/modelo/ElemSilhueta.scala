package modelo

case class ElemSilhueta(
    x: Int, // coordenada horizontal
    h: Int  // altura
){
  def >(e: ElemSilhueta) : Boolean = {
      this.x >= e.x
  }
  def <(e: ElemSilhueta) : Boolean = {
      this.x < e.x
  }
  override def toString = "x: " + x + " alt: "+ h
}