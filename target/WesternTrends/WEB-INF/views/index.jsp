<%@ include file="template/header.jsp"%>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="./resources/images/image1.jpg.jpeg" style="width:100%;">
      </div>

      <div class="item">
        <img src="./resources/images/image2.jpg" style="width:100%;">
      </div>
      <div class="item">
        <img src="./resources/images/image3.jpg" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  <div class="container" style="margin-top:70px;">
  <img src="./resources/images/image4.jpg" class="img-circle" width="304"height="236"style="margin-left:50px;"> 
  <img src="./resources/images/image5.jpg" class="img-circle" width="304"height="236"style="margin-left:50px;">
  <img src="./resources/images/image6.jpg" class="img-circle" width="304"height="236"style="margin-left:50px;">
  </div>
  <%@ include file="template/footer.jsp"%>