package com.onix.modulo.dominio.persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.empresa.OmseSucursalPersona;
import com.onix.modulo.dominio.localizacion.OmslPais;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMSG_PERSONAS")
public class OmsgPersona extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final Long ECUATORIANO = 1l;
	public static final String NUMERODOCUMENTO = "numeroDocumento";

	private String razonSocial;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private String genero;
	private String ocupacion;
	private String telefonoContacto;
	private String direccionPrincipal;

	private OmsgTipoDocumentoIdentificacion tipoDocumentoIdentificacion;
	private String numeroDocumento;

	private OmslPais pais;

	private List<OmsgTelefonoPersona> telefonos = new ArrayList<OmsgTelefonoPersona>();
	private List<OmsgDireccionPersona> direcciones = new ArrayList<OmsgDireccionPersona>();
	private String direccionCorreo;

	private OmsUsuario usuario;

	private List<OmseSucursalPersona> listaSucursales;
	
	@GeneratedValue(generator = "secPersona", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secPersona", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PERSONA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "ID_USUARIO", nullable = true)
	public OmsUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(OmsUsuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy = "persona")
	public List<OmsgTelefonoPersona> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<OmsgTelefonoPersona> telefonos) {
		this.telefonos = telefonos;
	}

	@OneToMany(mappedBy = "persona")
	public List<OmsgDireccionPersona> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<OmsgDireccionPersona> direcciones) {
		this.direcciones = direcciones;
	}

	@Transient
	public OmsgTelefonoPersona getTelefono(Long pIdTipoTelefono) {
		OmsgTelefonoPersona lTelefonoSeleccionado = null;
		for (OmsgTelefonoPersona lTelefono : getTelefonos()) {
			if (lTelefono.getTipoTelefono() != null && lTelefono.getTipoTelefono().getId().equals(pIdTipoTelefono)) {
				lTelefonoSeleccionado = lTelefono;
				break;
			}
		}
		return lTelefonoSeleccionado;
	}

	@Transient
	public OmsgDireccionPersona getDireccionPersona(Long pIdTipoDireccion) {
		OmsgDireccionPersona lDireccionPersonaSeleccionada = null;
		for (OmsgDireccionPersona lDireccionPersona : getDirecciones()) {
			if (lDireccionPersona.getTipoDireccion() != null
					&& lDireccionPersona.getTipoDireccion().getId().equals(pIdTipoDireccion)) {
				lDireccionPersonaSeleccionada = lDireccionPersona;
				break;
			}
		}
		return lDireccionPersonaSeleccionada;
	}

	public boolean removerTelefono(Long pIdTipoTelefono) {
		for (OmsgTelefonoPersona lTelefono : getTelefonos()) {
			if (lTelefono.getTipoTelefono() != null && lTelefono.getTipoTelefono().getId().equals(pIdTipoTelefono)) {
				return getTelefonos().remove(lTelefono);
			}
		}
		return false;
	}

	public boolean removerDireccion(Long pIdTipoDireccion) {
		for (OmsgDireccionPersona lDireccionPersona : getDirecciones()) {
			if (lDireccionPersona.getTipoDireccion() != null
					&& lDireccionPersona.getTipoDireccion().getId().equals(pIdTipoDireccion)) {
				return getDirecciones().remove(lDireccionPersona);
			}
		}
		return false;
	}

	public void asociarRemoverPersonaTelefono(OmsgTipoTelefono pTipoTelefono, String pNumeroTelefono) {
		Long pIdTipoTelefono = pTipoTelefono.getId();
		if (pNumeroTelefono != null && !pNumeroTelefono.trim().equals("")) {
			OmsgTelefonoPersona lTelefono = this.getTelefono(pIdTipoTelefono);
			if (lTelefono == null) {
				lTelefono = new OmsgTelefonoPersona();
				lTelefono.setTipoTelefono(pTipoTelefono);
				lTelefono.setPersona(this);
				this.getTelefonos().add(lTelefono);
			}
			lTelefono.setNumero(pNumeroTelefono);
		} else
			this.removerTelefono(pIdTipoTelefono);
	}

	public void asociarRemoverPersonaDireccion(OmsgTipoDireccion pTipoDireccion, OmsgDireccionPersona pDireccionPersona) {
		removerDireccion(pTipoDireccion.getId());
		// Si la direccion es valida
		if (pDireccionPersona != null && pDireccionPersona.getDireccion() != null
				&& !pDireccionPersona.getDireccion().trim().equals("") && pDireccionPersona.getCanton() != null
				&& pDireccionPersona.getCanton().getId() != null) {
			pDireccionPersona.setTipoDireccion(pTipoDireccion);
			this.getDirecciones().add(pDireccionPersona);
			pDireccionPersona.setPersona(this);
		}
	}

	// public void asociarRemoverNacionalidadOriginaria(OmslPais pPais){
	// OmsgNacionalidad lNacionalidad=getNacionalidadOriginaria();
	// if(pPais!=null){
	// if(lNacionalidad!=null){
	// lNacionalidad.setPais(pPais);
	// pPais.getNacionalidades().add(lNacionalidad);
	// }
	// else{
	// lNacionalidad=new OmsgNacionalidad();
	// lNacionalidad.setTipoNacionalidad(TipoNacionalidad.ORIGINARIA);
	//
	// lNacionalidad.setPais(pPais);
	// pPais.getNacionalidades().add(lNacionalidad);
	//
	// this.getNacionalidades().add(lNacionalidad);
	// lNacionalidad.setPersona(this);
	// }
	// }
	// }

	@Column(name = "DIRECCION_CORREO", nullable = true, length = 128)
	public String getDireccionCorreo() {
		return direccionCorreo;
	}

	public void setDireccionCorreo(String direccionCorreo) {
		if ("".equals(direccionCorreo))
			direccionCorreo = null;
		this.direccionCorreo = direccionCorreo;
	}

	@Column(name = "RAZON_SOCIAL", length = 128)
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "NOMBRES", length = 128)
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "APELLIDOS", length = 128)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", nullable = true)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "GENERO", nullable = true, length = 32)
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "OCUPACION", nullable = true)
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENT", nullable = false)
	public OmsgTipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}

	public void setTipoDocumentoIdentificacion(OmsgTipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}

	@Column(name = "NUMERO_DOCUMENTO", length = 128, nullable = false)
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PAIS", nullable = true)
	public OmslPais getPais() {
		return pais;
	}

	public void setPais(OmslPais pais) {
		this.pais = pais;
	}

	@Column(name = "TELEFONO_CONTACTO")
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	@Column(name = "TELEFONO_PRINCIPAL")
	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}
	
	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}
	
	@OneToMany(mappedBy="sucursal")
	public List<OmseSucursalPersona> getListaSucursales() {
		return listaSucursales;
	}
	
	public void setListaSucursales(List<OmseSucursalPersona> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}
}
