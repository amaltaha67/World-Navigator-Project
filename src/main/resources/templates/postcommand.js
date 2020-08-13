$(document).ready(
    function() {

        // SUBMIT FORM
        $("#playerForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // PREPARE FORM DATA
            var formData = {
                mazePlayer : $("#mazePlayer").val(),
                mazeCommand : $("#mazeCommand").val(),
            }

            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "saveCommand",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                            result.data + "<br>"
                            + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                },
                error : function(e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

        }

    })