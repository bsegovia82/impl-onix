
package sicore.cortes.servicios.ifc.cortes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;
import bpe.cuentas.servicios.entidades.BeanFileCorte;


/**
 * <p>Clase Java para consultarDetalleOrdenesRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarDetalleOrdenesRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="cortes" type="{http://entidades.servicios.cuentas.bpe/}beanFileCorte" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarDetalleOrdenesRespuesta", propOrder = {
    "cortes"
})
public class ConsultarDetalleOrdenesRespuesta
    extends Respuesta
{

    @XmlElement(nillable = true)
    protected List<BeanFileCorte> cortes;

    /**
     * Gets the value of the cortes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cortes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCortes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanFileCorte }
     * 
     * 
     */
    public List<BeanFileCorte> getCortes() {
        if (cortes == null) {
            cortes = new ArrayList<BeanFileCorte>();
        }
        return this.cortes;
    }

}
