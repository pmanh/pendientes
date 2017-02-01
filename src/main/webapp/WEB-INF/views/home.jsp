<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <title>Mis pendientes</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css(.) styles/vendor.css -->
    <!-- bower:css -->
    <link rel="stylesheet" href="app/bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="app/bower_components/bootstrap/dist/css/bootstrap.min.css" />
    
    <link rel="stylesheet" href="app/font-awesome-4.7.0/css/font-awesome.min.css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
    <!-- endbower -->
    <!-- endbuild -->
    <!-- build:css(.tmp) styles/main.css -->
    <link rel="stylesheet" href="app/app/styles/style.min.css">
    <!-- endbuild -->
     <script src="app/bower_components/jquery/dist/jquery.js"></script>
    <!-- jqwidgets -->
	
    <script type="text/javascript">
    	var ctxPath = "app/app/";
    </script>
</head>
<body ng-app="FamsaPendings">
	<!--[if lte IE 8]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <!-- Add your site or application content here -->
    <div class="header">
      <div class="navbar navbar-default" role="navigation">
        <div class="container">
          <div class="navbar-header">

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#js-navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#/"><img style="width: 64px;" src="app/app/images/famsa.png" alt="Dispute Bills"></a>
            
          </div>

          <div class="collapse navbar-collapse" id="js-navbar-collapse">

            <ul class="nav navbar-nav">
              <li><a href="#/">Mis pendientes</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div class="container" >
    	<div ng-view=""></div>
    </div>

    <div class="footer">
    </div>
    
    <!-- build:js(.) scripts/vendor.js -->
    <!-- bower:js -->   
    <script src="app/bowercomponents/angular/angular.js"></script>
    <script src="app/bowercomponents/bootstrap/dist/js/bootstrap.js"></script>
    <script src="app/bowercomponents/bootstrap-validator/dist/validator.js"></script>
    <script src="app/bowercomponents/angular-animate/angular-animate.js"></script>
    <script src="app/bowercomponents/angular-cookies/angular-cookies.js"></script>
    <script src="app/bowercomponents/angular-resource/angular-resource.js"></script>
    <script src="app/bowercomponents/angular-route/angular-route.js"></script>
    <script src="app/bowercomponents/angular-sanitize/angular-sanitize.js"></script>
    <script src="app/bowercomponents/angular-touch/angular-touch.js"></script>
    <script src="app/bowercomponents/at-table/dist/angular-table.min.js"></script>
    
    <!-- endbuild -->

        <script src="app/app/scripts/bootbox.min.js"></script>
        <!-- build:js({.tmp,app}) scripts/scripts.js -->
        <script src="app/app/scripts/app.js"></script>
        <script src="app/app/scripts/services/services.js"></script>
        <script src="app/app/scripts/controllers/main.js"></script>
        <!-- endbuild -->
 </body>
</html>