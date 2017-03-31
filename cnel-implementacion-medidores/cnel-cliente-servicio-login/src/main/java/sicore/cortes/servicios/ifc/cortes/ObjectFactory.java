
package sicore.cortes.servicios.ifc.cortes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sicore.cortes.servicios.ifc.cortes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sicore.cortes.servicios.ifc.cortes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetalleOrdenesPeticion }
     * 
     */
    public DetalleOrdenesPeticion createDetalleOrdenesPeticion() {
        return new DetalleOrdenesPeticion();
    }

    /**
     * Create an instance of {@link ActualizaCargaPeticion }
     * 
     */
    public ActualizaCargaPeticion createActualizaCargaPeticion() {
        return new ActualizaCargaPeticion();
    }

    /**
     * Create an instance of {@link InsertarUnidadPeticion }
     * 
     */
    public InsertarUnidadPeticion createInsertarUnidadPeticion() {
        return new InsertarUnidadPeticion();
    }

    /**
     * Create an instance of {@link ConsultarDetalleOrdenesRespuesta }
     * 
     */
    public ConsultarDetalleOrdenesRespuesta createConsultarDetalleOrdenesRespuesta() {
        return new ConsultarDetalleOrdenesRespuesta();
    }

}
