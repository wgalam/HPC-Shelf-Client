package br.ufc.storm.export;


import br.ufc.storm.jaxb.AbstractComponentType;
import br.ufc.storm.jaxb.CalculatedArgumentType;
import br.ufc.storm.jaxb.CalculatedParameterType;
import br.ufc.storm.jaxb.ContextArgumentType;
import br.ufc.storm.jaxb.ContextContract;
import br.ufc.storm.jaxb.ContextParameterType;

public class FormalFormat {

//	public static String exportComponentSignature(AbstractComponentType ac, String space){
//		
//		String str = "";
//		if(space == null){
//			space="    ";
//		}else{
//			space+="    ";
//		}
//		str+=ac.getName()+"=[";
//		for(ContextParameterType cp: ac.getContextParameter()){
//			if(cp.getBound()!= null){
//				try {
//					if(cp.getBound().getCcName().equals("DATA")){
//						str+="\n"+space+cp.getName()+" : "+cp.getBound().getCcName()+",";
//					}else{
//						str+="\n"+space+cp.getName()+" : "+cp.getBound().getCcName()+" ["+exportComponentSignature(AbstractComponentHandler.getAbstractComponentFromContextContractID(cp.getBound().getCcId()), ""+space)+"],";
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else{
//				str+="\n"+space+cp.getName()+" : "+cp.getBoundValue()+",";
//			}
//		}
//		for(CalculatedParameterType cp: ac.getQualityParameters()){
//			str+="\n"+space+cp.getName()+" : DATA(Quality)";
//		}
//		for(CalculatedParameterType cp: ac.getCostParameters()){
//			str+="\n"+space+cp.getName()+" : DATA(Cost)";
//		}
//		for(CalculatedParameterType cp: ac.getRankingParameters()){
//			str+="\n"+space+cp.getName()+" : DATA(Ranking)";
//		}
//		str+="]";
//		return str;
//	}
//
//	
//	
	
	

	public static String exportContextContract(ContextContract cc, String space){
		if(space == null){
			space="    ";
		}else{
			space+="    ";
		}
		String str = "";
		AbstractComponentType ac = cc.getAbstractComponent();
		str+=cc.getCcName()+"[";
		for(ContextParameterType cp: ac.getContextParameter()){
			for(ContextArgumentType ca : cc.getContextArgumentsProvided()){
				if(cp.getCpId()==ca.getCpId()){
					if(ca.getContextContract()!=null){
						str+="\n"+space+cp.getName()+" = "+exportContextContract(ca.getContextContract(),space+"")+",";
					}else{
						if(ca.getValue()!= null){
							str+="\n"+space+cp.getName()+" = "+ca.getValue().getValue()+",";
						}else{
							if(ca.getCpId()!= null){
								//Definir comportamento
							}
						}
					}
				}
			}
		}
		if(cc.getPlatform()!=null){
			str+="\n"+space+"PLATFORM: = "+exportContextContract(cc.getPlatform().getPlatformContract(),space+"")+",";
		}
		for(CalculatedParameterType cp: ac.getQualityParameters()){
//			str+="\n"+space+cp.getName()+" = ";
			for(CalculatedArgumentType c : cc.getQualityArguments()){
				if(c.getCalcId()==cp.getCalcId()){
					str+="\n"+space+cp.getName()+" = "+c.getValue();//terminar
				}
			}
		}
		for(CalculatedParameterType cp: ac.getCostParameters()){
//			str+="\n"+space+cp.getName()+" = ";
			for(CalculatedArgumentType c : cc.getCostArguments()){
				if(c.getCalcId()==cp.getCalcId()){
					str+="\n"+space+cp.getName()+" = "+c.getValue();//terminar
				}
			}
		}
		for(CalculatedParameterType cp: ac.getRankingParameters()){
//			str+="\n"+space+cp.getName()+" = ";
			for(CalculatedArgumentType c : cc.getRankingArguments()){
				if(c.getCalcId()==cp.getCalcId()){
					str+="\n"+space+cp.getName()+" = "+c.getValue();//terminar
				}
			}
		}
		
		str+="]";
		return str;
	}
}
