GET: $(document).ready(
    function() {

        // GET REQUEST
        $("#remove").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "startGame",
                success : function(result) {
                    if (result.status == "success") {
                        $("#getResultDiv").html(
                            result.data + "</p>");
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error : function(e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })