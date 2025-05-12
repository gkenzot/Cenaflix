package dao;

import beans.Filme;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private final Conexao conexao;
    private final Connection conn;

    public FilmeDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public void inserir(Filme filme) {
        String sql = "INSERT INTO filmes (nome, datalancamento, categoria) VALUES "
                + "(?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, filme.getNomeFilme());
            stmt.setString(2, filme.getDataLancamento());
            stmt.setString(3, filme.getCategoria());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public List<Filme> getFilmeLista(String nomeFilme) {
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeFilme + "%");
            ResultSet rs = stmt.executeQuery();
            List<Filme> listaFilmes = new ArrayList<>();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNomeFilme(rs.getString("nome"));
                filme.setDataLancamento(rs.getString("dataLancamento"));
                filme.setCategoria(rs.getString("categoria"));
                listaFilmes.add(filme);
            }
            return listaFilmes;
        } catch (SQLException e) {
            return null;
        }

    }

    public Filme getFilme(int id) {
        String sql = "SELECT * FROM filmes WHERE id = ?";
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Filme filme = new Filme();

            rs.next();
            filme.setId(id);
            filme.setNomeFilme(rs.getString("nome"));
            filme.setDataLancamento(rs.getString("dataLancamento"));
            filme.setCategoria(rs.getString("categoria"));

            return filme;

        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM filmes WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir filme: " + e.getMessage());
        }

    }

    public void editar(Filme filme) {
        String sql = "UPDATE filmes SET nome=?, datalancamento=?, categoria=? WHERE id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, filme.getNomeFilme());
            stmt.setString(2, filme.getDataLancamento());
            stmt.setString(3, filme.getCategoria());
            stmt.setInt(4, filme.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar filme: " + e.getMessage());
        }
    }

    public Filme getFilmeNome(String nomeFilme) {
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nomeFilme);
            ResultSet rs = stmt.executeQuery();
            Filme filme = new Filme();
            rs.next();

            filme.setId(rs.getInt("id"));
            filme.setNomeFilme(nomeFilme);
            filme.setNomeFilme(rs.getString("nome"));
            filme.setDataLancamento(rs.getString("datalancamento"));
            filme.setCategoria(rs.getString("categoria"));

            return filme;

        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public List<Filme> getFilmeTodos() {
        String sql = "SELECT * FROM filmes";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Filme> listaFilmes = new ArrayList<>();

            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Filme filme = new Filme();

                filme.setId(rs.getInt("id"));
                filme.setNomeFilme(rs.getString("nome"));
                filme.setDataLancamento(rs.getString("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));

                listaFilmes.add(filme);
            }
            return listaFilmes;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Filme> getFilmePorId(int id1, int id2) {
        String sql = "SELECT * FROM filmes WHERE id >= ? AND id <= ?;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, id1);
            stmt.setInt(2, id2);
            ResultSet rs = stmt.executeQuery();

            List<Filme> listaFilmes = new ArrayList<>();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNomeFilme(rs.getString("nome"));
                filme.setDataLancamento(rs.getString("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));
                listaFilmes.add(filme);
            }
            return listaFilmes;

        } catch (Exception e) {
            return null;
        }

    }
}
