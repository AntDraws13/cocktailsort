package app;


public class Sales<T extends Comparable<T>> {
    private T dia;
    private T mes;
    private T valor;

    public Sales(T mes, T dia, T valor) {
        this.dia = dia;
        this.mes = mes;
        this.valor = valor;
    }

    @Override
    public String toString(){
        return "Mes: "+mes+" Dia: "+dia+" Valor: "+valor;
    }

    public T getDia() {
        return dia;
    }

    public void setDia(T dia) {
        this.dia = dia;
    }

    public T getMes() {
        return mes;
    }

    public void setMes(T mes) {
        this.mes = mes;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
