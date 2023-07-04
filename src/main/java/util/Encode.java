package util;

import java.io.PrintWriter;
import java.io.IOException;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.KeyGenerator;
import com.ibm.websphere.crypto.PasswordUtil;

@WebServlet({ "/encode" })
public class Encode extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");
		String key = request.getParameter("key");
	
		System.setProperty("wlp.password.encryption.key", key);
		String encodedPassword = PasswordUtil.passwordEncode(pwd, "aes");

                JSONObject json = new JSONObject();
                  	   json.put("encoded", encodedPassword);
                           json.put("decoded", pwd);
                           json.put("key", key);

                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.close();
	}

}
