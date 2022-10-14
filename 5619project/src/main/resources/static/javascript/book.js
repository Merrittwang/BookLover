/**
 * Retrieve parameter from request URL, matching by parameter name
 * @param target String
 * @returns {*}
 */


/**
 * Handles the data returned by the API, read the jsonObject and populate data into html elements
 * @param resultData jsonObject
 */
function handleResult(resultData) {
    console.log("book called");
    resultData = resultData['data'];
    console.log(resultData);


    let bookInfoBodyElement = jQuery("#single_book_body");

    // Concatenate the html tags with resultData jsonObject to create body
    let rowHTML = ' <br>';
    rowHTML +=
        "<h3>\n" +
        "<a href='#'>"
        + resultData["book_name"] +  '\n</a>\n' +
        "\n</h3>\n";
    rowHTML += '<div  class="book_row"> \n';
    rowHTML += "<div class=\"book_info\"> \n"
    rowHTML += "<p> Year: " + resultData["years"] + "</p> \n";
    rowHTML += "<p> Likes: " + resultData["likes"] + "</p> \n";
    rowHTML += "<p> Author: " + resultData["author"] + "</p> \n";


    rowHTML += '<div class="add_to_cart"> \n ' +
        '<h4> $' + resultData["points"] +'</h4> \n';
    rowHTML += '<input type="submit" class="btn btn-outline-dark" value="Add to Cart" ' +
        'onclick="addBook(\'' + resultData["book_id"]  + '\', \'' + resultData["book_name"] + '\')" /> \n' ;
    rowHTML += '</div>\n ' +
        '</div> \n';

    // Append the row created to the table body, which will refresh the page
    bookInfoBodyElement.append(rowHTML);
}

/**
 *  Handle add to shopping cart
 */
function addBook(id, title){
    jQuery.ajax({
        method: "POST", // Setting request method
        data: {"add": id, "title": title},
        url: "api/cart",
        success: () => {
            alert("Successfully added!");
        },
        error: () => {
            alert("Fail to add");
        }
    });
};



/**
 * Once this .js is loaded, following scripts will be executed by the browser\
 */

// Get id from URL
let queryString = window.location.search;
let urlParams = new URLSearchParams(queryString);
let bookId = urlParams.get('id');


// Makes the HTTP GET request and registers on success callback function handleResult
jQuery.ajax({
    dataType: "json",  // Setting return data type
    method: "GET",// Setting request method
    url: "books/bookId?id=" + bookId, // Setting request url, which is mapped by StarsServlet in Stars.java
    success: (resultData) => handleResult(resultData) // Setting callback function to handle data returned successfully by the SingleStarServlet
});