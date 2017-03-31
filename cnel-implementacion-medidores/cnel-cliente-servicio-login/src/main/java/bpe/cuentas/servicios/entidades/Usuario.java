
package bpe.cuentas.servicios.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para usuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoContratista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userFecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ilimitado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ejecutor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enLinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaIniArchivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuario", propOrder = {
    "codigoContratista",
    "userApellido",
    "userClave",
    "userEmail",
    "userEstado",
    "userFecha",
    "userId",
    "userNombre",
    "userUsuario",
    "fechaHasta",
    "ilimitado",
    "ejecutor",
    "enLinea",
    "fechaIniArchivo"
})
public class Usuario {

    protected String codigoContratista;
    protected String userApellido;
    protected String userClave;
    protected String userEmail;
    protected String userEstado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar userFecha;
    protected int userId;
    protected String userNombre;
    protected String userUsuario;
    protected String fechaHasta;
    protected String ilimitado;
    protected String ejecutor;
    protected String enLinea;
    protected String fechaIniArchivo;

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
     * Obtiene el valor de la propiedad userApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserApellido() {
        return userApellido;
    }

    /**
     * Define el valor de la propiedad userApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserApellido(String value) {
        this.userApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad userClave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserClave() {
        return userClave;
    }

    /**
     * Define el valor de la propiedad userClave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserClave(String value) {
        this.userClave = value;
    }

    /**
     * Obtiene el valor de la propiedad userEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Define el valor de la propiedad userEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserEmail(String value) {
        this.userEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad userEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserEstado() {
        return userEstado;
    }

    /**
     * Define el valor de la propiedad userEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserEstado(String value) {
        this.userEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad userFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUserFecha() {
        return userFecha;
    }

    /**
     * Define el valor de la propiedad userFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUserFecha(XMLGregorianCalendar value) {
        this.userFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad userId.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Define el valor de la propiedad userId.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Obtiene el valor de la propiedad userNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserNombre() {
        return userNombre;
    }

    /**
     * Define el valor de la propiedad userNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserNombre(String value) {
        this.userNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad userUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserUsuario() {
        return userUsuario;
    }

    /**
     * Define el valor de la propiedad userUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserUsuario(String value) {
        this.userUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHasta(String value) {
        this.fechaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad ilimitado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIlimitado() {
        return ilimitado;
    }

    /**
     * Define el valor de la propiedad ilimitado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIlimitado(String value) {
        this.ilimitado = value;
    }

    /**
     * Obtiene el valor de la propiedad ejecutor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEjecutor() {
        return ejecutor;
    }

    /**
     * Define el valor de la propiedad ejecutor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEjecutor(String value) {
        this.ejecutor = value;
    }

    /**
     * Obtiene el valor de la propiedad enLinea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnLinea() {
        return enLinea;
    }

    /**
     * Define el valor de la propiedad enLinea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnLinea(String value) {
        this.enLinea = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIniArchivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIniArchivo() {
        return fechaIniArchivo;
    }

    /**
     * Define el valor de la propiedad fechaIniArchivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIniArchivo(String value) {
        this.fechaIniArchivo = value;
    }

}
