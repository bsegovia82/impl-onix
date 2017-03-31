
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para consultarRutasEstadoPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarRutasEstadoPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="_rutasEstado" type="{http://medidores.ifc.servicios.medidores.sicore/}rutasEstado" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarRutasEstadoPeticion", propOrder = {
    "rutasEstado"
})
public class ConsultarRutasEstadoPeticion
    extends Peticion
{

    @XmlElement(name = "_rutasEstado")
    protected RutasEstado rutasEstado;

    /**
     * Obtiene el valor de la propiedad rutasEstado.
     * 
     * @return
     *     possible object is
     *     {@link RutasEstado }
     *     
     */
    public RutasEstado getRutasEstado() {
        return rutasEstado;
    }

    /**
     * Define el valor de la propiedad rutasEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link RutasEstado }
     *     
     */
    public void setRutasEstado(RutasEstado value) {
        this.rutasEstado = value;
    }

}
