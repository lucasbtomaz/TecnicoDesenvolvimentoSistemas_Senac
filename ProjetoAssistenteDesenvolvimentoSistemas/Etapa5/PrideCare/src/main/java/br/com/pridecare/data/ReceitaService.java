package br.com.pridecare.data;

import br.com.pridecare.model.Receita;
import br.com.pridecare.dao.ReceitaDAO;
import java.util.List;

/**
 * Classe responsável pela lógica de negócio de receita.
 *
 */
public class ReceitaService {

    private final ReceitaDAO receitaDAO = new ReceitaDAO();

    /**
     * Lista todas as receitas cadastradas.
     *
     * @param cpfUsuario
     * @return uma lista de todas as receitas cadastradas.
     */
    public List<Receita> buscarPorCpf(String cpfUsuario) {
        return receitaDAO.buscarPorCpf(cpfUsuario);
    }

    public void salvarReceita(Receita receita) {
        receitaDAO.salvarReceita(receita);
    }

    // Adicionar o método buscarPorId 
    public Receita buscarPorId(int id) {
        return receitaDAO.buscarPorId(id);
    }

}
