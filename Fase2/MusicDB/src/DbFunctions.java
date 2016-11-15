
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

public class DbFunctions {
   
private GraphDatabaseService graphDb;
private Vector<String> artistas;


      
    public void Conectar(){
    	
        File rute = new File ("C:\\Users\\Diego\\Documents\\Neo4j\\MusicDB");
    	 graphDb= new GraphDatabaseFactory().newEmbeddedDatabase( rute );
         registerShutdownHook(graphDb);
         
		 
    }
    
    public enum NodeType implements Label{
        Song,Genre;
    }
    
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
    
    public Vector getGenero(){
    	
    	Conectar();
    	Vector<String> nombres = new Vector();
    	  try (Transaction tx = graphDb.beginTx()) {
         	 
         	 ResourceIterator<Node> canciones = graphDb.findNodes(NodeType.Genre);
              
              while(canciones.hasNext()){
                  Node cancion = canciones.next();
                  nombres.add((String)cancion.getProperty("Name"));
                  
              }	
              
      		tx.success();
      	}
    	  return nombres;
    }
    
public Vector getCanciones(String genero){
	
		artistas = new Vector();
		artistas.clear();
    	Vector<String> names = new Vector();
    	//Node genre =graphDb.findNode(NodeType.Genre,"Name",genero);
    	try (Transaction tx = graphDb.beginTx()) {
    		
        	ResourceIterator<Node> genres = graphDb.findNodes(NodeType.Genre);
        	Iterable<Relationship> relation;
    		while (genres.hasNext()){
    		 Node genre = genres.next();
    		 if(genre.getProperty("Name").equals(genero)){
    			 for( Relationship relationship : genre.getRelationships( Direction.INCOMING,
    				     RelationType.Belongs ) ){
    				 names.add( ( String )relationship.getOtherNode( genre)
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

public Vector <String> getArtistas(){
	
	
	return artistas;
}




 } 
    
 
