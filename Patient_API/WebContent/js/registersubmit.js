/**
 * 
 */

$(document).ready(function()
{
 $("#alertSuccess").hide();
 $("#alertError").hide();
}); 


//SAVE ============================================
$(document).on("click", "#submit", function(event)
{
// Clear status msges-------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation----------------
var status = validateItemForm();
// If not valid-------------------
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid-----------------------
$.ajax(
		{
			url:"patientAPI",
			type:"POST",
			data:$("#booking-form").serialize(),
			dataType:"text",
			complete:function(response,status)
			{
				onItemSaveComplete(response.responseText,status);
			}
		});
function  onItemSaveComplete(response,status){
	
	if(status=="success")
		{
		//var resultSet=JSON.parse(response);
		
		//if(resultSet.status.trim()=="success")
			//{
			$("#alertSuccess").text("Saved successfully.");
			 $("#alertSuccess").show();
			 	window.location.href="/PatientAPI/home.jsp";
			//}
		}else if(status=="error")
			{
			$("#alertError").text("Error while saving");
			 $("#alertError").show();
			
			}else{
				
				$("#alertError").text("Unknown error while saving");
				 $("#alertError").show();
			}
}
/*var student = getStudentCard($("#txtName").val().trim(),
 $('input[name="rdoGender"]:checked').val(),
 $("#ddlYear").val());
 $("#colStudents").append(student);

 $("#alertSuccess").text("Saved successfully.");
 $("#alertSuccess").show();

 $("#formStudent")[0].reset();*/
});


function validateItemForm()
{
	console.log("Visted this function")
// NAME
if ($("#firstName").val().trim() == "")
 {
 return "Insert first name.";
 }

if ($("#lastName").val().trim() == "")
{
return "Insert last name.";
}
// GENDER
if ($('input[name="Gender"]:checked').length === 0)
 {
 return "Select gender.";
 }


if ($("#Nic").val().trim() == "")
{
return "Insert NIC.";
}

if ($("#Address").val().trim() == "")
{
return "Insert Address.";
}

if ($("#City").val().trim() == "")
{
return "Insert City.";
}

if ($("#phone-number").val().trim() == "")
{
return "Insert phone number.";
}


if ($("#email").val().trim() == "")
{
return "Insert email.";
}

if ($("#password").val().trim() == "")
{
return "Insert password.";
}

if ($("#password-confirm").val().trim() == "")
{
return "Insert confirm password.";
}


return true;
}
