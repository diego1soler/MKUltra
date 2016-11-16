
import java.io.File;

import java.util.HashSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.factory.*;


/**
 * @author Diego Soler, Fredy Espana, Rodolfo Cacacho
 * Proyecto 2 Fase 2. Funciones de la base de datos
 * Clase que maneja la base de datos basada en grafos en Neo4J
 * @version 16/11/2016
 */



public class DbFunctions {
   
private GraphDatabaseService graphDb;
private Vector<String> artistas;
private Vector<String> artistas2;


      
    public void Conectar(){
    	
    	//Conexion a la base de datos
         File rute = new File ("C:\\Users\\Diego\\Documents\\Neo4j\\MusicDB");
    	 graphDb= new GraphDatabaseFactory().newEmbeddedDatabase( rute );
         registerShutdownHook(graphDb);
         artistas2 = new Vector();
         
		 
    }
    
    //Tipos de nodos de la base de datos
    public enum NodeType implements Label{
        Song,Genre;
    }
    
    //Tipos de relaciones en la base de datos 
    public enum RelationType implements RelationshipType{
        Belongs,Related;
    }
    
   
    private static void registerShutdownHook (final GraphDatabaseService graphDb){
    	Runtime.getRuntime().addShutdownHook(new Thread()
    			{
    		
    				@Override
    				public void run(){
    					graphDb.shutdown();
    				}
    			}
    			
    			
    			);
    	
    }
    
    
    //Metodo para obtener los generos
    public Vector getGenero(){
    	
    	Conectar();
    	Vector<String> nombres = new Vector(); //Vector temporal
    	  try (Transaction tx = graphDb.beginTx()) {
         	 
         	 ResourceIterator<Node> canciones = graphDb.findNodes(NodeType.Genre); //Se obtienen los nodos de los generos
              
              while(canciones.hasNext()){
                  Node cancion = canciones.next();
                  nombres.add((String)cancion.getProperty("Name")); //Se obtiene solo el nombre
                  
              }	
              
      		tx.success();
      	}
    	  return nombres;
    }
    
public Vector getCanciones(String genero){
	
		artistas = new Vector();
		artistas.clear();
    	Vector<String> names = new Vector();
    	try (Transaction tx = graphDb.beginTx()) {
    		
        	ResourceIterator<Node> genres = graphDb.findNodes(NodeType.Genre); //Se obtienen los nodos de genero
        	Iterable<Relationship> relation;
    		while (genres.hasNext()){
    		 Node genre = genres.next();
    		 if(genre.getProperty("Name").equals(genero)){ //Se manejan solo los que sean del genero que solicita el usuario
    			 for( Relationship relationship : genre.getRelationships( Direction.INCOMING, //Se especifican las relaciones necesarias para obtener los nodos de las canciones
    				     RelationType.Belongs ) ){
    				 names.add( ( String )relationship.getOtherNode( genre) //Se agregan al vector temporal de nombres y de artistas
    	                        .getProperty( "Name" ) );
    				 artistas.add(( String )relationship.getOtherNode( genre)
    	                        .getProperty( "Artist" ) );
    			 }
    			
    		 }
    		 
    		
    		} 
              
              
      		tx.success();
      	}
    	return names;
}

//Se retornan los artistas
public Vector <String> getArtistas(){
	
	
	return artistas;
}

//Se retornan los artistas recomendados
public Vector <String> getArtistas2(){
	
	
	return artistas2;
}


//Metodo para obtener las recomendadas
public Vector <String> getRecomendadas(String song){
	
	
	//SUCEDE EXACTAMENTE LO MISMO QUE EN EL GET CANCIONES, solo se modifica el tipo de relacion y nodo entre las canciones
	artistas2 = new Vector();
	artistas2.clear();
	Vector<String> names = new Vector();
	try (Transaction tx = graphDb.beginTx()) {
		
    	ResourceIterator<Node> songs = graphDb.findNodes(NodeType.Song);
    	
		while (songs.hasNext()){
		 Node songTemp = songs.next();
		  if(songTemp.getProperty("Name").equals(song)){
			 for( Relationship relationship :songTemp.getRelationships(Direction.OUTGOING,RelationType.Related)){
				 names.add( ( String )relationship.getOtherNode(songTemp)
	                        .getProperty( "Name" ) );
				 
				 artistas2.add(( String )relationship.getOtherNode(songTemp)
	                        .getProperty( "Artist" ) );
				 
			 }
			
		 }
		 
		
		} 
          
          
  		tx.success();
  	}
	
	return names;
}




 } 
    
 
