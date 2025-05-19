package model;

/**
 *
 * @author Zainur Fadli
 */
public class dataMovie {
    private Integer id;
    private String judul;
    private Float alur;
    private Float penokohan;
    private Float akting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Float getAlur() {
        return alur;
    }

    public void setAlur(Float alur) {
        this.alur = alur;
    }

    public Float getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(Float penokohan) {
        this.penokohan = penokohan;
    }

    public Float getAkting() {
        return akting;
    }

    public void setAkting(Float akting) {
        this.akting = akting;
    }
    
    public double getNilai() {
        return (alur + penokohan + akting) / 3;
    }
    
    
}
