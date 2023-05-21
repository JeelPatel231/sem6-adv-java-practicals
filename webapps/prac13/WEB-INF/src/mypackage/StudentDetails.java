/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class StudentDetails extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String jdbcUrl = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "password";
            // create a connection to the database
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println(conn);

            String query = "SELECT * FROM students WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, Integer.parseInt(request.getParameter("id")));
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String college = resultSet.getString("college");
                    String number = resultSet.getString("number");

                    out.println("<table border='5' cellpadding='10'>");
                    out.println("<table border='5' cellpadding='10'>");
                    out.println("<tr><td> Name </td><td>" + name + "</td><tr>");
                    out.println("<tr><td> ID </td><td>" + id + "</td><tr>");
                    out.println("<tr><td> College </td><td>" + college + "</td><tr>");
                    out.println("<tr><td> Number </td><td>" + number + "</td><tr>");
                    out.println("</table>");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(out);
        }
    }

}
