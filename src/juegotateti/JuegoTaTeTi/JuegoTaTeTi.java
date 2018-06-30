/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotateti.JuegoTaTeTi;

import java.awt.Color;
import java.awt.Font; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Guada
 */
public class JuegoTaTeTi {
    
    JFrame ventana;
    JPanel panelInicio;
    JLabel fondo;
    JLabel titulo;
    Font fuenteTitulo = new Font("Arial", 1, 33);
    JLabel labelJugador1;
    JLabel labelJugador2;
    Font fuenteJugador = new Font("Arial", 1, 13);
    JTextField jugador1;
    JTextField jugador2;
    JButton comenzar;
    
    JPanel panelEleccion;
    JLabel nombreJugador1;
    JLabel nombreJugador2;
    JLabel elijeFichaJugador1;
    JLabel fichaX;
    JLabel fichaO;
    int ficha;
    JLabel jugador1JuegaCon;
    JLabel jugador2JuegaCon;
    Font fuenteTurno = new Font("Arial", 1, 22);
    JButton jugar;
    JPanel panelJuego;
    JLabel turno;
    int juegaJugador = 1;
    JLabel tablero[][] = new JLabel[3][3];
    int[][] matriz = new int[3][3];
    JLabel ganador;
    JLabel empataron;
    
    
    // CREO EL CONSTRUCTOR DE LA CLASE:
    
    public JuegoTaTeTi() {
        // CREO LA VENTANA
        ventana = new JFrame("Juego de TA TE TI");
        ventana.setSize(666, 499);
        ventana.setLocationRelativeTo(null);
        // PODER COLOCAR COMPONENTES DONDE UNO QUIERA
        ventana.setLayout(null);
        // BOTÓN PARA CERRAR LA VENTANA
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        panelInicio = new JPanel();
        panelInicio.setSize(ventana.getWidth(), ventana.getHeight());
        panelInicio.setLayout(null);
        panelInicio.setVisible(true);
        
        fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/fondo.jpg")));
        fondo.setSize(ventana.getWidth(), ventana.getHeight());
        fondo.setVisible(true);
        panelInicio.add(fondo);
        
        titulo = new JLabel("TA TE TI");
        titulo.setBounds(0, 22, 666, 33);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(Color.black);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVisible(true);
        panelInicio.add(titulo,0);
        
        labelJugador1 = new JLabel("Ingresá el nombre del Jugador 1:");
        labelJugador1.setFont(fuenteJugador);
        labelJugador1.setForeground(Color.black);
        labelJugador1.setVisible(true);
        labelJugador1.setBounds(100, 99, 266, 33);
        panelInicio.add(labelJugador1,0);
        
        jugador1 = new JTextField("");
        jugador1.setBounds(347, 99, 199, 33);
        jugador1.setVisible(true);
        panelInicio.add(jugador1,0);
        
        labelJugador2 = new JLabel("Ingresá el nombre del Jugador 2:");
        labelJugador2.setFont(fuenteJugador);
        labelJugador2.setForeground(Color.black);
        labelJugador2.setVisible(true);
        labelJugador2.setBounds(100, 147, 266, 33);
        panelInicio.add(labelJugador2,0);
        
        jugador2 = new JTextField("");
        jugador2.setBounds(347, 147, 199, 33);
        jugador2.setVisible(true);
        panelInicio.add(jugador2);
                
        panelEleccion = new JPanel();
        panelEleccion.setSize(ventana.getWidth(), ventana.getHeight());
        panelEleccion.setLayout(null);
        panelEleccion.setVisible(true);
        
        panelJuego = new JPanel();
        panelJuego.setSize(ventana.getWidth(), ventana.getHeight());
        panelJuego.setLayout(null);
        panelJuego.setVisible(true);
        
        comenzar = new JButton("Comenzar");
        comenzar.setBounds(250, 266, 166, 33);
        comenzar.setVisible(true);
        comenzar.setBackground(java.awt.Color.LIGHT_GRAY);
        comenzar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if (jugador1.getText().compareTo("") != 0 && jugador2.getText().compareTo("") != 0){
                    panelInicio.setVisible(false);
                    panelJuego.setVisible(false);
                    panelEleccion.add(fondo);
                    ventana.add(panelEleccion);
                    elijeFichaJugador1.setText(jugador1.getText() + " ¿Con cuál ficha querés jugar?");
                    panelEleccion.add(elijeFichaJugador1,0);
                }
            }
        });
        panelInicio.add(comenzar,0);
        
        elijeFichaJugador1 = new JLabel();
        elijeFichaJugador1.setFont(fuenteJugador);
        elijeFichaJugador1.setForeground(Color.black);
        elijeFichaJugador1.setVisible(true);
        elijeFichaJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        elijeFichaJugador1.setBounds(0, 33, 666, 33);
        
        jugador1JuegaCon = new JLabel();
        jugador1JuegaCon.setFont(fuenteJugador);
        jugador1JuegaCon.setForeground(Color.black);
        jugador1JuegaCon.setVisible(true);
        jugador1JuegaCon.setBounds(147, 333, 222, 33);
        panelEleccion.add(jugador1JuegaCon);
        
        jugador2JuegaCon = new JLabel();
        jugador2JuegaCon.setFont(fuenteJugador);
        jugador2JuegaCon.setForeground(Color.black);
        jugador2JuegaCon.setVisible(true);
        jugador2JuegaCon.setBounds(399, 333, 222, 33);
        panelEleccion.add(jugador2JuegaCon);
        
        fichaX = new JLabel();
        fichaX.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/1.png")));
        fichaX.setSize(133, 133);
        fichaX.setVisible(true);
        fichaX.setBounds(166, 99, 133, 133);
        fichaX.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                jugar.setVisible(true);
                ficha = 1;
                jugador1JuegaCon.setText(jugador1.getText() + " Jugás con las X");
                jugador2JuegaCon.setText(jugador2.getText() + " Jugás con las O");
                fichaX.setEnabled(false);
                fichaO.setEnabled(false);
            }
        });
        panelEleccion.add(fichaX);
        
        fichaO = new JLabel();
        fichaO.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/2.png")));
        fichaO.setSize(133, 133);
        fichaO.setVisible(true);
        fichaO.setBounds(399, 99, 133, 133);
        fichaO.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                jugar.setVisible(true);
                ficha = 2;
                jugador1JuegaCon.setText(jugador1.getText() + " Jugás con las O");
                jugador2JuegaCon.setText(jugador2.getText() + " Jugás con las X");
                fichaO.setEnabled(false);
                fichaX.setEnabled(false);
                
            }
        });
        panelEleccion.add(fichaO);
        
        nombreJugador1 = new JLabel();
        nombreJugador1.setBounds(9, 0, 333, 33);
        nombreJugador1.setVisible(true);
        nombreJugador1.setFont(fuenteJugador);
        nombreJugador1.setForeground(Color.black);
        panelJuego.add(nombreJugador1,0);
        
        nombreJugador2 = new JLabel();
        nombreJugador2.setBounds(350, 0, 333, 33);
        nombreJugador2.setVisible(true);
        nombreJugador2.setFont(fuenteJugador);
        nombreJugador2.setForeground(Color.black);
        panelJuego.add(nombreJugador2,0);
        
        turno = new JLabel();
        turno.setVisible(true);
        turno.setFont(fuenteTurno);
        turno.setForeground(Color.black);
        turno.setHorizontalAlignment(SwingConstants.CENTER);
        turno.setBounds(0, 25, 666, 33);
        panelJuego.add(turno);
        
        ganador = new JLabel();
        ganador.setFont(fuenteTurno);
        ganador.setForeground(Color.black);
        ganador.setVisible(true);
        ganador.setBounds(188, 25, 299, 33);
                
        empataron = new JLabel();
        empataron.setFont(fuenteTurno);
        empataron.setForeground(Color.black);
        empataron.setVisible(true);
        empataron.setBounds(188, 25, 299, 33);
        
        jugar = new JButton("Jugar");
        jugar.setBounds(250, 399, 166, 33);
        jugar.setVisible(false);
        jugar.setBackground(java.awt.Color.LIGHT_GRAY);
        jugar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){   
                    panelInicio.setVisible(false);
                    panelEleccion.setVisible(false);
                    panelJuego.setVisible(true);
                    panelJuego.add(fondo);
                    ventana.add(panelJuego);
                    nombreJugador1.setText("El Jugador 1 es: "+ jugador1JuegaCon.getText());
                    nombreJugador2.setText("El Jugador 2 es: "+ jugador2JuegaCon.getText());
                    turno.setText("Le toca jugar a: " + jugador1.getText());
                    int filas = matriz.length;
                    int columnas = matriz[0].length;
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            matriz[i][j] = 0;
                            tablero[i][j] = new JLabel();
                            tablero[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[i][j] + ".png")));
                            tablero[i][j].setBounds(125+133*i, 66+133*j, 133, 133);
                            tablero[i][j].setVisible(true);
                            panelJuego.add(tablero[i][j],0);
                        }
                    }
                        
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            tablero[i][j].addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e){
                                    for (int k = 0; k < tablero.length; k++) {
                                        for (int l = 0; l < tablero.length; l++) {
                                            
                                            if (e.getSource() == tablero[k][l]){
                                                System.out.println(k + " " + l);
                                                if (matriz[k][l] == 0){
                                                    
                                                    if (ficha == 1){
                                                        if (juegaJugador == 1){
                                                            matriz[k][l] = 1;
                                                            tablero[k][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[k][l] + ".png")));
                                                            gano(matriz, 1, juegaJugador);
                                                            tableroLleno(matriz);
                                                            turno.setText("Le toca jugar a: " + jugador2.getText());
                                                        }
                                                        else {
                                                            matriz[k][l] = 2;
                                                            tablero[k][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[k][l] + ".png")));
                                                            gano(matriz, 2, juegaJugador);
                                                            tableroLleno(matriz);
                                                            turno.setText("Le toca jugar a: " + jugador1.getText());
                                                        }
                                                    }
                                                      
                                                    if (ficha == 2){
                                                        if (juegaJugador == 1){
                                                            matriz[k][l] = 2;
                                                            tablero[k][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[k][l] + ".png")));
                                                            gano(matriz, 2, juegaJugador);
                                                            tableroLleno(matriz);
                                                            turno.setText("Le toca jugar a: " + jugador2.getText());
                                                        }
                                                        else {
                                                            matriz[k][l] = 1;
                                                            tablero[k][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[k][l] + ".png")));
                                                            gano(matriz, 1, juegaJugador);
                                                            tableroLleno(matriz);
                                                            turno.setText("Le toca jugar a: " + jugador1.getText());
                                                        }
                                                    }

                                                    juegaJugador *= -1;
                                                
                                                }
                                               
                                                
                                            }
                                    }
                                    }
                                    }
                                
                                
                        });
                            
                    }
                }
            }
        });
        panelEleccion.add(jugar,0);
        
        
        
        ventana.add(panelInicio);
        
                
        
        ventana.add(panelJuego);
        
        
        
        
        
        
        
        
        ventana.setVisible(true);
        
    }


public void gano (int[][] matriz, int ficha, int juegaJugador){
         boolean gano = false;
         int filas = matriz.length;
         int columnas= matriz[0].length;
         int contadorX ;
         int contadorY;
         int contadorO = 0;
         int contadorU = 0;
         
         for (int i = 0; i < filas; i++){
             contadorX = 0;
             for (int j = 0; j < columnas; j++){
                 if (matriz[i][j] == ficha){
                     contadorX++;
                 }
            }
             if (contadorX == filas){
                 gano = true;
             }
         }
         
         for (int j = 0; j < filas; j++){
             contadorY = 0;
             for (int i = 0; i < columnas; i++){
                 if (matriz[i][j] == ficha){
                     contadorY++;
                 }
             }
             if (contadorY == columnas){
                 gano = true;
             }
         }
        
         for (int i = 0; i < filas; i++){
             for (int j = 0; j < columnas; j++){
                 if (i == j){
                     if (matriz[i][j] == ficha){
                        contadorO++;
                     }
                 }
             }
             if (contadorO == filas){
                 gano = true;
             }
         }
         
         for (int i = 0; i < filas; i++){
             contadorX = 0;
             for (int j = 0; j < columnas; j++){
               if ((i == 0 && j == 2) || (i == 1 && j ==1) || (i == 2 && j == 0)){
                     if (matriz[i][j] == ficha){
                        contadorU++;
                     }
                 }
             }
             if (contadorU == filas){
                 gano = true;
             }
         }   
                  
         if (gano) {
            turno.setVisible(false);
            if (juegaJugador == 1){
                int jugarDeNuevo = JOptionPane.showConfirmDialog(null, "¡Felicidades " + jugador1.getText() + " ganaste!\n¿Quieren Jugar de Nuevo?", "Partida Terminada", JOptionPane.YES_NO_OPTION);
                if (jugarDeNuevo == 0){
                    turno.setVisible(true);
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            matriz[i][j] = 0;
                            tablero[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[i][j] + ".png")));
                        }
                    }
                }
                if (jugarDeNuevo == 1){
                    System.exit(0);
                }
                }
                else {
                    int jugarDeNuevo = JOptionPane.showConfirmDialog(null, "¡Felicidades " + jugador2.getText() + " ganaste!\n¿Quieren Jugar de Nuevo?", "Partida Terminada", JOptionPane.YES_NO_OPTION);
                    if (jugarDeNuevo == 0){
                        turno.setVisible(true);
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                matriz[i][j] = 0;
                                tablero[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[i][j] + ".png")));
                            }
                        }
                    }
                    if (jugarDeNuevo == 1){
                        System.exit(0);
                    }
                }
        }
     }


    public void tableroLleno (int[][] matriz){
        boolean tableroLleno = false;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int contador= 0;

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if (matriz[i][j] == 1 || matriz[i][j] == 2){
                   contador++;
                }
            }
        }
        
        if (contador == (filas*columnas)){
            tableroLleno = true;
        }
             
        if (tableroLleno){
            turno.setVisible(false);
            int jugarDeNuevo = JOptionPane.showConfirmDialog(null, "¡Empataron el partido!\n¿Quieren Jugar de Nuevo?", "Partida Terminada", JOptionPane.YES_NO_OPTION);
            if (jugarDeNuevo == 0){
                turno.setVisible(true);
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        matriz[i][j] = 0;
                        tablero[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/" + matriz[i][j] + ".png")));
                    }
                }
            }
            if (jugarDeNuevo == 1){
                System.exit(0);
            }

        }
    }


}