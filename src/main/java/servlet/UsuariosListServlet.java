/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import dao.UsuariosJpaController;
import dto.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wilbert
 */
@WebServlet(name = "UsuariosListServlet", urlPatterns = {"/usuariosListServlet"})
public class UsuariosListServlet extends HttpServlet {
    private EntityManagerFactory emf;
    private UsuariosJpaController usuariosDao;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("com.mycompany_BlockchainWebApp_war_1.0-SNAPSHOTPU");
        usuariosDao = new UsuariosJpaController(emf);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Usuarios> lista = usuariosDao.findUsuariosEntities();

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(lista));
    }
}
