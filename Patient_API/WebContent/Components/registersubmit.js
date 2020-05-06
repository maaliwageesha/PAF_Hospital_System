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
			$("#alertSuccess").text("Saved successfully.");
			 $("#alertSuccess").show();
			 	window.location.href="/PatientAPI/home.jsp";
		
		}else if(status=="error")
			{
			$("#alertError").text("Error while saving");
			 $("#alertError").show();
			
			}else{
				
				$("#alertError").text("Unknown error while saving");
				 $("#alertError").show();
			}
}

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

// NIC
if ($("#Nic").val().trim() == "")
{
return "Insert NIC.";
}
//Address
if ($("#Address").val().trim() == "")
{
return "Insert Address.";
}
//City
if ($("#City").val().trim() == "")
{
return "Insert City.";
}
//Phone no
if ($("#phone-number").val().trim() == "")
{
return "Insert phone number.";
}

//Email
if ($("#email").val().trim() == "")
{
return "Insert email.";
}
//Password
if ($("#password").val().trim() == "")
{
return "Insert password.";
}
//Confirm Password
if ($("#password-confirm").val().trim() == "")
{
return "Insert confirm password.";
}


return true;
}

//Update operation

$(document).on("click", ".btnUpdate", function(event)
		{
	
           $("#hidpatientIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val()); 
           $("#Nic").val($(this).closest("tr").find('td:eq(1)').text());  
           $("#firstName").val($(this).closest("tr").find('td:eq(2)').text());
           $("#lastName").val($(this).closest("tr").find('td:eq(3)').text());  
          
           $("#email").val($(this).closest("tr").find('td:eq(4)').text());
           $(".gridRadios").val($(this).closest("tr").find('td:eq(5)').text());
           $("#address").val($(this).closest("tr").find('td:eq(6)').text());
           $("#password").val($(this).closest("tr").find('td:eq(7)').text());
           $("#city").val($(this).closest("tr").find('td:eq(8)').text());
           $("#contact").val($(this).closest("tr").find('td:eq(9)').text());

		
		});

$(document).on("click", "#btnSave", function(event)
		{
	      $.ajax(
				{
					url:"patientAPI",
					type:"PUT",
					data:$("#formPatient").serialize(),
					dataType:"text",
					complete:function(response,status)
					{
						
						onItemSaveComplete1(response.responseText,status);
					}
				});
	      
function  onItemSaveComplete1(response,status)
{  
	if (status == "success")
	{ 
		var resultSet = JSON.parse(response); 
    

       if (resultSet.status.trim() == "success")
       {   
	     $("#alertSuccess").text("Successfully saved.");
	     $("#alertSuccess").show(); 

         $("#divItemsGrid").html(resultSet.data);
      } else if (resultSet.status.trim() == "error")
      {    
	     $("#alertError").text(resultSet.data);
	     $("#alertError").show(); 
      } 

      } else if (status == "error")
      {  
	     $("#alertError").text("Error while saving.");
	     $("#alertError").show();
      } else 
      {  
	     $("#alertError").text("Unknown error while saving..");
	     $("#alertError").show();
      } 

      $("#hidpatientIDSave").val("");
      $("#formPatient")[0].reset();
	
	

} 
	

		});
//Delete Operation
$(document).on("click", ".btnRemove", function(event)
		{  
	      $.ajax (
	    	{   
	    	  url : "patientAPI",
	    	  type : "DELETE", 
	    	  data : "patientID=" + $(this).data("patientid"),
	    	  dataType : "text", 
	    	  complete : function(response, status) 
	    	   {   
	    		  onItemDeleteComplete(response.responseText, status); 
	    	   } 
	    }); 

function onItemDeleteComplete(response, status)
 {
	 if (status == "success") 
	 {  
		 var resultSet = JSON.parse(response); 

         if (resultSet.status.trim() == "success") 
         {   
        	$("#alertSuccess").text("Successfully deleted.");
        	$("#alertSuccess").show(); 

            $("#divItemsGrid").html(resultSet.data);
         } else if (resultSet.status.trim() == "error")
            {   
        	   $("#alertError").text(resultSet.data);  
        	   $("#alertError").show(); 
        	} 

    } else if (status == "error")
        {  
    	    $("#alertError").text("Error while deleting.");
    	    $("#alertError").show();
    	}
        else
         {   $("#alertError").text("Unknown error while deleting..");
             $("#alertError").show(); 
         } 
  } 
		});
