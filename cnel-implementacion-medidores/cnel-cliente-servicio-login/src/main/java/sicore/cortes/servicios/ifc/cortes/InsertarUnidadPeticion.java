
package sicore.cortes.servicios.ifc.cortes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;
import bpe.cuentas.servicios.entidades.BeanEjecutor;


/**
 * <p>Clase Java para insertarUnidadPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarUnidadPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="unidades" type="{http://entidades.servicios.cuentas.bpe/}beanEjecutor" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarUnidadPeticion", propOrder = {
    "unidades"
})
public class InsertarUnidadPeticion
    extends Peticion
{

    @XmlElement(nillable = true)
    protected List<BeanEjecutor> unidades;

    /**
     * Gets the value of the unidades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unidades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnidades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanEjecutor }
     * 
     * 
     */
    public List<BeanEjecutor> getUnidades() {
        if (unidades == null) {
            unidades = new ArrayList<BeanEjecutor>();
        }
        return this.unidades;
    }

}
