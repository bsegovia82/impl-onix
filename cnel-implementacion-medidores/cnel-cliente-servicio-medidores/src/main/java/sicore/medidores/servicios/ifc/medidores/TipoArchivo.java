
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoArchivo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoArchivo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Medidores"/>
 *     &lt;enumeration value="Perdidas"/>
 *     &lt;enumeration value="Cortes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoArchivo")
@XmlEnum
public enum TipoArchivo {

    @XmlEnumValue("Medidores")
    MEDIDORES("Medidores"),
    @XmlEnumValue("Perdidas")
    PERDIDAS("Perdidas"),
    @XmlEnumValue("Cortes")
    CORTES("Cortes");
    private final String value;

    TipoArchivo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoArchivo fromValue(String v) {
        for (TipoArchivo c: TipoArchivo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
