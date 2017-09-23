package example.com.timtro;

/**
 * Created by Administrator on 23/09/2017.
 */

public class PhongTro {
    private String diachi;
    private String sdt;
   // private  String thongtinchu;
    private String giatien;
   // private int anh;
    private String chitiet;

    public PhongTro(String diachi, String sdt, String giatien,String chitiet) {
        this.diachi = diachi;
        this.sdt = sdt;
        this.giatien = giatien;
        this.chitiet=chitiet;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public PhongTro() {
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }
}
