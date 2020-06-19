package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=bancodados;user=bancodados;password=banco123";
        
////////////////************* INSERTS *************/////////////
        
        String insertString1 = "INSERT INTO ator (id_ator, nome_ator) VALUES (?, ?)";
        String insertString2 = "INSERT INTO filme (id_filme, titulo_filme, id_ator_filme) VALUES (?, ?, ?)";
               
        try (
        		Connection con = DriverManager.getConnection(connectionUrl);
        		PreparedStatement stmt1 = con.prepareStatement(insertString1);
        		PreparedStatement stmt2 = con.prepareStatement(insertString2);
        	){
        	
        	Ator a1 = new Ator(5, "Jennifer Lawrence"); //sem filme
        	stmt1.setInt(1, a1.getId());
        	stmt1.setString(2, a1.getNome());
        	stmt1.executeUpdate();
        	
        	Ator a2 = new Ator(4, "Daniel Radcliffe");
        	stmt1.setInt(1, a2.getId());
        	stmt1.setString(2, a2.getNome());
        	stmt1.executeUpdate();
        	
        	Filme f1 = new Filme(4, "Harry Potter", 4);
        	stmt2.setInt(1, f1.getId());
        	stmt2.setString(2, f1.getTitulo());
        	stmt2.setInt(3, f1.getIdAtor());
        	stmt2.executeUpdate();
        	
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
                
////////////////************* FIM INSERTS *************///////////////
        
////////////////************* SELECT GERAL (JOIN)*************/////////////

        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt1 = con.createStatement();
        		
        	){
        	        	
            String AtorFilmeSQL = "SELECT * FROM filme f FULL OUTER JOIN ator a ON f.id_ator_filme = a.id_ator";
            
            ResultSet result1 = stmt1.executeQuery(AtorFilmeSQL);          
            
            System.out.println("\n********* Tabela Ator e Filme ******");
            
            while (result1.next()) {
            	
            	 filme_X_ator af = new filme_X_ator();
            	            	
            	af.setId(result1.getInt("id_ator"));
            	af.setNome(result1.getString("nome_ator"));
            	af.setId1(result1.getInt("id_filme"));
            	af.setTitulo(result1.getString("titulo_filme"));
            	af.setIdAtor(result1.getInt("id_ator_filme"));
            	
            	System.out.println(af);
            
            }
            
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        
////////////////************* FIM SELECT GERAL (JOIN)*************/////////////
        
////////////////************* UPDATES *************//////////////////////
        
        String updateString = "UPDATE ator SET nome_ator = ? WHERE id_ator=?";
        
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement stmt = con.prepareStatement(updateString);
        	){
        	
        	Ator ator1 = new Ator(1, "Johnny Depp - updated");
        	stmt.setString(1, ator1.getNome());
        	stmt.setInt(2, ator1.getId());	
        	
        	stmt.executeUpdate();
        	
        	System.out.println("\n----> Dados da tabela Ator alterados!\n");
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
////////////////************* FIM UPDATES *************///////////////////
        
////////////////************* DELETES *************///////////////////
        
        String deleteString1 = "DELETE ator WHERE id_ator=?";
        String deleteString2 = "DELETE filme WHERE id_filme=?";
        
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement stmt = con.prepareStatement(deleteString1);
        		PreparedStatement stmt2 = con.prepareStatement(deleteString2);
        	) {
        	
        	int atorID1 = 6;
        	stmt.setInt(1, atorID1);
        	stmt.executeUpdate();
        	
        	int filmeID = 1;
        	stmt2.setInt(1, filmeID);
        	stmt2.executeUpdate();
        	
        	int atorID2 = 3;
        	stmt.setInt(1, atorID2);
        	stmt.executeUpdate();
        	
        	System.out.println("----> Dados da tabela Ator removidos!");
        	System.out.println("----> Dados da tabela Filme removidos!");
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
////////////////************* FIM DELETES *************///////////////////////////

////////////////************* SELECTS CONFERENCIA *************///////////////////
        
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt1 = con.createStatement();
        		Statement stmt2 = con.createStatement();
        	){
        	
            String AtorSQL = "SELECT * FROM ator";
            String FilmeSQL = "SELECT * FROM filme";
            
            ResultSet result1 = stmt1.executeQuery(AtorSQL);
            ResultSet result2 = stmt2.executeQuery(FilmeSQL);
            
            System.out.println("\n******* Tabela Ator (Depois) ******");

            while (result1.next()) {
            	Ator at = new Ator();
            	at.setId(result1.getInt("id_ator"));
            	at.setNome(result1.getString("nome_ator"));

            	System.out.println(at);
            }
            
            System.out.println("\n******* Tabela Filme (Depois)******");
            
            while (result2.next()) {
            	
            	Filme fi = new Filme();
            	
            	fi.setId(result2.getInt("id_filme"));
            	fi.setTitulo(result2.getString("titulo_filme"));
            	fi.setIdAtor(result2.getInt("id_ator_filme"));
            	            	
            	System.out.println(fi);
            	
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        
////////////////************* FIM SELECTS CONFERENCIA *************///////////////////

	}

}
