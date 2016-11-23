/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare;

import java.util.ArrayList;
import java.util.logging.Level;
import vaccinare.dao.CriancaDAO;
import vaccinare.dao.VacinaDAO;
import vaccinare.model.Crianca;
import vaccinare.model.Etnia;
import vaccinare.model.Sexo;
import vaccinare.model.Vacina;
import vaccinare.view.JFrameMain;

/**
 *
 * @author mauricio.rosito
 */
public class Vaccinare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           //testeCrianca();
           //testeVacina();
            JFrameMain jFrameMain = new JFrameMain();
            jFrameMain.setVisible(true);
            
        } catch (Exception ex) {
            System.out.print("Erro!!!\n"+ex.toString() );            
            
        }

    }
    
    private static void testeCrianca() throws Exception{
         //Criança de Teste
            Crianca crianca = new Crianca();
            crianca.setNome("Fernando Rosito");
            crianca.setIdade(7);
            crianca.setMae("Laura Maria Rosito");
            crianca.setPartoNatural(false);
            crianca.setSexo(Sexo.MASCULINO);
            crianca.setEtnia(Etnia.NEGRA);

            //DAO de teste
            CriancaDAO criancaDAO = new CriancaDAO();

            // Inserir
            //criancaDAO.inserir(crianca);
            //Update id = 8
//            crianca.setId(8);
//            crianca.setNome("Fernando Covolan Rosito");
//            crianca.setIdade(9);
//            crianca.setMae("Laura Maria Covolan Rosito");
//            crianca.setPartoNatural(true);
//            crianca.setSexo(Sexo.FEMININO);
//            crianca.setEtnia(Etnia.INDIGENA);
//            criancaDAO.atualizar(crianca);
            //Pesquisar
            ArrayList<Crianca> criancas = new ArrayList<>();
            criancas = criancaDAO.buscarTodos("Enzo");
    }

    private static void testeVacina() throws Exception{
          //Vacina de Teste
            Vacina vacina = new Vacina();
            vacina.setNome("Vacina 1");
            vacina.setLote(1213);
            vacina.setFornecedor("Fornecedor");
            java.util.Date now = new java.util.Date();
            vacina.setDataValidade(now);
            
            //DAO de teste
            VacinaDAO vacinaDAO = new VacinaDAO();

            // Inserir
            //vacinaDAO.inserir(vacina);
            //Update id = 2
//            vacina.setId(2);
//            vacina.setNome("Vacina 2");
//            vacina.setLote(1213333);
//            vacina.setFornecedor("Fornecedor 2");
//            vacina.setDataValidade(now);
//            vacinaDAO.atualizar(vacina);
            
            vacinaDAO.excluir(2);
            //Pesquisar
            ArrayList<Vacina> vacinas = new ArrayList<>();
            vacinas = vacinaDAO.buscarTodos("Vacina");
    }
}
