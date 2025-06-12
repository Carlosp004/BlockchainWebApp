/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.BlockJpaController;
import dto.Block;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.SHA256Util;

/**
 *
 * @author Piero
 */
@WebServlet(name = "AddBlockServlet", urlPatterns = {"/addBlockServlet"})
public class AddBlockServlet extends HttpServlet {

    private EntityManagerFactory emf;
    private BlockJpaController blockDao;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("com.mycompany_BlockchainWebApp_war_1.0-SNAPSHOTPU");
        blockDao = new BlockJpaController(emf);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");

        // Obtener último bloque para calcular previousHash
        Block lastBlock = blockDao.findLastBlock();
        String previousHash = (lastBlock != null) ? lastBlock.getHash() : "0";

        // Crear nuevo bloque
        int nonce = 0;
        String hash;
        int difficulty = 4;
        String prefix = "0".repeat(difficulty);

        long inicio = System.currentTimeMillis();

        // Minado (proof of work)
        do {
            nonce++;
            String input = data + previousHash + nonce;
            hash = SHA256Util.aplicarSHA256(input);
        } while (!hash.startsWith(prefix));

        long fin = System.currentTimeMillis();
        long tiempoMinado = fin - inicio;

        Block nuevoBloque = new Block();
        nuevoBloque.setData(data);
        nuevoBloque.setPreviousHash(previousHash);
        nuevoBloque.setHash(hash);
        nuevoBloque.setNonce(nonce);
        nuevoBloque.setTimestamp(new Date());

        blockDao.create(nuevoBloque);

        response.setContentType("application/json");
        response.getWriter().write("{\"status\":\"ok\",\"hash\":\"" + hash + "\",\"tiempoMinado\":\"" + tiempoMinado + " ms\"}");
    }
}
