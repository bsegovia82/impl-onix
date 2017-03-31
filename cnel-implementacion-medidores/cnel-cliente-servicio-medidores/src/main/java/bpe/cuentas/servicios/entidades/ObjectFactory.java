
package bpe.cuentas.servicios.entidades;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bpe.cuentas.servicios.entidades package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bpe.cuentas.servicios.entidades
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Novedad }
     * 
     */
    public Novedad createNovedad() {
        return new Novedad();
    }

    /**
     * Create an instance of {@link BeanEjecutor }
     * 
     */
    public BeanEjecutor createBeanEjecutor() {
        return new BeanEjecutor();
    }

    /**
     * Create an instance of {@link ObjetosArchivosPlanos }
     * 
     */
    public ObjetosArchivosPlanos createObjetosArchivosPlanos() {
        return new ObjetosArchivosPlanos();
    }

    /**
     * Create an instance of {@link BeanFileCorte }
     * 
     */
    public BeanFileCorte createBeanFileCorte() {
        return new BeanFileCorte();
    }

}
