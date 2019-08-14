package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class visitor {
	public static void main(String[] args) throws Exception {
		try {
			List<String> articleIds = getArticleId();
			visitAll(articleIds);
		} catch (Exception e) {
			//
		}
	}

	private static void visitAll(List<String> articleIds) throws Exception {
		for (String string : articleIds) {
			String url = "https://blog.csdn.net/coderALEX/article/details/"+string;
			URL u = new URL(url);
			HttpURLConnection con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
		}
		
	}

	private static List<String> getArticleId() throws IOException {

		String url = "https://blog.csdn.net/coderALEX";
		URL u = new URL(url);
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		con.setRequestMethod("GET");

		// add request header

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// <a href="https://blog.csdn.net/coderALEX/article/details/90081223"
		// target="_blank">
		String result = response.toString();

		Pattern p = Pattern.compile("<a href=\"https://blog.csdn.net/coderALEX/article/details/\\d{8}");
		Matcher m = p.matcher(result);
		List<String> list = new ArrayList<>();
		int i = 0;
		while (m.find()) {
			String substring = result.substring(m.end() - 8, m.end());
			System.out.println("details: " + (i++) + " " + substring);
			list.add(substring);
		}
		return list;
	}
}