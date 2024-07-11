
package bean;

public class Persona {
    
    private String nombre, apellidos, tipoid, lugar, nacionalidad, correo, contrasena;
    private String documento, celular;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String tipoid, String lugar, String nacionalidad, String correo, String contrasena, String documento, String celular) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoid = tipoid;
        this.lugar = lugar;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.documento = documento;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return  "nombre: " + nombre + ", apellidos: " + apellidos + ", tipoid: " + tipoid + ", lugar: " + lugar + ", nacionalidad: " + nacionalidad + ", correo: " + correo + ", contrasena: " + contrasena + ", documento: " + documento + ", celular: " + celular ;
    }
    
    
    
}
