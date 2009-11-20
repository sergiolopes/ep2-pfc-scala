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
  override def toString = "silhueta elem x:" + x + " alt: "+ h
}