
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para recepcionSobrantesPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="recepcionSobrantesPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="_recepcionSobrantes" type="{http://medidores.ifc.servicios.medidores.sicore/}recepcionSobrantes" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionSobrantesPeticion", propOrder = {
    "recepcionSobrantes"
})
public class RecepcionSobrantesPeticion
    extends Peticion
{

    @XmlElement(name = "_recepcionSobrantes", nillable = true)
    protected List<RecepcionSobrantes> recepcionSobrantes;

    /**
     * Gets the value of the recepcionSobrantes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recepcionSobrantes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecepcionSobrantes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecepcionSobrantes }
     * 
     * 
     */
    public List<RecepcionSobrantes> getRecepcionSobrantes() {
        if (recepcionSobrantes == null) {
            recepcionSobrantes = new ArrayList<RecepcionSobrantes>();
        }
        return this.recepcionSobrantes;
    }

}
