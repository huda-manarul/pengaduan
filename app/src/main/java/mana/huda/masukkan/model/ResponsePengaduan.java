package mana.huda.masukkan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Created by Huda Mana on 23-Jul-18.
 */

public class ResponsePengaduan {

    @SerializedName("semuapengaduan")
    private List<SemuaPengaduan> semuapengaduan;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setSemuapengaduan(List<SemuaPengaduan> semuapengaduan){
        this.semuapengaduan = semuapengaduan;
    }

    public List<SemuaPengaduan> getSemuapengaduan(){
        return semuapengaduan;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return
                "ResponsePengaduan{" +
                        "semuapengaduan = '" + semuapengaduan + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
