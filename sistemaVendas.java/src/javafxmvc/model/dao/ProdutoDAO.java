package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.domain.Categoria;
import javafxmvc.model.domain.Produto;

public class ProdutoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Produto produto) {
        String sql = "INSERT INTO produtos(nome, preco, quantidade, cdCategoria) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setPreparedStatementForProduto(stmt, produto);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao inserir produto: " + produto, ex);
            return false;
        }
    }

    public boolean alterar(Produto produto) {
        String sql = "UPDATE produtos SET nome=?, preco=?, quantidade=?, cdCategoria=? WHERE cdProduto=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setPreparedStatementForProduto(stmt, produto);
            stmt.setInt(5, produto.getCdProduto());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao alterar produto: " + produto, ex);
            return false;
        }
    }

    public boolean remover(Produto produto) {
        String sql = "DELETE FROM produtos WHERE cdProduto=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getCdProduto());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao remover produto: " + produto, ex);
            return false;
        }
    }

    public List<Produto> listar() {
        String sql = "SELECT * FROM produtos";
        List<Produto> retorno = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {
            while (resultado.next()) {
                Produto produto = createProdutoFromResultSet(resultado);
                produto.setCategoria(buscarCategoria(produto.getCategoria().getCdCategoria()));
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao listar produtos", ex);
        }
        return retorno;
    }

    public List<Produto> listarPorCategoria(Categoria categoria) {
        String sql = "SELECT * FROM produtos WHERE cdCategoria=?";
        List<Produto> retorno = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getCdCategoria());
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    Produto produto = createProdutoFromResultSet(resultado);
                    produto.setCategoria(categoria);
                    retorno.add(produto);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao listar produtos por categoria", ex);
        }
        return retorno;
    }

    public Produto buscar(Produto produto) {
        String sql = "SELECT * FROM produtos WHERE cdProduto=?";
        Produto retorno = new Produto();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getCdProduto());
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    retorno = createProdutoFromResultSet(resultado);
                    retorno.setCategoria(buscarCategoria(retorno.getCategoria().getCdCategoria()));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, "Erro ao buscar produto: " + produto, ex);
        }
        return retorno;
    }

    private void setPreparedStatementForProduto(PreparedStatement stmt, Produto produto) throws SQLException {
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidade());
        stmt.setInt(4, produto.getCategoria().getCdCategoria());
    }

    private Produto createProdutoFromResultSet(ResultSet resultado) throws SQLException {
        Produto produto = new Produto();
        produto.setCdProduto(resultado.getInt("cdProduto"));
        produto.setNome(resultado.getString("nome"));
        produto.setPreco(resultado.getDouble("preco"));
        produto.setQuantidade(resultado.getInt("quantidade"));
        Categoria categoria = new Categoria();
        categoria.setCdCategoria(resultado.getInt("cdCategoria"));
        produto.setCategoria(categoria);
        return produto;
    }

    private Categoria buscarCategoria(int cdCategoria) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.setConnection(connection);
        Categoria categoria = new Categoria();
        categoria.setCdCategoria(cdCategoria);
        return categoriaDAO.buscar(categoria);
    }
}
