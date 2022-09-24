package Controller;
import DAO.DAO;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.GooglePojo;
import DAO.GoogleUtils;
import Model.UserAccount;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
      DAO dao;
    int count = 0;

    public void init() {
        dao = new DAO();
    }
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("logintrue.jsp");
      dis.forward(request, response);
    } else {
        
        
        
        
      String accessToken = GoogleUtils.getToken(code);
      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
      
       String mail = googlePojo.getEmail();
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        list = dao.takeinfor();
        
        int flag = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMail().equals(mail)) {
                flag = 1;
                id = list.get(i).getId();
            }
        }
        if(flag==1){
            request.setAttribute("id", id+"");
             RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
      dis.forward(request, response);
        }else{
        
      
      request.setAttribute("flag", id+"");
      
      
        try {
            dao.registerbymail( googlePojo.getEmail(),googlePojo.getPicture());
        } catch (Exception ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      request.setAttribute("id", id+"");
             RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
      dis.forward(request, response);
    }}
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}