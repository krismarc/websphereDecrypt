package util;

import java.io.PrintWriter;
import java.io.IOException;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ibm.websphere.crypto.PasswordUtil;

@WebServlet({ "/decode" })
public class Decode extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");
		String key = request.getParameter("key");

		System.setProperty("wlp.password.encryption.key", key);
		String decodedPassword = PasswordUtil.passwordDecode(pwd);

                JSONObject json = new JSONObject();
                  	   json.put("encoded", pwd);
                           json.put("decoded", decodedPassword);
                           json.put("key", key);

                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.close();
	}

}
