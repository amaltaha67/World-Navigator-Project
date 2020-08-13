GET: $(document).ready(
    function() {

        // GET REQUEST
        $("#getAllPlayers").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "getPlayers",
                success : function(result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data,
                            function(i, player) {
                               var user = "player IDS  "
                                    + player.playerIDS + " " + player.playerNameF + "<br>";
                                $('#getResultDiv .list-group').append(
                                    user)
                            });
                        console.log("Success: ", result);
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