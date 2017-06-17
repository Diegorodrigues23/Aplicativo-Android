package br.com.custocar.custocar;

/**
 * Created by Diego on 10/06/2017.
 */

public class SingletonData {

    private String data1;
    private String data2;
    private static final SingletonData instancia = new SingletonData();

    private SingletonData() {

    }

    public static SingletonData getInstancia() {
        return instancia;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}
