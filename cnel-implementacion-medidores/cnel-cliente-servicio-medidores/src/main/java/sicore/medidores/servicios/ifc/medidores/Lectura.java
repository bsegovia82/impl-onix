
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para lectura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lectura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_anio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_barrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_calle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_cifra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_codigoLector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_decimales" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_dia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_distrito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_empresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_enteros" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_fechaIngreso" type="{http://www.w3.org/2001/XMLSchema}dateTime" form="unqualified"/>
 *         &lt;element name="_fechaPlanificada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_idDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_idEmpresa" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_identificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_indice" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_interseccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_lecturaAnterior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_lecturaMaxima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_lecturaMinima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_marca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_material" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_mes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_motivoLectura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_mru" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_nota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_numerador" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_numeroCasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_numeroSerie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_numerohabitacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_piso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_poblacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_porcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_secuencia" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *         &lt;element name="_suplemento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_tarifa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_tipoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="_usuarioIngreso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
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
@XmlType(name = "lectura", propOrder = {
    "anio",
    "barrio",
    "calle",
    "cifra",
    "codigoLector",
    "cuenta",
    "decimales",
    "dia",
    "distrito",
    "empresa",
    "enteros",
    "fechaIngreso",
    "fechaPlanificada",
    "idDocumento",
    "idEmpresa",
    "identificador",
    "indice",
    "interseccion",
    "lecturaAnterior",
    "lecturaMaxima",
    "lecturaMinima",
    "marca",
    "material",
    "mes",
    "motivoLectura",
    "mru",
    "nombre",
    "nota",
    "numerador",
    "numeroCasa",
    "numeroSerie",
    "numerohabitacion",
    "piso",
    "poblacion",
    "porcion",
    "region",
    "ruta",
    "secuencia",
    "suplemento",
    "tarifa",
    "tipoCliente",
    "usuarioIngreso",
    "codigoResultado",
    "mensajeResultado"
})
public class Lectura {

    @XmlElement(name = "_anio")
    protected String anio;
    @XmlElement(name = "_barrio")
    protected String barrio;
    @XmlElement(name = "_calle")
    protected String calle;
    @XmlElement(name = "_cifra")
    protected String cifra;
    @XmlElement(name = "_codigoLector")
    protected String codigoLector;
    @XmlElement(name = "_cuenta")
    protected String cuenta;
    @XmlElement(name = "_decimales")
    protected int decimales;
    @XmlElement(name = "_dia")
    protected String dia;
    @XmlElement(name = "_distrito")
    protected String distrito;
    @XmlElement(name = "_empresa")
    protected String empresa;
    @XmlElement(name = "_enteros")
    protected int enteros;
    @XmlElement(name = "_fechaIngreso", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaIngreso;
    @XmlElement(name = "_fechaPlanificada")
    protected String fechaPlanificada;
    @XmlElement(name = "_idDocumento")
    protected String idDocumento;
    @XmlElement(name = "_idEmpresa")
    protected int idEmpresa;
    @XmlElement(name = "_identificador")
    protected String identificador;
    @XmlElement(name = "_indice")
    protected int indice;
    @XmlElement(name = "_interseccion")
    protected String interseccion;
    @XmlElement(name = "_lecturaAnterior")
    protected String lecturaAnterior;
    @XmlElement(name = "_lecturaMaxima")
    protected String lecturaMaxima;
    @XmlElement(name = "_lecturaMinima")
    protected String lecturaMinima;
    @XmlElement(name = "_marca")
    protected String marca;
    @XmlElement(name = "_material")
    protected String material;
    @XmlElement(name = "_mes")
    protected String mes;
    @XmlElement(name = "_motivoLectura")
    protected String motivoLectura;
    @XmlElement(name = "_mru")
    protected String mru;
    @XmlElement(name = "_nombre")
    protected String nombre;
    @XmlElement(name = "_nota")
    protected String nota;
    @XmlElement(name = "_numerador")
    protected int numerador;
    @XmlElement(name = "_numeroCasa")
    protected String numeroCasa;
    @XmlElement(name = "_numeroSerie")
    protected String numeroSerie;
    @XmlElement(name = "_numerohabitacion")
    protected String numerohabitacion;
    @XmlElement(name = "_piso")
    protected String piso;
    @XmlElement(name = "_poblacion")
    protected String poblacion;
    @XmlElement(name = "_porcion")
    protected String porcion;
    @XmlElement(name = "_region")
    protected String region;
    @XmlElement(name = "_ruta")
    protected String ruta;
    @XmlElement(name = "_secuencia")
    protected int secuencia;
    @XmlElement(name = "_suplemento")
    protected String suplemento;
    @XmlElement(name = "_tarifa")
    protected String tarifa;
    @XmlElement(name = "_tipoCliente")
    protected String tipoCliente;
    @XmlElement(name = "_usuarioIngreso")
    protected String usuarioIngreso;
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
     * Obtiene el valor de la propiedad cifra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCifra() {
        return cifra;
    }

    /**
     * Define el valor de la propiedad cifra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCifra(String value) {
        this.cifra = value;
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
     * Obtiene el valor de la propiedad decimales.
     * 
     */
    public int getDecimales() {
        return decimales;
    }

    /**
     * Define el valor de la propiedad decimales.
     * 
     */
    public void setDecimales(int value) {
        this.decimales = value;
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
     * Obtiene el valor de la propiedad distrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define el valor de la propiedad distrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrito(String value) {
        this.distrito = value;
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
     * Obtiene el valor de la propiedad enteros.
     * 
     */
    public int getEnteros() {
        return enteros;
    }

    /**
     * Define el valor de la propiedad enteros.
     * 
     */
    public void setEnteros(int value) {
        this.enteros = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIngreso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Define el valor de la propiedad fechaIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaIngreso(XMLGregorianCalendar value) {
        this.fechaIngreso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPlanificada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaPlanificada() {
        return fechaPlanificada;
    }

    /**
     * Define el valor de la propiedad fechaPlanificada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaPlanificada(String value) {
        this.fechaPlanificada = value;
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
     * Obtiene el valor de la propiedad idEmpresa.
     * 
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Define el valor de la propiedad idEmpresa.
     * 
     */
    public void setIdEmpresa(int value) {
        this.idEmpresa = value;
    }

    /**
     * Obtiene el valor de la propiedad identificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Define el valor de la propiedad identificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificador(String value) {
        this.identificador = value;
    }

    /**
     * Obtiene el valor de la propiedad indice.
     * 
     */
    public int getIndice() {
        return indice;
    }

    /**
     * Define el valor de la propiedad indice.
     * 
     */
    public void setIndice(int value) {
        this.indice = value;
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
     * Obtiene el valor de la propiedad lecturaAnterior.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLecturaAnterior() {
        return lecturaAnterior;
    }

    /**
     * Define el valor de la propiedad lecturaAnterior.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLecturaAnterior(String value) {
        this.lecturaAnterior = value;
    }

    /**
     * Obtiene el valor de la propiedad lecturaMaxima.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLecturaMaxima() {
        return lecturaMaxima;
    }

    /**
     * Define el valor de la propiedad lecturaMaxima.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLecturaMaxima(String value) {
        this.lecturaMaxima = value;
    }

    /**
     * Obtiene el valor de la propiedad lecturaMinima.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLecturaMinima() {
        return lecturaMinima;
    }

    /**
     * Define el valor de la propiedad lecturaMinima.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLecturaMinima(String value) {
        this.lecturaMinima = value;
    }

    /**
     * Obtiene el valor de la propiedad marca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define el valor de la propiedad marca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarca(String value) {
        this.marca = value;
    }

    /**
     * Obtiene el valor de la propiedad material.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Define el valor de la propiedad material.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterial(String value) {
        this.material = value;
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
     * Obtiene el valor de la propiedad motivoLectura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoLectura() {
        return motivoLectura;
    }

    /**
     * Define el valor de la propiedad motivoLectura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoLectura(String value) {
        this.motivoLectura = value;
    }

    /**
     * Obtiene el valor de la propiedad mru.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMru() {
        return mru;
    }

    /**
     * Define el valor de la propiedad mru.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMru(String value) {
        this.mru = value;
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
     * Obtiene el valor de la propiedad nota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNota() {
        return nota;
    }

    /**
     * Define el valor de la propiedad nota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNota(String value) {
        this.nota = value;
    }

    /**
     * Obtiene el valor de la propiedad numerador.
     * 
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Define el valor de la propiedad numerador.
     * 
     */
    public void setNumerador(int value) {
        this.numerador = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroCasa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * Define el valor de la propiedad numeroCasa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCasa(String value) {
        this.numeroCasa = value;
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
     * Obtiene el valor de la propiedad numerohabitacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerohabitacion() {
        return numerohabitacion;
    }

    /**
     * Define el valor de la propiedad numerohabitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerohabitacion(String value) {
        this.numerohabitacion = value;
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
     * Obtiene el valor de la propiedad poblacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Define el valor de la propiedad poblacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoblacion(String value) {
        this.poblacion = value;
    }

    /**
     * Obtiene el valor de la propiedad porcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPorcion() {
        return porcion;
    }

    /**
     * Define el valor de la propiedad porcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPorcion(String value) {
        this.porcion = value;
    }

    /**
     * Obtiene el valor de la propiedad region.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Define el valor de la propiedad region.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
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
     */
    public int getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     */
    public void setSecuencia(int value) {
        this.secuencia = value;
    }

    /**
     * Obtiene el valor de la propiedad suplemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuplemento() {
        return suplemento;
    }

    /**
     * Define el valor de la propiedad suplemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuplemento(String value) {
        this.suplemento = value;
    }

    /**
     * Obtiene el valor de la propiedad tarifa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * Define el valor de la propiedad tarifa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarifa(String value) {
        this.tarifa = value;
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
     * Obtiene el valor de la propiedad usuarioIngreso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    /**
     * Define el valor de la propiedad usuarioIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioIngreso(String value) {
        this.usuarioIngreso = value;
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
