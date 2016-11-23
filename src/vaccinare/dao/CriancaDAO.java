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
import vaccinare.model.Crianca;
import vaccinare.model.Etnia;
import vaccinare.model.Sexo;

/**
 *
 * @author mauricio.rosito
 */
public class CriancaDAO implements ICriancaDAO {

    @Override
    public ArrayList<Crianca> buscarTodos(String nome) throws Exception {
        ArrayList<Crianca> criancas = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        CallableStatement cstmt = con.prepareCall("{CALL sp_selecionar_criancas(?)}");
        cstmt.setString(1, nome); //Buscar todos com o nome ou "" para todos da base
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {

            int id = rs.getInt("id");
            String nomeCrianca = rs.getString("nome");
            int idade = rs.getInt("idade");
            String sexo = rs.getString("sexo");
            boolean partoNatural = rs.getBoolean("parto_natural");
            String mae = rs.getString("mae");
            int etnia = rs.getInt("etnia");

            Crianca crianca = new Crianca(id, nomeCrianca, idade, (sexo.equals("MASCULINO")) ? Sexo.MASCULINO : Sexo.FEMININO, partoNatural, mae, Etnia.NEGRA);
            criancas.add(crianca);
        }
        ConnectionFactory.closeConnection(con, cstmt, rs);
        return criancas;

    }

    @Override
    public void inserir(Crianca crianca) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = " INSERT INTO crianca ";
        sql += " (nome,idade,sexo,parto_natural,mae,etnia) ";
        sql += " VALUES (?,?,?,?,?,?) ";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, crianca.getNome());
        pstmt.setInt(2, crianca.getIdade());
        pstmt.setString(3, (crianca.getSexo() == Sexo.MASCULINO) ? "MASCULINO" : "FEMININO"); //Operador condicional ternário
        pstmt.setBoolean(4, crianca.isPartoNatural());
        pstmt.setString(5, crianca.getMae());
        pstmt.setInt(6, crianca.getEtnia().ordinal()); //Converte valor do Enum para Int
        pstmt.executeUpdate();

        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public void atualizar(Crianca crianca) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        String sql = " UPDATE crianca ";
        sql += " SET nome = ? , ";
        sql += "     idade = ? , ";
        sql += "     sexo = ? , ";
        sql += "     parto_natural = ? , ";
        sql += "     mae = ? , ";
        sql += "     etnia = ? ";
        sql += " WHERE id = ? ";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, crianca.getNome());
        pstmt.setInt(2, crianca.getIdade());
        pstmt.setString(3, (crianca.getSexo() == Sexo.MASCULINO) ? "MASCULINO" : "FEMININO"); //Operador condicional ternário
        pstmt.setBoolean(4, crianca.isPartoNatural());
        pstmt.setString(5, crianca.getMae());
        pstmt.setInt(6, crianca.getEtnia().ordinal()); //Converte valor do Enum para Int
        pstmt.setInt(7, crianca.getId());

        pstmt.executeUpdate();
        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public void excluir(int id) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        String sql = " DELETE FROM crianca ";
        sql += " WHERE id = ? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        ConnectionFactory.closeConnection(con, pstmt);

    }

    @Override
    public Crianca buscarUnico(int id) throws Exception {
        Crianca crianca = null;
        Connection con = ConnectionFactory.getConnection();
        CallableStatement cstmt = con.prepareCall("{CALL sp_selecionar_crianca_unica(?)}");
        cstmt.setInt(1, id); //Buscar especifica
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {

            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            String sexo = rs.getString("sexo");
            boolean partoNatural = rs.getBoolean("parto_natural");
            String mae = rs.getString("mae");
            int etnia = rs.getInt("etnia");

            crianca = new Crianca(id, nome, idade, (sexo.equals("MASCULINO")) ? Sexo.MASCULINO : Sexo.FEMININO, partoNatural, mae, Etnia.NEGRA);

        }
        ConnectionFactory.closeConnection(con, cstmt, rs);
        return crianca;
    }

}
