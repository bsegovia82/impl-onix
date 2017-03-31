
package sicore.medidores.servicios.ifc.medidores;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para recepcionPalm complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="recepcionPalm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_anio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_codLector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_consumo" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
 *         &lt;element name="_contador" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_cueLecAct" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
 *         &lt;element name="_cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_dia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_empresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_hora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_idDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_latitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_longitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_mes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_numeroSerie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_obser1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_obser2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_obser3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_obser4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_observ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_tipoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_transm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_varMedici" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_codigoResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_mensajeResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recepcionPalm", propOrder = {
    "anio",
    "codLector",
    "consumo",
    "contador",
    "cueLecAct",
    "cuenta",
    "dia",
    "empresa",
    "estado",
    "fecha",
    "hora",
    "idDocumento",
    "latitud",
    "longitud",
    "mes",
    "numeroSerie",
    "obser1",
    "obser2",
    "obser3",
    "obser4",
    "observ",
    "ruta",
    "tipoCliente",
    "transm",
    "varMedici",
    "codigoResultado",
    "mensajeResultado"
})
public class RecepcionPalm {

    @XmlElement(name = "_anio")
    protected String anio;
    @XmlElement(name = "_codLector")
    protected String codLector;
    @XmlElement(name = "_consumo", required = true)
    protected BigDecimal consumo;
    @XmlElement(name = "_contador")
    protected int contador;
    @XmlElement(name = "_cueLecAct", required = true)
    protected BigDecimal cueLecAct;
    @XmlElement(name = "_cuenta")
    protected String cuenta;
    @XmlElement(name = "_dia")
    protected String dia;
    @XmlElement(name = "_empresa")
    protected String empresa;
    @XmlElement(name = "_estado")
    protected String estado;
    @XmlElement(name = "_fecha")
    protected String fecha;
    @XmlElement(name = "_hora")
    protected String hora;
    @XmlElement(name = "_idDocumento")
    protected String idDocumento;
    @XmlElement(name = "_latitud")
    protected String latitud;
    @XmlElement(name = "_longitud")
    protected String longitud;
    @XmlElement(name = "_mes")
    protected String mes;
    @XmlElement(name = "_numeroSerie")
    protected String numeroSerie;
    @XmlElement(name = "_obser1")
    protected String obser1;
    @XmlElement(name = "_obser2")
    protected String obser2;
    @XmlElement(name = "_obser3")
    protected String obser3;
    @XmlElement(name = "_obser4")
    protected String obser4;
    @XmlElement(name = "_observ")
    protected String observ;
    @XmlElement(name = "_ruta")
    protected String ruta;
    @XmlElement(name = "_tipoCliente")
    protected String tipoCliente;
    @XmlElement(name = "_transm")
    protected String transm;
    @XmlElement(name = "_varMedici")
    protected String varMedici;
    @XmlElement(name = "_codigoResultado")
    protected String codigoResultado;
    @XmlElement(name = "_mensajeResultado")
    protected String mensajeResultado;

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
     * Obtiene el valor de la propiedad codLector.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLector() {
        return codLector;
    }

    /**
     * Define el valor de la propiedad codLector.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLector(String value) {
        this.codLector = value;
    }

    /**
     * Obtiene el valor de la propiedad consumo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConsumo() {
        return consumo;
    }

    /**
     * Define el valor de la propiedad consumo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConsumo(BigDecimal value) {
        this.consumo = value;
    }

    /**
     * Obtiene el valor de la propiedad contador.
     * 
     */
    public int getContador() {
        return contador;
    }

    /**
     * Define el valor de la propiedad contador.
     * 
     */
    public void setContador(int value) {
        this.contador = value;
    }

    /**
     * Obtiene el valor de la propiedad cueLecAct.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCueLecAct() {
        return cueLecAct;
    }

    /**
     * Define el valor de la propiedad cueLecAct.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCueLecAct(BigDecimal value) {
        this.cueLecAct = value;
    }

    /**
     * Obtiene el valor de la propiedad cuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Define el valor de la propiedad cuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuenta(String value) {
        this.cuenta = value;
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
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
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
     * Obtiene el valor de la propiedad idDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocumento() {
        return idDocumento;
    }

    /**
     * Define el valor de la propiedad idDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocumento(String value) {
        this.idDocumento = value;
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
     * Obtiene el valor de la propiedad numeroSerie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Define el valor de la propiedad numeroSerie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSerie(String value) {
        this.numeroSerie = value;
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
     * Obtiene el valor de la propiedad obser2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObser2() {
        return obser2;
    }

    /**
     * Define el valor de la propiedad obser2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObser2(String value) {
        this.obser2 = value;
    }

    /**
     * Obtiene el valor de la propiedad obser3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObser3() {
        return obser3;
    }

    /**
     * Define el valor de la propiedad obser3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObser3(String value) {
        this.obser3 = value;
    }

    /**
     * Obtiene el valor de la propiedad obser4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObser4() {
        return obser4;
    }

    /**
     * Define el valor de la propiedad obser4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObser4(String value) {
        this.obser4 = value;
    }

    /**
     * Obtiene el valor de la propiedad observ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObserv() {
        return observ;
    }

    /**
     * Define el valor de la propiedad observ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObserv(String value) {
        this.observ = value;
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

    /**
     * Obtiene el valor de la propiedad codigoResultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoResultado() {
        return codigoResultado;
    }

    /**
     * Define el valor de la propiedad codigoResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoResultado(String value) {
        this.codigoResultado = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeResultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeResultado() {
        return mensajeResultado;
    }

    /**
     * Define el valor de la propiedad mensajeResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeResultado(String value) {
        this.mensajeResultado = value;
    }

}
