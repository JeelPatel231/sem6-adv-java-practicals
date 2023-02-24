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
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Hello extends HttpServlet {

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration<String> allParamNames = request.getParameterNames();
        out.println("<table border='5' cellpadding='10'>");
        while (allParamNames.hasMoreElements()) {
            out.println("<tr> <td>");
            Object currentParam = allParamNames.nextElement();
            out.print(this.capitalize(currentParam.toString()) + "</td> <td>");
            String[] paramValues = request.getParameterValues(currentParam.toString());
            boolean needList = paramValues.length >= 2;
            // if (needList)
            // out.println("<ul>");
            for (int i = 0; i < paramValues.length; i++) {
                if (needList)
                    out.println("<li>");
                out.println(paramValues[i]);
                if (needList)
                    out.println("</li>");
            }
            // if (needList)
            // out.println("</ul>");
            out.println("</td> </tr>");
        }
        out.println("</table>");
    }

}
