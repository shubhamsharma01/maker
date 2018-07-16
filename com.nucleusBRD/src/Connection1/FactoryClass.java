package Connection1;

import com.sun.corba.se.pept.transport.Connection;

public class FactoryClass 
{
	public ConnectionInterface factoryMethod(String type){
		if(type.equalsIgnoreCase("oracle")){
			return new ConnectionClass();
		}
		return null;
	}

}
