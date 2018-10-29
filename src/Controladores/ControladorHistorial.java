/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Productos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ControladorHistorial extends ColeccionHistorial{
    protected String nombre;
    public ControladorHistorial(String Nombre){
        this.nombre = Nombre;
        lee();
    }
    public void grabar(){
        try{
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);
            for(Productos p:historial){
                pw.print(p.getTipoMovimento()+"*"
                        +p.getCodigoProd()+"*"
                        +p.getTipoProducto()+"*"
                        +p.getNomProducto()+"*"
                        +p.getAnioMov()+"*"
                        +p.getMesMov()+"*"
                        +p.getDiaMov()+"*"
                        +p.getFechaVencimiento()+"*"
                        +p.getProveedor()+"*"
                        +p.getUnidad()+"*"
                        +p.getNroLote()+"*"
                        +p.getPrecio()+"*"
                        +p.getCant()+"*"
                        +p.getStock());
            }pw.close();
            
        }catch(Exception e){}
    }
    
    public void lee(){
        try{
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea!=null){
                StringTokenizer st = new StringTokenizer(linea,"*");
                String tipoMovimiento = st.nextToken();
                String codigoProb = st.nextToken();
                int tipoProducto = Integer.parseInt(st.nextToken());
                String nombrePro = st.nextToken();
                int aniomov = Integer.parseInt(st.nextToken());
                int mesMov = Integer.parseInt(st.nextToken());
                int diaMov = Integer.parseInt(st.nextToken());
                String fechaMov = st.nextToken();
                String proveedor = st.nextToken();
                String unidad = st.nextToken();
                int nroLte = Integer.parseInt(st.nextToken());
                double precio = Double.parseDouble(st.nextToken());
                double cantidad = Double.parseDouble(st.nextToken());
                double stock = Double.parseDouble(st.nextToken());
                Productos p = new Productos(tipoMovimiento, codigoProb, tipoProducto, nombrePro, aniomov, mesMov, diaMov, tipoMovimiento, proveedor, unidad, nroLte, precio, cantidad, stock);
                agrega(p);
            }br.close();
        }catch(Exception e){
            
        }
    }
    
}
