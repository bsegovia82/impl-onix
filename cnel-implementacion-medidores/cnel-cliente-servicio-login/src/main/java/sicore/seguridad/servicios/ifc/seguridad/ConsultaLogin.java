
package sicore.seguridad.servicios.ifc.seguridad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import bpe.common.servicios.peticiones.Peticion;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="peticion" type="{http://peticiones.servicios.common.bpe/}peticion" minOccurs="0" form="unqualified"/>
 *         &lt;element name="userUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="userPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "peticion",
    "userUsuario",
    "userPassword"
})
@XmlRootElement(name = "consultaLogin")
public class ConsultaLogin {

    protected Peticion peticion;
    protected String userUsuario;
    protected String userPassword;

    /**
     * Obtiene el valor de la propiedad peticion.
     * 
     * @return
     *     possible object is
     *     {@link Peticion }
     *     
     */
    public Peticion getPeticion() {
        return peticion;
    }

    /**
     * Define el valor de la propiedad peticion.
     * 
     * @param value
     *     allowed object is
     *     {@link Peticion }
     *     
     */
    public void setPeticion(Peticion value) {
        this.peticion = value;
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
     * Obtiene el valor de la propiedad userPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Define el valor de la propiedad userPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

}
