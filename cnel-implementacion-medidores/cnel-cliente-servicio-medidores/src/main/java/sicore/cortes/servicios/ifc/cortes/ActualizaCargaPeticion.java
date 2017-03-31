
package sicore.cortes.servicios.ifc.cortes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para actualizaCargaPeticion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizaCargaPeticion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://peticiones.servicios.common.bpe/}peticion">
 *       &lt;sequence>
 *         &lt;element name="codigoContratista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0" form="unqualified"/>
 *         &lt;element name="secuenciaDescarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="tipoOrden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="unidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizaCargaPeticion", propOrder = {
    "codigoContratista",
    "idOrden",
    "secuenciaDescarga",
    "tipo",
    "tipoOrden",
    "unidad"
})
public class ActualizaCargaPeticion
    extends Peticion
{

    protected String codigoContratista;
    protected BigDecimal idOrden;
    protected String secuenciaDescarga;
    protected String tipo;
    protected String tipoOrden;
    protected String unidad;

    /**
     * Obtiene el valor de la propiedad codigoContratista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoContratista() {
        return codigoContratista;
    }

    /**
     * Define el valor de la propiedad codigoContratista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoContratista(String value) {
        this.codigoContratista = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdOrden(BigDecimal value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad secuenciaDescarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuenciaDescarga() {
        return secuenciaDescarga;
    }

    /**
     * Define el valor de la propiedad secuenciaDescarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuenciaDescarga(String value) {
        this.secuenciaDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
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

    /**
     * Obtiene el valor de la propiedad unidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Define el valor de la propiedad unidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidad(String value) {
        this.unidad = value;
    }

}
