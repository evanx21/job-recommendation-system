import com.example.jobrec.entity.ExampleCoordinates;
import com.example.jobrec.entity.ExampleJob;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ExampleJobServlet", urlPatterns = {"/example_job"})
public class ExampleJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json"); //determine the response's type
        ObjectMapper mapper = new ObjectMapper(); //Use ObjectMapper to do two-way mapping
        ExampleCoordinates coordinates = new ExampleCoordinates(37.4851, -122.148316);
        ExampleJob job = new ExampleJob("Software Engineer", 123456, "Aug 1, 2020", false, coordinates);

        mapper.writeValue(response.getWriter(), job);
    }
}