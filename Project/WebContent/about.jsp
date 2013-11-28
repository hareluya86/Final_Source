<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - About Our Company</title>
<meta name="keywords" content="station shop, theme, about us, company, free templates, web design, CSS, HTML" />
<meta name="description" content="Station Shop, About Us, Company, free CSS template by templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>

</head>

<body>

<div id="templatemo_wrapper">
    <s:action name="webcontrol_header" executeResult="true" />	
    
    <div id="templatemo_main">
   		<div id="sidebar" class="float_l">
		    <s:action name="webcontrol_categories" executeResult="true" />
        </div>
        <div id="content" class="float_r">
        <h1>About Us</h1>
        	<h2>History of our online shop</h2>
        <p>Nam cursus facilisis nibh nec eleifend. Mauris nulla leo, tempus ac laoreet in, aliquet eu sem. Nullam est est, imperdiet vitae mollis nec, aliquet varius ante. Donec laoreet <a href="#">eleifend velit a tristique</a>. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed vehicula elit vel ante venenatis laoreet.</p>
        <ul class="templatemo_list">
        	<li>Donec aliquam metus a odio molestie eu consequat.</li>
            <li>Sed a rutrum risus, nam sed ligula et nunc fermentum.</li>
            <li>Maecenas sit amet diam quis sem euismod porttitor.</li>
            <li>Aliquam fermentum cursus risus aliquam erat volutpat.</li>
            <li>Sed fermentum tempus enim, eget iaculis purus imperdiet eget.</li>
		</ul>
        <div class="cleaner h20"></div>
        <h3>Background of our company</h3>
		<p>Nam nec leo. Curabitur quis eros <a href="#">a arcu feugiat</a> egestas. Nunc sagittis, dui non porttitor tincidunt, mi tortor tincidunt sem, et aliquet mi tortor eu turpis. Ut nisi ligula, viverra ac, placerat sed, ultricies vitae, neque. Morbi feugiat neque non odio eleifend pulvinar. In risus lacus, consequat eu porta ac, mattis a lacus. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</p>
        <div class="cleaner"></div>
        <blockquote>Pellentesque vulputate cursus arcu vel pellentesque. Etiam facilisis imperdiet enim at tempus. Ut tincidunt venenatis est, quis viverra quam scelerisque vel. Aenean eu tellus a arcu blandit lobortis.
        </blockquote>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->

    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>