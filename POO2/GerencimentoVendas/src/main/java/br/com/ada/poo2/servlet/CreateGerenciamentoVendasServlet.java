package br.com.ada.poo2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-produto")
public class CreateGerenciamentoVendasServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeProduto = req.getParameter("nome-produto");
        Double precoProduto = Double.parseDouble(req.getParameter("preco-produto"));

        System.out.println(nomeProduto);
        System.out.println(precoProduto);

        req.getRequestDispatcher("index.html").forward(req, resp);


    }
}
