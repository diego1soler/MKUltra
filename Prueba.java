package Fase2;
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
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
/**
 *
 * @author JuanPablo
 */
public class Prueba {
    private static final String MainPath = "C:\\Users\\Diego\\Documents\\Neo4j\\MusicDB";


      
    public GraphDatabaseService Conectar(){
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDb = dbFactory.newEmbeddedDatabase(new File(MainPath));
        return graphDb;
    }
    
    public enum NodeType implements Label{
        Song;
    }
    
    public enum RelationType implements RelationshipType{
        RELATED_TO;
    }
    
    
    
  
    public void Eliminar(String nombre){
        GraphDatabaseService db = Conectar();
        try(Transaction tx = db.beginTx()){
            db.execute("MATCH (n {nombre: '"+nombre+"'}) DELETE n");
            tx.success();
        }
        
    }
    
    public Vector getCanciones(){
        GraphDatabaseService db = Conectar();
        ResourceIterator<Node> canciones = db.findNodes(NodeType.Song);
        Vector<String> nombres = new Vector();
        while(canciones.hasNext()){
            Node cancion = canciones.next();
            nombres.add((String)cancion.getProperty("name"));
        }
        return nombres;
    }
    
   public Vector RetrieveInstituciones(){
        GraphDatabaseService db = Conectar();
        ResourceIterator<Node> instituciones = db.findNodes(NodeType.Institucion);
        Vector<String> nombres = new Vector();
        while(instituciones.hasNext()){
            Node persona = instituciones.next();
            nombres.add((String)persona.getProperty("nombre"));
        }
        return nombres;
    }
    
    public Vector Recomendar(String profesion){
        GraphDatabaseService db = Conectar();
        Node empresa = db.findNode(NodeType.Institucion, "nombre", this.nombreEmpresa);
        //Encontrar todas las personas que contrato la empresa
        Vector<Node> personasVector = new Vector<Node>();
        ResourceIterator<Node> personas = db.findNodes(NodeType.Persona);
        Vector<String> nombres = new Vector();
        while(personas.hasNext()){
            Node persona = personas.next();
            if (persona.getSingleRelationship(RelationType.CONTRATO_A,Direction.INCOMING).getType()!=RelationType.CONTRATO_A){
                if( ((String)persona.getProperty("profesion")).equalsIgnoreCase(profesion)){
                    personasVector.add(persona);   
                }
            }
        }
        return personasVector;
    }
    public Vector Recomendar(String profesion, String localizacion){
        GraphDatabaseService db = Conectar();
        Node empresa = db.findNode(NodeType.Institucion, "nombre", this.nombreEmpresa);
        //Encontrar todas las personas que contrato la empresa
        Vector<Node> personasVector = new Vector<Node>();
        ResourceIterator<Node> personas = db.findNodes(NodeType.Persona);
        Vector<String> nombres = new Vector();
        while(personas.hasNext()){
            Node persona = personas.next();
            if (persona.getSingleRelationship(RelationType.CONTRATO_A,Direction.INCOMING).getType()!=RelationType.CONTRATO_A){
                if( ((String)persona.getProperty("profesion")).equalsIgnoreCase(profesion)&&((String)persona.getProperty("localizacion")).equalsIgnoreCase(localizacion)){
                    personasVector.add(persona);   
                }
            }
        }
        return personasVector;
    }
}