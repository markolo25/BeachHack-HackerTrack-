var Firebase = require("firebase");

function shout() {

    var ref = new Firebase("https://shining-fire-5186.firebaseio.com/");
    ref.orderByChild("time").on("child_added", function(snapshot) {
        snapshot.forEach(function(data) {

            console.log("You Spent " + snapshot.val().time + " Seconds on " + snapshot.val().name);
        });
    });
}

