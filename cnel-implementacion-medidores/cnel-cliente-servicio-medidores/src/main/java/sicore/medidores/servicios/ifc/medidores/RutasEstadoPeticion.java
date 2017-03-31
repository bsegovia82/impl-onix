
package sicore.medidores.servicios.ifc.medidores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para rutasEstadoPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rutasEstadoPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="rutasEstado" type="{http://medidores.ifc.servicios.medidores.sicore/}rutasEstado" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rutasEstadoPeticion", propOrder = {
    "rutasEstado"
})
public class RutasEstadoPeticion
    extends Peticion
{

    @XmlElement(nillable = true)
    protected List<RutasEstado> rutasEstado;

    /**
     * Gets the value of the rutasEstado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rutasEstado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRutasEstado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RutasEstado }
     * 
     * 
     */
    public List<RutasEstado> getRutasEstado() {
        if (rutasEstado == null) {
            rutasEstado = new ArrayList<RutasEstado>();
        }
        return this.rutasEstado;
    }

}
