package algoritmos

import modelo._ 
import scala.collection.mutable.ListBuffer

object Algoritmos {
	def algoritmo1(edifs: List[Edificio]): List[ElemSilhueta] = {
	  val ordenados = edifs.sort(_ < _)
	  if(edifs.length > 0){
		  var resultado = List[ElemSilhueta]()
		  for(k <- 0 until edifs.length){
			  resultado = uniao(resultado, silhuetaDeEdificio(ordenados(k)))
		  }
		  resultado.sort(_<_)
	  }else{
		  Nil
	  }
	}
	def algoritmo2(edifs: List[Edificio]): List[ElemSilhueta] = {
		algoritmo2_aux(edifs.sort(_ < _), List[ElemSilhueta]()).sort(_<_)
		
	}
 
	private def algoritmo2_aux(edifs: List[Edificio], acc: List[ElemSilhueta]): List[ElemSilhueta] = (edifs) match {
	  case (Nil) => acc
	  case (l1) =>  algoritmo2_aux(edifs.drop(1), uniao(acc, silhuetaDeEdificio(edifs.head)))
	}
	
	def algoritmo3(edifs: List[Edificio]): List[ElemSilhueta] = {
		algoritmo3_aux(edifs.sort(_>_))
	}
	
	def algoritmo3_aux(edifs: List[Edificio]): List[ElemSilhueta] = edifs match{
	  case Nil => Nil
	  case (l1)  =>  {
		if(l1.length == 1) silhuetaDeEdificio(l1(0)) 
		else {
			val split = l1.splitAt(l1.length / 2)
			uniao(algoritmo3_aux(split._1), algoritmo3_aux(split._2))
		}
	  }
 
	}
 
	def silhuetaComFoldLeft(edifs: List[Edificio]): List[ElemSilhueta] = {
	  ((List[ElemSilhueta]()) /: edifs.sort(_<_)) ((acc: List[ElemSilhueta], edif: Edificio) => uniao(acc, silhuetaDeEdificio(edif)))
	}
 
	def silhuetaComFoldRight(edifs: List[Edificio]): List[ElemSilhueta] = {
	  ((edifs.sort(_>_) :\ List[ElemSilhueta]())) ((edif: Edificio, acc: List[ElemSilhueta]) => uniao(acc, silhuetaDeEdificio(edif)))
	}
	
	
	def uniao(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] = uniao_aux(s1, s2)
 
	// s1 e s2 estao em ordem decresente de x
	private def uniao_aux(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] =
		(s1, s2) match {
		  case (Nil, Nil) => Nil
		  case (l1, Nil) => l1
		  case (Nil, l2) =>  l2
		  case(l1, l2) => {
		    if (l1.head < l2.head){
		    	if(l1.length > 1){
		    		if(l1(1).h == 0) adicionaElemento(uniao_aux(l1.drop(2), l2), l1(0), l1(1))
		    		else adicionaElemento(uniao_aux(l1.drop(1), l2), l1(0), l1(1))
		    	}
		    	else {
		    		l2
		    	}
		    }
		    else{
		    	if(l2.length > 1){
		    	  if(l2(1).h == 0) adicionaElemento(uniao_aux(l1, l2.drop(2)), l2(0), l2(1))
		    	  else adicionaElemento(uniao_aux(l1, l2.drop(1)), l2(0), l2(1))
		    	}
		    	else {
		    	  l1
		    	}
		    }
		  }
	}
 
	private def metade(e:ElemSilhueta, e2:ElemSilhueta): Boolean = e.x < e2.x
 
 	private def adicionaElemento(acc:List[ElemSilhueta],elemIni: ElemSilhueta, elemFim: ElemSilhueta) : List[ElemSilhueta] = {
 	  val divisao = acc.partition(metade(_,elemIni))
 	  val divisao2 = divisao._2.partition(metade(_,elemFim))
 	  doAdicionaElemento(divisao2._1, divisao2._2, elemIni, elemFim)
	}
  
	private def doAdicionaElemento(esquerda:List[ElemSilhueta], direita:List[ElemSilhueta], elemIni: ElemSilhueta, 
                                elemFim: ElemSilhueta): List[ElemSilhueta] = (esquerda, direita) match{
      case(Nil, Nil) => elemIni :: elemFim :: List()
      case(Nil, l2) =>  elemIni :: montaLista1(elemFim, l2)
	  case(l1, Nil) =>  elemIni :: montaLista2(elemIni, elemFim, l1)
	  case(l1, l2)  =>  elemIni :: montaLista3(elemIni, elemFim, l1, l2)
	}
 
	private def montaLista3(elemIni: ElemSilhueta,elemFim: ElemSilhueta, lista1: List[ElemSilhueta], lista2: List[ElemSilhueta]): List[ElemSilhueta] = {
			val altos = lista1.filter((e) => elemIni.h < e.h && elemFim.x >= e.x)
			if(altos isEmpty) {
			  if(elemFim.x != lista2.head.x) new ElemSilhueta(elemFim.x, lista1.reverse.head.h) :: lista2
			  else lista2
			}
			else altos ::: lista2

			
	}
 
	private def montaLista2(elemIni: ElemSilhueta,elemFim: ElemSilhueta, lista: List[ElemSilhueta]): List[ElemSilhueta] = {
		val altos = lista.filter(elemIni.h < _.h).reverse
		if(altos isEmpty) elemFim :: List()
		else (elemFim :: new ElemSilhueta(lista.reverse.head.x, elemIni.h):: altos).reverse
	}
	private def montaLista1(elem: ElemSilhueta, lista: List[ElemSilhueta]): List[ElemSilhueta] = {
			if(elem.x == lista.head.x && elem.h == lista.head.h) lista
			else elem :: lista
			
	}
	def silhuetaDeEdificio(edif: Edificio): List[ElemSilhueta] = {
			List(new ElemSilhueta(edif.esq,edif.alt), new ElemSilhueta(edif.dir,0))
	}
 
	// devolve o algoritmo baseado no numero dele
	def buscaAlgoritmo(num: Int) = num match {
	  case 1 => algoritmo1 _
      case 2 => algoritmo2 _
      case 3 => algoritmo3 _
      case 4 => silhuetaComFoldRight _
      case 5 => silhuetaComFoldLeft _
      case x => throw new IllegalArgumentException("Algoritmo invalido: %d" format x)
	}
}
