
    
<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1"> 

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>login page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>

<body>
  <!-- Section: Design Block -->
  <section class="text-center">
    <!-- Background image -->
    <div class="p-5 bg-image" style="
        background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg');
        height: 300px;
        "></div>
    <!-- Background image -->

    <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: -100px;
        background: hsla(0, 20%, 82%, 0.8);
        backdrop-filter: blur(30px);
        ">
      <div class="card-body py-5 px-md-5">

        <div class="row d-flex justify-content-center">
          <div class="col-lg-8">
            <h2 class="fw-bold mb-5">Patient registration form </h2>

            <!-- <form action="signup" method="post">
             -->
            <form action="signup" method="post">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" id="iname" name="fname" class="form-control" />
                    <label class="form-label" for="fname">First name</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" id="iname" name="lname" class="form-control" />
                    <label class="form-label" for="lname">Last name</label>
                  </div>
                </div>
              </div>

              <!-- Email input -->
              <div class="form-outline mb-4">
                <input type="email" id="email" name="email" class="form-control" />
                <label class="form-label" for="email">Email address</label>
              </div>
              <div class="form-outline mb-4">
                <div class="form-outline mb-4">

                  <label for="phno">phno:</label>
                  <input type="text" id="phno" name="phno" pattern="[0-9]{10}"
                    title="10 digit number is allowed note: only numbers are allowed "><br><br>
                </div>



                <label for="pincode">Adhar/Abha id:</label>
                <input type="text" id="adhar" name="adhar" pattern="[0-9]{12}"
                  title="12 digit number note: only numbers are allowed "><br><br>
              </div>

              <br>




              <div class="form-outline mb-4">
                <p>Gender</p>
			              � <input type="radio" id="pmale" name="gender" value="MALE">
			              � <label for="pmale">MALE</label><br>
			              � <input type="radio" id="pfemale" name="gender" value="FEMALE">
			              � <label for="pfemale">FEMALE</label>
			     <br>

              </div>

              <div class="form-outline mb-4">

                <label for="birthday">Patient Date Of Birth :</label> <br>
                <input type="date" id="birthday" name="birthday">

              </div>

              <div class="form-outline mb-4">

                <label for="pincode">Pin code:</label>
                <input type="text" id="pincode" name="pincode" pattern="[0-9]{6}"
                  title="6 digit pin code note: only numbers are allowed "><br><br>
              </div>






              <!-- Submit button -->
              <button type="submit" class="btn btn-primary btn-block mb-4">
                Sign up
              </button>


            </form>
          </div>
        </div>
      </div>
    </div>

  </section>
  <!-- Section: Design Block -->
</body>

</html>