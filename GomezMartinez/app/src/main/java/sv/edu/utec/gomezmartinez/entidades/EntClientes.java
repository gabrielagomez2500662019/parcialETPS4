package sv.edu.utec.gomezmartinez.entidades;

public class EntClientes {
     private String sNombreCliente;
     private String sApellidoCliente;
     private String sDireccionCliente;
     private String sCuidadCliente;

    public String getsNombreCliente() {return sNombreCliente;}

    public void setsNombreCliente(String sNombreCliente) {
        this.sNombreCliente = sNombreCliente;
    }


    public String getsApellidoCliente() {
        return sApellidoCliente;
    }

    public void setsApellidoCliente(String sApellidoCliente) {
        this.sApellidoCliente = sApellidoCliente;
    }

    public String getsDireccionCliente() {
        return sDireccionCliente;
    }

    public void setsDireccionCliente(String sDireccionCliente) {
        this.sDireccionCliente = sDireccionCliente;
    }

    public String getsCuidadCliente() {
        return sCuidadCliente;
    }

    public void setsCuidadCliente(String sCuidadCliente) {
        this.sCuidadCliente = sCuidadCliente;
    }

}