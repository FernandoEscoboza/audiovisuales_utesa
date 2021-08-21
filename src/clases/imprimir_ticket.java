
package clases;

public class imprimir_ticket {
    private String cod;
    private String cod2;
    private String descripcion;
    private String serial;
    
    public imprimir_ticket (String cod, String cod2, String descripcion, String serial){
        this.cod = cod;
        this.cod2 = cod2;
        this.descripcion = descripcion;
        this.serial = serial;
    }

    public String getCod() {
        return cod;
    }
    
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    public String getCod2() {
        return cod2;
    }
    public void setCod2(String cod2) {
        this.cod2 = cod2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    public String getSerial() {
        return serial;
    }
    
    public void setserial(String serial) {
        this.serial = serial;
    }
}
