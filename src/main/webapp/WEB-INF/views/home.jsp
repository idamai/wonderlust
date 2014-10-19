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


<body id="landing-page-bg">

	<div class="landing-page-holder">

		<row>
		<div class="col-xs-12">
			<div class="logo-holder">
				<img src="<c:url value="/resources/img/logo.png"/>">
			</div>
		</div>
		</row>

		<row>
		<div class="col-xs-12 headlines">
			<div class="logo-divider"></div>
			<span class="landing-subcopy">Discover inspiring travel
				moments</span>
		</div>
		</row>



		<row>
		<div class="col-xs-12">
			<div class="form-container" id="inquiry-form">
				<form id="form" action="<c:url value='/login.do'/>" method="POST">

					<c:if test="${not empty param.err}">
						<div>
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</div>
					</c:if>
					<c:if test="${not empty param.out}">
						<div>You've logged out successfully.</div>
					</c:if>
					<c:if test="${not empty param.time}">
						<div>You've been logged out due to inactivity.</div>
					</c:if>

					<div class="form-field">
						<input type="text" name="username" class="enter-info input-top"
							value="" placeholder="Email">
					</div>
					<div class="form-field">
						<input type="password" name="password" class="enter-info" value=""
							placeholder="Password">
					</div>
					<div class="submit-area">
						<div class="submit-items">
							<input type="submit" value="Create your story"
								class="submit-button submit-form">
						</div>
					</div>


				</form>

			</div>
		</row>

	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>