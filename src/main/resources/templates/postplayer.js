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
                playerIDS : $("#playerIDS").val(),
                playerNameF : $("#playerNameF").val()
            }

            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "savePlayer",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html(
                   /*         result.data.playerIDS + " " +
                            result.data.playerNameF
                            + " Post Successfully! <br>"*/
                            result.data + "</p>");
                    } else {
                        $("#postResultDiv").html("<strong>Can't Add Player</strong>");
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