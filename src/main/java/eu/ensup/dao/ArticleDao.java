package eu.ensup.dao;

import eu.ensup.domaine.Article;

import java.sql.*;

public class ArticleDao implements IDao {

    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3309/gestionarticle";
    //private String url = "jdbc:postgresql://152101lp6v.csh-dijon.ramage:5435/spring";
    private String login = "spring";
    private String passwd = "spring";

    @Override
    public Article get(String code) {
//        System.out.println("DAO: Récupération de l'article " + reference);
//        if (reference == "ref-bonbon-001") {
//            return new Article("Haribo", 10, 12.5f,"bonbon","ref-bonbon-001"); // MOCK SGBDR
            // Information d'accès à la base de données
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            String sql = "SELECT * FROM article WHERE code='" + code +"'";
            System.out.println(sql);
            st = cn.prepareStatement(sql);

            // Etape 4 : exécution requête
            rs = st.executeQuery();

            // Si récup données alors étapes 5 (parcours Resultset)
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
        // Information d'accès à la base de données
        Connection cn = null;
        PreparedStatement st = null;
        Integer rs = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.prepareStatement("INSERT INTO article(name, quantity, price, category, code) VALUES(?,?,?,?,?)");
            st.setString(1, article.getName());
            st.setInt(2, article.getQuantity());
            st.setFloat(3, article.getPrice());
            st.setString(4, article.getCategory());
            st.setString(5, article.getCode());

            // Etape 4 : exécution requête
            rs = st.executeUpdate();

            // Vérifier le résultat
            return rs;

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
    public Article update(Article article) {
        System.out.println("DAO: Update de l'article " + article.toString());
        System.out.println("DAO: Update de l'article " + article.toString());
        // Information d'accès à la base de données
        Connection cn = null;
        PreparedStatement st = null;
        Integer rs = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName(driverName);

            // Etape 2 : récupération de la connexion
            //cn = DriverManager.getConnection(url, login, passwd);
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.prepareStatement("UPDATE article SET quantity = ? WHERE code = ?");
            st.setInt(1, article.getQuantity());
            st.setString(2, article.getCode());

            // Etape 4 : exécution requête
            rs = st.executeUpdate();

            // Vérifier le résultat
            System.out.println("Update : " + rs);
            return article;
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
    public Integer delete(String code) {
        System.out.println("DAO: Suppression de l'article " + code);
        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
