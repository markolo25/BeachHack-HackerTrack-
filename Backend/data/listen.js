var app = require('http').createServer(handler);
var url = require('url');
var Firebase = require("firebase");
var statusCode = 200;

app.listen(3000);

function handler(req, res) {
    var data = '';


    console.log(req.url);
    console.log(url.parse(req.url, true));

    var queryObject = url.parse(req.url, true).query;

    if (req.method == "POST") {
        req.on('data', function(chunk) {
            data += chunk;
        });

        req.on('end', function() {
            console.log('mew:');
            var input = data.toString();
            var myFirebaseRef = new Firebase("https://shining-fire-5186.firebaseio.com/");
            myFirebaseRef.push({
                name: input,
                time: 45,
                fromJava: false,
            });
        });
    }

    console.log("Query strings: " + JSON.stringify(queryObject));

    res.writeHead(statusCode, { 'Content-Type': 'text/plain' });
    res.end();
}

console.log("Listening to port 3000");
console.log("Returning status code " + statusCode.toString());
