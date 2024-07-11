
package vista;

import javax.swing.JOptionPane;

public class Menu {
    
    public void menuPrincipal(){
        int opcion = 0;
        VPersona vformulario = new VPersona();
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Llenar formulario
                                                                        2. Mostrar array
                                                                        3. Cantidad de personas con cedula extranjera y pasaporte
                                                                        4. promedio con otra nacionalidad
                                                                       	5. porcentaje que se quivocaron
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            switch(opcion){
                case 1: 
                    vformulario.formulario();
                    break;
                case 2: 
                    vformulario.mostrar();
                    break;
                case 3: 
                    vformulario.docs();
                    break;
                case 4: 
                    vformulario.otros();
                    break;
                case 5: 
                    vformulario.prom();;
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saldra del programa, hasta la proxima", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
        
        
    }
    
}
