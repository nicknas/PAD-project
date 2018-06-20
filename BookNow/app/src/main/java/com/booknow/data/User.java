package com.booknow.data;

/**
 *
 * Entidad Usuario
 *
 */
public class User {
    private int id;
    private String login;
    private int telefono;
    private String password;
    private String email;

    public User(int id, String login, int telefono, String password, String email){
        this.id = id;
        this.login = login;
        this.telefono = telefono;
        this.password = password;
        this.email = email;

    }

    public int getId(){
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;

    }

}
