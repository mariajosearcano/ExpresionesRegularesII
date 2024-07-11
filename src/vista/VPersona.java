
package vista;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import logica.LPersona;

public class VPersona {
    
    private LPersona lpersona;
    private int cont;
    
    public LPersona getLpersona() {
		return lpersona;
	}

	public void setLpersona(LPersona lpersona) {
		this.lpersona = lpersona;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public VPersona() {
        lpersona = new LPersona();
        cont=0;
    }

    public VPersona(LPersona lformulario) {
        this.lpersona = lformulario;
    }

    public LPersona getLformulario() {
        return lpersona;
    }

    public void setLformulario(LPersona lformulario) {
        this.lpersona = lformulario;
    }
    
 
    
    public void formulario(){
        JTextField nombres = new JTextField(), apellidos = new JTextField(), documento = new JTextField(), celular = new JTextField(), correo = new JTextField(), correo2 = new JTextField(), contrasena = new JTextField(), contrasena2 = new JTextField();
        nombres.setTransferHandler(null);
        apellidos.setTransferHandler(null);
        documento.setTransferHandler(null);
        celular.setTransferHandler(null);
        correo.setTransferHandler(null);
        correo2.setTransferHandler(null);
        contrasena.setTransferHandler(null);
        contrasena2.setTransferHandler(null);
        JComboBox<String> tipoid = new JComboBox<>();
        tipoid.addItem("SELECCIONE");
        tipoid.addItem("Cedula de ciudadania");
        tipoid.addItem("Cedula extranjera");
        tipoid.addItem("Pasaporte");
        JComboBox<String> lugares = new JComboBox<>();
        lugares.addItem("BUSCAR");
        lugares.addItem("Antioquia");
        lugares.addItem("La Guajira");
        lugares.addItem("Cundinamarca");
        lugares.addItem("Putumayo");
        lugares.addItem("Quindio");
        lugares.addItem("Amazonas");
        lugares.addItem("Arauca");
        lugares.addItem("Santander");
        lugares.addItem("Casanare");
        lugares.addItem("Cordoba");
        lugares.addItem("Boyaca");
        JComboBox<String> nacionalidad = new JComboBox<>();
        nacionalidad.addItem("Colombiano (a)");
        nacionalidad.addItem("Otro");
        
        Object[] mensaje = {
            "Nombres", nombres,
            "Apellidos", apellidos,
            "Tipo de identificacion", tipoid,
            "Numero de documento", documento,
            "Lugar donde vives", lugares,
            "Numero celular", celular,
            "Nacionalidad", nacionalidad,
            "Correo electronico", correo,
            "Confirmar Correo electronico", correo2,
            "Contraseña", contrasena,
            "Confirmar Contraseña", contrasena2,
        };
       
        boolean[] b = new boolean[10];
        boolean f=false, o=false;
        String snombres = nombres.getText(), sapellidos = apellidos.getText(), stipoid = tipoid.getSelectedItem().toString(), sdocumento = documento.getText(), slugares = lugares.getSelectedItem().toString(), scelular = celular.getText(), snacionalidad = nacionalidad.getSelectedItem().toString(), scorreo = correo.getText(), scorreo2 = correo2.getText(), scontrasena = contrasena.getText(), scontrasena2 = contrasena2.getText();
        do{
            int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Formulario de registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            snombres = nombres.getText();
            sapellidos = apellidos.getText();
            stipoid = tipoid.getSelectedItem().toString();
            sdocumento = documento.getText();
            slugares = lugares.getSelectedItem().toString();
            scelular = celular.getText();
            snacionalidad = nacionalidad.getSelectedItem().toString();
            scorreo = correo.getText();
            scorreo2 = correo2.getText();
            scontrasena = contrasena.getText();
            scontrasena2 = contrasena2.getText();
            
            if(opcion == JOptionPane.OK_OPTION){
                b[0] = validacion(snombres, "^[A-ZÁÉÍÓÚ][a-záéíóú]+(\\s[A-ZÁÉÍÓÚ][a-záéíóú]*)?$", "nombres");
                b[1] = validacion(sapellidos, "^[A-ZÁÉÍÓÚ][a-záéíóú]+(\\s[A-ZÁÉÍÓÚ][a-záéíóú]*)?$", "apellidos");
                b[2] = validacion(stipoid, "^(?!SELECCIONE$).*", "tipoid");
                b[3] = validacion(sdocumento, "^\\d{6,10}$", "documento");
                b[4] = validacion(slugares, "^(?!BUSCAR$).*", "lugares");
                b[5] = validacion(scelular, "^\\d{10,}$", "celular");
                b[6] = validacion(scorreo, "^[a-zA-Z0-9]+([._-][a-zA-Z0-9_]+)*@[a-zA-Z0-9]+([._-][a-zA-Z0-9]+)*\\.[a-zA-Z]{2,5}$", "correo");
                b[7] = validacionIgual(scorreo, scorreo2, "correo2");
                b[8] = validacion(scontrasena, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", "contrasena");
                b[9] = validacionIgual(scontrasena, scontrasena2, "contrasena2");
                if(!b[7])
                	f=true;
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                o=true;
                break;
            }
        }while(!lpersona.error(b));
        if(f)
        	cont++;
        if(!o)
        {
            lpersona.getPersona().setNombre(snombres);
            lpersona.getPersona().setApellidos(sapellidos);
            lpersona.getPersona().setTipoid(stipoid);
            lpersona.getPersona().setDocumento(sdocumento);
            lpersona.getPersona().setLugar(slugares);
            lpersona.getPersona().setCelular(scelular);
            lpersona.getPersona().setNacionalidad(snacionalidad);
            lpersona.getPersona().setCorreo(scorreo2);
            lpersona.getPersona().setContrasena(scontrasena2);
            lpersona.ingreso();
        }
      
    }
    
    /*public boolean validacion(String cadena, String regex, String campo){
        if(!lformulario.es(cadena, regex)){
            JOptionPane.showMessageDialog(null, validacionMensaje(campo), "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        
        return true;
    }*/
    
    public boolean validacion(String cadena, String regex, String campo){
        if(!Pattern.matches(regex, cadena)){
            JOptionPane.showMessageDialog(null, validacionMensaje(campo), "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        
        return true;
    }
    
    public boolean validacionIgual(String cadena, String cadena2, String campo){
        if(!lpersona.esIgual(cadena, cadena2)){
            JOptionPane.showMessageDialog(null, validacionMensaje(campo), "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        
        return true;
    }
    
    public String validacionMensaje(String campo){
        String info = "";
        
        switch(campo){
            case "nombres":
                info = "Los nombres deben contener minimo dos digitos y no incluir numeros ni caracteres especiales";
                break;
            case "apellidos":
                info = "Los apellidos deben contener minimo dos digitos y no incluir numeros ni caracteres especiales";
                break;
            case "tipoid":
                info = "Seleccione un tipo de identificacion";
                break;
            case "documento":
                info = "El numero documento debe contener entre 6 y 10 dígitos e incluir solo números";
                break;
            case "lugares":
                info = "Seleccione un lugar";
                break;
            case "celular":
                info = "El numero de celular debe contener minimo 10 digitos e incluir solo numeros";
                break;
            /*case "nacionalidad":
                info = "";
                break;*/
            case "correo":
                info = "Ingresa una direccion de correo electronico valida";
                break;
            case "correo2":
                info = "Los correos electronicos no coinciden";
                break;
            case "contrasena":
                info = "La contraseña debe tener al menos 8 caracteres, una minuscula, una mayuscula y un numero";
                break;
            case "contrasena2":
                info = "Las contraseñas no coinciden";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tas mal", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        
        return info;
    }
    
    public void otros()
    {
    	JOptionPane.showMessageDialog(null, "En promedio de personas con otra nacionalidad es: "+lpersona.otro()+"%");
    }
    
    public void mostrar()
    {
    	JOptionPane.showMessageDialog(null, "Listado \n"+lpersona.mostrar());
    }
    
    public void docs()
    {
    	int con[]= lpersona.tdoc();
    	JOptionPane.showMessageDialog(null, "La cantidad de personas con cedula extranjera es: "+ con[0]+"\n La cantidad de personas con pasaporte es:"+ con[1]);
    }
    
    public void prom()
    {
    	float p=(float) cont/ lpersona.getArrayPersona().size();
    	p= p*100;
    	JOptionPane.showMessageDialog(null, "El promedio de personas que se equivocan es:" + p + "%");
    	
    }

}
