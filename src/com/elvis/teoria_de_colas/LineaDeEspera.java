package com.elvis.teoria_de_colas;

public class LineaDeEspera {
    private double lambda;
    private double miu;
    private double numeroDeClientes;
    private double clientesEnElSistema;
    private double clientesEnLaCola;
    private double tiempoEnElSistema;
    private double tiempoEnLaCola;
    private double probabilidadDeDesocupado;
    private double probabilidadDeOcupado;
    private String unidad;
    private double probabilidadDeNumeroDeClientes;

    public LineaDeEspera(double lambda, double miu, String unidad, double numeroDeClientes) {
        this.setNumeroDeClientes(numeroDeClientes);
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
        this.setTiempoEnElSistema(1 / (miu - lambda));
        this.setTiempoEnLaCola(lambda / (miu * (miu - lambda)));
        this.probabilidadDeDesocupado = (1 - (lambda / miu)) * 100;
        this.probabilidadDeOcupado = (lambda / miu) * 100;
        this.probabilidadDeNumeroDeClientes = ((1 - (lambda / miu)) * Math.pow((lambda / miu), getNumeroDeClientes())) * 100;
    }

    public void imprimirResultado(){
        Resultado frame = new Resultado(getClientesEnElSistema(), getClientesEnLaCola(),
                getTiempoEnElSistema(), getTiempoEnLaCola(), getProbabilidadDeDesocupado(),
                getProbabilidadDeOcupado(), getUnidad(), getProbabilidadDeNumeroDeClientes(), getNumeroDeClientes());
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

    public void setTiempoEnElSistema(double tiempoEnElSistema) {
        this.tiempoEnElSistema = tiempoEnElSistema;
    }

    public void setTiempoEnLaCola(double tiempoEnLaCola) {
        this.tiempoEnLaCola = tiempoEnLaCola;
    }

    public double getProbabilidadDeNumeroDeClientes() {
        return probabilidadDeNumeroDeClientes;
    }

    public void setProbabilidadDeNumeroDeClientes(double probabilidadDeNumeroDeClientes) {
        this.probabilidadDeNumeroDeClientes = probabilidadDeNumeroDeClientes;
    }

    public double getNumeroDeClientes() {
        return numeroDeClientes;
    }

    public void setNumeroDeClientes(double numeroDeClientes) {
        this.numeroDeClientes = numeroDeClientes;
    }
}
