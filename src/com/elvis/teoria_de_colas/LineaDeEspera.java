package com.elvis.teoria_de_colas;

public class LineaDeEspera {
    private double lambda;
    private double miu;
    private double clientesEnElSistema;
    private double clientesEnLaCola;
    private double tiempoEnElSistema;
    private double tiempoEnLaCola;
    private double probabilidadDeDesocupado;
    private double probabilidadDeOcupado;
    private String unidad;

    public LineaDeEspera(double lambda, double miu, String unidad){
        this.setLambda(lambda);
        this.setMiu(miu);
        this.setUnidad(unidad);
    }

    public void calcularCola(){
        calcularCola(getLambda(), getMiu());
    }

    private void calcularCola(double lambda, double miu){
        this.clientesEnElSistema = lambda / (miu - lambda);
        this.clientesEnLaCola = Math.pow(lambda, 2) / (miu * (miu - lambda));
        this.tiempoEnElSistema = 1 / (miu - lambda);
        this.tiempoEnLaCola = lambda /  (miu * (miu - lambda));
        this.probabilidadDeDesocupado = 1 - (lambda / miu);
        this.probabilidadDeOcupado = lambda / miu;
    }

    public void imprimirResultado(){
        Resultado frame = new Resultado(getClientesEnElSistema(), getClientesEnLaCola(),
                getTiempoEnElSistema(), getTiempoEnLaCola(), getProbabilidadDeDesocupado(),
                getProbabilidadDeOcupado(), getUnidad());
        frame.setVisible(true);
    }

    public double getClientesEnElSistema() {
        return clientesEnElSistema;
    }

    public double getClientesEnLaCola() {
        return clientesEnLaCola;
    }

    public double getTiempoEnElSistema() {
        return tiempoEnElSistema;
    }

    public double getTiempoEnLaCola() {
        return tiempoEnLaCola;
    }

    public double getProbabilidadDeDesocupado() {
        return probabilidadDeDesocupado;
    }

    public double getProbabilidadDeOcupado() {
        return probabilidadDeOcupado;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getMiu() {
        return miu;
    }

    public void setMiu(double miu) {
        this.miu = miu;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
