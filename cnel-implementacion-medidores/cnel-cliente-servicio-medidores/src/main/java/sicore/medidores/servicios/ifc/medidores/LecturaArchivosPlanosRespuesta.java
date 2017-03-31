
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;
import bpe.cuentas.servicios.entidades.ObjetosArchivosPlanos;


/**
 * <p>Clase Java para lecturaArchivosPlanosRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lecturaArchivosPlanosRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="cantidadError" type="{http://www.w3.org/2001/XMLSchema}long" form="unqualified"/>
 *         &lt;element name="objetosArchivosPlanos" type="{http://entidades.servicios.cuentas.bpe/}objetosArchivosPlanos" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lecturaArchivosPlanosRespuesta", propOrder = {
    "cantidadError",
    "objetosArchivosPlanos"
})
public class LecturaArchivosPlanosRespuesta
    extends Respuesta
{

    protected long cantidadError;
    @XmlElement(nillable = true)
    protected List<ObjetosArchivosPlanos> objetosArchivosPlanos;

    /**
     * Obtiene el valor de la propiedad cantidadError.
     * 
     */
    public long getCantidadError() {
        return cantidadError;
    }

    /**
     * Define el valor de la propiedad cantidadError.
     * 
     */
    public void setCantidadError(long value) {
        this.cantidadError = value;
    }

    /**
     * Gets the value of the objetosArchivosPlanos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objetosArchivosPlanos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjetosArchivosPlanos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjetosArchivosPlanos }
     * 
     * 
     */
    public List<ObjetosArchivosPlanos> getObjetosArchivosPlanos() {
        if (objetosArchivosPlanos == null) {
            objetosArchivosPlanos = new ArrayList<ObjetosArchivosPlanos>();
        }
        return this.objetosArchivosPlanos;
    }

}
