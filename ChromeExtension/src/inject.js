chrome.tabs.onUpdated.addListener(function(tabId, changeInfo) {
    var params;
    var currTime;
    var currUrl;
    if (changeInfo.status == 'complete') {

        chrome.tabs.query({
            active: true,
            lastFocusedWindow: true
        }, function(tabs) {

            // Get the URL
            var tab = tabs[0];
            var currUrl = tab.url;
            
            //alert(currUrl);

            // Get start time
            var currTime = new Date();
            //alert(currTime);



            var url = "http://ec2-54-183-149-25.us-west-1.compute.amazonaws.com:3000/";
            params = currUrl.toString() + currTime.getDate;
            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function() {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                }
            });
            xhr.open("POST", "http://ec2-54-183-149-25.us-west-1.compute.amazonaws.com:3000/");
            xhr.setRequestHeader("cache-control", "no-cache");
            xhr.setRequestHeader("postman-token", "4b43a93f-142b-fe1f-2c90-88c032c39608");

            xhr.send(params);
        });

    }


});
