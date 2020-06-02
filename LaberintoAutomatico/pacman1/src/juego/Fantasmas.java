/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import static juego.Juego.mat;

/**
 *
 * @author admin
 */
public class Fantasmas {
    
    int fanx;
    int fany;
    Timer timer;
    Random aleatorio;
    int direccion;
    int mx;
    int my;
    
    public Fantasmas(int x,int y)
    {
        aleatorio=new Random();
        fanx=x;
        fany=y;
        Juego.mat[fanx][fany]=7;
        direccion=aleatorio.nextInt(4);
        this.movimiento();
        
    }//constructor
    
    public void movimiento()
    {
        timer= new Timer(200, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("esta funcionando el timer");
                //izquierda
                if(fanx > 0 && direccion==0)
                {
                    //camina
                    if(Juego.mat[fanx-1][fany] != 2 && (Juego.mat[fanx-1][fany] == 0 || Juego.mat[fanx-1][fany] == 1))
                    {
                        Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                        fanx -=1;
                        Juego.mat[fanx][fany]=7;
                        Juego.pintaMatriz();
                    }else
                    //choca con la pared
                    if(fanx > 0 && Juego.mat[fanx-1][fany] == 2)
                    {
                        direccion=aleatorio.nextInt(4);
                    }else
                    //choca con otro fantasma
                    if(Juego.mat[fanx-1][fany] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }
                }
                //derecha
                if(direccion==1)
                {
                    if(Juego.mat[fanx+1][fany] != 2 && (Juego.mat[fanx+1][fany] == 0 || Juego.mat[fanx+1][fany] == 1))
                    {
                        Juego.mat[fanx][fany]=Juego.matAux[fanx][fany];
                        fanx +=1;
                        Juego.mat[fanx][fany]=7;
                        Juego.pintaMatriz();
                    }else
                    //choca con la pared
                    if(fanx < 14 && Juego.mat[fanx+1][fany] == 2)
                    {
                        direccion=aleatorio.nextInt(4);
                    }else
                    //choca con otro fantasma
                    if(Juego.mat[fanx+1][fany] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }
                    
                }
                //arriba
                if(fany > 0 && direccion==2)
                {
                    if(Juego.mat[fanx][fany-1] !=2 && (Juego.mat[fanx][fany-1] == 0 || Juego.mat[fanx][fany-1] == 1))
                    {
                        Juego.mat[fanx][fany] = Juego.matAux[fanx][fany];
                        fany -=1;
                        Juego.mat[fanx][fany]=7;
                        Juego.pintaMatriz();
                    }else
                    //choca con la pared
                    if(fany > 0 && Juego.mat[fanx][fany-1] == 2)
                    {
                        direccion=aleatorio.nextInt(4);
                    }else
                    //choca con otro fantasma
                    if(Juego.mat[fanx][fany-1] == 7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }
                    
                }
                //abajo
                if(direccion==3)
                {
                    if(Juego.mat[fanx][fany+1] != 2 && (Juego.mat[fanx][fany+1] == 0 || Juego.mat[fanx][fany+1] == 1))
                    {
                        Juego.mat[fanx][fany] = Juego.matAux[fanx][fany]; 
                        fany +=1;
                        Juego.mat[fanx][fany]=7;
                        Juego.pintaMatriz();
                    }else
                    //choca con la pared
                    if(fany < 14 && Juego.mat[fanx][fany+1]==2)
                    {
                        direccion=aleatorio.nextInt(4);
                    }else
                    //choca con otro fantasma
                    if(Juego.mat[fanx][fany+1]==7)
                    {
                        direccion = aleatorio.nextInt(4);
                    }
                    Juego.pintaMatriz();
                }
                
                
                
            }});
        timer.start();
    }
}
    

    

