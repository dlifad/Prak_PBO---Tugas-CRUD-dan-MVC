package DAODataMovie;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.dataMovieImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Zainur
 */
public class dataMovieDAO implements dataMovieImplement {
    Connection connection;

    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting) VALUES (?, ?, ?, ?)";
    final String update = "UPDATE movie SET judul=?, alur=?, penokohan=?, akting=? WHERE id=?";
    final String delete = "DELETE FROM movie WHERE id=?";
    

    public dataMovieDAO() {
        connection = connector.connection();
    }

    @Override
    public List<dataMovie> getAll() {
        List<dataMovie> listMovie = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                dataMovie movie = new dataMovie();
                movie.setId(rs.getInt("id"));
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getFloat("alur"));
                movie.setPenokohan(rs.getFloat("penokohan"));
                movie.setAkting(rs.getFloat("akting"));
                listMovie.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dataMovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listMovie;
    }

    @Override
    public void insert(dataMovie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setFloat(2, m.getAlur());
            statement.setFloat(3, m.getPenokohan());
            statement.setFloat(4, m.getAkting());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                m.setId(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataMovie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getJudul());
            statement.setFloat(2, m.getAlur());
            statement.setFloat(3, m.getPenokohan());
            statement.setFloat(4, m.getAkting());
            statement.setInt(5, m.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
    }
}
