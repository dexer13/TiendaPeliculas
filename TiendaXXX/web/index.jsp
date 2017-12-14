<%-- 
    Document   : index
    Created on : 10/12/2017, 07:14:41 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <script src="js/procesarRegistrarPelicula.js"></script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="col-md-6">
                <H1>Registrar pelicula</H1>
                <form>
                    <div class="form-group">
                        <label>Título</label>
                        <input type="text" class="form-control" id="titulo" placeholder="Ingrese el título">
                        <small id="emailHelp" class="form-text text-muted">Ingrese el título de la pelicula....</small>
                    </div>
                    <div class="form-group">
                        <label>Año</label>
                        <input type="number" class="form-control" id="anio" placeholder="Ingrese el título">
                        <small id="emailHelp" class="form-text text-muted">Ingrese el año de la pelicula....</small>
                    </div>
                    <div class="form-group">
                        <label>Crítica</label>
                        <input type="text" class="form-control" id="critica" placeholder="Ingrese el título">
                        <small id="emailHelp" class="form-text text-muted">Ingrese el Crítica de la pelicula....</small>
                    </div>
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#agregarCopia">Agregar copias +</button>
                    <button type="button" class="btn btn-primary" onclick="insertarPelicula()">Guardar</button>
                </form>
                <div id="resultado2"></div>
            </div>
            <div class="modal" tabindex="-1" role="dialog" id="agregarCopia">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Agregar Copia</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="checkbox" class="form-check-input" name="dete">
                                        Deteriorada
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Formato</label>
                                    <input type="text" class="form-control" id="formato" placeholder="Ingrese el título">
                                    <small id="emailHelp" class="form-text text-muted">Ingrese el año de la pelicula....</small>
                                </div>
                                <div class="form-group">
                                    <label>Precio Alquiler</label>
                                    <input type="number" class="form-control" id="precio" placeholder="Ingrese el título">
                                    <small id="emailHelp" class="form-text text-muted">Ingrese el Crítica de la pelicula....</small>
                                </div>
                                
                                <div id="resultado"></div>
                                <button type="button" class="btn btn-success" onclick="regisrarOtra()">Agregar otra</button>
                                <button type="button" class="btn btn-primary" onclick="guardar()" data-dismiss="modal">Guardar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
