<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - Contact Us</title>
<meta name="keywords" content="station shop, contact page, maps, free templates, website templates, CSS, HTML" />
<meta name="description" content="Station Shop, Contact Page, free CSS template provided by templatemo.com" />
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
        	
            <h1>Contact Information</h1>
            <div class="content_half float_l">
				<h4>Send us a message now!</h4>
                <p>Send us your feedback to help us help you give us your money. Thanks!</p>
                <div id="contact_form">
			   	<s:if test="feedbackSent == true">
					<s:if test="feedbackSentSuccessful == true">
						<div class="feedbacksentsuccess">
						Successfully sent feedback. Thanks!
						</div>
					</s:if>
					<s:else>
						<div class="feedbacksentfailure">
						Unable to send feedback. Try again later.
						</div>	
					</s:else>
				</s:if>
                
 					<div class="contactfielderror">
						<s:fielderror />
 					</div>
					<s:form action="sendfeedback" theme="simple">
                        <label for="author">Name:</label><s:textfield name="author" cssClass="required input_field" theme="simple" />
                        <div class="cleaner h10"></div>
						<label for="email">Email:</label><s:textfield name="email" cssClass="validate-email required input_field" theme="simple" />
                        <div class="cleaner h10"></div>

						<label for="subject">Subject:</label><s:textfield name="subject" cssClass="input_field" theme="simple" />
                        <div class="cleaner h10"></div>
                        
                        <label for="text">Message:</label><s:textarea name="body" rows="0" cols="0" cssClass="required" theme="simple" />
                        <div class="cleaner h10"></div>
                        
                        <s:submit value="Send" cssClass="submit_btn float_l" theme="simple" />                        
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r" />
					</s:form>
                <!-- 
                   <form method="post" name="contact" action="#">
                        
                        <label for="author">Name:</label> <input type="text" id="author" name="author" class="required input_field" />
                        <div class="cleaner h10"></div>
                        <label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                        <div class="cleaner h10"></div>
                        
						<label for="subject">Subject:</label> <input type="text" name="subject" id="subject" class="input_field" />

						<div class="cleaner h10"></div>
        
                        <label for="text">Message:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
                        <div class="cleaner h10"></div>
                        
                        <input type="submit" value="Send" id="submit" name="submit" class="submit_btn float_l" />
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r" />
                        
            	</form>
            	-->
                </div>
            </div>
        <div class="content_half float_r">
        	<h4>Mailing Address</h4>
        	<h6><strong>ISU CS Dept</strong></h6>
          226 Atanasoff Hall,<br />
            	Ames, IA 50011<br /><br />
            
				<strong>Phone:</strong> 020-050-1920<br />
		<br />
        </div>
        
        <div class="cleaner h40"></div>
        
        <iframe width="680" height="340" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=atanasoff+hall,+Iowa+State+University,+Ames,+IA&amp;aq=&amp;sll=42.02116,-93.63768&amp;sspn=0.024262,0.05991&amp;t=m&amp;ie=UTF8&amp;hq=&amp;hnear=Atanasoff+Hall,+Ames,+Story,+Iowa+50011&amp;ll=42.030424,-93.647289&amp;spn=0.021676,0.058193&amp;z=14&amp;output=embed"></iframe>
            
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>