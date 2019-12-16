<%@include file="cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

    <div class="site-wrap">

        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>


        <div class="py-2 bg-light">
            <div class="container">
                <div class="row align-items-center"><div class="col-lg-3 text-right">
                        <a href="login.jsp" class="small mr-3"><span class="icon-unlock-alt"></span> Logar</a>
                        <a href="cadastro.jsp" class="small btn btn-primary px-4 py-2 rounded-0"><span class="icon-users"></span>Registre-se</a>
                    </div>
                </div>
            </div>
             
        </div>
        <div class="hero-slide owl-carousel site-blocks-cover">
            <div class="intro-section" style="background-image: url('images/images (1).jpg');">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6 mx-auto text-center" data-aos="fade-up">
                            <h1>Confirma!</h1>
                            <h5>Pesquise os candidatos que te representam e ache informações sobre eles com mais facilidade</h5>
                        </div>
                    </div>
                </div>
            </div>

            <div class="intro-section" style="background-image: url('images/bg_1.jpg');">
 <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-12 mx-auto text-center" data-aos="fade-up">
                            <h1>Busque seus candidatos aqui.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

<div class="site-section site-section-sm pb-0">
      <div class="container">
        <div class="row">
            <form method="post" action="SiteWS" class="form-search col-md-12" style="margin-top: -100px;">
            <div class="row  align-items-end">
              <div class="col-md-3">
                <label for="list-types">Cargo</label>
                <div class="select-wrap">
                  <span class="icon icon-arrow_drop_down"></span>
                    <select name="txtCargo" id="list-types" class="form-control d-block rounded-0">
                 <option value="0">selecione</option>
                  <c:forEach items="${cargos}" var="cr">
                    <option value="${cr.id}">${cr.cargo}</option>
                    
                
                  </c:forEach>
                      </select>
                </div>
              </div>
              <div class="col-md-3">
                <label for="offer-types">Localização</label>
                <div class="select-wrap">
                  <span class="icon icon-arrow_drop_down"></span>
                  <select name="txtLocalizacao" id="offer-types" class="form-control d-block rounded-0">
                       <option value="0">selecione</option>
                   <c:forEach items="${localizacao}" var="l">
                    <option value="${l.id}">${l.localizacao}</option>
                   </c:forEach>
                     </select>
                </div>
              </div>
              <div class="col-md-3">
                <label for="select-city">Partido</label>
                <div class="select-wrap">
                  <span class="icon icon-arrow_drop_down"></span>
                  <select name="txtPartido" id="select-city" class="form-control d-block rounded-0">
                      <option value="0">selecione</option>
                      <c:forEach items="${partidos}" var="p">
                    <option value="${p.id}">${p.partido}</option>
                      </c:forEach>
                     </select>
                </div>
              </div>
              <div class="col-md-3">
                <input type="submit" class="btn btn-success text-white btn-block rounded-0" value="Filtrar">
              </div>
            </div>
          </form>
        </div>  
      </div>

   

    <div class="site-section">
        <div class="container">
            <div class="row mb-5 justify-content-center text-center">
                <div class="col-lg-4 mb-5">
                    <h2 class="section-title-underline mb-5">
                        <span>Candidatos</span>
                    </h2>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-4 col-md-6 mb-5 mb-lg-5">
                    <c:forEach items="${candidatos}" var="c">
                        <div class="feature-1 border person text-center">
                            <img src="../arquivos/${c.fotocandidato}" alt="" class="img-fluid">
                            <div class="feature-1-content">
                                <a href="CandidatoWS?acao=candidato&id=${c.id}"><h2>${c.nome}</h2></a>
                                <span class="position mb-3 d-block">${c.cargo.cargo}</span>  
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="site-section ftco-subscribe-1" style="background-image: url('images/bg_1.jpg')">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-7">
                    <h2>Faça uma sugestão!</h2>
                    <p>Acha que o site pode ser melhor? Envie sua sugestão para nós pelo email portalpolitica@gmail.com .</p>
                </div>
            </div>
        </div>
    </div> 

    <%@include file="rodape.jsp" %> 