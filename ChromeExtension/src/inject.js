chrome.tabs.onUpdated.addListener(function(tabId, changeInfo) {
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



            var url = "ec2-54-183-149-25.us-west-1.compute.amazonaws.com:3000";
            var params = currUrl + " " + currTime;
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.open("POST", url, true);
            xmlhttp.send(params);
        });

    }
});
