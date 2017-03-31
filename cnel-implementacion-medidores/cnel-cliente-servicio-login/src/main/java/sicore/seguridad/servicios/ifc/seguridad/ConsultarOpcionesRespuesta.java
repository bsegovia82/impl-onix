
package sicore.seguridad.servicios.ifc.seguridad;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.respuestas.Respuesta;
import bpe.cuentas.servicios.entidades.MenuIntranetBean;


/**
 * <p>Clase Java para consultarOpcionesRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarOpcionesRespuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://respuestas.servicios.common.bpe/}respuesta">
 *       &lt;sequence>
 *         &lt;element name="menuIntranetBean" type="{http://entidades.servicios.cuentas.bpe/}menuIntranetBean" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarOpcionesRespuesta", propOrder = {
    "menuIntranetBean"
})
public class ConsultarOpcionesRespuesta
    extends Respuesta
{

    @XmlElement(nillable = true)
    protected List<MenuIntranetBean> menuIntranetBean;

    /**
     * Gets the value of the menuIntranetBean property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuIntranetBean property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuIntranetBean().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuIntranetBean }
     * 
     * 
     */
    public List<MenuIntranetBean> getMenuIntranetBean() {
        if (menuIntranetBean == null) {
            menuIntranetBean = new ArrayList<MenuIntranetBean>();
        }
        return this.menuIntranetBean;
    }

}
