import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;

@WebServlet(name = "ExampleBookServlet", urlPatterns = {"/example_book"})
public class ExampleBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        //we are manual parsing JSON
        String title = jsonRequest.getString("title");
        String author = jsonRequest.getString("author");
        String date = jsonRequest.getString("date");
        float price = jsonRequest.getFloat("price");
        String currency = jsonRequest.getString("currency");
        int pages = jsonRequest.getInt("pages");
        String series = jsonRequest.getString("series");
        String language = jsonRequest.getString("language");
        String isbn = jsonRequest.getString("isbn");
        //take the order
        System.out.println("Title is: " + title);
        System.out.println("Author is: " + author);
        System.out.println("Date is: " + date);
        System.out.println("Price is: " + price);
        System.out.println("Currency is: " + currency);
        System.out.println("Pages is: " + pages);
        System.out.println("Series is: " + series);
        System.out.println("Language is: " + language);
        System.out.println("ISBN is: " + isbn);



        //response to client that the food is being prepared
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String keyword = request .getParameter("keyword");
       String category = request.getParameter("category");
       System.out.println("Keyword is  " + keyword);
       System.out.println("Category is  " + keyword);
       response.setContentType("application/json");
       JSONObject json = new JSONObject();
       json.put("title", "Elon Musk");
       json.put("author", "Walter Isaacon");
       json.put("data", "2023-9-12");
       json.put("price", 35.00);
       json.put("currency", "USD");
       json.put("pages", 688);
       json.put("series", "none");
       json.put("language", "en_US");
       json.put("isbn", "9781982181284");
       response.getWriter().print(json);
    }
}
