/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.dao;

import java.sql.SQLException;
import vaccinare.model.Crianca;
import java.util.ArrayList;

/**
 *
 * @author mauricio.rosito
 */
public interface ICriancaDAO {
    ArrayList<Crianca> buscarTodos(String nome) throws Exception;
    Crianca buscarUnico(int id) throws Exception;
    void inserir(Crianca crianca) throws Exception;
    void atualizar(Crianca crianca) throws Exception;
    void excluir(int id) throws Exception;
}
