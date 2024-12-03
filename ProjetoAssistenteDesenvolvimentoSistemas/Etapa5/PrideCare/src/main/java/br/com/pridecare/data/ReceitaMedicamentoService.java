package br.com.pridecare.data;

import br.com.pridecare.dao.ReceitaMedicamentoDAO;
import br.com.pridecare.model.ReceitaMedicamento;
import java.util.List;

/**
 *
 * @author oluca
 */
public class ReceitaMedicamentoService {

    private final ReceitaMedicamentoDAO receitaMedicamentoDAO = new ReceitaMedicamentoDAO();

    public void salvarReceitaMedicamento(ReceitaMedicamento receitaMedicamento) {
        receitaMedicamentoDAO.salvarReceitaMedicamento(receitaMedicamento);
    }

    public List<ReceitaMedicamento> buscarPorReceita(int receitaId) {
        return receitaMedicamentoDAO.buscarPorReceita(receitaId);
    }
}
