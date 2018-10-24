package eu.rafaelaznar.controller;

import eu.rafaelaznar.helper.NameGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.rafaelaznar.beans.pet;
import eu.rafaelaznar.beans.person;
import static eu.rafaelaznar.helper.RandomHelper.getRandomInt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class json extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                NameGenerator nameGenerator = new NameGenerator();
                ArrayList<person> alPerson = new ArrayList();
                for (int j = 0; j <= 24; j++) {
                    ArrayList<pet> alPets = new ArrayList();
                    person oPerson = new person();
                    oPerson.setId(j);
                    oPerson.setNombre(nameGenerator.getName());
                    oPerson.setPrimerApellido(nameGenerator.getName());
                    oPerson.setSegundoApellido(nameGenerator.getName());
                    oPerson.setBirthDate(new Date());
                    int max = getRandomInt(1, 3);
                    for (int k = 1; k <= max; k++) {
                        pet oPet = new pet();
                        oPet.setName(nameGenerator.getName());
                        if (getRandomInt(0, 1) == 0) {
                            oPet.setType("Dog");
                        } else {
                            oPet.setType("Cat");
                        }
                        alPets.add(oPet);
                    }
                    oPerson.setPets(alPets);
                    alPerson.add(oPerson);
                }
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson oGson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
                String jsonGenerado = oGson.toJson(alPerson);
                out.print(jsonGenerado);
            } catch (Exception ex) {
                out.println(ex);
                ex.printStackTrace(out);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Ejemplo de uso de Google Gson";
    }

}
