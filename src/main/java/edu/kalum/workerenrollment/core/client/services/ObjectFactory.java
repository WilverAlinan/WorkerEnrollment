
package edu.kalum.workerenrollment.core.client.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.kalum.workerenrollment.core.client.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnrollmentProcess_QNAME = new QName("http://beans.core.enrollment.kalum.edu/", "enrollmentProcess");
    private final static QName _EnrollmentProcessResponse_QNAME = new QName("http://beans.core.enrollment.kalum.edu/", "enrollmentProcessResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.kalum.workerenrollment.core.client.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnrollmentProcess }
     * 
     */
    public EnrollmentProcess createEnrollmentProcess() {
        return new EnrollmentProcess();
    }

    /**
     * Create an instance of {@link EnrollmentProcessResponse }
     * 
     */
    public EnrollmentProcessResponse createEnrollmentProcessResponse() {
        return new EnrollmentProcessResponse();
    }

    /**
     * Create an instance of {@link EnrollmentRequest }
     * 
     */
    public EnrollmentRequest createEnrollmentRequest() {
        return new EnrollmentRequest();
    }

    /**
     * Create an instance of {@link EnrollmentResponse }
     * 
     */
    public EnrollmentResponse createEnrollmentResponse() {
        return new EnrollmentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnrollmentProcess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.core.enrollment.kalum.edu/", name = "enrollmentProcess")
    public JAXBElement<EnrollmentProcess> createEnrollmentProcess(EnrollmentProcess value) {
        return new JAXBElement<EnrollmentProcess>(_EnrollmentProcess_QNAME, EnrollmentProcess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnrollmentProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.core.enrollment.kalum.edu/", name = "enrollmentProcessResponse")
    public JAXBElement<EnrollmentProcessResponse> createEnrollmentProcessResponse(EnrollmentProcessResponse value) {
        return new JAXBElement<EnrollmentProcessResponse>(_EnrollmentProcessResponse_QNAME, EnrollmentProcessResponse.class, null, value);
    }

}
