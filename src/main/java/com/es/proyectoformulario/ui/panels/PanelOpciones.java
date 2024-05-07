package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel {

    private FrameLogin framePadre;

    private JButton botonAlta, botonBaja, botonModificar, botonConsultar;


    public PanelOpciones(FrameLogin framePadre) {

        this.framePadre = framePadre;
        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        botonAlta = new JButton("Alta");
        botonBaja = new JButton("Baja");
        botonModificar = new JButton("Modificar");
        botonConsultar = new JButton("Consultar");

        this.setBackground(new Color(0xDFDCDC));
        this.botonAlta.setBackground(new Color(0xC0DDB8));
        this.botonBaja.setBackground(new Color(0xEA8484));
        this.botonModificar.setBackground(new Color(0xD8B969));
        this.botonConsultar.setBackground(new Color(0x69B0D8));

        this.botonAlta.setBounds(200, 100, 130, 32);
        this.botonBaja.setBounds(200, 200, 130, 32);
        this.botonModificar.setBounds(200, 300, 130, 32);
        this.botonConsultar.setBounds(200, 400, 130, 32);

        this.add(botonAlta);
        this.add(botonBaja);
        this.add(botonModificar);
        this.add(botonConsultar);

    }
}
