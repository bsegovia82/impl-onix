
package sicore.medidores.servicios.ifc.medidores;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para recepcionSobrantes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="recepcionSobrantes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_anio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_barrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_codigoLector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_dia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_empresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_esfera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="unqualified"/>
 *         &lt;element name="_hora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_interseccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_latitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_lectura" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
 *         &lt;element name="_longitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_marcam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_medNumero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_medidorAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_mes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_numcas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_obser1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_secuencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_tipoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_transm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_varMedici" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionSobrantes", propOrder = {
    "anio",
    "barrio",
    "codigoLector",
    "dia",
    "direccion",
    "empresa",
    "esfera",
    "fecha",
    "hora",
    "interseccion",
    "latitud",
    "lectura",
    "longitud",
    "marcam",
    "medNumero",
    "medidorAnterior",
    "mes",
    "numcas",
    "obser1",
    "ruta",
    "secuencia",
    "tipoCliente",
    "transm",
    "varMedici"
})
public class RecepcionSobrantes {

    @XmlElement(name = "_anio")
    protected String anio;
    @XmlElement(name = "_barrio")
    protected String barrio;
    @XmlElement(name = "_codigoLector")
    protected String codigoLector;
    @XmlElement(name = "_dia")
    protected String dia;
    @XmlElement(name = "_direccion")
    protected String direccion;
    @XmlElement(name = "_empresa")
    protected String empresa;
    @XmlElement(name = "_esfera")
    protected String esfera;
    @XmlElement(name = "_fecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "_hora")
    protected String hora;
    @XmlElement(name = "_interseccion")
    protected String interseccion;
    @XmlElement(name = "_latitud")
    protected String latitud;
    @XmlElement(name = "_lectura", required = true)
    protected BigDecimal lectura;
    @XmlElement(name = "_longitud")
    protected String longitud;
    @XmlElement(name = "_marcam")
    protected String marcam;
    @XmlElement(name = "_medNumero")
    protected String medNumero;
    @XmlElement(name = "_medidorAnterior")
    protected String medidorAnterior;
    @XmlElement(name = "_mes")
    protected String mes;
    @XmlElement(name = "_numcas")
    protected String numcas;
    @XmlElement(name = "_obser1")
    protected String obser1;
    @XmlElement(name = "_ruta")
    protected String ruta;
    @XmlElement(name = "_secuencia")
    protected String secuencia;
    @XmlElement(name = "_tipoCliente")
    protected String tipoCliente;
    @XmlElement(name = "_transm")
    protected String transm;
    @XmlElement(name = "_varMedici")
    protected String varMedici;

    /**
     * Obtiene el valor de la propiedad anio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnio() {
        return anio;
    }

    /**
     * Define el valor de la propiedad anio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnio(String value) {
        this.anio = value;
    }

    /**
     * Obtiene el valor de la propiedad barrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * Define el valor de la propiedad barrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrio(String value) {
        this.barrio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoLector.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoLector() {
        return codigoLector;
    }

    /**
     * Define el valor de la propiedad codigoLector.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoLector(String value) {
        this.codigoLector = value;
    }

    /**
     * Obtiene el valor de la propiedad dia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDia() {
        return dia;
    }

    /**
     * Define el valor de la propiedad dia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDia(String value) {
        this.dia = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad empresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Define el valor de la propiedad empresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresa(String value) {
        this.empresa = value;
    }

    /**
     * Obtiene el valor de la propiedad esfera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsfera() {
        return esfera;
    }

    /**
     * Define el valor de la propiedad esfera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsfera(String value) {
        this.esfera = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHora(String value) {
        this.hora = value;
    }

    /**
     * Obtiene el valor de la propiedad interseccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterseccion() {
        return interseccion;
    }

    /**
     * Define el valor de la propiedad interseccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterseccion(String value) {
        this.interseccion = value;
    }

    /**
     * Obtiene el valor de la propiedad latitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * Define el valor de la propiedad latitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitud(String value) {
        this.latitud = value;
    }

    /**
     * Obtiene el valor de la propiedad lectura.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLectura() {
        return lectura;
    }

    /**
     * Define el valor de la propiedad lectura.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLectura(BigDecimal value) {
        this.lectura = value;
    }

    /**
     * Obtiene el valor de la propiedad longitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * Define el valor de la propiedad longitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitud(String value) {
        this.longitud = value;
    }

    /**
     * Obtiene el valor de la propiedad marcam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarcam() {
        return marcam;
    }

    /**
     * Define el valor de la propiedad marcam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarcam(String value) {
        this.marcam = value;
    }

    /**
     * Obtiene el valor de la propiedad medNumero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedNumero() {
        return medNumero;
    }

    /**
     * Define el valor de la propiedad medNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedNumero(String value) {
        this.medNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad medidorAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedidorAnterior() {
        return medidorAnterior;
    }

    /**
     * Define el valor de la propiedad medidorAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedidorAnterior(String value) {
        this.medidorAnterior = value;
    }

    /**
     * Obtiene el valor de la propiedad mes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMes() {
        return mes;
    }

    /**
     * Define el valor de la propiedad mes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMes(String value) {
        this.mes = value;
    }

    /**
     * Obtiene el valor de la propiedad numcas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumcas() {
        return numcas;
    }

    /**
     * Define el valor de la propiedad numcas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumcas(String value) {
        this.numcas = value;
    }

    /**
     * Obtiene el valor de la propiedad obser1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObser1() {
        return obser1;
    }

    /**
     * Define el valor de la propiedad obser1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObser1(String value) {
        this.obser1 = value;
    }

    /**
     * Obtiene el valor de la propiedad ruta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Define el valor de la propiedad ruta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuencia(String value) {
        this.secuencia = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Define el valor de la propiedad tipoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCliente(String value) {
        this.tipoCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad transm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransm() {
        return transm;
    }

    /**
     * Define el valor de la propiedad transm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransm(String value) {
        this.transm = value;
    }

    /**
     * Obtiene el valor de la propiedad varMedici.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarMedici() {
        return varMedici;
    }

    /**
     * Define el valor de la propiedad varMedici.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarMedici(String value) {
        this.varMedici = value;
    }

}
