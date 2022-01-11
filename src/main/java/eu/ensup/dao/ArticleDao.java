package eu.ensup.dao;

import eu.ensup.domaine.Article;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ArticleDao implements IDao {


    private DataSource dataSource;
    private String driverName = "org.postgresql.Driver";

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Article get(String code) {
        System.out.println("DAO: Récupération de l'article " + code);
       /* if (code == "ref-bonbon-001") {
            return new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001"); // MOCK SGBDR

        }*/
        // Information d'acc�s � la base de donn�es
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            cn = this.dataSource.getConnection();

            // Etape 3 : Création d'un statement
            String sql = "SELECT * FROM article WHERE code= ?";


            st = cn.prepareStatement(sql);
            st.setString(1, code);


            // Etape 4 : exécution requête
            rs = st.executeQuery();

            // Si récup données alors étapes 5 (parcours Resultset)
            System.out.println("affichage du get d ' article");
            while (rs.next()) {
                return new Article(rs.getString("name"), rs.getInt("quantity"), rs.getFloat("price"),
                        rs.getString("category"),rs.getString("code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public Integer create(Article article) {
        System.out.println("DAO: Creation de l'article " + article.toString());


        // Information d'acc�s � la base de donn�es
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            cn = this.dataSource.getConnection();

            String sql = "INSERT INTO article (  name, quantity, price, category, code) VALUES ( ?, ?, ?, ?, ?)";

            // Etape 3 : Cr�ation d'un statement
            st = cn.prepareStatement(sql);
            st.setString(1, article.getName());
            st.setInt(2, article.getQuantity());
            st.setFloat(3, article.getPrice());
            st.setString(4, article.getCategory());
            st.setString(5, article.getCode());


            // Etape 4 : exécution requête
            st.executeUpdate();

            // Vérifier le résultat
         return  1;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : lib�rer ressources de la m�moire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public Article update(Article article) {
        System.out.println("DAO: Update de l'article " + article.toString());
        return null;
    }

    @Override
    public Integer delete(String reference) {
        System.out.println("DAO: Suppression de l'article " + reference);
        return null;
    }

    @Override
    public ArrayList<Article> getAll() {

        System.out.println("DAO: GetAll ");


        // Information d'acc�s � la base de donn�es
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            cn = this.dataSource.getConnection();

            String sql = "SELECT * FROM article";

            // Etape 3 : Cr�ation d'un statement
            st = cn.prepareStatement(sql);



            // Etape 4 : exécution requête
             rs =  st.executeQuery();

            // Vérifier le résultat
            ArrayList<Article> list = new ArrayList<Article>();
            while (rs.next()) {
                list.add(new Article(rs.getString("name"), rs.getInt("quantity"), rs.getFloat("price"),
                        rs.getString("category"),rs.getString("code"))) ;
            }
           return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : lib�rer ressources de la m�moire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
