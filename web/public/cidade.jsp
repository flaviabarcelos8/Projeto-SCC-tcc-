<%@include file="cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="rodape.jsp" %>