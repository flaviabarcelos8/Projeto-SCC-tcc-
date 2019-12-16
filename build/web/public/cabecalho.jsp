<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Confirma!</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <link rel="stylesheet" href="css/jquery.fancybox.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">

        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/aos.css">
        <link href="css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="css/style.css">



    </head>

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
                            <i class="fa fa-user adminpro-user-rounded header-riht-inf" aria-hidden="true"></i>
                            <span class="admin-name">
                                <c:if test="${sessionScope.usuario !=null}">
                                    <a href="UsuarioWS?acao=sair" class="small mr-2"><span class="icon-unlock-alt"></span> Sair</a>
                                    <a href="ColaWS?acao=list" class="small btn btn-primary px-2 py-1 rounded-0"><span class="icon-users"></span>Cola</a>
                                    <a href="UsuarioWS?acao=edit&id=${sessionScope.usuario.id}" class="small btn btn-primary px-2 py-1 rounded-0"><span class="icon-users"></span>Perfil</a>
                                </c:if>

                                <c:if test="${sessionScope.usuario ==null}">  
                                    <a href="login.jsp" class="small mr-3"><span class="icon-unlock-alt"></span> Logar</a>
                                    <a href="cadastro.jsp" class="small btn btn-primary px-4 py-2 rounded-0"><span class="icon-users"></span> Cadastre-se</a>
                                </c:if>

                            </span>


                            <i class="fa fa-angle-down adminpro-icon adminpro-down-arrow"></i>

                        </div>

                    </div>

                </div>



            </div>
            <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

                <div class="container">
                    <div class="d-flex align-items-center">
                        <div class="site-logo">
                            <a href="SiteWS?pg=index" class="d-block">
                                <img src="" alt="" class="img-fluid">
                            </a>
                        </div>
                        <div class="mr-auto">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li class="active">
                                        <a href="SiteWS?pg=index" class="nav-link text-left">Home</a>
                                    </li>
                                    <li class="has-children">
                                        <a href="SiteWS?pg=cargos" class="nav-link text-left">Cargos</a>
                                        <ul class="dropdown">
                                            <c:forEach items="${cargos}" var="cr">

                                                <li><a href="SiteWS?pg=cargos&id=<c:out value="${cr.id}"/>"><c:out value="${cr.cargo}"/></a></li>

                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="has-children">
                                        <a href="SiteWS?pg=partidos" class="nav-link text-left">Partidos</a>
                                        <ul class="dropdown">
                                            <c:forEach items="${partidos}" var="p">

                                                <li><a href="SiteWS?pg=partidos&id=<c:out value="${p.id}"/>"><c:out value="${p.partido}"/></a></li>

                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="has-children">
                                        <a href="SiteWS?pg=localizacaos" class="nav-link text-left">Cidades</a>
                                        <ul class="dropdown">
                                            <c:forEach items="${localizacao}" var="l">

                                                <li><a href="SiteWS?pg=localizacaos&id=<c:out value="${l.id}"/>"><c:out value="${l.localizacao}"/></a></li>

                                            </c:forEach>
                                        </ul>
                                    </li>
                                </ul>        
                            </nav>
                        </div>
                    </div>

                </div>

            </header>

