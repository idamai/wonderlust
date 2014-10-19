<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- <html>
    <head>
        <title>Spring Security Form Login Tutorial</title>
    </head>
    <body>
        <H1>Welcome to the User screen!</H1>
        <p><a href="<c:url value='/logout'/>">Logout</a></p>
    </body>
</html> --%>
 <html> 
  <head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="http://assets.ziggeo.com/css/ziggeo-betajs-player.min.css"/>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/"></script>
    <script src="//assets.ziggeo.com/js/ziggeo-jquery-json2-betajs-player.min.js"></script>
    <script>ZiggeoApi.token = "a66a10279f51ef5d416edb09c78851ff";</script>

    <!-- Pacifico font -->
    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>

    <!-- font awesome -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  </head>


  <body>
  
  	<div id="wonderlust-map" style="height: 1080px;">

	</div>

    <ziggeo></ziggeo>

    <a class="check-in-link" data-toggle="modal" href="#textModal">
      <div class="check-in-button pin-button" data-toggle="modal">
        Check In
      </div>
    </a>



      <!-- MODAL SETUP -->
      <div class="modal fade" id="textModal">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-body">
              <div class="body-container pin-modal">
                

        

             
                <!-- Carousel -->
                <div id="myCarousel" class="carousel slide">
                    <div class="carousel-inner">
                      <div class="item active">
                        <div class="jumbotron video-1">
                          <i class="fa fa-play fa-4x play-button"></i>
                        </div>
                      </div>
                      <div class="item">
                        <div class="jumbotron video-2">
                          <i class="fa fa-play fa-4x play-button"></i>
                        </div>                        
                      </div>
                      <div class="item">
                        <div class="jumbotron video-3">
                          <i class="fa fa-play fa-4x play-button"></i>
                        </div>                        
                      </div>
                    </div>
                  
                  <a class="left carousel-control" id="carousel-buttons" href="#myCarousel" data-slide="prev">
                    <i class="fa fa-chevron-left slider-button"></i>
                  </a>
                  <a class="right carousel-control" id="carousel-buttons" href="#myCarousel" data-slide="next">
                    <i class="fa fa-chevron-right slider-button"></i>
                  </a>
                </div>
                <!-- End Carousel -->



                <!--
                <div class="jumbotron video-player-holder">
                  <iframe width="100%" height="315" src="http://www.youtube.com/embed/kebwTsRZ7bs" frameborder="0" allowfullscreen></iframe>
                </div>
                -->

                <div class="pin-container">

                  <!--Select Location-->
                  <div class="location-holder">
                    <row>
                      <div class="col-xs-12 location-details">
                        <span class="attraction">Eiffel Tower</span>
                        <span class="location">Champ de Mars, 75007, Paris</span>
                      </div>
                    </row>
                  </div>

                  <!--Comments-->

                    <div class="comments-holder">

                      <row>
                        <div class="col-xs-2">
                          <div class="avatar">
                            <img src="<c:url value="/resources/img/heewon.png"/>"/>
                          </div>
                        </div>
                        <div class="col-xs-10 comment-input-holder">
                          <form>
                            <div class="form-group">
                              <textarea class="form-control status-box" rows="2" placeholder="How was your experience?"></textarea>
                            </div>
                          </form>
                        </div>
                      </row>

                      <row>
                        <div class="col-xs-4 col-xs-offset-8">
                          <div class="button-group pull-right">
                            <p class="counter">140</p>
                            <a href="#" class="post-button"><i class="fa fa-pencil pencil-button"></i></a>
                          </div>
                        </div>
                      </row>
                      


                          <ul class="posts">
                          </ul>


                    
                    </div>
                    <!-- END COMMENTS HOLDER -->
                </div>
                <!-- END PIN CONTAINER -->
              </div>
              <!-- END BODY CONTAINER -->

              <!--Pin It!-->
              <div class="check-in-holder pin-it">
                <a class="check-in-link">
                  <div class="check-in-button">
                    Pin It!
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>

    
    

    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
   
<!-- Google Maps stuff -->
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
 
<script>
$(document).ready(function() {
	// initialization
	var map;
	var firstCoords;
	var marker = undefined;
	var currentCoords;
	var wps = [];
	var markers = [];

	// setting up map
	var mapOptions = {
		zoom: 16,
		center: new google.maps.LatLng(40.7287645, -73.9954957)
	};
	map = new google.maps.Map(document.getElementById('wonderlust-map'), mapOptions);
	
	// setting up map renderer options 
	var rendererOptions = { 
		map: map,
		suppressMarkers: true
	};
	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);

	// setting geocode
	var geocoder = new google.maps.Geocoder();

	// placing markers
	google.maps.event.addListener(map, 'click', function(event) {
		console.log(event.latLng);

		// update fields; just for fun
		$('#latitude').val(event.latLng.k);
		$('#longitude').val(event.latLng.B);
		var lat = event.latLng.k;
		var longi = event.latLng.B;
		var latlng = new google.maps.LatLng(lat, longi);
		geocoder.geocode({'latLng': latlng}, function(data, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var add = data[1].formatted_address; //this is the full address
				$('#address').val(add);
				
			}
		});

	   	// set currentCoords and push it to waypoint array
	   	currentCoords = event.latLng;
	   	wps.push({location:currentCoords});

	   	// set firstCoords after clicking
	   	if (firstCoords == undefined) {
	   		firstCoords = currentCoords;
	   	}

	   	var org = firstCoords;
	   	var dest = currentCoords;

	   	var request = {
	   		origin: org,
	   		destination: dest,
	   		waypoints: wps,
	   		travelMode: google.maps.DirectionsTravelMode.WALKING
	   	};

	   	directionsService = new google.maps.DirectionsService();
	   	directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);

				if (marker != undefined) {
					marker.setMap(null);
				}

				for (i=0; i < wps.length; i++) {
					// initialize start flag
					if (i == 0) {
						marker = new google.maps.Marker({
							position: wps[i].location,
							map: map,
							icon: 'http://maps.google.com/mapfiles/ms/micons/flag.png'
						});
					}
					// initialize middle flag
					else if ((i > 0) && (i < wps.length - 1)) {
						marker = new google.maps.Marker({
							position: wps[i].location,
							map: map,
							icon: 'http://maps.google.com/mapfiles/ms/micons/orange.png'
						});
					}
					// initialize last flag
					else {
						marker = new google.maps.Marker({
							position: wps[i].location,
							map: map,
							icon: 'http://maps.google.com/mapfiles/ms/micons/red-pushpin.png'
						});

					}

					markers[i] = marker;
					console.log(markers);

				}

				google.maps.event.addListener(markers[0], 'click', function(event) {
					$('#first_pin').modal('toggle');
				});

				if (markers.length >= 2) {
					google.maps.event.addListener(markers[1], 'click', function(event) {
						$('#second_pin').modal('toggle');
					});
				}
				if (markers.length >= 3) {
					google.maps.event.addListener(markers[2], 'click', function(event) {
						$('#third_pin').modal('toggle');
					});
				}
				if (markers.length >= 4) {
					google.maps.event.addListener(markers[3], 'click', function(event) {
						$('#fourth_pin').modal('toggle');
					});
				}

				if (markers.length >= 5) {
					google.maps.event.addListener(markers[4], 'click', function(event) {
						$('#fifth_pin').modal('toggle');
					});
				}
				if (markers.length >= 6) {
					google.maps.event.addListener(markers[5], 'click', function(event) {
						$('#sixth_pin').modal('toggle');
					});
				}
				if (markers.length >= 7) {
					google.maps.event.addListener(markers[6], 'click', function(event) {
						$('#seventh_pin').modal('toggle');
					});
				}
				if (markers.length >= 8) {
					google.maps.event.addListener(markers[7], 'click', function(event) {
						$('#eighth_pin').modal('toggle');
					});
				}
			}
			else
				alert ('You can only have up to 8 points :(');
		});
	});

	

});
</script>
    
  </body>
</html>