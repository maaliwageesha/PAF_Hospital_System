/**
 * 
 */

$(document).ready(function()
{
 $("#alertSuccess").hide();
 $("#alertError").hide();
}); 

//Click event of the SAVE Button ============================================
$(document).on("click", "#submit", function(event)
		
{
	console.log("hello")
// Clear status messages-------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
 
// Form validation----------------
var status = validateItemFormforRegister();

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
			data:$("#register-form").serialize(),
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

//For register for validation
function validateItemFormforRegister()
{
   console.log("Visted this function")
// For First Name
   if ($("#firstName").val().trim() == "")
   {
	  return "Please Enter Your First Name.";
   }
//For Last Name
   if ($("#lastName").val().trim() == "")
   {
      return "Please Enter Your Last Name.";
   }
//For Gender
   if ($('input[name="Gender"]:checked').length === 0)
   {
     return "Please Select gender.";
   }
//For NIC
   if ($("#Nic").val().trim() == "")
   {
     return "Please Enter Your NIC.";
   }
//For Address
   if ($("#Address").val().trim() == "")
   {
     return "Please Enter Your Address.";
   }
//For City
   if ($("#City").val().trim() == "")
   {
     return "Plaease Enter Your City.";
   }
//For Phone No
   if ($("#phone-number").val().trim() == "")
   {
	 return "Please Enter Your Phone No.";
   }
   var phone = $("#phone-number").val().trim();
   if (!$.isNumeric(phone)) 
   {
	 return "Enter a correct Phone No";
   }
   var pattern = /^\d{9}$/;
   if (!pattern.test(phone))
   {
	 return "Phone No should have 9 numbers without country code";
   }
//For Email
   var e = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;	
   var email = $("#email").val().trim();
   if (e.test(email) == false) 
   {
	 return "Please enter valid email address";
   }
//For Password
   if ($("#password").val().trim() == "")
   {
     return "Insert password.";
   }
//For Confirm Password
   if ($("#password-confirm").val().trim() == "")
   {
     return "Insert confirm password.";
   }
   if(($("#password").val().trim()) !=($("#password-confirm").val().trim()))
   {
	 return "passwords doesn't match";
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
	
	 $("#alertSuccess").text("");
	 $("#alertSuccess").hide();
	 $("#alertError").text("");
	 $("#alertError").hide();
	 
	var status2 = validateItemFormforUpdate();
	if (status2 != true)
	{
	  $("#alertError").text(status2);
	  $("#alertError").show();
	return;
	}
	
	
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

function validateItemFormforUpdate(){
// For First Name
   if ($("#firstName").val().trim() == "")
	 {
	 return "Insert first name.";
	 }
//For Last Name
   if ($("#lastName").val().trim() == "")
   {
   return "Insert last name.";
   }
//For NIC
   if ($("#Nic").val().trim() == "")
   {
   return "Insert NIC.";
   }
//For Email
   var e = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;	
   var email = $("#email").val().trim();
   if (e.test(email) == false) 
   {
	 return "Please enter valid email address";
   }
//For Gender
   if ($('input[name="gridRadios"]:checked').length === 0)
   {
     return "Select gender.";
   }
//For Address
   if ($("#address").val().trim() == "")
   {
     return "Insert Address.";
   }
//For Password
   if ($("#password").val().trim() == "")
   {
    return "Insert password.";
   }
//For City
   if ($("#city").val().trim() == "")
   {
    return "Insert City.";
   }
//For Phone No
   if ($("#contact").val().trim() == "")
   {
	 return "Please enter Phone No.";
   }
   var phone = $("#contact").val().trim();
   if (!$.isNumeric(phone)) 
   {
	 return "Insert a correct Phone No";
   }
   var pattern = /^\d{9}$/;
   if (!pattern.test(phone))
   {
	 return "Phone No should have 9 numbers without country code";
   }
   
   return true;
}

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
