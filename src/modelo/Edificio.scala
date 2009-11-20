package modelo

case class Edificio(
    esq: Int,       // coordenada horizontal esquerda do edifício
    alt: Int,       // altura do edifício
    dir: Int        // coordenada horizontal esquerda do edifício
){
   def <(e: Edificio) : Boolean = {
      this.esq < e.esq
  }
  
  override def toString = "edificio esq:" + esq + " alt: "+ alt + " dir: "+dir
}
