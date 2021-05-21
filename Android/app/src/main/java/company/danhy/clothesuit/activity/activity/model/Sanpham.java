package company.danhy.clothesuit.activity.activity.model;

import java.io.Serializable;

public class Sanpham  {
    public int id;
    public String tensanpham;
    public Integer giasanpham;
    public String hinhanhsanpham;
    public String motasanpham;
    public int idSanpham;

    public Sanpham(int id, String tensanpham, Integer giasanpham, String hinhanhsanpham, String motasanpham, int idSanpham) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.hinhanhsanpham = hinhanhsanpham;
        this.motasanpham = motasanpham;
        this.idSanpham = idSanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public Integer getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(Integer giasanpham) {
        this.giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        this.motasanpham = motasanpham;
    }

    public int getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(int idSanpham) {
        this.idSanpham = idSanpham;
    }
}
