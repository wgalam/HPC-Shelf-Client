//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.19 às 07:42:25 PM BRT 
//


package br.ufc.storm.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.storm.jaxb package. 
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

    private final static QName _ContextContract_QNAME = new QName("http://storm.lia.ufc.br", "context_contract");
    private final static QName _CandidateList_QNAME = new QName("http://storm.lia.ufc.br", "candidateList");
    private final static QName _AbstractComponent_QNAME = new QName("http://storm.lia.ufc.br", "abstract_component");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.storm.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ContextContract }
     * 
     */
    public ContextContract createContextContract() {
        return new ContextContract();
    }

    /**
     * Create an instance of {@link CandidateListType }
     * 
     */
    public CandidateListType createCandidateListType() {
        return new CandidateListType();
    }

    /**
     * Create an instance of {@link AbstractComponentType }
     * 
     */
    public AbstractComponentType createAbstractComponentType() {
        return new AbstractComponentType();
    }

    /**
     * Create an instance of {@link AbstractUnitType }
     * 
     */
    public AbstractUnitType createAbstractUnitType() {
        return new AbstractUnitType();
    }

    /**
     * Create an instance of {@link QualityArgumentType }
     * 
     */
    public QualityArgumentType createQualityArgumentType() {
        return new QualityArgumentType();
    }

    /**
     * Create an instance of {@link PlatformProfileType }
     * 
     */
    public PlatformProfileType createPlatformProfileType() {
        return new PlatformProfileType();
    }

    /**
     * Create an instance of {@link QualityFunctionType }
     * 
     */
    public QualityFunctionType createQualityFunctionType() {
        return new QualityFunctionType();
    }

    /**
     * Create an instance of {@link CostParameterType }
     * 
     */
    public CostParameterType createCostParameterType() {
        return new CostParameterType();
    }

    /**
     * Create an instance of {@link RankingFunctionTermType }
     * 
     */
    public RankingFunctionTermType createRankingFunctionTermType() {
        return new RankingFunctionTermType();
    }

    /**
     * Create an instance of {@link ContextParameterType }
     * 
     */
    public ContextParameterType createContextParameterType() {
        return new ContextParameterType();
    }

    /**
     * Create an instance of {@link CostFunctionTermType }
     * 
     */
    public CostFunctionTermType createCostFunctionTermType() {
        return new CostFunctionTermType();
    }

    /**
     * Create an instance of {@link QualityFunctionTermType }
     * 
     */
    public QualityFunctionTermType createQualityFunctionTermType() {
        return new QualityFunctionTermType();
    }

    /**
     * Create an instance of {@link SliceType }
     * 
     */
    public SliceType createSliceType() {
        return new SliceType();
    }

    /**
     * Create an instance of {@link QualityParameterType }
     * 
     */
    public QualityParameterType createQualityParameterType() {
        return new QualityParameterType();
    }

    /**
     * Create an instance of {@link ContextArgumentType }
     * 
     */
    public ContextArgumentType createContextArgumentType() {
        return new ContextArgumentType();
    }

    /**
     * Create an instance of {@link RankingFunctionType }
     * 
     */
    public RankingFunctionType createRankingFunctionType() {
        return new RankingFunctionType();
    }

    /**
     * Create an instance of {@link ConcreteComponentType }
     * 
     */
    public ConcreteComponentType createConcreteComponentType() {
        return new ConcreteComponentType();
    }

    /**
     * Create an instance of {@link CostFunctionType }
     * 
     */
    public CostFunctionType createCostFunctionType() {
        return new CostFunctionType();
    }

    /**
     * Create an instance of {@link CostArgumentType }
     * 
     */
    public CostArgumentType createCostArgumentType() {
        return new CostArgumentType();
    }

    /**
     * Create an instance of {@link RankingParameterType }
     * 
     */
    public RankingParameterType createRankingParameterType() {
        return new RankingParameterType();
    }

    /**
     * Create an instance of {@link RankingArgumentType }
     * 
     */
    public RankingArgumentType createRankingArgumentType() {
        return new RankingArgumentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContextContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://storm.lia.ufc.br", name = "context_contract")
    public JAXBElement<ContextContract> createContextContract(ContextContract value) {
        return new JAXBElement<ContextContract>(_ContextContract_QNAME, ContextContract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CandidateListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://storm.lia.ufc.br", name = "candidateList")
    public JAXBElement<CandidateListType> createCandidateList(CandidateListType value) {
        return new JAXBElement<CandidateListType>(_CandidateList_QNAME, CandidateListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractComponentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://storm.lia.ufc.br", name = "abstract_component")
    public JAXBElement<AbstractComponentType> createAbstractComponent(AbstractComponentType value) {
        return new JAXBElement<AbstractComponentType>(_AbstractComponent_QNAME, AbstractComponentType.class, null, value);
    }

}
