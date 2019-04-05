$(document).ready(function () {
    $("#submit").on("click",function () {
        var n=$("#input-n").val();
        if(n==""){
            $("#input-n").focus();
            return;
        }

        var k=$("#input-k").val();
        if(n==""){
            $("#input-k").focus();
            return;
        }

        var arr=$("#input-arr").val();
        if(n==""){
            $("#input-arr").focus();
            return;
        }

        var data={
            n:n,
            k:k,
            arr:arr
        }

        $.ajax({
            url:"/api/ahihi/processCount",
            data: JSON.stringify(data),
            dataType:'json',
            type:'POST',
            contentType: "application/json",
            success: function (data) {
                if(data.success==false){
                    $("#output").text(data.message);
                } else {
                    console.log(data);
                    $("#output").text(data.data);
                }

            },
            error: function(xhr, status, err)  {
                console.log(err.toString());
            }
        })

    }) ;
});