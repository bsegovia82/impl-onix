
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para rutasEstado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rutasEstado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_anio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_cantid" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_carga" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="unqualified"/>
 *         &lt;element name="_chk" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_descar" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="unqualified"/>
 *         &lt;element name="_dia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_empresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_equipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_fechafin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_fechaini" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_genera" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="unqualified"/>
 *         &lt;element name="_horafin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_horaini" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_lecnot" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_lectom" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_mes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_planificada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_sobrantes" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
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
@XmlType(name = "rutasEstado", propOrder = {
    "anio",
    "cantid",
    "carga",
    "chk",
    "descar",
    "dia",
    "empresa",
    "equipo",
    "estado",
    "fechafin",
    "fechaini",
    "genera",
    "horafin",
    "horaini",
    "lecnot",
    "lectom",
    "mes",
    "planificada",
    "ruta",
    "sobrantes",
    "tipo",
    "codigoResultado",
    "mensajeResultado"
})
public class RutasEstado {

    @XmlElement(name = "_anio")
    protected String anio;
    @XmlElement(name = "_cantid")
    protected int cantid;
    @XmlElement(name = "_carga", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar carga;
    @XmlElement(name = "_chk")
    protected int chk;
    @XmlElement(name = "_descar", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar descar;
    @XmlElement(name = "_dia")
    protected String dia;
    @XmlElement(name = "_empresa")
    protected String empresa;
    @XmlElement(name = "_equipo")
    protected String equipo;
    @XmlElement(name = "_estado")
    protected String estado;
    @XmlElement(name = "_fechafin")
    protected String fechafin;
    @XmlElement(name = "_fechaini")
    protected String fechaini;
    @XmlElement(name = "_genera", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar genera;
    @XmlElement(name = "_horafin")
    protected String horafin;
    @XmlElement(name = "_horaini")
    protected String horaini;
    @XmlElement(name = "_lecnot")
    protected int lecnot;
    @XmlElement(name = "_lectom")
    protected int lectom;
    @XmlElement(name = "_mes")
    protected String mes;
    @XmlElement(name = "_planificada")
    protected String planificada;
    @XmlElement(name = "_ruta")
    protected String ruta;
    @XmlElement(name = "_sobrantes")
    protected int sobrantes;
    @XmlElement(name = "_tipo")
    protected String tipo;
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
     * Obtiene el valor de la propiedad cantid.
     * 
     */
    public int getCantid() {
        return cantid;
    }

    /**
     * Define el valor de la propiedad cantid.
     * 
     */
    public void setCantid(int value) {
        this.cantid = value;
    }

    /**
     * Obtiene el valor de la propiedad carga.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCarga() {
        return carga;
    }

    /**
     * Define el valor de la propiedad carga.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCarga(XMLGregorianCalendar value) {
        this.carga = value;
    }

    /**
     * Obtiene el valor de la propiedad chk.
     * 
     */
    public int getChk() {
        return chk;
    }

    /**
     * Define el valor de la propiedad chk.
     * 
     */
    public void setChk(int value) {
        this.chk = value;
    }

    /**
     * Obtiene el valor de la propiedad descar.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDescar() {
        return descar;
    }

    /**
     * Define el valor de la propiedad descar.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDescar(XMLGregorianCalendar value) {
        this.descar = value;
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
     * Obtiene el valor de la propiedad equipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * Define el valor de la propiedad equipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipo(String value) {
        this.equipo = value;
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
     * Obtiene el valor de la propiedad fechafin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * Define el valor de la propiedad fechafin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafin(String value) {
        this.fechafin = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaini.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaini() {
        return fechaini;
    }

    /**
     * Define el valor de la propiedad fechaini.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaini(String value) {
        this.fechaini = value;
    }

    /**
     * Obtiene el valor de la propiedad genera.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGenera() {
        return genera;
    }

    /**
     * Define el valor de la propiedad genera.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGenera(XMLGregorianCalendar value) {
        this.genera = value;
    }

    /**
     * Obtiene el valor de la propiedad horafin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorafin() {
        return horafin;
    }

    /**
     * Define el valor de la propiedad horafin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorafin(String value) {
        this.horafin = value;
    }

    /**
     * Obtiene el valor de la propiedad horaini.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraini() {
        return horaini;
    }

    /**
     * Define el valor de la propiedad horaini.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraini(String value) {
        this.horaini = value;
    }

    /**
     * Obtiene el valor de la propiedad lecnot.
     * 
     */
    public int getLecnot() {
        return lecnot;
    }

    /**
     * Define el valor de la propiedad lecnot.
     * 
     */
    public void setLecnot(int value) {
        this.lecnot = value;
    }

    /**
     * Obtiene el valor de la propiedad lectom.
     * 
     */
    public int getLectom() {
        return lectom;
    }

    /**
     * Define el valor de la propiedad lectom.
     * 
     */
    public void setLectom(int value) {
        this.lectom = value;
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
     * Obtiene el valor de la propiedad planificada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanificada() {
        return planificada;
    }

    /**
     * Define el valor de la propiedad planificada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanificada(String value) {
        this.planificada = value;
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
     * Obtiene el valor de la propiedad sobrantes.
     * 
     */
    public int getSobrantes() {
        return sobrantes;
    }

    /**
     * Define el valor de la propiedad sobrantes.
     * 
     */
    public void setSobrantes(int value) {
        this.sobrantes = value;
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
