
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para lecturaArchivosPlanosPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lecturaArchivosPlanosPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="tipoArchivo" type="{http://medidores.ifc.servicios.medidores.sicore/}tipoArchivo" form="unqualified"/>
 *         &lt;element name="tipoSistemaCNEL" type="{http://medidores.ifc.servicios.medidores.sicore/}tipoSistemaCNEL" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lecturaArchivosPlanosPeticion", propOrder = {
    "estado",
    "extension",
    "nombre",
    "tipoArchivo",
    "tipoSistemaCNEL"
})
public class LecturaArchivosPlanosPeticion
    extends Peticion
{

    protected String estado;
    protected String extension;
    protected String nombre;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoArchivo tipoArchivo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoSistemaCNEL tipoSistemaCNEL;

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoArchivo.
     * 
     * @return
     *     possible object is
     *     {@link TipoArchivo }
     *     
     */
    public TipoArchivo getTipoArchivo() {
        return tipoArchivo;
    }

    /**
     * Define el valor de la propiedad tipoArchivo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoArchivo }
     *     
     */
    public void setTipoArchivo(TipoArchivo value) {
        this.tipoArchivo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoSistemaCNEL.
     * 
     * @return
     *     possible object is
     *     {@link TipoSistemaCNEL }
     *     
     */
    public TipoSistemaCNEL getTipoSistemaCNEL() {
        return tipoSistemaCNEL;
    }

    /**
     * Define el valor de la propiedad tipoSistemaCNEL.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoSistemaCNEL }
     *     
     */
    public void setTipoSistemaCNEL(TipoSistemaCNEL value) {
        this.tipoSistemaCNEL = value;
    }

}
