package model;

public class Temperatura {
    private String temp;
    private String tempMin;
    private String tempMax;



    public Temperatura( String temp, String tempMin, String tempMax) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }



    public String getTemp() {
        return temp;
    }



    public String getTempMin() {
        return tempMin;
    }


    public String getTempMax() {
        return tempMax;
    }

    @Override
    public String toString() {
        return "TEMPERATURA" + temp + "|" +
                "MINIMA" + tempMin +  "|" +
                "MAXIMA" + tempMax;
    }
}
