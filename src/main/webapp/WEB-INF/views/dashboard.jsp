<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="http://assets.ziggeo.com/css/ziggeo-betajs-player.min.css" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="http://unslider.com/unslider.min.js"></script>
<script
	src="//assets.ziggeo.com/js/ziggeo-jquery-json2-betajs-player.min.js"></script>
<script>ZiggeoApi.token = "a66a10279f51ef5d416edb09c78851ff";</script>

<!-- Pacifico font -->
<link href='http://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>


<body>

	<div id="wonderlust-map" style="height: 1080px;"></div>

	<ziggeo></ziggeo>

	<a class="check-in-link" data-toggle="modal" href="#textModal">
		<div class="check-in-button pin-button" data-toggle="modal">
			Check In</div>
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

							<a class="left carousel-control" id="carousel-buttons"
								href="#myCarousel" data-slide="prev"> <i
								class="fa fa-chevron-left slider-button"></i>
							</a> <a class="right carousel-control" id="carousel-buttons"
								href="#myCarousel" data-slide="next"> <i
								class="fa fa-chevron-right slider-button"></i>
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
									<span class="attraction">Eiffel Tower</span> <span
										class="location">Champ de Mars, 75007, Paris</span>
								</div>
								</row>
							</div>

							<!--Comments-->

							<div class="comments-holder">

								<row>
								<div class="col-xs-2">
									<div class="avatar">
										<img src="<c:url value="/resources/img/heewon.png"/>" />
									</div>
								</div>
								<div class="col-xs-10 comment-input-holder">
									<form>
										<div class="form-group">
											<textarea class="form-control status-box" rows="2"
												placeholder="How was your experience?"></textarea>
										</div>
									</form>
								</div>
								</row>

								<row>
								<div class="col-xs-4 col-xs-offset-8">
									<div class="button-group pull-right">
										<p class="counter">140</p>
										<a href="#" class="post-button"><i
											class="fa fa-pencil pencil-button"></i></a>
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
							<div class="check-in-button">Pin It!</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>




	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js"/>"></script>

	<!-- Google Maps stuff -->
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>

	<script src="<c:url value="/resources/js/dashboard.js"/>">
</script>
</body>
</html>