$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        get_Country();

    });

});

function get_Country() {

    var search = {}
    

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getCountry",
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
           
            var html = '';
            var len = data.length;
            console.log("size of country ::"+len)
            html += '<select id = "kk" onchange="get_League(this)"><option value="0"></option>';
            for (var i = 0; i < len; i++) {
             html += '<option value="' + data[i].country_id + '">'
               + data[i].country_name
               + '</option>';
            }
            html += '</select>';
            console.log(html);
            $('#country').html(html);
            $('#countryLabel').html("Please select country :: ");
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#country').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

function get_League() {
	console.log("siva");
    var search = $("#kk").val()
    console.log(search);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getLeaguesByCountryId?countryId="+search,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";

            
            var html = '';
            var len = data.length;
            console.log("size of country ::"+len)
            html += '<select id = "ll" onchange="get_Team(this)"><option value="0"></option>';
            for (var i = 0; i < len; i++) {
             html += '<option value="' + data[i].league_id + '">'
               + data[i].league_name
               + '</option>';
            }
            html += '</select>';
            console.log(html);
            
            $('#leaque').html(html);
            $('#leaqueLabel').html("Please select league :: ");
            console.log("SUCCESS : ", data);
            
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#leaque').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}
    
    function get_Team() {
    	var search = $("#ll").val()
        console.log(search);

        $("#btn-search").prop("disabled", true);
        var leagueUrl = "getTeamsByLeagueId?leagueId="+search
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: leagueUrl,
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                    + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
                var html = '';
                var len = data.length;
                console.log("size of country ::"+len)
                html+= '<table class="table table-bordered"><thead><tr><th>Team Id</th><th>Team Name</th><th>Team size</th><th>Coach Name</th><th>Team Badge</th></tr></thead>';
                for (var i = 0; i < len; i++) {
                	var coaches = ''; 
                	if(data[i].coaches != null){
                		for(var c = 0 ; c < data[i].coaches.length; c++){
                    		coaches += data[i].coaches[c].coach_name +' ';
                    	}
                    	
                	}
                	
                    html += '<tbody><tr><td>' + data[i].team_key + '</td>'
                      + '<td>' + data[i].team_name + '</td>'
                      + '<td>' + data[i].players.length + '</td>'
                      + '<td>' + coaches + '</td>'
                      + '<td> <img src="' + data[i].team_badge + '"/></td>'
                      + '</tr></tbody>';
                }
                html+='</table';
                $('#teams').html(html);
                console.log("SUCCESS : ", data);
                $("#btn-search").prop("disabled", false);
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                    + e.responseText + "&lt;/pre&gt;";
                $('#teams').html(json);

                console.log("ERROR : ", e);

            }
        });
        

}