package modelo;

import java.sql.*;
import java.util.*;

public class PerfilDAO {

    public List<Perfil> listar(){

        List<Perfil> lista=new ArrayList<>();

        String sql="SELECT * FROM perfil";

        try{

            Connection con=ConexionDAO.getConexion();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Perfil p=new Perfil();

                p.setPerCodigo(rs.getInt("perCodigo"));
                p.setPerNombre(rs.getString("perNombre"));
                p.setPerEstado(rs.getString("perEstado"));

                lista.add(p);
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return lista;
    }
}