

function handleLookup(query, doneCallback) {
    console.log("autocomplete initiated")
    let cachedResult = fetchCachedResult(query);
    if (cachedResult != null) {
        console.log("Past result found in the Cache! Retrieved from cache");
        console.log("Retrieved from Cache:");
        console.log(JSON.parse(cachedResult));
        doneCallback( { suggestions: JSON.parse(cachedResult) } );
        return;
    }

    // sending the HTTP GET request to the Java Servlet endpoint hero-suggestion
    // with the query data
    jQuery.ajax({
        "method": "GET",
        // generate the request url from the query.
        // escape the query string to avoid errors caused by special characters
        "url": "movie-suggestion?query=" + escape(query),
        "success": function(data) {
            // pass the data, query, and doneCallback function into the success handler
            handleLookupAjaxSuccess(data, query, doneCallback)
        },
        "error": function(errorData) {
            console.log("lookup ajax error")
            console.log(errorData)
        }
    })
}


/*
 * This function is used to handle the ajax success callback function.
 * It is called by our own code upon the success of the AJAX request
 *
 * data is the JSON data string you get from your Java Servlet
 *
 */
function handleLookupAjaxSuccess(data, query, doneCallback) {
    console.log("lookup ajax successful")

    // parse the string into JSON
    let jsonData = JSON.parse(data);
    console.log(jsonData)
    cacheResult(query, data);
    doneCallback( { suggestions: jsonData } );
}



function handleSelectSuggestion(suggestion) {
    let movieId = suggestion["data"]["movieID"]
    console.log("you select " + suggestion["value"] + " with ID " + suggestion["data"]["movieID"])
    window.location.replace("single-movie.html?id="+movieId)
}



$('#autocomplete').autocomplete({
    // documentation of the lookup function can be found under the "Custom lookup function" section
    lookup: function (query, doneCallback) {
        handleLookup(query, doneCallback)
    },
    onSelect: function(suggestion) {
        handleSelectSuggestion(suggestion)
    },
    // set delay time
    deferRequestBy: 300,
    minChars: 3
});



function handleNormalSearch(query) {
    console.log("doing normal search with query: " + query)
    let titleName = document.getElementById("autocomplete").value
    if(titleName) {
        window.location.replace("./movie-list.html?fulltext=true&title=" + titleName)
    }
}

// bind pressing enter key to a handler function
$('#autocomplete').keypress(function(event) {
    // keyCode 13 is the enter key
    if (event.keyCode == 13) {
        // pass the value of the input box to the handler function
        handleNormalSearch($('#autocomplete').val())
    }
})

let cache_size = 100;
let cache_name = "resultCache";
let session = window.sessionStorage;
let default_cache = "{\"key\":[]}";
function cacheResult(query, data){
    let cache = session.getItem(cache_name);
    if (cache == null){
        session.setItem(cache_name, default_cache);
    }
    let json = JSON.parse(cache);
    query = query.trim();

    // pop first if cache is full
    if (json['key'].length >= cache_size){
        let toPop = json['key'].shift();
        delete json[toPop];
    }
    json['key'].push(query);
    json[query] = data;
    session.setItem(cache_name, JSON.stringify(json));
}

function fetchCachedResult(query){
    let cache = session.getItem(cache_name);
    if (cache == null){
        session.setItem(cache_name, default_cache);
        return null
    }
    return JSON.parse(cache)[query.trim()];
}



