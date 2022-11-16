package com.ar.jorge.newbery;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BlockingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, String> db = new HashMap<>();
    ObjectMapper sampleObject = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = (String) request.getAttribute("id");

        String value = db.get(id);

        if (value != null) {

        }
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);


        response.getWriter().println(System.getenv().get("CONFLUENT_CLI"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String body = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        JsonNode json = sampleObject.readTree(body);

        System.out.println(json.get("name").asText());
    }
}