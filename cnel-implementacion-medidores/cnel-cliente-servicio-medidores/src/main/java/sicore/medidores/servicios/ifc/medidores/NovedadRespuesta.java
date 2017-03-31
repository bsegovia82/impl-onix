
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;
import bpe.cuentas.servicios.entidades.Novedad;


/**
 * <p>Clase Java para novedadRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="novedadRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="novedades" type="{http://entidades.servicios.cuentas.bpe/}novedad" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "novedadRespuesta", propOrder = {
    "novedades"
})
public class NovedadRespuesta
    extends Respuesta
{

    @XmlElement(nillable = true)
    protected List<Novedad> novedades;

    /**
     * Gets the value of the novedades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the novedades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNovedades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Novedad }
     * 
     * 
     */
    public List<Novedad> getNovedades() {
        if (novedades == null) {
            novedades = new ArrayList<Novedad>();
        }
        return this.novedades;
    }

}
