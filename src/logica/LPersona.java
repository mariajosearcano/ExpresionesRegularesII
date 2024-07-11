
package logica;

import bean.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LPersona {
    
    private ArrayList<Persona> arrayPersona;
    private Persona persona;


    public LPersona(ArrayList<Persona> arrayPersona, Persona persona) {
		super();
		this.arrayPersona = arrayPersona;
		this.persona = persona;
	}

	public LPersona() {
        arrayPersona = new ArrayList<>();
        persona= new Persona();
   
    }

  
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LPersona(ArrayList<Persona> arrayPersona) {
        this.arrayPersona = arrayPersona;
    }

    public ArrayList<Persona> getArrayPersona() {
        return arrayPersona;
    }

    public void setArrayPersona(ArrayList<Persona> arrayPersona) {
        this.arrayPersona = arrayPersona;
    }
    
    
    
    public boolean es(String cadena, String regex){
        return cadena.matches(regex);
    }
    
    public boolean esIgual(String cadena, String cadena2){
        return cadena.equals(cadena2);
    }
    
    public boolean error(boolean[] b){
        for(boolean b2 : b){
            if(!b2){
                return false;
            }
        }
        
        return true;
    }
    
    public void ingreso()
    {
    	arrayPersona.add(persona);
    	
    	persona= new Persona();
    
   
    }
    
    public String mostrar()
    {
    	String s="";
    	Iterator<Persona> iterador= arrayPersona.iterator();
    	while(iterador.hasNext())
    	{
    		Persona p= iterador.next();
    		s+="\n";
    		s+= p.toString();
    	}
    	return s;
    }
    
    public float otro() {
    	int cont =0;
    	Iterator<Persona> iterador= arrayPersona.iterator();
    	while(iterador.hasNext())
    	{
    		Persona p= iterador.next();
    		if(p.getNacionalidad().equals("Otro"))
    		{
    			cont++;
    		}
    	}
    	float p=(float)cont/arrayPersona.size();
    	return p*100;
    }
    
    public int[] tdoc()
    {
    	int cont[] = new int[2];
    	Iterator<Persona> iterador= arrayPersona.iterator();
    	while(iterador.hasNext())
    	{
    		Persona p= iterador.next();
    		if(p.getTipoid().equals("Cedula extranjera"))
    		{
    			cont[0]++;
    		}
    		if(p.getTipoid().equals("Pasaporte"))
    			cont[1]++;
    	}
    	return cont;
    }
    
}
