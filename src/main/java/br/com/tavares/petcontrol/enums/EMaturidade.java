package br.com.tavares.petcontrol.enums;

public enum EMaturidade {	

		FILHOTE(0,"Filhote"),ADULTO(1,"Adulto"), IDOSO(2,"Idoso");

		private final int index;
		private final String desc;

		EMaturidade(int index, String desc) {			
			this.index = index;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public int getIndex() {
			return index;
		}				
				
       public static EMaturidade returnEnumValueFromDesc(String desc){
			
			for (EMaturidade item : values()) {
				if (item.getDesc().equalsIgnoreCase(desc)){
					return item; 	
				}
			}
			return null;
		}
       
       public static EMaturidade returnEnumValueFromIndex(int index){
			
			for (EMaturidade item : values()) {
				if (item.getIndex() == index){
					return item; 	
				}
			}
			return null;
		}
	}

