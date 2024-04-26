package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.ServiceUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLogin extends JPanel {
    JTextField user;
    JPasswordField pass;
    JButton bEnviar;

    ServiceUser serviceUser = new ServiceUser();

    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String username = user.getText();
            String password = new String(pass.getPassword());

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(PanelLogin.this, "Por favor, introduzca el nombre de usuario y la contraseña", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(PanelLogin.this, "Por favor, introduzca el nombre de usuario", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(PanelLogin.this, "Por favor, introduzca la contraseña", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            } else {
                User user = serviceUser.checkUser(username, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(PanelLogin.this, "Bienvenido " + user.getName() + "!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(PanelLogin.this, "Credenciales incorrectas. Intente nuevamente.", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
        }
    };

    public PanelLogin() {
        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200,135));
        usuario.setSize(new Dimension(152,32));
        this.add(usuario);

        user = new JTextField();
        user.setLocation(new Point(260,135));
        user.setSize(new Dimension(152,32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200,200));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,200));
        pass.setSize(new Dimension(152,32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(220,321));
        bEnviar.setSize(new Dimension(152,32));
        this.add(bEnviar);
        bEnviar.addMouseListener(listenerMouse);

        JButton bRegistrarse = new JButton("Registrarse");
        bRegistrarse.setLocation(new Point(220, 360));
        bRegistrarse.setSize(new Dimension(152, 32));
        this.add(bRegistrarse);

        bRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir la ventana de registro al hacer clic
                PanelAlta alta = new PanelAlta();
                alta.setVisible(true);
            }
        });
    }
}
