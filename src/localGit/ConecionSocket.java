package localGit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConecionSocket {
	public static void main(String[] args) throws IOException {
		String rutaArchivo=args[0];
		System.out.println(rutaArchivo);
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		archivo = new File(rutaArchivo);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		String linea;
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
			String [] listaIps= linea.split(" ");
			String ipF=listaIps[0];
			int puertoF= Integer.parseInt(listaIps[1]);
			validasocket(ipF, puertoF);
		}
		br.close();
		fr.close();

	}// main

	private static void validasocket(String ip, int puerto) {
		Socket s = null;
		BufferedReader in = null;
		try {
			s = new Socket(ip, puerto);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			boolean more = true;
			while (more) {
				String line = in.readLine();
				if (line == null) {
					System.out.println( line);
					more = false;
				} else {
					 System.out.println( line);
				}
			}
			System.out.println("fin Exito  ip" + ip + " puerto=" + puerto);
		} catch (IOException e) {
			System.out.println("fin Falla  ip" + ip + " puerto=" + puerto + " --" + e.getMessage());
			// e.printStackTrace();
		} catch (Exception e2) {
			System.out.println("fin Falla  ip" + ip + " puerto=" + puerto + " --" + e2.getMessage());
		} finally {

			try {
				if (in != null)
					in.close();
				if (s != null)
					s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// validasocket
	private static void m1() {
		System.out.println("ConecionSocket.m1() Comentario local 1 ");
	}
}// cklass
