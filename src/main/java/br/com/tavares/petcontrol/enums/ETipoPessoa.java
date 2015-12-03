package br.com.tavares.petcontrol.enums;

public enum ETipoPessoa {	

		FISICA(0,"F","FISICA"), JURIDICA(1,"J","JURIDICA");

		private final int index;
		private final String sigla;
		private final String desc;

		ETipoPessoa(int index, String sigla, String desc) {			
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
		
		public static ETipoPessoa returnEnumValueFromSigla(String sigla){
			
			for (ETipoPessoa item : values()) {
				if (item.getSigla().equalsIgnoreCase(sigla)){
					return item; 	
				}
			}
			return null;
		}
		
       public static ETipoPessoa returnEnumValueFromDesc(String desc){
			
			for (ETipoPessoa item : values()) {
				if (item.getDesc().equalsIgnoreCase(desc)){
					return item; 	
				}
			}
			return null;
		}
       
       public static ETipoPessoa returnEnumValueFromIndex(int index){
			
			for (ETipoPessoa item : values()) {
				if (item.getIndex() == index){
					return item; 	
				}
			}
			return null;
		}
	}

