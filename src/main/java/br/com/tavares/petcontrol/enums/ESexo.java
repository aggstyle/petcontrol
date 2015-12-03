package br.com.tavares.petcontrol.enums;

public enum ESexo {	

		N_INFORMADO(0,"N","Não Informado"),MASCULINO(1,"M","Masculino"), FEMININO(2,"F","Feminino");

		private final int index;
		private final String sigla;
		private final String desc;

		ESexo(int index, String sigla, String desc) {			
			this.index = index;
			this.sigla = sigla;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public int getIndex() {
			return index;
		}
		
		public String getSigla() {
			return sigla;
		}
		
		public static ESexo returnEnumValueFromSigla(String sigla){
			
			for (ESexo item : values()) {
				if (item.getSigla().equalsIgnoreCase(sigla)){
					return item; 	
				}
			}
			return null;
		}
		
		
		
       public static ESexo returnEnumValueFromDesc(String desc){
			
			for (ESexo item : values()) {
				if (item.getDesc().equalsIgnoreCase(desc)){
					return item; 	
				}
			}
			return null;
		}
       
       public static ESexo returnEnumValueFromIndex(int index){
			
			for (ESexo item : values()) {
				if (item.getIndex() == index){
					return item; 	
				}
			}
			return null;
		}
	}

