/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Cajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int opcion=0;
        int TipoT=0;
        int Retiro=0;
        int MontoTotal=0;
        int Deposito=0;
        
        while(opcion != 3)
        {
            System.out.println("Ingresa numero 1-Si 2-No 3-salir");
            System.out.println("¿Transaccion valida?");
            Scanner entradaEscaner = new Scanner (System.in);
            opcion = entradaEscaner.nextInt();
            
            if(opcion == 1)
            {
                System.out.println("\n \n");
                System.out.println("TIPO DE TRANSACCION");
                System.out.println("1.- Extraccion");
                System.out.println("2.- Depositar");
                System.out.println("3.- Saldo");
                Scanner entradaEscaner1 = new Scanner (System.in);
                TipoT = entradaEscaner1.nextInt();
                
                System.out.println("\n \n");
                System.out.println("-*-*- -*-*- -*-*-");
                System.out.println("Monto total="+MontoTotal);
                
                if(TipoT == 1)
                {
                    if(MontoTotal <= 0)
                    {
                        System.out.println("\n \n");
                        System.out.println("Su Saldo es de 0, no puede realizar retiros");
                        System.out.println("\n \n");
                    }
                    else
                    {
                        System.out.println("\n \n");
                        System.out.println("Monto total="+MontoTotal);
                        System.out.println("-*-*- -*-*- -*-*-");
                        System.out.println("Extraccion");
                        System.out.println("¿Cuanto desea retirar?");
                        Scanner entradaEscaner2 = new Scanner (System.in);
                        Retiro = entradaEscaner2.nextInt();
                        MontoTotal=MontoTotal-Retiro;
                        System.out.println("\n \n");
                        System.out.println("-*-*- -*-*- -*-*-");
                        System.out.println("COMPROBANTE");
                        System.out.println("-- -- --");
                        System.out.println("Monto total="+MontoTotal);
                        System.out.println("\n \n");
                    }
                }else if(TipoT == 2)
                {
                    System.out.println("\n \n");
                    System.out.println("-*-*- -*-*- -*-*-");
                    System.out.println("DEPOSITAR");
                    System.out.println("¿Cuanto desea depositar?");
                    Scanner entradaEscaner3 = new Scanner (System.in);
                    Deposito = entradaEscaner3.nextInt();
                    MontoTotal=MontoTotal+Deposito;
                    System.out.println("\n \n");
                    System.out.println("-*-*- -*-*- -*-*-");
                    System.out.println("COMPROBANTE");
                    System.out.println("-- -- --");
                    System.out.println("Monto total="+MontoTotal);
                    System.out.println("\n \n");   
                }else if(TipoT == 3)
                {
                    System.out.println("\n \n");
                    System.out.println("-*-*- -*-*- -*-*-");
                    System.out.println("SALDO");
                    System.out.println("\n \n");
                    System.out.println("-*-*- -*-*- -*-*-");
                    System.out.println("COMPROBANTE");
                    System.out.println("-- -- --");
                    System.out.println("Monto total="+MontoTotal);
                    System.out.println("\n \n");   
                }
            }else if(opcion == 2)
            {
                System.out.println("!!! Error ¡¡¡");
            }
            
            System.out.println("\n");
            
        }
        System.out.println("--- SALIO DEL PROGRAMA ---");
    }
    
}
