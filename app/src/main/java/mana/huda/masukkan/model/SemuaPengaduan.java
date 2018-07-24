package mana.huda.masukkan.model;

import com.google.gson.annotations.SerializedName;
/**
 * Created by Huda Mana on 22-Jul-18.
 */

public class SemuaPengaduan {

    @SerializedName("id")
    private String id;

    @SerializedName("judul_pengaduan")
    private String judul_pengaduan;

    @SerializedName("isi_pengaduan")
    private String isi_pengaduan;

    @SerializedName("status_pengaduan")
    private String status_pengaduan;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setJudul_pengaduan(String judul_pengaduan){
        this.judul_pengaduan=judul_pengaduan;
    }

    public String getJudul_pengaduan(){
        return judul_pengaduan;
    }

    public void setIsi_pengaduan(String isi_pengaduan){
        this.isi_pengaduan=isi_pengaduan;
    }

    public String getIsi_pengaduan(){
        return isi_pengaduan;
    }

    public void setStatus_pengaduan(String status_pengaduan){
        this.status_pengaduan=status_pengaduan;
    }

    public String getStatus_pengaduan(){
        return status_pengaduan;
    }

    @Override
    public String toString(){
        return
                "SemuaPengaduan{" +
                        "id = '" + id + '\'' +
                        ",judul_pengaduan = '" + judul_pengaduan + '\'' +
                        ",isi_pengaduan = '" + isi_pengaduan + '\'' +
                        ",status_pengaduan = '" + status_pengaduan + '\'' +
                        "}";
    }

}
