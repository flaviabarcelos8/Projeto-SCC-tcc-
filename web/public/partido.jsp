<%@include file="cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
    <div class="custom-breadcrumns border-bottom">
        <div class="container">
            <a href="index.html">Home</a>
            <span class="mx-3 icon-keyboard_arrow_right"></span>
            <a href="courses.html">Partidos</a>
            <span class="mx-3 icon-keyboard_arrow_right"></span>
            <span class="current">${objp.partido}</span>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row">
                <h2 class="section-title-underline mb-5">
                    <span>${objp.partido}</span>
                </h2>
            </div>
            <div class="row">
                <div class="col-md-6 mb-4">
                    <span>
                        <img src="../arquivos/${objp.fotopartido}" alt="" class="img-fluid">
                    </span>

                    <p><strong class="text-black d-block">Biografia</strong></p>
                    <p>${objp.bio}</p>

                </div>

                <div class="col-lg-5 ml-auto align-self-center">
                    <h2 class="section-title-underline mb-5">
                        <span>Informações</span>
                    </h2>
                    
                    <p class="mb-5"><strong class="text-black d-block">N° do Partido:</strong>${objp.numpartido}</p>
                   
                    <h2 class="section-title-underline mb-5">
                        <span>Movimentos/Ideias</span>
                    </h2>
                    <ul class="ul-check primary list-unstyled mb-5">
                        <li>${objp.favoravel}</li>
                    </ul>
                    
                </div>
                    
            </div>
        </div>
    </div>

</body>
<%@include file="rodape.jsp" %>