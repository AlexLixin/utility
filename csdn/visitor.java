import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import sun.net.www.http.HttpClient;

public class visitor {
    public static void main(String[] args) throws IOException {
        String url = "https://blog.csdn.net/coderALEX";
        URL u = new URL(url);
        HttpURLConnection con = (HttpURLConnection)u.openConnection();
        con.setRequestMethod("GET");

		//add request header

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
        in.close();
        
        String result = response.toString();

		//print result
		System.out.println();
    }
}