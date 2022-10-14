/**
 * Retrieve parameter from request URL, matching by parameter name
 * @param target String
 * @returns {*}
 */



function handleResultCount(count) {
  let resultCountElement = jQuery("#book_list_count");
  resultCountElement.append("<header class=\"header-content\"><p>" + count  +" results found</p></header>");
}


/**
 * Handles the data returned by the API, read the jsonObject and populate data into html elements
 * @param resultData jsonObject
 */
function handleBookResult(resultData) {

  console.log("search book called");
  console.log(resultData);

//  handleDefaultCondition(resultData);
  window.localStorage.clear();
  window.localStorage.setItem("searchResult", window.location.href);

//  handleResultCount(resultData.count);
//  resultData = resultData.result;

  let bookTableBodyElement = jQuery("#book_list_body");

//  const result1 = resultData.length;
  console.log(resultData);
  // Iterate through resultData, no more than 10 entries
  for (let i = 0; i < resultData.length; i++) {
    // Concatenate the html tags with resultData jsonObject
    let rowHTML = " <div>";
    rowHTML += '<div class="book_list_block"> ';
    rowHTML += "<h3>"+'<a href="book.html?id=' + resultData[i]['book_id'] + '">' +
            resultData[i]["book_name"] + "\n</a>\n" +
            "<span>" + resultData[i]["years"] + "</span>" + "\n</h3>\n";
    rowHTML += '<div class="book_row"> ';
    rowHTML += '<div class="book_info"> \n';
    rowHTML += "<p> Likes: " + resultData[i]["likes"] + "</p> \n";
    rowHTML += "<p> Author: " + resultData[i]["author"] + "</p> \n";


    rowHTML += "</p></div>\n";
    rowHTML += '<div class="add_to_cart"> \n ' +
               '<h4> $' + resultData[i]["points"] +'</h4> \n';
    rowHTML += '<input type="submit" class="btn btn-outline-dark" value="Add to Cart" ' +
                'onclick="addBook(\'' + resultData[i]["book_id"]  + '\', \'' + resultData[i]["book_name"] + '\')" /> \n' ;
    rowHTML += '</div>\n ' +
               '</div> \n';
    rowHTML += '</div>\n ' +
               '</div> \n';

    // Append the row created to the table body, which will refresh the page
    bookTableBodyElement.append(rowHTML);
  }
}

/**
 *  Handle add to shopping cart
 */
function addBook(id, title){
  jQuery.ajax({
    method: "POST", // Setting request method
    data: {"add": id, "title": title},
    url: "cart",
    success: () => {
        alert("Successfully added!");
    },
    error: () => {
      alert("Fail to add");
    }
  });
}


/**
 * Pre-conditions setup for html elements
 */
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const Url = "/books/bookId/" + urlParams.get('B');

//let currentPage = getParameterByName("page");
//let itemPerPage = getParameterByName("ipp");
//let titleOrder = getParameterByName("titleOrder");
//let ratingOrder = getParameterByName("ratingOrder");
//let sortBy = getParameterByName("sortBy");

let title = urlParams.get('title');
//let year = getParameterByName("year");
//let directorName = getParameterByName("directorName");
//let starName = getParameterByName("starName");
//let genre = getParameterByName("genre");
//let browse = getParameterByName("browse");
//let fulltext = getParameterByName("fulltext");

function handleDefaultCondition(resultData){
  let page = currentPage? parseInt(currentPage): 1;
  let totalPage = Math.ceil(resultData.count/(itemPerPage ? parseInt(itemPerPage): 10));
  if(page<=1)
    $("#movie_list_pagination_prev").attr("disabled",true);
  if(totalPage<=page)
    $("#movie_list_pagination_next").attr("disabled",true);
  if(resultData.count <= 0) {
    $("#movie_list_page_count").attr("disabled", true);
    $("#movie_list_title").attr("disabled", true);
    $("#movie_list_rating").attr("disabled", true);
  }
  else {
    if (sortBy)
      $("#movie_list_order_sort").find("option[value='" + sortBy + "']").attr("selected",true);
    if (itemPerPage)
      $("#movie_list_page_count").find("option[value='" + itemPerPage + "']").attr("selected",true);
    if (titleOrder)
      $("#movie_list_title").val(titleOrder === "DESC" ? "Title \u25BC": "Title \u25B2");
    if (ratingOrder)
      $("#movie_list_rating").val(ratingOrder === "DESC" ? "Rating \u25BC": "Rating \u25B2");
  }
}


/**
 * HTML element state change handlers
 */
$("#movie_list_title").click(()=>{
  titleOrder = titleOrder === "ASC" || titleOrder === null ? "DESC": "ASC";
  updateWindowURL();
});

$("#movie_list_rating").click(()=>{
  ratingOrder = ratingOrder === "DESC"|| ratingOrder === null? "ASC":"DESC";
  updateWindowURL();
});

$("#movie_list_order_sort").change(()=>{
  sortBy = $("#movie_list_order_sort").val();
  updateWindowURL();
});

$("#movie_list_page_count").change(()=>{
  itemPerPage = $("#movie_list_page_count").val();
  currentPage = String(1);
  updateWindowURL();
});

$("#movie_list_pagination_prev").click(()=>{
  currentPage = String(parseInt(currentPage)-1);
  updateWindowURL();
});

$("#movie_list_pagination_next").click(()=>{
  let page = currentPage? parseInt(currentPage): 1;
  currentPage = String(page+1);
  updateWindowURL();
});

// update website link to activate HTTP request from server
function updateWindowURL() {
  let newURL = "movie-list.html?"
      + (sortBy? "sortBy=" + sortBy:"")
      + (title? "&title=" + title:"")
      + (year? "&year=" + year:"")
      + (directorName? "&directorName=" + directorName:"")
      + (starName? "&starName=" + starName:"")
      + (genre? "&genre=" + genre:"")
      + (titleOrder? "&titleOrder=" + titleOrder:"")
      + (ratingOrder? "&ratingOrder=" + ratingOrder:"")
      + (currentPage? "&page=" + currentPage: "")
      + (itemPerPage? "&ipp=" + itemPerPage: "")
      + (browse? "&browse=" + browse: "")
      + (fulltext? "&fulltext=" + fulltext: "");
  window.location.replace(newURL);
}

if(window.location.href.split("/")[4] === "movie-list.html" ||
    window.location.href.split("/")[4] === "movie-list.html?")
  window.location.replace("index.html");

/**
 * Once this .js is loaded, following scripts will be executed by the browser
 */
// Makes the HTTP GET request and registers on success callback function handleStarResult
jQuery.ajax({
  dataType: "json", // Setting return data type
  method: "GET", // Setting request method
  url: "books/search?"
//      + "sortBy=" + sortBy
//      + "&titleOrder=" + titleOrder
//      + "&ratingOrder=" + ratingOrder
//      + "&page=" + currentPage
//      + "&ipp=" + itemPerPage
      + "title=" + title
//      + "&year=" + year
//      + "&directorName=" + directorName
//      + "&starName=" + starName
//      + "&genre=" + genre
//      + "&browse=" + browse
//      + "&fulltext=" + fulltext
      ,
  success: (resultData) => handleBookResult(resultData["data"]),
});
