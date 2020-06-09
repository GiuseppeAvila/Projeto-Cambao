package br.edu.insper.al.carolineclc.myapplication;

public class User {

    private String email;
    private String fullName;
    private String placa;
    private String phone;
    private String password;
    private String caminhoes;
    private Entrega frete1;
    private Entrega frete2;
    private Entrega frete3;
    private String id;

    public User(String fullName, String email, String caminhoes,
                String placa, String phone) {
        this.id =null;
        this.email = email;
        this.fullName = fullName;
        this.placa = placa;
        this.phone = phone;
        this.caminhoes = caminhoes;
        this.frete1=null;
        this.frete2=null;
        this.frete3=null;

    }

/*    public HashMap<String, Object> getAsMap(){
        HashMap<String, Object> userAsMap = new HashMap<>();
        userAsMap.put("username",username);
        userAsMap.put("password",password);
        userAsMap.put("age",age);
        userAsMap.put("name",name);

        //Add or remove more key value pair

        return userAsMap;
    }*/

    public void setpassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setPlaca(String wordplace) {
        this.placa = wordplace;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() { return fullName; }

    public String getPlaca() {
        return placa;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getpassword() {
        return password;
    }

    public String getCaminhoes() {return caminhoes; }

    public void setCaminhoes(String caminhoes) { this.caminhoes = caminhoes; }

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
}
