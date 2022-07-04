package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
    private Date data;
    private String unix;
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Temperatura previsao;

    public Data(Date data, String unix, Temperatura previsao) {
        this.data = data;
        this.unix = unix;
        this.previsao = previsao;
    }

    public Data() {
        this.data = new Date();
        this.unix = unixPorPeriodo(this.data);
    }


    public Data(Temperatura previsao) {
        this.data = new Date();
        this.unix = unixPorPeriodo(this.data);
        this.previsao = previsao;
    }

    public Date getData() {
        return data;
    }

    public String getUnix() {
        return unix;
    }

    public Temperatura getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Temperatura previsao) {
        this.previsao = previsao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setUnix(String unix) {
        this.unix = unix;
    }

    public Date periodo() throws ParseException {
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        data = sdf.parse(sdf.format(calendar.getTime()));
        return data;
    }

    public String unixPorPeriodo(Date date) {
        String valor = String.valueOf(date.getTime());
        String unix = valor.substring(0, 10);
        return unix;
    }

    @Override
    public String toString() {
        return "DATA: " + sdf.format(data) + "|"+
                "UNIX: " + unix + "|" +
                "PREVIAO: " +  previsao;
    }

}
