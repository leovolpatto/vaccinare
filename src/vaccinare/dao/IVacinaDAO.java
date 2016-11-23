/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.dao;


import vaccinare.model.Vacina;
import vaccinare.model.Crianca;
import java.util.ArrayList;

/**
 *
 * @author mauricio.rosito
 */
public interface IVacinaDAO {
    ArrayList<Vacina> buscarTodos(String nome) throws Exception;
    Vacina buscarUnico(int id) throws Exception;
    void inserir(Vacina vacina) throws Exception;
    void atualizar(Vacina vacina) throws Exception;
    void excluir(int id) throws Exception;
}
