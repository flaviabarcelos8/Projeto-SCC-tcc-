<%@include file="cabecalho.jsp" %>
<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('images/images.jpg')">
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-0">Cadastro</h2>
             
            </div>
          </div>
        </div>
      </div> 
    

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.html">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">Cadastro</span>
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
                            <input type="file" name="txtFoto" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="username">Nome</label>
                            <input type="text" name="txtNome" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="sobrenome">Sobrenome</label>
                            <input type="text" name="txtSobrenome" class="form-control form-control-lg">
                        </div>
                       
                        <div class="col-md-12 form-group">
                            <label for="email">Email</label>
                            <input type="email" name="txtEmail" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="pword">Senha</label>
                            <input type="password" name="txtSenha" class="form-control form-control-lg">
                        </div>
                 <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-lg px-5" > Cadastrar</button>
                        </div>
                    </div>
            </form>
                         <c:if test="${not empty msg}">
                    <div class="alert alert-primary alert-dismissible fade show" role="alert">
                        <strong>ATENÇÃO:</strong> ${msg}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <i class="tim-icons icon-simple-remove"></i>
                        </button>
                    </div>
                </c:if>
                    </div>
                   
                </div>
            </div>
            

          
        </div>
    </div>
<%@include file="rodape.jsp" %>