/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class Juego {
    
    static JFrame ventana;
    //presentacion
    JPanel panelPresentacion;
    JButton iniciar;
    JLabel fondoPresentacion;
    ImageIcon imagenFondoPres;

    
    //menu
    JPanel panelMenu;
    JButton botones[];
    JLabel fondoMenu;
    ImageIcon imagenFondoMenu;
    
    //juego
    static JPanel panelJuego;
    JLabel fondoJuego;
    ImageIcon imagenFondoJuego;
    static int mat[][];
    static int movimientos[];
    static JLabel matriz [][];
    int px;
    int py;
    int movXY;
    
    String jugador;
    JLabel nombre;
    int puntos;
    JLabel records;
    int abajo;
    int arriba;
    int izq;
    int der;
    Timer timer;
    Random aleatorio;
    int direccion;
    
    //Fantasmas 
    //Fantasmas fantasma1;
    //Fantasmas fantasma2;
    //Fantasmas fantasma3;
    
    static int matAux[][];
    
    public Juego()
    {
        aleatorio=new Random();
        direccion=aleatorio.nextInt(4);
        ventana = new JFrame("PACMAN");
        ventana.setSize(700, 700);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        panelPresentacion = new JPanel();
        panelPresentacion.setLayout(null);
        panelPresentacion.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelPresentacion.setVisible(true);
        panelPresentacion.setBackground(Color.red);
        
        iniciar = new JButton("Iniciar");
        iniciar.setBounds(ventana.getWidth()-120,20,100,30);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.white);
        panelPresentacion.add(iniciar,0);
        
        
        fondoPresentacion = new JLabel();
        fondoPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoPres = new ImageIcon("imagenes/constelacion.png");
        imagenFondoPres = new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoPresentacion.setIcon(imagenFondoPres);
        fondoPresentacion.setVisible(true);
        panelPresentacion.add(fondoPresentacion,0);
        
        
        //menu
        botones = new JButton[5];
        for(int i=0; i< botones.length; i++)
        {
            botones[i] = new JButton();
        }
        
     
       
        
        
        iniciar.addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("iniciar");
                menu();
                eventoMenu();
        }
        });
        
        //juego
        mat= new int[15][15];
        movimientos= new int[100];
        mat=tablero(1);
        //matAux=tablero(1);
        matriz = new JLabel[15][15];
        matAux=new int[15][15];
        for(int i = 0;i<mat.length;i++)
        {
            for(int j = 0;j<mat.length;j++)
            {
                matriz[i][j]= new JLabel();
                matAux[i][j]= mat[i][j];
            }
        }
        
        mat=tablero(1);
        px=1;
        py=1;
        movXY=0;
        mat[px][py]=3;
        

        abajo=0;
        arriba=0;
        izq=0;
        der=0;
        
        ventana.add(panelPresentacion);
        
        ventana.setVisible(true);

    }//fin constructor
    
    
    //
    //
    //
    
    public void jugar()
    {
        panelMenu.setVisible(false);
        panelJuego = new JPanel();
        panelJuego.setLayout(null);
        panelJuego.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelJuego.setVisible(true);
        
        fondoJuego = new JLabel();
        fondoJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoJuego = new ImageIcon("imagenes/constelacion.png");
        imagenFondoJuego = new ImageIcon(imagenFondoJuego.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoJuego.setIcon(imagenFondoJuego);
        fondoJuego.setVisible(true);
        panelJuego.add(fondoJuego,0);
        
        for(int i = 0;i<mat.length;i++)
        {
            for(int j = 0;j<mat.length;j++)
            {
                matriz[i][j].setIcon(new ImageIcon("imagenes/"+mat[i][j]+".png"));
                matriz[i][j].setBounds(120+(i*30), 120+(j*30), 30, 30);
                matriz[i][j].setVisible(true);
                panelJuego.add(matriz[i][j],0);
            }
            
        }
        
        nombre=new JLabel("jugador : "+jugador);
        nombre.setBounds(20,20,150,30);
        nombre.setForeground(Color.white);
        nombre.setVisible(true);
        panelJuego.add(nombre,0);
        
        puntos=0;
        records =new JLabel("puntos : "+puntos);
        records.setBounds(ventana.getWidth()-(150+20),20,150,30);
        records.setForeground(Color.white);
        records.setVisible(true);
        panelJuego.add(records,0);
        mover();
        //fantasma1= new Fantasmas(12,12);
        //fantasma2= new Fantasmas(13,13);
        //fantasma3= new Fantasmas(13,12);
        ventana.add(panelJuego);
    }
    
    public static void pintaMatriz()
    {
        for(int i = 0;i<mat.length;i++)
        {
            for(int j = 0;j<mat.length;j++)
            {
                matriz[i][j].setIcon(new ImageIcon("imagenes/"+mat[i][j]+".png"));
                matriz[i][j].setBounds(120+(i*30), 120+(j*30), 30, 30);
                matriz[i][j].setVisible(true);
                panelJuego.add(matriz[i][j],0);
            }
            
        }
    }
    
     public void mover()
    {
        timer= new Timer(100, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                pintaMatriz();
                if(paso(px,py))
                {
                    pintaMatriz();
                    mat[px][py]=9;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"no hay");
                }
            }});
        timer.start();
    }   
     
     int d=0;
     int i=0;
     int a=0;
     int b=0;
    public boolean paso(int x, int y)
    {
        pintaMatriz();
        if(mat[x][y]==9)
        {
            JOptionPane.showMessageDialog(null, "salida encontrada");
            
            return true;
        }
        
        Juego.pintaMatriz();
        if(mat[x][y]==2 || mat[x][y]==5 || mat[x][y]==6)
        {
            return false;
        }
        
        
        mat[x][y]=5;
        Juego.pintaMatriz();
        
        boolean result; // se coloca 8 de start
        
        d=d+1;
        System.out.println("mov  total abajo: "+d);
        result=paso(x,y+1); //ir a derecha
        pintaMatriz();
        
        if(result)
        {return true;}
        
        
        pintaMatriz();
        a=a+1;
        System.out.println("mov  total arriba: "+a);
        result=paso(x-1, y); //ir hacia arriba
        if(result)
        {return true;}
        
        pintaMatriz();
        i=i+1;
        System.out.println("mov  total derecha: "+i);
        result=paso(x, y-1); //ir hacia izq
        pintaMatriz();
        if(result)
        {pintaMatriz();
            return true;}
        
        pintaMatriz();
        b=b+1;
        System.out.println("mov  total abajo: "+b);
        result=paso(x+1, y);//ir hacia abajo
        if(result)
        {return true;}
        
        pintaMatriz();
        mat[x][y]=6;
        return false;
    }
    
    public int[][] tablero(int opcion){
        int[][]aux1= new int[15][15];
    
        
        if(opcion == 1)
        {
            int aux[][] =
            {
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {2,0,2,2,0,0,2,2,0,2,0,0,2,0,2},
                {2,0,2,2,0,0,0,2,0,2,0,0,2,0,2},
                {2,0,0,2,2,0,0,0,0,0,0,0,2,0,2},
                {2,0,0,2,0,0,0,2,0,0,0,0,2,0,2},
                {2,0,0,2,0,0,2,2,0,0,0,0,0,0,2},
                {2,0,2,2,0,0,0,9,0,0,2,0,2,0,2},
                {2,0,0,2,2,0,2,0,0,0,2,0,0,0,2},
                {2,0,0,2,0,0,2,0,0,0,0,0,2,0,2},
                {2,0,2,2,0,0,0,2,2,0,0,0,2,0,2},
                {2,0,0,2,0,2,0,2,0,0,2,0,2,0,2},
                {2,0,2,2,2,0,0,2,0,2,0,0,0,0,2},
                {2,0,0,0,2,0,0,2,0,0,2,0,2,0,2},
                {2,2,2,2,2,2,2,2,0,2,2,2,2,2,2},
            };
            return aux;
        }
        
        if(opcion == 2)
        {
            int aux[][] =
            {
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,1,2,1,1,1,1,1,1,1,1,1,1,1,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,1,2},
                {2,1,2,2,1,2,1,2,1,2,1,2,2,1,2},
                {2,1,2,2,2,1,1,1,1,1,1,1,2,1,2},
                {2,1,1,2,1,2,1,2,1,2,1,1,2,1,2},
                {2,1,2,2,2,1,2,2,1,2,1,1,2,1,2},
                {2,1,2,2,1,1,1,1,1,1,2,1,2,1,2},
                {2,1,2,2,2,1,2,1,2,1,2,1,2,1,2},
                {2,1,2,2,1,1,2,1,2,1,2,1,2,1,2},
                {2,1,2,2,1,1,1,1,1,1,1,1,2,1,2},
                {2,1,2,2,1,2,1,2,1,1,2,1,2,1,2},
                {2,1,2,2,2,2,2,2,2,2,2,2,2,1,2},
                {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            };
            return aux;
        }
        
        if(opcion == 3)
        {
            int aux[][] =
            {
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                {2,1,2,2,2,2,2,2,2,2,2,2,2,1,2},
                {2,1,2,2,1,2,1,2,1,2,1,2,2,1,2},
                {2,1,2,2,2,1,1,1,1,1,1,1,2,1,2},
                {2,1,1,2,1,2,1,2,1,2,1,1,2,1,2},
                {2,1,2,2,2,1,2,2,1,2,1,1,2,1,2},
                {2,1,2,2,1,1,1,1,1,1,2,1,2,1,2},
                {2,1,2,2,2,1,2,1,2,1,2,1,2,1,2},
                {2,1,2,2,1,1,2,1,2,1,2,1,2,1,2},
                {2,1,2,2,1,1,1,1,1,1,1,1,2,1,2},
                {2,2,2,2,1,2,1,2,1,1,2,1,2,1,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,1,2},
                {2,2,1,1,1,2,1,2,1,1,1,1,1,1,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            };
            return aux;
        }
    return aux1;
    }
    
    //
    //
    //
    
    
    public void menu()
    {
        panelPresentacion.setVisible(false);
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());
        panelMenu.setVisible(true);
        
        fondoMenu = new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu = new ImageIcon("imagenes/constelacion.png");
        imagenFondoMenu = new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(),ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu,0);
        
        botones[0].setText("jugar");
        
        
        for(int i=0;i< botones.length;i++)
        {
            botones[i].setBounds(ventana.getWidth()-(200+50), (i+1)*50,200,40);
            botones[i].setVisible(true);
            botones[i].setBackground(Color.white);
            panelMenu.add(botones[i],0);
        }
        
        ventana.add(panelMenu);
        
    }//fin menu
    
    public void eventoMenu()
    {
        
        botones[0].addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("jugar");
                
                jugador= JOptionPane.showInputDialog(ventana,"nombre del jugador","escribe aqui");
                while(jugador == null || jugador.compareTo("Escribe aqui")==0 || jugador.compareTo("")==0)
                {
                    jugador = JOptionPane.showInputDialog(ventana, "Debes ingresar usuario","escribe aqui");              
                }
                jugar();
            }
        });
        
        botones[1].addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("crear tablero");
        }
        });
        
        //botones record
        botones[2].addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("record");
               
        }
        });
        
        //cargar tablero
        botones[3].addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("cargar tablero");
        }
        });
        
        //salir
        botones[4].addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e){
                System.out.print("salir");
                System.exit(0);
                
        }
        });
    }

}
