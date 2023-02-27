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

public final class Header extends HttpServlet {

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration<String> allHeaderNames = request.getHeaderNames();
        out.println("<style>th{background-color:#008bff; color:#ffffff;}</style>");
        out.println("<center><table border='1' cellspacing='0' cellpadding='10'>");
        out.println("<tr><th>Header Name</th><th>Header Values</th></tr>");
        while (allHeaderNames.hasMoreElements()) {
            out.println("<tr> <td>");
            Object currentHeader = allHeaderNames.nextElement();
            out.print(this.capitalize(currentHeader.toString()) + "</td> <td>");
            out.println(request.getHeader(currentHeader.toString()));
            out.println("</td> </tr>");
        }
        out.println("</table></center>");
    }

}
