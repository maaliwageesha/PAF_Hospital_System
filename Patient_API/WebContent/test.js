$(document).ready(function()
{
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();0
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
	{
		url : "ItemsAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			 onItemSaveComplete(response.responseText, status);
		}
	});
});



function onItemSaveComplete(response, status)
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
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}

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