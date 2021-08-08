<%-- 
    Document   : usuarios
    Created on : 3 ago. 2021, 07:04:25
    Author     : anace
--%>
<%@page import="config.conexion"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="modelo.usuariosDAO"%>
<%@page import="modelo.usuarios"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuarios</title>
        <link rel="stylesheet" href="/webapp/newcss.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <style type="text/css">
        table,th,td{
            border:1px solid black;
            border-collapse:collapse;
            margin:10px;

        </style>
        <body>
            <div class="conteiner-form">
                <form class="row g-3 needs-validation" action="usuariosController?accion=insert" method="POST" novalidate>
                    <div class="col-md-1">
                        <label for="validationCustom01" class="form-label">Id</label>
                        <input type="text" class="form-control"  id="id" name ="id" value ="" required>
                    </div>
                    <div class="col-md-4">
                        <label for="validationCustom01" class="form-label">Nombre</label>
                        <input type="text" class="form-control"  id="nombre" name="nombre" value ="" required>
                    </div>
                    <div class="col-md-4">
                        <label for="validationCustom02" class="form-label">Apellido</label>
                        <input type="text" class="form-control"  id="apellido" name="apellido"  value="" required>
                    </div>
                    <div class="col-md-4">
                        <label for="validationCustomUsername" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email" value="" required> 

                    </div>
                 <div class="col-md-2">
                        <label for="validationCustomUsername" class="form-label">Edad</label>
                        <input type="text" class="form-control" id="edad" name="edad" value="" required> 

                    </div>

                    <div class="col-md-3">
                        <label for="validationCustom04" class="form-label">Pais</label>
                        <input type="text" class="form-control" id="pais" name="pais" value="" required>        
                    </div>
                    
                    <div class="col-2">
                            <button class="btn btn-primary" type="submit">guardar</button>
                        </div>
                    
                    
                    
                    <tbody>
                    <table style="width:90%"
                           <tr> 
                            <th> ID  </th>
                            <th> NOMBRE </th>
                            <th> APELLIDO </th> 
                            <th> EMAIL </th>  
                            <th> EDAD </th>  
                            <th> PAIS </th>
                            <th>MODIFICAR</th> 
                            <th>ELIMINAR</th> 



                            <%
                                List<usuarios> resultado = null;
                                usuariosDAO usuario = new usuariosDAO();
                                resultado = usuario.listarUsuarios();
                                for (int i = 0; i < resultado.size(); i++) {
                                String ruta = "usuariosController?accion=modificar&id=" + resultado.get(i).getId();
                                String rutaE = "usuariosController?accion=eliminar&id=" + resultado.get(i).getId();

                            %>  

                            <tr>

                                <td><%=resultado.get(i).getId()%></td>
                                <td><%=resultado.get(i).getNombre()%></td>
                                <td><%=resultado.get(i).getApellido()%></td>
                                <td><%=resultado.get(i).getEmail()%></td>
                                <td><%=resultado.get(i).getEdad()%></td>
                                <td><%=resultado.get(i).getPais()%></td>
                                <td><a class="text-success" href=<%=ruta%>>X</a></td>
                                <td><a class="text-danger" href=<%=rutaE%>>X</a></td>


                            </tr>


                            <%
                                }
                            %>   
                        </table>    
                        </tbody>

                    </form>
                </li>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
