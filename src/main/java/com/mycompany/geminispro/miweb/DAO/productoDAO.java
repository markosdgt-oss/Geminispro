/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geminispro.miweb.DAO;

import com.mycompany.geminispro.miweb.conexion.conexionDB;
import com.mycompany.geminispro.miweb.modelo.producto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author marko
 */
public class productoDAO {
    
    private Connection conexion=null;
    private PreparedStatement prest=null;
    private ResultSet res=null;
    
    public ArrayList<producto> mostrar(){
        ArrayList<producto> productolista=new ArrayList<>();
        
        try{
            conexion=conexionDB.getConnection();
            prest=conexion.prepareStatement("select * from producto");
            res=prest.executeQuery();
            
            while(res.next()){
                producto pr=new producto();
                pr.setId_producto(res.getShort("id_producto"));
                pr.setId_categoria(res.getString("id_categoria"));
                pr.setProducto_nombre(res.getString("producto_nombre"));
                pr.setValor_unitario(res.getFloat("valor_unitrio"));
                pr.setExistencia(res.getShort("existencia"));
                productolista.add(pr);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        finally{
            try{
                if (conexion!=null){
                }
                if (prest!=null){
                    prest.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }          
        }
        return productolista;
    }
    
}
