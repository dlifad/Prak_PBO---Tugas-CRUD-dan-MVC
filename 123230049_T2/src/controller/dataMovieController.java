package controller;
import java.util.List;
import DAODataMovie.dataMovieDAO;
import DAOImplement.dataMovieImplement;
import model.*;
import view.MainView;
/**
 *
 * @author Zainur Fadli
 */
public class dataMovieController {
    MainView frame;
    dataMovieImplement implDataMovie;
    List<dataMovie> dataMovie;
    
    public dataMovieController(MainView frame){
        this.frame = frame;
        implDataMovie = new dataMovieDAO();
        dataMovie = implDataMovie.getAll();
    }
    
    public void isiTabel(){
        dataMovie = implDataMovie.getAll();
        modelTableDataMovie modelMovie = new modelTableDataMovie(dataMovie);
        frame.getTableDataMovie().setModel(modelMovie);
    }
    
    public void insert(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getJTxt_judul().getText());
        dm.setAlur(Float.parseFloat(frame.getJTxt_alur().getText()));
        dm.setPenokohan(Float.parseFloat(frame.getJTxt_penokohan().getText()));
        dm.setAkting(Float.parseFloat(frame.getJTxt_akting().getText()));
        implDataMovie.insert(dm);
        
    }
    
    public void update(){
        dataMovie dm = new dataMovie();
        dm.setJudul(frame.getJTxt_judul().getText());
        dm.setAlur(Float.parseFloat(frame.getJTxt_alur().getText()));
        dm.setPenokohan(Float.parseFloat(frame.getJTxt_penokohan().getText()));
        dm.setAkting(Float.parseFloat(frame.getJTxt_akting().getText()));
        dm.setId(Integer.parseInt(frame.getJTxt_idHidden().getText()));
        implDataMovie.update(dm);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxt_idHidden().getText());
        implDataMovie.delete(id);
    }
    
    public void clear() {
        frame.getJTxt_judul().setText("");
        frame.getJTxt_alur().setText("");
        frame.getJTxt_penokohan().setText("");
        frame.getJTxt_akting().setText("");
        frame.getJTxt_idHidden().setText("");
    }
    



}
