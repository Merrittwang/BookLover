function handleResult(resultData) {
    console.log("api/search called");
    console.log(resultData);

    let byTitleBodyElement = jQuery("#byTitle");
    let byGenreBodyElement = jQuery("#byGenre");
    let genres = resultData["genres"];

    // Concatenate the html tags with resultData jsonObject to create body
    let rowHTML1 = '';
    let rowHTML2 = '';

    for( let j = 0; j < 10; j++){
        rowHTML1 += '<a href="./movie-list.html?browse=true&title='+ j +'" >\n';
        rowHTML1 += j;
        rowHTML1 += "</a> \n";
        rowHTML1 += " &ensp; ";
    }
    rowHTML1 += '<a href="./movie-list.html?browse=true&title='+ '*' +'" >\n';
    rowHTML1 += "*";
    rowHTML1 += "</a> <br>\n";


    for( let j = 97; j < 123; j++){
        rowHTML1 += '<a href="./movie-list.html?browse=true&title='+ String.fromCharCode(j) +'" >\n';
        rowHTML1 += String.fromCharCode(j);
        rowHTML1 += "</a> \n";
        rowHTML1 += " &ensp; ";
    }

    for( let i = 0; i < genres.length; i++){
        rowHTML2 += '<a href="./movie-list.html?genre='+ genres[i]["name"] +'" >\n';
        rowHTML2 += genres[i]["name"];
        rowHTML2 += "</a> \n";
        if((i+1)%5 !== 0 )
            rowHTML2 += " &ensp; ";
    }

    // Append the row created to the table body, which will refresh the page
    byTitleBodyElement.append(rowHTML1);
    byGenreBodyElement.append(rowHTML2);
}

function detailSearch(){
    let titleName = document.getElementById("titleName").value;
    let year = document.getElementById("year").value;
    let directorName = document.getElementById("directorName").value;
    let starName = document.getElementById("starName").value;
    let genre = document.getElementById("genre").value;
    if(titleName || year ||  directorName || starName || genre) {
        window.location.replace("./movie-list.html?"
            + (titleName ? "&title=" + titleName : "")
            + (year ? "&year=" + year : "")
            + (directorName ? "&directorName=" + directorName : "")
            + (starName ? "&starName=" + starName : "")
            + (genre ? "&genre=" + genre : ""));
    }
}

function normalSearch(){
    let title = document.getElementById("autocomplete").value;
    window.location.replace("blist.html?title="+title)
}


//jQuery.ajax({
//    dataType: "json",  // Setting return data type
//    method: "GET",// Setting request method
//    url: "api/search", // Setting request url, which is mapped by StarsServlet in Stars.java
//    success: (resultData) => handleResult(resultData) // Setting callback function to handle data returned successfully by the SingleStarServlet
//});