
package sicore.medidores.servicios.ifc.medidores;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Medidores", targetNamespace = "http://medidores.ifc.servicios.medidores.sicore/", wsdlLocation = "http://186.3.217.195:7777/CortesServices/SICORE.Cortes.Service.Common.Medidores.svc?wsdl")
public class Medidores_Service
    extends Service
{

    private final static URL MEDIDORES_WSDL_LOCATION;
    private final static WebServiceException MEDIDORES_EXCEPTION;
    private final static QName MEDIDORES_QNAME = new QName("http://medidores.ifc.servicios.medidores.sicore/", "Medidores");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://186.3.217.195:7777/CortesServices/SICORE.Cortes.Service.Common.Medidores.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MEDIDORES_WSDL_LOCATION = url;
        MEDIDORES_EXCEPTION = e;
    }

    public Medidores_Service() {
        super(__getWsdlLocation(), MEDIDORES_QNAME);
    }

    public Medidores_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEDIDORES_QNAME, features);
    }

    public Medidores_Service(URL wsdlLocation) {
        super(wsdlLocation, MEDIDORES_QNAME);
    }

    public Medidores_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEDIDORES_QNAME, features);
    }

    public Medidores_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Medidores_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Medidores
     */
    @WebEndpoint(name = "BasicHttpBinding_Medidores")
    public Medidores getBasicHttpBindingMedidores() {
        return super.getPort(new QName("http://medidores.ifc.servicios.medidores.sicore/", "BasicHttpBinding_Medidores"), Medidores.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Medidores
     */
    @WebEndpoint(name = "BasicHttpBinding_Medidores")
    public Medidores getBasicHttpBindingMedidores(WebServiceFeature... features) {
        return super.getPort(new QName("http://medidores.ifc.servicios.medidores.sicore/", "BasicHttpBinding_Medidores"), Medidores.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEDIDORES_EXCEPTION!= null) {
            throw MEDIDORES_EXCEPTION;
        }
        return MEDIDORES_WSDL_LOCATION;
    }

}