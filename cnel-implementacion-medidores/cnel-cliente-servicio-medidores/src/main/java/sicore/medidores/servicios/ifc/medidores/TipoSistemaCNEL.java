
package sicore.medidores.servicios.ifc.medidores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoSistemaCNEL.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoSistemaCNEL">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sieeq"/>
 *     &lt;enumeration value="Sap"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoSistemaCNEL")
@XmlEnum
public enum TipoSistemaCNEL {

    @XmlEnumValue("Sieeq")
    SIEEQ("Sieeq"),
    @XmlEnumValue("Sap")
    SAP("Sap");
    private final String value;

    TipoSistemaCNEL(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoSistemaCNEL fromValue(String v) {
        for (TipoSistemaCNEL c: TipoSistemaCNEL.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
