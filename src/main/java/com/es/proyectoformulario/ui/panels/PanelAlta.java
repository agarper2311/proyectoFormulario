package com.es.proyectoformulario.ui.panels;

import javax.swing.*;
import java.awt.*;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.model.User;

public class PanelAlta extends JFrame {
    JTextField idUser, nombre;
    JPasswordField pass, pass2;
    JComboBox<String> esAdmin;
    JButton bRegistrarse;
    ServiceUser serviceUser = new ServiceUser();

    public PanelAlta() {
        setTitle("Registro de Usuario");
        setSize(612, 450);  // Tamaño para coincidir con el tamaño del PanelLogin
        setLayout(null);
        getContentPane().setBackground(new Color(102, 153, 204));  // Mismo color de fondo que PanelLogin

        JLabel lblIdUser = new JLabel("ID de Usuario:");
        lblIdUser.setBounds(50, 35, 152, 32);
        add(lblIdUser);

        idUser = new JTextField();
        idUser.setBounds(210, 35, 300, 32);
        add(idUser);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 77, 152, 32);
        add(lblNombre);

        nombre = new JTextField();
        nombre.setBounds(210, 77, 300, 32);
        add(nombre);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(50, 119, 152, 32);
        add(lblPass);

        pass = new JPasswordField();
        pass.setBounds(210, 119, 300, 32);
        add(pass);

        pass2 = new JPasswordField();
        pass2.setBounds(210, 161, 300, 32);
        add(pass2);

        JLabel lblAdmin = new JLabel("¿Es administrador?");
        lblAdmin.setBounds(50, 203, 152, 32);
        add(lblAdmin);

        esAdmin = new JComboBox<>(new String[]{"No", "Sí"});
        esAdmin.setBounds(210, 203, 300, 32);
        add(esAdmin);

        bRegistrarse = new JButton("Registrarse");
        bRegistrarse.setBounds(180, 245, 152, 32);
        add(bRegistrarse);

        bRegistrarse.addActionListener(e -> registrarUsuario());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void registrarUsuario() {
        try {
            String id = idUser.getText().trim();
            String name = nombre.getText().trim();
            String password = new String(pass.getPassword());
            String passwordConfirm = new String(pass2.getPassword());
            boolean isAdmin = esAdmin.getSelectedItem().equals("Sí");

            if (id.isEmpty() || name.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(passwordConfirm)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (serviceUser.userExists(id)) {
                JOptionPane.showMessageDialog(this, "El ID de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User newUser = new User(id, name, password, isAdmin);
            serviceUser.anadirFicheroUsers(newUser);
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error registrando usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            dispose();
        }
    }
}