package br.com.tavares.petcontrol.enums;

public enum EBooleanStr {

	NAO(0, "Não", false),SIM(1, "Sim", true);

	private final int index;
	private final String desc;
	private final boolean boolValue;

	EBooleanStr(int index, String desc, boolean boolValue) {			
		this.index = index;
		this.desc = desc;
		this.boolValue = boolValue;
	}

	public String getDesc() {
		return desc;
	}

	public int getIndex() {
		return index;
	}				

	public boolean getBoolValue() {
		return boolValue;
	}		
	
   public static EBooleanStr returnEnumValueFromDesc(String desc){
		
		for (EBooleanStr item : values()) {
			if (item.getDesc().equalsIgnoreCase(desc)){
				return item; 	
			}
		}
		return null;
	}
   
   public static EBooleanStr returnEnumValueFromIndex(int index){
		
		for (EBooleanStr item : values()) {
			if (item.getIndex() == index){
				return item; 	
			}
		}
		return null;
	}
   
   public static EBooleanStr returnEnumValueFromBool(boolean Boolean){
		
		for (EBooleanStr item : values()) {
			if (item.getBoolValue() == Boolean){
				return item; 	
			}
		}
		return null;
	}  
}

