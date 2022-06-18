package pl.training.jakarta;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "say-hello")
public class HelloServlet extends HttpServlet {

    private static final String NAME_PARAMETER = "name";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String ID_ATTRIBUTE = "id";
    private static final String SAY_HELLO_VIEW = "/say-hello.jsp";

    @EJB(beanName = "UuidGenerator")
    private IdGenerator idGenerator;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter(NAME_PARAMETER);
        request.setAttribute(NAME_ATTRIBUTE, name == null ? "" : name);
        request.setAttribute(ID_ATTRIBUTE, idGenerator.getNext());
        getServletContext().getRequestDispatcher(SAY_HELLO_VIEW)
                .forward(request, response);
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

}
