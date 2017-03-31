
package sicore.cortes.servicios.ifc.cortes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;
import bpe.cuentas.servicios.entidades.BeanFileCorte;


/**
 * <p>Clase Java para detalleOrdenesPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalleOrdenesPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="cortes" type="{http://entidades.servicios.cuentas.bpe/}beanFileCorte" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="tipoOrden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleOrdenesPeticion", propOrder = {
    "cortes",
    "idOrden",
    "tipoOrden"
})
public class DetalleOrdenesPeticion
    extends Peticion
{

    @XmlElement(nillable = true)
    protected List<BeanFileCorte> cortes;
    protected int idOrden;
    protected String tipoOrden;

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

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     */
    public void setIdOrden(int value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoOrden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOrden() {
        return tipoOrden;
    }

    /**
     * Define el valor de la propiedad tipoOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOrden(String value) {
        this.tipoOrden = value;
    }

}
