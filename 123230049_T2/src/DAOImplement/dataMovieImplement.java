/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Zainur Fadli
 */
public interface dataMovieImplement {
    public void insert(dataMovie m);
    public void update(dataMovie m);
    public void delete(int id);
    public List<dataMovie> getAll();
}
