package dataAdapter;

public class ClienteAdapter {
	
	private int nro_cliente;
	private String nombre;
	private String apellido;
	private String razon_social;
	private String telefono;
	private String localidad;
	
	public int getNro_cliente() {
		return nro_cliente;
	}
	public void setNro_cliente(int nro_cliente) {
		this.nro_cliente = nro_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
