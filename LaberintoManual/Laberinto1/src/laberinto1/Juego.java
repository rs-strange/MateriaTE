/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto1;


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
    int left;
    int right;
    int up;
    int down;
    JLabel derecha1;
    JLabel izquierda1;
    JLabel arriba1;
    JLabel abajo1;
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
        
        right=0;
        derecha1 =new JLabel("right : "+right);
        derecha1.setBounds(ventana.getWidth()-(150+20),20,150,30);
        derecha1.setForeground(Color.white);
        derecha1.setVisible(true);
        panelJuego.add(derecha1,0);
        
        left=0;
        izquierda1 =new JLabel("izquierda : "+left);
        izquierda1.setBounds(ventana.getWidth()-(150+20),0,150,30);
        izquierda1.setForeground(Color.white);
        izquierda1.setVisible(true);
        panelJuego.add(izquierda1,0);
        
        up=0;
        arriba1 =new JLabel("arriba : "+up);
        arriba1.setBounds(ventana.getWidth()-(150+20),40,150,30);
        arriba1.setForeground(Color.white);
        arriba1.setVisible(true);
        panelJuego.add(arriba1,0);
        
        down=0;
        abajo1 =new JLabel("abajo : "+down);
        abajo1.setBounds(ventana.getWidth()-(150+20),60,150,30);
        abajo1.setForeground(Color.white);
        abajo1.setVisible(true);
        panelJuego.add(abajo1,0);
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
        
        timer= new Timer(200, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(arriba == 1 && (mat[px][py-1]==9 || mat[px][py-1]==0))
                {
                    System.out.println("arriba");
                    if(mat[px][py-1]==9)
                    {
                        JOptionPane.showMessageDialog(ventana, "ganaste");
                        timer.stop();
                    }
                    up=up+1;
                    arriba1.setText("arriba: "+up);
                    mat[px][py]=0;
                    matAux[px][py]=mat[px][py];//new
                    py=py-1;
                    mat[px][py]=3;
                    pintaMatriz();
                    arriba=0;
                    
                }
                if(abajo == 1 && (mat[px][py+1]==9 || mat[px][py+1]==0))
                {
                    System.out.println("abajo");
                    if(mat[px][py+1]==9)
                    {
                        JOptionPane.showMessageDialog(ventana, "ganaste");
                        timer.stop();
                    }
                    down=down+1;
                    abajo1.setText("abajo: "+down);
                    mat[px][py]=0;
                    matAux[px][py]=mat[px][py];//new
                    py=py+1;
                    mat[px][py]=3;
                    pintaMatriz();
                    abajo=0;

                }
                if(izq == 1 && (mat[px-1][py]==9 || mat[px-1][py]==0))
                {
                    System.out.println("izquierda");
                    if(mat[px-1][py]==9)
                    {
                        JOptionPane.showMessageDialog(ventana, "ganaste");
                        timer.stop();
                    }
                    left=left+1;
                    izquierda1.setText("izquierda: "+left);
                    mat[px][py]=0;
                    matAux[px][py]=mat[px][py];//new
                    px=px-1;
                    mat[px][py]=3;
                    pintaMatriz();
                    izq=0;
                    
                    
                }
                if(der == 1 && (mat[px+1][py]==0 || mat[px+1][py]==9))
                {
                    System.out.println("derecha");
                    if(mat[px+1][py]==9)
                    {
                        JOptionPane.showMessageDialog(ventana, "ganaste");
                        timer.stop();
                    }
                    right=right+1;
                    derecha1.setText("derecha: "+right);
                    mat[px][py]=0;
                    matAux[px][py]=mat[px][py];//new
                    px=px+1;
                    mat[px][py]=3;
                    pintaMatriz();
                    der=0;
                    
                    if(mat[px][py]==9)
                    {
                        JOptionPane.showMessageDialog(ventana, "ganaste");
                        timer.stop();
                    }
                }
                
                int enc=0;
                for(int i=0;i<mat.length && enc==0;i++)
                {
                    for(int j=0;j<mat.length && enc==0;j++)
                    {
                       if(mat[i][j]==1)
                       {
                           enc=1;
                       }

                    }
                    
                }
                if(enc==0)
                       {
                           JOptionPane.showMessageDialog(ventana, "ganaste");
                           panelJuego.setVisible(false);
                           panelMenu.setVisible(true);
                           timer.stop();
                       }
                
                if(mat[px][py+1] == 7 || mat[px][py-1] == 7 
                        || mat[px-1][py] == 7 || mat[px+1][py] == 7)
                {
                    //fantasma1.timer.stop();
                    //fantasma2.timer.stop();
                    //7fantasma3.timer.stop();
                    JOptionPane.showMessageDialog(ventana, "estas muerto");
                    panelJuego.setVisible(false);
                    panelMenu.setVisible(true);
                    timer.stop();
                }
                
        }});
        
        timer.start();
        
        ventana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP)
                {
                    
                    if(mat[px][py-1]==9 || mat[px][py-1]==0)
                    {
                        arriba= 1;
                        abajo=0;
                        izq=0;
                        der=0;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    //System.out.println("tecla hacia abajo");
                    if(mat[px][py+1]==9 || mat[px][py+1]==0)
                    {
                        arriba= 0;
                        abajo=1;
                        izq=0;
                        der=0;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    //System.out.println("tecla hacia izquierda");
                    if(mat[px-1][py]==9 || mat[px-1][py]==0)
                    {
                        arriba= 0;
                        abajo=0;
                        izq=1;
                        der=0;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    //System.out.println("tecla hacia derecha");
                    if(mat[px+1][py]==9 || mat[px+1][py]==0)
                    {
                        arriba=0;
                        abajo=0;
                        izq=0;
                        der=1;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }   
  
    public boolean paso(int x, int y)
    {
        pintaMatriz();
        System.out.println("fun entro pasoooo --");
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
        System.out.println("paso --");
        result=paso(x,y+1); //ir a derecha
        pintaMatriz();
        
        if(result)
        {return true;}
        
        pintaMatriz();
        System.out.println("arriba");
        result=paso(x-1, y); //ir hacia arriba
        if(result)
        {return true;}
        
        pintaMatriz();
        System.out.println("izquierda");
        result=paso(x, y-1); //ir hacia izq
        pintaMatriz();
        if(result)
        {pintaMatriz();
            return true;}
        
        pintaMatriz();
        System.out.println("abajo");
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
                {2,0,2,0,0,0,2,2,0,2,0,0,2,0,2},
                {2,0,2,0,0,0,0,2,0,2,0,0,2,0,2},
                {2,0,2,0,2,0,2,0,2,0,0,0,2,0,2},
                {2,0,2,0,0,0,0,2,0,0,0,0,2,0,2},
                {2,0,2,0,0,0,2,2,0,0,0,0,2,0,2},
                {2,0,2,0,0,0,0,0,0,0,2,0,2,0,2},
                {2,0,2,0,2,0,2,0,0,0,2,0,0,0,2},
                {2,0,2,0,0,0,2,0,0,2,0,0,2,0,2},
                {2,0,2,0,0,0,2,2,0,0,2,0,2,0,2},
                {2,0,2,0,0,0,0,0,0,0,2,2,2,0,2},
                {2,0,2,0,2,0,0,2,2,0,0,9,2,0,2},
                {2,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
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
        //botones[1].setText("crear tablero");
        //botones[2].setText("records");
        //botones[3].setText("cargar tablero");
        //botones[4].setText("salir");
        
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
        
        /*botones[1].addMouseListener(new MouseAdapter() {
            
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
*/
    }

}
