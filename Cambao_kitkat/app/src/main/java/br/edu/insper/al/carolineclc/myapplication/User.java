package br.edu.insper.al.carolineclc.myapplication;

public class User {

    private String email;
    private String fullName;
    private String placa;
    private String phone;
    private String password;
    private String caminhoes;
    private Entrega frete1, frete2,frete3, frete4, frete5,frete6;
    private String id;
    private String nomec1,nomec2,nomec3;
    private Entrega antiga1, antiga2, antiga3, antiga4, antiga5, antiga6;
    private String entregas;


    public User(String fullName, String email, String caminhoes,
                String placa, String phone, Entrega frete1, Entrega frete2, Entrega frete3, Entrega frete4, Entrega frete5, Entrega frete6,
                Entrega antiga1, Entrega antiga2, Entrega antiga3, Entrega antiga4, Entrega antiga5, Entrega antiga6,
                String entregas) {
        this.id =null;
        this.entregas = entregas;

        this.email = email;
        this.fullName = fullName;
        this.placa = placa;
        this.phone = phone;
        this.caminhoes = caminhoes;
        this.nomec1="Caminhão 1";
        this.nomec2="Caminhão 2";
        this.nomec3="Caminhão 3";

        this.frete1=frete1;
        this.frete2=frete2;
        this.frete3=frete3;
        this.frete4=frete4;
        this.frete5=frete5;
        this.frete6=frete6;

        this.antiga1=antiga1;
        this.antiga2=antiga2;
        this.antiga3=antiga3;
        this.antiga4=antiga4;
        this.antiga5=antiga5;
        this.antiga6=antiga6;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(String caminhoes) {
        this.caminhoes = caminhoes;
    }

    public Entrega getFrete1() {
        return frete1;
    }

    public void setFrete1(Entrega frete1) {
        this.frete1 = frete1;
    }

    public Entrega getFrete2() {
        return frete2;
    }

    public void setFrete2(Entrega frete2) {
        this.frete2 = frete2;
    }

    public Entrega getFrete3() {
        return frete3;
    }

    public void setFrete3(Entrega frete3) {
        this.frete3 = frete3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomec1() {
        return nomec1;
    }

    public void setNomec1(String nomec1) {
        this.nomec1 = nomec1;
    }

    public String getNomec2() {
        return nomec2;
    }

    public void setNomec2(String nomec2) {
        this.nomec2 = nomec2;
    }

    public String getNomec3() {
        return nomec3;
    }

    public void setNomec3(String nomec3) {
        this.nomec3 = nomec3;
    }

    public Entrega getAntiga1() {
        return antiga1;
    }

    public void setAntiga1(Entrega antiga1) {
        this.antiga1 = antiga1;
    }

    public Entrega getAntiga2() {
        return antiga2;
    }

    public void setAntiga2(Entrega antiga2) {
        this.antiga2 = antiga2;
    }

    public Entrega getAntiga3() {
        return antiga3;
    }

    public void setAntiga3(Entrega antiga3) {
        this.antiga3 = antiga3;
    }

    public Entrega getAntiga4() {
        return antiga4;
    }

    public void setAntiga4(Entrega antiga4) {
        this.antiga4 = antiga4;
    }

    public Entrega getAntiga5() {
        return antiga5;
    }

    public void setAntiga5(Entrega antiga5) {
        this.antiga5 = antiga5;
    }

    public Entrega getAntiga6() {
        return antiga6;
    }

    public void setAntiga6(Entrega antiga6) {
        this.antiga6 = antiga6;
    }

    public Entrega getFrete4() {
        return frete4;
    }

    public void setFrete4(Entrega frete4) {
        this.frete4 = frete4;
    }

    public Entrega getFrete5() {
        return frete5;
    }

    public void setFrete5(Entrega frete5) {
        this.frete5 = frete5;
    }

    public Entrega getFrete6() {
        return frete6;
    }

    public void setFrete6(Entrega frete6) {
        this.frete6 = frete6;
    }

    public String getEntregas() {
        return entregas;
    }

    public void setEntregas(String entregas) {
        this.entregas = entregas;
    }
}
