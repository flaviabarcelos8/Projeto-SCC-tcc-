<%@include file="cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
    <div class="custom-breadcrumns border-bottom">
        <div class="container">
            <a href="index.html">Home</a>
            <span class="mx-3 icon-keyboard_arrow_right"></span>
            <a href="courses.html">Courses</a>
            <span class="mx-3 icon-keyboard_arrow_right"></span>
            <span class="current">Courses</span>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row">
                <h2 class="section-title-underline mb-5">
                    <span>${obj.nome}</span>
                </h2>
            </div>
            <div class="row">
                <div class="col-md-6 mb-4">
                    <span>
                        <img src="../arquivos/${obj.fotocandidato}" alt="" class="img-fluid">
                    </span>
                    <span>${obj.biocandidato}</span>

                    <h4 class="section-title-underline mb-5">
                        <span>Propostas e Opiniões</span>
                    </h4>

                    <ul class="ul-check primary list-unstyled mb-5">
                        <c:forEach items="${obj.propostas}" var="p">
                            <li><strong class="text-black d-block">${p.topico.topico}</strong></li>
                            <p>${p.solucao}</p>


                            <strong class="text-black d-block">Fonte:</strong> <p>${p.fonte}</p>
                        </c:forEach>

                    </ul>

                    <p> 
                        <a href="../arquivos/${obj.planospdf}">Visualizar PDF da proposta</a>
                    </p>

                </div>


                <div class="col-lg-5 ml-auto align-self-center">

                    <h2 class="section-title-underline mb-5">
                        <span>Detalhes</span>
                    </h2>

                    <p><strong class="text-black d-block">Idade:</strong>${obj.idade}</p>
                    <p class="mb-5"><strong class="text-black d-block">Cargo concorrido:</strong>${obj.cargo.cargo}</p>
                    <p class="mb-5"><strong class="text-black d-block">N° do candidato:</strong>${obj.numcandidato}</p>
                    <p class="mb-5"><strong class="text-black d-block" >Partido:</strong>${obj.partido.partido}</p>
                    <p class="mb-5"><strong class="text-black d-block">Localização:</strong>${obj.localizacao.localizacao}</p>

                    <p><strong class="text-black d-block">Acompanhe aqui:</strong></p>
                    <div class="ml-auto">
                        <div class="social-wrap">
                            <a href="${obj.facebook}"><span class="icon-facebook"></span></a>
                            <a href="${obj.twitter}"><span class="icon-twitter"></span></a>


                            <a href="#" class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
                                    class="icon-menu h3"></span></a>
                        </div>
                    </div>

                    <form action="ColaWS" method="POST">
                        <input type="hidden" value="${obj.id}" name="txtId">
                        <button type="submit" class="btn btn-primary rounded-0 btn-lg px-5">+ Cola</button>

                        <c:if test = "${not empty msg}">
                            <div class="alert alert-success" role="alert">
                                <p>${msg}</p> 
                            </div>

                        </c:if>
                    </form>
                </div>               
            </div>
        </div>
    </div>

    <div class="section-bg style-1" style="background-image: url('images/hero_1.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                    <span class="icon flaticon-mortarboard"></span>
                    <h3>Our Philosphy</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea? Dolore, amet reprehenderit.</p>
                </div>
                <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                    <span class="icon flaticon-school-material"></span>
                    <h3>Academics Principle</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                        Dolore, amet reprehenderit.</p>
                </div>
                <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
                    <span class="icon flaticon-library"></span>
                    <h3>Key of Success</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                        Dolore, amet reprehenderit.</p>
                </div>
            </div>
        </div>
    </div>
</body>
<%@include file="rodape.jsp" %>