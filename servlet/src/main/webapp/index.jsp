<%@page import="ru.eltex.DateClass"%>
<%@page import="ru.eltex.ServletTomcat"%>
<%
String header = "USERS PAGE Servlet";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
     <title>
        <meta charset="UTF-8" />
        <%= header %>
     </title>
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
    $.get("/servlet/get_users",function(data){
        console.log(data);
        var line="";

        $(".listOfUsers").html(line);

         if (typeof(data)=="object"){
            for (let i=0; i<data.length; i++){
                line += data[i].id +"  "+ data[i].fio +"  "+ data[i].phone + "<br/>" ;
            }
            $(".listOfUsers").html(line);
         } else{
            $(".listOfUsers").html(data);
         }
    });
});

function getAllUsers() {
    $.get("/servlet/get_users",function(data){
        console.log(data);
        var line="";

        $(".listOfUsers").html(line);

         if (typeof(data)=="object"){
            for (let i=0; i<data.length; i++){
                line += data[i].id +"  "+ data[i].fio +"  "+ data[i].phone + "<br/>" ;
            }
            $(".listOfUsers").html(line);
         } else{
            $(".listOfUsers").html(data);
         }
    });
}

function getUser() {
var idUser = document.getElementById('numberUser').value;
    $.get("/servlet/get_user/"+idUser,function(data){
        console.log(data);
        if (typeof(data)=="object"){
            $(".Users").html(data.id + " " + data.fio + " " + data.phone);
        } else{
            $(".Users").html(data);
        }

    });
}

function deleteUser() {
var idUser = document.getElementById('numberUser').value;
    $.get("/servlet/remove_user/"+idUser,function(data){
        console.log(data);
        $(".Users").html(data);
        getAllUsers()
    });

}


function createUsers() {
    $.get("/servlet/create",function(data){
        console.log(data);
        $(".Users").html(data);
        getAllUsers()

    });
}
</script>

<body>
<br/>
<div class="container">
    <div class="row">
        <div class="col-md-6" style="height:777px;
                            width:777px;
                            border:5px solid #AAAAAA;
                            background-color:#AAAAFF;">

            <font size="5" color="00FFFF"> List of Users from DB:</font>
            <br/>
            <font class="listOfUsers" size="4">Loading...</font>
        </div>


        <div class="col-md-6" style="height:777px;
                            width:777px;
                            border:5px solid #AAAAAA;
                            background-color:#AAAAFF;">
            <font size="5" color="00FFFF"> Choose User:</font>
            <br/>
            <input id="numberUser" type="text" />
            <br/>
            <button type="button"  onclick="getUser()">Show data of choosen User</button>
            <br/>
            <font class="Users" size="4"></font>
            <br/>
            <br/>
            <br/>
            <button type="button"  onclick="deleteUser()">Delate choosen User</button>
            <button type="button"  onclick="createUsers()">Create 5 new Users</button>
            <button type="button"  onclick="getAllUsers()">Refresh</button>
             <br/>
             <font class="Date" size="4"><%= new java.util.Date() %></font>
            <br/>


        </div>
    </div>
</div>

</body>
</html>
