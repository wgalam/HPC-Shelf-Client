//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2014.11.21 às 06:18:39 PM BRT 
//


package br.ufc.storm.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de context_variable_type complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="context_variable_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="instantiation_type" type="{http://storm.lia.ufc.br}context_contract"/>
 *           &lt;element name="abstract_component" type="{http://storm.lia.ufc.br}abstract_component_type"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "context_variable_type", propOrder = {
    "instantiationType",
    "abstractComponent"
})
public class ContextVariableType {

    @XmlElement(name = "instantiation_type")
    protected ContextContract instantiationType;
    @XmlElement(name = "abstract_component")
    protected AbstractComponentType abstractComponent;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Obtém o valor da propriedade instantiationType.
     * 
     * @return
     *     possible object is
     *     {@link ContextContract }
     *     
     */
    public ContextContract getInstantiationType() {
        return instantiationType;
    }

    /**
     * Define o valor da propriedade instantiationType.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextContract }
     *     
     */
    public void setInstantiationType(ContextContract value) {
        this.instantiationType = value;
    }

    /**
     * Obtém o valor da propriedade abstractComponent.
     * 
     * @return
     *     possible object is
     *     {@link AbstractComponentType }
     *     
     */
    public AbstractComponentType getAbstractComponent() {
        return abstractComponent;
    }

    /**
     * Define o valor da propriedade abstractComponent.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractComponentType }
     *     
     */
    public void setAbstractComponent(AbstractComponentType value) {
        this.abstractComponent = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
