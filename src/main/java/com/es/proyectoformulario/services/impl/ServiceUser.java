package com.es.proyectoformulario.services.impl;

import com.es.proyectoformulario.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUser {

    // ATRIBUTOS
    private ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    private GestionFicheroUser gestionUser; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    private ServiceLogger logger;

    private String ruta = "src/main/resources/users/users.txt";

    public ServiceUser() {
        this.users = new ArrayList<>();
        this.gestionUser = new GestionFicheroUser();
        leerFicheroUsers();
        this.logger = new ServiceLogger();
    }

    // Modificado para devolver User en lugar de boolean
    public User checkUser(String idUser, String password) {
        for (int i = 0; i < this.users.size(); i++) {
            User usuario = this.users.get(i);
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)) {
                this.logger.registrarLog(idUser, "LOGIN", "OK");
                return usuario;  // Devuelve el usuario si las credenciales son correctas
            }
        }
        this.logger.registrarLog(idUser, "LOGIN", "NOT OK");
        return null;  // Devuelve null si las credenciales son incorrectas
    }

    public boolean userExists(String idUser) {
        return this.users.stream().anyMatch(user -> user.getId().equalsIgnoreCase(idUser));
    }

    public void leerFicheroUsers() {
        this.users = gestionUser.leerFichero(this.ruta);
    }

    public void anadirFicheroUsers(User u) {
        gestionUser.anadirFichero(u, this.ruta);
    }

    public void modificarFicheroUsers() {
        gestionUser.modificarFichero(this.users, this.ruta);
    }

}
