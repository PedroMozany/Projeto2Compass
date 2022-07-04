package model;

public class Cidades {
    private String nome;
    private String latitude;
    private String longitude;





    public Cidades(String nome,String latitude,String longitude){
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
