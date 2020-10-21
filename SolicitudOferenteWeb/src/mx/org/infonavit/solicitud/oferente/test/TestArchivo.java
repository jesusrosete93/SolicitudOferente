package mx.org.infonavit.solicitud.oferente.test;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class TestArchivo {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File file = new File("C:/Users/user/Desktop/notas22092020.txt");
// 
//        FileInputStream fis = new FileInputStream(file);
//        //System.out.println(file.exists() + "!!");
//        //InputStream in = resource.openStream();
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024];
//        try {
//            for (int readNum; (readNum = fis.read(buf)) != -1;) {
//                bos.write(buf, 0, readNum); //no doubt here is 0
//                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
//                System.out.println("read " + readNum + " bytes,");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(genJpeg.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        byte[] bytes = bos.toByteArray();
// 
//        //below is the different part
//        File someFile = new File("C:/Users/user/Desktop/Nueva carpeta/notas22092020.txt");
//        FileOutputStream fos = new FileOutputStream(someFile);
//        fos.write(bytes);
//        fos.flush();
//        fos.close();
    	File file = new File("C:/Users/user/Desktop/notas22092020.txt");
    	File archivo = file;
    	byte[] archivoBytes = null;

   

    	 long tamanoArch = archivo.length(); //Nos quedamos con el tamaño del archivo.

    	//Con esta condicional controlamos si el archivo es demasiado grande
    	if (tamanoArch > Integer.MAX_VALUE)
    	{
    
    	System.out.println("El archivo es demasiado largo.");
    	}
    	else
    	
    	

    	try
    	{
    	//Nos creamos esta variable para poder leer el archivo.
    	FileInputStream docu = new FileInputStream(archivo);

    	//Leemos los bytes del archivo y a la vez se van insertando en el array de bytes creado.
    	int numBytes = docu.read(archivoBytes);

    	System.out.println("El archivo tiene " + numBytes + " de bytes.");

    	docu.close(); //Muy importante cerrar tras la lectura.
    	}
    	catch (FileNotFoundException e)
    	{
    	System.out.println("No se ha encontrado el archivo.");
    	}
    	catch (IOException e)
    	{
    	System.out.println("No se ha podido leer el archivo.");
    	}
    	
    	
    }
}

