
package bpe.cuentas.servicios.entidades;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para beanFileCorte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="beanFileCorte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anteriorDuplex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="anteriorTriplex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="barrioEdificioUrbanizacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="base" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cableDuplex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cableTriplex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cableTriplex10" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="calle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colorAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colorNuevo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contratista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correlativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="densidadDemografica" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descargado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionNovedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionTipoCorte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deudaTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ejecutor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaHoraDescarga" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaUltimoPago" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fleje" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="foto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="grapa150" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grapa250" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grapa350" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horaEjecucion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idBitacora" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idCortesReconexion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idOrdenOrigen" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idUnico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="interseccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lectura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marcaAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marcaMedidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marcaNuevo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marcado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedadCinco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedadCuatro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedadDos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedadTres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novedadUno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroMedidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroPlanillas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="op" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="or" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origenEnvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="piso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="porFactura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="porSancion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="porTransf" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="posicionX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posicionY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preemSablado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reposicionElemento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutaLectura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seccion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secuencia" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="secuenciaDescarga" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="secuenciaRegistro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="selloInstalado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selloRetirado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selloTipoNuevo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="separador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subzona" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tabla" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoMedidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoReconexion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoReconexionAntrior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoReparto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoSelloAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoSuspension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoSuspensionAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zona" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanFileCorte", propOrder = {
    "anteriorDuplex",
    "anteriorTriplex",
    "barrioEdificioUrbanizacion",
    "base",
    "cableDuplex",
    "cableTriplex",
    "cableTriplex10",
    "calle",
    "carta",
    "codigoCuenta",
    "codigoError",
    "colorAnterior",
    "colorNuevo",
    "confirmacion",
    "contratista",
    "correlativo",
    "corte",
    "densidadDemografica",
    "departamento",
    "descargado",
    "descripcionNovedad",
    "descripcionTipoCorte",
    "deudaTotal",
    "direccion",
    "ejecutor",
    "estadoProceso",
    "fechaHoraDescarga",
    "fechaSolicitud",
    "fechaUltimoPago",
    "fleje",
    "foto",
    "grapa150",
    "grapa250",
    "grapa350",
    "horaEjecucion",
    "idBitacora",
    "idCortesReconexion",
    "idOrden",
    "idOrdenOrigen",
    "idUnico",
    "interseccion",
    "lectura",
    "me",
    "marcaAnterior",
    "marcaMedidor",
    "marcaNuevo",
    "marcado",
    "mensajeError",
    "nombre",
    "novedad",
    "novedadCinco",
    "novedadCuatro",
    "novedadDos",
    "novedadTres",
    "novedadUno",
    "nroDoc",
    "numero",
    "numeroMedidor",
    "numeroPlanillas",
    "ok",
    "op",
    "or",
    "origenEnvio",
    "piso",
    "plan",
    "porFactura",
    "porSancion",
    "porTransf",
    "posicionX",
    "posicionY",
    "preemSablado",
    "referencia",
    "reposicionElemento",
    "rutaLectura",
    "seccion",
    "sector",
    "secuencia",
    "secuenciaDescarga",
    "secuenciaRegistro",
    "selloInstalado",
    "selloRetirado",
    "selloTipoNuevo",
    "separador",
    "sistema",
    "subzona",
    "tabla",
    "telefono",
    "tipoError",
    "tipoMedidor",
    "tipoReconexion",
    "tipoReconexionAntrior",
    "tipoReparto",
    "tipoSelloAnterior",
    "tipoServicio",
    "tipoSuspension",
    "tipoSuspensionAnterior",
    "unidad",
    "zona"
})
public class BeanFileCorte {

    protected BigDecimal anteriorDuplex;
    protected BigDecimal anteriorTriplex;
    protected String barrioEdificioUrbanizacion;
    protected int base;
    protected BigDecimal cableDuplex;
    protected BigDecimal cableTriplex;
    protected BigDecimal cableTriplex10;
    protected String calle;
    protected String carta;
    protected String codigoCuenta;
    protected String codigoError;
    protected String colorAnterior;
    protected String colorNuevo;
    protected String confirmacion;
    protected String contratista;
    protected String correlativo;
    protected String corte;
    protected int densidadDemografica;
    protected String departamento;
    protected String descargado;
    protected String descripcionNovedad;
    protected String descripcionTipoCorte;
    protected BigDecimal deudaTotal;
    protected String direccion;
    protected String ejecutor;
    protected String estadoProceso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraDescarga;
    protected String fechaSolicitud;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUltimoPago;
    protected int fleje;
    protected byte[] foto;
    protected int grapa150;
    protected int grapa250;
    protected int grapa350;
    protected int horaEjecucion;
    protected long idBitacora;
    protected long idCortesReconexion;
    protected long idOrden;
    protected long idOrdenOrigen;
    protected String idUnico;
    protected String interseccion;
    protected BigDecimal lectura;
    @XmlElement(name = "mE")
    protected String me;
    protected String marcaAnterior;
    protected String marcaMedidor;
    protected String marcaNuevo;
    protected Boolean marcado;
    protected String mensajeError;
    protected String nombre;
    protected String novedad;
    protected String novedadCinco;
    protected String novedadCuatro;
    protected String novedadDos;
    protected String novedadTres;
    protected String novedadUno;
    protected String nroDoc;
    protected String numero;
    protected String numeroMedidor;
    protected int numeroPlanillas;
    protected Boolean ok;
    protected String op;
    protected String or;
    protected String origenEnvio;
    protected String piso;
    protected String plan;
    protected BigDecimal porFactura;
    protected BigDecimal porSancion;
    protected BigDecimal porTransf;
    protected String posicionX;
    protected String posicionY;
    protected BigDecimal preemSablado;
    protected String referencia;
    protected String reposicionElemento;
    protected String rutaLectura;
    protected BigDecimal seccion;
    protected int sector;
    protected BigDecimal secuencia;
    protected long secuenciaDescarga;
    protected int secuenciaRegistro;
    protected String selloInstalado;
    protected String selloRetirado;
    protected String selloTipoNuevo;
    protected int separador;
    protected String sistema;
    protected BigDecimal subzona;
    protected int tabla;
    protected String telefono;
    protected String tipoError;
    protected String tipoMedidor;
    protected String tipoReconexion;
    protected String tipoReconexionAntrior;
    protected String tipoReparto;
    protected String tipoSelloAnterior;
    protected String tipoServicio;
    protected String tipoSuspension;
    protected String tipoSuspensionAnterior;
    protected String unidad;
    protected BigDecimal zona;

    /**
     * Obtiene el valor de la propiedad anteriorDuplex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnteriorDuplex() {
        return anteriorDuplex;
    }

    /**
     * Define el valor de la propiedad anteriorDuplex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnteriorDuplex(BigDecimal value) {
        this.anteriorDuplex = value;
    }

    /**
     * Obtiene el valor de la propiedad anteriorTriplex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnteriorTriplex() {
        return anteriorTriplex;
    }

    /**
     * Define el valor de la propiedad anteriorTriplex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnteriorTriplex(BigDecimal value) {
        this.anteriorTriplex = value;
    }

    /**
     * Obtiene el valor de la propiedad barrioEdificioUrbanizacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrioEdificioUrbanizacion() {
        return barrioEdificioUrbanizacion;
    }

    /**
     * Define el valor de la propiedad barrioEdificioUrbanizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrioEdificioUrbanizacion(String value) {
        this.barrioEdificioUrbanizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad base.
     * 
     */
    public int getBase() {
        return base;
    }

    /**
     * Define el valor de la propiedad base.
     * 
     */
    public void setBase(int value) {
        this.base = value;
    }

    /**
     * Obtiene el valor de la propiedad cableDuplex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCableDuplex() {
        return cableDuplex;
    }

    /**
     * Define el valor de la propiedad cableDuplex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCableDuplex(BigDecimal value) {
        this.cableDuplex = value;
    }

    /**
     * Obtiene el valor de la propiedad cableTriplex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCableTriplex() {
        return cableTriplex;
    }

    /**
     * Define el valor de la propiedad cableTriplex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCableTriplex(BigDecimal value) {
        this.cableTriplex = value;
    }

    /**
     * Obtiene el valor de la propiedad cableTriplex10.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCableTriplex10() {
        return cableTriplex10;
    }

    /**
     * Define el valor de la propiedad cableTriplex10.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCableTriplex10(BigDecimal value) {
        this.cableTriplex10 = value;
    }

    /**
     * Obtiene el valor de la propiedad calle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Define el valor de la propiedad calle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Obtiene el valor de la propiedad carta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarta() {
        return carta;
    }

    /**
     * Define el valor de la propiedad carta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarta(String value) {
        this.carta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Define el valor de la propiedad codigoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCuenta(String value) {
        this.codigoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad colorAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorAnterior() {
        return colorAnterior;
    }

    /**
     * Define el valor de la propiedad colorAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorAnterior(String value) {
        this.colorAnterior = value;
    }

    /**
     * Obtiene el valor de la propiedad colorNuevo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorNuevo() {
        return colorNuevo;
    }

    /**
     * Define el valor de la propiedad colorNuevo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorNuevo(String value) {
        this.colorNuevo = value;
    }

    /**
     * Obtiene el valor de la propiedad confirmacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * Define el valor de la propiedad confirmacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmacion(String value) {
        this.confirmacion = value;
    }

    /**
     * Obtiene el valor de la propiedad contratista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContratista() {
        return contratista;
    }

    /**
     * Define el valor de la propiedad contratista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContratista(String value) {
        this.contratista = value;
    }

    /**
     * Obtiene el valor de la propiedad correlativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelativo() {
        return correlativo;
    }

    /**
     * Define el valor de la propiedad correlativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelativo(String value) {
        this.correlativo = value;
    }

    /**
     * Obtiene el valor de la propiedad corte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorte() {
        return corte;
    }

    /**
     * Define el valor de la propiedad corte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorte(String value) {
        this.corte = value;
    }

    /**
     * Obtiene el valor de la propiedad densidadDemografica.
     * 
     */
    public int getDensidadDemografica() {
        return densidadDemografica;
    }

    /**
     * Define el valor de la propiedad densidadDemografica.
     * 
     */
    public void setDensidadDemografica(int value) {
        this.densidadDemografica = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad descargado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescargado() {
        return descargado;
    }

    /**
     * Define el valor de la propiedad descargado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescargado(String value) {
        this.descargado = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionNovedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionNovedad() {
        return descripcionNovedad;
    }

    /**
     * Define el valor de la propiedad descripcionNovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionNovedad(String value) {
        this.descripcionNovedad = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionTipoCorte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionTipoCorte() {
        return descripcionTipoCorte;
    }

    /**
     * Define el valor de la propiedad descripcionTipoCorte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionTipoCorte(String value) {
        this.descripcionTipoCorte = value;
    }

    /**
     * Obtiene el valor de la propiedad deudaTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeudaTotal() {
        return deudaTotal;
    }

    /**
     * Define el valor de la propiedad deudaTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeudaTotal(BigDecimal value) {
        this.deudaTotal = value;
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
     * Obtiene el valor de la propiedad estadoProceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoProceso() {
        return estadoProceso;
    }

    /**
     * Define el valor de la propiedad estadoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoProceso(String value) {
        this.estadoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraDescarga.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraDescarga() {
        return fechaHoraDescarga;
    }

    /**
     * Define el valor de la propiedad fechaHoraDescarga.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraDescarga(XMLGregorianCalendar value) {
        this.fechaHoraDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Define el valor de la propiedad fechaSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSolicitud(String value) {
        this.fechaSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaUltimoPago.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    /**
     * Define el valor de la propiedad fechaUltimoPago.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUltimoPago(XMLGregorianCalendar value) {
        this.fechaUltimoPago = value;
    }

    /**
     * Obtiene el valor de la propiedad fleje.
     * 
     */
    public int getFleje() {
        return fleje;
    }

    /**
     * Define el valor de la propiedad fleje.
     * 
     */
    public void setFleje(int value) {
        this.fleje = value;
    }

    /**
     * Obtiene el valor de la propiedad foto.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Define el valor de la propiedad foto.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFoto(byte[] value) {
        this.foto = value;
    }

    /**
     * Obtiene el valor de la propiedad grapa150.
     * 
     */
    public int getGrapa150() {
        return grapa150;
    }

    /**
     * Define el valor de la propiedad grapa150.
     * 
     */
    public void setGrapa150(int value) {
        this.grapa150 = value;
    }

    /**
     * Obtiene el valor de la propiedad grapa250.
     * 
     */
    public int getGrapa250() {
        return grapa250;
    }

    /**
     * Define el valor de la propiedad grapa250.
     * 
     */
    public void setGrapa250(int value) {
        this.grapa250 = value;
    }

    /**
     * Obtiene el valor de la propiedad grapa350.
     * 
     */
    public int getGrapa350() {
        return grapa350;
    }

    /**
     * Define el valor de la propiedad grapa350.
     * 
     */
    public void setGrapa350(int value) {
        this.grapa350 = value;
    }

    /**
     * Obtiene el valor de la propiedad horaEjecucion.
     * 
     */
    public int getHoraEjecucion() {
        return horaEjecucion;
    }

    /**
     * Define el valor de la propiedad horaEjecucion.
     * 
     */
    public void setHoraEjecucion(int value) {
        this.horaEjecucion = value;
    }

    /**
     * Obtiene el valor de la propiedad idBitacora.
     * 
     */
    public long getIdBitacora() {
        return idBitacora;
    }

    /**
     * Define el valor de la propiedad idBitacora.
     * 
     */
    public void setIdBitacora(long value) {
        this.idBitacora = value;
    }

    /**
     * Obtiene el valor de la propiedad idCortesReconexion.
     * 
     */
    public long getIdCortesReconexion() {
        return idCortesReconexion;
    }

    /**
     * Define el valor de la propiedad idCortesReconexion.
     * 
     */
    public void setIdCortesReconexion(long value) {
        this.idCortesReconexion = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     */
    public long getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     */
    public void setIdOrden(long value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrdenOrigen.
     * 
     */
    public long getIdOrdenOrigen() {
        return idOrdenOrigen;
    }

    /**
     * Define el valor de la propiedad idOrdenOrigen.
     * 
     */
    public void setIdOrdenOrigen(long value) {
        this.idOrdenOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad idUnico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUnico() {
        return idUnico;
    }

    /**
     * Define el valor de la propiedad idUnico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUnico(String value) {
        this.idUnico = value;
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
     * Obtiene el valor de la propiedad me.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getME() {
        return me;
    }

    /**
     * Define el valor de la propiedad me.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setME(String value) {
        this.me = value;
    }

    /**
     * Obtiene el valor de la propiedad marcaAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarcaAnterior() {
        return marcaAnterior;
    }

    /**
     * Define el valor de la propiedad marcaAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarcaAnterior(String value) {
        this.marcaAnterior = value;
    }

    /**
     * Obtiene el valor de la propiedad marcaMedidor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarcaMedidor() {
        return marcaMedidor;
    }

    /**
     * Define el valor de la propiedad marcaMedidor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarcaMedidor(String value) {
        this.marcaMedidor = value;
    }

    /**
     * Obtiene el valor de la propiedad marcaNuevo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarcaNuevo() {
        return marcaNuevo;
    }

    /**
     * Define el valor de la propiedad marcaNuevo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarcaNuevo(String value) {
        this.marcaNuevo = value;
    }

    /**
     * Obtiene el valor de la propiedad marcado.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarcado() {
        return marcado;
    }

    /**
     * Define el valor de la propiedad marcado.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarcado(Boolean value) {
        this.marcado = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Define el valor de la propiedad mensajeError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeError(String value) {
        this.mensajeError = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad novedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * Define el valor de la propiedad novedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedad(String value) {
        this.novedad = value;
    }

    /**
     * Obtiene el valor de la propiedad novedadCinco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedadCinco() {
        return novedadCinco;
    }

    /**
     * Define el valor de la propiedad novedadCinco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedadCinco(String value) {
        this.novedadCinco = value;
    }

    /**
     * Obtiene el valor de la propiedad novedadCuatro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedadCuatro() {
        return novedadCuatro;
    }

    /**
     * Define el valor de la propiedad novedadCuatro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedadCuatro(String value) {
        this.novedadCuatro = value;
    }

    /**
     * Obtiene el valor de la propiedad novedadDos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedadDos() {
        return novedadDos;
    }

    /**
     * Define el valor de la propiedad novedadDos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedadDos(String value) {
        this.novedadDos = value;
    }

    /**
     * Obtiene el valor de la propiedad novedadTres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedadTres() {
        return novedadTres;
    }

    /**
     * Define el valor de la propiedad novedadTres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedadTres(String value) {
        this.novedadTres = value;
    }

    /**
     * Obtiene el valor de la propiedad novedadUno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedadUno() {
        return novedadUno;
    }

    /**
     * Define el valor de la propiedad novedadUno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedadUno(String value) {
        this.novedadUno = value;
    }

    /**
     * Obtiene el valor de la propiedad nroDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroDoc() {
        return nroDoc;
    }

    /**
     * Define el valor de la propiedad nroDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroDoc(String value) {
        this.nroDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroMedidor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    /**
     * Define el valor de la propiedad numeroMedidor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroMedidor(String value) {
        this.numeroMedidor = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPlanillas.
     * 
     */
    public int getNumeroPlanillas() {
        return numeroPlanillas;
    }

    /**
     * Define el valor de la propiedad numeroPlanillas.
     * 
     */
    public void setNumeroPlanillas(int value) {
        this.numeroPlanillas = value;
    }

    /**
     * Obtiene el valor de la propiedad ok.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOk() {
        return ok;
    }

    /**
     * Define el valor de la propiedad ok.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOk(Boolean value) {
        this.ok = value;
    }

    /**
     * Obtiene el valor de la propiedad op.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOp() {
        return op;
    }

    /**
     * Define el valor de la propiedad op.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOp(String value) {
        this.op = value;
    }

    /**
     * Obtiene el valor de la propiedad or.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOr() {
        return or;
    }

    /**
     * Define el valor de la propiedad or.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOr(String value) {
        this.or = value;
    }

    /**
     * Obtiene el valor de la propiedad origenEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigenEnvio() {
        return origenEnvio;
    }

    /**
     * Define el valor de la propiedad origenEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigenEnvio(String value) {
        this.origenEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad piso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiso() {
        return piso;
    }

    /**
     * Define el valor de la propiedad piso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiso(String value) {
        this.piso = value;
    }

    /**
     * Obtiene el valor de la propiedad plan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlan() {
        return plan;
    }

    /**
     * Define el valor de la propiedad plan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlan(String value) {
        this.plan = value;
    }

    /**
     * Obtiene el valor de la propiedad porFactura.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorFactura() {
        return porFactura;
    }

    /**
     * Define el valor de la propiedad porFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorFactura(BigDecimal value) {
        this.porFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad porSancion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorSancion() {
        return porSancion;
    }

    /**
     * Define el valor de la propiedad porSancion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorSancion(BigDecimal value) {
        this.porSancion = value;
    }

    /**
     * Obtiene el valor de la propiedad porTransf.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorTransf() {
        return porTransf;
    }

    /**
     * Define el valor de la propiedad porTransf.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorTransf(BigDecimal value) {
        this.porTransf = value;
    }

    /**
     * Obtiene el valor de la propiedad posicionX.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosicionX() {
        return posicionX;
    }

    /**
     * Define el valor de la propiedad posicionX.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosicionX(String value) {
        this.posicionX = value;
    }

    /**
     * Obtiene el valor de la propiedad posicionY.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosicionY() {
        return posicionY;
    }

    /**
     * Define el valor de la propiedad posicionY.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosicionY(String value) {
        this.posicionY = value;
    }

    /**
     * Obtiene el valor de la propiedad preemSablado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreemSablado() {
        return preemSablado;
    }

    /**
     * Define el valor de la propiedad preemSablado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreemSablado(BigDecimal value) {
        this.preemSablado = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad reposicionElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReposicionElemento() {
        return reposicionElemento;
    }

    /**
     * Define el valor de la propiedad reposicionElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReposicionElemento(String value) {
        this.reposicionElemento = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaLectura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaLectura() {
        return rutaLectura;
    }

    /**
     * Define el valor de la propiedad rutaLectura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaLectura(String value) {
        this.rutaLectura = value;
    }

    /**
     * Obtiene el valor de la propiedad seccion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSeccion() {
        return seccion;
    }

    /**
     * Define el valor de la propiedad seccion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSeccion(BigDecimal value) {
        this.seccion = value;
    }

    /**
     * Obtiene el valor de la propiedad sector.
     * 
     */
    public int getSector() {
        return sector;
    }

    /**
     * Define el valor de la propiedad sector.
     * 
     */
    public void setSector(int value) {
        this.sector = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencia.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSecuencia(BigDecimal value) {
        this.secuencia = value;
    }

    /**
     * Obtiene el valor de la propiedad secuenciaDescarga.
     * 
     */
    public long getSecuenciaDescarga() {
        return secuenciaDescarga;
    }

    /**
     * Define el valor de la propiedad secuenciaDescarga.
     * 
     */
    public void setSecuenciaDescarga(long value) {
        this.secuenciaDescarga = value;
    }

    /**
     * Obtiene el valor de la propiedad secuenciaRegistro.
     * 
     */
    public int getSecuenciaRegistro() {
        return secuenciaRegistro;
    }

    /**
     * Define el valor de la propiedad secuenciaRegistro.
     * 
     */
    public void setSecuenciaRegistro(int value) {
        this.secuenciaRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad selloInstalado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloInstalado() {
        return selloInstalado;
    }

    /**
     * Define el valor de la propiedad selloInstalado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloInstalado(String value) {
        this.selloInstalado = value;
    }

    /**
     * Obtiene el valor de la propiedad selloRetirado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloRetirado() {
        return selloRetirado;
    }

    /**
     * Define el valor de la propiedad selloRetirado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloRetirado(String value) {
        this.selloRetirado = value;
    }

    /**
     * Obtiene el valor de la propiedad selloTipoNuevo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelloTipoNuevo() {
        return selloTipoNuevo;
    }

    /**
     * Define el valor de la propiedad selloTipoNuevo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelloTipoNuevo(String value) {
        this.selloTipoNuevo = value;
    }

    /**
     * Obtiene el valor de la propiedad separador.
     * 
     */
    public int getSeparador() {
        return separador;
    }

    /**
     * Define el valor de la propiedad separador.
     * 
     */
    public void setSeparador(int value) {
        this.separador = value;
    }

    /**
     * Obtiene el valor de la propiedad sistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * Define el valor de la propiedad sistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSistema(String value) {
        this.sistema = value;
    }

    /**
     * Obtiene el valor de la propiedad subzona.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubzona() {
        return subzona;
    }

    /**
     * Define el valor de la propiedad subzona.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubzona(BigDecimal value) {
        this.subzona = value;
    }

    /**
     * Obtiene el valor de la propiedad tabla.
     * 
     */
    public int getTabla() {
        return tabla;
    }

    /**
     * Define el valor de la propiedad tabla.
     * 
     */
    public void setTabla(int value) {
        this.tabla = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoError() {
        return tipoError;
    }

    /**
     * Define el valor de la propiedad tipoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoError(String value) {
        this.tipoError = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoMedidor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMedidor() {
        return tipoMedidor;
    }

    /**
     * Define el valor de la propiedad tipoMedidor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMedidor(String value) {
        this.tipoMedidor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReconexion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReconexion() {
        return tipoReconexion;
    }

    /**
     * Define el valor de la propiedad tipoReconexion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReconexion(String value) {
        this.tipoReconexion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReconexionAntrior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReconexionAntrior() {
        return tipoReconexionAntrior;
    }

    /**
     * Define el valor de la propiedad tipoReconexionAntrior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReconexionAntrior(String value) {
        this.tipoReconexionAntrior = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReparto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReparto() {
        return tipoReparto;
    }

    /**
     * Define el valor de la propiedad tipoReparto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReparto(String value) {
        this.tipoReparto = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoSelloAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSelloAnterior() {
        return tipoSelloAnterior;
    }

    /**
     * Define el valor de la propiedad tipoSelloAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSelloAnterior(String value) {
        this.tipoSelloAnterior = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Define el valor de la propiedad tipoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServicio(String value) {
        this.tipoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoSuspension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuspension() {
        return tipoSuspension;
    }

    /**
     * Define el valor de la propiedad tipoSuspension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuspension(String value) {
        this.tipoSuspension = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoSuspensionAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSuspensionAnterior() {
        return tipoSuspensionAnterior;
    }

    /**
     * Define el valor de la propiedad tipoSuspensionAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSuspensionAnterior(String value) {
        this.tipoSuspensionAnterior = value;
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

    /**
     * Obtiene el valor de la propiedad zona.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getZona() {
        return zona;
    }

    /**
     * Define el valor de la propiedad zona.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setZona(BigDecimal value) {
        this.zona = value;
    }

}
