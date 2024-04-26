package com.es.proyectoformulario;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;

public class ProyectoFormulario {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameLogin fc = new FrameLogin();
            }
        });
    }
}
