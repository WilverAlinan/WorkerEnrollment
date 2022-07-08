
package edu.kalum.workerenrollment.core.client.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enrollmentRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="enrollmentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carreraId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ciclo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mesInicioPago" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="noExpediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrollmentRequest", propOrder = {
    "carreraId",
    "ciclo",
    "mesInicioPago",
    "noExpediente"
})
public class EnrollmentRequest {

    protected String carreraId;
    protected String ciclo;
    protected int mesInicioPago;
    protected String noExpediente;

    /**
     * Obtiene el valor de la propiedad carreraId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarreraId() {
        return carreraId;
    }

    /**
     * Define el valor de la propiedad carreraId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarreraId(String value) {
        this.carreraId = value;
    }

    /**
     * Obtiene el valor de la propiedad ciclo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * Define el valor de la propiedad ciclo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiclo(String value) {
        this.ciclo = value;
    }

    /**
     * Obtiene el valor de la propiedad mesInicioPago.
     * 
     */
    public int getMesInicioPago() {
        return mesInicioPago;
    }

    /**
     * Define el valor de la propiedad mesInicioPago.
     * 
     */
    public void setMesInicioPago(int value) {
        this.mesInicioPago = value;
    }

    /**
     * Obtiene el valor de la propiedad noExpediente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoExpediente() {
        return noExpediente;
    }

    /**
     * Define el valor de la propiedad noExpediente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoExpediente(String value) {
        this.noExpediente = value;
    }

}
