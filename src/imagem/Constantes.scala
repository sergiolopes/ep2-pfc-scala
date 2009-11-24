package imagem

object Constantes {
    val NLins = 600                     // número de linhas da imagem
    val NCols = 800                     // número de colunas da imagem
    val BordaInf = NLins - 1            // borda inferior (última linha da imagem) 
    val MargemInf = 20                  // linhas do eixo base à borda inferior da imagem
    val Base = BordaInf - MargemInf     // linha do eixo base 
    val Branco = 15                     // valor de maxval
    val Cinza = 10                      // cor da silhueta preenchida
    val Preto = 0                       // cor do eixo base
}
