package thiengo.com.br.spinner_viviane.model

/**
 * Classe de modelo (também conhecida como classe de domínio
 * de problema) responsável por ser a arquitetura de objetos
 * de itens do [Spinner] principal em tela.
 *
 * Está classe é totalmente adptável de acordo com as
 * necessidades em layout de item de [Spinner].
 *
 * Ou seja, é possível colocar ou remover ainda mais propriedades.
 * Porém, caso alguma atualização ocorra aqui, não deixe de
 * verificar a necessidade de atualizar o algoritmo do método
 * getView() em [CountriesAdapter].
 */
class Country(
    val id: Long,
    val name: String,
    val image: Int,
    val info: String
)