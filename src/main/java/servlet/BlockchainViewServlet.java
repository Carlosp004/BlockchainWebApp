/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import dao.BlockJpaController;
import dto.Block;
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
 * @author Piero
 */
@WebServlet(name = "BlockchainViewServlet", urlPatterns = {"/blockchainViewServlet"})
public class BlockchainViewServlet extends HttpServlet {

    private EntityManagerFactory emf;
    private BlockJpaController blockDao;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("BlockchainWebAppPU");
        blockDao = new BlockJpaController(emf);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Block> blockchain = blockDao.findBlockEntities();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(blockchain));
        out.flush();
    }
}
