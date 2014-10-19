$(document).ready(function() {
	// initialization
	var map;
	var firstCoords;
	var marker = undefined;
	var currentCoords;
	var wps = [];
	var markers = [];
	var server = "/wonderlust/api";
	var routeId;
	var interestPointId;
	// setting up map
	var mapOptions = {
		zoom : 16,
		center : new google.maps.LatLng(40.7287645, -73.9954957)
	};
	map = new google.maps.Map(document.getElementById('wonderlust-map'), mapOptions);

	// setting up map renderer options
	var rendererOptions = {
		map : map,
		suppressMarkers : true
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
		geocoder.geocode({
			'latLng' : latlng
		}, function(data, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var latitude = data[0].geometry.location.lat();
				var longitude = data[0].geometry.location.lng();
				var add = data[0].formatted_address; // this is the full
														// address
				$('#address').val(add);
				var url = server + "/route";

				if (markers.length == 0) {
					$.ajax({
						type : "POST",
						url : url + "/new"
					}).done(function(msg) {
						alert("Data Saved: " + msg);
						routeId = msg.routeId;
						$.ajax({
							type : "POST",
							url : url + "/add-point?x=" + longitude + "&y=" + longitude + "&id=" + routeId
						}).done(function(msg) {
							alert("Data Saved: " + msg);
						})
					});

				} else {
					$.ajax({
						type : "POST",
						url : url + "/add-point?x=" + longitude + "&y=" + longitude + "&id=" + routeId
					}).done(function(msg) {
						alert("Data Saved: " + msg);
					})
				}
			}
		});

		// set currentCoords and push it to waypoint array
		currentCoords = event.latLng;
		wps.push({
			location : currentCoords
		});

		// set firstCoords after clicking
		if (firstCoords == undefined) {
			firstCoords = currentCoords;
		}

		var org = firstCoords;
		var dest = currentCoords;

		var request = {
			origin : org,
			destination : dest,
			waypoints : wps,
			travelMode : google.maps.DirectionsTravelMode.WALKING
		};

		directionsService = new google.maps.DirectionsService();
		directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);

				if (marker != undefined) {
					marker.setMap(null);
				}

				for (i = 0; i < wps.length; i++) {
					// initialize start flag
					if (i == 0) {
						marker = new google.maps.Marker({
							position : wps[i].location,
							map : map,
							icon : 'http://maps.google.com/mapfiles/ms/micons/flag.png'
						});
					}
					// initialize middle flag
					else if ((i > 0) && (i < wps.length - 1)) {
						marker = new google.maps.Marker({
							position : wps[i].location,
							map : map,
							icon : 'http://maps.google.com/mapfiles/ms/micons/orange.png'
						});
					}
					// initialize last flag
					else {
						marker = new google.maps.Marker({
							position : wps[i].location,
							map : map,
							icon : 'http://maps.google.com/mapfiles/ms/micons/red-pushpin.png'
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
			} else
				alert('You can only have up to 8 points :(');
		});
	});

});