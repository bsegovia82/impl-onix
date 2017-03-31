package com.onix.modulo.eao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import com.onix.modulo.ConstantesServicio;
import com.onix.modulo.librerias.dominio.entidades.IEntidadPersistible;
import com.onix.modulo.librerias.eao.GenericEAO;

public abstract class OnixEAO<T extends IEntidadPersistible<Id>, Id extends Serializable> 
extends GenericEAO<T, Id>
{
	@PersistenceContext(unitName=ConstantesServicio.NOMBRE_UNIDAD_PERSISTENCIA)
	protected EntityManager adminEntidad;
	
	public EntityManager getAdminEntidad() {
		return adminEntidad;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(Class<T> clase) {
        javax.persistence.criteria.CriteriaQuery cq = getAdminEntidad().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return getAdminEntidad().createQuery(cq).getResultList();
    }
	
	public void create(T entity) {
        super.insertar(entity);
    }

    public void edit(T entity) {
       super.actualizar(entity);
    }

    public void remove(T entity) {
       super.eliminar(entity);
    }

    public T find(Id id, Class<T> clase) {
        return super.obtenerObjetoPorPk(id, clase);
    }
    
    public int count(Class<T> clase) {
        CriteriaQuery<Object> cq = getAdminEntidad().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(clase);
        cq.select(getAdminEntidad().getCriteriaBuilder().count(rt));
        return ((Long) getAdminEntidad().createQuery(cq).getSingleResult()).intValue();
    }
	
}
