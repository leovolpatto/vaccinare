/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import vaccinare.model.Vacina;
import vaccinare.model.Etnia;
import vaccinare.model.Sexo;

/**
 *
 * @author mauricio.rosito
 */
public class VacinaDAO implements IVacinaDAO {

    @Override
    public ArrayList<Vacina> buscarTodos(String nome) throws Exception {
        ArrayList<Vacina> vacinas = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        CallableStatement cstmt = con.prepareCall("{CALL sp_selecionar_vacinas(?)}");
        cstmt.setString(1, nome); //Buscar todos com o nome ou "" para todos da base
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {

            int id = rs.getInt("id");
            int lote = rs.getInt("lote");
            String nomeVacina = rs.getString("nome");
            Date dataValidade = rs.getDate("data_validade");
            String fornecedor = rs.getString("fornecedor");
            
            Vacina vacina = new Vacina(id, lote, nomeVacina, dataValidade, fornecedor);
            vacinas.add(vacina);
        }
        ConnectionFactory.closeConnection(con, cstmt, rs);
        return vacinas;

    }

    @Override
    public void inserir(Vacina vacina) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = " INSERT INTO vacina ";
        sql += " (lote, nome,data_validade,fornecedor) ";
        sql += " VALUES (?,?,?,?) ";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, vacina.getLote());
        pstmt.setString(2, vacina.getNome());
        java.sql.Date dataSql = new java.sql.Date(vacina.getDataValidade().getTime());
        pstmt.setDate(3, dataSql);
        pstmt.setString(4, vacina.getFornecedor());
        pstmt.executeUpdate();

        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public void atualizar(Vacina vacina) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        String sql = " UPDATE vacina ";
        sql += " SET lote = ? , ";
        sql += "     nome = ? , ";
        sql += "     data_validade = ? , ";
        sql += "     fornecedor = ?  ";
        sql += " WHERE id = ? ";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, vacina.getLote());
        pstmt.setString(2, vacina.getNome());
        java.sql.Date dataSql = new java.sql.Date(vacina.getDataValidade().getTime());
        pstmt.setDate(3, dataSql);
        pstmt.setString(4, vacina.getFornecedor());
        pstmt.setInt(5, vacina.getId());

        pstmt.executeUpdate();
        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public void excluir(int id) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        String sql = " DELETE FROM vacina ";
        sql += " WHERE id = ? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public Vacina buscarUnico(int id) throws Exception {
        Vacina vacina = null;
        Connection con = ConnectionFactory.getConnection();
        CallableStatement cstmt = con.prepareCall("{CALL sp_selecionar_vacina_unica(?)}");
        cstmt.setInt(1, id); //Buscar especifica
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {

            int lote = rs.getInt("lote");
            String nome = rs.getString("nome");
            Date dataValidade = rs.getDate("data_validade");
            String fornecedor = rs.getString("fornecedor");
            
            vacina = new Vacina(id, lote, nome, dataValidade, fornecedor);

        }
        ConnectionFactory.closeConnection(con, cstmt, rs);
        return vacina;
    }

}
