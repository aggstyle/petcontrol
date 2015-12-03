package br.com.tavares.petcontrol.enums;

public enum EStatusAnimal {	

		N_INFORMADO(0,"N","Não Informado"),ADOTADO(1,"A","Adotado"), N_ADOTADO(2,"N","Não Adotado"), FALECIDO(3,"F","Falecido"), EM_PROCESSO(4,"E","Em processo de adoção");;

		private final int index;
		private final String sigla;
		private final String desc;

		EStatusAnimal(int index, String sigla, String desc) {			
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
		
		public static EStatusAnimal returnEnumValueFromSigla(String sigla){
			
			for (EStatusAnimal item : values()) {
				if (item.getSigla().equalsIgnoreCase(sigla)){
					return item; 	
				}
			}
			return null;
		}
		
       public static EStatusAnimal returnEnumValueFromDesc(String desc){
			
			for (EStatusAnimal item : values()) {
				if (item.getDesc().equalsIgnoreCase(desc)){
					return item; 	
				}
			}
			return null;
		}
       
       public static EStatusAnimal returnEnumValueFromIndex(int index){
			
			for (EStatusAnimal item : values()) {
				if (item.getIndex() == index){
					return item; 	
				}
			}
			return null;
		}
	}

