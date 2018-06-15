$.fn.fileUploader = function (filesToUpload, sectionIdentifier) {
    var fileIdCounter = 0;

    this.closest(".files").change(function (evt) {
        var output = [];

        for (var i = 0; i < evt.target.files.length; i++) {
            fileIdCounter++;
            var file = evt.target.files[i];
            var fileId = sectionIdentifier + fileIdCounter;

            filesToUpload.push({
                id: fileId,
                file: file
            });

            var removeLink = "<a class=\"removeFile\" href=\"#\" data-fileid=\"" + fileId + "\"><button id=\"myButton\">Remove</button></a>";

            output.push("<li class=\"mesLi\"><strong class=\"mesLi\">", file.name, "</strong> - ", file.size, " bytes. ", removeLink, "</li> ");
        };

        $(this).children(".fileList")
            .append(output.join(""));

        //reset the input to null - nice little chrome bug!
        evt.target.value = null;
    });

    $(this).on("click", ".removeFile", function (e) {
        e.preventDefault();

        var fileId = $(this).parent().children("a").data("fileid");

        // loop through the files array and check if the name of that file matches FileName
        // and get the index of the match
        for (var i = 0; i < filesToUpload.length; ++i) {
            if (filesToUpload[i].id === fileId)
                filesToUpload.splice(i, 1);
        }

        $(this).parent().remove();
    });

    this.clear = function () {
        for (var i = 0; i < filesToUpload.length; ++i) {
            if (filesToUpload[i].id.indexOf(sectionIdentifier) >= 0)
                filesToUpload.splice(i, 1);
        }

        $(this).children(".fileList").empty();
    }

    return this;
};

(function () {
    var filesToUpload = [];

    var files1Uploader = $("#files1").fileUploader(filesToUpload, "files1");
    

    $("#uploadBtn").click(function (e) {
        e.preventDefault();
        var champ_prenom = $("#pour_prenom").val();
        var champ_nom = $("#pour_nom").val();
        var champ_courriel = $("#pour_courriel").val();
        var values_choix_programme = [];
        
        $('input[name="choix_programme"]:checked').each(function(i, item) {
        	values_choix_programme.push(item.value);
        });
      
        var values_choix_session = [];
        $('input[name="choix_session"]:checked').each(function(i, item) {
        	values_choix_session.push(item.value);
        });

        
        var formData = new FormData();
        formData.append("prenom", champ_prenom);
        formData.append("nom", champ_nom);
        formData.append("courriel", champ_courriel);
        
        for (var i = 0, len = values_choix_programme.length; i < len; i++) {
        	formData.append('choix_programme', values_choix_programme[i]);
            
        }
        
        for (var i = 0, len = values_choix_session.length; i < len; i++) {
        	formData.append('choix_session', values_choix_session[i]);
            
        }
        
        
        for (var i = 0, len = filesToUpload.length; i < len; i++) {
            formData.append("files", filesToUpload[i].file);
            
        }
       
        if(champ_prenom !== "" && champ_nom !=="" && champ_courriel !== "" 
        	&& values_choix_programme.length>0  && values_choix_programme.length>0){
        	console.log("hello world le pro!!!"+ values_choix_programme );
        	 $.ajax({
             	type: "POST",
                 enctype: 'multipart/form-data',
                 url: "http://localhost:8080/ProjetFinalDevSite1/SoumettreDossierEtudiantServlet",
                 data: formData,
                 processData: false,
                 contentType: false,
                 success: function (result) {
                	 files1Uploader.clear();
                     console.log("nom : "+formData.get('nom')); 
                     $("#container").html("");
                     $("#result").html(result);
                 },
                 error: function (data) {
                     alert("ERROR - Contact admin please!!!");
                 }
             });
        	
        }

       
    });
})()