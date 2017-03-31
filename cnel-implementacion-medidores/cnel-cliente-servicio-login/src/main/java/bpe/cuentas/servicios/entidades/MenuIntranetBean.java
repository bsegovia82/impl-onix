
package bpe.cuentas.servicios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para menuIntranetBean complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="menuIntranetBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opcinesId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="opcionesDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcionesImagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcionesNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcionesPadre" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="opcionesRuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcionesSubmenu" type="{http://entidades.servicios.cuentas.bpe/}menuIntranetBean" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="opciones_self" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opciones_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opcionescam_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menuIntranetBean", propOrder = {
    "opcinesId",
    "opcionesDescripcion",
    "opcionesImagen",
    "opcionesNombre",
    "opcionesPadre",
    "opcionesRuta",
    "opcionesSubmenu",
    "opcionesSelf",
    "opcionesUrl",
    "opcionescamUrl"
})
public class MenuIntranetBean {

    protected BigDecimal opcinesId;
    protected String opcionesDescripcion;
    protected String opcionesImagen;
    protected String opcionesNombre;
    protected BigDecimal opcionesPadre;
    protected String opcionesRuta;
    @XmlElement(nillable = true)
    protected List<MenuIntranetBean> opcionesSubmenu;
    @XmlElement(name = "opciones_self")
    protected String opcionesSelf;
    @XmlElement(name = "opciones_url")
    protected String opcionesUrl;
    @XmlElement(name = "opcionescam_url")
    protected String opcionescamUrl;

    /**
     * Obtiene el valor de la propiedad opcinesId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpcinesId() {
        return opcinesId;
    }

    /**
     * Define el valor de la propiedad opcinesId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpcinesId(BigDecimal value) {
        this.opcinesId = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesDescripcion() {
        return opcionesDescripcion;
    }

    /**
     * Define el valor de la propiedad opcionesDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesDescripcion(String value) {
        this.opcionesDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesImagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesImagen() {
        return opcionesImagen;
    }

    /**
     * Define el valor de la propiedad opcionesImagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesImagen(String value) {
        this.opcionesImagen = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesNombre() {
        return opcionesNombre;
    }

    /**
     * Define el valor de la propiedad opcionesNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesNombre(String value) {
        this.opcionesNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesPadre.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpcionesPadre() {
        return opcionesPadre;
    }

    /**
     * Define el valor de la propiedad opcionesPadre.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpcionesPadre(BigDecimal value) {
        this.opcionesPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesRuta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesRuta() {
        return opcionesRuta;
    }

    /**
     * Define el valor de la propiedad opcionesRuta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesRuta(String value) {
        this.opcionesRuta = value;
    }

    /**
     * Gets the value of the opcionesSubmenu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opcionesSubmenu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpcionesSubmenu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuIntranetBean }
     * 
     * 
     */
    public List<MenuIntranetBean> getOpcionesSubmenu() {
        if (opcionesSubmenu == null) {
            opcionesSubmenu = new ArrayList<MenuIntranetBean>();
        }
        return this.opcionesSubmenu;
    }

    /**
     * Obtiene el valor de la propiedad opcionesSelf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesSelf() {
        return opcionesSelf;
    }

    /**
     * Define el valor de la propiedad opcionesSelf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesSelf(String value) {
        this.opcionesSelf = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionesUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionesUrl() {
        return opcionesUrl;
    }

    /**
     * Define el valor de la propiedad opcionesUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionesUrl(String value) {
        this.opcionesUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad opcionescamUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcionescamUrl() {
        return opcionescamUrl;
    }

    /**
     * Define el valor de la propiedad opcionescamUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcionescamUrl(String value) {
        this.opcionescamUrl = value;
    }

}
