<%@include file="cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4">
    <div class="container">
        <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
                <h2 class="mb-0">Editar Perfil</h2>
              
            </div>
        </div>
    </div>
</div> 


<div class="custom-breadcrumns border-bottom">
    <div class="container">
        <a href="index.html">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">Edição</span>
    </div>
</div>

<div class="site-section">
    <div class="container">


        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="row">
                    <form action="UploadWS" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="urldestino" value="UsuarioWS">

                        <div class="col-md-12 form-group">
                            <label for="file">Foto</label>
                            <input type="file" name="txtFoto" class="form-control form-control-lg" value="../../arquivos/${obj.endFoto}">
                        </div>
                       
                        <div class="col-md-12 form-group">
                            <label for="username">Nome</label>
                            <input type="text" name="txtNome" class="form-control form-control-lg" value="${obj.nome}">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="sobrenome">Sobrenome</label>
                            <input type="text" name="txtSobrenome" class="form-control form-control-lg" value="${obj.sobrenome}">
                        </div>
                       
                        <div class="col-md-12 form-group">
                            <label for="email">Email</label>
                            <input type="email" name="txtEmail" class="form-control form-control-lg" value="${obj.email}">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="pword">Senha</label>
                            <input type="password" name="txtSenha" class="form-control form-control-lg">
                        </div>
                        
               <div class="row">
                <div class="col-8">
                    <p><button type="submit" class="btn btn-primary px-1 btn-lg ">Salvar</button>
                    <a class="btn btn-primary btn-lg px-1" href="UsuarioWS?acao=del">
                        <i class="btn btn-primary btn-lg px-1"></i>Excluir
                        </a></p>
                </div>
            </div>
 
                    </form>
                </div>

            </div>
            
        </div>



    </div>
</div>

<%@include file="rodape.jsp" %>