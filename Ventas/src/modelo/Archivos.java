
package modelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {

	private BufferedReader bufEntrada;
	private FileReader fluLee;
	private FileWriter fluEscr;
	private PrintWriter busSalida;
	
	public Archivos(BufferedReader bufEntrada, FileReader fluLee, FileWriter fluEscr, PrintWriter busSalida) {
		this.bufEntrada = bufEntrada;
		this.fluLee = fluLee;
		this.fluEscr = fluEscr;
		this.busSalida = busSalida;
	}
	
	public Archivos() {
		this.bufEntrada = null;
		this.fluLee = null;
		this.fluEscr = null;
		this.busSalida = null;
	}
	
	public String leerDatos(String name) throws IOException {
		this.fluLee = new FileReader(name+".txt");
		bufEntrada = new BufferedReader(fluLee);
		String datos="";
		String linea = this.bufEntrada.readLine();
		while(linea!=null) {
			datos+=linea+"\n";
			linea = this.bufEntrada.readLine();
		
		}
		bufEntrada.close();
		return datos;
	}
	
	public void escribeDatos(String datos, String name) throws IOException {
		
		fluEscr = new FileWriter(name+".txt",true);
		busSalida = new PrintWriter(fluEscr);
		busSalida.println(datos);
		busSalida.close();
		
	}
	
	

}
