package br.ufc.storm.core;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.axis2.AxisFault;
import org.xml.sax.InputSource;

import br.ufc.storm.export.FormalFormat;
import br.ufc.storm.jaxb.CandidateListType;
import br.ufc.storm.jaxb.ComputationalSystemType;
import br.ufc.storm.jaxb.ContextArgumentType;
import br.ufc.storm.jaxb.ContextContract;
import br.ufc.storm.jaxb.ContextParameterType;
import br.ufc.storm.jaxb.ObjectFactory;
import br.ufc.storm.webservices.CoreServicesDBHandlerExceptionException;
import br.ufc.storm.webservices.CoreServicesIOExceptionException;
import br.ufc.storm.webservices.CoreServicesParserConfigurationExceptionException;
import br.ufc.storm.webservices.CoreServicesSAXExceptionException;
import br.ufc.storm.webservices.CoreServicesStub;
import br.ufc.storm.webservices.CoreServicesStub.AddAbstractComponentResponse;
import br.ufc.storm.webservices.CoreServicesStub.AddContextParameterResponse;
import br.ufc.storm.webservices.CoreServicesStub.AddInnerComponentResponse;
import br.ufc.storm.webservices.CoreServicesStub.AddUnitFileResponse;
import br.ufc.storm.webservices.CoreServicesStub.ConvertContextContractResponse;
import br.ufc.storm.webservices.CoreServicesStub.DeployResponse;
import br.ufc.storm.webservices.CoreServicesStub.ExportComponentSignatureResponse;
import br.ufc.storm.webservices.CoreServicesStub.ExportContextContractResponse;
import br.ufc.storm.webservices.CoreServicesStub.GetAbstractComponentResponse;
import br.ufc.storm.webservices.CoreServicesStub.GetContextContractResponse;
import br.ufc.storm.webservices.CoreServicesStub.GetContextParameterResponse;
import br.ufc.storm.webservices.CoreServicesStub.InstantiateResponse;
import br.ufc.storm.webservices.CoreServicesStub.ListContractResponse;
import br.ufc.storm.webservices.CoreServicesStub.ListResponse;
import br.ufc.storm.webservices.CoreServicesStub.ReleasePlatformResponse;
import br.ufc.storm.webservices.CoreServicesStub.ResolveResponse;
import br.ufc.storm.webservices.CoreServicesStub.SortCandidatesResponse;
import br.ufc.storm.xml.XMLHandler;

public class CoreServiceConsumer {

	static final String server = "http://storm.lia.ufc.br:8080/axis2/services/CoreServices.CoreServicesHttpSoap12Endpoint/";
	
	public static void main(String[] args) {
		//String str = getContextContract(128);
		//String out = contextContractToString(str);
		//System.out.println(exportContextContract(127));
		//System.out.println(exportComponentSignature(19));
		//System.out.println(getAbstractComponent("MatrixMultiplication"));

		
//		System.out.println(registerAbstractComponent("XML/testeAllyson.xml"));
//		System.out.println(listComponents());
		
		
			long tempoInicial = System.currentTimeMillis();
			String str = resolve("XML/MatrixMultiplicationBasic.xml");
			long tempoFinal = System.currentTimeMillis();
			System.out.printf("Tempo de Resolução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
			tempoInicial = System.currentTimeMillis();
			String str2 = sortCandidates(str, 3);
			tempoFinal = System.currentTimeMillis();
			System.out.printf("Tempo de Reordenação: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
			try {
				CandidateListType cl = XMLHandler.getCandidateList(str2);
				
				for(ContextContract cc : cl.getCandidate()){
					System.out.println(exportContextContract(cc));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		 
			
			
			//			FileHandler.toHardDisk("/home/wagner/Downloads/resolve_06_06_2016-16-50.xml", str.getBytes());
		 
		 

//		
	}
	
	
	public static String contextContractToString(String in){
		JAXBContext context;
		ContextContract cc = null;
		try {
			context = JAXBContext.newInstance(br.ufc.storm.jaxb.ObjectFactory.class.getPackage().getName(),
					br.ufc.storm.jaxb.ObjectFactory.class.getClassLoader());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<ContextContract> element = (JAXBElement<ContextContract>) unmarshaller.unmarshal(new InputSource(new java.io.StringReader(in)));
			cc = element.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toString(null,cc);
	}


	public static String toString(String pre, ContextContract cc){
			String out = "";
			if(pre==null){
				pre ="";
				out+= pre+cc.getCcName()+":"+cc.getCcId()+"\n";
			}
//			System.out.println(cc.getContextArguments().size()+":"+cc.getAbstractComponent().getContextParameter().size());
			for(ContextArgumentType cat: cc.getContextArgumentsProvided()){
//				System.out.println(cat.getCcId());
				for(ContextParameterType cpt: cc.getAbstractComponent().getContextParameter()){
//					System.out.println(cat.getVariableCpId()+":"+cpt.getCpId());
					if(cat.getCpId() == cpt.getCpId()){
						if(cat.getContextContract()!=null){
							out+=pre+cpt.getCpId()+":"+cpt.getName()+": "+cat.getContextContract().getCcName()+"\n";
//							System.out.println(cat.getContextContract().getCcName()+":"+cat.getContextContract().getContextArguments().size());
							out+=toString(pre+"*",cat.getContextContract());
						}else{
							if(cat.getValue()!=null){
			 					out+= pre+cpt.getCpId()+":"+cpt.getName()+": "+cat.getValue().getValue()+"\n";
							}else{
								
							}
							//incomplete
						}
						
					}
				}
			}
			return out;
		}


	public static void main2(String [] args){
		System.out.println("########RESOLVING##########");
		String str = resolve("MatrixMultiplicationBasic.xml");
//		String str = resolve("XML/mImgTblSW.xml");
		System.out.println(str);
		String computational = deploy(str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#######DEPLOYING###########");
		System.out.println(computational);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#######INSTANTIATING###########");
		System.out.println(instantiate(computational));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#######DESTROYING###########");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(releasePlatform(computational));
	}

	public static String resolve(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.Resolve request;
		request = new CoreServicesStub.Resolve();
		request.setCmp(str);
		//Invoca o servico
		ResolveResponse response = null;
		try {
			response = stub.resolve(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static String sortCandidates(String str, int i){	
			CoreServicesStub stub = null;
			try {
				stub = new CoreServicesStub(server);
			} catch (AxisFault e1) {
				e1.printStackTrace();
			}
			//Cria a requisicao para o servico
			CoreServicesStub.SortCandidates request;
			request = new CoreServicesStub.SortCandidates();
			request.setCandidateList(str);
			request.setI(i);
			//Invoca o servico
			SortCandidatesResponse response = null;
			try {
				response = stub.sortCandidates(request);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return response.get_return();
		}
	
	
	public static String deploy(String str){
//		
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.Deploy request;
		request = new CoreServicesStub.Deploy();
		request.setCandidateList(str);
//		setCmp(str);
		//Invoca o servico
		DeployResponse response = null;
		try {
			response = stub.deploy(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	
	public static String instantiate(String str){
//		
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.Instantiate request;
		request = new CoreServicesStub.Instantiate();
		request.setCst(str);
		//Invoca o servico
		InstantiateResponse response = null;
		try {
			response = stub.instantiate(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	
	public static boolean releasePlatform(String str){
//		
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.ReleasePlatform request;
		request = new CoreServicesStub.ReleasePlatform();
		request.setCst(str);
		//Invoca o servico
		ReleasePlatformResponse response = null;
		try {
			response = stub.releasePlatform(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	private static boolean registerIC(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddInnerComponent request;
		request = new CoreServicesStub.AddInnerComponent();
		request.setCmp(str);
		//Invoca o servico
		AddInnerComponentResponse response = null;
		try {
			response = stub.addInnerComponent(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}

	public static boolean registerUnitFile(String path, String filename){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		CoreServicesStub.AddUnitFile request;
		request = new CoreServicesStub.AddUnitFile();
		javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
		javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
		request.setData(dh);
		request.setXml(filename);
		AddUnitFileResponse response = null;		
		try {
			response = stub.addUnitFile(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(response.get_return()){
			return true;
		}else{
			return false;
		}
	}
	private static boolean register_context_parameter(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddContextParameter request;
		request = new CoreServicesStub.AddContextParameter();
		request.setCmp(str);
		//Invoca o servico
		AddContextParameterResponse response = null;
		try {
			response = stub.addContextParameter(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}

	/*private static boolean register_context_argument(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddContextArgument request;
		request = new CoreServicesStub.AddContextArgument();
		request.setCmp(str);
		//Invoca o servico
		AddContextArgumentResponse response = null;
		try {
			try {
				response = stub.addContextArgument(request);
			} catch (CoreServicesParserConfigurationExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesSAXExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesIOExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}*/

	private static String readFile(String pathname) throws IOException {

		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");
		try {
			while(scanner.hasNextLine()) {        
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	}

	public static String listComponents(){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.List request;
		request = new CoreServicesStub.List();
		//Invoca o servico
		ListResponse response = null;
		try {
			response = stub.list(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	
	public static String listComponentslocal(){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub(server);
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.List request;
		request = new CoreServicesStub.List();
		//Invoca o servico
		ListResponse response = null;
		try {
			response = stub.list(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	
	public static String listContextContract(int ac_id){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.ListContract request;
		request = new CoreServicesStub.ListContract();
		request.setAc_id(ac_id);
		//Invoca o servico
		ListContractResponse response = null;
		try {
			try {
				response = stub.listContract(request);
			} catch (CoreServicesDBHandlerExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	

	public static String getAbstractComponent(String str){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetAbstractComponent request;
		request = new CoreServicesStub.GetAbstractComponent();
		request.setName(str);
		//Invoca o servico
		GetAbstractComponentResponse response = null;

		try {
			response = stub.getAbstractComponent(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static String getContextParameter(String str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextParameter request;
		request = new CoreServicesStub.GetContextParameter();
		request.setName(str);
		//Invoca o servico
		GetContextParameterResponse response = null;

		try {
			response = stub.getContextParameter(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static String getContextContract(int str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();		
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextContract request;
		request = new CoreServicesStub.GetContextContract();
		request.setId(str);
		//Invoca o servico
		GetContextContractResponse response = null;

		try {
			response = stub.getContextContract(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}



		//		String st = new String(response.get_return());
		return response.get_return().toString();
	}
	
	public static String exportContextContract(ContextContract cc){
		String str;
		JAXBContext context;
		java.io.StringWriter sw = new StringWriter();
		try {
			context = JAXBContext.newInstance(br.ufc.storm.jaxb.ObjectFactory.class.getPackage().getName(),
					br.ufc.storm.jaxb.ObjectFactory.class.getClassLoader());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			JAXBElement<ContextContract> element = new ObjectFactory().createContextContract(cc);
			marshaller.marshal(element, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		str = sw.toString();
		
		
		
		
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();		
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.ConvertContextContract request;
		request = new CoreServicesStub.ConvertContextContract();
		request.setCmp(str);
		//Invoca o servico
		ConvertContextContractResponse response = null;

		try {
			response = stub.convertContextContract(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return().toString();
	}
	
	public static String exportComponentSignature(int str){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();		
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.ExportComponentSignature request;
		request = new CoreServicesStub.ExportComponentSignature();
		request.setAc_id(str);
		//Invoca o servico
		ExportComponentSignatureResponse response = null;

		try {
			response = stub.exportComponentSignature(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}



		//		String st = new String(response.get_return());
		return response.get_return().toString();
	}

	/*public static String getContextArgument(String str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextArgument request;
		request = new CoreServicesStub.GetContextArgument();
		request.setName(str);
		//Invoca o servico
		GetContextArgumentResponse response = null;

		try {
			response = stub.getContextArgument(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}*/


	public static boolean registerAbstractComponent(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(str);
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddAbstractComponent request;
		request = new CoreServicesStub.AddAbstractComponent();
		request.setCmp(str);
		//Invoca o servico
		AddAbstractComponentResponse response = null;
		try {
			try {
				try {
					response = stub.addAbstractComponent(request);
				} catch (CoreServicesDBHandlerExceptionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (CoreServicesParserConfigurationExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesSAXExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesIOExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	/*public static boolean registerIT(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddInstantiationType request;
		request = new CoreServicesStub.AddInstantiationType();
		request.setCmp(str);
		//Invoca o servico
		AddInstantiationTypeResponse response = null;
		try {
			response = stub.addInstantiationType(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}*/
	/*public static int registerAU(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddAbstractUnit request;
		request = new CoreServicesStub.AddAbstractUnit();
		request.setCmp(str);
		//Invoca o servico
		AddAbstractUnitResponse response = null;
		try {
			response = stub.addAbstractUnit(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}*/


	/*	public static boolean registerUnitFile(String path, String filename){  //Delete after testing above code
			CoreServicesStub stub = null;
			try {
				stub = new CoreServicesStub();
			} catch (AxisFault e1) {
				e1.printStackTrace();
			}
			CoreServicesStub.AddUnitFile request;
			request = new CoreServicesStub.AddUnitFile();
			javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
			javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
			request.setData(dh);
			request.setFileName(filename);
			AddUnitFileResponse response = null;		
			try {
				response = stub.addUnitFile(request);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(response.get_return()){
				return true;
			}else{
				return false;
			}
	}
	 */

//	public static int registerCU(String str){
//		try {
//			str = readFile(str);
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		CoreServicesStub stub = null;
//		try {
//			stub = new CoreServicesStub();
//		} catch (AxisFault e1) {
//			e1.printStackTrace();
//		}
//		//Cria a requisicao para o servico
//		CoreServicesStub.AddConcreteUnit request;
//		request = new CoreServicesStub.AddConcreteUnit();
//		request.setCmp(str);
//		//Invoca o servico
//		AddConcreteUnitResponse response = null;
//		try {
//			response = stub.addConcreteUnit(request);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return response.get_return();
//	}
	private static boolean registerCUF(String str, String path) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddUnitFile request;
		request = new CoreServicesStub.AddUnitFile();
		javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
		javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
		request.setXml(str);
		request.setData(dh);

		//Invoca o servico
		AddUnitFileResponse response = null;
		try {
			response = stub.addUnitFile(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}


}



