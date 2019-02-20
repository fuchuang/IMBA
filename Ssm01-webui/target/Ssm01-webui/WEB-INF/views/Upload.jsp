<html>


<body>
<script type="text/javascript">
    function fileupload2(){
    var formData = new FormData($("#form2")[0]);
    $.ajax({
        url:'teacher/filesend',
        type:'post',
        data:formData,
        //必须false才会自动加上正确的Content-Type
        contentType: false,
        //必须false才会避开jQuery对 formdata 的默认处理
        //XMLHttpRequest会对 formdata 进行正确的处理
        processData: false,
        success:function(data){
            alert(data);
        },
        error:function(data){
            alert(data);
            alert("后台发生异常");
        },
        cache:false,
        async:true
    });
    }
</script>



<h2>Hello World!</h2>
<form  id ="form2" action="/teacher/filesend" enctype="multipart/form-data" method="post">
    <input type = "file" name= "file" />
    <input type="text" name="name" value="dzf"/>
    <input type="text" name="course_id" value="1"/>

    <input type="button" id = "button2" value="ajax上传" onclick="fileupload2()">
    <input type ="submit" value="直接上传">
</form>
</body>
</html>
