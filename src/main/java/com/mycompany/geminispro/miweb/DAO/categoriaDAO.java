/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geminispro.miweb.DAO;

import com.mycompany.geminispro.miweb.conexion.conexionDB;
import com.mycompany.geminispro.miweb.modelo.categoria;
import java.sql.*;
import java.util.*;
        
/**
 *
 * @author marko
 */
public class categoriaDAO {
    
    private Connection conexion=null;
    private PreparedStatement prest=null;
    private ResultSet res=null;
    
    public ArrayList<categoria> mostrar(){
        ArrayList<categoria> categorialista=new ArrayList<>();
        
        try{
            conexion=conexionDB.getConnection();
            prest=conexion.prepareStatement("select * from categoria");
            res=prest.executeQuery();
            
            while(res.next()){
                categoria ca=new categoria();
                ca.setId_categoria(res.getShort("id_categoria"));
                ca.setCategoria(res.getString("categoria"));
                categorialista.add(ca);
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
        return categorialista;
    }
}
