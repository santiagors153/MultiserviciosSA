package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Productos {
    protected String codigoProd, nomProducto, fechaVencimiento, proveedor, unidad, tipoMovimiento;
    protected int  nroLote ,tipoProducto, anioMov, mesMov, diaMov;
    protected double precio, cant, Stock;
    private Conexion co;

    private PreparedStatement ps;

    public Productos(String codigoProd,double cant) {
        this.codigoProd = codigoProd;
        this.cant = cant;
        co = new Conexion();
        ps = null;
    }
    
    public Productos(String tipoMovimiento, String codigoProd, int tipoProducto, String nomProducto, 
            int anioMov, int mesMov, int diaMov, String fechaVencimiento, String proveedor, 
            String unidad, int nroLote, double precio, double cant, double Stock) {
        this.tipoMovimiento=tipoMovimiento;
        this.codigoProd = codigoProd;
        this.tipoProducto = tipoProducto;
        this.nomProducto = nomProducto;
        this.anioMov = anioMov;
        this.mesMov = mesMov;
        this.diaMov = diaMov;
        this.fechaVencimiento = fechaVencimiento;
        this.proveedor = proveedor;
        this.unidad = unidad;
        this.nroLote = nroLote;
        this.precio = precio;
        this.cant = cant;
        this.Stock = Stock;
        co = new Conexion();
        ps = null;
    }
    public boolean EntradaStock(){
        int as =0;
        try{
            ps = co.getConeccion().prepareCall("exec EntradaStock ?,? ");
            ps.setString(1, codigoProd);
            ps.setDouble(2, cant);
            as = ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("No se Ingreso la Cantidad");
            return false;
        }finally{}
    }
    
    public boolean SalidaStock(){
        int as =0;
        try{
            ps = co.getConeccion().prepareCall("exec SalidaStock ?,? ");
            ps.setString(1, codigoProd);
            ps.setDouble(2, cant);
            as = ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("No se Resto la Cantidad");
            return false;
        }finally{}
    }
    
    public boolean EntradaProducto(){
        int as =0;
        try{
            ps = co.getConeccion().prepareCall("exec EntradaProducto ?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
            ps.setString(1, tipoMovimiento);
            ps.setString(2, codigoProd);
            ps.setInt(3, tipoProducto);
            ps.setString(4, nomProducto);
            ps.setInt(5, anioMov);
            ps.setInt(6, mesMov);
            ps.setInt(7, diaMov);
            ps.setString (8, fechaVencimiento);
            ps.setString(9, proveedor);
            ps.setString(10, unidad);
            ps.setInt(11, nroLote);
            ps.setDouble(12, precio);
            ps.setDouble(13, cant);
            ps.setDouble(14, Stock);
            as=ps.executeUpdate();
            if (as>0){
             return true;   
            }else{
            return false;   
            }
            
            }catch (SQLException e){
                System.out.println("Error de Insersion de Datos "+e+as);
                return false;
            }
    }
    
    public double getStock(){
        return Stock;
    }
    public void setStock(double stock){
        this.Stock=stock;
    }
    public String getTipoMovimento(){
        return tipoMovimiento;
    }
    public void setTipoMovimento(String tipoMovimiento){
        this.tipoMovimiento=tipoMovimiento;
    }
    public String getCodigoProd() {
        return codigoProd;
    }
    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }
    public int getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getNomProducto() {
        return nomProducto;
    }
    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }
    public int getAnioMov(){
        return anioMov;
    }
    public void setAnioMov(int anioMov){
        this.anioMov = anioMov;
    }
    public int getMesMov() {
        return mesMov;
    }
    public void setMesMov(int mesMov) {
        this.mesMov = mesMov;
    }
    public int getDiaMov(){
        return diaMov;
    }
    public void setDiaMov(int diaMov){
        this.diaMov = diaMov;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getProveedor() {
        return proveedor;
    }
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public String getUnidad() {
        return unidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public int getNroLote() {
        return nroLote;
    }
    public void setNroLote(int nroLote) {
        this.nroLote = nroLote;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getCant() {
        return cant;
    }
    public void setCant(double cant) {
        this.cant = cant;
    }
    public String Informe(){
        return "CodigoProducto:\t"+codigoProd+
                "\nTipo Producto:\t\t"+tipoProducto+
                "\nNombre Producto:\t"+nomProducto+
                "\nCosto:\t\t"+precio+
                "\nAnio:\t\t"+anioMov+
                "\nMes:\t\t"+mesMov+
                "\nDia:\t\t"+diaMov+
                "\nTipo Movimineto:\t"+tipoMovimiento+
                "\nCantidad:\t\t"+cant+
                "\nUnidad:\t\t"+unidad+
                "\nFecha Vencimiento:\t"+fechaVencimiento+
                "\nN° Lote:\t\t"+nroLote+
                "\nProveedor:\t\t"+proveedor+
                "\nStock:\t\t"+Stock;
    }
    public double Stock(String TpoMovimiento,double cantidad){
        cant = cantidad;
        if(TpoMovimiento.equalsIgnoreCase("Entrada")){
            Stock= Stock + cant;
        }else if(TpoMovimiento.equalsIgnoreCase("Salida")){
            Stock= Stock - cant;
        }else{
            Stock=Stock+0;
        }
        return Stock;
    }
}