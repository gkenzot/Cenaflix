package beans;

/**
 *
 * @author Kenzo
 */
public class Filme {

    private int id;
    private String nomeFilme;
    private String dataLancamento;
    private String categoria;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNomeFilme() {
        return nomeFilme;
    }

    /**
     *
     * @param nomeFilme
     */
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    /**
     *
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @return
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     *
     * @param dataLancamento
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

}
