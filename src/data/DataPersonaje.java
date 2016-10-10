package data;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.*;
import utils.ApplicationException;

public class DataPersonaje {
	
	
	public DataPersonaje(){
		
	}
	
	public boolean verificarNombre(Personaje per){
		boolean valido=true;
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre "
					+ "from personajes"
					+ " where nombre=?");
			stmt.setString(1, per.getNombre().trim());
			rs= stmt.executeQuery();			
			if(rs.next()){
				valido=false;
			}
			
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valido;
	}
	
	public void add(Personaje p) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nombre, energia, defensa, ataque, evasion, puntosTotales)"+
					" values(?,?,?,?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
			
			
			
			stmt.setString(1, p.getNombre().trim());
			stmt.setFloat(2, p.getEnergia());
			stmt.setFloat(3, p.getDefensa());
			stmt.setInt(4, p.getAtaque());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void update(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update personajes set nombre=?, energia=?, defensa=?, ataque=?, evasion=?, puntosTotales=?"+
					" where id=?");
			
			stmt.setString(1, p.getNombre());
			stmt.setFloat(2, p.getEnergia());
			stmt.setFloat(3, p.getDefensa());
			stmt.setInt(4, p.getAtaque());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.setInt(7, p.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void acreditarPuntos(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update personajes set puntosTotales=?"+
					" where id=?");
			
			
			stmt.setInt(1, p.getPuntosTotales()+10);
			stmt.setInt(2, p.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from personajes where id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public ArrayList<String> getPersonajes(){

		ArrayList<String> nombres = new ArrayList<String>();
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre"
					+ " from personajes");
			rs= stmt.executeQuery();
			
			while(rs!=null && rs.next()){
				nombres.add(rs.getString("nombre"));				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return nombres;
	}
	
	
	public Personaje getById(Personaje per){
		Personaje p=null;
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, energia, defensa, ataque, evasion, puntosTotales "
					+ "from personajes"
					+ " where id=?");
			stmt.setInt(1, per.getId());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setEnergia(rs.getFloat("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setAtaque(rs.getInt("ataque"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("puntosTotales"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public Personaje getByNom(String nom){
		Personaje p=null;
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, energia, defensa, ataque, evasion, puntosTotales "
					+ "from personajes"
					+ " where nombre=?");
			stmt.setString(1, nom);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setEnergia(rs.getFloat("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setAtaque(rs.getInt("ataque"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("puntosTotales"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	
}