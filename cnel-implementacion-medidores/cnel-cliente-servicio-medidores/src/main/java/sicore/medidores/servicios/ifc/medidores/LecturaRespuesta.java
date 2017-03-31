
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;


/**
 * <p>Clase Java para lecturaRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lecturaRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="lectura" type="{http://medidores.ifc.servicios.medidores.sicore/}lectura" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lecturaRespuesta", propOrder = {
    "lectura"
})
public class LecturaRespuesta
    extends Respuesta
{

    @XmlElement(nillable = true)
    protected List<Lectura> lectura;

    /**
     * Gets the value of the lectura property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lectura property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLectura().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lectura }
     * 
     * 
     */
    public List<Lectura> getLectura() {
        if (lectura == null) {
            lectura = new ArrayList<Lectura>();
        }
        return this.lectura;
    }

}
