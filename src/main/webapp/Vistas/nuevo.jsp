<%-- 
    Document   : nuevo
    Created on : 3 ago. 2021, 07:04:39
    Author     : anace
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
              <div class="conteiner-form">
    <form class="row g-3 needs-validation" action="../usuariosController?accion=insert" method="POST" novalidate>
        <div class="col-md-1">
          <label for="validationCustom01" class="form-label">Id</label>
          <input type="text" class="form-control" id="id" name="id" value ="" required>
        </div>
       
        <div class="col-md-4">
          <label for="validationCustom01" class="form-label">Nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre" value ="" required>
        </div>
        <div class="col-md-4">
          <label for="validationCustom02" class="form-label">Apellido</label>
          <input type="text" class="form-control" id="apellido" name="apellido" value="" required>
        </div>
        <div class="col-md-4">
          <label for="validationCustomUsername" class="form-label">Email</label>
          <input type="email" class="form-control" id="email" name="email" value="" required> 
           
          </div>
        
     <div class="col-md-3">
          <label for="validationCustom03" class="form-label">Edad</label>
          <input type="text" class="form-control" id="edad" name="edad" required>
        </div>
        <div class="col-md-3">
          <label for="validationCustom04" class="form-label">Pais</label>
          <input type="text" class="form-control" id="pais"name="pais" required>        
        </div>
     <div class="col-12">
       <div class="col-2">
          <button class="btn btn-primary" type="submit">Enviar</button>
       </div><br>
        
        </div>
      </div>
      </form>
    </li>
  </div>
</div>
        
    </body>
</html>
