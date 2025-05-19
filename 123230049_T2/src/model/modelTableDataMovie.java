package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zainur Fadli
 */
public class modelTableDataMovie extends AbstractTableModel {

    List<dataMovie> dataMovie;

    public modelTableDataMovie(List<dataMovie> dataMovie) {
        this.dataMovie = dataMovie;
    }
    
    public dataMovie getDataMovieAt(int row) {
        return dataMovie.get(row);
    }


    @Override
    public int getRowCount() {
        return dataMovie.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        dataMovie movie = dataMovie.get(row);
        switch (column) {
            case 0:
                return movie.getJudul();
            case 1:
                return movie.getAlur();
            case 2:
                return movie.getPenokohan();
            case 3:
                return movie.getAkting();
            case 4:
                return movie.getNilai();
            default:
                return null;
        }
    }
}
