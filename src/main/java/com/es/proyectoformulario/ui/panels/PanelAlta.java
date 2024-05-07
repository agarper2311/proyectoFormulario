package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;

public class PanelAlta extends JPanel {

    // VINCULAMOS EL PANEL AL FRAME
    private FrameLogin framePadre;


    public PanelAlta(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(0xDFDCDC));
        this.setLayout(null);

        JLabel eti = new JLabel("Panel ALTA");
        eti.setBounds(200,200,172,55);
        this.add(eti);

    }


}
