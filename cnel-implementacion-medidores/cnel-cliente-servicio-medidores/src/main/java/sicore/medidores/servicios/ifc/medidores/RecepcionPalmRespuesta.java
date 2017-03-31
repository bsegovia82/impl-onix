
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;


/**
 * <p>Clase Java para recepcionPalmRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="recepcionPalmRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="_recepcionPalm" type="{http://medidores.ifc.servicios.medidores.sicore/}recepcionPalm" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionPalmRespuesta", propOrder = {
    "recepcionPalm"
})
public class RecepcionPalmRespuesta
    extends Respuesta
{

    @XmlElement(name = "_recepcionPalm", nillable = true)
    protected List<RecepcionPalm> recepcionPalm;

    /**
     * Gets the value of the recepcionPalm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recepcionPalm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecepcionPalm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecepcionPalm }
     * 
     * 
     */
    public List<RecepcionPalm> getRecepcionPalm() {
        if (recepcionPalm == null) {
            recepcionPalm = new ArrayList<RecepcionPalm>();
        }
        return this.recepcionPalm;
    }

}
