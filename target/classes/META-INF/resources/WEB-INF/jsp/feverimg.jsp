<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
body{
background: linear-gradient(113.5deg, rgb(234, 234, 234) 22.3%, rgb(201, 234, 211) 56.6%, rgb(255, 180, 189) 90.9%);
}

.nash{
background: linear-gradient(113.5deg, rgb(234, 234, 234) 22.3%, rgb(201, 234, 211) 56.6%, rgb(255, 180, 189) 90.9%);
}
img {
height:15rem;
}

.fda:link, .fda:visited {
  background-color: blue;
  color: white;
  padding: 7px 14px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
</style>

</head>

<body>

<%-- <h4 class="text-center">Your search result for ${Drug}</h4> 
<h4 class="text-center">For the Age of  ${Age},Onset of  ${Onset} ,of sex: ${Sex}</h4> --%>
<div class="jumbotron text-center">
  <h1 class="display-4">Drug Reaction:${Drug}</h1>
  <p class="lead">For the Age of  ${Age},Onset of  ${Onset} ,of sex: ${Sex}</p>
  <hr class="my-4">
  <p>If you want to move further and submit this request to FDA 
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Click here
</button>
  </p>
</div>
<form action="https://google.com">
<div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content nash">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">FDA Notice</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
       The above Drug reaction will be passed to FDA for further medication or treatment by the authorised people
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <!-- <button type="button"  value="Submit" class="btn btn-primary">Save changes</button> -->
        <a class="fda" href="https://google.com" target="_blank">save</a>
      </div>
    </div>
  </div>
</div>
</form>
<div class="row">

<form id="myform" method="post" action="mypage.php">
  
</form>



<div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r1.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 1</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
     <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  
  
  <div class="col card " style="width: 15rem ">
  <img class="card-img-top" src="images/r2.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 2</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  <div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r3.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 3</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  
  <div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r4.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 4</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  
  
  
</div>





<div class="row">
  <div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r5.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 5</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  
  
  <div class="col card" style="width: 15rem ">
  <img class="card-img-top" src="images/r6.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 6</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  <div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r7.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 7</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
  
  
  <div class="col card" style="width: 15rem;">
  <img class="card-img-top" src="images/r8.jpg" alt="Card image cap">
  <div class="card-body text-center">
    <h5 class="card-title">sick 8</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Click here</a>
  </div>
</div>
</body>
  

</html>


<%@ include file="common/footer.jspf" %>
