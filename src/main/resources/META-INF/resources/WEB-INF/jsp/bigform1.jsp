<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



<style>

body{
background: linear-gradient(113.5deg, rgb(234, 234, 234) 22.3%, rgb(201, 234, 211) 56.6%, rgb(255, 180, 189) 90.9%);
}

.need-back{
background: linear-gradient(113.5deg, rgb(234, 234, 234) 22.3%, rgb(201, 234, 211) 56.6%, rgb(255, 180, 189) 90.9%);
}
button.text-center
{  
  margin-left:36rem;
}

.nash{
  transition: box-shadow .5s;

  
}
.nash:hover {
  box-shadow: 0 0 45px rgba(33,33,33,.2); 
}

.slidecontainer {
  width: 80%;
}

.slider {
  -webkit-appearance: none;
  width: 100%;
  height: 25px;
  background: #d3d3d3;
  outline: none;
  opacity: 0.7;
  -webkit-transition: .2s;
  transition: opacity .2s;
}

.slider:hover {
  opacity: 1;
}

.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 25px;
  height: 25px;
  background:#343a40;
  cursor: pointer;
}

.slider::-moz-range-thumb {
  width: 25px;
  height: 25px;
  background: #04AA6D;
  cursor: pointer;
}

</style>


</head>
<body>
<form action="/picform">
 <div class="shadow p-3 mb-5 bg-white rounded text-center need-back">Enter more details for ${search}</div>
 <div class="container">
  <div class="row ">
    <div class="col nash ">


Select one or more symptoms 
<div>
<input type="checkbox" name="langs" id="symp1" value="Headache and nausea" checked> <label for="langs_javascript">Headache and nausea</label>
</div>
<div>
<input type="checkbox" name="langs" id="symp2" value="Bodypain"> <label for="langs_perl">103 temperature</label>
</div>
<div>
<input type="checkbox" name="langs" id="symp3" value="Diarhea" > <label for="langs_php">Diarhea</label>
</div>
<div>
<input type="checkbox" name="langs" id="symp4" value="Blindness"> <label for="langs_ruby">sudden chill</label>
</div>
<div style="visibility:hidden; color:red; " id="chk_option_error">
Please select atleast one option.
</div>

</div>

<div class="col nash text-center">   
	<div class="slidecontainer">
  <p>Select your age:</p>
  <input type="range" min="1" max="100" id="myRange" name="age" value="20" class="slider" required>
  <p>Age: <span id="demo"></span></p>
    </div>

 </div>
    <div class="col nash text-center ">
     <label for="age ">onset of reaction </label><br>
	<select name="reaction" id="reaction" required>
	<option value="" selected>select</option>
	<option value="After 1 or 2 days from drug">After 1 or 2days from drug</option>
	<option value="After 1week from drug">After 1week from drug</option>
	<option value="After 2 week from drug">After 2 week from drug</option>
	<option value="After 3 week from drug">After 3 week from drug</option>
	</select>
    </div>
    <div class="col nash text-center ">
    <label for="age">Select your sex: </label><br>
	<select name="sex" id="sex" required>
	<option value="" selected>Click to select</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
	<option value="Other">Other</option>
	</select>
    </div>
  </div>
</div>
<input type="hidden" id="custId" name="drug" value="${search}">
<div class="shadow p-3 mb-5 bg-white rounded need-back"><button  class="btn btn-primary text-center" type="submit" value="Submit" onclick="myFunction()">Submit</button></div>

 </form>

</body>
<script>

var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}

function myFunction() {	
var form_data = new FormData(document.querySelector("form"));
   if(!form_data.has("langs"))
   {
       document.getElementById("chk_option_error").style.visibility = "visible";
     return false;      
   }
   else
   {
       document.getElementById("chk_option_error").style.visibility = "hidden";
     return true;
   } 
   function reset_msg() {
	    document.getElementById('msg').innerHTML = '';
	}
}
   </script>


 

</html>
